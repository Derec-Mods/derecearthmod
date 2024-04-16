
package net.minecraftearthmod.world.features.ores;

public class RubyBlockFeature extends OreFeature {

	public static RubyBlockFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new RubyBlockFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("minecraft_earth_mod:ruby_block", FEATURE,
			new OreConfiguration(
				List.of(
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.STONE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_BLOCK.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_BLOCK.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_BLOCK.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_BLOCK.get().defaultBlockState()
						)				),
				1
			)
		);
		PLACED_FEATURE = PlacementUtils.register("minecraft_earth_mod:ruby_block", CONFIGURED_FEATURE, List.of(
			CountPlacement.of(1),
			InSquarePlacement.spread(),
			HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(12)),
			BiomeFilter.biome()
		));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(
				ResourceKey.create(Registry.DIMENSION_REGISTRY,
						new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"))
				);

	public RubyBlockFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;


		return super.place(context);
	}

}

