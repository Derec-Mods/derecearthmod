package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class SetPissedProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
entity.getPersistentData().putBoolean("pissed", false);entity.getPersistentData().putDouble("calmtimer", 7000);
}
}
