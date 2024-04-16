

package net.minecraftearthmod.client.renderer;




public class TropicalSlimeSmallRenderer extends MobRenderer<TropicalSlimeSmallEntity, SlimeModel<TropicalSlimeSmallEntity>> {

	public TropicalSlimeSmallRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(TropicalSlimeSmallEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/tropical_slime.png");
	}



}
