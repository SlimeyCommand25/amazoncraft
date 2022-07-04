package net.slimey.amazoncraft.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.slimey.amazoncraft.entity.ModEntityTypes;
import net.slimey.amazoncraft.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;



public class CapybaraEntity extends TamableAnimal implements ContainerListener, IAnimatable {

    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.MELON_SLICE);
    private AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Boolean> DATA_ID_CHEST = SynchedEntityData.defineId(CapybaraEntity.class, EntityDataSerializers.BOOLEAN);
    protected SimpleContainer inventory;
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(CapybaraEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Optional<UUID>> DATA_ID_OWNER_UUID = SynchedEntityData.defineId(CapybaraEntity.class, EntityDataSerializers.OPTIONAL_UUID);





    public CapybaraEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.maxUpStep = 1.0F;
        this.createInventory();
    }


    //______________________________________________________________________________________________________________________________________________

    @Nullable
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.capybara.walk", true));
            return PlayState.CONTINUE;
        }


        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.capybara.idle", true));
        return PlayState.CONTINUE;

    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }
    @Override
    public AnimationFactory getFactory() {
        return this.factory;

    }
    
    //______________________________________________________________________________________________________________________________________________

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.MELON_SLICE), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }
    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0f)
                .add(Attributes.ATTACK_SPEED, 0.0f)
                .add(Attributes.MOVEMENT_SPEED, (double)0.2f).build();
    }
    public boolean canBeLeashed(Player pPlayer) {
        return super.canBeLeashed(pPlayer);
    }
    public Vec3 getLeashOffset() {
        return new Vec3(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }
    //______________________________________________________________________________________________________________________________________________
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
        this.entityData.define(DATA_ID_OWNER_UUID, Optional.empty());
        this.entityData.define(DATA_ID_CHEST, false);
    }

    protected boolean getFlag(int p_30648_) {
        return (this.entityData.get(DATA_ID_FLAGS) & p_30648_) != 0;
    }

    protected void setFlag(int p_30598_, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_30599_) {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 | p_30598_));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 & ~p_30598_));
        }

    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();

        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(Items.MELON) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!pPlayer.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }
            } else if (itemstack.is(Items.MELON)) {
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                    this.tame(pPlayer);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            }
            if (!this.isBaby()) {
                if (this.isTame() && pPlayer.isSecondaryUseActive()) {
                    this.openInventory(pPlayer);
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
            }

            if (!itemstack.isEmpty()) {
                if (!this.hasChest() && itemstack.is(Blocks.CHEST.asItem())) {
                    this.setChest(true);
                    this.playChestEquipsSound();
                    if (!pPlayer.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.createInventory();
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }

                if (!this.isBaby()) {
                    this.openInventory(pPlayer);
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
            }
            return InteractionResult.SUCCESS;
        }

    }

    public void openInventory(Player pPlayerEntity) {
        if (!this.level.isClientSide && this.isTame()) {
            pPlayerEntity.openHorseInventory(this, this.inventory);
        }

    }


    public SlotAccess getSlot(int pSlot) {
        return pSlot == 499 ? new SlotAccess() {
            public ItemStack get() {
                return CapybaraEntity.this.hasChest() ? new ItemStack(Items.CHEST) : ItemStack.EMPTY;
            }

            public boolean set(ItemStack p_149485_) {
                if (p_149485_.isEmpty()) {
                    if (CapybaraEntity.this.hasChest()) {
                        CapybaraEntity.this.setChest(false);
                        CapybaraEntity.this.createInventory();
                    }

                    return true;
                } else if (p_149485_.is(Items.CHEST)) {
                    if (!CapybaraEntity.this.hasChest()) {
                        CapybaraEntity.this.setChest(true);
                        CapybaraEntity.this.createInventory();
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } : super.getSlot(pSlot);
    }
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Chested Capybara", this.hasChest());
        if (this.hasChest()) {
            ListTag listtag = new ListTag();

            for(int i = 2; i < this.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = this.inventory.getItem(i);
                if (!itemstack.isEmpty()) {
                    CompoundTag compoundtag = new CompoundTag();
                    compoundtag.putByte("Slot", (byte)i);
                    itemstack.save(compoundtag);
                    listtag.add(compoundtag);
                }
            }

            pCompound.put("Items", listtag);
        }

    }
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setChest(pCompound.getBoolean("Chested Capybara"));
        this.createInventory();
        if (this.hasChest()) {
            ListTag listtag = pCompound.getList("Items", 10);

            for(int i = 0; i < listtag.size(); ++i) {
                CompoundTag compoundtag = listtag.getCompound(i);
                int j = compoundtag.getByte("Slot") & 255;
                if (j >= 2 && j < this.inventory.getContainerSize()) {
                    this.inventory.setItem(j, ItemStack.of(compoundtag));
                }
            }
        }

        this.updateContainerEquipment();
    }

    public boolean hasChest() {return this.entityData.get(DATA_ID_CHEST);}

    public void setChest(boolean pChested) {this.entityData.set(DATA_ID_CHEST, pChested);}

    protected int getInventorySize() {return 2;}

    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;


    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for(int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    protected void updateContainerEquipment() {
        if (!this.level.isClientSide) {
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
        }
    }
    private SlotAccess createEquipmentSlotAccess(final int p_149503_, final Predicate<ItemStack> p_149504_) {
        return new SlotAccess() {
            public ItemStack get() {
                return CapybaraEntity.this.inventory.getItem(p_149503_);
            }

            public boolean set(ItemStack p_149528_) {
                if (!p_149504_.test(p_149528_)) {
                    return false;
                } else {
                    CapybaraEntity.this.inventory.setItem(p_149503_, p_149528_);
                    CapybaraEntity.this.updateContainerEquipment();
                    return true;
                }
            }
        };
    }

    protected void dropEquipment() {
        super.dropEquipment();
        if (this.inventory != null) {
            for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = this.inventory.getItem(i);
                if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
                    this.spawnAtLocation(itemstack);
                }
            }

        }
    }


    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.core.Direction facing) {
        if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }


    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null) {
            net.minecraftforge.common.util.LazyOptional<?> oldHandler = itemHandler;
            itemHandler = null;
            oldHandler.invalidate();
        }
    }
    
    public boolean hasInventoryChanged(Container p_149512_) {
        return this.inventory != p_149512_;
    }

    //______________________________________________________________________________________________________________________________________________
    @Override
    public CapybaraEntity getBreedOffspring(ServerLevel p_148890_, AgeableMob p_148891_) {
        return ModEntityTypes.CAPYBARA.get().create(p_148890_);
    }
    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return this.isBaby() ? pSize.height * 0.7F : 1.0F;

    }
    //______________________________________________________________________________________________________________________________________________

    @Override
    protected SoundEvent getAmbientSound() {return ModSounds.CAPYBARA_CHIRP.get();}

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CAPYBARA_SQUEAK.get();
    }

    protected SoundEvent getDeathSound() {return ModSounds.CAPYBARA_DEATH.get();}

    protected void playChestEquipsSound() {this.playSound(SoundEvents.ARMOR_EQUIP_TURTLE, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);}


    @Override
    public void containerChanged(Container pInvBasic) {

    }
}

