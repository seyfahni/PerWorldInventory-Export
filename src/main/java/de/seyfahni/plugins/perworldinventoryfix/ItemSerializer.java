package de.seyfahni.plugins.perworldinventoryfix;

import com.dumptruckman.bukkit.configuration.util.SerializationHelper;
import net.minidev.json.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;

public final class ItemSerializer {

    private static final String AIR = "AIR";

    private ItemSerializer() {}

    /**
     * Get an ItemStack from a JsonObject.
     *
     * @param obj The Json to read
     * @param format The data format being used.
     * @return The deserialized item stack
     */
    @SuppressWarnings("UNCHECKED_CAST") // Reading a map we created; it's safe to assume the Map types
    public static ItemStack deserialize(JSONObject obj, int format) {
        switch (format)
        {
            case 0:
                throw new IllegalArgumentException("Old data format is not supported!");
            case 1:
            case 2:
                return decodeItem((String) obj.get("item"));
            case 3:
                return obj.get("item") instanceof Map ? (ItemStack) SerializationHelper.deserialize((Map) obj.get("item")) : new ItemStack(Material.AIR);
            default:
                throw new IllegalArgumentException("Unknown data format '$format'.");
        }
    }

    private static ItemStack decodeItem(String encoded) {
        if (encoded == AIR) {
            return new ItemStack(Material.AIR);
        }
        try (InputStream is = new ByteArrayInputStream(Base64Coder.decodeLines(encoded));
             BukkitObjectInputStream bukkitObjectStream = new BukkitObjectInputStream(is)) {
            return (ItemStack) bukkitObjectStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Bukkit.getPluginManager().getPlugin("PerWorldInventoryFix").getLogger().log(Level.SEVERE, "Unable to deserialize an item:", ex);
            return new ItemStack(Material.AIR);
        }
    }
}
