// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelmuddypig extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;

	public Modelmuddypig() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 11.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 28, 8, -5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, -6.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -6.0F, -8.0F, 8, 8, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 16, -2.0F, -2.0F, -9.0F, 4, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 36, 0, -1.0F, -7.0F, -7.0F, 4, 1, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 5, 0.0F, -8.0F, -5.0F, 3, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 4, 0.0F, -9.0F, -5.0F, 4, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 56, 3, 1.0F, -10.0F, -5.0F, 1, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 1, 0.0F, -12.0F, -5.0F, 3, 2, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 0, 0.0F, -13.0F, -5.0F, 1, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 57, 0, 2.0F, -13.0F, -5.0F, 1, 1, 0, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-3.0F, 18.0F, 7.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 16, -2.0F, 0.0F, -4.0F, 4, 6, 4, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(3.0F, 18.0F, 7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -4.0F, 4, 6, 4, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 18.0F, -5.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(3.0F, 18.0F, -5.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
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
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}