// Made with Blockbench 4.6.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelvilerwitch_NEW<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "vilerwitch_new"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart arms;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart bodywear;

	public Modelvilerwitch_NEW(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.arms = root.getChild("arms");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.bodywear = root.getChild("bodywear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(18, 88)
						.addBox(4.15F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 77)
						.addBox(4.15F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.1F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.1F, -6.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 66)
						.addBox(4.15F, -6.0F, 1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(15, 40)
						.addBox(-4.1F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(42, 15)
						.addBox(-4.0F, -2.6F, -4.05F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(2.0F, -2.6F, -4.15F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(-4.0F, -6.0F, 4.15F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(60, 22)
						.addBox(-2.0F, -1.0F, -4.05F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(5, 6)
						.addBox(1.0F, -1.0F, -4.15F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F,
				-1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition mole = head.addOrReplaceChild("mole", CubeListBuilder.create().texOffs(0, 0).addBox(-0.95F, 2.0F,
				-6.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 106)
				.addBox(-14.0F, -0.1F, -4.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -10.0F, -5.0F));

		PartDefinition bone = headwear.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, -4.0F, 0.0F, 7.0F, 4.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.5F, -0.1F, 1.5F, -0.0524F, 0.0F, 0.0349F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 87).addBox(0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -3.5F, 1.5F, -0.1222F, 0.0F, -0.0611F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 95).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -4.0F, 1.5F, -0.2618F, 0.0F, 0.0175F));

		PartDefinition headwear2 = head.addOrReplaceChild("headwear2", CubeListBuilder.create(),
				PartPose.offset(0.0F, -4.0F, 14.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(
				-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = partdefinition.addOrReplaceChild("arms",
				CubeListBuilder.create().texOffs(40, 38)
						.addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(44, 67)
						.addBox(-8.75F, -2.4F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(44, 22)
						.addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition mirrored = arms.addOrReplaceChild("mirrored", CubeListBuilder.create().texOffs(44, 22).mirror()
				.addBox(4.0F, -24.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 74)
				.mirror().addBox(4.5F, -24.25F, -2.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(0, 22).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 22)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition bodywear = partdefinition.addOrReplaceChild("bodywear",
				CubeListBuilder.create().texOffs(0, 38)
						.addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(0, 105)
						.addBox(-4.5F, 11.7F, 3.6F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(0, 105)
						.addBox(-4.5F, 11.7F, -3.4F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.5F)).texOffs(42, 90)
						.addBox(4.5F, 11.7F, -3.4F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.5F)).texOffs(0, 105)
						.addBox(-4.0F, 11.7F, -3.4F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(22, 29)
						.addBox(-4.0F, 19.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(20, 28)
						.addBox(0.0F, 19.0F, -3.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(14, 39)
						.addBox(4.0F, 19.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(2, 45)
						.addBox(4.0F, 19.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(20, 44)
						.addBox(4.0F, 19.0F, 0.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(26, 29)
						.addBox(-1.0F, 20.0F, -3.0F, 0.0F, 0.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(13, 40)
						.addBox(-4.0F, 20.0F, -3.0F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.5F)).texOffs(8, 40)
						.addBox(-4.0F, 20.0F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(4, 46)
						.addBox(-4.0F, 21.0F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arms.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodywear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}