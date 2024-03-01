package net.sanberdir.wizardrydelight.common.enchant.musketer_speed;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;

@Mod.EventBusSubscriber(modid = WizardryDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, WizardryDelight.MOD_ID);


    public static void register(IEventBus bus) {
        ENCHANTMENTS.register(bus);
    }
}