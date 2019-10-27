package waylanderou.almostalltheores.item.crafting;

import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RefinerRecipeSerializer<T extends RefinerRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
	public final RefinerRecipeSerializer.IFactory<T> factory;

	public RefinerRecipeSerializer(RefinerRecipeSerializer.IFactory<T> factory) {
		this.factory = factory;
	}

	@Override
	@Nonnull
	public T read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
		String group = JSONUtils.getString(json, "group", "");
		JsonElement jsonelement = JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");//change that
		Ingredient ingredient = Ingredient.deserialize(jsonelement);		
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

		float exp = JSONUtils.getFloat(json, "experience", 0.0F);
		int time = JSONUtils.getInt(json, "refiningTime", 200);

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

				ResourceLocation rslocation = new ResourceLocation(JSONUtils.getString(jsonobj, "item"));
				int count = JSONUtils.getInt(jsonobj, "count", 1);				
				results.add(new ItemStack(ForgeRegistries.ITEMS.getValue(rslocation), count));
			} else {
				results.add(ItemStack.EMPTY);
			}
		}
		return results;
	}

	@Nullable
	@Override
	public T read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
		String s = buffer.readString(32767);
		Ingredient ingredient = Ingredient.read(buffer);		
		ItemStack a = buffer.readItemStack();
		ItemStack b = buffer.readItemStack();
		ItemStack c = buffer.readItemStack();
		ItemStack d = buffer.readItemStack();
		ItemStack e = buffer.readItemStack();
		ItemStack f = buffer.readItemStack();
		ItemStack g = buffer.readItemStack();
		ItemStack h = buffer.readItemStack();
		ItemStack i = buffer.readItemStack();
		float exp = buffer.readFloat();
		int refiningTime = buffer.readVarInt();		
		return this.factory.create(recipeId, s, ingredient, a, b, c, d, e, f, g, h, i, exp, refiningTime);
	}

	@Override
	public void write(PacketBuffer buffer, T recipe) {
		buffer.writeString(recipe.group);
		recipe.ingredient.write(buffer);		
		buffer.writeItemStack(recipe.result_a);
		buffer.writeItemStack(recipe.result_b);
		buffer.writeItemStack(recipe.result_c);
		buffer.writeItemStack(recipe.result_d);
		buffer.writeItemStack(recipe.result_e);
		buffer.writeItemStack(recipe.result_f);
		buffer.writeItemStack(recipe.result_g);
		buffer.writeItemStack(recipe.result_h);
		buffer.writeItemStack(recipe.result_i);		
		buffer.writeFloat(recipe.experience);
		buffer.writeVarInt(recipe.refiningTime);
	}

	public interface IFactory<T extends RefinerRecipe> {
		T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack a, ItemStack b, ItemStack c, ItemStack d,
				ItemStack e, ItemStack f, ItemStack g, ItemStack h , ItemStack i, float experience, int cookTime);
	}

}
