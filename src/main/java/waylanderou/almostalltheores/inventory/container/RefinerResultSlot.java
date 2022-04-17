package waylanderou.almostalltheores.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import waylanderou.almostalltheores.RefinerTile;

public class RefinerResultSlot extends Slot {
	private final Player player;

	public RefinerResultSlot(Player playerIn, Container inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		this.player = playerIn;		
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}

	@Override
	public void onTake(Player player, ItemStack stack) {
		this.safeInsert(stack);
		super.onTake(player, stack);	
	}

	@Override
	public ItemStack safeInsert(ItemStack stack, int amount) {
		return this.safeInsert(stack);
	}

	@Override
	public ItemStack safeInsert(ItemStack stack) {
		stack.onCraftedBy(this.player.level, this.player, stack.getCount());
		if(!this.player.level.isClientSide && this.container instanceof RefinerTile) {
			((RefinerTile)this.container).spawnExp(this.player);
		}
		net.minecraftforge.event.ForgeEventFactory.firePlayerSmeltedEvent(this.player, stack);
		return stack;
	}

}
