package net.sanberdir.wizardrydelight.common.Items.customItem;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.sanberdir.wizardrydelight.client.ModCreativeTab;
import net.sanberdir.wizardrydelight.common.entity.boat.ModBoatEntity;
import net.sanberdir.wizardrydelight.common.entity.boat.ModBoatTypes;

import java.util.List;
import java.util.function.Predicate;
public class AppleBoat extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final ModBoatTypes type;

    public AppleBoat() {
        super(new Properties().stacksTo(1).tab(ModCreativeTab.BUSHES));
        type = ModBoatTypes.APPLE;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack itemStack = player.getItemInHand(hand);
        HitResult rayTraceResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

        if (rayTraceResult.getType() == HitResult.Type.MISS)
        {
            return InteractionResultHolder.pass(itemStack);
        }
        else
        {
            Vec3 view = player.getViewVector(1.0F);
            List<Entity> entityList = level.getEntities(player, player.getBoundingBox().expandTowards(view.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!entityList.isEmpty())
            {
                Vec3 eyePosition = player.getEyePosition(1.0F);

                for (Entity entity : entityList)
                {
                    AABB entityBoundingBox = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (entityBoundingBox.contains(eyePosition))
                    {
                        return InteractionResultHolder.pass(itemStack);
                    }
                }
            }

            if (rayTraceResult.getType() == HitResult.Type.BLOCK)
            {
                ModBoatEntity boat = new ModBoatEntity(level, rayTraceResult.getLocation().x, rayTraceResult.getLocation().y, rayTraceResult.getLocation().z);
                boat.setModBoatType(this.type);
                boat.setYRot(player.getYRot());
                if (!level.noCollision(boat, boat.getBoundingBox()))
                {
                    return InteractionResultHolder.fail(itemStack);
                }
                else
                {
                    if (!level.isClientSide)
                    {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, new BlockPos(rayTraceResult.getLocation()));
                        if (!player.getAbilities().instabuild) {
                            itemStack.shrink(1);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }
            }
            else
            {
                return InteractionResultHolder.pass(itemStack);
            }
        }
    }

}
