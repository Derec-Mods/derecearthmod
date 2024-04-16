
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.DyedCatEntity;
import net.minecraftearthmod.client.model.Modeldyedcat_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DyedCatRenderer extends MobRenderer<DyedCatEntity, Modeldyedcat_new<DyedCatEntity>> {
	public DyedCatRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldyedcat_new(context.bakeLayer(Modeldyedcat_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DyedCatEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/dyedcat.png");
	}
}
