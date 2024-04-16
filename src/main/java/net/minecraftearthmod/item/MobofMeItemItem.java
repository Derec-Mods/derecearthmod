

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class MobofMeItemItem extends Item {

	public MobofMeItemItem() {
		super(new Item.Properties()
				.tab(MinecraftEarthModModTabs.TAB_DEREC_EARTH_MOBS_SPAWN_EGGS)
				.stacksTo(1)
				.rarity(Rarity.UNCOMMON)
		);
	}

	@Override public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}






@Override @OnlyIn(Dist.CLIENT) public boolean isFoil(ItemStack itemstack) {
	return true;
}





@Override public InteractionResult useOn(UseOnContext context) {
	super.useOn(context);
    SpawnMobofMeProcedure.execute(
    context.getLevel(),context.getClickedPos().getX(),context.getClickedPos().getY(),context.getClickedPos().getZ(),context.getPlayer()
);
        return InteractionResult.SUCCESS;
}







}
