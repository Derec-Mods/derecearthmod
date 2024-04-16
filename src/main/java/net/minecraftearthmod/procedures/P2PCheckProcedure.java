package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class P2PCheckProcedure {
public static void execute(
LevelAccessor world,
Entity entity
) {
if(
entity == null
) return ;
if ((MinecraftEarthModModVariables.MapVariables.get(world).paidyet).equals("yes")) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:p_2_p"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
Iterator _iterator = _ap.getRemainingCriteria().iterator();
while(_iterator.hasNext())
_player.getAdvancements().award(_adv, (String)_iterator.next());
}
}}
}
}
