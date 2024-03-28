package net.sanberdir.wizardrydelight.server.procedures;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class HitByBlockWDJson {
    public static void execute(Level world, double x, double y, double z, BlockState blockState) {
        // Получаем объект блока из состояния блока
        Block block = blockState.getBlock();
        // Получаем ключ блока из реестра блоков
        ResourceLocation blockKey = ForgeRegistries.BLOCKS.getKey(block);

        // Проверяем, что ключ блока существует
        if (blockKey != null) {
            // Преобразуем ключ блока в строку
            String blockId = blockKey.toString();

            // Формируем путь к JSON файлу для данного блока
            String jsonPath = "data/wizardry_delight/robin_block/" + blockId + ".json";

            // Проверяем, существует ли файл JSON
            File jsonFile = new File(jsonPath);
            if (jsonFile.exists()) {
                try {
                    // Читаем JSON файл
                    JsonObject jsonObject = new JsonParser().parse(new FileReader(jsonFile)).getAsJsonObject();

                    // Получаем информацию о предмете и его количестве из JSON
                    String itemName = jsonObject.get("item").getAsString();
                    int minCount = jsonObject.get("min_count").getAsInt();
                    int maxCount = jsonObject.get("max_count").getAsInt();

                    // Создаем предмет
                    Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName));

                    if (item != null && item != Items.AIR) {
                        // Создаем ItemStack
                        ItemStack itemStack = new ItemStack(item);
                        int count = minCount + world.random.nextInt(maxCount - minCount + 1);
                        itemStack.setCount(count);

                        // Добавляем предмет в мир
                        world.addFreshEntity(new ItemEntity(world, x, y, z, itemStack));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}