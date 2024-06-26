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
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RubyShop3Screen extends AbstractContainerScreen<RubyShop3Menu> {
	private final static HashMap<String, Object> guistate = RubyShop3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_purchase_32;
	Button button_empty;

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

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("minecraft_earth_mod:textures/screens/critterpedia_gui_blank.png"), this.leftPos + -30, this.topPos + -2, 0, 0, 236, 157, 236, 157);

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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.minecraft_earth_mod.ruby_shop_3.label_empty"), -12, 25, -3407872, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_purchase_32 = Button.builder(Component.translatable("gui.minecraft_earth_mod.ruby_shop_3.button_purchase_32"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop3ButtonMessage(0, x, y, z));
				RubyShop3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 16, 72, 20).build();
		guistate.put("button:button_purchase_32", button_purchase_32);
		this.addRenderableWidget(button_purchase_32);
		button_empty = Button.builder(Component.translatable("gui.minecraft_earth_mod.ruby_shop_3.button_empty"), e -> {
			if (true) {
				MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop3ButtonMessage(1, x, y, z));
				RubyShop3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 106, 18, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
