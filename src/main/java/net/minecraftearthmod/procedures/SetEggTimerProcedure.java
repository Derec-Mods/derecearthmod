package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class SetEggTimerProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
entity.getPersistentData().putDouble("eggtimer", 0);
}
}
