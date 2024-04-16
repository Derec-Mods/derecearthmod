

package net.minecraftearthmod.client.renderer;




public class PieBaldPigRenderer extends MobRenderer<PieBaldPigEntity, Modeldefaultpig_new<PieBaldPigEntity>> {

	public PieBaldPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(PieBaldPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/piebaldpig.png");
	}



}
