
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.PalePigEntity;
import net.minecraftearthmod.client.model.Modeldefaultpig_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PalePigRenderer extends MobRenderer<PalePigEntity, Modeldefaultpig_new<PalePigEntity>> {
	public PalePigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PalePigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/palepig.png");
	}
}
