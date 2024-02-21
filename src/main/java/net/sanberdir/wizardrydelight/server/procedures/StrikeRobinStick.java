package net.sanberdir.wizardrydelight.server.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.entity.AbstractHurtingProjectileMod;
import net.sanberdir.wizardrydelight.common.entity.ModEntities;
import net.sanberdir.wizardrydelight.common.entity.StarBall;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StrikeRobinStick {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;

            execute(event, event.getEntity(), event.getItemStack(), event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());

    }

    public static void execute(Entity entity,ItemStack itemStack, LevelAccessor world, double x, double y, double z) {
        execute(null, entity,itemStack,world,x,y,z);
    }

    private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, LevelAccessor world, double x, double y, double z) {
        if (entity == null)
            return;


        if (!(new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                } else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                }
                return false;
            }
        }.checkGamemode(entity)) && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() < 69) {

            {
                ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                if (_ist.hurt(1, RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.ROBIN_STICK.get().asItem()) {
                world.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("wizardry_delight:robin_stick")), SoundSource.NEUTRAL, 1, 1);
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level;
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
                                AbstractHurtingProjectileMod entityToSpawn = new StarBall(ModEntities.STAR_BALL.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.xPower = ax;
                                entityToSpawn.yPower = ay;
                                entityToSpawn.zPower = az;
                                return entityToSpawn;
                            }
                        }.getFireball(projectileLevel, entity, (entity.getLookAngle().x / 10), (entity.getLookAngle().y / 10), (entity.getLookAngle().z / 10));
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            }
        }
        if ((new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                } else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                }
                return false;
            }
        }.checkGamemode(entity))){
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InitItemsWD.ROBIN_STICK.get().asItem()) {
                world.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("wizardry_delight:robin_stick")), SoundSource.NEUTRAL, 1, 1);
                {
                   Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level;
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
                                AbstractHurtingProjectileMod entityToSpawn = new StarBall(ModEntities.STAR_BALL.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.xPower = ax;
                                entityToSpawn.yPower = ay;
                                entityToSpawn.zPower = az;
                                return entityToSpawn;
                            }
                        }.getFireball(projectileLevel, entity, (entity.getLookAngle().x / 10), (entity.getLookAngle().y / 10), (entity.getLookAngle().z / 10));
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            }
        }
    }
}

