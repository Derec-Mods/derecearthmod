
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.TropicalSlimeSmallEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

public class TropicalSlimeSmallRenderer extends MobRenderer<TropicalSlimeSmallEntity, SlimeModel<TropicalSlimeSmallEntity>> {
	public TropicalSlimeSmallRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TropicalSlimeSmallEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/tropical_slime.png");
	}
}
