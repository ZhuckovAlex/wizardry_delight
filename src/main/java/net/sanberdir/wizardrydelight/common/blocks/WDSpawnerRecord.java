package net.sanberdir.wizardrydelight.common.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;

import java.util.Optional;

public record WDSpawnerRecord(CompoundTag entityToSpawn, Optional<CustomSpawnRules> customSpawnRules) {
    public static final Codec<WDSpawnerRecord> CODEC = RecordCodecBuilder.create((p_186571_) -> {
        return p_186571_.group(CompoundTag.CODEC.fieldOf("entity").forGetter((p_186576_) -> {
            return p_186576_.entityToSpawn;
        }), CustomSpawnRules.CODEC.optionalFieldOf("custom_spawn_rules").forGetter((p_186569_) -> {
            return p_186569_.customSpawnRules;
        })).apply(p_186571_, WDSpawnerRecord::new);
    });
    public static final Codec<SimpleWeightedRandomList<WDSpawnerRecord>> LIST_CODEC = SimpleWeightedRandomList.wrappedCodecAllowingEmpty(CODEC);




    private static final double x = 1;
    private static final double y = 1;
    private static final double z = 1;
    public static String DEFAULT_TYPE = "minecraft:cow";

    public WDSpawnerRecord() {
        this(Util.make(new CompoundTag(), (p_186573_) -> {
            p_186573_.putString("id", DEFAULT_TYPE);
        }), Optional.empty());
    }

    public WDSpawnerRecord {
        ResourceLocation resourcelocation = ResourceLocation.tryParse(entityToSpawn.getString("id"));
        entityToSpawn.putString("id", resourcelocation != null ? resourcelocation.toString() : DEFAULT_TYPE);
    }

    public CompoundTag getEntityToSpawn() {
        return this.entityToSpawn;
    }

    public Optional<CustomSpawnRules> getCustomSpawnRules() {
        return this.customSpawnRules;
    }

    public static record CustomSpawnRules(InclusiveRange<Integer> blockLightLimit, InclusiveRange<Integer> skyLightLimit) {
        private static final InclusiveRange<Integer> LIGHT_RANGE = new InclusiveRange<>(0, 15);
        public static final Codec<CustomSpawnRules> CODEC = RecordCodecBuilder.create((p_186597_) -> {
            return p_186597_.group(InclusiveRange.INT.optionalFieldOf("block_light_limit", LIGHT_RANGE).flatXmap(CustomSpawnRules::checkLightBoundaries, CustomSpawnRules::checkLightBoundaries).forGetter((p_186600_) -> {
                return p_186600_.blockLightLimit;
            }), InclusiveRange.INT.optionalFieldOf("sky_light_limit", LIGHT_RANGE).flatXmap(CustomSpawnRules::checkLightBoundaries, CustomSpawnRules::checkLightBoundaries).forGetter((p_186595_) -> {
                return p_186595_.skyLightLimit;
            })).apply(p_186597_, CustomSpawnRules::new);
        });

        private static DataResult<InclusiveRange<Integer>> checkLightBoundaries(InclusiveRange<Integer> p_186593_) {
            return !LIGHT_RANGE.contains(p_186593_) ? DataResult.error("Light values must be withing range " + LIGHT_RANGE) : DataResult.success(p_186593_);
        }
    }
}