package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CleanPigWaterProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
Entity sourceentity
) {
if(
entity == null ||
sourceentity == null
) return ;
if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {if (entity instanceof LivingEntity _entity) {
ItemStack _setstack = new ItemStack(Items.BUCKET);
_setstack.setCount(1);
_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
if (_entity instanceof Player _player) _player.getInventory().setChanged();
}
CleanAPigProcedure.execute(world,x,y,z,entity)
;
}
}
}
