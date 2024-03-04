package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.common.sounds.CustomSoundEvents;
import vectorwing.farmersdelight.common.registry.ModSounds;

@Mod.EventBusSubscriber
public class ChargeRingEat {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;

        Player player = (Player) event.getEntity();
        ItemStack mainHandStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHandStack = player.getItemInHand(InteractionHand.OFF_HAND);

        // Проверяем, что RING_SUPPLY_DISCHARGED находится в одной из рук, а SOUL_STONE_CHARGED в другой
        boolean isRingInMainHand = mainHandStack.getItem() == InitItemsWD.RING_SUPPLY_DISCHARGED.get().asItem();
        boolean isRingInOffHand = offHandStack.getItem() == InitItemsWD.RING_SUPPLY_DISCHARGED.get().asItem();
        boolean isSoulStoneInMainHand = mainHandStack.getItem() == InitItemsWD.SOUL_STONE_CHARGED.get().asItem();
        boolean isSoulStoneInOffHand = offHandStack.getItem() == InitItemsWD.SOUL_STONE_CHARGED.get().asItem();

        // Условие, что RING_SUPPLY_DISCHARGED и SOUL_STONE_CHARGED должны находиться в руках одновременно
        if ((isRingInMainHand && isSoulStoneInOffHand) || (isRingInOffHand && isSoulStoneInMainHand)) {
            // Заменяем RING_SUPPLY_DISCHARGED на RING_SUPPLY и SOUL_STONE_CHARGED на SOUL_STONE_DISCHARGED
            player.playSound(CustomSoundEvents.NYAMNYAM_END.get(), 1.0F, 1.0F);

            if (isRingInMainHand) {
                mainHandStack = new ItemStack(InitItemsWD.RING_SUPPLY.get().asItem());
                player.setItemInHand(InteractionHand.MAIN_HAND, mainHandStack);
            } else if (isRingInOffHand) {
                offHandStack = new ItemStack(InitItemsWD.RING_SUPPLY.get().asItem());
                player.setItemInHand(InteractionHand.OFF_HAND, offHandStack);
            }

            if (isSoulStoneInMainHand) {
                mainHandStack = new ItemStack(WizardryDelight.SOUL_STONE_DISCHARGED.get().asItem());
                player.setItemInHand(InteractionHand.MAIN_HAND, mainHandStack);
            } else if (isSoulStoneInOffHand) {
                offHandStack = new ItemStack(WizardryDelight.SOUL_STONE_DISCHARGED.get().asItem());
                player.setItemInHand(InteractionHand.OFF_HAND, offHandStack);
            }
        }
    }
}

