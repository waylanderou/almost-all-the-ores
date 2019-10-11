package waylanderou.almostalltheores.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Fuel extends Item {

	public Fuel(Properties properties) {
		super(properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		if(this.getItem() == Items.ANTHRACITE) { 
			return 2000;			
		} else if(this.getItem() == Items.BITUMINOUS_COAL) {
			return 1600;
		} else if(this.getItem() == Items.LIGNITE) {
			return 1000;			
		} else if(this.getItem() == Items.PEAT_PIECE) {
			return 600;		
		} else {
			return 0;
		}		
	}	

}
