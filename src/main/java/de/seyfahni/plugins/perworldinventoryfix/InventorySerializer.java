package de.seyfahni.plugins.perworldinventoryfix;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.logging.Level;

public final class InventorySerializer {

    private InventorySerializer() {}

    /**
     * Gets an ItemStack array from serialized inventory contents.
     *
     * @param array The array of items to deserialize
     * @param size The expected size of the inventory; can be greater than expected
     * @param format The data format being used
     * @return An array of ItemStacks
     */
    public static ItemStack[] deserialize(JSONArray array, int size, int format) {
        ItemStack[] contents = new ItemStack[size];
        Arrays.fill(contents, new ItemStack(Material.AIR));

        for (int i = 0; i < array.size(); i++) {
            // We don't want to risk failing to deserialize a players inventory.
            // Try your best to deserialize as much as possible.
            try {
                JSONObject obj = (JSONObject) array.get(i);
                int index = (int) obj.get("index");
                ItemStack item = ItemSerializer.deserialize(obj, format);

                contents[index] = item;
            } catch (Exception ex) {
                Bukkit.getPluginManager().getPlugin("PerWorldInventoryFix").getLogger()
                        .log(Level.WARNING, "Failed to deserialize item in inventory:", ex);
            }
        }

        return contents;
    }
}
