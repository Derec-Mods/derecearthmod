
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class CluckshroomEntity extends Animal  {


	public CluckshroomEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.CLUCKSHROOM.get(), world);
    }

	public CluckshroomEntity(EntityType<CluckshroomEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 2;
		setNoAi(false);




	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.goalSelector.addGoal(1, new BreedGoal(this, 1));
this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.of(Items.WHEAT_SEEDS), false));this.goalSelector.addGoal(3,new PanicGoal(this, 1));this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));this.goalSelector.addGoal(6, new FloatGoal(this));

	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.ambient"));
	}


	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.death"));
	}



	@Override public boolean hurt(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
		return super.hurt(source, amount);
	}


	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
			MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
    SetEggTimerProcedure.execute(
    this
);
		return retval;
	}


	@Override public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());


			super.mobInteract(sourceentity, hand);


			double x = this.getX();
			double y = this.getY();
			double z = this.getZ();
			Entity entity = this;
			Level world = this.level;
    

    ShearCluckshroomProcedure.execute(world,x,y,z,entity)
;
				return retval;
	}


	@Override public void baseTick() {
		super.baseTick();
    CheckCanLayEggProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
	}



        @Override public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
			CluckshroomEntity retval = MinecraftEarthModModEntities.CLUCKSHROOM.get().create(serverWorld);
			retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
			return retval;
		}

		@Override public boolean isFood(ItemStack stack) {
			return List.of(Items.WHEAT_SEEDS).contains(stack.getItem());
		}








	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.CLUCKSHROOM.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) ->
							(world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8)
			);

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 4);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
