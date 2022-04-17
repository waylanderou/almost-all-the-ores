package waylanderou.almostalltheores;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import waylanderou.almostalltheores.block.Refiner;
import waylanderou.almostalltheores.inventory.container.RefinerContainer;
import waylanderou.almostalltheores.item.crafting.RefinerRecipe;
import waylanderou.almostalltheores.item.crafting.RefinerRecipeSerializer;

public class RefinerRegistryEvents {

	@ObjectHolder("almostalltheores:refiner")
	public static Refiner REFINER;

	@ObjectHolder("almostalltheores:refiner")
	public static BlockEntityType<RefinerTile> REFINER_TILE;

	@ObjectHolder( "almostalltheores:refiner")
	public static MenuType<RefinerContainer> REFINER_CONTAINER;

	@ObjectHolder("almostalltheores:refiner_serializer")
	public static RefinerRecipeSerializer<RefinerRecipe> refiner_serializer;

	@Mod.EventBusSubscriber(modid=AlmostAllTheOres.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {		

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new Refiner());       
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().register(new BlockItem(REFINER, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)).setRegistryName("refiner"));
		}

		@SubscribeEvent
		public static void onTileEntityRegistry(final RegistryEvent.Register<BlockEntityType<?>> event) {
			event.getRegistry().register(BlockEntityType.Builder.of(RefinerTile::new, REFINER).build(null).setRegistryName("refiner"));			
		}

		@SubscribeEvent
		public static void onRecipeSerializersRegistry(final RegistryEvent.Register<RecipeSerializer<?>> event) {
			event.getRegistry().register(new RefinerRecipeSerializer<>(RefinerRecipe::new).setRegistryName("refiner_serializer"));
		}

		@SubscribeEvent
		public static void onContainerRegistry(final RegistryEvent.Register<MenuType<?>> event) {
			event.getRegistry().register(new MenuType<>(RefinerContainer::new).setRegistryName("refiner"));
		} 

	}

}
