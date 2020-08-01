package waylanderou.almostalltheores.integration;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import waylanderou.almostalltheores.AlmostAllTheOres;

@Mod.EventBusSubscriber(modid=AlmostAllTheOres.MODID)
public class ModPlugAndPlay {
	static final String[] copperMods = {"tconstruct", "easy_steel", "immersiveengineering", "mekanism", "occultism", "create"};
	static final String[] tinMods = {"tconstruct", "easy_steel", "mekanism"};
	static final String[] leadMods = {"tconstruct", "immersiveengineering"};
	static final String[] aluminumMods = {"tconstruct", "immersiveengineering"};
	static final String[] zincMods = {"tconstruct", "create"};
	static final String[] silverMods = {"tconstruct", "immersiveengineering", "occultism"};
	static final String[] nickelMods = {"immersiveengineering"};
	static final String[] tungstenMods = {"easy_steel"};
	static final String[] uraniumMods = {"immersiveengineering"};
	static final String[] titaniumMods = {"easy_steel"};
	static final String[] rubyMods = {"undermat", "extragems"};
	static final String[] amethystMods = {"undermat", "extragems"};
	static final String[] topazMods = {"undermat", "extragems"};
	static final String[] cobaltMods = {"undermat"};
	static final String[] calciumMods = {"undermat"};
	static final String[] sapphireMods = {"extragems"};
	static final String[] someGemsMods = {"toolsforaatogems", "silentgems"};
	static final String[] PGMsMods = {"mekanism"};

	public static void activateOres() {
		new IntegratedOre("Copper", copperMods);
		new IntegratedOre("Tin", tinMods);
		new IntegratedOre("Lead", leadMods);
		new IntegratedOre("Aluminum", aluminumMods);
		new IntegratedOre("Zinc", zincMods);
		new IntegratedOre("Silver", silverMods);
		new IntegratedOre("Nickel", nickelMods);
		new IntegratedOre("Tungsten", tungstenMods);
		new IntegratedOre("Uranium", uraniumMods);
		new IntegratedOre("Titanium", titaniumMods);
		new IntegratedOre("Ruby", rubyMods, true);
		new IntegratedOre("Amethyst", amethystMods, true);
		new IntegratedOre("Topaz", topazMods, true);
		new IntegratedOre("Cobalt", cobaltMods);
		new IntegratedOre("Calcium", calciumMods);
		new IntegratedOre("Sapphire", sapphireMods, true);
		new IntegratedOre("SomeGems", someGemsMods);
		new IntegratedOre("PGMs", PGMsMods);

		for(IntegratedOre ore : IntegratedOre.integratedOresList) {
			for(String modName : ore.mods)
				if(ModList.get().isLoaded(modName))
					ore.isNeeded = true;
		}
	}

}