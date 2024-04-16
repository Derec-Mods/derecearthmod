// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modeljollyllama extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer foot4;
	private final ModelRenderer foot1;
	private final ModelRenderer foot3;
	private final ModelRenderer foot2;

	public Modeljollyllama() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 7.0F, -6.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -14.0F, -10.0F, 4, 4, 9, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 14, -4.0F, -16.0F, -6.0F, 8, 18, 6, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 35, 57, -2.5F, -14.1F, -9.0F, 5, 5, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 57, 52, -4.5F, -9.1F, -6.999F, 9, 5, 7, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 0, 50, -4.5F, -15.1F, -6.5F, 9, 7, 7, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 27, 0, 1.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 17, 0, -4.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 73, 0, -11.0F, -29.0F, -4.0F, 7, 16, 0, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 73, 16, 4.0F, -29.0F, -4.0F, 7, 16, 0, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 29, 0, -6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 104, 42, -6.0F, -4.0F, 3.001F, 12, 11, 0, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 108, 43, 6.001F, -4.0F, -7.0F, 0, 11, 10, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 108, 21, -6.001F, -4.0F, -7.0F, 0, 11, 10, 0.0F, true));

		foot4 = new ModelRenderer(this);
		foot4.setRotationPoint(3.0F, 12.0F, 6.0F);
		foot4.cubeList.add(new ModelBox(foot4, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		foot1 = new ModelRenderer(this);
		foot1.setRotationPoint(-3.0F, 12.0F, -5.0F);
		foot1.cubeList.add(new ModelBox(foot1, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		foot3 = new ModelRenderer(this);
		foot3.setRotationPoint(3.0F, 12.0F, -5.0F);
		foot3.cubeList.add(new ModelBox(foot3, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		foot2 = new ModelRenderer(this);
		foot2.setRotationPoint(-3.0F, 12.0F, 6.0F);
		foot2.cubeList.add(new ModelBox(foot2, 29, 31, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		foot4.render(f5);
		foot1.render(f5);
		foot3.render(f5);
		foot2.render(f5);
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
		this.foot1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.foot3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.foot2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.foot4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}