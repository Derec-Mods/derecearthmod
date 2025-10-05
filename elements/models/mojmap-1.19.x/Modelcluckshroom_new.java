// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcluckshroom_new<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "cluckshroom_new"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart right_wing;
	private final ModelPart left_wing;

	public Modelcluckshroom_new(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.right_wing = root.getChild("right_wing");
		this.left_wing = root.getChild("left_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror()
				.addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(18, 9)
				.mirror().addBox(-1.5F, -10.0F, -0.5F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 4).mirror().addBox(1.0F, -10.0F, -3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offset(0.0F, 15.0F, -4.0F));

		PartDefinition bill = head.addOrReplaceChild("bill",
				CubeListBuilder.create().texOffs(14, 0).mirror()
						.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chin = head.addOrReplaceChild("chin",
				CubeListBuilder.create().texOffs(14, 4).mirror()
						.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 9).mirror()
						.addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition body_sub_2 = body.addOrReplaceChild("body_sub_2",
				CubeListBuilder.create().texOffs(28, 3).mirror()
						.addBox(-1.0F, -8.0F, -9.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(28, 8).mirror()
						.addBox(-3.5F, -8.0F, -6.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(26, 0).mirror()
						.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 19.0F, 1.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(26, 0).mirror()
						.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-1.0F, 19.0F, 1.0F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(24, 13).mirror()
						.addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-3.0F, 13.0F, 0.0F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing",
				CubeListBuilder.create().texOffs(24, 13).mirror()
						.addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(3.0F, 13.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_wing.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_wing.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}