package waylanderou.almostalltheores.inventory.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import waylanderou.almostalltheores.RefinerRegistryEvents;
import waylanderou.almostalltheores.item.Items;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;

public class RefinerContainer extends AbstractContainerMenu {
	private ContainerData machineData;
	private BlockPos tePos;
	private final Container machineInventory;
	private final Level level;

	public RefinerContainer(int windowId, Inventory playerInventory) {
		this(windowId, playerInventory, new SimpleContainerData(5), new SimpleContainer(12), null);
	}    

	public RefinerContainer(int windowId, Inventory playerInventory, ContainerData machineData, Container machineInv, BlockPos tePos) {
		super(RefinerRegistryEvents.REFINER_CONTAINER, windowId);
		this.tePos = tePos;		    
		this.machineInventory = machineInv;
		this.machineData = machineData;
		this.level = playerInventory.player.level;

		addSlot(new Slot(machineInv, 0, 56, 53));
		addSlot(new Slot(machineInv, 1, 45, 17));
		addSlot(new Slot(machineInv, 2, 67, 17));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 3, 109, 17));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 4, 127, 17));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 5, 145, 17));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 6, 109, 35));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 7, 127, 35));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 8, 145, 35));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 9, 109, 53));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 10, 127, 53));
		addSlot(new RefinerResultSlot(playerInventory.player, machineInv, 11, 145, 53));
		layoutPlayerInventorySlots(playerInventory, 8, 84);         

		this.addDataSlots(machineData);
	}

	@Override
	public boolean stillValid(Player playerIn) {		
		return this.machineInventory.stillValid(playerIn);
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack stack = slot.getItem();
			itemstack = stack.copy();
			if (index == 0 || index == 1 || index == 2 || index == 3 || index == 4 || index == 5 || index ==  6 || index == 7 || 
					index == 8 || index == 9 || index == 10 || index == 11) { 
				if (!this.moveItemStackTo(stack, 12, 48, true)) { 
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(stack, itemstack);
			} else { 
				if (AbstractFurnaceBlockEntity.isFuel(stack)) {
					if (!this.moveItemStackTo(stack, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if(stack.getItem() == Items.SULPHURIC_ACID) {
					if (!this.moveItemStackTo(stack, 1, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else if(this.hasRecipe(stack)) {
					if (!this.moveItemStackTo(stack, 2, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index < 39) {
					if (!this.moveItemStackTo(stack, 39, 48, false)) { 
						return ItemStack.EMPTY;
					}
				} else if (index < 48 && !this.moveItemStackTo(stack, 12, 39, false)) {
					return ItemStack.EMPTY;
				}
			}
			if (stack.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (stack.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, stack);
		}
		return itemstack;
	}	

	private boolean hasRecipe(ItemStack stack) {
		boolean flag = false;
		for(ItemStack s : this.getItems()) {
			if(s.getItem() == Items.SULPHURIC_ACID) {
				flag = this.level.getRecipeManager().getRecipeFor((RecipeType<RefinerRecipe>)RefinerRecipe.REFINING, new SimpleContainer(ItemStack.EMPTY, new ItemStack(Items.SULPHURIC_ACID), stack), this.level).isPresent();
			}
		}		
		return flag || this.level.getRecipeManager().getRecipeFor((RecipeType<RefinerRecipe>)RefinerRecipe.REFINING, new SimpleContainer(ItemStack.EMPTY, ItemStack.EMPTY, stack), this.level).isPresent();
	}

	private int addSlotRange(Inventory playerInventory, int index, int x, int y, int amount, int dx) {
		for (int i = 0 ; i < amount ; i++) {
			this.addSlot(new Slot(playerInventory, index, x, y));
			x += dx;
			index++;
		}
		return index;
	}

	private int addSlotBox(Inventory playerInventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
		for (int j = 0 ; j < verAmount ; j++) {
			index = addSlotRange(playerInventory, index, x, y, horAmount, dx);
			y += dy;
		}
		return index;
	}

	private void layoutPlayerInventorySlots(Inventory playerInventory, int leftCol, int topRow) {		  
		addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);		
		topRow += 58;
		addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
	}

	public int getArrowProgression() { 
		int i = hasBeenProcessingFor();
		int j = this.machineData.get(3);

		return j != 0 && i != 0 ? i * 24 / j : 0;
	}

	public int getFireProgression() {
		int i = this.machineData.get(4);
		if(i == 0) i = 200;
		return getFuelLeft() * 13 / i; 
	}

	public boolean isProcessingOre() {
		return this.hasBeenProcessingFor()>0;
	}    

	public int hasBeenProcessingFor() {    	
		return this.machineData.get(0);
	}

	public int getSecondCounter() { 
		return this.machineData.get(2);    	
	}

	public int getFuelLeft() {    	
		return this.machineData.get(1);  	
	}

}
