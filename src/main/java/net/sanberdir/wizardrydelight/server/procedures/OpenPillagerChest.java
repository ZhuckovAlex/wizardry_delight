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
public class OpenPillagerChest {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        getDropPillagerChest(event.getEntity());
    }

    public static void getDropPillagerChest(Entity entity) {
        if (entity == null)
            return;

        if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(InitItemsWD.THE_PILLAGERS_KEY.get())) : false)
                && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.THE_PILLAGERS_CHEST.get().asItem()) {

            if (entity instanceof Player _player) {
                removeItemFromPlayerInventory(_player, new ItemStack(InitItemsWD.THE_PILLAGERS_KEY.get()), 1);
                removeItemFromPlayerInventory(_player, new ItemStack(InitItemsWD.THE_PILLAGERS_CHEST.get()), 1);
            }
            handleRandomItemDrop(entity, Items.DIAMOND, 0.07, 1, 2);
            handleRandomItemDrop(entity, Items.BONE, 0.8, 2, 10);
            handleRandomItemDrop(entity, Items.COAL, 0.6, 2, 10);
            handleRandomItemDrop(entity, InitItemsWD.THROWING_KNIFE.get(), 0.15, 2, 10);
            handleRandomItemDrop(entity, Items.ARROW, 0.6, 3, 32);
            handleRandomItemDrop(entity, Items.RAW_IRON, 0.7, 2, 8);
            handleRandomItemDrop(entity, InitItemsWD.CHEESE.get(), 1, 1, 1);
            // Добавляем выпадение 5 единиц опыта
            if (entity instanceof Player _playerWithExperience) {
                _playerWithExperience.giveExperiencePoints(5);
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