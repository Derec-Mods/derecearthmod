

package net.minecraftearthmod.client.renderer;




public class AmberChickenRenderer extends MobRenderer<AmberChickenEntity, Modeldefaultchicken_new<AmberChickenEntity>> {

	public AmberChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(AmberChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/amberchicken.png");
	}



}
