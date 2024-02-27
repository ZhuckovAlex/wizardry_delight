package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.sanberdir.wizardrydelight.server.procedures.SoulStoneCharged;

public class SoulStoneDeactive extends Item {
    public SoulStoneDeactive(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        SoulStoneCharged.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
        return InteractionResult.SUCCESS;
    }

}
