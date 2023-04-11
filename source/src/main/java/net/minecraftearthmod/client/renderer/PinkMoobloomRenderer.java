
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.PinkMoobloomEntity;
import net.minecraftearthmod.client.model.Modelpinkmoobloom_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PinkMoobloomRenderer extends MobRenderer<PinkMoobloomEntity, Modelpinkmoobloom_new<PinkMoobloomEntity>> {
	public PinkMoobloomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpinkmoobloom_new(context.bakeLayer(Modelpinkmoobloom_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PinkMoobloomEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/pinkmoobloom.png");
	}
}
