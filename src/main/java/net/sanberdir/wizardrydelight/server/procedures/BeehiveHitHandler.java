package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;

public class BeehiveHitHandler {
    public static void handleHit(BlockHitResult hitResult, Level level, BeehiveBlockEntity beehiveEntity) {
        BlockPos pos = hitResult.getBlockPos();
        BlockState blockState = level.getBlockState(pos);

        if (blockState.getBlock() instanceof BeehiveBlock) {
            BeehiveBlockEntity beehive = (BeehiveBlockEntity) level.getBlockEntity(pos);

            if (beehive != null) {
                CompoundTag blockEntityTag = beehiveEntity.getPersistentData();
                ListTag beesTag = blockEntityTag.getList("Bees", 10);

                int honeyLevel = blockEntityTag.getInt("honey_level");
                if (honeyLevel <= 0 && beesTag.isEmpty()) {
                    // Пустой улей или пасека, генерируем случайное количество мёда от 1 до 2
                    int honeyAmount = 1 + level.random.nextInt(1);

                    // Если в блоке есть пчела, умножаем количество мёда на (1 + n), где n - количество пчёл
                    int beeCount = beesTag.size();
                    honeyAmount *= (1 + beeCount);

                    spawnHoneyBottles(level, pos, honeyAmount);
                }
            }
        }
    }

    private static void spawnHoneyBottles(Level level, BlockPos pos, int count) {
        // Создаем ItemStack для бутылок мёда
        ItemStack honeyBottleStack = new ItemStack(Items.HONEY_BOTTLE, count);

        // Если игрок попал по блоку, даем ему бутылки мёда
        Player playerEntity = (Player)level.getNearestPlayer(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5.0, false);
        if (playerEntity != null) {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), honeyBottleStack);
            level.addFreshEntity(itemEntity);        } else {
            // Иначе, спавним бутылки мёда в мире
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), honeyBottleStack);
            level.addFreshEntity(itemEntity);        }
    }
}
