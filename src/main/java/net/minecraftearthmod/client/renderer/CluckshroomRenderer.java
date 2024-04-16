

package net.minecraftearthmod.client.renderer;




public class CluckshroomRenderer extends MobRenderer<CluckshroomEntity, Modelcluckshroom_new<CluckshroomEntity>> {

	public CluckshroomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcluckshroom_new(context.bakeLayer(Modelcluckshroom_new.LAYER_LOCATION)), 0.3f);


	}


	@Override public ResourceLocation getTextureLocation(CluckshroomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/cluckshroom_2.png");
	}



}
