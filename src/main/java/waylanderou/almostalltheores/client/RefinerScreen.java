package waylanderou.almostalltheores.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import waylanderou.almostalltheores.inventory.container.RefinerContainer;

public class RefinerScreen extends ContainerScreen<RefinerContainer> {
	private ResourceLocation GUI = new ResourceLocation("almostalltheores:textures/gui/refinergui.png");

	public RefinerScreen(RefinerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void render(MatrixStack matrixstack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixstack);
		super.render(matrixstack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixstack, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixstack, int mouseX, int mouseY) {
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		int j = container.getFuelLeft();
		drawString(matrixstack, fontRenderer, "Refiner : ", 5, 5, 0xffffff);
		if(this.container.isProcessingOre()) {
			drawString(matrixstack, fontRenderer, "refining ore...", 52, 5, 0xffffff);
		} else {
			drawString(matrixstack, fontRenderer, "ready", 52, 5, 0xffffff);
		}
		if(!this.container.isProcessingOre() && this.container.getFuelLeft() > 0) {
			drawString(matrixstack, fontRenderer, "Fuel reserve : ", 5, 73, 0xffffff);
			drawString(matrixstack, fontRenderer, "" + j, 85, 73, 0xffffff);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixstack, float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		this.blit(matrixstack, relX, relY, 0, 0, this.xSize, this.ySize);

		if (this.container.isProcessingOre() && this.container.getFuelLeft() > 0) { 
			int k = this.container.getFireProgression(); 
			this.blit(matrixstack, relX + 56, relY + 36 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		int l = this.container.getArrowProgression();
		this.blit(matrixstack, relX + 79, relY + 34, 176, 14, l + 1, 16);
	}

}
