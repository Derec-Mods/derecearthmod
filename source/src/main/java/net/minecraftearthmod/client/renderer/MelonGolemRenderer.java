
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.MelonGolemEntity;
import net.minecraftearthmod.client.model.Modelmelongolem_NEW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MelonGolemRenderer extends MobRenderer<MelonGolemEntity, Modelmelongolem_NEW<MelonGolemEntity>> {
	public MelonGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmelongolem_NEW(context.bakeLayer(Modelmelongolem_NEW.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MelonGolemEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/melongolem.png");
	}
}
