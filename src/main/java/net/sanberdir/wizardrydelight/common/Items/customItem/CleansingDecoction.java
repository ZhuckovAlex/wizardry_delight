package net.sanberdir.wizardrydelight.common.Items.customItem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.sanberdir.wizardrydelight.common.enchant.musketer_speed.EnchantmentInit;

import java.util.Map;

public class CleansingDecoction extends Item {
    public CleansingDecoction(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ClearEnchant(entity, ar.getObject(), hand);
        ClearEnchant2(entity, ar.getObject(), hand);
        return ar;
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public boolean isRepairable(ItemStack itemstack) {
        return false;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }

    public static void ClearEnchant(Entity entity, ItemStack stack, InteractionHand hand) {
        if (entity == null)
            return;

        ItemStack itemInHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
        Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemInHand);

        if (!_enchantments.isEmpty()) {
            Enchantment enchantmentToRemove = _enchantments.keySet().iterator().next();
            _enchantments.remove(enchantmentToRemove);
            EnchantmentHelper.setEnchantments(_enchantments, itemInHand);
            if (entity instanceof LivingEntity) {
                stack.hurtAndBreak(1, (LivingEntity) entity, e -> e.broadcastBreakEvent(hand));
            }
        }
    }
    public static void ClearEnchant2(Entity entity, ItemStack stack, InteractionHand hand) {
        if (entity == null)
            return;

        ItemStack itemInHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
        Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemInHand);

        if (!_enchantments.isEmpty()) {
            Enchantment enchantmentToRemove = _enchantments.keySet().iterator().next();
            _enchantments.remove(enchantmentToRemove);
            EnchantmentHelper.setEnchantments(_enchantments, itemInHand);
            if (entity instanceof LivingEntity) {
                stack.hurtAndBreak(1, (LivingEntity) entity, e -> e.broadcastBreakEvent(hand));
            }
        }
    }
}
