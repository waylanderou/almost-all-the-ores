package waylanderou.almostalltheores.item;

import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShearsItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import waylanderou.almostalltheores.AlmostAllTheOres;

public class Items {

	@ObjectHolder(AlmostAllTheOres.MODID + ":peat_piece")
	public static final Fuel PEAT_PIECE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":lignite")
	public static final Fuel LIGNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bituminous_coal")
	public static final Fuel BITUMINOUS_COAL = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anthracite")
	public static final Fuel ANTHRACITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":salt")
	public static final Item SALT = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":ruthenium")
	public static final Item RUTHENIUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":rhodium")
	public static final Item RHODIUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":palladium")
	public static final Item PALLADIUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":osmium")
	public static final Item OSMIUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":iridium")
	public static final Item IRIDIUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":platinum")
	public static final Item PLATINUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sulphur_dust")
	public static final Item SULPHUR_DUST = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":saltpetre")
	public static final Item SALTPETRE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":fertilizer")
	public static final Item FERTILIZER = null;	

	//GEMS

	@ObjectHolder(AlmostAllTheOres.MODID + ":jet")
	public static final Item JET = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":sapphire")
	public static final Item SAPPHIRE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":ruby")
	public static final Item RUBY = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":spinel")
	public static final Item SPINEL = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":amethyst")
	public static final Item AMETHYST = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":jade")
	public static final Item JADE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":tourmaline")
	public static final Item TOURMALINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":sugilite")
	public static final Item SUGILITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":peridot")
	public static final Item PERIDOT = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":agate")
	public static final Item AGATE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":carnelian")
	public static final Item CARNELIAN = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":chrysoprase")
	public static final Item CHRYSOPRASE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":heliotrope")
	public static final Item HELIOTROPE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":topaz")
	public static final Item TOPAZ = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":unakite")
	public static final Item UNAKITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":tanzanite")
	public static final Item TANZANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":hauyne")
	public static final Item HAUYNE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":onyx")
	public static final Item ONYX = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":opal")
	public static final Item OPAL = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":moonstone")
	public static final Item MOONSTONE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":turquoise")
	public static final Item TURQUOISE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":amazonite")
	public static final Item AMAZONITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":chrysocolla")
	public static final Item CHRYSOCOLLA = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":almandine")
	public static final Item ALMANDINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":spessartine")
	public static final Item SPESSARTINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":pyrope")
	public static final Item PYROPE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":tsavorite")
	public static final Item TSAVORITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":andradite")
	public static final Item ANDRADITE = null;

	//Stone age
	@ObjectHolder(AlmostAllTheOres.MODID +":filter")
	public static final Item filter = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":grinder")
	public static final Item GRINDER = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":digester")
	public static final Item DIGESTER = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":dryer")
	public static final Item DRYER = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":refiner_mechanism")
	public static final Item REFINER_MECHANISM = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":separation_part")
	public static final Item SEPARATION_PART = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":grinding_part")
	public static final Item GRINDING_PART = null;

	@ObjectHolder(AlmostAllTheOres.MODID +":refined_iron_ore")
	public static final Item REFINED_IRON_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":flint_shears")
	public static final ShearsItem FLINT_SHEARS = null;


	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class ItemsRegistryEvents {

		public static final String[] normalItemNames = {
				"salt", "ruthenium", "rhodium", "palladium", "osmium", "iridium", "platinum", "jet",
				"sapphire", "ruby", "spinel", "amethyst", "jade", "tourmaline", "sugilite", "peridot", "agate", "carnelian", 
				"chrysoprase", "heliotrope", "topaz", "unakite", "tanzanite", "hauyne", "onyx", "opal", "moonstone", "turquoise", 
				"amazonite", "chrysocolla", "almandine", "spessartine", "pyrope", "tsavorite", "andradite", "sulphur_dust", "saltpetre",
				"filter", "grinder", "digester", "dryer", "refiner_mechanism", "separation_part", "grinding_part", "refined_iron_ore"				
		};
		public static final String[] customItemNames = {
				"peat_piece", "lignite", "bituminous_coal", "anthracite"	
		};

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			for(String name: normalItemNames) {
				event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(name));								
			}
			for(String name: customItemNames) {
				event.getRegistry().register(new Fuel(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(name));
			}
			event.getRegistry().register(new BoneMealItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("fertilizer"));
			event.getRegistry().register(new ShearsItem((new Item.Properties()).maxDamage(42).group(ItemGroup.TOOLS)).setRegistryName("flint_shears"));
		}

	}

}
