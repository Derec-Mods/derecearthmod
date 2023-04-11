
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.TropicalSlimeBigEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

public class TropicalSlimeBigRenderer extends MobRenderer<TropicalSlimeBigEntity, SlimeModel<TropicalSlimeBigEntity>> {
	public TropicalSlimeBigRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(TropicalSlimeBigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/tropical_slime.png");
	}
}
