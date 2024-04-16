
package net.minecraftearthmod.world.features;

public class MuddySpring1Feature extends Feature<NoneFeatureConfiguration> {
public static MuddySpring1Feature FEATURE = null;
public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
public static Holder<PlacedFeature> PLACED_FEATURE = null;
public static Feature<?> feature() {
FEATURE = new MuddySpring1Feature();
CONFIGURED_FEATURE = FeatureUtils.register("minecraft_earth_mod:muddy_spring_1", FEATURE, FeatureConfiguration.NONE);
PLACED_FEATURE = PlacementUtils.register("minecraft_earth_mod:muddy_spring_1", CONFIGURED_FEATURE, List.of());
return FEATURE;
}
private final Set<ResourceKey<Level>> generate_dimensions = Set.of(
Level.OVERWORLD
);
private StructureTemplate template = null;
public MuddySpring1Feature() {
super(NoneFeatureConfiguration.CODEC);
}
@Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
if (!generate_dimensions.contains(context.level().getLevel().dimension()))
return false;
if (template == null)
template = context.level().getLevel().getStructureManager()
.getOrCreate(new ResourceLocation("minecraft_earth_mod", "mudfountain2"));
if (template == null)
return false;
boolean anyPlaced = false;
if ((context.random().nextInt(1000000) + 1) <= 1000) {
int count = context.random().nextInt(1) + 1;
for (int a = 0; a < count; a++) {
int i = context.origin().getX() + context.random().nextInt(16);
int k = context.origin().getZ() + context.random().nextInt(16);
int j = context.level().getHeight(
Heightmap.Types.OCEAN_FLOOR_WG, i, k
) - 1;
BlockPos spawnTo = new BlockPos(i + 0, j + -1, k + 0);
WorldGenLevel world = context.level();
int x = spawnTo.getX();
int y = spawnTo.getY();
int z = spawnTo.getZ();
if (!
GetSpawnMudFountainProcedure.execute(world)
)
continue;
if (template.placeInWorld(context.level(), spawnTo, spawnTo, new StructurePlaceSettings()
.setMirror(Mirror.values()[context.random().nextInt(2)])
.setRotation(Rotation.values()[context.random().nextInt(3)])
.setRandom(context.random())
.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK)
.setIgnoreEntities(false), context.random(), 2)) {
anyPlaced = true;
}
}
}
return anyPlaced;
}
}