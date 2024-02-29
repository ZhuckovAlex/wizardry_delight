package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.sanberdir.wizardrydelight.common.sounds.CustomSoundEvents;

public class Cheese2 extends Item {
    public Cheese2(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return CustomSoundEvents.NYAMNYAM.get();
    }
    @Override
    public SoundEvent getEatingSound() {
        return CustomSoundEvents.NYAMNYAM_END.get();
    }

}
