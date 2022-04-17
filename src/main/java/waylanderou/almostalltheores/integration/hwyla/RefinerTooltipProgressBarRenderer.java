package waylanderou.almostalltheores.integration.hwyla;

import static net.minecraft.client.gui.GuiComponent.blit;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import mcp.mobius.waila.api.ITooltipComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;

public class RefinerTooltipProgressBarRenderer implements ITooltipComponent {
	private static final ResourceLocation SHEET = new ResourceLocation("waila", "textures/sprites.png");
	private int progress;
	private int total;

	@Override
	public int getWidth() {
		return 24;
	}

	@Override
	public int getHeight() {
		return 18;
	}

	public RefinerTooltipProgressBarRenderer(int progress, int total) {
		this.progress = progress;
		this.total = total;
	}

	@Override
	public void render(PoseStack matrixStack, int x, int y, float delta) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, SHEET);
		blit(matrixStack, x + 1, y + 1, 0, 16, 22, 16, 22, 32);
		if (total > 0 && progress > 0) {
			int progressBar = (progress * 22) / total;
			blit(matrixStack, x + 1, y + 1, 0, 0, progressBar + 1, 16, 22, 32);
		}
	}

}
