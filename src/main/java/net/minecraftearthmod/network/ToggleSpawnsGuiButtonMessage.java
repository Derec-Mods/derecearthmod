
package net.minecraftearthmod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftearthmod.world.inventory.ToggleSpawnsGuiMenu;
import net.minecraftearthmod.procedures.ToggleSpawnFountainProcedure;
import net.minecraftearthmod.procedures.ToggleGolemSpawnsProcedure;
import net.minecraftearthmod.procedures.ToggleExperimentalModeProcedure;
import net.minecraftearthmod.procedures.ChangeHostileMobSpawnsProcedure;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToggleSpawnsGuiButtonMessage {
	private final int buttonID, x, y, z;

	public ToggleSpawnsGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ToggleSpawnsGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ToggleSpawnsGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ToggleSpawnsGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ToggleSpawnsGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ChangeHostileMobSpawnsProcedure.execute(world);
		}
		if (buttonID == 1) {

			ToggleExperimentalModeProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			ToggleGolemSpawnsProcedure.execute(world);
		}
		if (buttonID == 3) {

			ToggleSpawnFountainProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinecraftEarthModMod.addNetworkMessage(ToggleSpawnsGuiButtonMessage.class, ToggleSpawnsGuiButtonMessage::buffer,
				ToggleSpawnsGuiButtonMessage::new, ToggleSpawnsGuiButtonMessage::handler);
	}
}
