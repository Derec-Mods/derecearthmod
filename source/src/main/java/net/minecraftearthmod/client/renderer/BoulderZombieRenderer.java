
package net.minecraftearthmod.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraftearthmod.entity.model.BoulderZombieModel;
import net.minecraftearthmod.entity.BoulderZombieEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BoulderZombieRenderer extends GeoEntityRenderer<BoulderZombieEntity> {
	public BoulderZombieRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BoulderZombieModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(BoulderZombieEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
