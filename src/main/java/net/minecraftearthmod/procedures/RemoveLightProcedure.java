package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class RemoveLightProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
if (new Object(){
public double getValue(LevelAccessor world, BlockPos pos, String tag) {
BlockEntity blockEntity=world.getBlockEntity(pos);
if(blockEntity != null) return blockEntity.getPersistentData().getDouble(tag);
return -1;
}
}.getValue(world, new BlockPos(x,y,z), "timer")>=3) {world.setBlock(new BlockPos(x,y,z), Blocks.AIR.defaultBlockState(), 3);}else{if(!world.isClientSide()) {
BlockPos _bp = new BlockPos(x,y,z);
BlockEntity _blockEntity = world.getBlockEntity(_bp);
BlockState _bs = world.getBlockState(_bp);
if(_blockEntity != null)
_blockEntity.getPersistentData().putDouble("timer", (new Object(){
public double getValue(LevelAccessor world, BlockPos pos, String tag) {
BlockEntity blockEntity=world.getBlockEntity(pos);
if(blockEntity != null) return blockEntity.getPersistentData().getDouble(tag);
return -1;
}
}.getValue(world, new BlockPos(x,y,z), "timer")+1));
if(world instanceof Level _level)
_level.sendBlockUpdated(_bp, _bs, _bs, 3);
}}
}
}
