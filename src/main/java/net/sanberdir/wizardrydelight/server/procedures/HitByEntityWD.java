package net.sanberdir.wizardrydelight.server.procedures;


import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken2;
import net.sanberdir.wizardrydelight.common.entity.fat_pig.custom.FatPig;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow2;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class HitByEntityWD {

    private static final Map<Class<? extends Entity>, EntityBehaviour> ENTITY_BEHAVIOURS = Map.ofEntries(
            Map.entry(Pig.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_PORKCHOP), 1.0f, 1, 3),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SMOKED_HAM.get()), 0.4f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.NOODLE_SOUP.get()), 0.3f, 1, 2)
                    )
            )),
            Map.entry(FatPig.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.6f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_PORKCHOP), 1.0f, 1, 5),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SMOKED_HAM.get()), 0.8f, 1, 4),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.NOODLE_SOUP.get()), 0.6f, 2, 4)
                    )
            )),
            Map.entry(WoolCow.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.hurt")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.6f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.IRIS.get()), 1.0f, 1, 4)
                    )
            )),
            Map.entry(WoolCow2.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.hurt")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.6f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.IRIS.get()), 1.0f, 1, 4)
                    )
            )),
            Map.entry(FeatherChicken.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.6f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.CHICKEN_SOUP.get()), 1.0f, 1, 4)
                    )
            )),
            Map.entry(FeatherChicken2.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.6f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.CHICKEN_SOUP.get()), 1.0f, 1, 4)
                    )
            )),
            Map.entry(Hoglin.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.hoglin.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_PORKCHOP), 1.0f, 1, 3),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SMOKED_HAM.get()), 0.4f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.NOODLE_SOUP.get()), 0.3f, 1, 2)
                    )
            )),
            Map.entry(Cow.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_BEEF), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BEEF_STEW.get()), 0.6f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BEEF_PATTY.get()), 0.3f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.LEATHER), 0.7f, 1, 1)

                    )
            )),
            Map.entry(MushroomCow.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_BEEF), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BEEF_STEW.get()), 0.6f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BEEF_PATTY.get()), 0.3f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.LEATHER), 0.7f, 1, 1)

                    )
            )),
            Map.entry(Rabbit.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.rabbit.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.RABBIT_STEW), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.RABBIT_FOOT), 0.3f, 1, 2)
                    )
            )),
            Map.entry(Turtle.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.TURTLE_SOUP.get()), 1f, 1, 3)
                    )
            )),
            Map.entry(Sheep.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_MUTTON), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.ROASTED_MUTTON_CHOPS.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Chicken.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_CHICKEN), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.CHICKEN_SOUP.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Skeleton.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(WitherSkeleton.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither_skeleton.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Stray.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.stray.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.BONE_BROTH.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Cod.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cod.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_COD), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.COD_ROLL.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(TropicalFish.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cod.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.FISH_STEW.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Salmon.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.salmon.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.COOKED_SALMON), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SALMON_ROLL.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Squid.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SQUID_INK_PASTA.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SQUID_INK_PASTA.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(EnderMan.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.hurt")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.CHORUS_FRUIT), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.CHORUS_FRUIT), 0.45f, 1, 2)
                    )
            )),
            Map.entry(GlowSquid.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SQUID_INK_PASTA.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.SQUID_INK_PASTA.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(PolarBear.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.polar_bear.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.COCKED_BEAR_MEAT.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.BEAR_MEAT_SOUP.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Goat.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.goat.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.COCKED_GOATS_MEAT.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.GOAT_MEAT_KEBAB.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Frog.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.frog.death")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.COCKED_FROG.get()), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.COCKED_FROG_LEGS.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Bee.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.spit")),
                    List.of(
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.HONEY_BOTTLE), 1.0f, 1, 2),
                            new EntityBehaviour.ItemDrop(new ItemStack(ModItems.HONEY_COOKIE.get()), 0.45f, 1, 2)
                    )
            )),
            Map.entry(Horse.class, new EntityBehaviour(
                    () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.hurt")),
                    List.of(new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.SPARKLING_POLLEN.get()), 0.3f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(InitItemsWD.COCKED_HORSE.get()), 1.0f, 1, 1),
                            new EntityBehaviour.ItemDrop(new ItemStack(Items.LEATHER), 0.7f, 1, 1)
                    )
            ))
    );

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity instanceof LivingEntity _livEnt && _livEnt.isBaby()) return;

        EntityBehaviour behaviour = ENTITY_BEHAVIOURS.entrySet().stream()
                .filter(entry -> !world.getEntitiesOfClass(entry.getKey(), AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        if (behaviour == null) {
            // Если сущность не в списке, применяем отталкивание
            // Применяем отталкивание
            double knockbackStrength = 5.0; // Сила отталкивания
            double knockbackX = entity.getX() - x; // Направление по оси X
            double knockbackZ = entity.getZ() - z; // Направление по оси Z

// Вычисляем угол
            double angle = Math.atan2(knockbackZ, knockbackX);

// Расстояние, на которое будет отталкиваться сущность
            double distance = 5.0;

// Вычисляем новые координаты
            double newX = entity.getX() + distance * Math.cos(angle);
            double newZ = entity.getZ() + distance * Math.sin(angle);

            if (entity instanceof LivingEntity) {
                // Проверяем, является ли сущность живой
                LivingEntity livingEntity = (LivingEntity) entity;

                // Применяем отталкивание
                livingEntity.push(knockbackX, 0.5, knockbackZ);
                if (world instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), x, y, z, 36, 0.5, 0.5, 0.5, 0.05f);
                }
            }
            return; // Прекращаем выполнение метода, если сущность не в списке
        }

        if (!world.isClientSide()) {
            playSound(world, x, y, z, behaviour.getDeathSound(), SoundSource.NEUTRAL, 1, 1);
            spawnItems(world, x, y, z, behaviour.getItemDrops());
        }

        if (world instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(), x, y, z, 36, 0.5, 0.5, 0.5, 0.05f);
        }

        // Discard the entity
        entity.discard();
    }


    private static void playSound(LevelAccessor world, double x, double y, double z, Supplier<SoundEvent> soundSupplier, SoundSource source, float volume, float pitch) {
        SoundEvent sound = soundSupplier.get();
        if (sound != null) {
            world.playSound(null, new BlockPos(x, y, z), sound, source, volume, pitch);
        }
    }

    private static void spawnItems(LevelAccessor world, double x, double y, double z, List<EntityBehaviour.ItemDrop> itemDrops) {
        for (EntityBehaviour.ItemDrop itemDrop : itemDrops) {
            if (world instanceof Level level && !world.isClientSide()) {
                float chance = level.random.nextFloat();
                if (chance <= itemDrop.getChance()) {
                    int amount = level.random.nextInt(itemDrop.getMaxAmount() - itemDrop.getMinAmount() + 1) + itemDrop.getMinAmount();
                    ItemStack itemStack = itemDrop.getItemStack().copy();
                    itemStack.setCount(amount);

                    ItemEntity entityToSpawn = new ItemEntity(level, x, y, z, itemStack);
                    entityToSpawn.setPickUpDelay(10);
                    level.addFreshEntity(entityToSpawn);
                }
            }
        }
    }

    private static class EntityBehaviour {
        private final Supplier<SoundEvent> deathSound;
        private final List<ItemDrop> itemDrops;

        public EntityBehaviour(Supplier<SoundEvent> deathSound, List<ItemDrop> itemDrops) {
            this.deathSound = deathSound;
            this.itemDrops = itemDrops;
        }

        public Supplier<SoundEvent> getDeathSound() {
            return deathSound;
        }

        public List<ItemDrop> getItemDrops() {
            return itemDrops;
        }

        public static class ItemDrop {
            private final ItemStack itemStack;
            private final float chance;
            private final int minAmount;
            private final int maxAmount;

            public ItemDrop(ItemStack itemStack, float chance, int minAmount, int maxAmount) {
                this.itemStack = itemStack;
                this.chance = chance;
                this.minAmount = minAmount;
                this.maxAmount = maxAmount;
            }

            public ItemStack getItemStack() {
                return itemStack;
            }

            public float getChance() {
                return chance;
            }

            public int getMinAmount() {
                return minAmount;
            }
            public int getMaxAmount () {
                return maxAmount;
            }
        }
    }
}