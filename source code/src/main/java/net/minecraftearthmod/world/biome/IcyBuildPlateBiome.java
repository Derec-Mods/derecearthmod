
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
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

@MinecraftEarthModModElements.ModElement.Tag
public class IcyBuildPlateBiome extends MinecraftEarthModModElements.ModElement {
	@ObjectHolder("minecraft_earth_mod:icy_build_plate")
	public static final CustomBiome biome = null;
	public IcyBuildPlateBiome(MinecraftEarthModModElements instance) {
		super(instance, 142);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.RARE);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.7f).depth(0.1f).scale(0.1f).temperature(0.1f).precipitation(Biome.RainType.SNOW)
					.category(Biome.Category.ICY).waterColor(4159204).waterFogColor(329011).parent("minecraft_earth_mod:mountains_build_plate")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.ICE.getDefaultState(),
							Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())));
			setRegistryName("icy_build_plate");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			DefaultBiomeFeatures.addIcebergs(this);
			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/snowy/town_centers", 6)));
			this.addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(AshenCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(RockySheepEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(WoolyCowEntity.entity, 15, 2, 3));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(HornedSheepEntity.entity, 15, 2, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(MelonGolemEntity.entity, 15, 3, 3));
		}
	}
}
