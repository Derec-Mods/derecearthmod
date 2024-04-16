// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelamberchicken extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer bill;
	private final ModelRenderer chin;
	private final ModelRenderer body;
	private final ModelRenderer rotation;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_wing;
	private final ModelRenderer left_wing;

	public Modelamberchicken() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F, false));

		bill = new ModelRenderer(this);
		bill.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bill);
		bill.cubeList.add(new ModelBox(bill, 14, 0, -2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F, false));

		chin = new ModelRenderer(this);
		chin.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(chin);
		chin.cubeList.add(new ModelBox(chin, 14, 4, -1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.cubeList.add(new ModelBox(rotation, 0, 9, -3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F, false));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(2.0F, 19.0F, 1.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(-1.0F, 19.0F, 1.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 26, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(-3.0F, 13.0F, 0.0F);
		right_wing.cubeList.add(new ModelBox(right_wing, 24, 13, -1.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, false));

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(3.0F, 13.0F, 0.0F);
		left_wing.cubeList.add(new ModelBox(left_wing, 24, 13, 0.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
		right_wing.render(f5);
		left_wing.render(f5);
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
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
	}
}