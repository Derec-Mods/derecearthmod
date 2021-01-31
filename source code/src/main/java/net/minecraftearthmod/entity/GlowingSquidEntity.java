
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

import net.minecraftearthmod.procedures.ExperimentalModeCheckProcedure;
import net.minecraftearthmod.itemgroup.DerecEarthMobsSpawnEggsItemGroup;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@MinecraftEarthModModElements.ModElement.Tag
public class GlowingSquidEntity extends MinecraftEarthModModElements.ModElement {
	public static EntityType entity = null;
	public GlowingSquidEntity(MinecraftEarthModModElements instance) {
		super(instance, 89);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("glowing_squid").setRegistryName("glowing_squid");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16758961, -16711892, new Item.Properties().group(DerecEarthMobsSpawnEggsItemGroup.tab))
				.setRegistryName("glowing_squid_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("ocean")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(entity, 20, 2, 3));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> {
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					return ExperimentalModeCheckProcedure.executeProcedure(ImmutableMap.of());
				});
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelglowingsquidtest(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_earth_mod:textures/glowingsquid.png");
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
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("Work in Progress!"));
			setCustomNameVisible(true);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new SwimGoal(this));
			this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1, 40));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
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

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelglowingsquidtest extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer tentacle1;
		private final ModelRenderer tentacle2;
		private final ModelRenderer tentacle3;
		private final ModelRenderer tentacle4;
		private final ModelRenderer tentacle5;
		private final ModelRenderer tentacle6;
		private final ModelRenderer tentacle7;
		private final ModelRenderer tentacle8;
		public Modelglowingsquidtest() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 23.0F, 7.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 1.5708F);
			body.setTextureOffset(0, 0).addBox(-11.0F, -15.0F, -6.0F, 12.0F, 16.0F, 12.0F, 0.0F, false);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(-2.0F, 13.0F, 9.0F);
			setRotationAngle(tentacle1, 1.5708F, 0.0F, 1.5708F);
			tentacle1.setTextureOffset(48, 0).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-3.0F, 15.0F, 7.0F);
			setRotationAngle(tentacle2, 1.5708F, 0.0F, 1.5708F);
			tentacle2.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -1.5F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(-5.0F, 18.0F, 7.0F);
			setRotationAngle(tentacle3, 1.5708F, 0.0F, 1.5708F);
			tentacle3.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(-3.0F, 21.0F, 7.0F);
			setRotationAngle(tentacle4, 1.5708F, 0.0F, 1.5708F);
			tentacle4.setTextureOffset(48, 0).addBox(-0.5F, 0.0F, -1.5F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(0.0F, 13.0F, 7.0F);
			setRotationAngle(tentacle5, 1.5708F, 0.0F, 1.5708F);
			tentacle5.setTextureOffset(48, 0).addBox(9.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle6 = new ModelRenderer(this);
			tentacle6.setRotationPoint(3.0F, 21.0F, 7.0F);
			setRotationAngle(tentacle6, 1.5708F, 0.0F, 1.5708F);
			tentacle6.setTextureOffset(48, 0).addBox(-0.5F, 0.0F, -0.5F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle7 = new ModelRenderer(this);
			tentacle7.setRotationPoint(4.0F, 18.0F, 7.0F);
			setRotationAngle(tentacle7, 1.5708F, 0.0F, 1.5708F);
			tentacle7.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -0.7F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle8 = new ModelRenderer(this);
			tentacle8.setRotationPoint(3.0F, 15.0F, 7.0F);
			setRotationAngle(tentacle8, 1.5708F, 0.0F, 1.5708F);
			tentacle8.setTextureOffset(48, 0).addBox(-1.5F, 0.0F, -0.5F, 2.0F, 18.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle7.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle8.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
