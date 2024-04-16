
package net.minecraftearthmod.item;

public class MinecraftEarthDimensionItem extends Item {

	public MinecraftEarthDimensionItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(64));
	}

	@Override public InteractionResult useOn(UseOnContext context) {
		Player entity = context.getPlayer();
		BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
		ItemStack itemstack = context.getItemInHand();
		Level world = context.getLevel();
		if (!entity.mayUseItemAt(pos, context.getClickedFace(), itemstack)) {
			return InteractionResult.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			boolean success = false;

			if (world.isEmptyBlock(pos) &&         

    CheckEarthDimensionGameruleProcedure.execute(world)

) {
				MinecraftEarthDimensionPortalBlock.portalSpawn(world, pos);
				itemstack.hurtAndBreak(1, entity, c -> c.broadcastBreakEvent(context.getHand()));
				success = true;
			}

				return success ? InteractionResult.SUCCESS : InteractionResult.FAIL;
		}
	}
}

