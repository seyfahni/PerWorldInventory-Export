package de.seyfahni.plugins.perworldinventoryfix;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.bukkit.GameMode;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;
import java.util.Collections;

public final class PlayerSerializer {

    private PlayerSerializer() {
    }

    public static PlayerProfile deserialize(JSONObject data, String playerName, int inventorySize, int eChestSize) {
        // Get the data format being used
        int format = 3;
        if (data.containsKey("data-format")) {
            format = (int) data.get("data-format");
        }

        JSONObject inventory = (JSONObject) data.get("inventory");
        ItemStack[] items = InventorySerializer.deserialize((JSONArray) inventory.get("inventory"), inventorySize, format);
        ItemStack[] armor = InventorySerializer.deserialize((JSONArray) inventory.get("armor"), 4, format);
        ItemStack[] enderChest = InventorySerializer.deserialize((JSONArray) data.get("ender-chest"), eChestSize, format);
        JSONObject stats = StatSerializer.validateStats((JSONObject) data.get("stats"), playerName);
        Object potionEffectsObject = stats.get("potion-effects");
        Collection<PotionEffect> potionEffects = potionEffectsObject instanceof JSONArray ? PotionSerializer.deserialize((JSONArray) potionEffectsObject) : Collections.emptySet();

        return new PlayerProfile(armor,
                enderChest,
                items,
                (boolean) stats.get("can-fly"),
                (String) stats.get("display-name"),
                ((Number) stats.get("exhaustion")).floatValue(),
                ((Number) stats.get("exp")).floatValue(),
                (boolean) stats.get("flying"),
                ((Number) stats.get("food")).intValue(),
                ((Number) stats.get("max-health")).doubleValue(),
                ((Number) stats.get("health")).doubleValue(),
                GameMode.valueOf((String) stats.get("gamemode")),
                ((Number) stats.get("level")).intValue(),
                ((Number) stats.get("saturation")).floatValue(),
                potionEffects,
                ((Number) stats.get("fallDistance")).floatValue(),
                ((Number) stats.get("fireTicks")).intValue(),
                ((Number) stats.get("maxAir")).intValue(),
                ((Number) stats.get("remainingAir")).intValue());
    }
}
