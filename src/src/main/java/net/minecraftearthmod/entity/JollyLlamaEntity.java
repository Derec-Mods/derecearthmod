
package net.minecraftearthmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

@MinecraftEarthModModElements.ModElement.Tag
public class JollyLlamaEntity extends MinecraftEarthModModElements.ModElement {
	public static EntityType entity = null;
	public JollyLlamaEntity(MinecraftEarthModModElements instance) {
		super(instance, 46);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.9f, 1.87f)).build("jolly_llama")
						.setRegistryName("jolly_llama");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -16738048, -6750208, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("jolly_llama"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna_plateau")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 4, 6));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modeljollyllama(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_earth_mod:textures/jollyllama.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.death"));
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			super.processInteract(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			Entity entity = this;
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modeljollyllama extends EntityModel<Entity> {
		private final RendererModel head;
		private final RendererModel body;
		private final RendererModel foot4;
		private final RendererModel foot1;
		private final RendererModel foot3;
		private final RendererModel foot2;
		public Modeljollyllama() {
			textureWidth = 128;
			textureHeight = 64;
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, 7.0F, -6.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -14.0F, -10.0F, 4, 4, 9, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 0, 14, -4.0F, -16.0F, -6.0F, 8, 18, 6, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 35, 57, -2.5F, -14.1F, -9.0F, 5, 5, 2, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 57, 52, -4.5F, -9.1F, -6.999F, 9, 5, 7, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 0, 50, -4.5F, -15.1F, -6.5F, 9, 7, 7, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 27, 0, 1.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 17, 0, -4.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 73, 0, -11.0F, -29.0F, -4.0F, 7, 16, 0, 0.0F, true));
			head.cubeList.add(new ModelBox(head, 73, 16, 4.0F, -29.0F, -4.0F, 7, 16, 0, 0.0F, true));
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 5.0F, 2.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 29, 0, -6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 104, 42, -6.0F, -4.0F, 3.001F, 12, 11, 0, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 108, 43, 6.001F, -4.0F, -7.0F, 0, 11, 10, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 108, 21, -6.001F, -4.0F, -7.0F, 0, 11, 10, 0.0F, true));
			foot4 = new RendererModel(this);
			foot4.setRotationPoint(3.0F, 12.0F, 6.0F);
			foot4.cubeList.add(new ModelBox(foot4, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			foot1 = new RendererModel(this);
			foot1.setRotationPoint(-3.0F, 12.0F, -5.0F);
			foot1.cubeList.add(new ModelBox(foot1, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			foot3 = new RendererModel(this);
			foot3.setRotationPoint(3.0F, 12.0F, -5.0F);
			foot3.cubeList.add(new ModelBox(foot3, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			foot2 = new RendererModel(this);
			foot2.setRotationPoint(-3.0F, 12.0F, 6.0F);
			foot2.cubeList.add(new ModelBox(foot2, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			foot4.render(f5);
			foot1.render(f5);
			foot3.render(f5);
			foot2.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.foot1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.foot3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.foot2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.foot4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
