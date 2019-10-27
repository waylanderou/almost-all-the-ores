package waylanderou.almostalltheores;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
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
	public static TileEntityType<RefinerTile> REFINER_TILE;

	@ObjectHolder( "almostalltheores:refiner")
	public static ContainerType<RefinerContainer> REFINER_CONTAINER;

	@ObjectHolder("almostalltheores:refiner_serializer")
	public static RefinerRecipeSerializer<RefinerRecipe> refiner_serializer;

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {		

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new Refiner());       
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().register(new BlockItem(REFINER, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName("refiner"));
		}

		@SubscribeEvent
		public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(RefinerTile::new, REFINER).build(null).setRegistryName("refiner"));			
		}

		@SubscribeEvent
		public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
			event.getRegistry().register(new RefinerRecipeSerializer<>(RefinerRecipe::new).setRegistryName("refiner_serializer"));
		}

		@SubscribeEvent
		public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(new ContainerType<>(RefinerContainer::new).setRegistryName("refiner"));
		} 

	}

}
