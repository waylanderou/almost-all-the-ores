package waylanderou.almostalltheores.client;

import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

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
	public final String[] uranium = { "carnotite", "uraninite" };
	public final String[] magnesium = { "magnesite", "kieserite", "brucite" };
	public final String[] calcium = { "anhydrite" };
	public final String[] limestone = { "calcite" };
	public final String[] strontium = { "strontianite", "celestine" };
	public final String[] lithium = { "polylithionite", "petalite" };
	public final String[] potassium = { "carnallite", "sylvite", "polyhalite", "kainite", "langbeinite" };
	public final String[] saltpetre = { "nitratine" };
	public final String[] salt = { "halite" };
	public final String[] mithril = { "mithril_ore" };
	public final String[] npk = { "guano", "phosphorite", "carnallite", "sylvite", "polyhalite", "kainite", "langbeinite" };
	public final String[] coal = {"bituminous_coal", "anthracite", "peat_piece", "lignite"};

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
		tooltips.put(thorium, "tooltip.almostalltheores.thorium");
		tooltips.put(uranium, "tooltip.almostalltheores.uranium");
		tooltips.put(magnesium, "tooltip.almostalltheores.magnesium");
		tooltips.put(calcium, "tooltip.almostalltheores.calcium");
		tooltips.put(limestone, "tooltip.almostalltheores.limestone");
		tooltips.put(strontium, "tooltip.almostalltheores.strontium");
		tooltips.put(lithium,"tooltip.almostalltheores.lithium");
		tooltips.put(potassium, "tooltip.almostalltheores.potassium");
		tooltips.put(saltpetre, "tooltip.almostalltheores.saltpetre");
		tooltips.put(salt, "tooltip.almostalltheores.salt");
		tooltips.put(mithril, "tooltip.almostalltheores.mithril");
		tooltips.put(npk, "tooltip.almostalltheores.npk");
		tooltips.put(coal, "tooltip.almostalltheores.coal");
	}

	public void onToolTip(ItemTooltipEvent event) {
		Item item = event.getItemStack().getItem();
		List<ITextComponent> tooltip = event.getToolTip();
		if ("almostalltheores".equals(item.getCreatorModId(event.getItemStack()))) {
			addTooltips(item, tooltip);
		} 		
	}

	private void addTooltips(Item item, List<ITextComponent> tooltip) {
		String itemName = item.getRegistryName().toString().split(":")[1];

		for(String[] array : tooltips.keySet()) {
			for(String name: array) {
				if(name.equals(itemName)) {
					String translationKey = tooltips.get(array);
					tooltip.add(new TranslationTextComponent(translationKey).applyTextStyle(TextFormatting.BLUE));
				}
			}
		}	
	}	

}