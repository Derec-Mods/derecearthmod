

package net.minecraftearthmod.client.renderer;




public class MelonGolemRenderer extends MobRenderer<MelonGolemEntity, Modelmelongolem_NEW<MelonGolemEntity>> {

	public MelonGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmelongolem_NEW(context.bakeLayer(Modelmelongolem_NEW.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(MelonGolemEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/melongolem.png");
	}



}
