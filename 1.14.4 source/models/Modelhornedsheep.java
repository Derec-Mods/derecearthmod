// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelhornedsheep extends ModelBase {
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
		body.cubeList.add(new ModelBox(body, 22, 10, -6.0F, -10.0F, -7.0F, 12, 16, 8, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, -8.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 32, -7.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 20, 32, 3.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 45, -7.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 14, 45, 3.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 12.0F, 7.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(3.0F, 12.0F, 7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-3.0F, 12.0F, -5.0F);
		leg4.cubeList.add(new ModelBox(leg4, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(3.0F, 12.0F, -5.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg2.render(f5);
		leg1.render(f5);
		leg4.render(f5);
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
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}