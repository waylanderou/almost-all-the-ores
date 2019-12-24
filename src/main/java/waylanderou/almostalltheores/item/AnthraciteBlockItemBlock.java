package waylanderou.almostalltheores.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class AnthraciteBlockItemBlock extends BlockItem {

	public AnthraciteBlockItemBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);		
	}

	@Override
	public int getBurnTime(ItemStack itemstack) {	
		return 20000;
	}

}