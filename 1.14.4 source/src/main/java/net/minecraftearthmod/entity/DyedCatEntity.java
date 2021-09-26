
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
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
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
public class DyedCatEntity extends MinecraftEarthModModElements.ModElement {
	public static EntityType entity = null;
	public DyedCatEntity(MinecraftEarthModModElements instance) {
		super(instance, 76);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.7f)).build("dyed_cat")
						.setRegistryName("dyed_cat");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -10092442, -10066330, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("dyed_cat"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 15, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modeldyedcat(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_earth_mod:textures/dyedcat.png");
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
			experienceValue = 2;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cat.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cat.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cat.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
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
	public static class Modeldyedcat extends EntityModel<Entity> {
		private final RendererModel back_left_leg;
		private final RendererModel back_right_leg;
		private final RendererModel front_left_leg;
		private final RendererModel front_right_leg;
		private final RendererModel tail;
		private final RendererModel tail2;
		private final RendererModel head;
		private final RendererModel body;
		private final RendererModel rotation;
		public Modeldyedcat() {
			textureWidth = 64;
			textureHeight = 32;
			back_left_leg = new RendererModel(this);
			back_left_leg.setRotationPoint(-1.1F, 18.0F, 7.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 8, 13, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
			back_right_leg = new RendererModel(this);
			back_right_leg.setRotationPoint(1.1F, 18.0F, 7.0F);
			back_right_leg.cubeList.add(new ModelBox(back_right_leg, 8, 13, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
			front_left_leg = new RendererModel(this);
			front_left_leg.setRotationPoint(-1.2F, 18.0F, -4.0F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 40, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
			front_right_leg = new RendererModel(this);
			front_right_leg.setRotationPoint(1.2F, 18.0F, -4.0F);
			front_right_leg.cubeList.add(new ModelBox(front_right_leg, 40, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
			tail = new RendererModel(this);
			tail.setRotationPoint(0.0F, 14.5F, 9.0F);
			setRotationAngle(tail, 0.6109F, 0.0F, 0.0F);
			tail.cubeList.add(new ModelBox(tail, 0, 15, -0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F, false));
			tail2 = new RendererModel(this);
			tail2.setRotationPoint(0.0F, 7.4483F, -0.1907F);
			tail.addChild(tail2);
			setRotationAngle(tail2, 0.9599F, 0.0F, 0.0F);
			tail2.cubeList.add(new ModelBox(tail2, 4, 15, -0.5F, 0.0F, -1.0F, 1, 8, 1, 0.0F, false));
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, 15.0F, -7.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -2.5F, -2.0F, -5.0F, 5, 4, 5, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 24, -1.5F, -0.02F, -6.0F, 3, 2, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 10, -2.0F, -3.0F, -2.0F, 1, 1, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 6, 10, 1.0F, -3.0F, -2.0F, 1, 1, 2, 0.0F, false));
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 6.0F, 6.1F);
			rotation = new RendererModel(this);
			rotation.setRotationPoint(0.0F, 11.0F, -5.1F);
			body.addChild(rotation);
			setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
			rotation.cubeList.add(new ModelBox(rotation, 20, 0, -2.0F, -8.0F, -2.9F, 4, 16, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			back_left_leg.render(f5);
			back_right_leg.render(f5);
			front_left_leg.render(f5);
			front_right_leg.render(f5);
			tail.render(f5);
			head.render(f5);
			body.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tail.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
