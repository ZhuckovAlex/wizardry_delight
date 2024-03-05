package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import net.minecraft.world.level.block.state.properties.Property;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;


import java.util.Random;

public class HitByBlock {

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        BlockPos pos = new BlockPos(x, y, z);
        Block block = world.getBlockState(pos).getBlock();
        Random random = new Random();

        if (block == InitBlocksWD.COASTAL_STEEP.get()) {
            if (random.nextDouble() < 0.15) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.KRUTNEVY_BREAD.get(), 1, 3,InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.COCOA) {
            Property<?> ageProperty = blockstate.getBlock().getStateDefinition().getProperty("age");
            if (ageProperty instanceof IntegerProperty) {
                IntegerProperty integerAgeProperty = (IntegerProperty) ageProperty;
                int ageValue = blockstate.getValue(integerAgeProperty);
                if (ageValue >= 2 && random.nextDouble() < 0.15) { // Шанс 15%
                    processBlock(world, pos, Blocks.AIR.defaultBlockState(), InitItemsWD.HOT_COCOA_WITH_SPARKING_POLLEN.get(), 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
                }
            }
        } else if (block == Blocks.BEE_NEST) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.15) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.HONEYCOMB_BLOCK) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.15) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.HONEY_BOTTLE, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
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
        } else if (block == Blocks.RED_MUSHROOM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.BROWN_MUSHROOM) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.MUSHROOM_STEW, 1, 3, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == Blocks.GRASS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 2, 3, InitItemsWD.SPARKLING_POLLEN.get());
            }
        } else if (block == Blocks.FERN) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.WHEAT, 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
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
        } else if (block == ModBlocks.SANDY_SHRUB.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.HOT_COCOA.get(), 1, 1, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.BEETROOT_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.BEETROOT_SOUP, 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.CARROT_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
        } else if (block == ModBlocks.POTATO_CRATE.get()) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), ModItems.STUFFED_POTATO.get(), 3, 9, InitItemsWD.SPARKLING_POLLEN.get());
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
        } else if (block == Blocks.CARROTS) {
            processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            if (random.nextDouble() < 0.3) { // Шанс 15%
                processBlock(world, pos, Blocks.AIR.defaultBlockState(), Items.GOLDEN_CARROT, 1, 2, InitItemsWD.SPARKLING_POLLEN.get());
            }
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
        }
        // Добавьте аналогичные проверки для других блоков, если это необходимо
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