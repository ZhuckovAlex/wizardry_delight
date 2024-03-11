package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.ArrayList;
import java.util.Iterator;

public class MinusEffectBeneficial extends Item {
    public MinusEffectBeneficial(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entityLiving) {
        if (entityLiving instanceof Player) {
            Player player = (Player) entityLiving;

            // Проходим по активным эффектам игрока
            for (MobEffectInstance effectInstance : player.getActiveEffects()) {
                // Проверяем, является ли эффект отрицательным
                if (!effectInstance.getEffect().isBeneficial()) {
                    // Удаляем только один отрицательный эффект и выходим из цикла
                    player.removeEffect(effectInstance.getEffect());
                    break;
                }
            }
        }

        return super.finishUsingItem(stack, world, entityLiving);
    }
}
