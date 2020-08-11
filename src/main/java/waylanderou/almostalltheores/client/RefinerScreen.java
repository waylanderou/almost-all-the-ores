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
	public void func_230430_a_(MatrixStack matrixstack, int mouseX, int mouseY, float partialTicks) {
		this.func_230446_a_(matrixstack);
		super.func_230430_a_(matrixstack, mouseX, mouseY, partialTicks);
		this.func_230459_a_(matrixstack, mouseX, mouseY);
	}

	@Override
	protected void func_230451_b_(MatrixStack matrixstack, int mouseX, int mouseY) {
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		int j = container.getFuelLeft();
		func_238476_c_(matrixstack, fontRenderer, "Refiner : ", 5, 5, 0xffffff);
		if(this.container.isProcessingOre()) {
			func_238476_c_(matrixstack, fontRenderer, "refining ore...", 52, 5, 0xffffff);
		} else {
			func_238476_c_(matrixstack, fontRenderer, "ready", 52, 5, 0xffffff);
		}
		if(!this.container.isProcessingOre() && this.container.getFuelLeft() > 0) {
			func_238476_c_(matrixstack, fontRenderer, "Fuel reserve : ", 5, 73, 0xffffff);
			func_238476_c_(matrixstack, fontRenderer, "" + j, 85, 73, 0xffffff);
		}
	}

	@Override
	protected void func_230450_a_(MatrixStack matrixstack, float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_230706_i_.getTextureManager().bindTexture(GUI);
		int relX = (this.field_230708_k_ - this.xSize) / 2;
		int relY = (this.field_230709_l_ - this.ySize) / 2;
		this.func_238474_b_(matrixstack, relX, relY, 0, 0, this.xSize, this.ySize);

		if (this.container.isProcessingOre() && this.container.getFuelLeft() > 0) { 
			int k = this.container.getFireProgression(); 
			this.func_238474_b_(matrixstack, relX + 56, relY + 36 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		int l = this.container.getArrowProgression();
		this.func_238474_b_(matrixstack, relX + 79, relY + 34, 176, 14, l + 1, 16);
	}

}
