package waylanderou.almostalltheores.jei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.RefinerRegistryEvents;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;

public class RefinerRecipeCategory implements IRecipeCategory<RefinerRecipe> { 
	public static final ResourceLocation UID = new ResourceLocation(AlmostAllTheOres.MODID, "refining");
	public static final ResourceLocation REFINER_GUI = new ResourceLocation(AlmostAllTheOres.MODID, "textures/gui/refinerguidisplay.png");
	public static final int width = 129;
	public static final int height = 66;

	private final IDrawable background;
	private final IDrawable icon;
	private final IDrawableStatic staticFlame;
	private final IDrawableAnimated animatedFlame;
	protected final IDrawableAnimated arrow;

	public RefinerRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(REFINER_GUI, 0, 0, width, height);
		icon = guiHelper.createDrawableIngredient(new ItemStack(RefinerRegistryEvents.REFINER));		
		staticFlame = guiHelper.createDrawable(REFINER_GUI, 130, 0, 14, 14); 
		animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
		arrow = guiHelper.drawableBuilder(REFINER_GUI, 130, 14, 24, 17) 
				.buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends RefinerRecipe> getRecipeClass() {
		return RefinerRecipe.class;
	}

	@Override
	public String getTitle() {
		return "Refining";
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void draw(RefinerRecipe recipe, double mouseX, double mouseY) {
		animatedFlame.draw(18, 26);
		arrow.draw(41, 24);

		float experience = recipe.getExperience();
		if (experience > 0) {
			String experienceString = experience + " XP"; 
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringWidth(experienceString);
			fontRenderer.drawString(experienceString, background.getWidth() - stringWidth - 61, 46, 0xFF808080);
		}
	}

	@Override
	public void setIngredients(RefinerRecipe recipe, IIngredients ingredients) {	

		List<ItemStack> oreSlot = new ArrayList<ItemStack>();
		oreSlot = Arrays.asList(recipe.getInput().getMatchingStacks()); 

		List<ItemStack> acidSlot = new ArrayList<ItemStack>();
		if(recipe.isREERecipe()) {
			acidSlot.add(new ItemStack(waylanderou.almostalltheores.item.Items.SULPHURIC_ACID));
		}

		List<ItemStack> fuelSlot = new ArrayList<ItemStack>();

		List<ItemStack> outputSlots = new ArrayList<ItemStack>();		
		for(int i=3; i<12; i++) {
			ItemStack stack = recipe.getRecipeOutput(i);
			if(stack != ItemStack.EMPTY && stack.getItem() != Items.AIR) { 
				outputSlots.add(stack);
			}
		}

		List<List<ItemStack>> recipeInputs = new ArrayList<List<ItemStack>>();
		recipeInputs.add(fuelSlot);
		recipeInputs.add(acidSlot);
		recipeInputs.add(oreSlot);

		ingredients.setInputLists(VanillaTypes.ITEM, recipeInputs);
		ingredients.setOutputs(VanillaTypes.ITEM, outputSlots);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, RefinerRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();		
		itemStacks.init(1, true, 6, 6);
		itemStacks.init(2, true, 28, 6);
		itemStacks.init(0, true, 17, 42);
		itemStacks.init(3, false, 70, 6);
		itemStacks.init(4, false, 88, 6);
		itemStacks.init(5, false, 106, 6);
		itemStacks.init(6, false, 70, 24);
		itemStacks.init(7, false, 88, 24);
		itemStacks.init(8, false, 106, 24);
		itemStacks.init(9, false, 70, 42);
		itemStacks.init(10, false, 88, 42);
		itemStacks.init(11, false, 106, 42);

		for(int i=3; i<12; i++) {
			ItemStack stack = recipe.getRecipeOutput(i);
			if(stack != ItemStack.EMPTY && stack.getItem() != Items.AIR) { 
				itemStacks.set(i, stack);
			}
		}
		if(recipe.isREERecipe()) {
			itemStacks.set(1, new ItemStack(waylanderou.almostalltheores.item.Items.SULPHURIC_ACID));
		}
		itemStacks.set(2, Arrays.asList(recipe.getInput().getMatchingStacks()));
	}

}