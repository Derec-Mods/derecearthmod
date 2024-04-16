
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.DriedMuddyPigEntity;
import net.minecraftearthmod.client.model.Modeldefaultpig_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DriedMuddyPigRenderer extends MobRenderer<DriedMuddyPigEntity, Modeldefaultpig_new<DriedMuddyPigEntity>> {
	public DriedMuddyPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultpig_new(context.bakeLayer(Modeldefaultpig_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DriedMuddyPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/driedmuddypig.png");
	}
}
