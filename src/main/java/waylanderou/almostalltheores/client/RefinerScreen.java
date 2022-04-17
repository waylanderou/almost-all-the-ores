package waylanderou.almostalltheores.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import waylanderou.almostalltheores.inventory.container.RefinerContainer;

public class RefinerScreen extends AbstractContainerScreen<RefinerContainer> {
	private ResourceLocation GUI = new ResourceLocation("almostalltheores:textures/gui/refinergui.png");

	public RefinerScreen(RefinerContainer screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void render(PoseStack matrixstack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixstack);
		super.render(matrixstack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixstack, mouseX, mouseY);
	}

	@Override
	protected void renderLabels(PoseStack matrixstack, int mouseX, int mouseY) {
		Font fontRenderer = this.font;
		int j = menu.getFuelLeft();
		drawString(matrixstack, fontRenderer, "Refiner : ", 5, 5, 0xffffff);
		if(this.menu.isProcessingOre()) {
			drawString(matrixstack, fontRenderer, "refining ore...", 52, 5, 0xffffff);
		} else {
			drawString(matrixstack, fontRenderer, "READY", 52, 5, 0xffffff);
		}
		if(!this.menu.isProcessingOre() && this.menu.getFuelLeft() > 0) {
			drawString(matrixstack, fontRenderer, "Fuel reserve : ", 5, 73, 0xffffff);
			drawString(matrixstack, fontRenderer, "" + j, 85, 73, 0xffffff);
		}
	}

	@Override
	protected void renderBg(PoseStack matrixstack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderTexture(0, GUI);		
		int relX = (this.width - this.getXSize()) / 2;
		int relY = (this.height - this.getYSize()) / 2;
		this.blit(matrixstack, relX, relY, 0, 0, this.getXSize(), this.getYSize());

		if (this.menu.isProcessingOre() && this.menu.getFuelLeft() > 0) { 
			int k = this.menu.getFireProgression(); 
			this.blit(matrixstack, relX + 56, relY + 36 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		int l = this.menu.getArrowProgression();
		this.blit(matrixstack, relX + 79, relY + 34, 176, 14, l + 1, 16);
	}

}
