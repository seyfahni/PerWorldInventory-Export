package de.seyfahni.plugins.perworldinventoryfix;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PotionSerializer {

    private PotionSerializer() {}

    /**
     * Return a Collection of PotionEffects from a given JsonArray.
     *
     * @param array The serialized PotionEffects
     * @return The PotionEffects
     */
    public static Collection<PotionEffect> deserialize(JSONArray array) {
        List<PotionEffect> effects = new ArrayList<>();

        for (int i = 0 ; i < array.size() ; i++) {
            JSONObject obj = (JSONObject) array.get(i);

            PotionEffectType type = PotionEffectType.getByName((String) obj.get("type"));
            int amplifier = (int) obj.get("amp");
            int duration = (int) obj.get("duration");
            boolean ambient = (boolean) obj.get("ambient");
            boolean particles = (boolean) obj.get("particles");

            PotionEffect effect = new PotionEffect(type, duration, amplifier, ambient, particles);
            effects.add(effect);
        }

        return effects;
    }
}
