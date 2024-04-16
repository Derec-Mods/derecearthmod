

package net.minecraftearthmod.client.renderer;




public class StormyChickenRenderer extends MobRenderer<StormyChickenEntity, Modeldefaultchicken_new<StormyChickenEntity>> {

	public StormyChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(StormyChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/stormychicken.png");
	}



}
