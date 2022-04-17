package waylanderou.almostalltheores.item.crafting;

import javax.annotation.Nonnull;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import waylanderou.almostalltheores.RefinerRegistryEvents;

public class RefinerRecipe implements Recipe<Container> {
	public static final RecipeType<RefinerRecipe> REFINING = RecipeType.register("almostalltheores:refining");
	private final RecipeType<?> type;
	private final ResourceLocation id;
	final String group;
	final Ingredient ingredient;	
	final ItemStack result_a;
	final ItemStack result_b;
	final ItemStack result_c;
	final ItemStack result_d;
	final ItemStack result_e;
	final ItemStack result_f;
	final ItemStack result_g;
	final ItemStack result_h;
	final ItemStack result_i;
	final float experience;
	final int refiningTime;

	public RefinerRecipe(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack a, ItemStack b, ItemStack c, 
			ItemStack d, ItemStack e, ItemStack f, ItemStack g, ItemStack h, ItemStack i, float experience, int refiningTime) {
		type = REFINING;
		id = resourceLocation;
		this.group = group;
		this.ingredient = ingredient;
		this.result_a = a;
		this.result_b = b;
		this.result_c = c;
		this.result_d = d;
		this.result_e = e;
		this.result_f = f;
		this.result_g = g;
		this.result_h = h;
		this.result_i = i;

		this.experience = experience;
		this.refiningTime = refiningTime;
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {		
		return this.ingredient.test(inv.getItem(2));
	}

	@Deprecated
	@Override
	public ItemStack assemble(Container inv) {			
		return null;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	/**
	 * There are multiple outputs so do not use this method.
	 * The only reason this method returns something is to avoid Vanilla's recipe book throwing a NPE.
	 */
	@Deprecated
	@Override
	public ItemStack getResultItem() {	
		return this.result_a.copy();
	}

	public ItemStack getResultItem(int slotIndex) {
		switch(slotIndex) {
		case 3: return this.result_a.copy();		
		case 4: return this.result_b.copy();
		case 5: return this.result_c.copy();
		case 6: return this.result_d.copy();
		case 7: return this.result_e.copy();
		case 8: return this.result_f.copy();
		case 9: return this.result_g.copy();
		case 10: return this.result_h.copy();
		case 11: return this.result_i.copy();
		default: return ItemStack.EMPTY;
		}
	}

	public boolean isREERecipe() {
		if(this.id.getPath().contains("acid")) {
			return true;
		}
		return false;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RefinerRegistryEvents.refiner_serializer;
	}

	@Override
	public RecipeType<?> getType() {
		return type;
	}

	@Override
	@Nonnull
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		return nonnulllist;
	}

	public Ingredient getInput() {
		return this.ingredient;
	}

	@Override
	@Nonnull
	public ItemStack getToastSymbol() {
		return new ItemStack(RefinerRegistryEvents.REFINER);
	}

	public int getRefiningTime() {
		return refiningTime;
	}

	public boolean hasRecipeOutput() {
		ItemStack output = ItemStack.EMPTY;
		for(int i=3; i<12; i++) {
			output = getResultItem(i);
			if(!output.isEmpty()) {
				return true;
			}
		}		
		return false;
	}

	public float getExperience() {
		return this.experience;
	}

}
