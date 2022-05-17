package mrthomas20121.biolib.item.tool;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class BioTier implements Tier {

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;

    private BioTier(int level, int durability, float speed, float damage, int enchantValue, Supplier<Ingredient> item) {
        this.level = level;
        this.uses = durability;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantValue;
        this.repairIngredient = Lazy.of(item);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
