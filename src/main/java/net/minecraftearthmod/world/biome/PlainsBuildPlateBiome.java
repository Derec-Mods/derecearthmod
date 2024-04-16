
package net.minecraftearthmod.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

public class PlainsBuildPlateBiome {



    public static Biome createBiome() {
            BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .skyColor(7972607)
                .foliageColorOverride(-5843849)
                .grassColorOverride(-5836737)
                .build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();







            BiomeDefaultFeatures.addSavannaGrass(biomeGenerationSettings);

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
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 15, 2, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.COW, 15, 3, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.PIG, 15, 3, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 15, 3, 4));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.COOKIE_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.PINTO_COW.get(), 15, 2, 3));
			mobSpawnInfo.addSpawn(MobCategory.CREATURE,
				new MobSpawnSettings.SpawnerData(MinecraftEarthModModEntities.MOOLIP.get(), 15, 2, 3));

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.5f)
            .downfall(0.5f)
            .specialEffects(effects)
            .mobSpawnSettings(mobSpawnInfo.build())
            .generationSettings(biomeGenerationSettings.build())
            .build();
    }

}

