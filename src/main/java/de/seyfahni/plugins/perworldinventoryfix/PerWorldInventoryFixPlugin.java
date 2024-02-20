package de.seyfahni.plugins.perworldinventoryfix;

import java.io.*;
import java.util.logging.Level;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PerWorldInventoryFixPlugin extends JavaPlugin implements Listener {

    private File perWorldInventoryDataFolder;
    private String group;
    private GameMode gamemode;
    private String suffix;

    private RestoreSelector restore;

    @Override
    public void onEnable() {
        perWorldInventoryDataFolder = new File (new File(getDataFolder().getParent(), "PerWorldInventory"), "data");
        saveDefaultConfig();
        reloadConfig();
        loadSelection(getConfig().getConfigurationSection("selection"));
        loadRestore(getConfig().getConfigurationSection("restore"));
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void loadSelection(ConfigurationSection selectorConfig) {
        group = selectorConfig.getString("group");
        gamemode = GameMode.valueOf(selectorConfig.getString("gamemode"));
        switch (gamemode) {
            case ADVENTURE:
                suffix = "_adventure.json";
                break;
            case CREATIVE:
                suffix = "_creative.json";
                break;
            case SPECTATOR:
                suffix = "_spectator.json";
                break;
            case SURVIVAL:
            default:
                suffix = ".json";
                break;
        }
    }

    private void loadRestore(ConfigurationSection restoreConfig) {
        ConfigurationSection statsConfig = restoreConfig.getConfigurationSection("stats");
        restore = new RestoreSelector(
                restoreConfig.getBoolean("ender-chest"),
                restoreConfig.getBoolean("inventory"),
                statsConfig.getBoolean("can-fly"),
                statsConfig.getBoolean("display-name"),
                statsConfig.getBoolean("exhaustion"),
                statsConfig.getBoolean("exp"),
                statsConfig.getBoolean("food"),
                statsConfig.getBoolean("flying"),
                statsConfig.getBoolean("gamemode"),
                statsConfig.getBoolean("max-health"),
                statsConfig.getBoolean("health"),
                statsConfig.getBoolean("level"),
                statsConfig.getBoolean("potion-effects"),
                statsConfig.getBoolean("saturation"),
                statsConfig.getBoolean("fall-distance"),
                statsConfig.getBoolean("fire-ticks"),
                statsConfig.getBoolean("max-air"),
                statsConfig.getBoolean("remaining-air"));
    }

    @Override
    public void onDisable() {
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent joinEvent) {
        final Player player = joinEvent.getPlayer();
        final ProfileKey key = new ProfileKey(player.getUniqueId(), group, gamemode);
        final String playerName = player.getName();
        final int inventorySize = player.getInventory().getSize();
        final int enderChestSize = player.getEnderChest().getSize();
        getServer().getScheduler().runTaskAsynchronously(this, () -> loadPlayerInventoryData(key, player, playerName, inventorySize, enderChestSize));
    }

    private void loadPlayerInventoryData(ProfileKey key, Player player, String displayName, int inventorySize, int enderChestSize) {
        final File file = getPerWorldInventoryData(key);

        // If the file does not exist, the player hasn't been to this group before or was already applied
        if (!file.exists()) {
            return;
        }
        getLogger().log(Level.INFO, "Restoring player data: {0}", displayName);

        try (FileReader reader = new FileReader(file)) {
            JSONParser parser = new JSONParser(JSONParser.USE_INTEGER_STORAGE);
            JSONObject data = (JSONObject) parser.parse(reader);

            PlayerProfile profile = PlayerSerializer.deserialize(data, displayName, inventorySize, enderChestSize);
            getServer().getScheduler().runTask(this, () -> applyPlayerInventoryData(profile, player, file));
        } catch (ParseException | IOException e) {
            getLogger().log(Level.SEVERE, null, e);
        }
    }

    private void applyPlayerInventoryData(PlayerProfile profile, Player player, File file) {
        if (restore.isEnderChest()) {
            player.getEnderChest().setContents(profile.getEnderChest());
        }
        if (restore.isInventory()) {
            player.getInventory().setContents(profile.getInventory());
        }
        if (restore.isCanFly()) {
            player.setAllowFlight(profile.isAllowFlight());
        }
        if (restore.isDisplayName()) {
            player.setDisplayName(profile.getDisplayName());
        }
        if (restore.isExhaustion()) {
            player.setExhaustion(profile.getExhaustion());
        }
        if (restore.isExp()) {
            player.setExp(profile.getExperience());
        }
        if (restore.isFood()) {
            player.setFoodLevel(profile.getFoodLevel());
        }
        if (restore.isFlying()) {
            player.setFlying(profile.isFlying());
        }
        if (restore.isGamemode()) {
            player.setGameMode(profile.getGameMode());
        }
        if (restore.isMaxHealth()) {
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(profile.getMaxHealth());
        }
        if (restore.isHealth()) {
            player.setHealth(profile.getHealth());
        }
        if (restore.isLevel()) {
            player.setLevel(profile.getLevel());
        }
        if (restore.isPotionEffects()) {
            player.addPotionEffects(profile.getPotionEffects());
        }
        if (restore.isSaturation()) {
            player.setSaturation(profile.getSaturation());
        }
        if (restore.isFallDistance()) {
            player.setFallDistance(profile.getFallDistance());
        }
        if (restore.isFireTicks()) {
            player.setFireTicks(profile.getFireTicks());
        }
        if (restore.isMaxAir()) {
            player.setMaximumAir(profile.getMaximumAir());
        }
        if (restore.isRemainingAir()) {
            player.setRemainingAir(profile.getRemainingAir());
        }
        getServer().getScheduler().runTaskAsynchronously(this, () -> file.renameTo(new File(file.getPath() + ".old")));
    }


    /**
     * Get the data file for a player.
     *
     * @param key The [ProfileKey] to get the right file
     * @return The data file to read from or write to
     */
    private File getPerWorldInventoryData(ProfileKey key) {
        File dir = new File(perWorldInventoryDataFolder, key.getUuid().toString());
        return new File(dir, key.getGroup() + suffix);
    }
}
