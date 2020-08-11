package waylanderou.almostalltheores.integration;

import java.util.ArrayList;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import waylanderou.almostalltheores.AlmostAllTheOres;

@Mod.EventBusSubscriber(modid=AlmostAllTheOres.MODID)
public class ModPlugAndPlay {
	final String[] copperMods = {"tconstruct", "easy_steel", "immersiveengineering", "mekanism", "occultism", "create"};
	final String[] tinMods = {"tconstruct", "easy_steel", "mekanism"};
	final String[] leadMods = {"tconstruct", "immersiveengineering"};
	final String[] aluminumMods = {"tconstruct", "immersiveengineering"};
	final String[] zincMods = {"tconstruct", "create"};
	final String[] silverMods = {"tconstruct", "immersiveengineering", "occultism"};
	final String[] nickelMods = {"immersiveengineering"};
	final String[] tungstenMods = {"easy_steel"};
	final String[] uraniumMods = {"immersiveengineering"};
	final String[] titaniumMods = {"easy_steel"};
	final String[] rubyMods = {"undermat", "extragems"};
	final String[] amethystMods = {"undermat", "extragems"};
	final String[] topazMods = {"undermat", "extragems"};
	final String[] cobaltMods = {"undermat"};
	final String[] calciumMods = {"undermat"};
	final String[] sapphireMods = {"extragems"};
	final String[] someGemsMods = {"toolsforaatogems", "silentgems"};
	final String[] PGMsMods = {"mekanism"};
	private ArrayList<IntegratedOre> integratedOresList = new ArrayList<IntegratedOre>();

	public ArrayList<IntegratedOre> getIntegratedOresList() {
		return integratedOresList;
	}

	public void activateOres() {
		integratedOresList.add(new IntegratedOre("Copper", copperMods));
		integratedOresList.add(new IntegratedOre("Tin", tinMods));
		integratedOresList.add(new IntegratedOre("Lead", leadMods));
		integratedOresList.add(new IntegratedOre("Aluminum", aluminumMods));
		integratedOresList.add(new IntegratedOre("Zinc", zincMods));
		integratedOresList.add(new IntegratedOre("Silver", silverMods));
		integratedOresList.add(new IntegratedOre("Nickel", nickelMods));
		integratedOresList.add(new IntegratedOre("Tungsten", tungstenMods));
		integratedOresList.add(new IntegratedOre("Uranium", uraniumMods));
		integratedOresList.add(new IntegratedOre("Titanium", titaniumMods));
		integratedOresList.add(new IntegratedOre("Ruby", rubyMods, true));
		integratedOresList.add(new IntegratedOre("Amethyst", amethystMods, true));
		integratedOresList.add(new IntegratedOre("Topaz", topazMods, true));
		integratedOresList.add(new IntegratedOre("Cobalt", cobaltMods));
		integratedOresList.add(new IntegratedOre("Calcium", calciumMods));
		integratedOresList.add(new IntegratedOre("Sapphire", sapphireMods, true));
		integratedOresList.add(new IntegratedOre("SomeGems", someGemsMods));
		integratedOresList.add(new IntegratedOre("PGMs", PGMsMods));

		for(IntegratedOre ore : integratedOresList) {
			for(String modName : ore.mods)
				if(ModList.get().isLoaded(modName))
					ore.isNeeded = true;
		}
	}

}
