package waylanderou.almostalltheores.item;

import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class AnthraciteBlockItemBlock extends BlockItem {

	public AnthraciteBlockItemBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);		
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {	
		return 20000;
	}

}