
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.BruleCowEntity;
import net.minecraftearthmod.client.model.Modeldefaultcow_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BruleCowRenderer extends MobRenderer<BruleCowEntity, Modeldefaultcow_new<BruleCowEntity>> {
	public BruleCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BruleCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/cream_cow.png");
	}
}
