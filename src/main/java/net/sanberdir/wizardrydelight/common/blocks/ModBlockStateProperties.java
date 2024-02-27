package net.sanberdir.wizardrydelight.common.blocks;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties extends BlockStateProperties {
    public static final IntegerProperty POLLEN_PR = IntegerProperty.create("pollen_charges", 0, 5);
    public static final IntegerProperty SOUL_STONES = IntegerProperty.create("soul_stone_charges", 0, 2);
}
