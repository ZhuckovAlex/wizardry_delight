package net.sanberdir.wizardrydelight.common.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, WizardryDelight.MOD_ID);


    // Цветы
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHARMING_BERRIES = CONFIGURED_FEATURES.register("charming_berries",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.CHARMING_BERRIES_BLOCK.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FREEZE_BERRIES = CONFIGURED_FEATURES.register("freeze_berries",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(12, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.FREEZE_BERRIES.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> POISON_BERRY = CONFIGURED_FEATURES.register("poison_berry",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.POISON_BERRY.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COASTAL_STEEP = CONFIGURED_FEATURES.register("coastal_steep",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.COASTAL_STEEP.get()))))));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> STRANGE_SHIP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), InitBlocksWD.STRANGE_SHIP.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> STRANGE_SHIP_ORE = CONFIGURED_FEATURES.register("strange_chip_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(STRANGE_SHIP_ORES.get(), 5)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> APPLE_TREE =
            CONFIGURED_FEATURES.register("apple_tree", () ->
                    new ConfiguredFeature<>( Feature.TREE, (
                            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(InitBlocksWD.APPLE_LOG.get()),
                                    new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)),
                                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(InitBlocksWD.APPLE_LEAVES.get().defaultBlockState(), 3)
                                            .add(InitBlocksWD.APPLE_LEAVES_NOAPPLE.get().defaultBlockState(), 2)),
                                    new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), ConstantInt.of(2), 50),
                                    new TwoLayersFeatureSize(1, 0, 1))).dirt(BlockStateProvider.simple(Blocks.ROOTED_DIRT)).forceDirt().build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> APPLE_SPAWN =
            CONFIGURED_FEATURES.register("apple_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.APPLE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.APPLE_CHECKED.getHolder().get())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FIRE_STEM = CONFIGURED_FEATURES.register("fire_stem",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(30, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.FIRE_STEM.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSE_OF_GHOSTY_TEARS = CONFIGURED_FEATURES.register("rose_of_ghosty_tears",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(8, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.ROSE_OF_GHOSTY_TEARS.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SPATIAL_ORCHID = CONFIGURED_FEATURES.register("spatial_orchid",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(2, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.SPATIAL_ORCHID.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MEADOW_GOLDEN_FLOWER = CONFIGURED_FEATURES.register("meadow_golden_flower",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(1, 20, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(InitBlocksWD.MEADOW_GOLDEN_FLOWER.get()))))));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
