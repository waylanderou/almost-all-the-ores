package waylanderou.almostalltheores;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import waylanderou.almostalltheores.block.Refiner;
import waylanderou.almostalltheores.inventory.container.RefinerContainer;
import waylanderou.almostalltheores.item.Items;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;

public class RefinerTile extends BlockEntity implements MenuProvider, WorldlyContainer {
	private NonNullList<ItemStack> items = NonNullList.withSize(SIZE, ItemStack.EMPTY);
	private static final int SIZE = 12;
	private static final int[] OUTPUT_SLOTS = {3, 4, 5, 6, 7, 8, 9, 10, 11};
	private static final int[] INPUT_SLOTS = {0, 1, 2};
	private String itemBeingRefined = "empty";
	private int secondCounter = 0;
	private int hasBeenRefinedFor = 0; 
	private int fuelTimeLeft;
	private ResourceLocation recipeLocation;
	private final RecipeType<? extends RefinerRecipe> recipeType;
	private int refineTimeNeeded;
	private int itemBurnTime;
	private float totalExperience;

	public final ContainerData data = new ContainerData() {
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

		public int getCount() {
			return 5;
		}
	};

	public RefinerTile(BlockPos pos, BlockState state) {
		super(RefinerRegistryEvents.REFINER_TILE, pos, state);
		this.recipeType = RefinerRecipe.REFINING;
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int i, Inventory playerInv, Player player) {
		return new RefinerContainer(i, playerInv, this.data, this, this.worldPosition);
	}

	@Override
	public int getContainerSize() {
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
	public ItemStack getItem(int index) {
		return this.items.get(index);
	}

	@Override
	public ItemStack removeItem(int index, int count) {
		return ContainerHelper.removeItem(this.items, index, count);
	}

	@Override
	public ItemStack removeItemNoUpdate(int index) {
		return ContainerHelper.takeItem(this.items, index);
	}

	@Override
	public void setItem(int index, ItemStack stack) {
		this.items.set(index, stack);
		if (stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.level.getBlockEntity(this.getBlockPos()) != this) {
			return false;
		} else {
			return player.distanceToSqr((double)this.getBlockPos().getX() + 0.5D, (double)this.getBlockPos().getY() + 0.5D, (double)this.getBlockPos().getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clearContent() {
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
		if(index == 0 && AbstractFurnaceBlockEntity.isFuel(stack)) {
			return true;
		} else if(index == 1 && stack.getItem() == waylanderou.almostalltheores.item.Items.SULPHURIC_ACID) { 
			return true;			
		} else if(index == 2) {
			return true;			
		} else {
			return false;
		}
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, Direction direction) {
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		if((index > 2)) {			
			return true;
		}		
		return false;
	}

	@Override
	public TranslatableComponent getDisplayName() {
		return new TranslatableComponent("tileentity.almostalltheores.refinertile");
	}

	public void tickServer() {
		if(!level.isClientSide) {
			if(!hasFuel()) {
				ItemStack fuelStack = items.get(0);
				if(this.hasBeenRefinedFor > 0) {					
					if(AbstractFurnaceBlockEntity.isFuel(fuelStack)) {						
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
					RefinerRecipe recipe = this.level.getRecipeManager().getRecipeFor(RefinerRecipe.REFINING, this, this.level).orElse(null);
					if(AbstractFurnaceBlockEntity.isFuel(fuelStack) && canRefine(recipe)) {	
						if(recipe.isREERecipe()) {
							if(this.secondCounter == 0) {
								this.items.get(1).shrink(1);
								this.secondCounter = 800;
							}						
						}
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
							this.itemBeingRefined = itemBeingRefinedLocal.getItem().getDescriptionId();
							itemBeingRefinedLocal.shrink(1);														
						}						
						setChanged(); 							
					} else {
						turnOff();						
					}
				}
			}			
			if(hasFuel()) { 
				if(!this.itemBeingRefined.equals("empty")) { 
					BlockState blockState = level.getBlockState(worldPosition);
					level.setBlock(worldPosition, blockState.setValue(Refiner.REFINING, true), 3);
					this.fuelTimeLeft--; 
					this.hasBeenRefinedFor++;
					if(this.recipeLocation.getPath().contains("acid")) this.secondCounter--;
					if(this.hasBeenRefinedFor >= this.refineTimeNeeded) {
						RefinerRecipe r = (RefinerRecipe) this.level.getRecipeManager().byKey(this.recipeLocation).orElse(null);
						checkRecipeAndSpawnOutput(r);
						this.hasBeenRefinedFor = 0;
						this.itemBeingRefined = "empty";
						setChanged();
					}										
				} else {	
					RefinerRecipe recipe = this.level.getRecipeManager().getRecipeFor(RefinerRecipe.REFINING, this, this.level).orElse(null);
					if(canRefine(recipe)) {

						if(recipe.isREERecipe()) {
							if(this.secondCounter == 0) {
								this.items.get(1).shrink(1);
								this.secondCounter = 800;
							}						
						}

						this.recipeLocation = recipe.getId();
						this.refineTimeNeeded = recipe.getRefiningTime();
						ItemStack itembeingRefinedLocal = items.get(2);						
						if(!itembeingRefinedLocal.isEmpty()) {
							this.itemBeingRefined = itembeingRefinedLocal.getItem().getDescriptionId();
							itembeingRefinedLocal.shrink(1);												
						}
					} else {
						turnOff();
					}
				}
				setChanged();
			}
		}
	}

	private void turnOff() {
		BlockState blockState = level.getBlockState(this.worldPosition);
		level.setBlock(worldPosition, blockState.setValue(Refiner.REFINING, false), 3);
	}	

	private boolean canRefine(RefinerRecipe recipe) {
		if(!this.items.get(2).isEmpty() && recipe != null) {
			if(recipe.isREERecipe()) {
				if(this.items.get(1).getItem() == Items.SULPHURIC_ACID || this.secondCounter > 0) {
					return true;
				} else {
					return false;
				}
			}	
			if(recipe.hasRecipeOutput()) return true;									
		}		
		return false;
	}

	public void spawnExp(Player player) {
		spawnExp(player, this.totalExperience);
		this.totalExperience = 0;
	}

	public static void spawnExp(Player player, float totalXp) {		
		int i = (int) totalXp;		
		while(i > 0) {
			int j = ExperienceOrb.getExperienceValue(i);
			i -= j;
			player.level.addFreshEntity(new ExperienceOrb(player.level, player.xOld, player.yOld + 0.5D, player.zOld + 0.5D, j));
		}		
	}

	private void checkRecipeAndSpawnOutput(RefinerRecipe recipe) {			
		ItemStack recipeOutput;
		ItemStack itemstackInSlot;
		Boolean refinerFull;		
		for(int i = 3; i<12; i++) {
			refinerFull = true;
			recipeOutput = recipe.getResultItem(i);	
			if(recipeOutput.isEmpty()) continue;

			this.totalExperience += recipe.getExperience(); 

			for(int j = 3; j<12; j++) { 
				itemstackInSlot = this.items.get(j);
				if (itemstackInSlot.isEmpty()) {
					this.items.set(j, recipeOutput);
					j = 42;	
					refinerFull = false;					
				} else if (itemstackInSlot.sameItem(recipeOutput) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= this.getMaxStackSize()) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= itemstackInSlot.getMaxStackSize())) {
					itemstackInSlot.grow(recipeOutput.getCount());	
					j = 42;
					refinerFull = false;					
				}
			}
			if(refinerFull) {
				Block.popResource(level, worldPosition, recipeOutput);				
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
			return net.minecraftforge.common.ForgeHooks.getBurnTime(itemstack, null);
		}
	}

	@Override
	public void load(CompoundTag compound) {
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.items);
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
		super.load(compound);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		ContainerHelper.saveAllItems(compound, this.items);
		compound.putFloat("totalExperience", this.totalExperience);
		compound.putInt("itemBurnTime", this.itemBurnTime);
		compound.putInt("refineTime", this.refineTimeNeeded);
		compound.putInt("BurnTime", this.fuelTimeLeft);
		compound.putInt("secondCounter", this.secondCounter);
		compound.putInt("hasBurntFor", this.hasBeenRefinedFor);
		compound.putString("itemBurning", this.itemBeingRefined);
		if(this.recipeLocation != null) {
			compound.putString("recipeLocation", this.recipeLocation.toString());		
		} else {
			compound.putString("recipeLocation", "");
		}
		super.saveAdditional(compound);
	}

}
