
package net.minecraftearthmod.client.renderer;

import net.minecraftearthmod.entity.RockySheepEntity;
import net.minecraftearthmod.client.model.ModelrockysheepNEW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class RockySheepRenderer extends MobRenderer<RockySheepEntity, ModelrockysheepNEW<RockySheepEntity>> {
	public RockySheepRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelrockysheepNEW(context.bakeLayer(ModelrockysheepNEW.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RockySheepEntity entity) {
		return new ResourceLocation("minecraft_earth_mod:textures/entities/rockysheep.png");
	}
}
