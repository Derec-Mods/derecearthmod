
package net.minecraftearthmod.world.features;

import net.minecraftearthmod.world.features.configurations.StructureFeatureConfiguration;
import net.minecraftearthmod.procedures.GetSpawnMudFountainProcedure;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class MuddySpring1FeatureFeature extends StructureFeature {
	public MuddySpring1FeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!GetSpawnMudFountainProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
