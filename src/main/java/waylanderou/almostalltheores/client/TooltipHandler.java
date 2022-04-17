package waylanderou.almostalltheores.client;

import java.util.HashMap;
import java.util.List;

import net.minecraft.world.item.Item;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import waylanderou.almostalltheores.config.AatoConfig;

public class TooltipHandler {
	public final String[] iron = { "hematite", "magnetite", "limonite", "siderite", "telluric_iron" };
	public final String[] arsenic = { "lollingite", "realgar", "orpiment", "arsenopyrite" };
	public final String[] selenium = { "clausthalite" };
	public final String[] antimony = { "stibnite" };
	public final String[] germanium = { "germanite", "argutite" };
	public final String[] bismuth = { "bismuthinite", "native_bismuth", "bismite" };
	public final String[] tin = { "cassiterite", "teallite", "stannite", "native_tin", "kesterite" };
	public final String[] lead = { "galena", "cerussite", "anglesite", "boulangerite", "pyromorphite" };
	public final String[] aluminium = { "bauxite", "nepheline", "leucite" };
	public final String[] zinc = { "sphalerite", "smithsonite", "hemimorphite", "franklinite", "zincite", "hydrozincite" };
	public final String[] cadmium = { "otavite", "greenockite" };
	public final String[] mercury = { "cinnabar" };
	public final String[] copper = { "native_copper", "chalcopyrite", "chalcocite", "bornite", "enargite", "tennantite", "tetrahedrite", "covellite", "azurite", "malachite", "cuprite" };
	public final String[] silver = { "native_silver", "acanthite", "stephanite", "proustite", "freibergite" };
	public final String[] nickel = { "nickeline", "pentlandite", "nepouite", "millerite", "gersdorffite" };
	public final String[] cobalt = { "cobaltite", "carrollite", "skutterudite" };
	public final String[] manganese = { "pyrolusite", "rhodochrosite", "hollandite", "manganite", "hausmannite", "alabandite", "rhodonite" };
	public final String[] chromium = { "chromite" };
	public final String[] molybdenum = { "molybdenite", "wulfenite" };
	public final String[] tungsten = { "scheelite", "ferberite", "hubnerite" };
	public final String[] vanadium = { "vanadinite", "descloizite" };
	public final String[] niobium  = { "columbite" };
	public final String[] tantalum = { "tantalite" };
	public final String[] titanium = { "rutile", "ilmenite", "anatase", "brookite", "titanite" };
	public final String[] zirconium = { "zircon" };
	public final String[] thorium = { "thorite" };
	public final String[] uranium = { "carnotite", "uraninite", "torbernite" };
	public final String[] magnesium = { "magnesite", "kieserite", "brucite" };
	public final String[] calcium = { "anhydrite" };
	public final String[] limestone = { "calcite" };
	public final String[] strontium = { "strontianite", "celestine" };
	public final String[] lithium = { "polylithionite", "petalite" };
	public final String[] potassium = { "carnallite", "sylvite", "polyhalite", "kainite", "langbeinite" };
	public final String[] saltpetre = { "nitratine" };
	public final String[] salt = { "halite" };
	public final String[] sulphur = { "pyrite", "sulphur" };
	public final String[] mithril = { "mithril_ore" };
	public final String[] npk = { "guano", "phosphorite", "carnallite", "sylvite", "polyhalite", "kainite", "langbeinite" };
	public final String[] coal = {"bituminous_coal", "anthracite", "peat_piece", "lignite"};
	public final String[] scandium = {"scandium"};
	public final String[] yttrium = {"yttrium"};
	public final String[] yttrium_m = {"yttrium_m"};
	public final String[] yttrium_s = {"yttrium_s"};
	public final String[] lanthanum = {"lanthanum"};
	public final String[] lanthanum_m = {"lanthanum_m"};
	public final String[] lanthanum_s = {"lanthanum_s"};
	public final String[] cerium = {"cerium"};
	public final String[] cerium_m = {"cerium_m"};
	public final String[] cerium_s = {"cerium_s"};
	public final String[] praseodymium = {"praseodymium"};
	public final String[] praseodymium_m = {"praseodymium_m"};
	public final String[] praseodymium_s = {"praseodymium_s"};
	public final String[] neodymium = {"neodymium"};
	public final String[] neodymium_m = {"neodymium_m"};
	public final String[] neodymium_s = {"neodymium_s"};
	public final String[] samarium = {"samarium"};
	public final String[] samarium_m = {"samarium_m"};
	public final String[] samarium_s = {"samarium_s"};
	public final String[] europium = {"europium"};
	public final String[] europium_m = {"europium_m"};
	public final String[] europium_s = {"europium_s"};
	public final String[] gadolinium = {"gadolinium"};
	public final String[] gadolinium_m = {"gadolinium_m"};
	public final String[] gadolinium_s = {"gadolinium_s"};
	public final String[] terbium = {"terbium"};
	public final String[] terbium_m = {"terbium_m"};
	public final String[] terbium_s = {"terbium_s"};
	public final String[] dysprosium = {"dysprosium"};
	public final String[] dysprosium_m = {"dysprosium_m"};
	public final String[] dysprosium_s = {"dysprosium_s"};
	public final String[] holmium = {"holmium"};
	public final String[] holmium_m = {"holmium_m"};
	public final String[] holmium_s = {"holmium_s"};
	public final String[] erbium = {"erbium"};
	public final String[] erbium_m = {"erbium_m"};
	public final String[] erbium_s = {"erbium_s"};
	public final String[] thulium = {"thulium"};
	public final String[] thulium_m = {"thulium_m"};
	public final String[] thulium_s = {"thulium_s"};
	public final String[] ytterbium = {"ytterbium"};
	public final String[] ytterbium_m = {"ytterbium_m"};
	public final String[] ytterbium_s = {"ytterbium_s"};
	public final String[] lutetium = {"lutetium"};
	public final String[] lutetium_m = {"lutetium_m"};
	public final String[] lutetium_s = {"lutetium_s"};
	public final String[] thoriumm = {"thorium"};
	public final String[] thorium_m = {"thorium_m"};
	public final String[] thorium_s = {"thorium_s"};
	public final String[] rees = {"bastnasite_la", "monazite_la", "bastnasite_ce", "monazite_ce", "bastnasite_nd", "monazite_nd", "bastnasite_y", "samarskite_y", "thortveitite"};
	public final String[] bastnasite_la = { "bastnasite_la" };
	public final String[] monazite_la = { "monazite_la" };
	public final String[] bastnasite_ce = { "bastnasite_ce" };
	public final String[] monazite_ce = { "monazite_ce" };
	public final String[] bastnasite_nd = { "bastnasite_nd" };
	public final String[] monazite_nd = { "monazite_nd" };
	public final String[] bastnasite_y = { "bastnasite_y" };
	public final String[] samarskite_y = { "samarskite_y" };
	public final String[] thortveitite = { "thortveitite" };
	public final String[] diamond = {"kimberlite", "lamproite"};


	HashMap<String[], String> tooltips = new HashMap<String[], String>();

	public TooltipHandler() {
		tooltips.put(iron, "tooltip.almostalltheores.iron");
		tooltips.put(arsenic, "tooltip.almostalltheores.arsenic");
		tooltips.put(selenium, "tooltip.almostalltheores.selenium");
		tooltips.put(antimony, "tooltip.almostalltheores.antimony");
		tooltips.put(germanium, "tooltip.almostalltheores.germanium");
		tooltips.put(bismuth, "tooltip.almostalltheores.bismuth");
		tooltips.put(tin, "tooltip.almostalltheores.tin");
		tooltips.put(lead, "tooltip.almostalltheores.lead");
		tooltips.put(aluminium, "tooltip.almostalltheores.aluminium");
		tooltips.put(zinc, "tooltip.almostalltheores.zinc");
		tooltips.put(cadmium, "tooltip.almostalltheores.cadmium");
		tooltips.put(mercury, "tooltip.almostalltheores.mercury");
		tooltips.put(copper, "tooltip.almostalltheores.copper");
		tooltips.put(silver, "tooltip.almostalltheores.silver");
		tooltips.put(nickel, "tooltip.almostalltheores.nickel");
		tooltips.put(cobalt, "tooltip.almostalltheores.cobalt");
		tooltips.put(manganese, "tooltip.almostalltheores.manganese");
		tooltips.put(chromium, "tooltip.almostalltheores.chromium");
		tooltips.put(molybdenum, "tooltip.almostalltheores.molybdenum");
		tooltips.put(tungsten, "tooltip.almostalltheores.tungsten");
		tooltips.put(vanadium, "tooltip.almostalltheores.vanadium");
		tooltips.put(niobium, "tooltip.almostalltheores.niobium");
		tooltips.put(tantalum, "tooltip.almostalltheores.tantalum");
		tooltips.put(titanium, "tooltip.almostalltheores.titanium");
		tooltips.put(zirconium, "tooltip.almostalltheores.zirconium");
		tooltips.put(thorium, "tooltip.almostalltheores.thorite");
		tooltips.put(uranium, "tooltip.almostalltheores.uranium");
		tooltips.put(magnesium, "tooltip.almostalltheores.magnesium");
		tooltips.put(calcium, "tooltip.almostalltheores.calcium");
		tooltips.put(limestone, "tooltip.almostalltheores.limestone");
		tooltips.put(strontium, "tooltip.almostalltheores.strontium");
		tooltips.put(lithium,"tooltip.almostalltheores.lithium");
		tooltips.put(potassium, "tooltip.almostalltheores.potassium");
		tooltips.put(saltpetre, "tooltip.almostalltheores.saltpetre");
		tooltips.put(salt, "tooltip.almostalltheores.salt");
		tooltips.put(sulphur, "tooltip.almostalltheores.sulphur");
		tooltips.put(mithril, "tooltip.almostalltheores.mithril");
		tooltips.put(npk, "tooltip.almostalltheores.npk");
		tooltips.put(coal, "tooltip.almostalltheores.coal");		
		tooltips.put(scandium, "tooltip.almostalltheores.scandium");
		tooltips.put(yttrium, "tooltip.almostalltheores.yttrium");
		tooltips.put(yttrium_m, "tooltip.almostalltheores.yttrium_m");
		tooltips.put(yttrium_s, "tooltip.almostalltheores.yttrium_s");
		tooltips.put(lanthanum, "tooltip.almostalltheores.lanthanum");
		tooltips.put(lanthanum_m, "tooltip.almostalltheores.lanthanum_m");
		tooltips.put(lanthanum_s, "tooltip.almostalltheores.lanthanum_s");
		tooltips.put(cerium, "tooltip.almostalltheores.cerium");
		tooltips.put(cerium_m, "tooltip.almostalltheores.cerium_m");
		tooltips.put(cerium_s, "tooltip.almostalltheores.cerium_s");
		tooltips.put(praseodymium, "tooltip.almostalltheores.praseodymium");
		tooltips.put(praseodymium_m, "tooltip.almostalltheores.praseodymium_m");
		tooltips.put(praseodymium_s, "tooltip.almostalltheores.praseodymium_s");
		tooltips.put(neodymium, "tooltip.almostalltheores.neodymium");
		tooltips.put(neodymium_m, "tooltip.almostalltheores.neodymium_m");
		tooltips.put(neodymium_s, "tooltip.almostalltheores.neodymium_s");
		tooltips.put(samarium, "tooltip.almostalltheores.samarium");
		tooltips.put(samarium_m, "tooltip.almostalltheores.samarium_m");
		tooltips.put(samarium_s, "tooltip.almostalltheores.samarium_s");
		tooltips.put(europium, "tooltip.almostalltheores.europium");
		tooltips.put(europium_m, "tooltip.almostalltheores.europium_m");
		tooltips.put(europium_s, "tooltip.almostalltheores.europium_s");
		tooltips.put(gadolinium, "tooltip.almostalltheores.gadolinium");
		tooltips.put(gadolinium_m, "tooltip.almostalltheores.gadolinium_m");
		tooltips.put(gadolinium_s, "tooltip.almostalltheores.gadolinium_s");
		tooltips.put(terbium, "tooltip.almostalltheores.terbium");
		tooltips.put(terbium_m, "tooltip.almostalltheores.terbium_m");
		tooltips.put(terbium_s, "tooltip.almostalltheores.terbium_s");
		tooltips.put(dysprosium, "tooltip.almostalltheores.dysprosium");
		tooltips.put(dysprosium_m, "tooltip.almostalltheores.dysprosium_m");
		tooltips.put(dysprosium_s, "tooltip.almostalltheores.dysprosium_s");
		tooltips.put(holmium, "tooltip.almostalltheores.holmium");
		tooltips.put(holmium_m, "tooltip.almostalltheores.holmium_m");
		tooltips.put(holmium_s, "tooltip.almostalltheores.holmium_s");
		tooltips.put(erbium, "tooltip.almostalltheores.erbium");
		tooltips.put(erbium_m, "tooltip.almostalltheores.erbium_m");
		tooltips.put(erbium_s, "tooltip.almostalltheores.erbium_s");
		tooltips.put(thulium, "tooltip.almostalltheores.thulium");
		tooltips.put(thulium_m, "tooltip.almostalltheores.thulium_m");
		tooltips.put(thulium_s, "tooltip.almostalltheores.thulium_s");
		tooltips.put(ytterbium, "tooltip.almostalltheores.ytterbium");
		tooltips.put(ytterbium_m, "tooltip.almostalltheores.ytterbium_m");
		tooltips.put(ytterbium_s, "tooltip.almostalltheores.ytterbium_s");
		tooltips.put(lutetium, "tooltip.almostalltheores.lutetium");
		tooltips.put(lutetium_m, "tooltip.almostalltheores.lutetium_m");
		tooltips.put(lutetium_s, "tooltip.almostalltheores.lutetium_s");
		tooltips.put(thoriumm, "tooltip.almostalltheores.thorium");
		tooltips.put(thorium_m, "tooltip.almostalltheores.thorium_m");
		tooltips.put(thorium_s, "tooltip.almostalltheores.thorium_s");
		tooltips.put(rees, "tooltip.almostalltheores.rees");
		tooltips.put(bastnasite_la, "tooltip.almostalltheores.bastnasite_la");
		tooltips.put(monazite_la, "tooltip.almostalltheores.monazite_la");
		tooltips.put(bastnasite_ce, "tooltip.almostalltheores.bastnasite_ce");
		tooltips.put(monazite_ce, "tooltip.almostalltheores.monazite_ce");
		tooltips.put(bastnasite_nd, "tooltip.almostalltheores.bastnasite_nd");
		tooltips.put(monazite_nd, "tooltip.almostalltheores.monazite_nd");
		tooltips.put(bastnasite_y, "tooltip.almostalltheores.bastnasite_y");
		tooltips.put(samarskite_y, "tooltip.almostalltheores.samarskite_y");
		tooltips.put(thortveitite, "tooltip.almostalltheores.thortveitite");
		tooltips.put(diamond, "tooltip.almostalltheores.diamond");
	}

	public void onToolTip(ItemTooltipEvent event) {
		Item item = event.getItemStack().getItem();
		List<Component> tooltip = event.getToolTip();
		if ("almostalltheores".equals(item.getCreatorModId(event.getItemStack()))) {
			String itemName = item.getRegistryName().toString().split(":")[1];
			addTooltips(itemName, tooltip);
		} 		
	}

	public void addTooltips(String name, List<Component> tooltip) {
		if(AatoConfig.mineralogistOption.get())
			return;
		tooltips.forEach((keys, tsKey) -> {			
			for(String key : keys) {
				if(key.equals(name))
					tooltip.add(new TranslatableComponent(tsKey).withStyle(ChatFormatting.GRAY));
			}
		});
	}	

}
