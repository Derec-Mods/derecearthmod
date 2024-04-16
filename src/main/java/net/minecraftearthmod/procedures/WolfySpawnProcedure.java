package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class WolfySpawnProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
entity.getPersistentData().putString("sit", "standing");
}
}
