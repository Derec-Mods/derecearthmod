package net.minecraftearthmod.client.gui;


public class RubyShop2Screen extends AbstractContainerScreen<RubyShop2Menu> {

	private final static HashMap<String, Object> guistate = RubyShop2Menu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;



		Button button_purchase;
		Button button_empty;
		Button button_empty1;
		Button button_purchase1;


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



	@Override public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);


	}

	@Override protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();


			
				RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft_earth_mod:textures/screens/critterpedia_gui_blank.png"));
				this.blit(ms, this.leftPos + -29, this.topPos + -2, 0, 0,
					236, 157,
					236, 157);
			

		RenderSystem.disableBlend();
	}

	@Override public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}


		return super.keyPressed(key, b, c);
	}

	@Override public void containerTick() {
		super.containerTick();
	}

	@Override protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
			this.font.draw(poseStack,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.label_buy_boost"),
				-11, 25, -6750208);
			this.font.draw(poseStack,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.label_buy_tappable"),
				-11, 61, -6750208);
	}

	@Override public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override public void init() {
		super.init();

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);



			button_purchase = new Button(
				this.leftPos + 60, this.topPos + 52,
				63, 20,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.button_purchase"),
e -> {
	    if (        true
) {
			MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(0, x, y, z));
			RubyShop2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}
}
			);

			guistate.put("button:button_purchase", button_purchase);
			this.addRenderableWidget(button_purchase);

			button_empty = new Button(
				this.leftPos + 150, this.topPos + 106,
				18, 20,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.button_empty"),
e -> {
	    if (        true
) {
			MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(1, x, y, z));
			RubyShop2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
		}
}
			);

			guistate.put("button:button_empty", button_empty);
			this.addRenderableWidget(button_empty);

			button_empty1 = new Button(
				this.leftPos + 177, this.topPos + 106,
				18, 20,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.button_empty1"),
e -> {
	    if (        true
) {
			MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(2, x, y, z));
			RubyShop2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
		}
}
			);

			guistate.put("button:button_empty1", button_empty1);
			this.addRenderableWidget(button_empty1);

			button_purchase1 = new Button(
				this.leftPos + 60, this.topPos + 16,
				63, 20,
				Component.translatable("gui.minecraft_earth_mod.ruby_shop_2.button_purchase1"),
e -> {
	    if (        true
) {
			MinecraftEarthModMod.PACKET_HANDLER.sendToServer(new RubyShop2ButtonMessage(3, x, y, z));
			RubyShop2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
		}
}
			);

			guistate.put("button:button_purchase1", button_purchase1);
			this.addRenderableWidget(button_purchase1);



	}

}

