

package net.minecraftearthmod.client.renderer;




public class BronzedChickenRenderer extends MobRenderer<BronzedChickenEntity, Modeldefaultchicken_new<BronzedChickenEntity>> {

	public BronzedChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(BronzedChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/bronzed_chicken.png");
	}



}
