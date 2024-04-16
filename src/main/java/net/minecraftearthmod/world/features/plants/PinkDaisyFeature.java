
package net.minecraftearthmod.world.features.plants;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class PinkDaisyFeature extends RandomPatchFeature {

	public static PinkDaisyFeature FEATURE = null;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new PinkDaisyFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("minecraft_earth_mod:pink_daisy", FEATURE,
				FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
						new SimpleBlockConfiguration(BlockStateProvider.simple(MinecraftEarthModModBlocks.PINK_DAISY.get())),
						List.of(), 64)
		);
		PLACED_FEATURE = PlacementUtils.register("minecraft_earth_mod:pink_daisy", CONFIGURED_FEATURE,
				List.of(
			CountPlacement.of(1),
			RarityFilter.onAverageOnceEvery(32),
			InSquarePlacement.spread(),
			PlacementUtils.HEIGHTMAP
			,
			 BiomeFilter.biome()
		));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(
				Level.OVERWORLD
	);

	public PinkDaisyFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;


		return super.place(context);
	}
}

