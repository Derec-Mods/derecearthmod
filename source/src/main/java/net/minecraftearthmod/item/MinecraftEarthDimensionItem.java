
package net.minecraftearthmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraftearthmod.world.dimension.MinecraftEarthDimensionDimension;
import net.minecraftearthmod.procedures.CheckEarthDimensionGameruleProcedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import com.google.common.collect.ImmutableMap;

public class MinecraftEarthDimensionItem extends Item {
	@ObjectHolder("minecraft_earth_mod:minecraft_earth_dimension")
	public static final Item block = null;
	public MinecraftEarthDimensionItem() {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			boolean success = false;
			if (world.isAirBlock(pos) && CheckEarthDimensionGameruleProcedure.executeProcedure(ImmutableMap.of("world", world))) {
				MinecraftEarthDimensionDimension.portal.portalSpawn(world, pos);
				itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
				success = true;
			}
			return success ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		}
	}
}
