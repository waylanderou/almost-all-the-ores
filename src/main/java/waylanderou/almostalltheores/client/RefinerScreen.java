package waylanderou.almostalltheores.client;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
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
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {		
		int j = container.getFuelLeft();	
		//TODO ? translationTextComponents
		drawString(Minecraft.getInstance().fontRenderer, "Refiner : ", 5, 5, 0xffffff);
		if(this.container.isProcessingOre()) {
			drawString(Minecraft.getInstance().fontRenderer, "refining ore...", 52, 5, 0xffffff);
		} else {
			drawString(Minecraft.getInstance().fontRenderer, "ready", 52, 5, 0xffffff);
		}
		if(!this.container.isProcessingOre() && this.container.getFuelLeft() > 0) {
			drawString(Minecraft.getInstance().fontRenderer, "Fuel reserve : ", 5, 73, 0xffffff);
			drawString(Minecraft.getInstance().fontRenderer, "" + j, 85, 73, 0xffffff);		
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.func_227637_a_(1.0F, 1.0F, 1.0F, 1.0F); // color4f let's replace this shit
		this.minecraft.getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);

		if (this.container.isProcessingOre() && this.container.getFuelLeft() > 0) { 
			int k = this.container.getFireProgression(); 
			this.blit(relX + 56, relY + 36 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		int l = this.container.getArrowProgression();
		this.blit(relX + 79, relY + 34, 176, 14, l + 1, 16);
	}

}
