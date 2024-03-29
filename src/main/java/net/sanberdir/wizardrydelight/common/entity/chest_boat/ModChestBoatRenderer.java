package net.sanberdir.wizardrydelight.common.entity.chest_boat;


import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.sanberdir.wizardrydelight.common.entity.boat.ModBoatTypes;

import java.util.Map;
import java.util.stream.Stream;

import static net.sanberdir.wizardrydelight.WizardryDelight.MOD_ID;

public class ModChestBoatRenderer extends BoatRenderer {
    private final Map<ModBoatTypes, Pair<ResourceLocation, BoatModel>> modChestBoatResources;

    public ModChestBoatRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoot) {
        super(renderContext, isChestBoot);

        // NOTE: Basically a copy of how we build boat resources but using our modded type enums since there's no easy way to add to the vanilla types
        //  Also note that I ripped this straight from ModBoatRenderer rather than trying to build my polymorphic solution
        modChestBoatResources = Stream.of(ModBoatTypes.values()).collect(ImmutableMap.toImmutableMap((boatType) -> {
            return boatType;
        }, (boatType) -> {
            return Pair.of(
                    new ResourceLocation(MOD_ID, "textures/entity/chest_boat/" + boatType.getName() + ".png"),
                    new BoatModel(renderContext.bakeLayer(
                            new ModelLayerLocation(
                                    new ResourceLocation("chest_boat/oak"),
                                    "main"
                            )
                    ), isChestBoot)
            );
        }));
    }

    public ModChestBoatRenderer(EntityRendererProvider.Context renderContext) {
        this(renderContext, true);
    }

    /**
     * Gets the resources (including model) for a modded chest boat given its type.
     * Override of the vanilla getter so that we can utilize our modded boat types over vanilla boat types without re-coding the vanilla render logic for boats
     *
     * @param boat The boat entity we are getting rendering resources for
     * @return A pair containing the resource location for the textures of this chest boat and its model
     */
    @Override
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        ModChestBoatEntity moddedBoat = (ModChestBoatEntity) boat;
        return modChestBoatResources.get(moddedBoat.getModChestBoatType());
    }
}
