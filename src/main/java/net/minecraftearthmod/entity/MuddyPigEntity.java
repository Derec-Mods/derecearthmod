
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class MuddyPigEntity extends Animal  {


	public MuddyPigEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.MUDDY_PIG.get(), world);
    }

	public MuddyPigEntity(EntityType<MuddyPigEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 3;
		setNoAi(false);




	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.goalSelector.addGoal(1, new BreedGoal(this, 1));
this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.of(MinecraftEarthModModItems.BUCKET_OF_MUD.get()), false));this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(Blocks.WHEAT.asItem()), false));this.goalSelector.addGoal(4, new TemptGoal(this, 1, Ingredient.of(Items.CARROT), false));this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(Items.POTATO), false));this.goalSelector.addGoal(6,new PanicGoal(this, 1.2));this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1));this.goalSelector.addGoal(8, new FloatGoal(this));this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));

	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.ambient"));
	}

	@Override public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.step")), 0.15f, 1);
	}

	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.death"));
	}




	@Override public void die(DamageSource source) {
		super.die(source);
    CheckMuddyPigOnFireProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
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
    

    CleanPigWaterProcedure.execute(world,x,y,z,entity,sourceentity)
;
				return retval;
	}


	@Override public void baseTick() {
		super.baseTick();
    CheckMuddyPigCleanProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
	}



        @Override public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
			MuddyPigEntity retval = MinecraftEarthModModEntities.MUDDY_PIG.get().create(serverWorld);
			retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
			return retval;
		}

		@Override public boolean isFood(ItemStack stack) {
			return List.of(Blocks.WHEAT.asItem(),Items.CARROT,Items.POTATO).contains(stack.getItem());
		}








	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.MUDDY_PIG.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) ->
							(world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8)
			);

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
