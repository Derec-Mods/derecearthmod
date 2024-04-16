package net.minecraftearthmod.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraftearthmod.entity.BoulderZombieEntity;

import net.minecraft.resources.ResourceLocation;

public class BoulderZombieModel extends AnimatedGeoModel<BoulderZombieEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoulderZombieEntity entity) {
		return new ResourceLocation("minecraft_earth_mod", "animations/boulderzombienew.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoulderZombieEntity entity) {
		return new ResourceLocation("minecraft_earth_mod", "geo/boulderzombienew.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoulderZombieEntity entity) {
		return new ResourceLocation("minecraft_earth_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
