package waylanderou.almostalltheores.integration.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.RefinerRegistryEvents;
import waylanderou.almostalltheores.config.AatoConfig;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;

@JeiPlugin
public class AatoPlugin implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(AlmostAllTheOres.MODID);	
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(getRecipesOfType(RefinerRecipe.REFINING), RefinerRecipeCategory.UID);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new RefinerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(RefinerRegistryEvents.REFINER), RefinerRecipeCategory.UID);
	}

	@SuppressWarnings("resource")
	private static List<Recipe<?>> getRecipesOfType(RecipeType<?> recipeType) {
		return Minecraft.getInstance().level.getRecipeManager().getRecipes().stream()
				.filter(r -> r.getType() == recipeType)
				.collect(Collectors.toList());
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		if(!AatoConfig.hideJEI.get())
			return;
		List<ItemStack> itemsToBeHidden = new ArrayList<ItemStack>();
		jeiRuntime.getIngredientManager().getAllIngredients(VanillaTypes.ITEM).forEach(item -> {
			if(item.getItem().getRegistryName().toString().contains("almostalltheores"))
				itemsToBeHidden.add(item);
		});
		jeiRuntime.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM, itemsToBeHidden);
	}

}
