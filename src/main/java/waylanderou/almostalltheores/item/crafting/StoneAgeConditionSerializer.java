package waylanderou.almostalltheores.item.crafting;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class StoneAgeConditionSerializer implements IConditionSerializer<StoneAgeCondition> {

	public StoneAgeConditionSerializer() {		
	}

	@Override
	public void write(JsonObject json, StoneAgeCondition value) {
		json.addProperty("stoneage", value.stoneage);
	}

	@Override
	public StoneAgeCondition read(JsonObject json) {		
		return new StoneAgeCondition(GsonHelper.getAsBoolean(json, "stoneage"));
	}

	@Override
	public ResourceLocation getID() {
		return StoneAgeCondition.NAME;
	}

}
