

package net.minecraftearthmod.client.renderer;




public class MerlRenderer extends HumanoidMobRenderer<MerlEntity, HumanoidModel<MerlEntity>> {

	public MerlRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}


	@Override public ResourceLocation getTextureLocation(MerlEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/merl.png");
	}



}
