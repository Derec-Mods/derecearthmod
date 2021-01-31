
package net.minecraftearthmod.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraftearthmod.entity.RainbowSheepEntity;
import net.minecraftearthmod.entity.MelonGolemEntity;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

@MinecraftEarthModModElements.ModElement.Tag
public class JungleBuildPlateBiome extends MinecraftEarthModModElements.ModElement {
	@ObjectHolder("minecraft_earth_mod:jungle_build_plate")
	public static final CustomBiome biome = null;
	public JungleBuildPlateBiome(MinecraftEarthModModElements instance) {
		super(instance, 153);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.JUNGLE);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.6f).depth(0.1f).scale(0.3f).temperature(0.95f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.JUNGLE).waterColor(4159204).waterFogColor(329011).parent("minecraft_earth_mod:plains_build_plate")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())));
			setRegistryName("jungle_build_plate");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			DefaultBiomeFeatures.addBamboo(this);
			DefaultBiomeFeatures.addJungleGrass(this);
			DefaultBiomeFeatures.addJungleTreeForest(this);
			this.addStructure(Feature.JUNGLE_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(6))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MelonGolemEntity.entity, 20, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(RainbowSheepEntity.entity, 1, 1, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.OCELOT, 15, 1, 3));
		}
	}
}
