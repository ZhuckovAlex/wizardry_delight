package net.sanberdir.wizardrydelight.client;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;

public class ModCreativeTab {
    public static final CreativeModeTab BUSHES = new CreativeModeTab("wizardry_delight") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(InitItemsWD.CHARMING_BERRIES.get());
        }
    };
}
