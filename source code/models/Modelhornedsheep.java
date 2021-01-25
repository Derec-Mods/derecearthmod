// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelhornedsheep extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leg2;
	private final ModelRenderer leg1;
	private final ModelRenderer leg4;
	private final ModelRenderer leg3;

	public Modelhornedsheep() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 3.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(22, 10).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 16.0F, 8.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, -8.0F);
		head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F, 0.0F, true);
		head.setTextureOffset(0, 32).addBox(-7.0F, -5.0F, -4.5F, 4.0F, 7.0F, 6.0F, 0.0F, true);
		head.setTextureOffset(20, 32).addBox(3.0F, -5.0F, -4.5F, 4.0F, 7.0F, 6.0F, 0.0F, true);
		head.setTextureOffset(0, 45).addBox(-7.0F, -1.0F, -7.5F, 4.0F, 3.0F, 3.0F, 0.0F, true);
		head.setTextureOffset(14, 45).addBox(3.0F, -1.0F, -7.5F, 4.0F, 3.0F, 3.0F, 0.0F, true);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 12.0F, 7.0F);
		leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(3.0F, 12.0F, 7.0F);
		leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-3.0F, 12.0F, -5.0F);
		leg4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(3.0F, 12.0F, -5.0F);
		leg3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}