package net.sanberdir.wizardrydelight.common.Items.arrows;


import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;

public class DispenserRegistry {
    public static void registerBehaviors() {

        DispenserBlock.registerBehavior(InitItemsWD.FLAME_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123456_, Position p_123457_, ItemStack p_123458_) {
                AbstractArrow abstractarrow = new FlameArrow(p_123456_, p_123457_.x(), p_123457_.y(), p_123457_.z());
                abstractarrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return abstractarrow;
            }
        });

    }
}
