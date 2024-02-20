package de.seyfahni.plugins.perworldinventoryfix;

import net.minidev.json.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public final class LocationSerializer {

    private LocationSerializer() {}

    /**
     * Deserialize a [Location] from a JsonObject.
     *
     * @param obj The JsonObject to deserialize
     * @return A new location from the properties of the JsonObject
     */
    public static Location deserialize(JSONObject obj) {
        World world = Bukkit.getWorld((String) obj.get("world"));
        double x = (double) obj.get("x");
        double y = (double) obj.get("y");
        double z = (double) obj.get("z");
        float pitch = (float) obj.get("pitch");
        float yaw = (float) obj.get("yaw");

        return new Location(world, x, y, z, yaw, pitch);
    }
}
