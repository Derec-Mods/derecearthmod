
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.PinkFootedPigEntity;
import net.minecraftearthmod.client.model.Modeldefaultpig_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PinkFootedPigRenderer extends MobRenderer<PinkFootedPigEntity, Modeldefaultpig_new<PinkFootedPigEntity>> {
	public PinkFootedPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PinkFootedPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/pinkfootedpig.png");
	}
}
