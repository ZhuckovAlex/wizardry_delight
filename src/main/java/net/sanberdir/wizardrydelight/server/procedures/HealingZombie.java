package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HealingZombie {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
    }
    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (Math.random() <= 0.7) {
            if (!world.getEntitiesOfClass(ZombieVillager.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()
                    && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.HEALING_DEW.get().asItem()) {
                if (sourceentity instanceof Player _player) {
                    ItemStack _stktoremove = new ItemStack(InitItemsWD.HEALING_DEW.get());
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
                if (!entity.level.isClientSide())
                    entity.discard();
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = new Villager(EntityType.VILLAGER, _level);
                    entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                    if (entityToSpawn instanceof Mob _mobToSpawn)
                        _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                    world.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 12, 1.5, 1.5, 1.5, 0.2);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            }
        }
        if (Math.random() <= 0.3 && !world.getEntitiesOfClass(ZombieVillager.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()
                && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.HEALING_DEW.get().asItem()) {
            if (sourceentity instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(InitItemsWD.HEALING_DEW.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }
            if (!entity.level.isClientSide())
                entity.discard();
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new Zombie(EntityType.ZOMBIE, _level);
                entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                world.addFreshEntity(entityToSpawn);
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 12, 1.5, 1.5, 1.5, 0.2);
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
        }
    }
}