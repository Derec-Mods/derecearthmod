
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.MoobloomEntity;
import net.minecraftearthmod.client.model.Modelmoobloom_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MoobloomRenderer extends MobRenderer<MoobloomEntity, Modelmoobloom_new<MoobloomEntity>> {
	public MoobloomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmoobloom_new(context.bakeLayer(Modelmoobloom_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MoobloomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/moobloom.png");
	}
}
