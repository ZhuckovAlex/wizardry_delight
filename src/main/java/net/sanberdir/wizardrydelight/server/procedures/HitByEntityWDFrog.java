package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;

public class HitByEntityWDFrog {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!world.getEntitiesOfClass(Creeper.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
            if (!entity.level.isClientSide())
                entity.discard();
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new Frog(EntityType.FROG, _level);
                entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                world.addFreshEntity(entityToSpawn);
            }
            if (Math.random() < 0.35) {
                if (world instanceof Level _level && !_level.isClientSide()) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), x, y, z, 36, 0.5, 0.5, 0.5, 0.05f);
        }
        if (!world.getEntitiesOfClass(Witch.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
            if (!entity.level.isClientSide())
                entity.discard();
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new Frog(EntityType.FROG, _level);
                entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                world.addFreshEntity(entityToSpawn);
            }
            if (Math.random() < 0.35) {
                if (world instanceof Level _level && !_level.isClientSide()) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), x, y, z, 36, 0.5, 0.5, 0.5, 0.05f);
        }
        if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
            if (!entity.level.isClientSide())
                entity.discard();
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new Frog(EntityType.FROG, _level);
                entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                world.addFreshEntity(entityToSpawn);
            }
            if (Math.random() < 0.35) {
                if (world instanceof Level _level && !_level.isClientSide()) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.ambient")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), x, y, z, 36, 0.5, 0.5, 0.5, 0.05f);
        }
    }
}
