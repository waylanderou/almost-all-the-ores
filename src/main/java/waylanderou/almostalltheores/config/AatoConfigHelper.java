package waylanderou.almostalltheores.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.level.block.Blocks;
import waylanderou.almostalltheores.block.Ores;

public class AatoConfigHelper {
	private List<IndividualOreConfigHolder> allBiomesOres = new ArrayList<IndividualOreConfigHolder>();
	private List<IndividualOreConfigHolder> mediumTempOres = new ArrayList<IndividualOreConfigHolder>();
	private List<IndividualOreConfigHolder> warmTempOres = new ArrayList<IndividualOreConfigHolder>();
	private List<IndividualOreConfigHolder> coldTempOres = new ArrayList<IndividualOreConfigHolder>();
	private List<IndividualOreConfigHolder> netherOres = new ArrayList<IndividualOreConfigHolder>();

	public AatoConfigHelper() {
		//NETHER
		netherOres.add(new IndividualOreConfigHolder("NetherCoal", "NONE", Ores.NETHER_COAL_ORE));
		netherOres.add(new IndividualOreConfigHolder("NetherMithril", "NONE", Ores.NETHER_MITHRIL_ORE));
		netherOres.add(new IndividualOreConfigHolder("NetherSulphur", "NONE", Ores.SULPHUR));
		netherOres.add(new IndividualOreConfigHolder("NetherQuartz", "NONE", Blocks.NETHER_QUARTZ_ORE));
		netherOres.add(new IndividualOreConfigHolder("NetherGold", "NONE", Blocks.NETHER_GOLD_ORE));
		//OVERWORLD -- ALL BIOMES
		//VANILLA
		//allBiomesOres.add(new IndividualOreConfigHolder("Gold", "Gold", Blocks.GOLD_ORE, "NO_GROUP"));
		allBiomesOres.add(new IndividualOreConfigHolder("CoalOre", "Coal", Blocks.COAL_ORE, "NO_GROUP"));
		allBiomesOres.add(new IndividualOreConfigHolder("IronOre", "Iron", Blocks.IRON_ORE, "NO_GROUP"));
		/*allBiomesOres.add(new IndividualOreConfigHolder("Diamond", "Diamond", Blocks.DIAMOND_ORE, "NO_GROUP"));
		allBiomesOres.add(new IndividualOreConfigHolder("Redstone", "RedstoneOre", Blocks.REDSTONE_ORE, "NO_GROUP"));
		allBiomesOres.add(new IndividualOreConfigHolder("Dirt", "NONE", Blocks.DIRT));
		allBiomesOres.add(new IndividualOreConfigHolder("Gravel", "NONE", Blocks.GRAVEL));
		allBiomesOres.add(new IndividualOreConfigHolder("Granite", "NONE", Blocks.GRANITE));
		allBiomesOres.add(new IndividualOreConfigHolder("Diorite", "NONE", Blocks.DIORITE));
		allBiomesOres.add(new IndividualOreConfigHolder("Andesite", "NONE", Blocks.ANDESITE));*/
		//AATO
		allBiomesOres.add(new IndividualOreConfigHolder("Nitratine", "Saltpetre", Ores.NITRATINE, new DownfallCriteria(0.25f, false)));		
		allBiomesOres.add(new IndividualOreConfigHolder("Peat", "Coal", Ores.PEAT, new DownfallCriteria(0.75f, true)));
		allBiomesOres.add(new IndividualOreConfigHolder("AdditionalPeat", "Coal", Ores.PEAT, new DownfallCriteria(0.85f, true)));
		allBiomesOres.add(new IndividualOreConfigHolder("PGMs", "PGMs", Ores.PLATINUM_GROUP_METALS));
		allBiomesOres.add(new IndividualOreConfigHolder("RarePGMs", "RarePGMs", Ores.RARE_PLATINUM_GROUP_METALS));
		allBiomesOres.add(new IndividualOreConfigHolder("Pyrite", "Sulphur"));
		allBiomesOres.add(new IndividualOreConfigHolder("Guano", "NPK"));
		allBiomesOres.add(new IndividualOreConfigHolder("Phosphorite", "NPK"));
		allBiomesOres.add(new IndividualOreConfigHolder("Lignite_ore", "Coal"));
		allBiomesOres.add(new IndividualOreConfigHolder("Bituminous_coal_ore", "Coal"));
		allBiomesOres.add(new IndividualOreConfigHolder("Anthracite_ore", "Coal"));
		allBiomesOres.add(new IndividualOreConfigHolder("Graphite", "Graphite"));
		allBiomesOres.add(new IndividualOreConfigHolder("Arsenopyrite", "Arsenic", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Stibnite", "Antimony", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Germanite", "Germanium", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Argutite", "Germanium", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Bismuthinite", "Bismuth", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Native_bismuth", "Bismuth", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Bismite", "Bismuth", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Cassiterite", "Tin"));
		allBiomesOres.add(new IndividualOreConfigHolder("Native_tin", "Tin"));
		allBiomesOres.add(new IndividualOreConfigHolder("Galena", "Lead"));
		allBiomesOres.add(new IndividualOreConfigHolder("Pyromorphite", "Lead"));
		allBiomesOres.add(new IndividualOreConfigHolder("Bauxite", "Aluminum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Nepheline", "Aluminum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Leucite", "Aluminum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Sphalerite", "Zinc"));
		allBiomesOres.add(new IndividualOreConfigHolder("Smithsonite", "Zinc"));
		allBiomesOres.add(new IndividualOreConfigHolder("Cinnabar", "Mercury"));
		allBiomesOres.add(new IndividualOreConfigHolder("Chalcopyrite", "Copper"));
		allBiomesOres.add(new IndividualOreConfigHolder("Chalcocite", "Copper"));
		allBiomesOres.add(new IndividualOreConfigHolder("Malachite", "Copper"));
		allBiomesOres.add(new IndividualOreConfigHolder("Native_silver", "Silver"));
		allBiomesOres.add(new IndividualOreConfigHolder("Proustite", "Silver"));
		allBiomesOres.add(new IndividualOreConfigHolder("Nickeline", "Nickel"));
		allBiomesOres.add(new IndividualOreConfigHolder("Nepouite", "Nickel"));
		allBiomesOres.add(new IndividualOreConfigHolder("Cobaltite", "Cobalt"));
		allBiomesOres.add(new IndividualOreConfigHolder("Hematite", "Iron"));
		allBiomesOres.add(new IndividualOreConfigHolder("Magnetite", "Iron"));
		allBiomesOres.add(new IndividualOreConfigHolder("Limonite", "Iron"));
		allBiomesOres.add(new IndividualOreConfigHolder("Siderite", "Iron"));
		allBiomesOres.add(new IndividualOreConfigHolder("Telluric_iron", "Iron"));
		allBiomesOres.add(new IndividualOreConfigHolder("Pyrolusite", "Manganese"));
		allBiomesOres.add(new IndividualOreConfigHolder("Chromite", "Chromium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Molybdenite", "Molybdenum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Wulfenite", "Molybdenum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Scheelite", "Tungsten"));
		allBiomesOres.add(new IndividualOreConfigHolder("Ferberite", "Tungsten"));
		allBiomesOres.add(new IndividualOreConfigHolder("Hubnerite", "Tungsten"));
		allBiomesOres.add(new IndividualOreConfigHolder("Vanadinite", "Vanadium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Descloizite", "Vanadium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Columbite", "Niobium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Tantalite", "Tantalum"));
		allBiomesOres.add(new IndividualOreConfigHolder("Rutile", "Titanium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Ilmenite", "Titanium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Zircon", "Zirconium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Thorite", "Thorium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Carnotite", "Uranium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Uraninite", "Uranium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Magnesite", "Magnesium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Kieserite", "Magnesium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Brucite", "Magnesium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Calcite", "Calcium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Gypsum", "Calcium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Anhydrite", "Calcium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Dolomite", "Calcium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Strontianite", "Strontium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Polylithionite", "Lithium"));
		allBiomesOres.add(new IndividualOreConfigHolder("Carnallite", "NPK"));
		allBiomesOres.add(new IndividualOreConfigHolder("Sylvite", "NPK"));
		allBiomesOres.add(new IndividualOreConfigHolder("Halite", "Salt"));
		allBiomesOres.add(new IndividualOreConfigHolder("Sapphire_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Ruby_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Amethyst_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Jade_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Peridot_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Agate_ore", "AllGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Carnelian_ore", "AllGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Heliotrope_ore", "AllGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Topaz_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Unakite_ore", "AllGems", "NO_BLACKLIST")); 
		allBiomesOres.add(new IndividualOreConfigHolder("Onyx_ore", "SomeGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Turquoise_ore", "AllGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Amazonite_ore", "AllGems", "NO_BLACKLIST"));
		allBiomesOres.add(new IndividualOreConfigHolder("Mithril", "Mithril", Ores.MITHRIL_ORE));

		//MEDIUM
		//mediumTempOres.add(new IndividualOreConfigHolder("Kimberlite", "AatODiamondOres", Ores.KIMBERLITE));
		mediumTempOres.add(new IndividualOreConfigHolder("Torbernite", "Uranium"));
		mediumTempOres.add(new IndividualOreConfigHolder("Bastnasite_ce", "REEs", "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Bastnasite_la", "REEs", "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Clausthalite", "Selenium", Ores.CLAUSTHALITE, "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Orpiment", "Arsenic", Ores.ORPIMENT, "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Stannite", "Tin"));
		mediumTempOres.add(new IndividualOreConfigHolder("Boulangerite", "Lead"));
		mediumTempOres.add(new IndividualOreConfigHolder("Hemimorphite", "Zinc"));
		mediumTempOres.add(new IndividualOreConfigHolder("Franklinite", "Zinc"));
		mediumTempOres.add(new IndividualOreConfigHolder("Greenockite", "Cadmium"));
		mediumTempOres.add(new IndividualOreConfigHolder("Native_copper", "Copper"));
		mediumTempOres.add(new IndividualOreConfigHolder("Bornite", "Copper"));
		mediumTempOres.add(new IndividualOreConfigHolder("Azurite", "Copper"));
		mediumTempOres.add(new IndividualOreConfigHolder("Freibergite", "Silver"));		
		mediumTempOres.add(new IndividualOreConfigHolder("Pentlandite", "Nickel"));
		mediumTempOres.add(new IndividualOreConfigHolder("Carrollite", "Cobalt"));
		mediumTempOres.add(new IndividualOreConfigHolder("Rhodochrosite", "Manganese"));
		mediumTempOres.add(new IndividualOreConfigHolder("Hollandite", "Manganese"));
		mediumTempOres.add(new IndividualOreConfigHolder("Brookite", "Titanium"));
		mediumTempOres.add(new IndividualOreConfigHolder("Celestine", "Strontium"));
		mediumTempOres.add(new IndividualOreConfigHolder("Polyhalite", "NPK"));
		mediumTempOres.add(new IndividualOreConfigHolder("Hauyne_ore", "AllGems", "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Moonstone_ore", "AllGems", "NO_BLACKLIST"));
		mediumTempOres.add(new IndividualOreConfigHolder("Almandine_ore", "AllGems", "NO_BLACKLIST"));

		//WARM
		//warmTempOres.add(new IndividualOreConfigHolder("Kimberlite", "AatODiamondOres", Ores.KIMBERLITE));
		warmTempOres.add(new IndividualOreConfigHolder("Bastnasite_y", "REEs", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Monazite_la", "REEs", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Monazite_ce", "REEs", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Sulphur", "Sulphur"));
		warmTempOres.add(new IndividualOreConfigHolder("Realgar", "Arsenic", Ores.REALGAR, "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Teallite", "Tin"));
		warmTempOres.add(new IndividualOreConfigHolder("Anglesite", "Lead"));
		warmTempOres.add(new IndividualOreConfigHolder("Zincite", "Zinc"));
		warmTempOres.add(new IndividualOreConfigHolder("Hydrozincite", "Zinc"));
		warmTempOres.add(new IndividualOreConfigHolder("Otavite", "Cadmium"));
		warmTempOres.add(new IndividualOreConfigHolder("Tennantite", "Copper"));
		warmTempOres.add(new IndividualOreConfigHolder("Tetrahedrite", "Copper"));
		warmTempOres.add(new IndividualOreConfigHolder("Stephanite", "Silver"));
		warmTempOres.add(new IndividualOreConfigHolder("Gersdorffite", "Nickel"));
		warmTempOres.add(new IndividualOreConfigHolder("Carrollite", "Cobalt"));
		warmTempOres.add(new IndividualOreConfigHolder("Manganite", "Manganese"));
		warmTempOres.add(new IndividualOreConfigHolder("Hausmannite", "Manganese"));
		warmTempOres.add(new IndividualOreConfigHolder("Titanite", "Titanium"));
		warmTempOres.add(new IndividualOreConfigHolder("Celestine", "Strontium"));
		warmTempOres.add(new IndividualOreConfigHolder("Petalite", "Lithium"));
		warmTempOres.add(new IndividualOreConfigHolder("Kainite", "NPK"));
		warmTempOres.add(new IndividualOreConfigHolder("Spinel_ore", "SomeGems", "NO_BLACKLIST"));		
		warmTempOres.add(new IndividualOreConfigHolder("Tourmaline_ore", "AllGems", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Tanzanite_ore", "SomeGems", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Opal_ore", "SomeGems", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Pyrope_ore", "AllGems", "NO_BLACKLIST"));
		warmTempOres.add(new IndividualOreConfigHolder("Andradite_ore", "AllGems", "NO_BLACKLIST"));

		//COLD
		//coldTempOres.add(new IndividualOreConfigHolder("Lamproite", "AatODiamondOres", Ores.LAMPROITE));
		coldTempOres.add(new IndividualOreConfigHolder("Samarskite_y", "REEs", "NO_BLACKLIST"));		
		coldTempOres.add(new IndividualOreConfigHolder("Thortveitite", "REEs", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Bastnasite_nd", "REEs", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Monazite_nd", "REEs", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Lollingite", "Arsenic", Ores.LOLLINGITE, "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Kesterite", "Tin"));
		coldTempOres.add(new IndividualOreConfigHolder("Cerussite", "Lead"));
		coldTempOres.add(new IndividualOreConfigHolder("Pyrite", "Sulphur"));
		coldTempOres.add(new IndividualOreConfigHolder("Clausthalite", "Selenium", Ores.CLAUSTHALITE, "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Hemimorphite", "Zinc"));
		coldTempOres.add(new IndividualOreConfigHolder("Franklinite", "Zinc"));
		coldTempOres.add(new IndividualOreConfigHolder("Greenockite", "Cadmium"));
		coldTempOres.add(new IndividualOreConfigHolder("Enargite", "Copper"));
		coldTempOres.add(new IndividualOreConfigHolder("Covellite", "Copper"));
		coldTempOres.add(new IndividualOreConfigHolder("Cuprite", "Copper"));
		coldTempOres.add(new IndividualOreConfigHolder("Acanthite", "Silver"));
		coldTempOres.add(new IndividualOreConfigHolder("Millerite", "Nickel"));
		coldTempOres.add(new IndividualOreConfigHolder("Skutterudite", "Cobalt"));	
		coldTempOres.add(new IndividualOreConfigHolder("Alabandite", "Manganese"));
		coldTempOres.add(new IndividualOreConfigHolder("Rhodonite", "Manganese"));	
		coldTempOres.add(new IndividualOreConfigHolder("Anatase", "Titanium"));
		coldTempOres.add(new IndividualOreConfigHolder("Langbeinite", "NPK"));
		coldTempOres.add(new IndividualOreConfigHolder("Sugilite_ore", "AllGems", "NO_BLACKLIST"));	
		coldTempOres.add(new IndividualOreConfigHolder("Chrysoprase_ore", "AllGems", "NO_BLACKLIST"));		
		coldTempOres.add(new IndividualOreConfigHolder("Hauyne_ore", "AllGems", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Opal_ore", "SomeGems", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Spessartine_ore", "AllGems", "NO_BLACKLIST"));
		coldTempOres.add(new IndividualOreConfigHolder("Tsavorite_ore", "AllGems", "NO_BLACKLIST"));
	}

	public List<IndividualOreConfigHolder> getAllBiomesOreConfig() {
		return allBiomesOres;
	}

	public List<IndividualOreConfigHolder> getMediumTempOreConfig() {
		return mediumTempOres;
	}

	public List<IndividualOreConfigHolder> getWarmTempOreConfig() {
		return warmTempOres;
	}

	public List<IndividualOreConfigHolder> getColdTempOreConfig() {
		return coldTempOres;
	}

	public List<IndividualOreConfigHolder> getNetherOres() {
		return netherOres;
	}

}
