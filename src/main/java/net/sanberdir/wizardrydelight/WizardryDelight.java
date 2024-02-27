package net.sanberdir.wizardrydelight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.client.ModCreativeTab;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.Items.ModArmorMaterials;
import net.sanberdir.wizardrydelight.common.Items.customItem.AppleBoat;
import net.sanberdir.wizardrydelight.common.Items.customItem.AppleChestBoat;
import net.sanberdir.wizardrydelight.common.Items.customItem.ModElytra;
import net.sanberdir.wizardrydelight.common.Items.customItem.SoulStoneDeactive;
import net.sanberdir.wizardrydelight.common.ModWoodType;
import net.sanberdir.wizardrydelight.common.armor.elytra.DragoliteElytraArmorStandLayer;
import net.sanberdir.wizardrydelight.common.armor.elytra.DragoliteElytraLayer;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.WDBlockEntities;
import net.sanberdir.wizardrydelight.common.entity.ModEntities;
import net.sanberdir.wizardrydelight.common.entity.type_blocks_item.EntityTypeInitializer;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.common.sounds.CustomSoundEvents;
import net.sanberdir.wizardrydelight.common.world.feature.ModConfiguredFeatures;
import net.sanberdir.wizardrydelight.common.world.feature.ModPlacedFeatures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WizardryDelight.MOD_ID)
public class WizardryDelight
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "wizardry_delight";
    // Directly reference a slf4j logger
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final Logger LOGGER = LogManager.getLogger();
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> SOUL_STONE_DISCHARGED = ITEMS.register("soul_stone_discharged", () -> new SoulStoneDeactive(new Item.Properties().stacksTo(1).tab(ModCreativeTab.BUSHES)));
    public static final RegistryObject<Item> MAG_ELITRA =  ITEMS.register("mag_elitra", () ->new ModElytra(ModArmorMaterials.ELITRA, EquipmentSlot.CHEST, new Item.Properties().durability(1200).tab(ModCreativeTab.BUSHES).fireResistant()));

    // Directly reference a slf4j logger


    // Network channel

   public WizardryDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        if(FMLEnvironment.dist.isClient()) modEventBus.addListener(this::registerElytraLayer);
        // Register the Deferred Register to the mod event bus so blocks get registered
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        InitItemsWD.register(modEventBus);
        InitBlocksWD.register(modEventBus);
        ModParticles.register(modEventBus);
        ModEntities.register(modEventBus);
        CustomSoundEvents.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        WDBlockEntities.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegisterEvent registerEvent) {
            registerEvent.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, registrar -> {


                // All sign block entities

            });
        }
        @SubscribeEvent
        public static void onBlocksRegistry(final RegisterEvent registryEvent) {
            registryEvent.register(ForgeRegistries.Keys.BLOCKS, registrar -> {

            });
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegisterEvent registerEvent) {
            registerEvent.register(ForgeRegistries.Keys.ITEMS, registrar -> {
                registrar.register(new ResourceLocation(WizardryDelight.MOD_ID, "apple_boat"), new AppleBoat());
                registrar.register(new ResourceLocation(WizardryDelight.MOD_ID, "apple_chest_boat"), new AppleChestBoat());
            });
        }
        @SubscribeEvent
        public static void onEntityRegistry(final RegisterEvent registerEvent) {
            registerEvent.register(ForgeRegistries.Keys.ENTITY_TYPES, registrar -> {
                // All vehicle entities

                registrar.register(new ResourceLocation(WizardryDelight.MOD_ID, "mod_boat_entity"), EntityTypeInitializer.BOAT_ENTITY_TYPE);
                registrar.register(new ResourceLocation(WizardryDelight.MOD_ID, "mod_chest_boat_entity"), EntityTypeInitializer.CHEST_BOAT_ENTITY_TYPE);
            });
        }


    }
    @OnlyIn(Dist.CLIENT)
    private void registerElytraLayer(EntityRenderersEvent event) {
        if(event instanceof EntityRenderersEvent.AddLayers addLayersEvent){
            EntityModelSet entityModels = addLayersEvent.getEntityModels();
            addLayersEvent.getSkins().forEach(s -> {
                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = addLayersEvent.getSkin(s);
                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
                    playerRenderer.addLayer(new DragoliteElytraLayer(playerRenderer, entityModels));
                }
            });
            LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = addLayersEvent.getRenderer(EntityType.ARMOR_STAND);
            if(livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer){
                armorStandRenderer.addLayer(new DragoliteElytraArmorStandLayer(armorStandRenderer, entityModels));
            }

        }
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {


        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () ->  SlotTypePreset.RING.getMessageBuilder().build());
            WoodType.register(ModWoodType.APPLE_WOOD);
        });
    }
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }
    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemProperties.register(WizardryDelight.MAG_ELITRA.get(), new ResourceLocation(MOD_ID, "broken"),
                    (stack, arg1, arg2, arg3) -> ModElytra.isUseable(stack) ? 0 : 1);
            event.enqueueWork(() -> {
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.COASTAL_STEEP_FLOWER.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.COASTAL_STEEP_FIBERS.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.COASTAL_STEEP.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.CHARMING_BERRIES.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.FIRE_STEM.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsWD.ROSE_OF_GHOSTY_TEARS.get(), 0.2f);
            });
        }
    }
}
