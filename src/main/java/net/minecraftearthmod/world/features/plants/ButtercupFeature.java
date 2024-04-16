
package net.minecraftearthmod.world.features.plants;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ButtercupFeature extends RandomPatchFeature {

	public static ButtercupFeature FEATURE = null;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new ButtercupFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("minecraft_earth_mod:buttercup", FEATURE,
				FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
						new SimpleBlockConfiguration(BlockStateProvider.simple(MinecraftEarthModModBlocks.BUTTERCUP.get())),
						List.of(), 64)
		);
		PLACED_FEATURE = PlacementUtils.register("minecraft_earth_mod:buttercup", CONFIGURED_FEATURE,
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

	public ButtercupFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;


		return super.place(context);
	}
}

