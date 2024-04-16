

package net.minecraftearthmod.client.renderer;




public class TropicalSlimeBigRenderer extends MobRenderer<TropicalSlimeBigEntity, SlimeModel<TropicalSlimeBigEntity>> {

	public TropicalSlimeBigRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 1f);


	}


	@Override public ResourceLocation getTextureLocation(TropicalSlimeBigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/tropical_slime.png");
	}



}
