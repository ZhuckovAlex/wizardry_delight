package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mod.EventBusSubscriber
public class OpenPillagerKIngChest {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        getDropPillagerChest(event.getEntity());
    }

    public static void getDropPillagerChest(Entity entity) {
        if (entity == null)
            return;

        if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(InitItemsWD.THE_KING_PILLAGERS_KEY.get())) : false)
                && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.GOLDEN_CHEST_KING_PILLAGER.get().asItem()) {

            if (entity instanceof Player _player) {
                removeItemFromPlayerInventory(_player, new ItemStack(InitItemsWD.THE_KING_PILLAGERS_KEY.get()), 1);
                removeItemFromPlayerInventory(_player, new ItemStack(InitItemsWD.GOLDEN_CHEST_KING_PILLAGER.get()), 1);
            }
            handleRandomItemDrop(entity, Items.DIAMOND, 0.6, 1, 5);
            handleRandomItemDrop(entity, Items.EMERALD, 0.8, 3, 16);
            handleRandomItemDrop(entity, Items.GOLD_INGOT, 1, 4, 16);
            handleRandomItemDrop(entity, InitItemsWD.A_DROP_OF_LOVE.get(), 0.5, 1, 2);
            handleRandomItemDrop(entity, InitItemsWD.CHEESE.get(), 1, 1, 2);
            if (entity instanceof Player _playerWithExperience) {
                _playerWithExperience.giveExperiencePoints(500);
            }
        }
    }
    private static void removeItemFromPlayerInventory(Player player, ItemStack itemStack, int quantity) {
        player.getInventory().clearOrCountMatchingItems(p -> itemStack.getItem() == p.getItem(), quantity, player.inventoryMenu.getCraftSlots());
    }

    private static void handleRandomItemDrop(Entity entity, Item item, double chance, int minQuantity, int maxQuantity) {
        if (Math.random() <= chance) {
            if (entity instanceof Player _player) {
                ItemStack itemStack = new ItemStack(item);
                int quantity = (int) Mth.nextDouble(RandomSource.create(), minQuantity, maxQuantity);
                itemStack.setCount(quantity);
                ItemEntity itemEntity = new ItemEntity(entity.level, entity.getX(), entity.getY(), entity.getZ(), itemStack);
                entity.level.addFreshEntity(itemEntity);
            }
        }
    }
}