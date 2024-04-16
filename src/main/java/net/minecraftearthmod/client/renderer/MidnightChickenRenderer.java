

package net.minecraftearthmod.client.renderer;




public class MidnightChickenRenderer extends MobRenderer<MidnightChickenEntity, Modeldefaultchicken_new<MidnightChickenEntity>> {

	public MidnightChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(MidnightChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/midnightchicken.png");
	}



}
