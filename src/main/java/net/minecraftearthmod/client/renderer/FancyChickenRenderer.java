

package net.minecraftearthmod.client.renderer;




public class FancyChickenRenderer extends MobRenderer<FancyChickenEntity, Modelfancychicken_new<FancyChickenEntity>> {

	public FancyChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfancychicken_new(context.bakeLayer(Modelfancychicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(FancyChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/fancy_chicken.png");
	}



}
