
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.MoolipEntity;
import net.minecraftearthmod.client.model.Modelpinkmoobloom_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MoolipRenderer extends MobRenderer<MoolipEntity, Modelpinkmoobloom_new<MoolipEntity>> {
	public MoolipRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpinkmoobloom_new(context.bakeLayer(Modelpinkmoobloom_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MoolipEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/moolip.png");
	}
}
