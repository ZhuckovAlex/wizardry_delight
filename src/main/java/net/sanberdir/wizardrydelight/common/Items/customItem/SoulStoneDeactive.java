package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.sanberdir.wizardrydelight.server.procedures.SoulStoneCharged;

import javax.annotation.Nullable;
import java.util.List;

public class SoulStoneDeactive extends Item {
    public SoulStoneDeactive(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("wizardry_delight.press_shift2").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("wizardry_delight.soul_stone_deactive").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.translatable("wizardry_delight.press_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        SoulStoneCharged.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
        return InteractionResult.SUCCESS;
    }

}
