

package net.minecraftearthmod.client.renderer;




public class WoolyCowRenderer extends MobRenderer<WoolyCowEntity, ModelwoolycowNEW<WoolyCowEntity>> {

	public WoolyCowRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelwoolycowNEW(context.bakeLayer(ModelwoolycowNEW.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(WoolyCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/woolycow.png");
	}



}
