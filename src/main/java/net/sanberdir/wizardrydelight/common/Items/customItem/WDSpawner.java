package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class WDSpawner extends ItemNameBlockItem {
    public WDSpawner(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("wizardry_delight.press_shift2").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("wizardry_delight.wd_spawner1").withStyle(ChatFormatting.DARK_PURPLE));
            components.add(Component.translatable("wizardry_delight.wd_spawner2").withStyle(ChatFormatting.DARK_PURPLE));
            components.add(Component.translatable("wizardry_delight.wd_spawner3").withStyle(ChatFormatting.DARK_PURPLE));
            components.add(Component.translatable("wizardry_delight.wd_spawner4").withStyle(ChatFormatting.DARK_PURPLE));
            components.add(Component.translatable("wizardry_delight.wd_spawner5").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.translatable("wizardry_delight.press_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
    }
}
