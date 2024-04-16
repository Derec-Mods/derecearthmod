package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class YouAteTheMudFormulaProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,180,6));if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.POISON,180,6));if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,180,9));if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION,180,1));if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,180,1));if (!(entity instanceof ServerPlayer _plr6 && _plr6.level instanceof ServerLevel && _plr6.getAdvancements()
.getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:eat_mud_formula"))).isDone())) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:eat_mud_formula"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
Iterator _iterator = _ap.getRemainingCriteria().iterator();
while(_iterator.hasNext())
_player.getAdvancements().award(_adv, (String)_iterator.next());
}
}}
}
}
