package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RingSupply extends Item implements ICurioItem {
    public RingSupply(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity entity, ItemStack stack) {
        if ((stack).getDamageValue() < 69 && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
            if (!entity.level.isClientSide())
                entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 0, false, false));
            {
                ItemStack _ist = stack;
                if (_ist.hurt(1, RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
        }
    }
}