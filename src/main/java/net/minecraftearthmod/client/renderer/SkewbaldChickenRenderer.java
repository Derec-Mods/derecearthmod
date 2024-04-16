
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.SkewbaldChickenEntity;
import net.minecraftearthmod.client.model.Modeldefaultchicken_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SkewbaldChickenRenderer extends MobRenderer<SkewbaldChickenEntity, Modeldefaultchicken_new<SkewbaldChickenEntity>> {
	public SkewbaldChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkewbaldChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/skewbald_chicken.png");
	}
}
