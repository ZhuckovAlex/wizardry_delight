package net.sanberdir.wizardrydelight.common.Items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;

import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.customItem.*;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.client.ModCreativeTab;
import net.sanberdir.wizardrydelight.common.sounds.CustomSoundEvents;


public class InitItemsWD {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WizardryDelight.MOD_ID);


    //Еда

    //    public static final RegistryObject<Item> SLICING_FROM_COCKED_BEAR_MEAT = ITEMS.register("slicing_from_cocked_bear_meat",
//            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6f)
//                    .build())));
    //    public static final RegistryObject<Item> SLICING_FROM_RAW_BEAR_MEAT = ITEMS.register("slicing_from_raw_bear_meat",
//            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.7f).alwaysEat().fast()
//                    .build())));

    public static final RegistryObject<Item> POISON_BERRY = ITEMS.register("poison_berry",
            () -> new ItemNameBlockItem(InitBlocksWD.POISON_BERRY.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat().fast()
                            .effect(new MobEffectInstance(MobEffects.POISON, 80, 0), 0.5F)
                            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 0.5F)
                            .build()))));
    public static final RegistryObject<Item> CHARMING_BERRIES = ITEMS.register("charming_berries",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.HARM, 10, 0), 0.7F)
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0), 0.5F)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 2), 0.3F)
                    .build())));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Cheese(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(20).saturationMod(1f)
                    .build())));
    public static final RegistryObject<Item> FREEZE_JAM = ITEMS.register("freeze_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(10).saturationMod(0.3f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0), 0.9F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2200, 0), 0.7F)
                    .build())));
    public static final RegistryObject<Item> FROG_BODY = ITEMS.register("frog_body",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(1).saturationMod(0.5f)
                    .effect(new MobEffectInstance(MobEffects.POISON, 40, 0), 0.6F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.9F)
                    .build())));
    public static final RegistryObject<Item> CHEESE_1 = ITEMS.register("cheese_1",
            () -> new Cheese1(new Item.Properties().food(new FoodProperties.Builder().nutrition(20).saturationMod(1f)
                    .build())));
    public static final RegistryObject<Item> CHEESE_2 = ITEMS.register("cheese_2",
            () -> new Cheese2(new Item.Properties().food(new FoodProperties.Builder().nutrition(20).saturationMod(1f)
                    .build())));
    public static final RegistryObject<Item> CHARMING_JAM = ITEMS.register("charming_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(10).saturationMod(0.3f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 0.2F)
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 0.4F)
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 0), 0.6F)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 840, 2), 0.7F)
                    .build())));
    public static final RegistryObject<Item> FREEZE_BERRIES = ITEMS.register("freeze_berries",
            () -> new ItemNameBlockItem(InitBlocksWD.FREEZE_BERRIES.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1), 0.8F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 280, 0), 0.7F)
                    .build()))));
    public static final RegistryObject<Item> SOUP_FROM_BEAR = ITEMS.register("soup_from_bear",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(12).saturationMod(0.7f).alwaysEat().fast()
                    .build())));
    public static final RegistryObject<Item> COCKED_BEAR_MEAT = ITEMS.register("cocked_bear_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> COCKED_HORSE = ITEMS.register("cocked_horse",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> COCKED_SHPIKACHKI = ITEMS.register("cocked_shpikachki",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> SHPIKACHKI = ITEMS.register("shpikachki",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(4).saturationMod(0.3f)
                    .build())));
    public static final RegistryObject<Item> COCKED_SLISING_GOATS_MEAT = ITEMS.register("cocked_slising_goats_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(5).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> COCKED_FROG = ITEMS.register("cocked_frog",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(6).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> FROG_LEGS = ITEMS.register("frog_legs",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(1).saturationMod(0.1f)
                    .build())));
    public static final RegistryObject<Item> GLOWING_JAM = ITEMS.register("glowing_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(14).saturationMod(0.5f)
                    .effect(new MobEffectInstance(MobEffects.GLOWING, 220, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> MUSHROOM_ON_STICK = ITEMS.register("mushroom_on_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.1f)
                    .effect(new MobEffectInstance(MobEffects.POISON, 120, 0), 0.6F)
                    .alwaysEat()
                    .build())));
    public static final RegistryObject<Item> COCKED_MUSHROOM_ON_STICK = ITEMS.register("cocked_mushroom_on_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6f).alwaysEat()
                    .build())));
    public static final RegistryObject<Item> GOAT_MEAT_KEBAB = ITEMS.register("goat_meat_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(2).saturationMod(0.2f)
                    .build())));
    public static final RegistryObject<Item> COCKED_GOAT_MEAT_KEBAB = ITEMS.register("cocked_goat_meat_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(10).saturationMod(0.8f)
                    .build())));
    public static final RegistryObject<Item> COCKED_FROG_LEGS = ITEMS.register("cocked_frog_legs",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(3).saturationMod(0.3f)
                    .build())));
    public static final RegistryObject<Item> COCKED_GOATS_MEAT = ITEMS.register("cocked_goats_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(8).saturationMod(0.4f)
                    .build())));
    public static final RegistryObject<Item> THROWING_KNIFE = ITEMS.register("throwing_knife",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> TURTLE_SOUP = ITEMS.register("turtle_soup",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(7).saturationMod(0.4f)
                    .build())));
    public static final RegistryObject<Item> CLEANED_TURTLE_NECK = ITEMS.register("cleaned_turtle_neck",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(2).saturationMod(0.4f)
                    .build())));
    public static final RegistryObject<Item> PICKLED_TURTLE_NECK = ITEMS.register("pickled_turtle_neck",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(5).saturationMod(0.4f)
                    .build())));

    public static final RegistryObject<Item> TURTLE_NECK = ITEMS.register("turtle_neck",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.4f)
                    .build())));
    public static final RegistryObject<Item> HOT_COCOA_WITH_SPARKING_POLLEN = ITEMS.register("hot_cocoa_with_sparkling_pollen",
            () -> new MinusEffectBeneficialDrink(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(6).saturationMod(0.2f)
                    .build())));
    public static final RegistryObject<Item> HUNTING_TWISTER = ITEMS.register("hunting_twister",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(14).saturationMod(0.7f)
                    .build())));
    public static final RegistryObject<Item> IRIS = ITEMS.register("iris",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.2f)
                    .fast()
                    .build())));
    public static final RegistryObject<Item> JAM_INVISIBILITY = ITEMS.register("jam_invisibility",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(12).saturationMod(0.55f)
                    .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 4800, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> JAM_TONIC = ITEMS.register("jam_tonic",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(9).saturationMod(0.7f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 10), 1F)
                    .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 4800, 4), 1F)
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 5000, 8), 1F)
                    .build())));
    public static final RegistryObject<Item> KRUTNEVY_BREAD = ITEMS.register("krutnevy_bread",
            () -> new MinusEffectBeneficial(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.45f)
                    .build())));
    public static final RegistryObject<Item> LEVITAN_JAM = ITEMS.register("levitan_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(15).saturationMod(0.4f)
                    .effect(new MobEffectInstance(MobEffects.LEVITATION, 4, 100), 1F)
                    .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 10), 1F)
                    .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2000, 0), 0.4F)
                    .build())));
    public static final RegistryObject<Item> APPLE_JAM = ITEMS.register("apple_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(9).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> BEAR_MEAT_SOUP = ITEMS.register("bear_meat_soup",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(9).saturationMod(0.8f)
                    .build())));
    public static final RegistryObject<Item> MEDICAL_POTATO = ITEMS.register("medical_potato",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).alwaysEat()
                    .effect(new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2f)
                    .build()).fireResistant()));
    public static final RegistryObject<Item> GOULASH_WITH_GOAT_MEAT = ITEMS.register("goulash_with_goat_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(10).saturationMod(0.7f)
                    .build())));
    public static final RegistryObject<Item> SWEET_ROLL = ITEMS.register("sweet_roll",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(18).saturationMod(0.8f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 720, 2), 1F)
                    .build())));
    public static final RegistryObject<Item> SPAGETTI_IN_THE_NORTH = ITEMS.register("spaghetti_in_the_north",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(12).saturationMod(0.8f)
                    .build())));
    public static final RegistryObject<Item> RAW_BEAR_MEAT = ITEMS.register("raw_bear_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(2).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> RAW_GOATS_MEAT = ITEMS.register("raw_goats_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(3).saturationMod(0.09f)
                    .build())));
    public static final RegistryObject<Item> RAW_SLISING_GOATS_MEAT = ITEMS.register("raw_slising_goats_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.04f)
                    .build())));
    public static final RegistryObject<Item> RAW_HORSE = ITEMS.register("raw_horse",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().meat().nutrition(3).saturationMod(0.09f)
                    .build())));
    public static final RegistryObject<Item> POISON_BERRY_JAM = ITEMS.register("poison_berry_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(13).saturationMod(0.3f)
                    .effect(new MobEffectInstance(MobEffects.POISON, 180, 0), 1F)
                    .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3300, 4), 0.95F)
                    .build())));
    public static final RegistryObject<Item> SUGAR_REFINED = ITEMS.register("sugar_refined",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5f)
                    .build())));
    public static final RegistryObject<Item> SWEET_JAM = ITEMS.register("sweet_jam",
            () -> new Jam(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().alwaysEat().nutrition(9).saturationMod(0.6f)
                    .build())));


    //Предметы


    public static final RegistryObject<Item> ROSE_OF_THE_MURDERER = ITEMS.register("rose_of_the_murderer",
            () -> new ItemNameBlockItem(InitBlocksWD.ROSE_OF_THE_MURDERER.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant())));
    public static final RegistryObject<Item> SILVERAN = ITEMS.register("silveran",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> SOUL_CORE = ITEMS.register("soul_core",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> COASTAL_STEEP = ITEMS.register("coastal_steep",
            () -> new ItemNameBlockItem(InitBlocksWD.COASTAL_STEEP.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> WIZARD_PIE = ITEMS.register("wizard_pie",
            () -> new ItemNameBlockItem(InitBlocksWD.WIZARD_PIE.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> COASTAL_STEEP_W = ITEMS.register("coastal_steep_w",
            () -> new ItemNameBlockItem(InitBlocksWD.COASTAL_STEEP_W.get(),(new Item.Properties())));
    public static final RegistryObject<Item> COASTAL_STEEP_FLOWER = ITEMS.register("coastal_steep_flower",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> COASTAL_STEEP_FIBERS = ITEMS.register("coastal_steep_fibers",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> CRIMSON_BONE_MEAL = ITEMS.register("crimson_bone_meal",
            () -> new AnimateItem(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> WARPED_BONE_MEAL = ITEMS.register("warped_bone_meal",
            () -> new AnimateItem(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> SOUL_STONE_CHARGED = ITEMS.register("soul_stone_charged",
            () -> new SoulStoneActive(new Item.Properties().craftRemainder(WizardryDelight.SOUL_STONE_DISCHARGED.get()).stacksTo(1)));
    public static final RegistryObject<Item> FIRE_STEM = ITEMS.register("fire_stem",
            () -> new ItemNameBlockItem(InitBlocksWD.FIRE_STEM.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> WD_SPAWNER = ITEMS.register("wd_spawner",
            () -> new WDSpawner(InitBlocksWD.WD_SPAWNER.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> ROSE_OF_GHOSTY_TEARS = ITEMS.register("rose_of_ghosty_tears",
            () -> new RoseGhostyTears(InitBlocksWD.ROSE_OF_GHOSTY_TEARS.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant())));
    public static final RegistryObject<Item> SPATIAL_ORCHID = ITEMS.register("spatial_orchid",
            () -> new ItemNameBlockItem(InitBlocksWD.SPATIAL_ORCHID.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> MEADOW_GOLDEN_FLOWER = ITEMS.register("meadow_golden_flower",
            () -> new ItemNameBlockItem(InitBlocksWD.MEADOW_GOLDEN_FLOWER.get(),(new Item.Properties().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> MEADOW_GOLDEN_FLOWER_INACTIVE = ITEMS.register("meadow_golden_flower_inactive",
            () -> new ItemNameBlockItem(InitBlocksWD.MEADOW_GOLDEN_FLOWER_INACTIVE.get(),(new Item.Properties())));
    public static final RegistryObject<Item> STRANGE_SCRAP = ITEMS.register("strange_scrap",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> CLEAR_DRAGOLIT_NUGGET = ITEMS.register("clear_dragolit_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> DRAGOLIT_INGOT = ITEMS.register("dragolit_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> EGG_OFF_A_MOTTLED_CHICKEN = ITEMS.register("egg_of_a_mottled_chicken",
            () -> new EggMottled(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> JAR = ITEMS.register("jar",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> GOLDEN_CHEST_KING_PILLAGER = ITEMS.register("golden_chest_king_pillager",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> GOLDEN_RUNO = ITEMS.register("golden_runo",
            () -> new GoldenRuno(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> HAT_HELMET = ITEMS.register("hat_helmet",
            () -> new HatArmorItem(ModArmorMaterials.HAT, EquipmentSlot.HEAD,
                    new Item.Properties().durability(105).tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> HAT_HELMET_CLEAR = ITEMS.register("hat_helmet_clear",
            () -> new ClearHatArmorItem(ModArmorMaterials.HAT_CLEAR, EquipmentSlot.HEAD,
                    new Item.Properties().durability(105).tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> HEALING_DEW = ITEMS.register("healing_dew",
            () -> new HealingDew(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> CLEANING_DECOCTION = ITEMS.register("cleansing_decoction",
            () -> new CleansingDecoction(new Item.Properties().tab(ModCreativeTab.BUSHES).durability(12)));
    public static final RegistryObject<Item> A_DROP_OF_LOVE = ITEMS.register("a_drop_of_love",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> FLAME_ARROW = ITEMS.register("flame_arrow",
            () -> new FlameArrowItem(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> DRAGOLIT_BLOCK = ITEMS.register("dragolit_block",
            () -> new ItemNameBlockItem(InitBlocksWD.DRAGOLIT_BLOCK.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
    public static final RegistryObject<Item> DRAGOLIT_GRID = ITEMS.register("dragolit_grid",
            () -> new ItemNameBlockItem(InitBlocksWD.DRAGOLIT_GRID.get(),(new Item.Properties().fireResistant().tab(ModCreativeTab.BUSHES))));
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
    public static final RegistryObject<Item> HANDFUL_YADOGA = ITEMS.register("handful_yadoga",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> WIZARDRY_DELIGHT_JAM = ITEMS.register("wizardry_delight_jam",
            () -> new RecordItem(8, CustomSoundEvents.WIZARDRY_DELIGHT_JAM.get() ,new Item.Properties().stacksTo(1).tab(ModCreativeTab.BUSHES),16));
    public static final RegistryObject<Item>  NOT_PICKLED_SHISH_KEBAB = ITEMS.register("not_pickled_shish_kebab",
            () -> new NotPickledKebab(new Item.Properties().durability(1500)));
    public static final RegistryObject<Item>  PICKLED_SHISH_KEBAB = ITEMS.register("pickled_shish_kebab",
            () -> new PickledKebab(new Item.Properties().tab(ModCreativeTab.BUSHES).craftRemainder(Items.FLOWER_POT)));
    public static final RegistryObject<Item> SPAGA_DRACOLIT = ITEMS.register("spaga_dragolit",
            () -> new Rapier(Tiers.NETHERITE, -2,-1.6f,new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> THE_PILLAGERS_CHEST = ITEMS.register("the_pillagers_chest",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> THE_PILLAGERS_KEY = ITEMS.register("the_pillagers_key",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> THE_KING_PILLAGERS_KEY = ITEMS.register("the_king_pillagers_key",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> RING_RESERVATION_LIVE = ITEMS.register("ring_reservation_life",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> RING_RESERVATION_LIVE_CHANGED = ITEMS.register("ring_reservation_life_changed",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> ROBIN_STICK = ITEMS.register("robin_stick",
            () -> new StarBallItem(new Item.Properties().tab(ModCreativeTab.BUSHES).durability(70)));
    public static final RegistryObject<Item> STAR_BALL = ITEMS.register("star_ball",
            () -> new StarBallItem(new Item.Properties()));
    public static final RegistryObject<Item> HANDFUL_NETHER = ITEMS.register("handful_nether",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> ROAST_GOAT_MEAT_WITH_FREEZE_BERRIES_SYRUP = ITEMS.register("roast_goat_meat_with_freeze_berries_syrup",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.BUSHES).food(new FoodProperties.Builder().nutrition(12).saturationMod(0.6f)
                    .build())));
    public static final RegistryObject<Item> RING_SUPPLY = ITEMS.register("ring_supply",
            () -> new RingSupply(new Item.Properties().stacksTo(1).durability(40).tab(ModCreativeTab.BUSHES).fireResistant()));
    public static final RegistryObject<Item> RING_SUPPLY_DISCHARGED = ITEMS.register("ring_supply_discharged",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeTab.BUSHES).fireResistant()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
