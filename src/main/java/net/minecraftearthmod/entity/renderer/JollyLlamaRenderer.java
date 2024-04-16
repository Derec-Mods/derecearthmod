package net.minecraftearthmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.entity.JollyLlamaEntity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class JollyLlamaRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(JollyLlamaEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeljollyllama(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_earth_mod:textures/jollyllama.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeljollyllama extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer foot4;
		private final ModelRenderer foot1;
		private final ModelRenderer foot3;
		private final ModelRenderer foot2;
		public Modeljollyllama() {
			textureWidth = 128;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 7.0F, -6.0F);
			head.setTextureOffset(0, 0).addBox(-2.0F, -14.0F, -10.0F, 4.0F, 4.0F, 9.0F, 0.0F, true);
			head.setTextureOffset(0, 14).addBox(-4.0F, -16.0F, -6.0F, 8.0F, 18.0F, 6.0F, 0.0F, true);
			head.setTextureOffset(35, 57).addBox(-2.5F, -14.1F, -9.0F, 5.0F, 5.0F, 2.0F, 0.0F, true);
			head.setTextureOffset(57, 52).addBox(-4.5F, -9.1F, -6.999F, 9.0F, 5.0F, 7.0F, 0.0F, true);
			head.setTextureOffset(0, 50).addBox(-4.5F, -15.1F, -6.5F, 9.0F, 7.0F, 7.0F, 0.0F, true);
			head.setTextureOffset(27, 0).addBox(1.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
			head.setTextureOffset(17, 0).addBox(-4.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
			head.setTextureOffset(73, 0).addBox(-11.0F, -29.0F, -4.0F, 7.0F, 16.0F, 0.0F, 0.0F, true);
			head.setTextureOffset(73, 16).addBox(4.0F, -29.0F, -4.0F, 7.0F, 16.0F, 0.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.0F, 2.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.setTextureOffset(29, 0).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, 0.0F, true);
			body.setTextureOffset(104, 42).addBox(-6.0F, -4.0F, 3.001F, 12.0F, 11.0F, 0.0F, 0.0F, true);
			body.setTextureOffset(108, 43).addBox(6.001F, -4.0F, -7.0F, 0.0F, 11.0F, 10.0F, 0.0F, true);
			body.setTextureOffset(108, 21).addBox(-6.001F, -4.0F, -7.0F, 0.0F, 11.0F, 10.0F, 0.0F, true);
			foot4 = new ModelRenderer(this);
			foot4.setRotationPoint(3.0F, 12.0F, 6.0F);
			foot4.setTextureOffset(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			foot1 = new ModelRenderer(this);
			foot1.setRotationPoint(-3.0F, 12.0F, -5.0F);
			foot1.setTextureOffset(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			foot3 = new ModelRenderer(this);
			foot3.setRotationPoint(3.0F, 12.0F, -5.0F);
			foot3.setTextureOffset(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			foot2 = new ModelRenderer(this);
			foot2.setRotationPoint(-3.0F, 12.0F, 6.0F);
			foot2.setTextureOffset(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			foot4.render(matrixStack, buffer, packedLight, packedOverlay);
			foot1.render(matrixStack, buffer, packedLight, packedOverlay);
			foot3.render(matrixStack, buffer, packedLight, packedOverlay);
			foot2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.foot1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.foot3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.foot2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.foot4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
