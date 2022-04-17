package waylanderou.almostalltheores.item.crafting;

import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RefinerRecipeSerializer<T extends RefinerRecipe> extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<T> {
	public final RefinerRecipeSerializer.IFactory<T> factory;

	public RefinerRecipeSerializer(RefinerRecipeSerializer.IFactory<T> factory) {
		this.factory = factory;
	}

	@Override
	@Nonnull
	public T fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
		String group = GsonHelper.getAsString(json, "group", "");
		JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");//change that
		Ingredient ingredient = Ingredient.fromJson(jsonelement);		
		ArrayList<ItemStack> results = getResults(json);

		ItemStack a = results.get(0);
		ItemStack b = results.get(1);
		ItemStack c = results.get(2);
		ItemStack d = results.get(3);
		ItemStack e = results.get(4);
		ItemStack f = results.get(5);
		ItemStack g = results.get(6);
		ItemStack h = results.get(7);
		ItemStack i = results.get(8);		              	

		float exp = GsonHelper.getAsFloat(json, "experience", 0.0F);
		int time = GsonHelper.getAsInt(json, "refiningTime", 200);

		return this.factory.create(recipeId, group, ingredient, a, b, c, d, e, f, g, h, i, exp, time);
	}

	private ArrayList<ItemStack> getResults(JsonObject json) {
		ArrayList<ItemStack> results = new ArrayList<ItemStack>();		
		final String[] toCheck = {
				"result_a", "result_b", "result_c", "result_d", "result_e", "result_f",
				"result_g", "result_h", "result_i"
		};		
		for(String s : toCheck) {
			if(json.has(s)) {				
				JsonObject jsonobj = json.getAsJsonObject(s);
				if(!jsonobj.isJsonObject()) throw new JsonSyntaxException("Expected json object for " + s);

				ResourceLocation rslocation = new ResourceLocation(GsonHelper.getAsString(jsonobj, "item"));
				int count = GsonHelper.getAsInt(jsonobj, "count", 1);				
				results.add(new ItemStack(ForgeRegistries.ITEMS.getValue(rslocation), count));
			} else {
				results.add(ItemStack.EMPTY);
			}
		}
		return results;
	}

	@Nullable
	@Override
	public T fromNetwork(@Nonnull ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String s = buffer.readUtf(32767);
		Ingredient ingredient = Ingredient.fromNetwork(buffer);		
		ItemStack a = buffer.readItem();
		ItemStack b = buffer.readItem();
		ItemStack c = buffer.readItem();
		ItemStack d = buffer.readItem();
		ItemStack e = buffer.readItem();
		ItemStack f = buffer.readItem();
		ItemStack g = buffer.readItem();
		ItemStack h = buffer.readItem();
		ItemStack i = buffer.readItem();
		float exp = buffer.readFloat();
		int refiningTime = buffer.readVarInt();		
		return this.factory.create(recipeId, s, ingredient, a, b, c, d, e, f, g, h, i, exp, refiningTime);
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, T recipe) {
		buffer.writeUtf(recipe.group);
		recipe.ingredient.toNetwork(buffer);	
		buffer.writeItem(recipe.result_a);
		buffer.writeItem(recipe.result_b);
		buffer.writeItem(recipe.result_c);
		buffer.writeItem(recipe.result_d);
		buffer.writeItem(recipe.result_e);
		buffer.writeItem(recipe.result_f);
		buffer.writeItem(recipe.result_g);
		buffer.writeItem(recipe.result_h);
		buffer.writeItem(recipe.result_i);		
		buffer.writeFloat(recipe.experience);
		buffer.writeVarInt(recipe.refiningTime);
	}

	public interface IFactory<T extends RefinerRecipe> {
		T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack a, ItemStack b, ItemStack c, ItemStack d,
				ItemStack e, ItemStack f, ItemStack g, ItemStack h , ItemStack i, float experience, int cookTime);
	}

}
