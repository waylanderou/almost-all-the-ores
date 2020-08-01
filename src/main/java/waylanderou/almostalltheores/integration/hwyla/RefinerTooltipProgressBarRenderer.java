package waylanderou.almostalltheores.integration.hwyla;

/**
 * This class contains code from Hwyla by TehNut:
 * https://github.com/TehNut/HWYLA
 */

import java.awt.Dimension;

import mcp.mobius.waila.api.ICommonAccessor;
import mcp.mobius.waila.api.ITooltipRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

public class RefinerTooltipProgressBarRenderer implements ITooltipRenderer {
	private static final ResourceLocation SHEET = new ResourceLocation("waila", "textures/sprites.png");

	@Override
	public Dimension getSize(CompoundNBT data, ICommonAccessor accessor) {
		return new Dimension(26, 16);
	}

	@Override
	public void draw(CompoundNBT data, ICommonAccessor accessor, int x, int y) {		
		int currentValue = data.getInt("progress");
		Minecraft.getInstance().getTextureManager().bindTexture(SHEET);        
		drawTexturedModalRect(x + 2, y, 0, 16, 22, 15, 22, 15);
		int maxValue = data.getInt("total");
		if (maxValue > 0) {
			int progress = (currentValue * 22) / maxValue;
			drawTexturedModalRect(x + 2, y, 0, 0, progress + 1, 16, progress + 1, 16);
		}
	}	

	public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, int tw, int th) {
		float f = 0.00390625F;
		float f1 = 0.00390625F;
		float zLevel = 0.0F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos(x, y + height, zLevel).tex( ((float) (textureX) * f), ((float) (textureY + th) * f1)).endVertex();
		buffer.pos(x + width, y + height, zLevel).tex( ((float) (textureX + tw) * f), ((float) (textureY + th) * f1)).endVertex();
		buffer.pos(x + width, y, zLevel).tex( ((float) (textureX + tw) * f), ((float) (textureY) * f1)).endVertex();
		buffer.pos(x, y, zLevel).tex( ((float) (textureX) * f), ((float) (textureY) * f1)).endVertex();
		tessellator.draw();
	}

}
