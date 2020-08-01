package waylanderou.almostalltheores.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.AatoConfig;
import waylanderou.almostalltheores.item.AnthraciteBlockItemBlock;

public class Ores {

	@ObjectHolder(AlmostAllTheOres.MODID + ":pyrite")
	public static final CustomOre PYRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sulphur")
	public static final CustomOre SULPHUR = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":clausthalite")
	public static final CustomOre CLAUSTHALITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":guano")
	public static final CustomOre GUANO = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":phosphorite")
	public static final CustomOre PHOSPHORITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":peat")
	public static final CustomOre PEAT = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":lignite_ore")
	public static final CustomOre LIGNITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bituminous_coal_ore")
	public static final CustomOre BITUMINOUS_COAL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anthracite_ore")
	public static final CustomOre ANTHRACITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":graphite")
	public static final CustomOre GRAPHITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":lollingite")
	public static final CustomOre LOLLINGITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":realgar")
	public static final CustomOre REALGAR = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":orpiment")
	public static final CustomOre ORPIMENT = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":arsenopyrite")
	public static final CustomOre ARSENOPYRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":stibnite")
	public static final CustomOre STIBNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":germanite")
	public static final CustomOre GERMANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":argutite")
	public static final CustomOre ARGUTITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bismuthinite")
	public static final CustomOre BISMUTHINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":native_bismuth")
	public static final CustomOre NATIVE_BISMUTH = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bismite")
	public static final CustomOre BISMITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":cassiterite")
	public static final CustomOre CASSITERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":teallite")
	public static final CustomOre TEALLITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":stannite")
	public static final CustomOre STANNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":native_tin")
	public static final CustomOre NATIVE_TIN = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":kesterite")
	public static final CustomOre KESTERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":galena")
	public static final CustomOre GALENA = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":cerussite")
	public static final CustomOre CERUSSITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anglesite")
	public static final CustomOre ANGLESITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":boulangerite")
	public static final CustomOre BOULANGERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":pyromorphite")
	public static final CustomOre PYROMORPHITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bauxite")
	public static final CustomOre BAUXITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nepheline")
	public static final CustomOre NEPHELINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":leucite")
	public static final CustomOre LEUCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sphalerite")
	public static final CustomOre SPHALERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":smithsonite")
	public static final CustomOre SMITHSONITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hemimorphite")
	public static final CustomOre HEMIMORPHITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":franklinite")
	public static final CustomOre FRANKLINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":zincite")
	public static final CustomOre ZINCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hydrozincite")
	public static final CustomOre HYDROZINCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":otavite")
	public static final CustomOre OTAVITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":greenockite")
	public static final CustomOre GREENOCKITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":cinnabar")
	public static final CustomOre CINNABAR = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":native_copper")
	public static final CustomOre NATIVE_COPPER = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":chalcopyrite")
	public static final CustomOre CHALCOPYRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":chalcocite")
	public static final CustomOre CHALCOCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bornite")
	public static final CustomOre BORNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":enargite")
	public static final CustomOre ENARGITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tennantite")
	public static final CustomOre TENNANTITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tetrahedrite")
	public static final CustomOre TETRAHEDRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":covellite")
	public static final CustomOre COVELLITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":azurite")
	public static final CustomOre AZURITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":malachite")
	public static final CustomOre MALACHITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":cuprite")
	public static final CustomOre CUPRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":native_silver")
	public static final CustomOre NATIVE_SILVER = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":acanthite")
	public static final CustomOre ACANTHITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":stephanite")
	public static final CustomOre STEPHANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":proustite")
	public static final CustomOre PROUSTITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":freibergite")
	public static final CustomOre FREIBERGITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nickeline")
	public static final CustomOre NICKELINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":pentlandite")
	public static final CustomOre PENTLANDITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nepouite")
	public static final CustomOre NEPOUITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":millerite")
	public static final CustomOre MILLERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":gersdorffite")
	public static final CustomOre GERSDORFFITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":cobaltite")
	public static final CustomOre COBALTITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":carrollite")
	public static final CustomOre CARROLLITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":skutterudite")
	public static final CustomOre SKUTTERUDITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hematite")
	public static final CustomOre HEMATITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":magnetite")
	public static final CustomOre MAGNETITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":limonite")
	public static final CustomOre LIMONITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":siderite")
	public static final CustomOre SIDERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":telluric_iron")
	public static final CustomOre TELLURIC_IRON = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":pyrolusite")
	public static final CustomOre PYROLUSITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":rhodochrosite")
	public static final CustomOre RHODOCHROSITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hollandite")
	public static final CustomOre HOLLANDITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":manganite")
	public static final CustomOre MANGANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hausmannite")
	public static final CustomOre HAUSMANNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":alabandite")
	public static final CustomOre ALABANDITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":rhodonite")
	public static final CustomOre RHODONITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":chromite")
	public static final CustomOre CHROMITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":molybdenite")
	public static final CustomOre MOLYBDENITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":wulfenite")
	public static final CustomOre WULFENITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":scheelite")
	public static final CustomOre SCHEELITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":ferberite")
	public static final CustomOre FERBERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hubnerite")
	public static final CustomOre HUBNERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":vanadinite")
	public static final CustomOre VANADINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":descloizite")
	public static final CustomOre DESCLOIZITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":columbite")
	public static final CustomOre COLUMBITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tantalite")
	public static final CustomOre TANTALITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":rutile")
	public static final CustomOre RUTILE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":ilmenite")
	public static final CustomOre ILMENITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anatase")
	public static final CustomOre ANATASE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":brookite")
	public static final CustomOre BROOKITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":titanite")
	public static final CustomOre TITANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":zircon")
	public static final CustomOre ZIRCON = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":thorite")
	public static final CustomOre THORITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":carnotite")
	public static final CustomOre CARNOTITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":uraninite")
	public static final CustomOre URANINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":torbernite")
	public static final CustomOre TORBERNITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":magnesite")
	public static final CustomOre MAGNESITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":kieserite")
	public static final CustomOre KIESERITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":brucite")
	public static final CustomOre BRUCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":calcite")
	public static final CustomOre CALCITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":gypsum")
	public static final CustomOre GYPSUM = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anhydrite")
	public static final CustomOre ANHYDRITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":dolomite")
	public static final CustomOre DOLOMITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":strontianite")
	public static final CustomOre STRONTIANITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":celestine")
	public static final CustomOre CELESTINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":polylithionite")
	public static final CustomOre POLYLITHIONITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":petalite")
	public static final CustomOre PETALITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":carnallite")
	public static final CustomOre CARNALLITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sylvite")
	public static final CustomOre SYLVITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":polyhalite")
	public static final CustomOre POLYHALITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":kainite")
	public static final CustomOre KAINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":langbeinite")
	public static final CustomOre LANGBEINITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nitratine")
	public static final CustomOre NITRATINE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":halite")
	public static final CustomOre HALITE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sapphire_ore")
	public static final CustomOre SAPPHIRE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":ruby_ore")
	public static final CustomOre RUBY_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":spinel_ore")
	public static final CustomOre SPINEL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":amethyst_ore")
	public static final CustomOre AMETHYST_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":jade_ore")
	public static final CustomOre JADE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tourmaline_ore")
	public static final CustomOre TOURMALINE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":sugilite_ore")
	public static final CustomOre SUGILITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":peridot_ore")
	public static final CustomOre PERIDOT_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":agate_ore")
	public static final CustomOre AGATE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":carnelian_ore")
	public static final CustomOre CARNELIAN_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":chrysoprase_ore")
	public static final CustomOre CHRYSOPRASE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":heliotrope_ore")
	public static final CustomOre HELIOTROPE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":topaz_ore")
	public static final CustomOre TOPAZ_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":unakite_ore")
	public static final CustomOre UNAKITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tanzanite_ore")
	public static final CustomOre TANZANITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":hauyne_ore")
	public static final CustomOre HAUYNE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":onyx_ore")
	public static final CustomOre ONYX_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":opal_ore")
	public static final CustomOre OPAL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":moonstone_ore")
	public static final CustomOre MOONSTONE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":turquoise_ore")
	public static final CustomOre TURQUOISE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":amazonite_ore")
	public static final CustomOre AMAZONITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":chrysocolla_ore")
	public static final CustomOre CHRYSOCOLLA_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":almandine_ore")
	public static final CustomOre ALMANDINE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":spessartine_ore")
	public static final CustomOre SPESSARTINE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":pyrope_ore")
	public static final CustomOre PYROPE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":tsavorite_ore")
	public static final CustomOre TSAVORITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":andradite_ore")
	public static final CustomOre ANDRADITE_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":mithril_ore")
	public static final CustomOre MITHRIL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":platinum_group_metals")
	public static final CustomOre PLATINUM_GROUP_METALS = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":rare_platinum_group_metals")
	public static final CustomOre RARE_PLATINUM_GROUP_METALS = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":anthracite_block")
	public static final CustomOre ANTHRACITE_BLOCK = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nether_coal_ore")
	public static final CustomOre NETHER_COAL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nether_gold_ore")
	public static final CustomOre NETHER_GOLD_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":nether_mithril_ore")
	public static final CustomOre NETHER_MITHRIL_ORE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bastnasite_la")
	public static final CustomOre BASTNASITE_LA = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":monazite_la")
	public static final CustomOre MONAZITE_LA = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bastnasite_ce")
	public static final CustomOre BASTNASITE_CE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":monazite_ce")
	public static final CustomOre MONAZITE_CE = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bastnasite_nd")
	public static final CustomOre BASTNASITE_ND = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":monazite_nd")
	public static final CustomOre MONAZITE_ND = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":bastnasite_y")
	public static final CustomOre BASTNASITE_Y = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":samarskite_y")
	public static final CustomOre SAMARSKITE_Y = null;

	@ObjectHolder(AlmostAllTheOres.MODID + ":thortveitite")
	public static final CustomOre THORTVEITITE = null;

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class OresRegistryEvents{		

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new CustomOre(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.GROUND)).setRegistryName("guano"));
			event.getRegistry().register(new CustomOre(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.GROUND)).setRegistryName("peat"));
			event.getRegistry().register(new CustomOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).harvestLevel(AatoConfig.mithrilHL.get()).lightValue(7)).setRegistryName("mithril_ore"));
			event.getRegistry().register(new CustomOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).harvestLevel(AatoConfig.mithrilHL.get()).lightValue(7)).setRegistryName("nether_mithril_ore"));

			final int copperHL = AatoConfig.copperHL.get();
			final int leadHL = AatoConfig.leadHL.get();
			final int zincHL = AatoConfig.zincHL.get();
			final int tinHL = AatoConfig.tinHL.get();
			final int cadmiumHL = AatoConfig.cadmiumHL.get();
			final int mercuryHL = AatoConfig.mercuryHL.get();
			final int aluminiumHL = AatoConfig.aluminiumHL.get();
			final int silverHL = AatoConfig.silverHL.get();
			final int manganeseHL = AatoConfig.manganeseHL.get();
			final int titaniumHL = AatoConfig.titaniumHL.get();
			final int tungstenHL = AatoConfig.tungstenHL.get();
			final int nickelHL = AatoConfig.nickelHL.get();
			final int carnotiteHL = AatoConfig.carnotiteHL.get();
			final int uraniniteHL = AatoConfig.uraniniteHL.get();
			final int torberniteHL = uraniniteHL;
			final int molybdenumHL = AatoConfig.molybdenumHL.get();
			final int ironHL = AatoConfig.ironHL.get();

			registerBlock(event, 1, "pyrite");
			registerBlock(event, 1, "sulphur");
			registerBlock(event, 1, "clausthalite");
			registerBlock(event, 1, "phosphorite");
			registerBlock(event, 0, "lignite_ore");
			registerBlock(event, 0, "bituminous_coal_ore");
			registerBlock(event, 0, "anthracite_ore");
			registerBlock(event, 1, "graphite");
			registerBlock(event, 2, "lollingite");
			registerBlock(event, 1, "realgar");
			registerBlock(event, 1, "orpiment");
			registerBlock(event, 2, "arsenopyrite");
			registerBlock(event, 2, "stibnite");
			registerBlock(event, 2, "germanite");
			registerBlock(event, 2, "argutite");
			registerBlock(event, 2, "bismuthinite");
			registerBlock(event, 2, "native_bismuth");
			registerBlock(event, 2, "bismite");
			registerBlock(event, tinHL, "cassiterite");
			registerBlock(event, tinHL, "teallite");
			registerBlock(event, tinHL, "stannite");
			registerBlock(event, tinHL, "native_tin");
			registerBlock(event, tinHL, "kesterite");
			registerBlock(event, leadHL, "galena");
			registerBlock(event, leadHL, "cerussite");
			registerBlock(event, leadHL, "anglesite");
			registerBlock(event, leadHL, "boulangerite");
			registerBlock(event, leadHL, "pyromorphite");
			registerBlock(event, aluminiumHL, "bauxite");
			registerBlock(event, aluminiumHL, "nepheline");
			registerBlock(event, aluminiumHL, "leucite");
			registerBlock(event, zincHL, "sphalerite");
			registerBlock(event, zincHL, "smithsonite");
			registerBlock(event, zincHL, "hemimorphite");
			registerBlock(event, zincHL, "franklinite");
			registerBlock(event, zincHL, "zincite");
			registerBlock(event, zincHL, "hydrozincite");
			registerBlock(event, cadmiumHL, "otavite"); 
			registerBlock(event, cadmiumHL, "greenockite"); 
			registerBlock(event, mercuryHL, "cinnabar"); 
			registerBlock(event, copperHL, "native_copper");
			registerBlock(event, copperHL, "chalcopyrite");
			registerBlock(event, copperHL, "chalcocite");
			registerBlock(event, copperHL, "bornite");
			registerBlock(event, copperHL, "enargite");
			registerBlock(event, copperHL, "tennantite");
			registerBlock(event, copperHL, "tetrahedrite");
			registerBlock(event, copperHL, "covellite");
			registerBlock(event, copperHL, "azurite");
			registerBlock(event, copperHL, "malachite");
			registerBlock(event, copperHL, "cuprite");
			registerBlock(event, silverHL, "native_silver");
			registerBlock(event, silverHL, "acanthite");
			registerBlock(event, silverHL, "stephanite");
			registerBlock(event, silverHL, "proustite");
			registerBlock(event, silverHL, "freibergite");
			registerBlock(event, nickelHL, "nickeline");
			registerBlock(event, nickelHL, "pentlandite");
			registerBlock(event, nickelHL, "nepouite");
			registerBlock(event, nickelHL, "millerite");
			registerBlock(event, nickelHL, "gersdorffite");
			registerBlock(event, 2, "cobaltite");
			registerBlock(event, 2, "carrollite");
			registerBlock(event, 2, "skutterudite");
			registerBlock(event, ironHL, "hematite");
			registerBlock(event, ironHL, "magnetite");
			registerBlock(event, ironHL, "limonite");
			registerBlock(event, ironHL, "siderite");
			registerBlock(event, ironHL, "telluric_iron");
			registerBlock(event, manganeseHL, "pyrolusite");
			registerBlock(event, manganeseHL, "rhodochrosite");
			registerBlock(event, manganeseHL, "hollandite");
			registerBlock(event, manganeseHL, "manganite");
			registerBlock(event, manganeseHL, "hausmannite");
			registerBlock(event, manganeseHL, "alabandite");
			registerBlock(event, manganeseHL, "rhodonite");
			registerBlock(event, AatoConfig.chromiumHL.get(), "chromite");
			registerBlock(event, molybdenumHL, "molybdenite");
			registerBlock(event, molybdenumHL, "wulfenite");
			registerBlock(event, tungstenHL, "scheelite");
			registerBlock(event, tungstenHL, "ferberite");
			registerBlock(event, tungstenHL, "hubnerite");
			registerBlock(event, 2, "vanadinite");
			registerBlock(event, 2, "descloizite");
			registerBlock(event, 3, "columbite");
			registerBlock(event, 2, "tantalite");
			registerBlock(event, titaniumHL, "rutile");
			registerBlock(event, titaniumHL, "ilmenite");
			registerBlock(event, titaniumHL, "anatase");
			registerBlock(event, titaniumHL, "brookite");
			registerBlock(event, titaniumHL, "titanite");
			registerBlock(event, 3, "zircon");
			registerBlock(event, 3, "thorite");
			registerBlock(event, carnotiteHL, "carnotite");
			registerBlock(event, uraniniteHL, "uraninite");
			registerBlock(event, torberniteHL, "torbernite");
			registerBlock(event, 1, "magnesite");
			registerBlock(event, 1, "kieserite");
			registerBlock(event, 1, "brucite");
			registerBlock(event, 1, "calcite");
			registerBlock(event, 1, "gypsum");
			registerBlock(event, 1, "anhydrite");
			registerBlock(event, 1, "dolomite");
			registerBlock(event, 2, "strontianite");
			registerBlock(event, 2, "celestine");
			registerBlock(event, 2, "polylithionite");
			registerBlock(event, 2, "petalite");
			registerBlock(event, 1, "carnallite");
			registerBlock(event, 1, "sylvite");
			registerBlock(event, 1, "polyhalite");
			registerBlock(event, 1, "kainite");
			registerBlock(event, 1, "langbeinite");
			registerBlock(event, AatoConfig.nitratineHL.get(), "nitratine");
			registerBlock(event, AatoConfig.haliteHL.get(), "halite");
			registerBlock(event, 2, "sapphire_ore");
			registerBlock(event, 2, "ruby_ore");
			registerBlock(event, 2, "spinel_ore");
			registerBlock(event, 2, "amethyst_ore");
			registerBlock(event, 2, "jade_ore");
			registerBlock(event, 2, "tourmaline_ore");
			registerBlock(event, 2, "sugilite_ore");
			registerBlock(event, 2, "peridot_ore");
			registerBlock(event, 2, "agate_ore");
			registerBlock(event, 2, "carnelian_ore");
			registerBlock(event, 2, "chrysoprase_ore");
			registerBlock(event, 2, "heliotrope_ore");
			registerBlock(event, 2, "topaz_ore");
			registerBlock(event, 2, "unakite_ore");
			registerBlock(event, 2, "tanzanite_ore");
			registerBlock(event, 2, "hauyne_ore");
			registerBlock(event, 2, "onyx_ore");
			registerBlock(event, 2, "opal_ore");
			registerBlock(event, 2, "moonstone_ore");
			registerBlock(event, 2, "turquoise_ore");
			registerBlock(event, 2, "amazonite_ore");
			registerBlock(event, 1, "chrysocolla_ore");
			registerBlock(event, 2, "almandine_ore");
			registerBlock(event, 1, "spessartine_ore");
			registerBlock(event, 1, "pyrope_ore");
			registerBlock(event, 1, "tsavorite_ore");
			registerBlock(event, 1, "andradite_ore");
			registerBlock(event, AatoConfig.commonPgmsHL.get(), "platinum_group_metals");
			registerBlock(event, AatoConfig.rarePgmsHL.get(), "rare_platinum_group_metals");
			registerBlock(event, 0, "anthracite_block");
			registerBlock(event, 2, "nether_gold_ore");
			registerBlock(event, 0, "nether_coal_ore");	
			registerBlock(event, 2, "bastnasite_la");
			registerBlock(event, 2, "monazite_la");
			registerBlock(event, 2, "bastnasite_ce");
			registerBlock(event, 2, "monazite_ce");
			registerBlock(event, 2, "bastnasite_nd");
			registerBlock(event, 2, "monazite_nd");
			registerBlock(event, 2, "bastnasite_y");
			registerBlock(event, 2, "samarskite_y");
			registerBlock(event, 2, "thortveitite");

		}

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {			
			registerItemBlock(PYRITE, event);
			registerItemBlock(SULPHUR, event);
			registerItemBlock(CLAUSTHALITE, event);
			registerItemBlock(GUANO, event);
			registerItemBlock(PHOSPHORITE, event);			
			registerItemBlock(LIGNITE_ORE, event);
			registerItemBlock(BITUMINOUS_COAL_ORE, event);
			registerItemBlock(ANTHRACITE_ORE, event);
			registerItemBlock(GRAPHITE, event);
			registerItemBlock(LOLLINGITE, event);
			registerItemBlock(REALGAR, event);
			registerItemBlock(ORPIMENT, event);
			registerItemBlock(ARSENOPYRITE, event);
			registerItemBlock(STIBNITE, event);
			registerItemBlock(GERMANITE, event);
			registerItemBlock(ARGUTITE, event);
			registerItemBlock(BISMUTHINITE, event);
			registerItemBlock(NATIVE_BISMUTH, event);
			registerItemBlock(BISMITE, event);
			registerItemBlock(CASSITERITE, event);
			registerItemBlock(TEALLITE, event);
			registerItemBlock(STANNITE, event);
			registerItemBlock(NATIVE_TIN, event);
			registerItemBlock(KESTERITE, event);
			registerItemBlock(GALENA, event);
			registerItemBlock(CERUSSITE, event);
			registerItemBlock(ANGLESITE, event);
			registerItemBlock(BOULANGERITE, event);
			registerItemBlock(PYROMORPHITE, event);
			registerItemBlock(BAUXITE, event);
			registerItemBlock(NEPHELINE, event);
			registerItemBlock(LEUCITE, event);
			registerItemBlock(SPHALERITE, event);
			registerItemBlock(SMITHSONITE, event);
			registerItemBlock(HEMIMORPHITE, event);
			registerItemBlock(FRANKLINITE, event);
			registerItemBlock(ZINCITE, event);
			registerItemBlock(HYDROZINCITE, event);
			registerItemBlock(OTAVITE, event);
			registerItemBlock(GREENOCKITE, event);
			registerItemBlock(CINNABAR, event);
			registerItemBlock(NATIVE_COPPER, event);
			registerItemBlock(CHALCOPYRITE, event);
			registerItemBlock(CHALCOCITE, event);
			registerItemBlock(BORNITE, event);
			registerItemBlock(ENARGITE, event);
			registerItemBlock(TENNANTITE, event);
			registerItemBlock(TETRAHEDRITE, event);
			registerItemBlock(COVELLITE, event);
			registerItemBlock(AZURITE, event);
			registerItemBlock(MALACHITE, event);
			registerItemBlock(CUPRITE, event);
			registerItemBlock(NATIVE_SILVER, event);
			registerItemBlock(ACANTHITE, event);
			registerItemBlock(STEPHANITE, event);
			registerItemBlock(PROUSTITE, event);
			registerItemBlock(FREIBERGITE, event);
			registerItemBlock(NICKELINE, event);
			registerItemBlock(PENTLANDITE, event);
			registerItemBlock(NEPOUITE, event);
			registerItemBlock(MILLERITE, event);
			registerItemBlock(GERSDORFFITE, event);
			registerItemBlock(COBALTITE, event);
			registerItemBlock(CARROLLITE, event);
			registerItemBlock(SKUTTERUDITE, event);
			registerItemBlock(HEMATITE, event);
			registerItemBlock(MAGNETITE, event);
			registerItemBlock(LIMONITE, event);
			registerItemBlock(SIDERITE, event);
			registerItemBlock(TELLURIC_IRON, event);
			registerItemBlock(PYROLUSITE, event);
			registerItemBlock(RHODOCHROSITE, event);
			registerItemBlock(HOLLANDITE, event);
			registerItemBlock(MANGANITE, event);
			registerItemBlock(HAUSMANNITE, event);
			registerItemBlock(ALABANDITE, event);
			registerItemBlock(RHODONITE, event);
			registerItemBlock(CHROMITE, event);
			registerItemBlock(MOLYBDENITE, event);
			registerItemBlock(WULFENITE, event);
			registerItemBlock(SCHEELITE, event);
			registerItemBlock(FERBERITE, event);
			registerItemBlock(HUBNERITE, event);
			registerItemBlock(VANADINITE, event);
			registerItemBlock(DESCLOIZITE, event);
			registerItemBlock(COLUMBITE, event);
			registerItemBlock(TANTALITE, event);
			registerItemBlock(RUTILE, event);
			registerItemBlock(ILMENITE, event);
			registerItemBlock(ANATASE, event);
			registerItemBlock(BROOKITE, event);
			registerItemBlock(TITANITE, event);
			registerItemBlock(ZIRCON, event);
			registerItemBlock(THORITE, event);
			registerItemBlock(CARNOTITE, event);
			registerItemBlock(URANINITE, event);
			registerItemBlock(TORBERNITE, event);
			registerItemBlock(MAGNESITE, event);
			registerItemBlock(KIESERITE, event);
			registerItemBlock(BRUCITE, event);
			registerItemBlock(CALCITE, event);
			registerItemBlock(GYPSUM, event);
			registerItemBlock(ANHYDRITE, event);
			registerItemBlock(DOLOMITE, event);
			registerItemBlock(STRONTIANITE, event);
			registerItemBlock(CELESTINE, event);
			registerItemBlock(POLYLITHIONITE, event);
			registerItemBlock(PETALITE, event);
			registerItemBlock(CARNALLITE, event);
			registerItemBlock(SYLVITE, event);
			registerItemBlock(POLYHALITE, event);
			registerItemBlock(KAINITE, event);
			registerItemBlock(LANGBEINITE, event);
			registerItemBlock(NITRATINE, event);
			registerItemBlock(HALITE, event);
			registerItemBlock(SAPPHIRE_ORE, event);
			registerItemBlock(RUBY_ORE, event);
			registerItemBlock(SPINEL_ORE, event);
			registerItemBlock(AMETHYST_ORE, event);
			registerItemBlock(JADE_ORE, event);
			registerItemBlock(TOURMALINE_ORE, event);
			registerItemBlock(SUGILITE_ORE, event);
			registerItemBlock(PERIDOT_ORE, event);
			registerItemBlock(AGATE_ORE, event);
			registerItemBlock(CARNELIAN_ORE, event);
			registerItemBlock(CHRYSOPRASE_ORE, event);
			registerItemBlock(HELIOTROPE_ORE, event);
			registerItemBlock(TOPAZ_ORE, event);
			registerItemBlock(UNAKITE_ORE, event);
			registerItemBlock(TANZANITE_ORE, event);
			registerItemBlock(HAUYNE_ORE, event);
			registerItemBlock(ONYX_ORE, event);
			registerItemBlock(OPAL_ORE, event);
			registerItemBlock(MOONSTONE_ORE, event);
			registerItemBlock(TURQUOISE_ORE, event);
			registerItemBlock(AMAZONITE_ORE, event);
			registerItemBlock(CHRYSOCOLLA_ORE, event);
			registerItemBlock(ALMANDINE_ORE, event);
			registerItemBlock(SPESSARTINE_ORE, event);
			registerItemBlock(PYROPE_ORE, event);
			registerItemBlock(TSAVORITE_ORE, event);
			registerItemBlock(ANDRADITE_ORE, event);
			registerItemBlock(MITHRIL_ORE, event);
			registerItemBlock(PLATINUM_GROUP_METALS, event);
			registerItemBlock(RARE_PLATINUM_GROUP_METALS, event);
			registerItemBlock(PEAT, event);			
			registerItemBlock(NETHER_GOLD_ORE, event);
			registerItemBlock(NETHER_COAL_ORE, event);
			registerItemBlock(NETHER_MITHRIL_ORE, event);
			registerItemBlock(BASTNASITE_LA, event);
			registerItemBlock(MONAZITE_LA, event);
			registerItemBlock(BASTNASITE_CE, event);
			registerItemBlock(MONAZITE_CE, event);
			registerItemBlock(BASTNASITE_ND, event);
			registerItemBlock(MONAZITE_ND, event);
			registerItemBlock(BASTNASITE_Y, event);
			registerItemBlock(SAMARSKITE_Y, event);
			registerItemBlock(THORTVEITITE, event);			
			event.getRegistry().register(new AnthraciteBlockItemBlock(ANTHRACITE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("anthracite_block"));			
		}

		private static void registerItemBlock(CustomOre block, RegistryEvent.Register<Item> event) {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
		}

		private static void registerBlock(RegistryEvent.Register<Block> event, int harvestLevel, String name) {
			event.getRegistry().register(new CustomOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).harvestLevel(harvestLevel)).setRegistryName(name));			
		}

	}

}