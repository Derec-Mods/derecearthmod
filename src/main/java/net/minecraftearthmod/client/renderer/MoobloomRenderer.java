

package net.minecraftearthmod.client.renderer;




public class MoobloomRenderer extends MobRenderer<MoobloomEntity, Modelmoobloom_new<MoobloomEntity>> {

	public MoobloomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmoobloom_new(context.bakeLayer(Modelmoobloom_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(MoobloomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/moobloom.png");
	}



}
