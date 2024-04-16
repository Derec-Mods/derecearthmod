

package net.minecraftearthmod.client.renderer;




public class PalePigRenderer extends MobRenderer<PalePigEntity, Modeldefaultpig_new<PalePigEntity>> {

	public PalePigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(PalePigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/palepig.png");
	}



}
