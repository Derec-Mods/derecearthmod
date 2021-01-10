
package net.minecraftearthmod.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraftearthmod.entity.WoolyCowEntity;
import net.minecraftearthmod.entity.RockySheepEntity;
import net.minecraftearthmod.entity.MelonGolemEntity;
import net.minecraftearthmod.entity.HornedSheepEntity;
import net.minecraftearthmod.entity.AshenCowEntity;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

@MinecraftEarthModModElements.ModElement.Tag
public class MountainsBuildPlateBiome extends MinecraftEarthModModElements.ModElement {
	public static Biome biome;
	public MountainsBuildPlateBiome(MinecraftEarthModModElements instance) {
		super(instance, 134);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(7972607).withFoliageColor(10387789).withGrassColor(9470285).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
								Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
				biomeGenerationSettings.withStructure(StructureFeatures.VILLAGE_SNOWY);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
								new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
								new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0),
										FeatureSpread.func_242253_a(13, 4)),
								new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).build())
						.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
						.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 1))));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(2));
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AshenCowEntity.entity, 15, 2, 3));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(RockySheepEntity.entity, 15, 2, 3));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(WoolyCowEntity.entity, 15, 2, 3));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(HornedSheepEntity.entity, 15, 2, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(MelonGolemEntity.entity, 15, 3, 3));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 15, 3, 4));
				biome = new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.EXTREME_HILLS).depth(0.1f).scale(0.5f)
						.temperature(0.1f).downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("minecraft_earth_mod:mountains_build_plate"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)),
				BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
	}
}
