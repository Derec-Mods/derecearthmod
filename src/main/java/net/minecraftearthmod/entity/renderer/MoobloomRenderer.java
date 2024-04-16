package net.minecraftearthmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.entity.MoobloomEntity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MoobloomRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MoobloomEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelmoobloom(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_earth_mod:textures/moobloom.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmoobloom extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer body_sub_2;
		private final ModelRenderer head;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		public Modelmoobloom() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.0F, 2.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.setTextureOffset(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, 0.0F, true);
			body_sub_2 = new ModelRenderer(this);
			body_sub_2.setRotationPoint(0.0F, 19.0F, -2.0F);
			body.addChild(body_sub_2);
			setRotationAngle(body_sub_2, -1.5708F, 0.0F, 0.0F);
			body_sub_2.setTextureOffset(52, 8).addBox(0.5F, -11.0F, -22.5F, 4.0F, 6.0F, 0.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 8).addBox(1.5F, -11.0F, -13.5F, 4.0F, 6.0F, 0.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 8).addBox(-4.5F, -10.0F, -23.5F, 4.0F, 5.0F, 0.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 8).addBox(-5.5F, -10.0F, -14.5F, 4.0F, 5.0F, 0.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 4).addBox(2.5F, -11.0F, -24.5F, 0.0F, 6.0F, 4.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 4).addBox(3.5F, -11.0F, -15.5F, 0.0F, 6.0F, 4.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 4).addBox(-2.5F, -10.0F, -25.5F, 0.0F, 5.0F, 4.0F, 0.0F, true);
			body_sub_2.setTextureOffset(52, 4).addBox(-3.5F, -10.0F, -16.5F, 0.0F, 5.0F, 4.0F, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 4.0F, -8.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F, true);
			head.setTextureOffset(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			head.setTextureOffset(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			head.setTextureOffset(52, 4).addBox(1.5F, -10.0F, -5.5F, 0.0F, 6.0F, 4.0F, 0.0F, true);
			head.setTextureOffset(52, 8).addBox(-0.5F, -10.0F, -3.5F, 4.0F, 6.0F, 0.0F, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(4.0F, 12.0F, 7.0F);
			leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
			leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(4.0F, 12.0F, -6.0F);
			leg3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-4.0F, 12.0F, -6.0F);
			leg4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
