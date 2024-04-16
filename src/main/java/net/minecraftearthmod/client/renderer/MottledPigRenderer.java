

package net.minecraftearthmod.client.renderer;




public class MottledPigRenderer extends MobRenderer<MottledPigEntity, Modeldefaultpig_new<MottledPigEntity>> {

	public MottledPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(MottledPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/molttledpig.png");
	}



}
