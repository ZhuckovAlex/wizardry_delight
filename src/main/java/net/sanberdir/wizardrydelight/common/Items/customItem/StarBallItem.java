package net.sanberdir.wizardrydelight.common.Items.customItem;


import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.sanberdir.wizardrydelight.server.procedures.StrikeRobinStick;

import javax.annotation.Nullable;
import java.util.List;


public class StarBallItem extends Item {

    public StarBallItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("wizardry_delight.press_shift2").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("wizardry_delight.robin_stick").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.translatable("wizardry_delight.press_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
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