// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelfurnacegolem extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public Modelfurnacegolem() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 40, -9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 0, 70, -4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.0F, -2.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 24, 0, -1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F, true));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(0.0F, -7.0F, 0.0F);
		right_arm.cubeList.add(new ModelBox(right_arm, 60, 21, 9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F, true));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(0.0F, -7.0F, 0.0F);
		left_arm.cubeList.add(new ModelBox(left_arm, 60, 58, -13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F, true));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-5.0F, 11.0F, 0.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 37, 0, 6.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F, true));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(5.0F, 11.0F, 0.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 60, 0, -12.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		right_arm.render(f5);
		left_arm.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
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
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}