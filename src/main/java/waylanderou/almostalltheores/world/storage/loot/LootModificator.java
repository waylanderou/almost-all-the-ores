package waylanderou.almostalltheores.world.storage.loot;

import java.util.List;
import java.util.Random;

import com.google.gson.JsonObject;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import waylanderou.almostalltheores.AatoConfig;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.item.Items;

@EventBusSubscriber(modid=AlmostAllTheOres.MODID, bus=EventBusSubscriber.Bus.MOD)
public class LootModificator {

	public LootModificator() {}

	private static class TestModifier extends LootModifier {

		protected TestModifier(ILootCondition[] conditionsIn) {
			super(conditionsIn);
		}

		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			if(AatoConfig.lootOsmiumOnly.get()) {
				generatedLoot.clear();
				ItemStack tool = context.get(LootParameters.TOOL);
				int level = 0;
				if(EnchantmentHelper.getEnchantments(tool).containsKey(Enchantments.FORTUNE)) {
					level = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, tool);
				}
				int i = new Random().nextInt(1 + level);
				generatedLoot.add(new ItemStack(Items.OSMIUM, 1 + i));
			}
			return generatedLoot;
		}

		private static class Serializer extends GlobalLootModifierSerializer<TestModifier>{

			@Override
			public TestModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
				return new TestModifier(ailootcondition);
			}

		}

	}

	@SubscribeEvent
	public static void registerLootModifiers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(new TestModifier.Serializer().setRegistryName("common_pgms_loot"));
	}

}
