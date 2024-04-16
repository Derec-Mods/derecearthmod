
package net.minecraftearthmod.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

public class ForestBuildPlateBiome {



    public static Biome createBiome() {
            BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .skyColor(7972607)
                .foliageColorOverride(-8857051)
                .grassColorOverride(-8857051)
                .build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();


            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("minecraft_earth_mod:tree_forest_build_plate",
                FeatureUtils.register("minecraft_earth_mod:tree_forest_build_plate", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder
                    (
                        BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                    )
                        .ignoreVines()
            .build()), List.of(
				CountPlacement.of(5),
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
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MUDDY_PIG.get(), 3, 2, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.CLUCKSHROOM.get(), 10, 2, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.FURNACE_GOLEM.get(), 3, 1, 1));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MELON_GOLEM.get(), 10, 1, 2));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MOOBLOOM.get(), 10, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.ALBINO_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.AMBER_CHICKEN.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MIDNIGHT_CHICKEN.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.STORMY_CHICKEN.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.SPOTTED_PIG.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.PIE_BALD_PIG.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.PALE_PIG.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.ASHEN_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.SUNSET_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.PINK_FOOTED_PIG.get(), 15, 2, 3));

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.NONE)
            .temperature(0.5f)
            .downfall(0f)
            .specialEffects(effects)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(biomeGenerationSettings.build())
            .build();
    }

}

