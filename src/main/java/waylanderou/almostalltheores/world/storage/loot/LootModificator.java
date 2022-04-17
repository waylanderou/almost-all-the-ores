package waylanderou.almostalltheores.world.storage.loot;

import java.util.List;
import java.util.Random;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.config.AatoConfig;

@EventBusSubscriber(modid=AlmostAllTheOres.MODID, bus=EventBusSubscriber.Bus.MOD)
public class LootModificator {

	public LootModificator() {}

	private static class TestModifier extends LootModifier {
		private final Item drop;

		protected TestModifier(LootItemCondition[] conditionsIn, Item drop) {
			super(conditionsIn);
			this.drop = drop;
		}

		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			if(AatoConfig.lootOsmiumOnly.get()) {
				generatedLoot.clear();
				ItemStack tool = context.getParam(LootContextParams.TOOL);
				int level = 0;
				if(EnchantmentHelper.getEnchantments(tool).containsKey(Enchantments.BLOCK_FORTUNE)) {
					level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, tool);
				}
				int i = new Random().nextInt(1 + level);
				generatedLoot.add(new ItemStack(drop, 1 + i));
			}
			return generatedLoot;
		}

		private static class Serializer extends GlobalLootModifierSerializer<TestModifier>{

			@Override
			public TestModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
				Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "replacement")));
				return new TestModifier(ailootcondition, replacement);
			}

			@Override
			public JsonObject write(TestModifier instance) {
				//For datagen
				return null;
			}

		}

	}

	@SubscribeEvent
	public static void registerLootModifiers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(new TestModifier.Serializer().setRegistryName("common_pgms_loot"));
	}

}