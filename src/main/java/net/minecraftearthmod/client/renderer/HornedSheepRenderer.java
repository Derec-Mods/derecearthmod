
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.HornedSheepEntity;
import net.minecraftearthmod.client.model.ModelhornedsheepNEW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class HornedSheepRenderer extends MobRenderer<HornedSheepEntity, ModelhornedsheepNEW<HornedSheepEntity>> {
	public HornedSheepRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelhornedsheepNEW(context.bakeLayer(ModelhornedsheepNEW.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HornedSheepEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/hornedsheepnew.png");
	}
}
