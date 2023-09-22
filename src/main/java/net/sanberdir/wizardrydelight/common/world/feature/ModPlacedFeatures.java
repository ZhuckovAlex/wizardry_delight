package net.sanberdir.wizardrydelight.common.world.feature;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

import java.util.List;
public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, WizardryDelight.MOD_ID);

    // Кусты
    public static final RegistryObject<PlacedFeature> CHARMING_BERRIES_PLACED = PLACED_FEATURES.register("charming_berries_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHARMING_BERRIES.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(5),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> POISON_BERRY_PLACED = PLACED_FEATURES.register("poison_berry_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.POISON_BERRY.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(5),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> COASTAL_STEEP_PLACED = PLACED_FEATURES.register("coastal_steep_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COASTAL_STEEP.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(5),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> STRANGE_SHIP_ORE_PLACED = PLACED_FEATURES.register("strange_chip_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.STRANGE_SHIP_ORE.getHolder().get(), commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> APPLE_CHECKED = PLACED_FEATURES.register("apple_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.APPLE_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(InitBlocksWD.APPLE_SAPLING.get()))));
    public static final RegistryObject<PlacedFeature> APPLE_PLACED = PLACED_FEATURES.register("apple_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.APPLE_SPAWN.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(45),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> FIRE_STEM_ORE_PLACED = PLACED_FEATURES.register("fire_stem_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FIRE_STEM.getHolder().get(), commonOrePlacement(45, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));

    public static final RegistryObject<PlacedFeature> ROSE_OF_GHOSTY_TEARS_ORE_PLACED = PLACED_FEATURES.register("rose_of_ghosty_tears_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSE_OF_GHOSTY_TEARS.getHolder().get(), commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));
    public static final RegistryObject<PlacedFeature> SPATIAL_ORCHID_PLACED = PLACED_FEATURES.register("spatial_orchid_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SPATIAL_ORCHID.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(15),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> MEADOW_GOLDEN_FLOWER_PLACED = PLACED_FEATURES.register("meadow_golden_flower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MEADOW_GOLDEN_FLOWER.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(30),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> FREEZE_BERRIES_PLACED = PLACED_FEATURES.register("freeze_berries_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FREEZE_BERRIES.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(3),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
