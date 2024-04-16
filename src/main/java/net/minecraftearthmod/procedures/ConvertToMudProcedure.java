package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class ConvertToMudProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
if ((world.getBlockState(new BlockPos(x,y-1,z))).getBlock() == Blocks.WATER) {{
BlockPos _bp = new BlockPos(x,y-1,z);
BlockState _bs = Blocks.MUD.defaultBlockState();
BlockState _bso = world.getBlockState(_bp);
for(Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
if (_property != null && _bs.getValue(_property) != null)
try {
_bs = _bs.setValue(_property, (Comparable) entry.getValue());
} catch (Exception e) {}
}
world.setBlock(_bp, _bs, 3);
}
}
}
}
