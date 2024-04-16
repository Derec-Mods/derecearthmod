// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelmoobloom extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer body_sub_0;
	private final ModelRenderer flowersonback;
	private final ModelRenderer body_sub_2;
	private final ModelRenderer head;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public Modelmoobloom() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);

		body_sub_0 = new ModelRenderer(this);
		body_sub_0.setRotationPoint(0.0F, 4.0F, 33.0F);
		body.addChild(body_sub_0);
		setRotationAngle(body_sub_0, 1.5708F, 0.0F, 0.0F);
		body_sub_0.cubeList.add(new ModelBox(body_sub_0, 18, 4, -6.0F, -44.0F, -3.0F, 12, 18, 10, 0.0F, true));

		flowersonback = new ModelRenderer(this);
		flowersonback.setRotationPoint(0.0F, 19.0F, -2.0F);
		body.addChild(flowersonback);
		setRotationAngle(flowersonback, -1.5708F, 0.0F, 0.0F);

		body_sub_2 = new ModelRenderer(this);
		body_sub_2.setRotationPoint(0.0F, -4.0F, -15.0F);
		flowersonback.addChild(body_sub_2);
		setRotationAngle(body_sub_2, 1.5708F, 0.0F, 0.0F);
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 52, 8, 0.5F, -13.0F, -8.5F, 4, 6, 0, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 52, 8, 1.5F, -13.0F, 0.5F, 4, 6, 0, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 52, 8, -4.5F, -12.0F, -9.5F, 4, 5, 0, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 52, 8, -5.5F, -12.0F, -0.5F, 4, 5, 0, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 56, 28, 2.5F, -13.0F, -10.5F, 0, 6, 4, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 56, 28, 3.5F, -13.0F, -1.5F, 0, 6, 4, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 56, 28, -2.5F, -12.0F, -11.5F, 0, 5, 4, 0.0F, true));
		body_sub_2.cubeList.add(new ModelBox(body_sub_2, 56, 28, -3.5F, -12.0F, -2.5F, 0, 5, 4, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, -8.0F);
		head.cubeList.add(new ModelBox(head, 22, 0, 4.0F, -5.0F, -5.0F, 1, 3, 1, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 22, 0, -5.0F, -5.0F, -5.0F, 1, 3, 1, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 52, 8, -1.5F, -10.0F, -4.5F, 4, 6, 0, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -7.0F, 8, 8, 6, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, 12.0F, -7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -3.0F, 4, 12, 4, 0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(4.0F, 12.0F, 6.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-4.0F, 12.0F, -7.0F);
		leg4.cubeList.add(new ModelBox(leg4, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
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
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}