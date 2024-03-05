package net.sanberdir.wizardrydelight.common.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.server.procedures.HitByBlockWD;
import net.sanberdir.wizardrydelight.server.procedures.HitByEntityWD;
import net.sanberdir.wizardrydelight.server.procedures.HitByEntityWDFrog;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class StarBall extends AbstractHurtingProjectileMod implements ItemSupplier {
    public StarBall(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.STAR_BALL.get(), world);
    }

    public StarBall(EntityType<? extends StarBall> type, Level world) {
        super(type, world);
    }


    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    protected void onHitEntity(EntityHitResult p_37386_) {
        super.onHitEntity(p_37386_);

        Entity entity = p_37386_.getEntity();
        if (!this.level.isClientSide) {
            HitByEntityWD.execute(level,getX(),getY(),getZ(),entity);
            HitByEntityWDFrog.execute(level,getX(),getY(),getZ(),entity);
            this.discard();
        }
    }

    protected void onHitBlock(BlockHitResult p_37384_) {
        super.onHitBlock(p_37384_);
        if (!this.level.isClientSide) {

            HitByBlockWD.execute(level,getX(),getY(),getZ(),getBlockStateOn());
            WizardryDelight.queueServerWork(2, () -> {
                this.discard();
            });
        }
    }

    @Override
    protected void onInsideBlock(BlockState p_20005_) {
        super.onInsideBlock(p_20005_);

        if (!this.level.isClientSide) {
            HitByBlockWD.execute(level,getX(),getY(),getZ(),getBlockStateOn());
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(InitItemsWD.STAR_BALL.get());
    }


}