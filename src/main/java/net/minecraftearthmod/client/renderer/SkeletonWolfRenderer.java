
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.SkeletonWolfEntity;
import net.minecraftearthmod.client.model.Modelskeletonwolf_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SkeletonWolfRenderer extends MobRenderer<SkeletonWolfEntity, Modelskeletonwolf_new<SkeletonWolfEntity>> {
	public SkeletonWolfRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeletonwolf_new(context.bakeLayer(Modelskeletonwolf_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkeletonWolfEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/skeletonwolf.png");
	}
}
