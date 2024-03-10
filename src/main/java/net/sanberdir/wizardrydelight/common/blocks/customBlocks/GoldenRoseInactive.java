package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.eventbus.api.Event;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.server.procedures.StombleRoseDeactive;

import javax.annotation.Nullable;
import java.util.Map;

public class GoldenRoseInactive extends Block implements net.minecraftforge.common.IPlantable {


    public GoldenRoseInactive(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.randomTick(blockstate, world, pos, random);
        // Проверяем, что блок все еще существует и находится в нужном месте
        if (world.getBlockState(pos).getBlock() instanceof GoldenRoseInactive) {
            // Запланируем задачу на превращение блока через 20 тиков (1 секунд)
            world.scheduleTick(pos, this, 20); // 20 тиков = 1 секунд
        }
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        // Превращаем блок в MEADOW_GOLDEN_FLOWER
        Block block = Block.byItem(InitItemsWD.MEADOW_GOLDEN_FLOWER.get());
        world.setBlockAndUpdate(pos, block.defaultBlockState());
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack(InitItemsWD.MEADOW_GOLDEN_FLOWER.get());
    }

    public boolean canSurvive(BlockState p_57175_, LevelReader p_57176_, BlockPos p_57177_) {
        BlockState soil = p_57176_.getBlockState(p_57177_.below());

        BlockState blockstate = p_57176_.getBlockState(p_57177_.below());
        if (blockstate.is(this)) {
            return false;
        } else {
            if (blockstate.is(Blocks.SOUL_SOIL)||blockstate.is(Blocks.SOUL_SAND)|| blockstate.is(BlockTags.NYLIUM)|| blockstate.is(BlockTags.SAND)||blockstate.is(Blocks.DIRT)||blockstate.is(Blocks.GRASS_BLOCK)) {
                BlockPos blockpos = p_57177_.below();

                return true;
            }
            return false;
        }
    }
    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }

    public void animateTick(BlockState p_222687_, Level p_222688_, BlockPos p_222689_, RandomSource p_222690_) {
        VoxelShape voxelshape = this.getShape(p_222687_, p_222688_, p_222689_, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)p_222689_.getX() + vec3.x;
        double d1 = (double)p_222689_.getZ() + vec3.z;

        for(int i = 0; i < 3; ++i) {
            if (p_222690_.nextBoolean()) {
                p_222688_.addParticle(ParticleTypes.SMOKE, d0 + p_222690_.nextDouble() / 5.0D, (double)p_222689_.getY() + (0.5D - p_222690_.nextDouble()), d1 + p_222690_.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }

    }



    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return defaultBlockState();
    }
}
