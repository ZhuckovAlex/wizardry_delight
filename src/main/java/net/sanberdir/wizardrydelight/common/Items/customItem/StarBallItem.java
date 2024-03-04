package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sanberdir.wizardrydelight.server.procedures.StrikeRobinStick;

public class StarBallItem extends Item {

    public StarBallItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        entity.startUsingItem(hand);

        // Вызов процедуры с необходимыми параметрами
        StrikeRobinStick.execute(entity, world, entity.getX(), entity.getY(), entity.getZ());

        // Кулдаун
        entity.getCooldowns().addCooldown(this, 40);
        return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
    }
}