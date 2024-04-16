
package net.minecraftearthmod.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

public class JungleBuildPlateBiome {



    public static Biome createBiome() {
            BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .skyColor(7972607)
                .foliageColorOverride(-14714610)
                .grassColorOverride(-10777806)
                .build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();


            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("minecraft_earth_mod:tree_jungle_build_plate",
                FeatureUtils.register("minecraft_earth_mod:tree_jungle_build_plate", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder
                    (
                        BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                        new StraightTrunkPlacer(1, 2, 0),
                        BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                    )
.decorators(ImmutableList.of(
		JungleBuildPlateLeaveDecorator.INSTANCE,
		JungleBuildPlateTrunkDecorator.INSTANCE

	    ,
        JungleBuildPlateFruitDecorator.INSTANCE
))
            .build()), List.of(
				CountPlacement.of(1),
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
				BiomeFilter.biome()
            )));



            BiomeDefaultFeatures.addJungleTrees(biomeGenerationSettings);

            BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);

            BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);

            BiomeDefaultFeatures.addBambooVegetation(biomeGenerationSettings);

            BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);

            BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MELON_GOLEM.get(), 20, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.RAINBOW_SHEEP.get(), 1, 1, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.PARROT, 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 15, 1, 3));

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.95f)
            .downfall(0.6f)
            .specialEffects(effects)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(biomeGenerationSettings.build())
            .build();
    }

}

