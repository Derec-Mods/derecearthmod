
package net.minecraftearthmod.client.gui;

import net.minecraftearthmod.world.inventory.ToggleSpawnsGuiMenu;
import net.minecraftearthmod.network.ToggleSpawnsGuiButtonMessage;
import net.minecraftearthmod.network.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ToggleSpawnsGuiScreen extends AbstractContainerScreen<ToggleSpawnsGuiMenu> {
	private final static HashMap<String, Object> guistate = ToggleSpawnsGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ToggleSpawnsGuiScreen(ToggleSpawnsGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 223;
		this.imageHeight = 225;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("minecraft_earth_mod:textures/screens/toggle_spawns_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Hostile Mobs: " + (MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns) + "", 12, 9, -12829636);
		this.font.draw(poseStack, "Experimental Mode: " + (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode) + "", 12, 27,
				-12829636);
		this.font.draw(poseStack, "Golem Spawns: " + (MinecraftEarthModModVariables.MapVariables.get(world).SpawnGolems) + "", 12, 54, -12829636);
		this.font.draw(poseStack, "Mud Fountain Spawns: " + (MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure) + "", 12, 81,
				-12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 9, 55, 20, Component.literal("Toggle"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new ToggleSpawnsGuiButtonMessage(0, x, y, z));
				ToggleSpawnsGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 36, 55, 20, Component.literal("Toggle"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new ToggleSpawnsGuiButtonMessage(1, x, y, z));
				ToggleSpawnsGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 63, 55, 20, Component.literal("Toggle"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new ToggleSpawnsGuiButtonMessage(2, x, y, z));
				ToggleSpawnsGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 90, 55, 20, Component.literal("Toggle"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new ToggleSpawnsGuiButtonMessage(3, x, y, z));
				ToggleSpawnsGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
