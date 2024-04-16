
package net.minecraftearthmod.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class) public class LobberZombieEntityProjectile extends AbstractArrow implements ItemSupplier {

	public LobberZombieEntityProjectile(PlayMessages.SpawnEntity packet, Level world) {
		super(MinecraftEarthModModEntities.LOBBER_ZOMBIE_PROJECTILE.get(), world);
	}

	public LobberZombieEntityProjectile(EntityType<? extends LobberZombieEntityProjectile> type, Level world) {
		super(type, world);
	}

	public LobberZombieEntityProjectile(EntityType<? extends LobberZombieEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public LobberZombieEntityProjectile(EntityType<? extends LobberZombieEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override @OnlyIn(Dist.CLIENT) public ItemStack getItem() {
		return new ItemStack(Items.ROTTEN_FLESH);
	}

	@Override protected ItemStack getPickupItem() {
		return new ItemStack(Items.ROTTEN_FLESH);
	}
}
