package waylanderou.almostalltheores.integration.hwyla;

import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.IServerDataProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import waylanderou.almostalltheores.RefinerTile;

public enum RefinerComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockEntity> {
	INSTANCE;

	@Override
	public void appendServerData(CompoundTag data, ServerPlayer player, Level world, BlockEntity tile) {		
		RefinerTile refinerTile = (RefinerTile) tile;
		ListTag items = new ListTag();
		for(int i=0; i<12; i++) {
			items.add(refinerTile.getItem(i).save(new CompoundTag()));
		}
		data.put("refiner", items);
		data.putInt("progress", refinerTile.data.get(0));
		data.putInt("total", refinerTile.data.get(3));
	}

	@Override
	public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
		ListTag refinerItems = accessor.getServerData().getList("refiner", Tag.TAG_COMPOUND);
		NonNullList<ItemStack> inventory = NonNullList.withSize(12, ItemStack.EMPTY);
		for (int i = 0; i <refinerItems.size(); i++)
			inventory.set(i, ItemStack.of(refinerItems.getCompound(i)));

		CompoundTag progress = new CompoundTag();
		progress.putInt("progress", accessor.getServerData().getInt("progress"));
		progress.putInt("total", accessor.getServerData().getInt("total"));

		tooltip.addLine()
		.with(new ItemComponent(inventory.get(0)))
		.with(new ItemComponent(inventory.get(1)))
		.with(new ItemComponent(inventory.get(2)))
		.with(new RefinerTooltipProgressBarRenderer(
				accessor.getServerData().getInt("progress"), accessor.getServerData().getInt("total")))
		.with(new ItemComponent(inventory.get(3)))
		.with(new ItemComponent(inventory.get(4)))
		.with(new ItemComponent(inventory.get(5)))
		.with(new ItemComponent(inventory.get(6)))
		.with(new ItemComponent(inventory.get(7)))
		.with(new ItemComponent(inventory.get(8)))
		.with(new ItemComponent(inventory.get(9)))
		.with(new ItemComponent(inventory.get(10)))
		.with(new ItemComponent(inventory.get(11)));


	}

}
