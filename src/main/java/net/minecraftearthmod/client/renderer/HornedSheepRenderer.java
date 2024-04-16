

package net.minecraftearthmod.client.renderer;




public class HornedSheepRenderer extends MobRenderer<HornedSheepEntity, ModelhornedsheepNEW<HornedSheepEntity>> {

	public HornedSheepRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelhornedsheepNEW(context.bakeLayer(ModelhornedsheepNEW.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(HornedSheepEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/hornedsheepnew.png");
	}



}
