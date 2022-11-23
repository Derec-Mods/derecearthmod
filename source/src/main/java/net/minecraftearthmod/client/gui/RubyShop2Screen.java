
package net.minecraftearthmod.client.gui;

import net.minecraftearthmod.world.inventory.RubyShop2Menu;
import net.minecraftearthmod.network.RubyShop2ButtonMessage;
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

public class RubyShop2Screen extends AbstractContainerScreen<RubyShop2Menu> {
	private final static HashMap<String, Object> guistate = RubyShop2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public RubyShop2Screen(RubyShop2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("minecraft_earth_mod:textures/screens/ruby_shop_2.png");

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
		this.font.draw(poseStack, "Buy Boost", 6, 29, -6750208);
		this.font.draw(poseStack, "Buy Tappable", 6, 47, -6750208);
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
		this.addRenderableWidget(new Button(this.leftPos + 78, this.topPos + 47, 90, 20, Component.literal("(Tappable) 1 Ruby"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(0, x, y, z));
				RubyShop2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 2, 80, 20, Component.literal("Previous"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(1, x, y, z));
				RubyShop2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 2, 40, 20, Component.literal("Next"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(2, x, y, z));
				RubyShop2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 78, this.topPos + 20, 72, 20, Component.literal("(Boost) 1 Ruby"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(3, x, y, z));
				RubyShop2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
