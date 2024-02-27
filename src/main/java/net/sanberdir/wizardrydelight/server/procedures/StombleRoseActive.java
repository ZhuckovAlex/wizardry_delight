package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber

public class StombleRoseActive {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(),event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        double fromZ = 0;
        double fromX = 0;
        double fromY = 0;
        if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty())) {

            if ((world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ()))) == InitBlocksWD.ROSE_OF_THE_MURDERER.get().defaultBlockState()) {
                {
                    world.setBlock(new BlockPos(x, y, z), InitBlocksWD.ROSE_OF_THE_MURDERER2.get().defaultBlockState(), 3);
                    if (!world.isClientSide()) {
                        BlockPos _bp = new BlockPos(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putString("entity", (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()));
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bp = new BlockPos(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null)
                            _blockEntity.getPersistentData().putString("name_entity", (entity.getDisplayName().getString()));
                        if (world instanceof Level _level)
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }

                }
            }
        }
    }
}