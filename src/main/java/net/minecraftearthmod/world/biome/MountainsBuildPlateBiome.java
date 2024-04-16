
package net.minecraftearthmod.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

public class MountainsBuildPlateBiome {



    public static Biome createBiome() {
            BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .skyColor(7972607)
                .foliageColorOverride(-7686519)
                .grassColorOverride(-7686519)
                .build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();


            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("minecraft_earth_mod:tree_mountains_build_plate",
                FeatureUtils.register("minecraft_earth_mod:tree_mountains_build_plate", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder
                    (
                        BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                        new GiantTrunkPlacer(13, 2, 14),
                        BlockStateProvider.simple(Blocks.SPRUCE_LEAVES.defaultBlockState()),
                        new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),
                        new TwoLayersFeatureSize(1, 1, 2)
                    )
                    .decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL.defaultBlockState()))))
            .build()), List.of(
				CountPlacement.of(2),
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
				BiomeFilter.biome()
            )));






            BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);

            BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);

            BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);

            BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);

            BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenerationSettings);

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.ASHEN_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.ROCKY_SHEEP.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.WOOLY_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.HORNED_SHEEP.get(), 15, 2, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MELON_GOLEM.get(), 15, 3, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 15, 3, 4));

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.SNOW)
            .temperature(0.1f)
            .downfall(0.5f)
            .specialEffects(effects)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(biomeGenerationSettings.build())
            .build();
    }

}

