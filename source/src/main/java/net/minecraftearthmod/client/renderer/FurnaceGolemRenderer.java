
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.FurnaceGolemEntity;
import net.minecraftearthmod.client.model.Modelfurnacegolem_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FurnaceGolemRenderer extends MobRenderer<FurnaceGolemEntity, Modelfurnacegolem_new<FurnaceGolemEntity>> {
	public FurnaceGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfurnacegolem_new(context.bakeLayer(Modelfurnacegolem_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FurnaceGolemEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/furnacegolem.png");
	}
}
