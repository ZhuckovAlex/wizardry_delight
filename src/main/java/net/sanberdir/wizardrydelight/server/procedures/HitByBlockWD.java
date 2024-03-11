package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.common.sounds.CustomSoundEvents;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;


import java.awt.*;
import java.util.Random;

public class HitByBlockWD {

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        BlockPos pos = new BlockPos(x, y, z);
        Block block = world.getBlockState(pos).getBlock();
        Random random = new Random();

        if (block == InitBlocksWD.COASTAL_STEEP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.KRUTNEVY_BREAD.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.15) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.KRUTNEVY_BREAD.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.COCOA) {
            Property<?> ageProperty = blockstate.getBlock().getStateDefinition().getProperty("age");
            if (ageProperty instanceof IntegerProperty) {
                IntegerProperty integerAgeProperty = (IntegerProperty) ageProperty;
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.HOT_COCOA_WITH_SPARKING_POLLEN.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());

                if (random.nextDouble() < 0.15) { // Шанс 15%
                    processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.HOT_COCOA_WITH_SPARKING_POLLEN.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
                }
            }
        } else if (block == InitBlocksWD.CHARMING_BERRIES_BLOCK.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.CHARMING_JAM.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == InitBlocksWD.POISON_BERRY.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.POISON_BERRY_JAM.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.HANDFUL_YADOGA.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == InitBlocksWD.FREEZE_BERRIES.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.FREEZE_JAM.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == InitBlocksWD.FIRE_STEM.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.HANDFUL_NETHER.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == InitBlocksWD.COASTAL_STEEP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.KRUTNEVY_BREAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == InitBlocksWD.COASTAL_STEEP_W.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.KRUTNEVY_BREAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.OXEYE_DAISY) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.SUNFLOWER) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 2, 4, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.RED_MUSHROOM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.BROWN_MUSHROOM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.WHEAT) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BREAD, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.HAY_BLOCK) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BREAD, 5, 12, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.GRASS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.TALL_GRASS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.FERN) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.LARGE_FERN) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.CRIMSON_FUNGUS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.NETHER_SALAD.get(), 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.CRIMSON_ROOTS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.NETHER_SALAD.get(), 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.WARPED_ROOTS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.NETHER_SALAD.get(), 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.WARPED_FUNGUS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.NETHER_SALAD.get(), 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.MUSHROOM_STEM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 7, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.RED_MUSHROOM_BLOCK) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 7, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.BROWN_MUSHROOM_BLOCK) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 7, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.DANDELION) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.POTATO, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.POPPY) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.ALLIUM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.ONION.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.KELP_PLANT) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.KELP_ROLL.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.CAVE_VINES) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.GLOW_BERRY_CUSTARD.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.SWEET_BERRY_BUSH) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.SWEET_JAM.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.SANDY_SHRUB.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.HOT_COCOA.get(), 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.BEETROOTS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 2, 4, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.BEETROOT_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.CARROT_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.POTATO_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == InitBlocksWD.APPLE_BLOCK.get()) {
            if (random.nextDouble() < 0.45) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.APPLE_JAM.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.APPLE_CIDER.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.CABBAGE_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.TOMATO_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.TOMATO_SAUCE.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.ONION_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.VEGETABLE_SOUP.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.RICE_BALE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MUSHROOM_RICE.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.RICE_BAG.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.FRIED_RICE.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.WILD_CABBAGES.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.CABBAGE_CROP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.WILD_ONIONS.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.ONION.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.ONION_CROP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MIXED_SALAD.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.ONION.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.WILD_TOMATOES.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.TOMATO_SAUCE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.TOMATO_SAUCE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.WILD_BEETROOTS.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.TOMATO_CROP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.TOMATO_SAUCE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.TOMATO_SAUCE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.WILD_RICE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.FRIED_RICE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.FRIED_RICE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.RICE_CROP.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.FRIED_RICE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.FRIED_RICE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == ModBlocks.WILD_CARROTS.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.RED_TULIP) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.ORANGE_TULIP) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.ROSE_BUSH) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.SWEET_BERRY_CHEESECAKE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.SWEET_BERRY_CHEESECAKE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.WHITE_TULIP) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.PINK_TULIP) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.POTATO, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.POTATO, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.CARROTS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.GLOW_LICHEN) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.BONE_BROTH.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.WILD_POTATOES.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.POTATOES) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.PUMPKIN) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.PUMPKIN_SLICE.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.PUMPKIN_PIE, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.MELON) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MELON_JUICE.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.MELON_POPSICLE.get(), 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == InitBlocksWD.MEADOW_GOLDEN_FLOWER.get()) {
            // Call the method to spawn smoke particles and heal entities
            spawnSmokeParticlesAndHeal(world, pos, 5, pos.getX(), pos.getY(), pos.getZ());
        }
        if (block == InitBlocksWD.A_BLOCK_OF_SPARKING_POLLEN.get()) {
            // Вызовите функцию взрыва с силой 10
            explodeSparkingPollen(world, pos, Blocks.AIR.defaultBlockState());
        }
        if (block == InitBlocksWD.WIZARD_PIE.get()) {
            // Вызовите функцию взрыва с силой 10
            explodeWizardCake(world, pos, Blocks.AIR.defaultBlockState());
        }
        // Добавьте аналогичные проверки для других блоков, если это необходимо

    }
    private static void spawnSmokeParticlesAndHeal(LevelAccessor world, BlockPos pos, int radius, double x, double y, double z) {
        if (world instanceof ServerLevel serverLevel) {
            // Spawn smoke particles around the Peony
            if (world instanceof ServerLevel _level)
                serverLevel.sendParticles(ModParticles.GOLDEN_FLOWER_PARTICLES.get(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 0, 0, 0, 0.7);

            serverLevel.sendParticles(ModParticles.GOLDEN_FLOWER_PARTICLES.get(), x, y, z, 1, 1, 1, 1, 0.5);



            BlockState redTulipState = InitBlocksWD.MEADOW_GOLDEN_FLOWER_INACTIVE.get().defaultBlockState();
            serverLevel.setBlockAndUpdate(pos, redTulipState);
            // Heal entities within the specified radius
            double radiusSquared = radius * radius;
//            serverLevel.getEntitiesOfClass(Mob.class, new AABB(pos).inflate(radius, radius, radius), mob -> mob.getMobType() == MobType.UNDEAD && !(mob instanceof ZombieVillager))
//                    .forEach(Entity::kill);
            serverLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pos).inflate(radius, radius, radius))
                    .forEach(entity -> {
                        if (entity instanceof LivingEntity) {
                            ((LivingEntity) entity).setHealth(((LivingEntity) entity).getMaxHealth());
                        }
                    });

            // Convert zombie villagers to regular villagers within the specified radius
            serverLevel.getEntitiesOfClass(ZombieVillager.class, new AABB(pos).inflate(radius, radius, radius))
                    .forEach(zombieVillager -> {
                            Villager villager = new Villager(EntityType.VILLAGER, serverLevel);
                            villager.copyPosition(zombieVillager);
                            zombieVillager.discard();
                            serverLevel.addFreshEntity(villager);


                            serverLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pos).inflate(radius, radius, radius))
                                    .forEach(entity -> {

                                        // Play healing sound for Villagers
                                        if (entity instanceof Villager) {
                                            serverLevel.playSound(null, entity.blockPosition(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                                        }
                                    });
                    });
            serverLevel.playSound(null, pos, CustomSoundEvents.GOLDEN_FLOWER.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }
    private static void explodeWizardCake(LevelAccessor world, BlockPos pos, BlockState replacementState) {
        if (world instanceof ServerLevel serverLevel) {
            world.setBlock(pos, replacementState, 3);
            // Создайте взрыв с силой 10 в позиции блока лазурита
            serverLevel.explode(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 4.0F, Explosion.BlockInteraction.BREAK);
        }
    }

    private static void explodeSparkingPollen(LevelAccessor world, BlockPos pos, BlockState replacementState) {
        if (world instanceof ServerLevel serverLevel) {
            world.setBlock(pos, replacementState, 3);

            // Создайте взрыв с силой 10 в позиции блока лазурита
            serverLevel.explode(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 10.0F, Explosion.BlockInteraction.BREAK);
        }
    }

    private static void processBlock(LevelAccessor world, BlockPos pos, BlockState replacementState, Item item, int minStackSize, int maxStackSize, Item particleItem) {
        world.setBlock(pos, replacementState, 3);
        spawnItem(world, pos, item, minStackSize, maxStackSize, particleItem);
        sendParticles(world, pos, particleItem);
    }

    private static void spawnItem(LevelAccessor world, BlockPos pos, Item item, int minStackSize, int maxStackSize, Item particleItem) {
        if (world instanceof Level _level && !_level.isClientSide()) {
            int stackSize = Math.max(minStackSize, new Random().nextInt(maxStackSize - minStackSize + 1) + minStackSize);
            ItemEntity entityToSpawn = new ItemEntity(_level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item, stackSize));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);

            // Добавляем логику создания сущности с Sparkling Pollen с определенной вероятностью
            if (Math.random() < 0.25) {
                ItemEntity pollenEntityToSpawn = new ItemEntity(_level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()));
                pollenEntityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(pollenEntityToSpawn);
            }
            // Добавляем логику создания сущности с частицами, если это необходимо
            if (particleItem != null) {
                sendParticles(world, pos, particleItem);
            }
        }
    }

    private static void sendParticles(LevelAccessor world, BlockPos pos, Item particleItem) {
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), pos.getX(), pos.getY(), pos.getZ(), 36, 0.5, 0.5, 0.5, 0.05f);
        }
    }
}