
package net.minecraftearthmod.network;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) public class RubyShop2ButtonMessage {

	private final int buttonID, x, y, z;

	public RubyShop2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public RubyShop2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(RubyShop2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(RubyShop2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;

			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = RubyShop2Menu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

					if (buttonID == 0) {
    

    BuyTappableProcedure.execute(world,x,y,z,entity)
;
					}
					if (buttonID == 1) {
    

    GotoPage1Procedure.execute(world,x,y,z,entity)
;
					}
					if (buttonID == 2) {
    

    GotoPage3Procedure.execute(world,x,y,z,entity)
;
					}
					if (buttonID == 3) {
    

    GiveAttackBoostProcedure.execute(world,x,y,z,entity)
;
					}
	}

	@SubscribeEvent public static void registerMessage(FMLCommonSetupEvent event) {
		MinecraftEarthModMod.addNetworkMessage(RubyShop2ButtonMessage.class, RubyShop2ButtonMessage::buffer, RubyShop2ButtonMessage::new, RubyShop2ButtonMessage::handler);
	}

}
