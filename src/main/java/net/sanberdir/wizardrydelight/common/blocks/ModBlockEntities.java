package net.sanberdir.wizardrydelight.common.blocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.WDSpawnerEntity;

public class ModBlockEntities {
    public static BlockEntityType<WDSpawnerEntity> SPAWNER_MOD_TYPE = BlockEntityType.Builder.of(WDSpawnerEntity::new, InitBlocksWD.WD_SPAWNER.get()).build(null);

}
