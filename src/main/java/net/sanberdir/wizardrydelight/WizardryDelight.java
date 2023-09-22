package net.sanberdir.wizardrydelight;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.ModWoodType;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;
import net.sanberdir.wizardrydelight.common.world.feature.ModConfiguredFeatures;
import net.sanberdir.wizardrydelight.common.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WizardryDelight.MOD_ID)
public class WizardryDelight
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "wizardry_delight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

   public WizardryDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        InitItemsWD.register(modEventBus);
        InitBlocksWD.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () ->  SlotTypePreset.RING.getMessageBuilder().build());
            WoodType.register(ModWoodType.APPLE_WOOD);
        });
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
