

package net.minecraftearthmod.client.renderer;




public class VillerWitchRenderer extends MobRenderer<VillerWitchEntity, Modelvilerwitch_NEW<VillerWitchEntity>> {

	public VillerWitchRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvilerwitch_NEW(context.bakeLayer(Modelvilerwitch_NEW.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(VillerWitchEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/villerwitch.png");
	}



}
