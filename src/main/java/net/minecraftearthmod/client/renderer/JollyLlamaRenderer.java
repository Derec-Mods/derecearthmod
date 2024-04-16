
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.JollyLlamaEntity;
import net.minecraftearthmod.client.model.Modeljollyllama_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class JollyLlamaRenderer extends MobRenderer<JollyLlamaEntity, Modeljollyllama_new<JollyLlamaEntity>> {
	public JollyLlamaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljollyllama_new(context.bakeLayer(Modeljollyllama_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(JollyLlamaEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/jollyllama.png");
	}
}
