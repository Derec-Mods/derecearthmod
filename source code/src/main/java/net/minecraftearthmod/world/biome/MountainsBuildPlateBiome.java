
package net.minecraftearthmod.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraftearthmod.entity.WoolyCowEntity;
import net.minecraftearthmod.entity.RockySheepEntity;
import net.minecraftearthmod.entity.MelonGolemEntity;
import net.minecraftearthmod.entity.HornedSheepEntity;
import net.minecraftearthmod.entity.AshenCowEntity;
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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import com.google.common.collect.ImmutableList;

@MinecraftEarthModModElements.ModElement.Tag
public class MountainsBuildPlateBiome extends MinecraftEarthModModElements.ModElement {
	@ObjectHolder("minecraft_earth_mod:mountains_build_plate")
	public static final CustomBiome biome = null;
	public MountainsBuildPlateBiome(MinecraftEarthModModElements instance) {
		super(instance, 134);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.5f).temperature(0.1f).precipitation(Biome.RainType.SNOW)
					.category(Biome.Category.EXTREME_HILLS).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("mountains_build_plate");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/snowy/town_centers", 6)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.MEGA_SPRUCE_TREE.withConfiguration(DefaultBiomeFeatures.MEGA_SPRUCE_TREE_CONFIG)
											.withChance(0.33333334F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.SPRUCE_TREE_CONFIG)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(AshenCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(RockySheepEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(WoolyCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(HornedSheepEntity.entity, 15, 2, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MelonGolemEntity.entity, 15, 3, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 15, 3, 4));
		}
	}
}
