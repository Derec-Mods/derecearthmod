

package net.minecraftearthmod.client.renderer;




public class PinkMoobloomRenderer extends MobRenderer<PinkMoobloomEntity, Modelpinkmoobloom_new<PinkMoobloomEntity>> {

	public PinkMoobloomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpinkmoobloom_new(context.bakeLayer(Modelpinkmoobloom_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(PinkMoobloomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/pinkmoobloom.png");
	}



}
