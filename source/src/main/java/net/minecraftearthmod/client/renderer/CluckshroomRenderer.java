
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.CluckshroomEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class CluckshroomRenderer extends HumanoidMobRenderer<CluckshroomEntity, HumanoidModel<CluckshroomEntity>> {
	public CluckshroomRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.3f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(CluckshroomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/cluckshroom_2.png");
	}
}
