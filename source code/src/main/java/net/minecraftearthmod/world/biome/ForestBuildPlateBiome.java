
package net.minecraftearthmod.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraftearthmod.entity.SunsetCowEntity;
import net.minecraftearthmod.entity.StormyChickenEntity;
import net.minecraftearthmod.entity.SpottedPigEntity;
import net.minecraftearthmod.entity.PinkFootedPigEntity;
import net.minecraftearthmod.entity.PieBaldPigEntity;
import net.minecraftearthmod.entity.PalePigEntity;
import net.minecraftearthmod.entity.MuddyPigEntity;
import net.minecraftearthmod.entity.MoobloomEntity;
import net.minecraftearthmod.entity.MidnightChickenEntity;
import net.minecraftearthmod.entity.MelonGolemEntity;
import net.minecraftearthmod.entity.FurnaceGolemEntity;
import net.minecraftearthmod.entity.CluckshroomEntity;
import net.minecraftearthmod.entity.AshenCowEntity;
import net.minecraftearthmod.entity.AmberChickenEntity;
import net.minecraftearthmod.entity.AlbinoCowEntity;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import com.google.common.collect.ImmutableList;

@MinecraftEarthModModElements.ModElement.Tag
public class ForestBuildPlateBiome extends MinecraftEarthModModElements.ModElement {
	@ObjectHolder("minecraft_earth_mod:forest_build_plate")
	public static final CustomBiome biome = null;
	public ForestBuildPlateBiome(MinecraftEarthModModElements instance) {
		super(instance, 141);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.1f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).parent("minecraft_earth_mod:plains_build_plate")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("forest_build_plate");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(3))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230129_h_).withChance(0.2F),
											Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.field_230131_m_).withChance(0.1F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230132_o_)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MuddyPigEntity.entity, 3, 2, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(CluckshroomEntity.entity, 10, 2, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(FurnaceGolemEntity.entity, 3, 1, 1));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MelonGolemEntity.entity, 10, 1, 2));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MoobloomEntity.entity, 10, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(AlbinoCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(AmberChickenEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MidnightChickenEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(StormyChickenEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(SpottedPigEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PieBaldPigEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PalePigEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(AshenCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(SunsetCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PinkFootedPigEntity.entity, 15, 2, 3));
		}
	}
}
