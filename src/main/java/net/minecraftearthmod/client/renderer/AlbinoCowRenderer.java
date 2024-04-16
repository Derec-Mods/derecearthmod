
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.AlbinoCowEntity;
import net.minecraftearthmod.client.model.Modeldefaultcow_new;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AlbinoCowRenderer extends MobRenderer<AlbinoCowEntity, Modeldefaultcow_new<AlbinoCowEntity>> {
	public AlbinoCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldefaultcow_new(context.bakeLayer(Modeldefaultcow_new.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AlbinoCowEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/albinocow6432.png");
	}
}
