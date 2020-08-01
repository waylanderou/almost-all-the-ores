package waylanderou.almostalltheores.integration.hwyla;

/**
 * This class contains code from Hwyla by TehNut:
 * https://github.com/TehNut/HWYLA
 */

import java.util.List;

import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.IServerDataProvider;
import mcp.mobius.waila.api.RenderableTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import waylanderou.almostalltheores.RefinerTile;
import waylanderou.almostalltheores.block.Refiner;

public class RefinerComponentProvider implements IComponentProvider, IServerDataProvider<TileEntity> {

	static final RefinerComponentProvider INSTANCE = new RefinerComponentProvider();

	@Override
	public void appendServerData(CompoundNBT data, ServerPlayerEntity player, World world, TileEntity tile) {		
		RefinerTile refiner = (RefinerTile) tile;
		ListNBT items = new ListNBT();
		for(int i=0; i<12; i++) {
			items.add(refiner.getStackInSlot(i).write(new CompoundNBT()));
		}
		data.put("refiner", items);
		CompoundNBT refinerTag = refiner.write(new CompoundNBT());
		data.putInt("progress", refinerTag.getInt("hasBurntFor"));
		data.putInt("total", refinerTag.getInt("refineTime"));
	}

	@Override
	public void appendBody(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {
		if(!accessor.getBlockState().get(Refiner.REFINING)) {
			return;
		}
		ListNBT refinerItems = accessor.getServerData().getList("refiner", Constants.NBT.TAG_COMPOUND);
		NonNullList<ItemStack> inventory = NonNullList.withSize(12, ItemStack.EMPTY);
		for (int i = 0; i <refinerItems.size(); i++)
			inventory.set(i, ItemStack.read(refinerItems.getCompound(i)));

		CompoundNBT progress = new CompoundNBT();
		progress.putInt("progress", accessor.getServerData().getInt("progress"));
		progress.putInt("total", accessor.getServerData().getInt("total"));

		RenderableTextComponent renderables = new RenderableTextComponent(
				getRenderable(inventory.get(0)),
				getRenderable(inventory.get(1)),
				getRenderable(inventory.get(2)),
				new RenderableTextComponent(AlmostAllTheOresPlugin.RENDER_REFINER_PROGRESS, progress),
				getRenderable(inventory.get(3)),
				getRenderable(inventory.get(4)),
				getRenderable(inventory.get(5)),
				getRenderable(inventory.get(3)),
				getRenderable(inventory.get(7)),
				getRenderable(inventory.get(8)),
				getRenderable(inventory.get(9)),
				getRenderable(inventory.get(10)),
				getRenderable(inventory.get(11))			
				);

		tooltip.add(renderables);
	}

	private static RenderableTextComponent getRenderable(ItemStack stack) {
		if (!stack.isEmpty()) {
			CompoundNBT tag = new CompoundNBT();
			tag.putString("id", stack.getItem().getRegistryName().toString());
			tag.putInt("count", stack.getCount());
			if (stack.hasTag())
				tag.putString("nbt", stack.getTag().toString());
			return new RenderableTextComponent(AlmostAllTheOresPlugin.RENDER_ITEM_CUSTOM, tag);
		} else {
			CompoundNBT spacerTag = new CompoundNBT();
			spacerTag.putInt("width", 18);
			return new RenderableTextComponent(AlmostAllTheOresPlugin.RENDER_SPACER, spacerTag);
		}
	}

}
