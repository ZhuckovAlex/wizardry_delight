package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class GoldenRuno extends Item implements ICurioItem {
    public GoldenRuno(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity entity, ItemStack stack) {

        // Новые условия
        if (entity.getHealth() <= 6 && !entity.hasEffect(MobEffects.MOVEMENT_SPEED)) {
            // Если здоровье игрока меньше или равно 6 хп и у него нет эффекта скорости
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, 1, false, false));
        } else if (entity.getHealth() > 6 && entity.hasEffect(MobEffects.MOVEMENT_SPEED)) {
            // Если здоровье игрока больше 6 хп и у него есть эффект скорости, убираем его
            entity.removeEffect(MobEffects.MOVEMENT_SPEED);
        }

        boolean isInDanger = entity.isInLava()
                || entity.isOnFire()
                || entity.isOnGround() && entity.level.getBlockState(entity.blockPosition().below()).getBlock() == Blocks.MAGMA_BLOCK
                || entity.isOnGround() && entity.level.getBlockState(entity.blockPosition().below()).getBlock() == Blocks.FIRE;

        // Apply fire resistance effect if the entity is in danger and not already affected
        if (isInDanger && !entity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));
        } else if (!isInDanger && entity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
            // Remove fire resistance effect if the entity is not in danger
            entity.removeEffect(MobEffects.FIRE_RESISTANCE);
        }
    }
}