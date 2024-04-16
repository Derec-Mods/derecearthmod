

package net.minecraftearthmod.client.renderer;




public class DairyCowRenderer extends MobRenderer<DairyCowEntity, Modeldefaultcow_new<DairyCowEntity>> {

	public DairyCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(DairyCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/dairycow.png");
	}



}
