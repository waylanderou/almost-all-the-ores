package waylanderou.almostalltheores.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import waylanderou.almostalltheores.RefinerTile;

public class RefinerResultSlot extends Slot {
	private final PlayerEntity player;

	public RefinerResultSlot(PlayerEntity playerIn, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		this.player = playerIn;		
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack onTake(PlayerEntity player, ItemStack stack) {
		this.onCrafting(stack);
		super.onTake(player, stack);
		return stack;		
	}

	@Override
	protected void onCrafting(ItemStack stack, int amount) {
		this.onCrafting(stack);
	}

	@Override
	protected void onCrafting(ItemStack stack) {
		stack.onCrafting(this.player.world, this.player, stack.getCount());
		if(!this.player.world.isRemote && this.inventory instanceof RefinerTile) {
			((RefinerTile)this.inventory).spawnExp(this.player);
		}
		net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerSmeltedEvent(this.player, stack);
	}

}
