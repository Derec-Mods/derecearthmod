package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class IfFurnaceGolemAngryProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
if (entity.getPersistentData().getBoolean("pissed")) {return
true;}return
false;
}
}
