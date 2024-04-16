package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class WolfTameProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
return
!(entity.getPersistentData().getString("isTame")).equals("yes");
}
}
