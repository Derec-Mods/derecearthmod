
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.GoldCrestedChickenEntity;
import net.minecraftearthmod.client.model.Modeldefaultchicken_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GoldCrestedChickenRenderer extends MobRenderer<GoldCrestedChickenEntity, Modeldefaultchicken_new<GoldCrestedChickenEntity>> {
	public GoldCrestedChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultchicken_new(context.bakeLayer(Modeldefaultchicken_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoldCrestedChickenEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/gold_crested_chicken.png");
	}
}
