
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.BoneSpiderEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

public class BoneSpiderRenderer extends MobRenderer<BoneSpiderEntity, SpiderModel<BoneSpiderEntity>> {
	public BoneSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BoneSpiderEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/bonespider.png");
	}
}
