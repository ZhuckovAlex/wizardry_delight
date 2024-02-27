package net.sanberdir.wizardrydelight.common.blocks.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.common.blocks.ModBlockEntities;
import net.sanberdir.wizardrydelight.common.world.level.ModBaseSpawner;

import javax.annotation.Nullable;


public class WDSpawnerEntity extends BlockEntity  {


    private final ModBaseSpawner spawner = new ModBaseSpawner() {
        public void broadcastEvent(Level p_155767_, BlockPos p_155768_, int p_155769_) {
            p_155767_.blockEvent(p_155768_, InitBlocksWD.WD_SPAWNER.get(), p_155769_, 0);
        }

        public void setNextSpawnData(@Nullable Level level, BlockPos blockPos, SpawnData spawnData) {
            super.setNextSpawnData(level, blockPos, spawnData);
            if (level != null) {
                BlockState blockstate = level.getBlockState(blockPos);
                level.sendBlockUpdated(blockPos, blockstate, blockstate, 4);
            }

        }

        @org.jetbrains.annotations.Nullable
        public BlockEntity getSpawnerBlockEntity(){ return WDSpawnerEntity.this; }
    };

    public WDSpawnerEntity(BlockPos p_155752_, BlockState p_155753_) {
        super(ModBlockEntities.SPAWNER_MOD_TYPE, p_155752_, p_155753_);
    }

    public void load(CompoundTag p_155760_) {
        super.load(p_155760_);
        this.spawner.load(this.level, this.worldPosition, p_155760_);
    }

    protected void saveAdditional(CompoundTag p_187521_) {
        super.saveAdditional(p_187521_);
        this.spawner.save(p_187521_);
    }



    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = this.saveWithoutMetadata();
        compoundtag.remove("SpawnPotentials");
        return compoundtag;
    }

    public boolean triggerEvent(int p_59797_, int p_59798_) {
        return this.spawner.onEventTriggered(this.level, p_59797_) ? true : super.triggerEvent(p_59797_, p_59798_);
    }

    public boolean onlyOpCanSetNbt() {
        return true;
    }

    public BaseSpawner getSpawner() {
        return this.spawner;
    }
    }

