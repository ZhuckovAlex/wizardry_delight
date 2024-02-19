package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sanberdir.wizardrydelight.server.procedures.EatingCheese1;

public class Cheese extends Item {
    public Cheese(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        EatingCheese1.execute(entity);
        return retval;
    }

}
