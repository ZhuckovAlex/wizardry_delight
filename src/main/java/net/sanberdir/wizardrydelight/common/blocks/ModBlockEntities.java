package net.sanberdir.wizardrydelight.common.blocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.WDSpawnerEntity;
import net.sanberdir.wizardrydelight.common.entity.sign.ModEntitiesBlock;
import net.sanberdir.wizardrydelight.common.entity.sign.ModSignBlockEntity;

public class ModBlockEntities {
    public static BlockEntityType<ModSignBlockEntity> SIGN_ENTITY_TYPE = BlockEntityType.Builder.of(ModSignBlockEntity::new, ModEntitiesBlock.APPLE_SIGN, ModEntitiesBlock.APPLE_WALL_SIGN).build(null);

    public static BlockEntityType<WDSpawnerEntity> SPAWNER_MOD_TYPE = BlockEntityType.Builder.of(WDSpawnerEntity::new, InitBlocksWD.WD_SPAWNER.get()).build(null);

}
