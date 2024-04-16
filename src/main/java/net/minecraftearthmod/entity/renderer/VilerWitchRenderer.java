package net.minecraftearthmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.entity.VilerWitchEntity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class VilerWitchRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(VilerWitchEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelvilerwitch(), 0.6f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_earth_mod:textures/vilerwitch_2.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelvilerwitch extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer nose;
		private final ModelRenderer mole;
		private final ModelRenderer body;
		private final ModelRenderer arms;
		private final ModelRenderer mirrored;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_leg;
		private final ModelRenderer bodywear;
		private final ModelRenderer headwear;
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer headwear2;
		public Modelvilerwitch() {
			textureWidth = 64;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(18, 88).addBox(4.15F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(0, 77).addBox(4.15F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-4.1F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-4.1F, -6.0F, 1.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 66).addBox(4.15F, -6.0F, 1.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(15, 40).addBox(-4.1F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(42, 15).addBox(-4.0F, -2.6F, -4.05F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 4).addBox(2.0F, -2.6F, -4.15F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 31).addBox(-4.0F, -6.0F, 4.15F, 8.0F, 6.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(60, 22).addBox(-2.0F, -1.0F, -4.05F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(5, 6).addBox(1.0F, -1.0F, -4.15F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			nose = new ModelRenderer(this);
			nose.setRotationPoint(0.0F, -2.0F, 0.0F);
			head.addChild(nose);
			nose.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			mole = new ModelRenderer(this);
			mole.setRotationPoint(0.0F, -4.0F, 0.0F);
			head.addChild(mole);
			mole.setTextureOffset(0, 0).addBox(-0.95F, 2.0F, -6.75F, 1.0F, 1.0F, 1.0F, -0.25F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 2.0F, 0.0F);
			arms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
			arms.setTextureOffset(44, 67).addBox(-8.75F, -2.4F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);
			arms.setTextureOffset(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
			mirrored = new ModelRenderer(this);
			mirrored.setRotationPoint(0.0F, 22.0F, 0.0F);
			arms.addChild(mirrored);
			mirrored.setTextureOffset(44, 22).addBox(4.0F, -24.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);
			mirrored.setTextureOffset(46, 74).addBox(4.5F, -24.25F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, true);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
			right_leg.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			left_leg.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			bodywear = new ModelRenderer(this);
			bodywear.setRotationPoint(0.0F, 0.0F, 0.0F);
			bodywear.setTextureOffset(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, 0.5F, false);
			bodywear.setTextureOffset(0, 105).addBox(-4.5F, 11.7F, 3.6F, 8.0F, 1.0F, 0.0F, 0.5F, false);
			bodywear.setTextureOffset(0, 105).addBox(-4.5F, 11.7F, -3.4F, 0.0F, 1.0F, 7.0F, 0.5F, false);
			bodywear.setTextureOffset(42, 90).addBox(4.5F, 11.7F, -3.4F, 0.0F, 1.0F, 7.0F, 0.5F, false);
			bodywear.setTextureOffset(0, 105).addBox(-4.0F, 11.7F, -3.4F, 8.0F, 1.0F, 0.0F, 0.5F, false);
			bodywear.setTextureOffset(22, 29).addBox(-4.0F, 19.0F, -3.0F, 3.0F, 0.0F, 6.0F, 0.5F, false);
			bodywear.setTextureOffset(20, 28).addBox(0.0F, 19.0F, -3.0F, 2.0F, 0.0F, 6.0F, 0.5F, false);
			bodywear.setTextureOffset(14, 39).addBox(4.0F, 19.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.5F, false);
			bodywear.setTextureOffset(2, 45).addBox(4.0F, 19.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.5F, false);
			bodywear.setTextureOffset(20, 44).addBox(4.0F, 19.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, false);
			bodywear.setTextureOffset(26, 29).addBox(-1.0F, 20.0F, -3.0F, 0.0F, 0.0F, 6.0F, 0.5F, false);
			bodywear.setTextureOffset(13, 40).addBox(-4.0F, 20.0F, -3.0F, 0.0F, 0.0F, 2.0F, 0.5F, false);
			bodywear.setTextureOffset(8, 40).addBox(-4.0F, 20.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, false);
			bodywear.setTextureOffset(4, 46).addBox(-4.0F, 21.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.5F, false);
			headwear = new ModelRenderer(this);
			headwear.setRotationPoint(5.0F, -10.0F, -5.0F);
			headwear.setTextureOffset(0, 106).addBox(-14.0F, -0.1F, -4.0F, 18.0F, 2.0F, 18.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-8.5F, -0.1F, 1.5F);
			headwear.addChild(bone);
			setRotationAngle(bone, -0.0524F, 0.0F, 0.0349F);
			bone.setTextureOffset(0, 76).addBox(0.0F, -4.0F, 0.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(1.5F, -3.5F, 1.5F);
			bone.addChild(bone2);
			setRotationAngle(bone2, -0.1222F, 0.0F, -0.0611F);
			bone2.setTextureOffset(0, 87).addBox(0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(1.5F, -4.0F, 1.5F);
			bone2.addChild(bone3);
			setRotationAngle(bone3, -0.2618F, 0.0F, 0.0175F);
			bone3.setTextureOffset(0, 95).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			headwear2 = new ModelRenderer(this);
			headwear2.setRotationPoint(0.0F, -4.0F, 14.0F);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			arms.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			bodywear.render(matrixStack, buffer, packedLight, packedOverlay);
			headwear.render(matrixStack, buffer, packedLight, packedOverlay);
			headwear2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
