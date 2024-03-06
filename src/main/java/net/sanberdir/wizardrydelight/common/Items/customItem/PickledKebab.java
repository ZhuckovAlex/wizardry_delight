package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PickledKebab extends Item {
    public PickledKebab(Properties p_41383_) {
        super(p_41383_);
    }


    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);

        list.add(Component.translatable("wizardry_delight.result_kebab"));
    }

}
