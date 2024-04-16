

package net.minecraftearthmod.client.renderer;




public class SkewbaldChickenRenderer extends MobRenderer<SkewbaldChickenEntity, Modeldefaultchicken_new<SkewbaldChickenEntity>> {

	public SkewbaldChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(SkewbaldChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/skewbald_chicken.png");
	}



}
