

package net.minecraftearthmod.client.renderer;




public class DyedCatRenderer extends MobRenderer<DyedCatEntity, Modeldyedcat_new<DyedCatEntity>> {

	public DyedCatRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldyedcat_new(context.bakeLayer(Modeldyedcat_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(DyedCatEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/dyedcat.png");
	}



}
