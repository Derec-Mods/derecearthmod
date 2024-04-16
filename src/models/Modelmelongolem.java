// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelmelongolem extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer left_hand;
	private final ModelRenderer right_hand;
	private final ModelRenderer body;
	private final ModelRenderer body_bottom;

	public Modelmelongolem() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 32, 8, -4.0F, -8.0F, -4.0F, 8, 8, 8, -0.5F, true));

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(8.0F, -9.0F, 0.0F);
		setRotationAngle(left_hand, 0.0F, 0.0F, -0.8727F);
		left_hand.cubeList.add(new ModelBox(left_hand, 32, 0, -31.0F, 0.0F, -1.0F, 12, 2, 2, -0.5F, true));

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(3.0F, -7.0F, 0.0F);
		setRotationAngle(right_hand, 0.0F, 0.0F, 0.8727F);
		right_hand.cubeList.add(new ModelBox(right_hand, 32, 0, 9.766F, 7.6428F, -1.0F, 12, 2, 2, -0.5F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 16, -5.0F, -10.0F, -5.0F, 10, 10, 10, -0.5F, true));

		body_bottom = new ModelRenderer(this);
		body_bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
		body_bottom.cubeList.add(new ModelBox(body_bottom, 0, 36, -6.0F, -12.0F, -6.0F, 12, 12, 12, -0.5F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		left_hand.render(f5);
		right_hand.render(f5);
		body.render(f5);
		body_bottom.render(f5);
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
	}
}