package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckShopProcedure {
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
if ((world.getBlockState(new BlockPos(x,y-1,z))).getBlock() == Blocks.DISPENSER||(world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Blocks.DISPENSER) {{
if(entity instanceof ServerPlayer _ent) {
BlockPos _bpos = new BlockPos(x,y,z);
NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
@Override public Component getDisplayName() {
return Component.literal("RubyShop");
}
@Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
return new RubyShopMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
}
}, _bpos);
}
}
PlayOpenSoundProcedure.execute(world,x,y,z)
;
}
}
}
