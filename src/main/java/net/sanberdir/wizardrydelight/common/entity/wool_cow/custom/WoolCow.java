package net.sanberdir.wizardrydelight.common.entity.wool_cow.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import net.sanberdir.wizardrydelight.common.Items.InitItemsWD;
import net.sanberdir.wizardrydelight.common.entity.ModEntityTypesWD;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WoolCow extends Animal implements IAnimatable, Shearable, net.minecraftforge.common.IForgeShearable {

    private AnimationFactory factory = new AnimationFactory(this);

    public WoolCow(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(1, new ClimbOnTopOfPowderSnowGoal(this, this.level));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.7D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(InitItemsWD.COASTAL_STEEP_FIBERS.get()), false));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(InitItemsWD.COASTAL_STEEP_FLOWER.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.7D));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }






    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wool_cow.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wool_cow.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }



    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_28306_) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(BlockPos p_28301_, BlockState p_28302_) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }
    public static void cowDropWool(LevelAccessor world, double x, double y, double z, Entity entity,ItemStack itemstack) {
        if (entity == null)
            return;
        {
            ItemStack _ist = itemstack;
            if (_ist.hurt(1, RandomSource.create(), null)) {
                _ist.shrink(1);
                _ist.setDamageValue(0);
            }

        }
        if (world instanceof Level _level && !_level.isClientSide()) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BROWN_WOOL,2));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }
        if (!entity.level.isClientSide())
            entity.discard();
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = new WoolCow2(ModEntityTypesWD.WOOL_COW2.get(), _level);
            entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
        }

    }

    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
        super.mobInteract(player, interactionHand);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level;

        if (itemstack.is(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, Items.MILK_BUCKET.getDefaultInstance());
            player.setItemInHand(interactionHand, itemstack1);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } if (itemstack.is(Items.SHEARS) && !this.isBaby()) {
            player.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, 1.0F);
            cowDropWool(world, x, y, z, entity, itemstack);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(player, interactionHand);
        }
    }
    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(InitItemsWD.COASTAL_STEEP_FLOWER.get())
                ||itemStack.is(InitItemsWD.COASTAL_STEEP_FIBERS.get())
                ||itemStack.is(Items.WHEAT);

    }
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof WoolCow) && !(animal instanceof WoolCow2)) {
            return false;
        } else {
            return true;
        }
    }

    public WoolCow getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        WoolCow woolCow;
        if (ageableMob instanceof WoolCow2) {
            woolCow = ModEntityTypesWD.WOOL_COW.get().create(serverLevel);
        }
        else if (ageableMob instanceof WoolCow) {
            woolCow = ModEntityTypesWD.WOOL_COW.get().create(serverLevel);
        }else {
            woolCow = (WoolCow) ageableMob;
            WoolCow WoolCow;
            WoolCow = ModEntityTypesWD.WOOL_COW.get().create(serverLevel);


            net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow woolCow1 = WoolCow;
        }

        this.setAttributes();
        return woolCow;
    }



    protected float getStandingEyeHeight(Pose p_28295_, EntityDimensions p_28296_) {
        return this.isBaby() ? p_28296_.height * 0.95F : 1.3F;
    }

    @Override
    public void shear(SoundSource p_21749_) {

    }

    @Override
    public boolean readyForShearing() {
        return false;
    }
}
