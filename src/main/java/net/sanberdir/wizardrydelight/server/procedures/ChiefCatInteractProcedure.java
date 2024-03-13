package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;

import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ChiefCatInteractProcedure {
    public static void catInteract(Player player, double x, double y, double z) {
        if (player == null || player.level.isClientSide) {
            return; // Прекращаем выполнение на клиенте или если игрок не существует
        }

        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() == Items.COOKED_PORKCHOP) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.COOKED_BEEF) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.APPLE) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.CARROT) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.POTATO) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.BAKED_POTATO) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.POISONOUS_POTATO) {
            processItemInteraction(player, x, y, z, 0.01);
        } else if (mainHandItem.getItem() == Items.BEETROOT) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.GLOW_BERRIES) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.SWEET_BERRIES) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.RABBIT) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.MUTTON) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.PUMPKIN_PIE) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == Items.HONEY_BOTTLE) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == Items.RABBIT_STEW) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == Items.BEETROOT_SOUP) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == Items.COOKED_SALMON) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.COOKED_COD) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.COOKED_CHICKEN) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.CHICKEN) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == Items.ROTTEN_FLESH) {
            processItemInteraction(player, x, y, z, 0.01);
        } else if (mainHandItem.getItem() == Items.SPIDER_EYE) {
            processItemInteraction(player, x, y, z, 0.01);
        } else if (mainHandItem.getItem() == Items.COOKED_RABBIT) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.COD) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.SALMON) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.TROPICAL_FISH) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.PUFFERFISH) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.GOLDEN_APPLE) {
            processItemInteraction(player, x, y, z, 0.25);
        } else if (mainHandItem.getItem() == Items.CAKE) {
            processItemInteraction(player, x, y, z, 0.4);
        } else if (mainHandItem.getItem() == Items.COOKIE) {
            processItemInteraction(player, x, y, z, 0.04);
        } else if (mainHandItem.getItem() == Items.BEEF) {
            processItemInteraction(player, x, y, z, 0.04);
        } else if (mainHandItem.getItem() == Items.DRIED_KELP) {
            processItemInteraction(player, x, y, z, 0.04);
        } else if (mainHandItem.getItem() == Items.MELON_SLICE) {
            processItemInteraction(player, x, y, z, 0.04);
        } else if (mainHandItem.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
            processItemInteraction(player, x, y, z, 0.75);
        } else if (mainHandItem.getItem() == Items.PORKCHOP) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.BREAD) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.MUSHROOM_STEW) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == Items.COOKED_MUTTON) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.TURTLE_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == InitItemsWD.PICKLED_TURTLE_NECK.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.FROG_BODY.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.FROG_LEGS.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.CLEANED_TURTLE_NECK.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.TURTLE_NECK.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.BEAR_MEAT_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_SLISING_GOATS_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.HUNTING_TWISTER.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_GOATS_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.GOAT_MEAT_KEBAB.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_GOAT_MEAT_KEBAB.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_BEAR_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.SOUP_FROM_BEAR.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.SWEET_ROLL.get()) {
            processItemInteraction(player, x, y, z, 0.3);
        } else if (mainHandItem.getItem() == InitItemsWD.CHEESE.get()) {
            processItemInteraction(player, x, y, z, 0.7);
        } else if (mainHandItem.getItem() == InitItemsWD.IRIS.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.POISON_BERRY.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.SHPIKACHKI.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_SHPIKACHKI.get()) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == InitItemsWD.CHARMING_BERRIES.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.PEPPER.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.RAW_HORSE.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.RAW_GOATS_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.RAW_BEAR_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.RAW_SLISING_GOATS_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.FREEZE_BERRIES.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_FROG_LEGS.get()) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_FROG.get()) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == InitItemsWD.MUSHROOM_ON_STICK.get()) {
            processItemInteraction(player, x, y, z, 0.04);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_MUSHROOM_ON_STICK.get()) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_HORSE.get()) {
            processItemInteraction(player, x, y, z, 0.08);
        } else if (mainHandItem.getItem() == InitItemsWD.APPLE_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == InitItemsWD.SWEET_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == InitItemsWD.KRUTNEVY_BREAD.get()) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == InitItemsWD.MEDICAL_POTATO.get()) {
            processItemInteraction(player, x, y, z, 0.05);
        } else if (mainHandItem.getItem() == InitItemsWD.GLOWING_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.1);
        } else if (mainHandItem.getItem() == InitItemsWD.CHARMING_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.HOT_COCOA_WITH_SPARKING_POLLEN.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.POISON_BERRY_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.FREEZE_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.POISON_BERRY_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.15);
        } else if (mainHandItem.getItem() == InitItemsWD.JAM_TONIC.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.JAM_INVISIBILITY.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.LEVITAN_JAM.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.COCKED_SLISING_GOATS_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.SPAGETTI_IN_THE_NORTH.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.GOULASH_WITH_GOAT_MEAT.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.ROAST_GOAT_MEAT_WITH_FREEZE_BERRIES_SYRUP.get()) {
            processItemInteraction(player, x, y, z, 0.2);
        } else if (mainHandItem.getItem() == InitItemsWD.WIZARD_PIE.get()) {
            processItemInteraction(player, x, y, z, 0.8);
        } else if (mainHandItem.getItem() == InitItemsWD.SUGAR_REFINED.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CABBAGE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.TOMATO.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.ONION.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.FRIED_EGG.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MILK_BOTTLE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HOT_COCOA.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.APPLE_CIDER.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MELON_JUICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.TOMATO_SAUCE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.WHEAT_DOUGH.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.RAW_PASTA.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.PUMPKIN_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CABBAGE_LEAF.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MINCED_BEEF.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BEEF_PATTY.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CHICKEN_CUTS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_CHICKEN_CUTS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BACON.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_BACON.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COD_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_COD_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SALMON_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_SALMON_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MUTTON_CHOPS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_MUTTON_CHOPS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HAM.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SMOKED_HAM.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.PIE_CRUST.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.APPLE_PIE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SWEET_BERRY_CHEESECAKE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CHOCOLATE_PIE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CAKE_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.APPLE_PIE_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SWEET_BERRY_CHEESECAKE_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CHOCOLATE_PIE_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SWEET_BERRY_COOKIE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HONEY_COOKIE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MELON_POPSICLE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.GLOW_BERRY_CUSTARD.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.FRUIT_SALAD.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MIXED_SALAD.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BARBECUE_STICK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.EGG_SANDWICH.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CHICKEN_SANDWICH.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HAMBURGER.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BACON_SANDWICH.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.MUTTON_WRAP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.DUMPLINGS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.STUFFED_POTATO.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CABBAGE_ROLLS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SALMON_ROLL.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COD_ROLL.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.KELP_ROLL.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.KELP_ROLL_SLICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.COOKED_RICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BONE_BROTH.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BEEF_STEW.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.CHICKEN_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.VEGETABLE_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.FISH_STEW.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.FRIED_RICE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.PUMPKIN_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BAKED_COD_STEW.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.NOODLE_SOUP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.BACON_AND_EGGS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.PASTA_WITH_MEATBALLS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.PASTA_WITH_MUTTON_CHOP.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.ROASTED_MUTTON_CHOPS.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.VEGETABLE_NOODLES.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.STEAK_AND_POTATOES.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.RATATOUILLE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SQUID_INK_PASTA.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.GRILLED_SALMON.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.ROAST_CHICKEN_BLOCK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.STUFFED_PUMPKIN_BLOCK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.STUFFED_PUMPKIN.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HONEY_GLAZED_HAM_BLOCK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HONEY_GLAZED_HAM.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SHEPHERDS_PIE_BLOCK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.RICE_ROLL_MEDLEY_BLOCK.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.DOG_FOOD.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.HORSE_FEED.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.ROAST_CHICKEN.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.SHEPHERDS_PIE.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        } else if (mainHandItem.getItem() == ModItems.NETHER_SALAD.get()) {
            processItemInteraction(player, x, y, z, 0.02);
        }
    }
    private static void processItemInteraction(Player player, double x, double y, double z, double chance) {
        Level world = player.getCommandSenderWorld();
        ItemStack mainHandItem = player.getMainHandItem();

        mainHandItem.shrink(1);
        if (Math.random() <= chance) {
            // Воспроизводим звук
            player.getCommandSenderWorld().playSound(null, player.blockPosition(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cat.purreow")), SoundSource.NEUTRAL, 1, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.HEART, x, y, z, 15, 0.2, 0.2, 0.2, 1);
            // Добавляем каплю любви
            ItemStack netherStar = new ItemStack(InitItemsWD.A_DROP_OF_LOVE.get());
            spawnItemEntity(world, x, y, z, netherStar);

            // Завершаем выполнение текущего метода
        } else {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 15, 0.2, 0.2, 0.2, 1);

            // Воспроизводим шипение кота
            player.getCommandSenderWorld().playSound(null, player.blockPosition(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cat.hiss")), SoundSource.NEUTRAL, 1, 1);
        }
    }
    private static void spawnItemEntity(Level world, double x, double y, double z, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(world, x, y, z, stack);
        world.addFreshEntity(itemEntity);
    }
}