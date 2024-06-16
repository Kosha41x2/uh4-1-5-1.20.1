package net.kosha.uh45.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    GLITCHTENITE(MiningLevels.IRON, 1500, 7f, 2.5f, 25,
            () -> Ingredient.ofItems(ModItems.GLITCHTENITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repainIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackSamage, int enchantability, Supplier<Ingredient> repainIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackSamage;
        this.enchantability = enchantability;
        this.repainIngredient = repainIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repainIngredient.get();
    }
}
