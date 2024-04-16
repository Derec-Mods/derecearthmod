// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeldyedcat extends EntityModel<Entity> {
	private final ModelRenderer back_left_leg;
	private final ModelRenderer back_right_leg;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rotation;

	public Modeldyedcat() {
		textureWidth = 64;
		textureHeight = 32;

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(-1.1F, 18.0F, 7.0F);
		back_left_leg.setTextureOffset(8, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(1.1F, 18.0F, 7.0F);
		back_right_leg.setTextureOffset(8, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(-1.2F, 18.0F, -4.0F);
		front_left_leg.setTextureOffset(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(1.2F, 18.0F, -4.0F);
		front_right_leg.setTextureOffset(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 14.5F, 9.0F);
		setRotationAngle(tail, 0.6109F, 0.0F, 0.0F);
		tail.setTextureOffset(0, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 7.4483F, -0.1907F);
		tail.addChild(tail2);
		setRotationAngle(tail2, 0.9599F, 0.0F, 0.0F);
		tail2.setTextureOffset(4, 15).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -7.0F);
		head.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 24).addBox(-1.5F, -0.02F, -6.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 10).addBox(-2.0F, -3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(6, 10).addBox(1.0F, -3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 6.1F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 11.0F, -5.1F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.setTextureOffset(20, 0).addBox(-2.0F, -8.0F, -2.9F, 4.0F, 16.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.front_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.tail.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.front_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}