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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}