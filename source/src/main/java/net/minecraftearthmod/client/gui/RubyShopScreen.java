
package net.minecraftearthmod.client.gui;

import net.minecraftearthmod.world.inventory.RubyShopMenu;
import net.minecraftearthmod.network.RubyShopButtonMessage;
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

public class RubyShopScreen extends AbstractContainerScreen<RubyShopMenu> {
	private final static HashMap<String, Object> guistate = RubyShopMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public RubyShopScreen(RubyShopMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("minecraft_earth_mod:textures/screens/ruby_shop.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft_earth_mod:textures/screens/rubyblock.png"));
		this.blit(ms, this.leftPos + 178, this.topPos + -33, 0, 0, 256, 256, 256, 256);

		RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft_earth_mod:textures/screens/ruby.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 11, 0, 0, 256, 256, 256, 256);

		RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft_earth_mod:textures/screens/ruby.png"));
		this.blit(ms, this.leftPos + 159, this.topPos + 11, 0, 0, 256, 256, 256, 256);

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
		this.font.draw(poseStack, "Welcome to the Ruby Shop!", 24, 11, -3407872);
		this.font.draw(poseStack, "Random Plant", 6, 38, -6750208);
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
		this.addRenderableWidget(new Button(this.leftPos + 78, this.topPos + 29, 90, 20, Component.literal("Buy Random Plant"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShopButtonMessage(0, x, y, z));
				RubyShopButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 43, this.topPos + 58, 90, 20, Component.literal("Next Page"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShopButtonMessage(1, x, y, z));
				RubyShopButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
