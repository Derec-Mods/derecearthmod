package net.minecraftearthmod.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeljollyllama_new<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("minecraft_earth_mod", "modeljollyllama_new"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart foot4;
	public final ModelPart foot1;
	public final ModelPart foot3;
	public final ModelPart foot2;

	public Modeljollyllama_new(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.foot4 = root.getChild("foot4");
		this.foot1 = root.getChild("foot1");
		this.foot3 = root.getChild("foot3");
		this.foot2 = root.getChild("foot2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -14.0F, -10.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 14).mirror()
						.addBox(-4.0F, -16.0F, -6.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(35, 57).mirror().addBox(-2.5F, -14.1F, -9.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(57, 52)
						.mirror().addBox(-4.5F, -9.1F, -6.999F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 50).mirror().addBox(-4.5F, -15.1F, -6.5F, 9.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(27, 0)
						.mirror().addBox(1.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(17, 0).mirror().addBox(-4.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(73, 0)
						.mirror().addBox(-11.0F, -29.0F, -4.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(73, 16).mirror().addBox(4.0F, -29.0F, -4.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 7.0F, -6.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(29, 0).mirror().addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(104, 42).mirror()
						.addBox(-6.0F, -4.0F, 3.001F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(108, 43).mirror().addBox(6.001F, -4.0F, -7.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(108, 21)
						.mirror().addBox(-6.001F, -4.0F, -7.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition foot4 = partdefinition.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, 6.0F));
		PartDefinition foot1 = partdefinition.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, -5.0F));
		PartDefinition foot3 = partdefinition.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, -5.0F));
		PartDefinition foot2 = partdefinition.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(29, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 6.0F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.foot1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.foot3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.foot2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.foot4.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
