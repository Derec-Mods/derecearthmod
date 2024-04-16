package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class EatButtercupProcedure {
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
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,60,1, false, false));if (entity instanceof Player _player) {
ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE);
_setstack.setCount(1);
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}
}
}
