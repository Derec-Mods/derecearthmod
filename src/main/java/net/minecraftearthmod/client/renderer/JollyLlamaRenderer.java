

package net.minecraftearthmod.client.renderer;




public class JollyLlamaRenderer extends MobRenderer<JollyLlamaEntity, Modeljollyllama_new<JollyLlamaEntity>> {

	public JollyLlamaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljollyllama_new(context.bakeLayer(Modeljollyllama_new.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(JollyLlamaEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/jollyllama.png");
	}



}
