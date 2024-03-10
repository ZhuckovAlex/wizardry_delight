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
import net.sanberdir.wizardrydelight.server.procedures.ProcedureSoulStone;

import javax.annotation.Nullable;
import java.util.List;

public class SoulStoneActive extends Item {
    public SoulStoneActive(Properties p_41383_) {
        super(p_41383_);
    }

    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        if(Screen.hasShiftDown()) {
            list.add(Component.translatable("wizardry_delight.press_shift2").withStyle(ChatFormatting.DARK_GRAY));
            list.add(Component.translatable("wizardry_delight.soul_stone_active").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            list.add(Component.translatable("wizardry_delight.press_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
        list.add(Component.translatable("wizardry_delight.tag_entity_soul"));
        list.add(Component.literal("§d" + itemstack.getOrCreateTag().getString("name_entity")));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);

        ProcedureSoulStone.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
        return InteractionResult.SUCCESS;
    }





}
