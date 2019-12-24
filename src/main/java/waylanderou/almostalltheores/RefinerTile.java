package waylanderou.almostalltheores;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import waylanderou.almostalltheores.block.Refiner;
import waylanderou.almostalltheores.inventory.container.RefinerContainer;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;

public class RefinerTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider, ISidedInventory {
	private NonNullList<ItemStack> items = NonNullList.withSize(SIZE, ItemStack.EMPTY);
	private static final int SIZE = 12;
	private static final int[] OUTPUT_SLOTS = {3, 4, 5, 6, 7, 8, 9, 10, 11};
	private static final int[] INPUT_SLOTS = {0, 1, 2};
	private String itemBeingRefined = "empty";
	private int secondCounter = 0;
	private int hasBeenRefinedFor = 0; 
	private int fuelTimeLeft;
	private ResourceLocation recipeLocation;
	private final IRecipeType<? extends RefinerRecipe> recipeType;
	private int refineTimeNeeded;
	private int itemBurnTime;
	private float totalExperience;

	protected final IIntArray data = new IIntArray() {
		public int get(int index) {
			switch(index) {
			case 0:
				return RefinerTile.this.hasBeenRefinedFor;
			case 1:
				return RefinerTile.this.fuelTimeLeft;
			case 2:
				return RefinerTile.this.secondCounter;
			case 3:
				return RefinerTile.this.refineTimeNeeded;
			case 4:
				return RefinerTile.this.itemBurnTime;
			default:
				return 0;
			}
		}

		public void set(int index, int value) {
			switch(index) {
			case 0:
				RefinerTile.this.hasBeenRefinedFor = value;
				break;
			case 1:
				RefinerTile.this.fuelTimeLeft = value;
				break;
			case 2:
				RefinerTile.this.secondCounter = value;								
				break;
			case 3:
				RefinerTile.this.refineTimeNeeded = value;
				break;
			case 4:
				RefinerTile.this.itemBurnTime = value;
				break;
			}
		}

		public int size() {
			return 5;
		}
	};

	public RefinerTile() {
		super(RefinerRegistryEvents.REFINER_TILE);
		this.recipeType = RefinerRecipe.refining;
	}

	@Nullable
	@Override
	public Container createMenu(int i, PlayerInventory playerInv, PlayerEntity p_createMenu_3_) {
		return new RefinerContainer(i, playerInv, this.data, this, this.pos);
	}

	@Override
	public int getSizeInventory() {
		return SIZE;
	}

	@Override
	public boolean isEmpty() {
		for(ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}			
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.items.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.items, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.items, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clear() {
		this.items.clear();
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		if(side == Direction.DOWN) {
			return OUTPUT_SLOTS;
		} else {
			return INPUT_SLOTS;			
		}
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(index == 0 && AbstractFurnaceTileEntity.isFuel(stack)) {
			return true;
		} else if(index == 1) { //Currently not used, future acid slot
			return false;			
		} else if(index == 2) {
			return true;			
		} else {
			return false;
		}
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if((index > 2)) {			
			return true;
		}		
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("tileentity.almostalltheores.refinertile");
	}

	@Override
	public void tick() {
		if(!world.isRemote) {
			if(!hasFuel()) {
				ItemStack fuelStack = items.get(0);
				if(this.hasBeenRefinedFor > 0) {					
					if(AbstractFurnaceTileEntity.isFuel(fuelStack)) {						
						this.fuelTimeLeft = getBurnTimes(fuelStack);
						this.itemBurnTime = getBurnTimes(fuelStack);
						if(fuelStack.hasContainerItem()) {
							this.items.set(0, fuelStack.getContainerItem());
						} else if(!fuelStack.isEmpty()) {
							fuelStack.shrink(1);
							if(fuelStack.isEmpty()) {
								this.items.set(0, fuelStack.getContainerItem());
							}
						}
					} else {
						turnOff();
					}
				} else {
					RefinerRecipe recipe = this.world.getRecipeManager().getRecipe(RefinerRecipe.refining, this, this.world).orElse(null);					 
					if(AbstractFurnaceTileEntity.isFuel(fuelStack) && canRefine(recipe)) {						
						this.fuelTimeLeft = getBurnTimes(fuelStack);	
						this.itemBurnTime = getBurnTimes(fuelStack);
						this.recipeLocation = recipe.getId();
						this.refineTimeNeeded = recipe.getRefiningTime();
						if(fuelStack.hasContainerItem()) {
							this.items.set(0, fuelStack.getContainerItem());
						} else if(!fuelStack.isEmpty()) {
							fuelStack.shrink(1);
							if(fuelStack.isEmpty()) {
								this.items.set(0, fuelStack.getContainerItem());
							}
						}			
						ItemStack itemBeingRefinedLocal = items.get(2);						
						if(!itemBeingRefinedLocal.isEmpty()) {
							this.itemBeingRefined = itemBeingRefinedLocal.getItem().getTranslationKey();
							itemBeingRefinedLocal.shrink(1);														
						}						
						markDirty(); 							
					} else {
						turnOff();						
					}
				}
			}			
			if(hasFuel()) { 
				if(!this.itemBeingRefined.equals("empty")) { 
					BlockState blockState = world.getBlockState(pos);
					world.setBlockState(pos, blockState.with(Refiner.REFINING, true), 3);
					this.fuelTimeLeft--; 
					this.hasBeenRefinedFor++;
					this.secondCounter--;

					if(this.hasBeenRefinedFor >= this.refineTimeNeeded) {
						RefinerRecipe r = (RefinerRecipe) this.world.getRecipeManager().getRecipe(this.recipeLocation).orElse(null);
						checkRecipeAndSpawnOutput(r);
						this.hasBeenRefinedFor = 0;
						this.itemBeingRefined = "empty";
						markDirty();
					}										
				} else {	
					RefinerRecipe recipe = this.world.getRecipeManager().getRecipe(RefinerRecipe.refining, this, this.world).orElse(null);
					if(canRefine(recipe)) {
						this.recipeLocation = recipe.getId();
						this.refineTimeNeeded = recipe.getRefiningTime();
						ItemStack itembeingRefinedLocal = items.get(2);						
						if(!itembeingRefinedLocal.isEmpty()) {
							this.itemBeingRefined = itembeingRefinedLocal.getItem().getTranslationKey();
							itembeingRefinedLocal.shrink(1);												
						}
					} else {
						turnOff();
					}
				}
				markDirty();
			}
		}
	}

	private void turnOff() {
		BlockState blockState = world.getBlockState(this.pos);
		world.setBlockState(pos, blockState.with(Refiner.REFINING, false), 3);
	}	

	private boolean canRefine(RefinerRecipe recipe) {
		if(!this.items.get(2).isEmpty() && recipe != null) {			
			if(recipe.hasRecipeOutput()) return true;									
		}		
		return false;
	}

	public void spawnExp(PlayerEntity player) {
		spawnExp(player, this.totalExperience);
		this.totalExperience = 0;
	}

	public static void spawnExp(PlayerEntity player, float totalXp) {		
		int i = (int) totalXp;		
		while(i > 0) {
			int j = ExperienceOrbEntity.getXPSplit(i);
			i -= j;
			player.world.addEntity(new ExperienceOrbEntity(player.world, player.lastTickPosX, player.lastTickPosY + 0.5D, player.lastTickPosZ + 0.5D, j)); //TODO check if that works
		}		
	}

	private void checkRecipeAndSpawnOutput(RefinerRecipe recipe) {			
		ItemStack recipeOutput;
		ItemStack itemstackInSlot;
		Boolean refinerFull;		
		for(int i = 3; i<12; i++) {
			refinerFull = true;
			recipeOutput = recipe.getRecipeOutput(i);		
			if(recipeOutput.isEmpty()) continue;

			this.totalExperience += recipe.getExperience(); 

			for(int j = 3; j<12; j++) { 
				itemstackInSlot = this.items.get(j);
				if (itemstackInSlot.isEmpty()) {
					this.items.set(j, recipeOutput);
					j = 42;	
					refinerFull = false;					
				} else if (itemstackInSlot.isItemEqual(recipeOutput) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= this.getInventoryStackLimit()) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= itemstackInSlot.getMaxStackSize())) {
					itemstackInSlot.grow(recipeOutput.getCount());	
					j = 42;
					refinerFull = false;					
				}
			}
			if(refinerFull) {
				Block.spawnAsEntity(world, this.pos, recipeOutput);				
			}
		}
	}

	private boolean hasFuel() {
		return this.fuelTimeLeft > 0;
	}

	public int getBurnTimes(ItemStack itemstack) {
		if (itemstack.isEmpty()) {
			return 0;
		} else {
			Item item = itemstack.getItem();
			int ret = itemstack.getBurnTime();
			return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(itemstack, ret == -1 ? AbstractFurnaceTileEntity.getBurnTimes().getOrDefault(item, 0) : ret);
		}
	}

	@Override
	public void read(CompoundNBT compound) {
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.items);
		this.totalExperience = compound.getFloat("totalExperience");
		this.itemBurnTime = compound.getInt("itemBurnTime");
		this.refineTimeNeeded = compound.getInt("refineTime");
		this.fuelTimeLeft = compound.getInt("BurnTime");
		this.secondCounter = compound.getInt("secondCounter");
		this.hasBeenRefinedFor = compound.getInt("hasBurntFor");
		this.itemBeingRefined = compound.getString("itemBurning");
		if(!compound.getString("recipeLocation").equals("")) {
			this.recipeLocation = new ResourceLocation(compound.getString("recipeLocation"));			
		}
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		ItemStackHelper.saveAllItems(compound, this.items);
		compound.putFloat("totalExperience", this.totalExperience);
		compound.putInt("itemBurnTime", this.itemBurnTime);
		compound.putInt("refineTime", this.refineTimeNeeded);
		compound.putInt("BurnTime", this.fuelTimeLeft);
		compound.putInt("secondCounter", this.secondCounter);
		compound.putInt("hasBurntFor", this.hasBeenRefinedFor);
		compound.putString("itemBurning", this.itemBeingRefined);
		if(this.recipeLocation != null) {
			compound.putString("recipeLocation", this.recipeLocation.toString());//			
		} else {
			compound.putString("recipeLocation", "");
		}
		return super.write(compound);
	}

}
