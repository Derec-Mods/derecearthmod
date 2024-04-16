// Made with Blockbench 3.6.6

public static class Modelrainbowsheepnowool extends AnimatedEntityModel {

	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer leg1;
	private final AnimatedModelRenderer leg2;
	private final AnimatedModelRenderer leg3;
	private final AnimatedModelRenderer leg4;

	public Modelrainbowsheepnowool() {
		textureWidth = 64;
		textureHeight = 64;
		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(22, 10).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, 0.0F, true);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, -8.0F);
		head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F, 0.0F, true);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		leg1 = new AnimatedModelRenderer(this);
		leg1.setRotationPoint(3.0F, 12.0F, 7.0F);
		leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leg1.setModelRendererName("leg1");
		this.registerModelRenderer(leg1);

		leg2 = new AnimatedModelRenderer(this);
		leg2.setRotationPoint(-3.0F, 12.0F, 7.0F);
		leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leg2.setModelRendererName("leg2");
		this.registerModelRenderer(leg2);

		leg3 = new AnimatedModelRenderer(this);
		leg3.setRotationPoint(3.0F, 12.0F, -5.0F);
		leg3.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leg3.setModelRendererName("leg3");
		this.registerModelRenderer(leg3);

		leg4 = new AnimatedModelRenderer(this);
		leg4.setRotationPoint(-3.0F, 12.0F, -5.0F);
		leg4.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leg4.setModelRendererName("leg4");
		this.registerModelRenderer(leg4);

		this.rootBones.add(body);
		this.rootBones.add(head);
		this.rootBones.add(leg1);
		this.rootBones.add(leg2);
		this.rootBones.add(leg3);
		this.rootBones.add(leg4);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation("MODID", "animations/ANIMATIONFILE.json");
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}