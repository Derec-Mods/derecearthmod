package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class SpawnMobofMeProcedure {
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
if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.MOBOF_ME_ITEM.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (Math.random()<=0.9) {if (world instanceof ServerLevel _level) {
Entity entityToSpawn = new MobOfMeEntity(MinecraftEarthModModEntities.MOB_OF_ME.get(), _level);
entityToSpawn.moveTo(x, (y+1), z, world.getRandom().nextFloat() * 360F, 0);
if (entityToSpawn instanceof Mob _mobToSpawn)
_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
world.addFreshEntity(entityToSpawn);
}
}else{if (world instanceof ServerLevel _level) {
Entity entityToSpawn = new MerlEntity(MinecraftEarthModModEntities.MERL.get(), _level);
entityToSpawn.moveTo(x, (y+1), z, world.getRandom().nextFloat() * 360F, 0);
if (entityToSpawn instanceof Mob _mobToSpawn)
_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
world.addFreshEntity(entityToSpawn);
}
}
}
}
