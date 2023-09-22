package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

public class AppleBlock extends Block implements net.minecraftforge.common.IPlantable {
    protected static final VoxelShape TOP_AABB = Block.box(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final float AABB_OFFSET = 6.0F;

    public AppleBlock(Properties p_49795_) {
        super(p_49795_);
    }


    public VoxelShape getShape(BlockState p_57193_, BlockGetter p_57194_, BlockPos p_57195_, CollisionContext p_57196_) {
        return TOP_AABB;
    }

    public void tick(BlockState p_222543_, ServerLevel p_222544_, BlockPos p_222545_, RandomSource p_222546_) {
        if (!p_222543_.canSurvive(p_222544_, p_222545_)) {
            p_222544_.destroyBlock(p_222545_, true);
        }

    }

    public void randomTick(BlockState p_222548_, ServerLevel p_222549_, BlockPos p_222550_, RandomSource p_222551_) {

        if (p_222549_.isEmptyBlock(p_222550_.above())) {
            int i;
            for(i = 1; p_222549_.getBlockState(p_222550_.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                int j = p_222548_.getValue(AGE);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222549_, p_222550_, p_222548_, true)) {
                    if (j == 15) {
                        p_222549_.setBlockAndUpdate(p_222550_.above(), this.defaultBlockState());
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222549_, p_222550_.above(), this.defaultBlockState());
                        p_222549_.setBlock(p_222550_, p_222548_.setValue(AGE, Integer.valueOf(0)), 4);
                    } else {
                        p_222549_.setBlock(p_222550_, p_222548_.setValue(AGE, Integer.valueOf(j + 1)), 4);
                    }
                }
            }
        }

    }

    public BlockState updateShape(BlockState p_57179_, Direction p_57180_, BlockState p_57181_, LevelAccessor p_57182_, BlockPos p_57183_, BlockPos p_57184_) {
        if (!p_57179_.canSurvive(p_57182_, p_57183_)) {
            p_57182_.scheduleTick(p_57183_, this, 1);
        }

        return super.updateShape(p_57179_, p_57180_, p_57181_, p_57182_, p_57183_, p_57184_);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57186_) {
        p_57186_.add(AGE);
    }
    public boolean canSurvive(BlockState p_57175_, LevelReader p_57176_, BlockPos p_57177_) {
        BlockState soil = p_57176_.getBlockState(p_57177_.above());
        if (soil.canSustainPlant(p_57176_, p_57177_.above(), Direction.DOWN, this)) return true;
        BlockState blockstate = p_57176_.getBlockState(p_57177_.above());
        if (blockstate.is(this)) {
            return true;
        } else {
            if (blockstate.is(InitBlocksWD.APPLE_LEAVES.get())){
                return true;
            }
            return false;
        }
    }

    @Override
    public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getPlant(BlockGetter level, BlockPos pos) {
        return defaultBlockState();
    }


}
