
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.WoolyCowEntity;
import net.minecraftearthmod.client.model.ModelwoolycowNEW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class WoolyCowRenderer extends MobRenderer<WoolyCowEntity, ModelwoolycowNEW<WoolyCowEntity>> {
	public WoolyCowRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelwoolycowNEW(context.bakeLayer(ModelwoolycowNEW.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WoolyCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/woolycow.png");
	}
}
