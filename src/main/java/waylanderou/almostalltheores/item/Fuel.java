package waylanderou.almostalltheores.item;

import javax.annotation.Nullable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class Fuel extends Item {

	public Fuel(Properties properties) {
		super(properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType)
	{
		if(this.asItem() == Items.ANTHRACITE) { 
			return 2000;			
		} else if(this.asItem() == Items.BITUMINOUS_COAL) {
			return 1600;
		} else if(this.asItem() == Items.LIGNITE) {
			return 1000;			
		} else if(this.asItem() == Items.PEAT_PIECE) {
			return 600;		
		} else {
			return 0;
		}		
	}	

}
