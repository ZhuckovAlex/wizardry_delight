package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.blocks.ModBlockStateProperties;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;

import java.util.Collections;
import java.util.List;

public class WDSpawner extends BaseEntityBlock implements EntityBlock{




    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    public void spawnAfterBreak(BlockState p_222477_, ServerLevel p_222478_, BlockPos p_222479_, ItemStack p_222480_, boolean p_222481_) {
        super.spawnAfterBreak(p_222477_, p_222478_, p_222479_, p_222480_, p_222481_);

    }


    public WDSpawner(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(POLLEN, Integer.valueOf(0)));
        this.registerDefaultState(this.stateDefinition.any().setValue(SOUL_STONES, Integer.valueOf(0)));

    }
    public static final int MIN_POLLEN = 0;
    public static final int MAX_POLLEN = 5;
    public static final IntegerProperty POLLEN = ModBlockStateProperties.POLLEN_PR;
    public static final int MIN_SOUL_STONES = 0;
    public static final int MAX_SOUL_STONES = 2;
    public static final IntegerProperty SOUL_STONES = ModBlockStateProperties.SOUL_STONES;

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WDSpawnerEntity(pos, state);
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


    public static void getEntity1(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            BlockPos _bp = new BlockPos(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putString("getEntity1", ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }entity.getPersistentData().putString("id", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")));


        entity.getPersistentData().putString("SpawnData", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")))));


        if (!world.isClientSide()) {
            BlockPos _bp = new BlockPos(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putString("getEntity1name", ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("name_entity")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }

    }

    public static void getEntity2(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            BlockPos _bp = new BlockPos(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putString("getEntity2", ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            BlockPos _bp = new BlockPos(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putString("getEntity2name", ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("name_entity")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }

    }

    public static void summonEntity(LevelAccessor world, double x, double y, double z,BlockPos pos,BlockState state,ServerLevel level) {
        if ((new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")).equals(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity2"))) {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        ("/summon " + (new Object() {
                            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getString(tag);
                                return "";
                            }
                        }.getValue(world, new BlockPos(x, y, z), "getEntity1")) + " ~0.5 ~1 ~0.5"));
          if ((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, new BlockPos(x, y, z), "getEntity1")).equals("minecraft:cow")) {
                if (Math.random() <= 0.04) {
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "summon wizardry_delight:wool_cow ~0.5 ~1 ~0.5");
                }
            }
           if ((new Object() {
                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getString(tag);
                    return "";
                }
            }.getValue(world, new BlockPos(x, y, z), "getEntity1")).equals("minecraft:chicken")) {
                if (Math.random() <= 0.02) {
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                "summon wizardry_delight:feather_chicken ~0.5 ~1 ~0.5");
                }
            }


            if (Math.random() < 0.40) {
                pollenMinus(level,pos,state);
            }
            }

        }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        super.animateTick(state, level, pos, source);

        if (state.getValue(SOUL_STONES) == 2) {
            if (source.nextInt(100) == 0) {
                level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            double d0 = (double)pos.getX() + 0.5D + (0.5D - source.nextDouble());
            double d1 = (double)pos.getY() + 0.3D;
            double d2 = (double)pos.getZ() + 0.5D + (0.5D - source.nextDouble());
            double d3 = (double)source.nextFloat() * 0.04D;
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0, d1, d2, 0.0D, d3, 0.0D);
        }
        if (state.getValue(POLLEN) > 0) {
            if (source.nextInt(100) == 0) {
                level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            double d0 = (double)pos.getX() + 0.5D + (0.5D - source.nextDouble());
            double d1 = (double)pos.getY() + 1D;
            double d2 = (double)pos.getZ() + 0.5D + (0.5D - source.nextDouble());
            double d3 = (double)source.nextFloat() * 0.04D;
            level.addParticle(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), d0, d1, d2, 0.0D, d3, 0.0D);
        }
    }

    @Override
    public void tick(BlockState p_222945_, ServerLevel level, BlockPos pos, RandomSource p_222948_) {
        super.tick(p_222945_, level, pos, p_222948_);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();


    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        Player entity = Minecraft.getInstance().player;
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if ((sumBePollen(state))&&(canBeSoulStones2(state))) {
            summonEntity(serverLevel,x, y, z,pos,state,serverLevel);
        }
    }




    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult p_55879_) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (interactionHand == InteractionHand.MAIN_HAND && !isPollen(itemstack) && isPollen(player.getItemInHand(InteractionHand.OFF_HAND))&& !isSoulStones(itemstack) && isSoulStones(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return InteractionResult.PASS;

        } else if (isPollen(itemstack) && canBePollen(state)) {
            pollen(level, pos, state);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.PASS;
        } else if (isSoulStones(itemstack) && canBeSoulStones0(state)) {
            soulStones(level, pos, state);
            getEntity1(level,pos.getX(),pos.getY(),pos.getZ(),player);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.PASS;

        } else if (isSoulStones(itemstack) && canBeSoulStones1(state)) {
            soulStones(level, pos, state);
            getEntity2(level,pos.getX(),pos.getY(),pos.getZ(),player);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.PASS;

        } else if (isRobinStick(itemstack) && canBeSoulStones1(state)) {
            soulStonesMinus(level, pos, state);
            GiveSoulStone1(level,pos.getX(),pos.getY(),pos.getZ(),player);

            return InteractionResult.PASS;

        } else if (isRobinStick(itemstack) && canBeSoulStones2(state)) {
            soulStonesMinus(level, pos, state);
            GiveSoulStone2(level,pos.getX(),pos.getY(),pos.getZ(),player);

            return InteractionResult.PASS;

        } else if (state.getValue(POLLEN) == 0) {
            return InteractionResult.PASS;
        } else if (state.getValue(SOUL_STONES) == 0) {
            return InteractionResult.PASS;
        }



        return InteractionResult.sidedSuccess(level.isClientSide);
    }
    private static void GiveSoulStone2(LevelAccessor world, double x, double y, double z, Entity entity) {

        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(InitItemsWD.SOUL_STONE_CHARGED.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("entity", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity2")));
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name_entity", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity2name")));
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Blocks.AIR);
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }



    }
    private static void GiveSoulStone1(LevelAccessor world, double x, double y, double z, Entity entity) {

        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(InitItemsWD.SOUL_STONE_CHARGED.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("entity", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")));
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name_entity", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1name")));
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Blocks.AIR);
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }

    }

    private static void GiveSoulStonesAllStarting(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putString("getEntity1", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")));
        entity.getPersistentData().putString("getEntity1name", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1name")));


        if (entity == null)
            return;
        entity.getPersistentData().putString("getEntity2", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity2")));
        entity.getPersistentData().putString("getEntity2name", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity2name")));
    }
    private static void GiveSoulStonesAll(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(InitItemsWD.SOUL_STONE_CHARGED.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("entity", (entity.getPersistentData().getString("getEntity1")));
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name_entity",  (entity.getPersistentData().getString("getEntity1name")));
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Blocks.AIR);
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }

        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(InitItemsWD.SOUL_STONE_CHARGED.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("entity", (entity.getPersistentData().getString("getEntity2")));
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name_entity",  (entity.getPersistentData().getString("getEntity2name")));
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Blocks.AIR);
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
    }
    private static void GiveSoulStonesOneStarting(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putString("getEntity1", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1")));
        entity.getPersistentData().putString("getEntity1name", (new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, new BlockPos(x, y, z), "getEntity1name")));
    }

    private static void GiveSoulStonesOne(LevelAccessor world, double x, double y, double z, Entity entity) {

        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(InitItemsWD.SOUL_STONE_CHARGED.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("entity", (entity.getPersistentData().getString("getEntity1")));
        (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name_entity",  (entity.getPersistentData().getString("getEntity1name")));
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Blocks.AIR);
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }

    }

    private static boolean isPollen(ItemStack itemStack) {
        return itemStack.is(InitItemsWD.SPARKLING_POLLEN.get());
    }
    private static boolean isSoulStones(ItemStack itemStack) {
        return itemStack.is(InitItemsWD.SOUL_STONE_CHARGED.get());
    }
    private static boolean isRobinStick(ItemStack itemStack) {
        return itemStack.is(InitItemsWD.ROBIN_STICK.get());
    }


    private static boolean sumBePollen(BlockState state) {
        return state.getValue(POLLEN) > 0;
    }
    private static boolean canBePollen(BlockState state) {
        return state.getValue(POLLEN) < 5;
    }
    private static boolean canBeSoulStones0(BlockState state) {
        return state.getValue(SOUL_STONES) == 0;
    }
    private static boolean canBeSoulStones1(BlockState state) {
        return state.getValue(SOUL_STONES) == 1;
    }
    private static boolean canBeSoulStones2(BlockState state) {
        return state.getValue(SOUL_STONES) == 2;
    }

    public static void pollenMinus(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(POLLEN, Integer.valueOf(state.getValue(POLLEN) - 1)), 3);
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    public static void pollen(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(POLLEN, Integer.valueOf(state.getValue(POLLEN) + 1)), 3);
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    public static void soulStones(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(SOUL_STONES, Integer.valueOf(state.getValue(SOUL_STONES) + 1)), 3);
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    public static void soulStonesMinus(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(SOUL_STONES, Integer.valueOf(state.getValue(SOUL_STONES) - 1)), 3);
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(POLLEN);
        state.add(FACING);
        state.add(SOUL_STONES);
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
        super.attack(blockstate, world, pos, entity);
        if (canBeSoulStones1(blockstate)) {
            GiveSoulStonesOneStarting(world, pos.getX(), pos.getY(), pos.getZ(), entity);
        }
        if (canBeSoulStones2(blockstate)) {
            GiveSoulStonesAllStarting(world, pos.getX(), pos.getY(), pos.getZ(), entity);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        if (canBeSoulStones2(blockstate)) {
            GiveSoulStonesAll(world, pos.getX(), pos.getY(), pos.getZ(), entity);
        }
        if (canBeSoulStones1(blockstate)) {
            GiveSoulStonesOne(world, pos.getX(), pos.getY(), pos.getZ(), entity);
        }
        return retval;
    }

}
