package de.seyfahni.plugins.perworldinventoryfix;

import net.minidev.json.JSONObject;
import org.bukkit.GameMode;

public final class StatSerializer
{

    private StatSerializer() {}

    /**
     * Validate data by making sure that all stats are present.
     * If something is missing, add it to the object with sane
     * defaults, in most cases using the [PlayerDefaults] object.
     *
     * @param data The data to validate
     * @param playerName The name of the player. Necessary in case
     * display name is not stored in the data
     * @return The data with all stats present
     */
        public static JSONObject validateStats(JSONObject data, String playerName) {
        if (!data.containsKey("can-fly")) data.put("can-fly", false);
        if (!data.containsKey("display-name")) data.put("display-name", playerName);
        if (!data.containsKey("exhaustion")) data.put("exhaustion", PlayerDefaults.EXHAUSTION);
        if (!data.containsKey("exp")) data.put("exp", PlayerDefaults.EXPERIENCE);
        if (!data.containsKey("flying")) data.put("flying", false);
        if (!data.containsKey("food")) data.put("food", PlayerDefaults.FOOD_LEVEL);
        if (!data.containsKey("gamemode")) data.put("gamemode", GameMode.SURVIVAL.toString());
        if (!data.containsKey("max-health")) data.put("max-health", PlayerDefaults.HEALTH);
        if (!data.containsKey("health")) data.put("health", PlayerDefaults.HEALTH);
        if (!data.containsKey("level")) data.put("level", PlayerDefaults.LEVEL);
        if (!data.containsKey("saturation")) data.put("saturation", PlayerDefaults.SATURATION);
        if (!data.containsKey("fallDistance")) data.put("fallDistance", PlayerDefaults.FALL_DISTANCE);
        if (!data.containsKey("fireTicks")) data.put("fireTicks", PlayerDefaults.FIRE_TICKS);
        if (!data.containsKey("maxAir")) data.put("maxAir", PlayerDefaults.MAXIMUM_AIR);
        if (!data.containsKey("remainingAir")) data.put("remainingAir", PlayerDefaults.REMAINING_AIR);

        return data;
    }
}
