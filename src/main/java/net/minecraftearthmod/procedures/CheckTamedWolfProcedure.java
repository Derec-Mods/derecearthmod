package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckTamedWolfProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
return
entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame():false;
}
}
