package waylanderou.almostalltheores.item.crafting;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class Serializers {

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrySerializers{

		@SubscribeEvent
		public static void register(RegistryEvent.Register<IRecipeSerializer<?>> event) {
			CraftingHelper.register(new StoneAgeConditionSerializer());
		}

	}

}
