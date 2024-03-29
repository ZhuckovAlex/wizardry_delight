package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.server.procedures.StombleRoseDeactive;

public class StombleRose2 extends Block implements net.minecraftforge.common.IPlantable, EntityBlock {


    public StombleRose2(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().getItem() != this.asItem();
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack(InitItemsWD.ROSE_OF_THE_MURDERER.get());
    }
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

@Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StombleRose2Entity(pos, state);
    }


    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StombleRose2Entity be) {
                Containers.dropContents(world, pos, be);
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
        BlockEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof StombleRose2Entity be)
            return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
        else
            return 0;
    }
    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        // Вызываем супер-метод для выполнения уже существующей логики
        super.tick(blockstate, world, pos, random);

        // Получаем координаты позиции
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        // Проверяем условие из первого класса
        if (!blockstate.canSurvive(world, pos)) {
            world.destroyBlock(pos, true);

        }
        else {
            // Если условие выполнено, можно просто вызвать вашу логику без проверки
            WizardryDelight.queueServerWork(140, () -> {
                StombleRoseDeactive.execute(world, x, y, z);
            });
            // Перезапускаем таймер для следующего вызова tick
            world.scheduleTick(pos, this, 1);
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
    public void animateTick(BlockState p_222687_, Level p_222688_, BlockPos p_222689_, RandomSource p_222690_) {
        VoxelShape voxelshape = this.getShape(p_222687_, p_222688_, p_222689_, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)p_222689_.getX() + vec3.x;
        double d1 = (double)p_222689_.getZ() + vec3.z;

        for(int i = 0; i < 3; ++i) {
            if (p_222690_.nextBoolean()) {
                p_222688_.addParticle(ModParticles.STOMBLE_ROSE.get(), d0 + p_222690_.nextDouble() / 5.0D, (double)p_222689_.getY() + (0.5D - p_222690_.nextDouble()), d1 + p_222690_.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }

    }





    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return defaultBlockState();
    }
}
