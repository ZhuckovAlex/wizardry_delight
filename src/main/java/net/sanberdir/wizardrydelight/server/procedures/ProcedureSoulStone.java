package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;

@Mod.EventBusSubscriber

public class ProcedureSoulStone {


    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;


        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.SOUL_STONE_CHARGED.get()) {
            if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.PLAINS : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
           else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.NETHER : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.DESERT : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.CAVE : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.CROP : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.WATER : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.BEACH : false) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            else {

                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x + 0.5, y + 1, z + 0.5), Vec2.MIN, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            ("summon " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("entity"))));
            }
            if (entity instanceof LivingEntity _entity) {
                ItemStack _setstack = new ItemStack(WizardryDelight.SOUL_STONE_DISCHARGED.get());
                _setstack.setCount(1);
                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                if (_entity instanceof Player _player)
                    _player.getInventory().setChanged();
            }
        }
    }
}