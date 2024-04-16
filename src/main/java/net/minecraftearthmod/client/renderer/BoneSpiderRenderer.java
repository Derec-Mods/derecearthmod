

package net.minecraftearthmod.client.renderer;




public class BoneSpiderRenderer extends MobRenderer<BoneSpiderEntity, SpiderModel<BoneSpiderEntity>> {

	public BoneSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(BoneSpiderEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/bonespider.png");
	}



}
