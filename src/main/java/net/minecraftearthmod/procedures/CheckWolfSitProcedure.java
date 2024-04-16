package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckWolfSitProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
if ((entity.getPersistentData().getString("sit")).equals("standing")) {return
true;}return
false;
}
}
