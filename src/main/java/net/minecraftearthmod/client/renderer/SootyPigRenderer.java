

package net.minecraftearthmod.client.renderer;




public class SootyPigRenderer extends MobRenderer<SootyPigEntity, Modeldefaultpig_new<SootyPigEntity>> {

	public SootyPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(SootyPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/sootypig.png");
	}



}
