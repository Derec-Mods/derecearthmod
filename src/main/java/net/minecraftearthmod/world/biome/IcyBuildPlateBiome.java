
package net.minecraftearthmod.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

public class IcyBuildPlateBiome {



    public static Biome createBiome() {
            BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(-8856848)
                .waterFogColor(329011)
                .skyColor(7972607)
                .foliageColorOverride(-8856848)
                .grassColorOverride(-8856833)
                    .ambientParticle(new AmbientParticleSettings(ParticleTypes.SNOWFLAKE, 0f))
                .build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();






            BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);

            BiomeDefaultFeatures.addIcebergs(biomeGenerationSettings);

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

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.SNOW)
            .temperature(0.1f)
            .downfall(0.7f)
            .specialEffects(effects)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(biomeGenerationSettings.build())
            .build();
    }

}

