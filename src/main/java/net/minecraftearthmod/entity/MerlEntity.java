
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class MerlEntity extends PathfinderMob  {


	public MerlEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.MERL.get(), world);
    }

	public MerlEntity(EntityType<MerlEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 0;
		setNoAi(false);


			setPersistenceRequired();

        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.EMERALD));

	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.goalSelector.addGoal(1,new PanicGoal(this, 1.2));this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));this.goalSelector.addGoal(4, new FloatGoal(this));

	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}



    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(MinecraftEarthModModItems.RUBY.get()));
   	}



	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}




















	public static void init() {

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
