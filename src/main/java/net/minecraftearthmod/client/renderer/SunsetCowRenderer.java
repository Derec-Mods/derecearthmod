

package net.minecraftearthmod.client.renderer;




public class SunsetCowRenderer extends MobRenderer<SunsetCowEntity, Modeldefaultcow_new<SunsetCowEntity>> {

	public SunsetCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(SunsetCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/sunsetcow.png");
	}



}
