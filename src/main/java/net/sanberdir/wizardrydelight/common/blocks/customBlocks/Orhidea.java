package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
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

public class Orhidea extends Block implements net.minecraftforge.common.IPlantable {


    public Orhidea(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().getItem() != this.asItem();
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
        return belowBlockState.is(Blocks.END_STONE);
    }
    @Override
    public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return null;
    }
    public void animateTick(BlockState p_222687_, Level p_222688_, BlockPos p_222689_, RandomSource p_222690_) {
        VoxelShape voxelshape = this.getShape(p_222687_, p_222688_, p_222689_, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)p_222689_.getX() + vec3.x;
        double d1 = (double)p_222689_.getZ() + vec3.z;
        for(int i = 0; i < 3; ++i) {
            if (p_222690_.nextBoolean()) {
                p_222688_.addParticle(ParticleTypes.PORTAL, d0 + p_222690_.nextDouble() / 5.0D, (double)p_222689_.getY() + (0.5D - p_222690_.nextDouble()), d1 + p_222690_.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    public void entityInside(BlockState p_58238_, Level p_58239_, BlockPos p_58240_, Entity p_58241_) {
        if (!p_58239_.isClientSide ) {

            if (p_58241_ instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)p_58241_;
                Double x = livingentity.getX();
                Double y = livingentity.getY();
                Double z = livingentity.getZ();

                livingentity.randomTeleport((x - Math.round(Math.random() * 200)), (Math.random() * y + 256), (z - Math.round(Math.random() * 200)),true);
                livingentity.randomTeleport((x + Math.round(Math.random() * 200)), (Math.random() * y + 256), (z - Math.round(Math.random() * 200)),true);
                livingentity.randomTeleport((x - Math.round(Math.random() * 200)), (Math.random() * y + 256), (z + Math.round(Math.random() * 200)),true);
                livingentity.randomTeleport((x + Math.round(Math.random() * 200)), (Math.random() * y + 256), (z + Math.round(Math.random() * 200)),true);
            }
        }
    }
    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return defaultBlockState();
    }
}
