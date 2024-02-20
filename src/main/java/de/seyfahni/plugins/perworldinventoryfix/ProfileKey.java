package de.seyfahni.plugins.perworldinventoryfix;

import org.bukkit.GameMode;
import java.util.*;

public class ProfileKey {

    private UUID uuid;
    private String group;
    private GameMode gameMode;

    public ProfileKey(UUID uuid) {
        this(uuid, null);
    }

    public ProfileKey(UUID uuid, String group) {
        this(uuid, group, null);
    }

    public ProfileKey(UUID uuid, String group, GameMode gameMode) {
        this.uuid = Objects.requireNonNull(uuid);
        this.group = group;
        this.gameMode = gameMode;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileKey that = (ProfileKey) o;
        return uuid.equals(that.uuid) &&
                Objects.equals(group, that.group) &&
                gameMode == that.gameMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, group, gameMode);
    }

    @Override
    public String toString() {
        return "ProfileKey{" +
                "uuid=" + uuid +
                ", group='" + group + '\'' +
                ", gameMode=" + gameMode +
                '}';
    }
}