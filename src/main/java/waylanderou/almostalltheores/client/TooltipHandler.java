package waylanderou.almostalltheores.client;

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

	public TooltipHandler() {		
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
		for(String name: iron) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.iron").applyTextStyle(TextFormatting.BLUE));		
			}
		}		
		for(String name: arsenic) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.arsenic").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: selenium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.selenium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: antimony) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.antimony").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: germanium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.germanium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: bismuth) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.bismuth").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: tin) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.tin").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: lead) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.lead").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: aluminium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.aluminium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: zinc) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.zinc").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: cadmium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.cadmium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: mercury) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.mercury").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: copper) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.copper").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: silver) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.silver").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: nickel) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.nickel").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: cobalt) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.cobalt").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: manganese) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.manganese").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: chromium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.chromium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: molybdenum) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.molybdenum").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: tungsten) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.tungsten").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: vanadium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.vanadium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: niobium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.niobium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: tantalum) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.tantalum").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: titanium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.titanium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: zirconium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.zirconium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: thorium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.thorium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: uranium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.uranium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: magnesium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.magnesium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: calcium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.calcium").applyTextStyle(TextFormatting.BLUE));		
			}			
		}
		for(String name: strontium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.strontium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: lithium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.lithium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: potassium) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.potassium").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: saltpetre) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.saltpetre").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: salt) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.salt").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: mithril) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.mithril").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: npk) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.npk").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: coal) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.coal").applyTextStyle(TextFormatting.BLUE));		
			}
		}
		for(String name: limestone) {
			if(name.equals(itemName)) {
				tooltip.add(new TranslationTextComponent("tooltip.almostalltheores.limestone").applyTextStyle(TextFormatting.BLUE));
			}
		}
	}	

}
