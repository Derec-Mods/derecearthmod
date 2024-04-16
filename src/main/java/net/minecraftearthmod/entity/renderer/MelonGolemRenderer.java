package net.minecraftearthmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.entity.MelonGolemEntity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MelonGolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MelonGolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelmelongolem(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_earth_mod:textures/melongolem.png");
					}
				};
			});
			RenderingRegistry.registerEntityRenderingHandler(MelonGolemEntity.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmelongolem extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer left_hand;
		private final ModelRenderer right_hand;
		private final ModelRenderer body;
		private final ModelRenderer body_bottom;
		public Modelmelongolem() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 4.0F, 0.0F);
			head.setTextureOffset(32, 8).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, true);
			left_hand = new ModelRenderer(this);
			left_hand.setRotationPoint(8.0F, -9.0F, 0.0F);
			setRotationAngle(left_hand, 0.0F, 0.0F, -0.8727F);
			left_hand.setTextureOffset(32, 0).addBox(-31.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);
			right_hand = new ModelRenderer(this);
			right_hand.setRotationPoint(3.0F, -7.0F, 0.0F);
			setRotationAngle(right_hand, 0.0F, 0.0F, 0.8727F);
			right_hand.setTextureOffset(32, 0).addBox(9.766F, 7.6428F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 13.0F, 0.0F);
			body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, true);
			body_bottom = new ModelRenderer(this);
			body_bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
			body_bottom.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
			right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			body_bottom.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
