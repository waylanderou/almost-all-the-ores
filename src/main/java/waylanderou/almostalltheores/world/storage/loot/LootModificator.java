package waylanderou.almostalltheores.world.storage.loot;

import java.util.List;
import java.util.Random;

import com.google.gson.JsonObject;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import waylanderou.almostalltheores.AatoConfig;
import waylanderou.almostalltheores.AlmostAllTheOres;

@EventBusSubscriber(modid=AlmostAllTheOres.MODID, bus=EventBusSubscriber.Bus.MOD)
public class LootModificator {

	public LootModificator() {}

	private static class TestModifier extends LootModifier {
		private final Item drop;

		protected TestModifier(ILootCondition[] conditionsIn, Item drop) {
			super(conditionsIn);
			this.drop = drop;
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
				generatedLoot.add(new ItemStack(drop, 1 + i));
			}
			return generatedLoot;
		}

		private static class Serializer extends GlobalLootModifierSerializer<TestModifier>{

			@Override
			public TestModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
				Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "replacement")));
				return new TestModifier(ailootcondition, replacement);
			}

		}

	}

	@SubscribeEvent
	public static void registerLootModifiers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(new TestModifier.Serializer().setRegistryName("common_pgms_loot"));
	}

}