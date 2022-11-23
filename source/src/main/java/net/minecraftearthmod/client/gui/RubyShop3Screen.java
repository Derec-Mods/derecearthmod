
package net.minecraftearthmod.client.gui;

import net.minecraftearthmod.world.inventory.RubyShop3Menu;
import net.minecraftearthmod.network.RubyShop3ButtonMessage;
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

public class RubyShop3Screen extends AbstractContainerScreen<RubyShop3Menu> {
	private final static HashMap<String, Object> guistate = RubyShop3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public RubyShop3Screen(RubyShop3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("minecraft_earth_mod:textures/screens/ruby_shop_3.png");

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
		this.font.draw(poseStack, "Suspicious Item", 6, 33, -3407872);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 2, 80, 20, Component.literal("Previous"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop3ButtonMessage(0, x, y, z));
				RubyShop3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 2, 40, 20, Component.literal("Next"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 47, 99, 20, Component.literal("Price: 32 Rubies"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop3ButtonMessage(2, x, y, z));
				RubyShop3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
