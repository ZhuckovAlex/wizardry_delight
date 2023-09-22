package net.sanberdir.wizardrydelight.common.Items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.customItem.RingSupply;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.client.ModCreativeTab;
import net.sanberdir.wizardrydelight.common.Items.customItem.AnimateItem;
import net.sanberdir.wizardrydelight.common.Items.customItem.BurnFences;


public class InitItemsWD {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WizardryDelight.MOD_ID);

    public static final RegistryObject<Item> POISON_BERRY = ITEMS.register("poison_berry",
            () -> new ItemNameBlockItem(InitBlocksWD.POISON_BERRY.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.POISON, 80, 0), 1F)
                    .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1F)
                    .build()))));
    public static final RegistryObject<Item> CHARMING_BERRIES = ITEMS.register("charming_berries",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.HARM, 10, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> FREEZE_BERRIES = ITEMS.register("freeze_berries",
            () -> new ItemNameBlockItem(InitBlocksWD.FREEZE_BERRIES.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0), 1F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1F)
                    .build()))));
    public static final RegistryObject<Item> COASTAL_STEEP = ITEMS.register("coastal_steep",
            () -> new ItemNameBlockItem(InitBlocksWD.COASTAL_STEEP.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> COASTAL_STEEP_W = ITEMS.register("coastal_steep_w",
            () -> new ItemNameBlockItem(InitBlocksWD.COASTAL_STEEP_W.get(),(new Item.Properties())));
    public static final RegistryObject<Item> COASTAL_STEEP_FIBERS = ITEMS.register("coastal_steep_fibers",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> COASTAL_STEEP_FLOWER = ITEMS.register("coastal_steep_flower",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> CRIMSON_BONE_MEAL = ITEMS.register("crimson_bone_meal",
            () -> new AnimateItem(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> WARPED_BONE_MEAL = ITEMS.register("warped_bone_meal",
            () -> new AnimateItem(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> FIRE_STEM = ITEMS.register("fire_stem",
            () -> new ItemNameBlockItem(InitBlocksWD.FIRE_STEM.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> ROSE_OF_GHOSTY_TEARS = ITEMS.register("rose_of_ghosty_tears",
            () -> new ItemNameBlockItem(InitBlocksWD.ROSE_OF_GHOSTY_TEARS.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant())));
    public static final RegistryObject<Item> SPATIAL_ORCHID = ITEMS.register("spatial_orchid",
            () -> new ItemNameBlockItem(InitBlocksWD.SPATIAL_ORCHID.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> MEADOW_GOLDEN_FLOWER = ITEMS.register("meadow_golden_flower",
            () -> new ItemNameBlockItem(InitBlocksWD.MEADOW_GOLDEN_FLOWER.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> STRANGE_SCRAP = ITEMS.register("strange_scrap",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> CLEAR_DRAGOLIT_NUGGET = ITEMS.register("clear_dragolit_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> DRAGOLIT_INGOT = ITEMS.register("dragolit_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));

    public static final RegistryObject<Item> DRAGOLIT_BLOCK = ITEMS.register("dragolit_block",
            () -> new ItemNameBlockItem(InitBlocksWD.DRAGOLIT_BLOCK.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> DRAGOLIT_GRID = ITEMS.register("dragolit_grid",
            () -> new ItemNameBlockItem(InitBlocksWD.DRAGOLIT_GRID.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));

    public static final RegistryObject<Item> MEDICAL_POTATO = ITEMS.register("medical_potato",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).alwaysEat()
                    .effect(new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> APPLE_FENCE_GATE = ITEMS.register("apple_fence_gate",
            () -> new BurnFences(InitBlocksWD.APPLE_FENCE_GATE.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));


    public static final RegistryObject<Item> APPLE_PRESSURE_PLATE = ITEMS.register("apple_pressure_plate",
            () -> new BurnFences(InitBlocksWD.APPLE_PRESSURE_PLATE.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));

    public static final RegistryObject<Item> APPLE_FENCE = ITEMS.register("apple_fence",
            () -> new BurnFences(InitBlocksWD.APPLE_FENCE.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> APPLE_LEAVES = ITEMS.register("apple_leaves",
            () -> new ItemNameBlockItem(InitBlocksWD.APPLE_LEAVES.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> APPLE_LEAVES_NOAPPLE = ITEMS.register("apple_leaves_noapple",
            () -> new ItemNameBlockItem(InitBlocksWD.APPLE_LEAVES_NOAPPLE.get(),(new Item.Properties())));
    public static final RegistryObject<Item> APPLE_SAPLING = ITEMS.register("apple_sapling",
            () -> new ItemNameBlockItem(InitBlocksWD.APPLE_SAPLING.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> WARPED_WART = ITEMS.register("warped_wart",
            () -> new ItemNameBlockItem(InitBlocksWD.WARPED_WART.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> SPARKLING_POLLEN = ITEMS.register("sparkling_pollen",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> RING_SUPPLY = ITEMS.register("ring_supply",
            () -> new RingSupply(new Item.Properties().stacksTo(1).durability(40).tab(ModCreativeTab.BUSHES).fireResistant()));

    public static final RegistryObject<Item> MUSHROOM_ON_STICK = ITEMS.register("mushroom_on_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).alwaysEat()
                    .build())));
    public static final RegistryObject<Item> COCKED_MEDICAL_POTATO = ITEMS.register("cocked_mushroom_on_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).alwaysEat()
                    .build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
