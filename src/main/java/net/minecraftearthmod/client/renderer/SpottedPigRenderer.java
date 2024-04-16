

package net.minecraftearthmod.client.renderer;




public class SpottedPigRenderer extends MobRenderer<SpottedPigEntity, Modeldefaultpig_new<SpottedPigEntity>> {

	public SpottedPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(SpottedPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/spottedpig.png");
	}



}
