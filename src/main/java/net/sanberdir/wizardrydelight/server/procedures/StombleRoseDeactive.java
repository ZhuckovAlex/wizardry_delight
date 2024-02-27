package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.eventbus.api.Event;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.blocks.InitBlocksWD;

import javax.annotation.Nullable;
import java.util.Map;


public class StombleRoseDeactive {


    public static void execute(LevelAccessor world, double x, double y, double z) {
        execute(null, world, x, y, z);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {


        double fromZ = 0;
        double fromX = 0;
        double fromY = 0;

            if ((world.getBlockState(new BlockPos(x, y, z))) == InitBlocksWD.ROSE_OF_THE_MURDERER2.get().defaultBlockState()) {

                    WizardryDelight.queueServerWork(140, () -> {

                        {
                            BlockPos _bp = new BlockPos(x, y, z);
                            BlockState _bs = InitBlocksWD.ROSE_OF_THE_MURDERER.get().defaultBlockState();
                            BlockState _bso = world.getBlockState(_bp);
                            for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                if (_property != null && _bs.getValue(_property) != null)
                                    try {
                                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                    } catch (Exception e) {
                                    }
                            }
                            world.setBlock(_bp, _bs, 3);
                        }
                    });
        }
    }
}
