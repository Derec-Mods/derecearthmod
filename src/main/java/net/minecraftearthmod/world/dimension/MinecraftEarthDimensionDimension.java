
package net.minecraftearthmod.world.dimension;

@Mod.EventBusSubscriber public class MinecraftEarthDimensionDimension {

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) public static class Fixers {

		@SubscribeEvent @OnlyIn(Dist.CLIENT) public static void registerDimensionSpecialEffects(FMLClientSetupEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(128,
					true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {

				@Override public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
						return new Vec3(0.7529411765,0.8470588235,1);
				}

				@Override public boolean isFoggyAt(int x, int y) {
					return false;
				}

			};
			event.enqueueWork(() -> DimensionSpecialEffects.EFFECTS.put(new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"), customEffect));
		}

	}


}
