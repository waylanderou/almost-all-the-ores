package waylanderou.almostalltheores.item.crafting;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class Serializers {

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrySerializers{

		@SubscribeEvent
		public static void register(RegistryEvent.Register<RecipeSerializer<?>> event) {
			CraftingHelper.register(new StoneAgeConditionSerializer());
		}

	}

}
