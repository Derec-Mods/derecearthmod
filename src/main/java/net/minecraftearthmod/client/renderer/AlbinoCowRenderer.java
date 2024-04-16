

package net.minecraftearthmod.client.renderer;




public class AlbinoCowRenderer extends MobRenderer<AlbinoCowEntity, Modeldefaultcow_new<AlbinoCowEntity>> {

	public AlbinoCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(AlbinoCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/albinocow6432.png");
	}



}
