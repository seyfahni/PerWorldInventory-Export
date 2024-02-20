package de.seyfahni.plugins.perworldinventoryfix;

import org.bukkit.GameMode;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.*;

/**
 * This class is used to represent a Player.
 * It contains all of the variables that can be saved, as well as a few things
 * for internal use.
 */
public final class PlayerProfile {

    private ItemStack[] armor;
    private ItemStack[] enderChest;
    private ItemStack[] inventory;
    private boolean allowFlight;
    private String displayName;
    private float exhaustion;
    private float experience;
    private boolean isFlying;
    private int foodLevel;
    private double maxHealth;
    private double health;
    private GameMode gameMode;
    private int level;
    private Float saturation;
    private Collection<PotionEffect> potionEffects;
    private float fallDistance;
    private int fireTicks;
    private int maximumAir;
    private int remainingAir;
    private double balance;

    public PlayerProfile(ItemStack[] armor,
                         ItemStack[] enderChest,
                         ItemStack[] inventory,
                         boolean allowFlight,
                         String displayName,
                         float exhaustion,
                         float experience,
                         boolean isFlying,
                         int foodLevel,
                         double maxHealth,
                         double health,
                         GameMode gameMode,
                         int level,
                         Float saturation,
                         Collection<PotionEffect> potionEffects,
                         float fallDistance,
                         int fireTicks,
                         int maximumAir,
                         int remainingAir) {
        this.armor = armor;
        this.enderChest = enderChest;
        this.inventory = inventory;
        this.allowFlight = allowFlight;
        this.displayName = displayName;
        this.exhaustion = exhaustion;
        this.experience = experience;
        this.isFlying = isFlying;
        this.foodLevel = foodLevel;
        this.maxHealth = maxHealth;
        this.health = health;
        this.gameMode = gameMode;
        this.level = level;
        this.saturation = saturation;
        this.potionEffects = potionEffects;
        this.fallDistance = fallDistance;
        this.fireTicks = fireTicks;
        this.maximumAir = maximumAir;
        this.remainingAir = remainingAir;
    }

    public ItemStack[] getArmor() {
        return armor;
    }

    public void setArmor(ItemStack[] armor) {
        this.armor = armor;
    }

    public ItemStack[] getEnderChest() {
        return enderChest;
    }

    public void setEnderChest(ItemStack[] enderChest) {
        this.enderChest = enderChest;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public boolean isAllowFlight() {
        return allowFlight;
    }

    public void setAllowFlight(boolean allowFlight) {
        this.allowFlight = allowFlight;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public float getExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(float exhaustion) {
        this.exhaustion = exhaustion;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Float getSaturation() {
        return saturation;
    }

    public void setSaturation(Float saturation) {
        this.saturation = saturation;
    }

    public Collection<PotionEffect> getPotionEffects() {
        return potionEffects;
    }

    public void setPotionEffects(Collection<PotionEffect> potionEffects) {
        this.potionEffects = potionEffects;
    }

    public float getFallDistance() {
        return fallDistance;
    }

    public void setFallDistance(float fallDistance) {
        this.fallDistance = fallDistance;
    }

    public int getFireTicks() {
        return fireTicks;
    }

    public void setFireTicks(int fireTicks) {
        this.fireTicks = fireTicks;
    }

    public int getMaximumAir() {
        return maximumAir;
    }

    public void setMaximumAir(int maximumAir) {
        this.maximumAir = maximumAir;
    }

    public int getRemainingAir() {
        return remainingAir;
    }

    public void setRemainingAir(int remainingAir) {
        this.remainingAir = remainingAir;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerProfile that = (PlayerProfile) o;
        return isAllowFlight() == that.isAllowFlight() &&
                Float.compare(that.getExhaustion(), getExhaustion()) == 0 &&
                Float.compare(that.getExperience(), getExperience()) == 0 &&
                isFlying() == that.isFlying() &&
                getFoodLevel() == that.getFoodLevel() &&
                Double.compare(that.getMaxHealth(), getMaxHealth()) == 0 &&
                Double.compare(that.getHealth(), getHealth()) == 0 &&
                getLevel() == that.getLevel() &&
                Float.compare(that.getFallDistance(), getFallDistance()) == 0 &&
                getFireTicks() == that.getFireTicks() &&
                getMaximumAir() == that.getMaximumAir() &&
                getRemainingAir() == that.getRemainingAir() &&
                Double.compare(that.getBalance(), getBalance()) == 0 &&
                Arrays.equals(getArmor(), that.getArmor()) &&
                Arrays.equals(getEnderChest(), that.getEnderChest()) &&
                Arrays.equals(getInventory(), that.getInventory()) &&
                Objects.equals(getDisplayName(), that.getDisplayName()) &&
                getGameMode() == that.getGameMode() &&
                Objects.equals(getSaturation(), that.getSaturation()) &&
                Objects.equals(getPotionEffects(), that.getPotionEffects());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isAllowFlight(), getDisplayName(), getExhaustion(), getExperience(), isFlying(), getFoodLevel(), getMaxHealth(), getHealth(), getGameMode(), getLevel(), getSaturation(), getPotionEffects(), getFallDistance(), getFireTicks(), getMaximumAir(), getRemainingAir(), getBalance());
        result = 31 * result + Arrays.hashCode(getArmor());
        result = 31 * result + Arrays.hashCode(getEnderChest());
        result = 31 * result + Arrays.hashCode(getInventory());
        return result;
    }

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "armor=" + Arrays.toString(armor) +
                ", enderChest=" + Arrays.toString(enderChest) +
                ", inventory=" + Arrays.toString(inventory) +
                ", allowFlight=" + allowFlight +
                ", displayName='" + displayName + '\'' +
                ", exhaustion=" + exhaustion +
                ", experience=" + experience +
                ", isFlying=" + isFlying +
                ", foodLevel=" + foodLevel +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", gameMode=" + gameMode +
                ", level=" + level +
                ", saturation=" + saturation +
                ", potionEffects=" + potionEffects +
                ", fallDistance=" + fallDistance +
                ", fireTicks=" + fireTicks +
                ", maximumAir=" + maximumAir +
                ", remainingAir=" + remainingAir +
                ", balance=" + balance +
                '}';
    }
}
