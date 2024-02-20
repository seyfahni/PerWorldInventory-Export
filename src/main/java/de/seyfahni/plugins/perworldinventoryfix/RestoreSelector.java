package de.seyfahni.plugins.perworldinventoryfix;

import java.util.Objects;

public final class RestoreSelector {

    private boolean enderChest;
    private boolean inventory;
    private boolean canFly;
    private boolean displayName;
    private boolean exhaustion;
    private boolean exp;
    private boolean food;
    private boolean flying;
    private boolean gamemode;
    private boolean maxHealth;
    private boolean health;
    private boolean level;
    private boolean potionEffects;
    private boolean saturation;
    private boolean fallDistance;
    private boolean fireTicks;
    private boolean maxAir;
    private boolean remainingAir;

    public RestoreSelector(boolean enderChest,
                           boolean inventory,
                           boolean canFly,
                           boolean displayName,
                           boolean exhaustion,
                           boolean exp,
                           boolean food,
                           boolean flying,
                           boolean gamemode,
                           boolean maxHealth,
                           boolean health,
                           boolean level,
                           boolean potionEffects,
                           boolean saturation,
                           boolean fallDistance,
                           boolean fireTicks,
                           boolean maxAir,
                           boolean remainingAir) {
        this.enderChest = enderChest;
        this.inventory = inventory;
        this.canFly = canFly;
        this.displayName = displayName;
        this.exhaustion = exhaustion;
        this.exp = exp;
        this.food = food;
        this.flying = flying;
        this.gamemode = gamemode;
        this.maxHealth = maxHealth;
        this.health = health;
        this.level = level;
        this.potionEffects = potionEffects;
        this.saturation = saturation;
        this.fallDistance = fallDistance;
        this.fireTicks = fireTicks;
        this.maxAir = maxAir;
        this.remainingAir = remainingAir;
    }

    public boolean isEnderChest() {
        return enderChest;
    }

    public void setEnderChest(boolean enderChest) {
        this.enderChest = enderChest;
    }

    public boolean isInventory() {
        return inventory;
    }

    public void setInventory(boolean inventory) {
        this.inventory = inventory;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isDisplayName() {
        return displayName;
    }

    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    public boolean isExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(boolean exhaustion) {
        this.exhaustion = exhaustion;
    }

    public boolean isExp() {
        return exp;
    }

    public void setExp(boolean exp) {
        this.exp = exp;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean isGamemode() {
        return gamemode;
    }

    public void setGamemode(boolean gamemode) {
        this.gamemode = gamemode;
    }

    public boolean isMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(boolean maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public boolean isLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    public boolean isPotionEffects() {
        return potionEffects;
    }

    public void setPotionEffects(boolean potionEffects) {
        this.potionEffects = potionEffects;
    }

    public boolean isSaturation() {
        return saturation;
    }

    public void setSaturation(boolean saturation) {
        this.saturation = saturation;
    }

    public boolean isFallDistance() {
        return fallDistance;
    }

    public void setFallDistance(boolean fallDistance) {
        this.fallDistance = fallDistance;
    }

    public boolean isFireTicks() {
        return fireTicks;
    }

    public void setFireTicks(boolean fireTicks) {
        this.fireTicks = fireTicks;
    }

    public boolean isMaxAir() {
        return maxAir;
    }

    public void setMaxAir(boolean maxAir) {
        this.maxAir = maxAir;
    }

    public boolean isRemainingAir() {
        return remainingAir;
    }

    public void setRemainingAir(boolean remainingAir) {
        this.remainingAir = remainingAir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestoreSelector that = (RestoreSelector) o;
        return isEnderChest() == that.isEnderChest() &&
                isInventory() == that.isInventory() &&
                isCanFly() == that.isCanFly() &&
                isDisplayName() == that.isDisplayName() &&
                isExhaustion() == that.isExhaustion() &&
                isExp() == that.isExp() &&
                isFood() == that.isFood() &&
                isFlying() == that.isFlying() &&
                isGamemode() == that.isGamemode() &&
                isMaxHealth() == that.isMaxHealth() &&
                isHealth() == that.isHealth() &&
                isLevel() == that.isLevel() &&
                isPotionEffects() == that.isPotionEffects() &&
                isSaturation() == that.isSaturation() &&
                isFallDistance() == that.isFallDistance() &&
                isFireTicks() == that.isFireTicks() &&
                isMaxAir() == that.isMaxAir() &&
                isRemainingAir() == that.isRemainingAir();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEnderChest(), isInventory(), isCanFly(), isDisplayName(), isExhaustion(), isExp(), isFood(), isFlying(), isGamemode(), isMaxHealth(), isHealth(), isLevel(), isPotionEffects(), isSaturation(), isFallDistance(), isFireTicks(), isMaxAir(), isRemainingAir());
    }

    @Override
    public String toString() {
        return "RestoreSelector{" +
                "enderChest=" + enderChest +
                ", inventory=" + inventory +
                ", canFly=" + canFly +
                ", displayName=" + displayName +
                ", exhaustion=" + exhaustion +
                ", exp=" + exp +
                ", food=" + food +
                ", flying=" + flying +
                ", gamemode=" + gamemode +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", level=" + level +
                ", potionEffects=" + potionEffects +
                ", saturation=" + saturation +
                ", fallDistance=" + fallDistance +
                ", fireTicks=" + fireTicks +
                ", maxAir=" + maxAir +
                ", remainingAir=" + remainingAir +
                '}';
    }
}
