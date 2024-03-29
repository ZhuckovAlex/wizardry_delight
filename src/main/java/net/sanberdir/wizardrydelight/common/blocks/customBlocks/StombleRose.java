package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class StombleRose extends Block implements net.minecraftforge.common.IPlantable {

    public StombleRose(Properties blockProperties) {
        super(blockProperties);
    }



    @Override
    public void onRemove(BlockState state, net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (state.is(this)) {
                if (!world.isClientSide()) {
                    if (!world.getBlockState(pos.below()).is(Blocks.SOUL_SOIL)) {
                        world.destroyBlock(pos, true);
                    }
                }
            }
        }
        super.onRemove(state, world, pos, newState, isMoving);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }
    public BlockState updateShape(BlockState currentBlockState, Direction direction, BlockState neighborBlockState, LevelAccessor world, BlockPos currentPos, BlockPos neighborPos) {
        if (!currentBlockState.canSurvive(world, currentPos)) {
            world.scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(currentBlockState, direction, neighborBlockState, world, currentPos, neighborPos);
    }
    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState belowBlockState = levelReader.getBlockState(blockPos.below());
        return belowBlockState.is(Blocks.SOUL_SOIL);
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.NETHER;
    }

    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource random) {
        VoxelShape voxelShape = this.getShape(blockState, level, pos, CollisionContext.empty());
        Vec3 center = voxelShape.bounds().getCenter();
        double x = (double)pos.getX() + center.x;
        double z = (double)pos.getZ() + center.z;

        for(int i = 0; i < 3; ++i) {
            if (random.nextBoolean()) {
                level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + random.nextDouble() / 5.0D, (double)pos.getY() + (0.5D - random.nextDouble()), z + random.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                entity.hurt(new DamageSource("magic").bypassArmor(), 2);
                livingEntity.getPersistentData().putBoolean("PreventDrops", true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity != null && entity.getPersistentData().contains("PreventDrops")) {
            boolean preventDrops = entity.getPersistentData().getBoolean("PreventDrops");

            if (preventDrops) {
                event.getDrops().clear();
            }
        }
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return defaultBlockState();
    }
}

