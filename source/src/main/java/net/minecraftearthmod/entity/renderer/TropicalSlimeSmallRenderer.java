package net.minecraftearthmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.entity.TropicalSlimeSmallEntity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TropicalSlimeSmallRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TropicalSlimeSmallEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeltropicalslime(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_earth_mod:textures/tropical_slime.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeltropicalslime extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer right_eye;
		private final ModelRenderer left_eye;
		private final ModelRenderer mouth;
		public Modeltropicalslime() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(0, 16).addBox(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
			right_eye = new ModelRenderer(this);
			right_eye.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(right_eye);
			right_eye.setTextureOffset(32, 0).addBox(1.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			left_eye = new ModelRenderer(this);
			left_eye.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(left_eye);
			left_eye.setTextureOffset(32, 4).addBox(-3.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			mouth = new ModelRenderer(this);
			mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(mouth);
			mouth.setTextureOffset(32, 8).addBox(-1.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
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
