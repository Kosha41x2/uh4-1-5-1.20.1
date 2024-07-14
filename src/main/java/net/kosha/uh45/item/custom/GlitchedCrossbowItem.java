package net.kosha.uh45.item.custom;


import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class GlitchedCrossbowItem extends CrossbowLikeItem {
    public GlitchedCrossbowItem(Settings settings){
        super(settings);
    }

    Random random = new Random();

    @Override
    public ItemStack projectileGetter(LivingEntity shooter, ItemStack crossbow) {
        ItemStack storeItemStack = shooter.getProjectileType(crossbow);
        if(storeItemStack.getItem().equals(Items.ARROW)){
            if(!((PlayerEntity)shooter).getAbilities().creativeMode){
                storeItemStack.decrement(1);
            }
            storeItemStack =new ItemStack(Items.TIPPED_ARROW, 1);
            switch (random.nextInt(0,4))
            {
                case 0:
                    PotionUtil.setPotion(storeItemStack, Potions.POISON);
                    break;
                case 1:
                    PotionUtil.setPotion(storeItemStack, Potions.SLOWNESS);
                    break;

                case 2:
                    PotionUtil.setPotion(storeItemStack, Potions.WEAKNESS);
                    break;

                case 3:
                    PotionUtil.setPotion(storeItemStack, Potions.HEALING);
                    break;

            }
        }
        return storeItemStack;
    }
}