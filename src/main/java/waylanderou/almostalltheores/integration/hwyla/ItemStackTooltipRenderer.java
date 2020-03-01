package waylanderou.almostalltheores.integration.hwyla;

/**
 * This class contains code from Hwyla by TehNut:
 * https://github.com/TehNut/HWYLA
 */

import java.awt.Dimension;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import mcp.mobius.waila.api.ICommonAccessor;
import mcp.mobius.waila.api.ITooltipRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemStackTooltipRenderer implements ITooltipRenderer {
	private static final Minecraft CLIENT = Minecraft.getInstance();

	@Override
	public Dimension getSize(CompoundNBT tag, ICommonAccessor accessor) {
		return new Dimension(18, 18);
	}

	@Override
	public void draw(CompoundNBT tag, ICommonAccessor accessor, int x, int y) {		
		int count = tag.getInt("count");
		if (count <= 0)
			return;

		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("id")));
		if (item == Items.AIR)
			return;

		CompoundNBT stackTag = null;
		try {
			stackTag = JsonToNBT.getTagFromJson(tag.getString("nbt"));
		} catch (CommandSyntaxException e) {}

		ItemStack stack = new ItemStack(item, count);
		if (stackTag != null)
			stack.setTag(stackTag);

		RenderHelper.enableGUIStandardItemLighting();
		renderStack(x, y, stack);
		RenderHelper.disableStandardItemLighting();
	}

	/*public static void enableGUIStandardItemLighting() {
		RenderSystem.pushMatrix();
		RenderSystem.rotatef(-30.0F, 0.0F, 1.0F, 0.0F);
		RenderSystem.rotatef(165.0F, 1.0F, 0.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();//();
		RenderSystem.popMatrix();
	}*/

	public static void renderStack(int x, int y, ItemStack stack) {
		enable3DRender();
		try {
			CLIENT.getItemRenderer().renderItemIntoGUI(stack, x, y);
			ItemStack stackToRender = stack.copy();
			stackToRender.setCount(stack.getCount());
			CLIENT.getItemRenderer().renderItemOverlayIntoGUI(CLIENT.fontRenderer, stackToRender, x, y, null);
		} catch (Exception e) {}
		enable2DRender();
	}

	public static void enable3DRender() {
		GlStateManager.enableLighting();
		GlStateManager.enableDepthTest();
	}

	public static void enable2DRender() {
		GlStateManager.disableLighting();
		GlStateManager.disableDepthTest();
	}

}
