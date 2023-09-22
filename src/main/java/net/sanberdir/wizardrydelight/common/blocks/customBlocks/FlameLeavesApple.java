package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.ForgeHooks;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class FlameLeavesApple extends LeavesBlock implements BonemealableBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    private final Supplier<Item> FRUIT;
    public FlameLeavesApple(Properties  pProperties, Supplier<Item> fruit) {
        super(pProperties);
        this.FRUIT = fruit;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, false)
                .setValue(WATERLOGGED, false)
                .setValue(AGE, 0)
        );
    }

    @Override
    public MaterialColor getMapColor(BlockState state, BlockGetter level, BlockPos pos, MaterialColor defaultColor) {
        return super.getMapColor(state, level, pos, defaultColor);
        }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return super.isRandomlyTicking(pState) || pState.getValue(AGE) != MAX_AGE;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (this.decaying(pState)) {
            dropResources(pState, pLevel, pPos);
            pLevel.removeBlock(pPos, false);
        } else {
            if (pLevel.getRawBrightness(pPos, 0) >= 9) {
                int age = pState.getValue(AGE);
                if ((age < MAX_AGE) && (Math.random() < 0.15f)) {
                    if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
                        pLevel.setBlock(pPos, pState.setValue(AGE, age + 1), 2);
                        ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                    }
                }
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DISTANCE, PERSISTENT, WATERLOGGED, AGE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pState.getValue(AGE) != MAX_AGE;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        pLevel.setBlock(pPos, pState.setValue(AGE, Math.min(MAX_AGE, pState.getValue(AGE) + 1)), 2);
    }

    @Override
    public boolean isBurning(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 100;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource source) {
        super.tick(pState, pLevel, pPos, source);
        final int age = pState.getValue(AGE);
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        if (age == MAX_AGE) {
            if (((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get())
                    &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR)) {
                pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.SMALL_GREEN_APPLE_BLOCK.get().defaultBlockState(), 3);
            }
            else if (((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get())
                    &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InitBlocksWD.SMALL_GREEN_APPLE_BLOCK.get())) {
                pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.GREEN_APPLE_BLOCK.get().defaultBlockState(), 3);
            }
            else if (((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get())
                    &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InitBlocksWD.GREEN_APPLE_BLOCK.get())) {
                pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.APPLE_BLOCK.get().defaultBlockState(), 3);
            }
            BlockState blockstate = pState.setValue(AGE, 1);
            pLevel.setBlock(pPos, blockstate, 2);
        }
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 10;
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        super.onCaughtFire(state, level, pos, direction, igniter);
    }

     @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        final int age = pState.getValue(AGE);
         int x = pPos.getX();
         int y = pPos.getY();
         int z = pPos.getZ();

         if (age != MAX_AGE && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
             if ((((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get()))
                     &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InitBlocksWD.APPLE_BLOCK.get())) {
                 BlockState blockstate = pState.setValue(AGE, MAX_AGE);
                 return InteractionResult.SUCCESS;
             }
            return InteractionResult.PASS;

        } else if (age == MAX_AGE) {

             if (((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get())
                     &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR)) {
                 pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.SMALL_GREEN_APPLE_BLOCK.get().defaultBlockState(), 3);
                 BlockState blockstate = pState.setValue(AGE, 1);
                 pLevel.setBlock(pPos, blockstate, 2);
                 pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
                 return InteractionResult.SUCCESS;
             }
             else if ((((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get()))
                     &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InitBlocksWD.SMALL_GREEN_APPLE_BLOCK.get())) {
                 pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.GREEN_APPLE_BLOCK.get().defaultBlockState(), 3);
                 BlockState blockstate = pState.setValue(AGE, 1);
                 pLevel.setBlock(pPos, blockstate, 2);
                 pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
                 return InteractionResult.SUCCESS;
             }
             else if ((((pLevel.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.APPLE_LEAVES.get()))
                     &&((pLevel.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InitBlocksWD.GREEN_APPLE_BLOCK.get())) {
                 pLevel.setBlock(new BlockPos(x, y - 1, z), InitBlocksWD.APPLE_BLOCK.get().defaultBlockState(), 3);
                 BlockState blockstate = pState.setValue(AGE, MAX_AGE);
                 return InteractionResult.SUCCESS;
             }

            return InteractionResult.SUCCESS;
        } else {
             return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
        }, InitBlocksWD.APPLE_LEAVES.get());
    }
}
