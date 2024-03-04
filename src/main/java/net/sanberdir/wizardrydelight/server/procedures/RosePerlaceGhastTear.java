package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber

public class RosePerlaceGhastTear {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }
    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocksWD.ROSE_OF_GHOSTY_TEARS.get() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SPONGE) {
            world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            if (entity instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(Items.SPONGE);
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }
            if (entity instanceof Player _player) {
                ItemStack _setstack = new ItemStack(Items.GHAST_TEAR);
                _setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 5, 10));
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
            world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(InitBlocksWD.ROSE_OF_GHOSTY_TEARS.get().defaultBlockState()));
        }
    }

}
