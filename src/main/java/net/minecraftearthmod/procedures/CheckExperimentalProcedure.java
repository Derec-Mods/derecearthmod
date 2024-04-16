package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckExperimentalProcedure {
public static boolean execute(
LevelAccessor world
) {
return
world.getLevelData().getGameRules().getBoolean(MinecraftEarthModModGameRules.EXPERIMENTALMODE);
}
}
