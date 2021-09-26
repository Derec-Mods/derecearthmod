// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelskeletonwolf extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer body_rotation;
	private final ModelRenderer body_sub_1;
	private final ModelRenderer mane;
	private final ModelRenderer mane_rotation;
	private final ModelRenderer mane_sub_1;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer tail;

	public Modelskeletonwolf() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, 13.5F, -7.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 14, 0.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 14, -4.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 10, -2.5F, -0.02F, -5.0F, 3, 3, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 14.0F, 2.0F);

		body_rotation = new ModelRenderer(this);
		body_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(body_rotation);
		setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);

		body_sub_1 = new ModelRenderer(this);
		body_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		body_rotation.addChild(body_sub_1);
		body_sub_1.cubeList.add(new ModelBox(body_sub_1, 18, 14, -3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F, false));

		mane = new ModelRenderer(this);
		mane.setRotationPoint(1.0F, 14.0F, 2.0F);

		mane_rotation = new ModelRenderer(this);
		mane_rotation.setRotationPoint(-1.0F, 2.5F, -2.5F);
		mane.addChild(mane_rotation);
		setRotationAngle(mane_rotation, 1.5708F, 0.0F, 0.0F);

		mane_sub_1 = new ModelRenderer(this);
		mane_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		mane_rotation.addChild(mane_sub_1);
		mane_sub_1.cubeList.add(new ModelBox(mane_sub_1, 21, 0, -4.0F, -5.5F, -0.5F, 8, 6, 7, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(2.5F, 16.0F, 7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 18, -2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-0.5F, 16.0F, 7.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 18, -2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(2.5F, 16.0F, -4.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 18, -2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-0.5F, 16.0F, -4.0F);
		leg4.cubeList.add(new ModelBox(leg4, 0, 18, -2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(1.0F, 12.0F, 10.0F);
		tail.cubeList.add(new ModelBox(tail, 9, 18, -2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		mane.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		tail.render(f5);
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
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.tail.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}