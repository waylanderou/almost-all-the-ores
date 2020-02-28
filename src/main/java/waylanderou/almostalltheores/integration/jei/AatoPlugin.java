package waylanderou.almostalltheores.integration.jei;

import java.util.List;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.RefinerRegistryEvents;
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
	
	private static List<IRecipe<?>> getRecipesOfType(IRecipeType<?> recipeType) {
        return Minecraft.getInstance().world.getRecipeManager().getRecipes().stream()
                .filter(r -> r.getType() == recipeType)
                .collect(Collectors.toList());
    }

}
