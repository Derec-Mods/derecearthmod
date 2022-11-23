
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.TropicalSlimeBigEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class TropicalSlimeBigRenderer extends HumanoidMobRenderer<TropicalSlimeBigEntity, HumanoidModel<TropicalSlimeBigEntity>> {
	public TropicalSlimeBigRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 1f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(TropicalSlimeBigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/tropical_slime.png");
	}
}
