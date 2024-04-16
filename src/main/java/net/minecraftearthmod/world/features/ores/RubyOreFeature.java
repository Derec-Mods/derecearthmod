
package net.minecraftearthmod.world.features.ores;

public class RubyOreFeature extends OreFeature {

	public static RubyOreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new RubyOreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("minecraft_earth_mod:ruby_ore", FEATURE,
			new OreConfiguration(
				List.of(
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.STONE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_ORE.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_ORE.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_ORE.get().defaultBlockState()
						),
						OreConfiguration.target(
							new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()),
							MinecraftEarthModModBlocks.RUBY_ORE.get().defaultBlockState()
						)				),
				3
			)
		);
		PLACED_FEATURE = PlacementUtils.register("minecraft_earth_mod:ruby_ore", CONFIGURED_FEATURE, List.of(
			CountPlacement.of(9),
			InSquarePlacement.spread(),
			HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)),
			BiomeFilter.biome()
		));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(
				Level.OVERWORLD
,
				ResourceKey.create(Registry.DIMENSION_REGISTRY,
						new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"))
				);

	public RubyOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;


		return super.place(context);
	}

}

