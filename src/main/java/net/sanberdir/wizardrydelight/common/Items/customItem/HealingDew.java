package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class HealingDew extends AnimateItem{
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("wizardry_delight.press_shift2").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("wizardry_delight.healing_dew").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.translatable("wizardry_delight.press_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
    }
    public HealingDew(Properties properties) {
        super(properties);
    }
}
