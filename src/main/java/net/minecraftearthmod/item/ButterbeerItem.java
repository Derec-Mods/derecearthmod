

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class ButterbeerItem extends Item {

	public ButterbeerItem() {
		super(new Item.Properties()
				.tab(CreativeModeTab.TAB_FOOD)
				.stacksTo(1)
				.rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder())
					.nutrition(4)
					.saturationMod(0.6f)
					.alwaysEat()
					
					.build())
		);
	}

	@Override public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}




	@Override public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}




	@Override public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("It's not butterbeer m'kay"));
	}


		@Override public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
			ItemStack retval =
			super.finishUsingItem(itemstack, world, entity);

				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
    

    EatButtercupProcedure.execute(world,x,y,z,entity)
;

				return retval;
		}








}
