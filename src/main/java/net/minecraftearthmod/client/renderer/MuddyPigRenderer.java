
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.MuddyPigEntity;
import net.minecraftearthmod.client.model.Modelmuddypig_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, Modelmuddypig_new<MuddyPigEntity>> {
	public MuddyPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmuddypig_new(context.bakeLayer(Modelmuddypig_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MuddyPigEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/muddypig.png");
	}
}
