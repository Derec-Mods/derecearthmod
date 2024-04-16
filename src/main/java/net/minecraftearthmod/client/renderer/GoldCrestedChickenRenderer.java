

package net.minecraftearthmod.client.renderer;




public class GoldCrestedChickenRenderer extends MobRenderer<GoldCrestedChickenEntity, Modeldefaultchicken_new<GoldCrestedChickenEntity>> {

	public GoldCrestedChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(GoldCrestedChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/gold_crested_chicken.png");
	}



}
