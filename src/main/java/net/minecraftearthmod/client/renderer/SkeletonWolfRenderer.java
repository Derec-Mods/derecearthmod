

package net.minecraftearthmod.client.renderer;




public class SkeletonWolfRenderer extends MobRenderer<SkeletonWolfEntity, Modelskeletonwolf_new<SkeletonWolfEntity>> {

	public SkeletonWolfRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeletonwolf_new(context.bakeLayer(Modelskeletonwolf_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(SkeletonWolfEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/skeletonwolf.png");
	}



}
