

package net.minecraftearthmod.client.renderer;




public class DriedMuddyPigRenderer extends MobRenderer<DriedMuddyPigEntity, Modeldefaultpig_new<DriedMuddyPigEntity>> {

	public DriedMuddyPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(DriedMuddyPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/driedmuddypig.png");
	}



}
