
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.RainbowSheepEntity;
import net.minecraftearthmod.client.model.Modelrainbowsheepwool_NEW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class RainbowSheepRenderer extends MobRenderer<RainbowSheepEntity, Modelrainbowsheepwool_NEW<RainbowSheepEntity>> {
	public RainbowSheepRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrainbowsheepwool_NEW(context.bakeLayer(Modelrainbowsheepwool_NEW.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RainbowSheepEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/rainbowsheepwool.png");
	}
}
