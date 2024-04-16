

package net.minecraftearthmod.client.renderer;




public class PintoCowRenderer extends MobRenderer<PintoCowEntity, Modeldefaultcow_new<PintoCowEntity>> {

	public PintoCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(PintoCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/pintocow.png");
	}



}
