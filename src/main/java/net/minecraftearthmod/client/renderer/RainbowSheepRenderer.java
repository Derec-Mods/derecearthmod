

package net.minecraftearthmod.client.renderer;




public class RainbowSheepRenderer extends MobRenderer<RainbowSheepEntity, Modelrainbowsheepwool_NEW<RainbowSheepEntity>> {

	public RainbowSheepRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrainbowsheepwool_NEW(context.bakeLayer(Modelrainbowsheepwool_NEW.LAYER_LOCATION)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(RainbowSheepEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/rainbowsheepwool.png");
	}



}
