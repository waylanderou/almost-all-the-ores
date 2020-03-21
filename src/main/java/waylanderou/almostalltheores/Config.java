package waylanderou.almostalltheores;

import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

public class Config {

	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();	
	public static ForgeConfigSpec spec;
	private static boolean enableTinkersDefault = false;
	private static boolean enableToolsforaatogemsMaterials = false;
	private static boolean enableExtraGemsMaterials = false;
	private static boolean enableEasySteelMaterials = false;
	private static boolean enableUndergroundMaterialsMaterials = false;
	private static boolean enableSilentsGemsMaterials = false;
	public static ForgeConfigSpec.BooleanValue enableStoneAge;
	public static ForgeConfigSpec.BooleanValue enablePlugAndPlay;
	public static ForgeConfigSpec.BooleanValue clearNether;
	
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistGoldOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistRedstoneOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistDiamondOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistLapisOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistCopperOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistIronOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistAnthraciteOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistBituminousCoalOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistLigniteOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistPeatOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistTinOres;	
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistSulfurOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistNPKOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistLeadOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistAluminiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistZincOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistCadmiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistMercuryOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistSilverOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistNickelOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistCommonPGMsOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistRarePGMsOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistManganeseOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistChromiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistMolybdenumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistTungstenOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistVanadiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistNiobiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistTantalumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistTitaniumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistZirconiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistThoriumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistUraniumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistMagnesiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistCalciumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistStrontiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistLithiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistPotassiumOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistSaltOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistSaltpetreOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistMithrilOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistCobaltOres;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistGraphiteOre;
	public static ForgeConfigSpec.ConfigValue<List<String>> blacklistChrysocollaOre;

	public static ForgeConfigSpec.BooleanValue enableVanillaCoalOre;
	public static ForgeConfigSpec.BooleanValue enableVanillaIronOre;
	public static ForgeConfigSpec.BooleanValue handleEverythingInOverworld;
	public static ForgeConfigSpec.BooleanValue disableAatoGeneration;

	public static ForgeConfigSpec.BooleanValue enableBastnasite_la;
	public static ForgeConfigSpec.IntValue VeinSizeBastnasite_la;
	public static ForgeConfigSpec.IntValue VeinsPerChunkBastnasite_la;
	public static ForgeConfigSpec.IntValue MinHeightBastnasite_la;
	public static ForgeConfigSpec.IntValue MaxHeightBastnasite_la;

	public static ForgeConfigSpec.BooleanValue enableMonazite_la;
	public static ForgeConfigSpec.IntValue VeinSizeMonazite_la;
	public static ForgeConfigSpec.IntValue VeinsPerChunkMonazite_la;
	public static ForgeConfigSpec.IntValue MinHeightMonazite_la;
	public static ForgeConfigSpec.IntValue MaxHeightMonazite_la;

	public static ForgeConfigSpec.BooleanValue enableBastnasite_ce;
	public static ForgeConfigSpec.IntValue VeinSizeBastnasite_ce;
	public static ForgeConfigSpec.IntValue VeinsPerChunkBastnasite_ce;
	public static ForgeConfigSpec.IntValue MinHeightBastnasite_ce;
	public static ForgeConfigSpec.IntValue MaxHeightBastnasite_ce;

	public static ForgeConfigSpec.BooleanValue enableMonazite_ce;
	public static ForgeConfigSpec.IntValue VeinSizeMonazite_ce;
	public static ForgeConfigSpec.IntValue VeinsPerChunkMonazite_ce;
	public static ForgeConfigSpec.IntValue MinHeightMonazite_ce;
	public static ForgeConfigSpec.IntValue MaxHeightMonazite_ce;

	public static ForgeConfigSpec.BooleanValue enableBastnasite_nd;
	public static ForgeConfigSpec.IntValue VeinSizeBastnasite_nd;
	public static ForgeConfigSpec.IntValue VeinsPerChunkBastnasite_nd;
	public static ForgeConfigSpec.IntValue MinHeightBastnasite_nd;
	public static ForgeConfigSpec.IntValue MaxHeightBastnasite_nd;

	public static ForgeConfigSpec.BooleanValue enableMonazite_nd;
	public static ForgeConfigSpec.IntValue VeinSizeMonazite_nd;
	public static ForgeConfigSpec.IntValue VeinsPerChunkMonazite_nd;
	public static ForgeConfigSpec.IntValue MinHeightMonazite_nd;
	public static ForgeConfigSpec.IntValue MaxHeightMonazite_nd;

	public static ForgeConfigSpec.BooleanValue enableBastnasite_y;
	public static ForgeConfigSpec.IntValue VeinSizeBastnasite_y;
	public static ForgeConfigSpec.IntValue VeinsPerChunkBastnasite_y;
	public static ForgeConfigSpec.IntValue MinHeightBastnasite_y;
	public static ForgeConfigSpec.IntValue MaxHeightBastnasite_y;

	public static ForgeConfigSpec.BooleanValue enableSamarskite_y;
	public static ForgeConfigSpec.IntValue VeinSizeSamarskite_y;
	public static ForgeConfigSpec.IntValue VeinsPerChunkSamarskite_y;
	public static ForgeConfigSpec.IntValue MinHeightSamarskite_y;
	public static ForgeConfigSpec.IntValue MaxHeightSamarskite_y;

	public static ForgeConfigSpec.BooleanValue enableThortveitite;
	public static ForgeConfigSpec.IntValue VeinSizeThortveitite;
	public static ForgeConfigSpec.IntValue VeinsPerChunkThortveitite;
	public static ForgeConfigSpec.IntValue MinHeightThortveitite;
	public static ForgeConfigSpec.IntValue MaxHeightThortveitite;

	public static ForgeConfigSpec.BooleanValue enablePyrite; 
	public static ForgeConfigSpec.IntValue VeinSizePyrite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPyrite; 
	public static ForgeConfigSpec.IntValue MinHeightPyrite; 
	public static ForgeConfigSpec.IntValue MaxHeightPyrite; 

	public static ForgeConfigSpec.BooleanValue enableSulphur; 
	public static ForgeConfigSpec.IntValue VeinSizeSulphur; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSulphur; 
	public static ForgeConfigSpec.IntValue MinHeightSulphur; 
	public static ForgeConfigSpec.IntValue MaxHeightSulphur; 

	public static ForgeConfigSpec.BooleanValue enableClausthalite; 
	public static ForgeConfigSpec.IntValue VeinSizeClausthalite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkClausthalite; 
	public static ForgeConfigSpec.IntValue MinHeightClausthalite; 
	public static ForgeConfigSpec.IntValue MaxHeightClausthalite; 

	public static ForgeConfigSpec.BooleanValue enableGuano; 
	public static ForgeConfigSpec.IntValue VeinSizeGuano; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGuano; 
	public static ForgeConfigSpec.IntValue MinHeightGuano; 
	public static ForgeConfigSpec.IntValue MaxHeightGuano; 

	public static ForgeConfigSpec.BooleanValue enablePhosphorite; 
	public static ForgeConfigSpec.IntValue VeinSizePhosphorite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPhosphorite; 
	public static ForgeConfigSpec.IntValue MinHeightPhosphorite; 
	public static ForgeConfigSpec.IntValue MaxHeightPhosphorite; 

	public static ForgeConfigSpec.BooleanValue enablePeat; 
	public static ForgeConfigSpec.IntValue VeinSizePeat; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPeat; 
	public static ForgeConfigSpec.IntValue MinHeightPeat; 
	public static ForgeConfigSpec.IntValue MaxHeightPeat; 

	public static ForgeConfigSpec.BooleanValue enableLignite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeLignite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLignite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightLignite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightLignite_ore;

	public static ForgeConfigSpec.BooleanValue enableBituminous_coal_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeBituminous_coal_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBituminous_coal_ore; 
	public static ForgeConfigSpec.IntValue MinHeightBituminous_coal_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightBituminous_coal_ore; 

	public static ForgeConfigSpec.BooleanValue enableAnthracite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAnthracite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAnthracite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAnthracite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAnthracite_ore; 

	public static ForgeConfigSpec.BooleanValue enableGraphite; 
	public static ForgeConfigSpec.IntValue VeinSizeGraphite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGraphite; 
	public static ForgeConfigSpec.IntValue MinHeightGraphite; 
	public static ForgeConfigSpec.IntValue MaxHeightGraphite; 

	public static ForgeConfigSpec.BooleanValue enableLollingite; 
	public static ForgeConfigSpec.IntValue VeinSizeLollingite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLollingite; 
	public static ForgeConfigSpec.IntValue MinHeightLollingite; 
	public static ForgeConfigSpec.IntValue MaxHeightLollingite; 

	public static ForgeConfigSpec.BooleanValue enableRealgar; 
	public static ForgeConfigSpec.IntValue VeinSizeRealgar; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRealgar; 
	public static ForgeConfigSpec.IntValue MinHeightRealgar; 
	public static ForgeConfigSpec.IntValue MaxHeightRealgar; 

	public static ForgeConfigSpec.BooleanValue enableOrpiment; 
	public static ForgeConfigSpec.IntValue VeinSizeOrpiment; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkOrpiment; 
	public static ForgeConfigSpec.IntValue MinHeightOrpiment; 
	public static ForgeConfigSpec.IntValue MaxHeightOrpiment; 

	public static ForgeConfigSpec.BooleanValue enableArsenopyrite; 
	public static ForgeConfigSpec.IntValue VeinSizeArsenopyrite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkArsenopyrite; 
	public static ForgeConfigSpec.IntValue MinHeightArsenopyrite; 
	public static ForgeConfigSpec.IntValue MaxHeightArsenopyrite; 

	public static ForgeConfigSpec.BooleanValue enableStibnite; 
	public static ForgeConfigSpec.IntValue VeinSizeStibnite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkStibnite; 
	public static ForgeConfigSpec.IntValue MinHeightStibnite; 
	public static ForgeConfigSpec.IntValue MaxHeightStibnite; 

	public static ForgeConfigSpec.BooleanValue enableGermanite; 
	public static ForgeConfigSpec.IntValue VeinSizeGermanite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGermanite; 
	public static ForgeConfigSpec.IntValue MinHeightGermanite; 
	public static ForgeConfigSpec.IntValue MaxHeightGermanite; 

	public static ForgeConfigSpec.BooleanValue enableArgutite; 
	public static ForgeConfigSpec.IntValue VeinSizeArgutite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkArgutite; 
	public static ForgeConfigSpec.IntValue MinHeightArgutite; 
	public static ForgeConfigSpec.IntValue MaxHeightArgutite; 

	public static ForgeConfigSpec.BooleanValue enableBismuthinite; 
	public static ForgeConfigSpec.IntValue VeinSizeBismuthinite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBismuthinite; 
	public static ForgeConfigSpec.IntValue MinHeightBismuthinite; 
	public static ForgeConfigSpec.IntValue MaxHeightBismuthinite; 

	public static ForgeConfigSpec.BooleanValue enableNative_bismuth; 
	public static ForgeConfigSpec.IntValue VeinSizeNative_bismuth; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNative_bismuth; 
	public static ForgeConfigSpec.IntValue MinHeightNative_bismuth; 
	public static ForgeConfigSpec.IntValue MaxHeightNative_bismuth; 

	public static ForgeConfigSpec.BooleanValue enableBismite; 
	public static ForgeConfigSpec.IntValue VeinSizeBismite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBismite; 
	public static ForgeConfigSpec.IntValue MinHeightBismite; 
	public static ForgeConfigSpec.IntValue MaxHeightBismite; 

	public static ForgeConfigSpec.BooleanValue enableCassiterite; 
	public static ForgeConfigSpec.IntValue VeinSizeCassiterite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCassiterite; 
	public static ForgeConfigSpec.IntValue MinHeightCassiterite; 
	public static ForgeConfigSpec.IntValue MaxHeightCassiterite; 

	public static ForgeConfigSpec.BooleanValue enableTeallite; 
	public static ForgeConfigSpec.IntValue VeinSizeTeallite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTeallite; 
	public static ForgeConfigSpec.IntValue MinHeightTeallite; 
	public static ForgeConfigSpec.IntValue MaxHeightTeallite; 

	public static ForgeConfigSpec.BooleanValue enableStannite; 
	public static ForgeConfigSpec.IntValue VeinSizeStannite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkStannite; 
	public static ForgeConfigSpec.IntValue MinHeightStannite; 
	public static ForgeConfigSpec.IntValue MaxHeightStannite; 

	public static ForgeConfigSpec.BooleanValue enableNative_tin; 
	public static ForgeConfigSpec.IntValue VeinSizeNative_tin; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNative_tin; 
	public static ForgeConfigSpec.IntValue MinHeightNative_tin; 
	public static ForgeConfigSpec.IntValue MaxHeightNative_tin; 

	public static ForgeConfigSpec.BooleanValue enableKesterite; 
	public static ForgeConfigSpec.IntValue VeinSizeKesterite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkKesterite; 
	public static ForgeConfigSpec.IntValue MinHeightKesterite; 
	public static ForgeConfigSpec.IntValue MaxHeightKesterite; 

	public static ForgeConfigSpec.BooleanValue enableGalena; 
	public static ForgeConfigSpec.IntValue VeinSizeGalena; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGalena; 
	public static ForgeConfigSpec.IntValue MinHeightGalena; 
	public static ForgeConfigSpec.IntValue MaxHeightGalena; 

	public static ForgeConfigSpec.BooleanValue enableCerussite; 
	public static ForgeConfigSpec.IntValue VeinSizeCerussite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCerussite; 
	public static ForgeConfigSpec.IntValue MinHeightCerussite; 
	public static ForgeConfigSpec.IntValue MaxHeightCerussite; 

	public static ForgeConfigSpec.BooleanValue enableAnglesite; 
	public static ForgeConfigSpec.IntValue VeinSizeAnglesite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAnglesite; 
	public static ForgeConfigSpec.IntValue MinHeightAnglesite; 
	public static ForgeConfigSpec.IntValue MaxHeightAnglesite; 

	public static ForgeConfigSpec.BooleanValue enableBoulangerite; 
	public static ForgeConfigSpec.IntValue VeinSizeBoulangerite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBoulangerite; 
	public static ForgeConfigSpec.IntValue MinHeightBoulangerite; 
	public static ForgeConfigSpec.IntValue MaxHeightBoulangerite; 

	public static ForgeConfigSpec.BooleanValue enablePyromorphite; 
	public static ForgeConfigSpec.IntValue VeinSizePyromorphite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPyromorphite; 
	public static ForgeConfigSpec.IntValue MinHeightPyromorphite; 
	public static ForgeConfigSpec.IntValue MaxHeightPyromorphite;

	public static ForgeConfigSpec.BooleanValue enableBauxite; 
	public static ForgeConfigSpec.IntValue VeinSizeBauxite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBauxite; 
	public static ForgeConfigSpec.IntValue MinHeightBauxite; 
	public static ForgeConfigSpec.IntValue MaxHeightBauxite; 

	public static ForgeConfigSpec.BooleanValue enableNepheline; 
	public static ForgeConfigSpec.IntValue VeinSizeNepheline; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNepheline; 
	public static ForgeConfigSpec.IntValue MinHeightNepheline; 
	public static ForgeConfigSpec.IntValue MaxHeightNepheline; 

	public static ForgeConfigSpec.BooleanValue enableLeucite; 
	public static ForgeConfigSpec.IntValue VeinSizeLeucite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLeucite; 
	public static ForgeConfigSpec.IntValue MinHeightLeucite; 
	public static ForgeConfigSpec.IntValue MaxHeightLeucite; 

	public static ForgeConfigSpec.BooleanValue enableSphalerite; 
	public static ForgeConfigSpec.IntValue VeinSizeSphalerite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSphalerite; 
	public static ForgeConfigSpec.IntValue MinHeightSphalerite; 
	public static ForgeConfigSpec.IntValue MaxHeightSphalerite; 

	public static ForgeConfigSpec.BooleanValue enableSmithsonite; 
	public static ForgeConfigSpec.IntValue VeinSizeSmithsonite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSmithsonite; 
	public static ForgeConfigSpec.IntValue MinHeightSmithsonite; 
	public static ForgeConfigSpec.IntValue MaxHeightSmithsonite;

	public static ForgeConfigSpec.BooleanValue enableHemimorphite; 
	public static ForgeConfigSpec.IntValue VeinSizeHemimorphite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHemimorphite; 
	public static ForgeConfigSpec.IntValue MinHeightHemimorphite; 
	public static ForgeConfigSpec.IntValue MaxHeightHemimorphite; 

	public static ForgeConfigSpec.BooleanValue enableFranklinite; 
	public static ForgeConfigSpec.IntValue VeinSizeFranklinite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkFranklinite; 
	public static ForgeConfigSpec.IntValue MinHeightFranklinite; 
	public static ForgeConfigSpec.IntValue MaxHeightFranklinite; 

	public static ForgeConfigSpec.BooleanValue enableZincite; 
	public static ForgeConfigSpec.IntValue VeinSizeZincite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkZincite; 
	public static ForgeConfigSpec.IntValue MinHeightZincite; 
	public static ForgeConfigSpec.IntValue MaxHeightZincite; 

	public static ForgeConfigSpec.BooleanValue enableHydrozincite; 
	public static ForgeConfigSpec.IntValue VeinSizeHydrozincite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHydrozincite; 
	public static ForgeConfigSpec.IntValue MinHeightHydrozincite; 
	public static ForgeConfigSpec.IntValue MaxHeightHydrozincite; 

	public static ForgeConfigSpec.BooleanValue enableOtavite; 
	public static ForgeConfigSpec.IntValue VeinSizeOtavite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkOtavite; 
	public static ForgeConfigSpec.IntValue MinHeightOtavite; 
	public static ForgeConfigSpec.IntValue MaxHeightOtavite; 

	public static ForgeConfigSpec.BooleanValue enableGreenockite; 
	public static ForgeConfigSpec.IntValue VeinSizeGreenockite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGreenockite; 
	public static ForgeConfigSpec.IntValue MinHeightGreenockite; 
	public static ForgeConfigSpec.IntValue MaxHeightGreenockite; 

	public static ForgeConfigSpec.BooleanValue enableCinnabar; 
	public static ForgeConfigSpec.IntValue VeinSizeCinnabar; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCinnabar; 
	public static ForgeConfigSpec.IntValue MinHeightCinnabar; 
	public static ForgeConfigSpec.IntValue MaxHeightCinnabar;

	public static ForgeConfigSpec.BooleanValue enableNative_copper; 
	public static ForgeConfigSpec.IntValue VeinSizeNative_copper; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNative_copper; 
	public static ForgeConfigSpec.IntValue MinHeightNative_copper; 
	public static ForgeConfigSpec.IntValue MaxHeightNative_copper; 

	public static ForgeConfigSpec.BooleanValue enableChalcopyrite; 
	public static ForgeConfigSpec.IntValue VeinSizeChalcopyrite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkChalcopyrite; 
	public static ForgeConfigSpec.IntValue MinHeightChalcopyrite; 
	public static ForgeConfigSpec.IntValue MaxHeightChalcopyrite; 

	public static ForgeConfigSpec.BooleanValue enableChalcocite; 
	public static ForgeConfigSpec.IntValue VeinSizeChalcocite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkChalcocite; 
	public static ForgeConfigSpec.IntValue MinHeightChalcocite; 
	public static ForgeConfigSpec.IntValue MaxHeightChalcocite; 

	public static ForgeConfigSpec.BooleanValue enableBornite; 
	public static ForgeConfigSpec.IntValue VeinSizeBornite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBornite; 
	public static ForgeConfigSpec.IntValue MinHeightBornite; 
	public static ForgeConfigSpec.IntValue MaxHeightBornite; 

	public static ForgeConfigSpec.BooleanValue enableEnargite; 
	public static ForgeConfigSpec.IntValue VeinSizeEnargite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkEnargite; 
	public static ForgeConfigSpec.IntValue MinHeightEnargite; 
	public static ForgeConfigSpec.IntValue MaxHeightEnargite; 

	public static ForgeConfigSpec.BooleanValue enableTennantite; 
	public static ForgeConfigSpec.IntValue VeinSizeTennantite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTennantite; 
	public static ForgeConfigSpec.IntValue MinHeightTennantite; 
	public static ForgeConfigSpec.IntValue MaxHeightTennantite; 

	public static ForgeConfigSpec.BooleanValue enableTetrahedrite; 
	public static ForgeConfigSpec.IntValue VeinSizeTetrahedrite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTetrahedrite; 
	public static ForgeConfigSpec.IntValue MinHeightTetrahedrite; 
	public static ForgeConfigSpec.IntValue MaxHeightTetrahedrite;

	public static ForgeConfigSpec.BooleanValue enableCovellite; 
	public static ForgeConfigSpec.IntValue VeinSizeCovellite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCovellite; 
	public static ForgeConfigSpec.IntValue MinHeightCovellite; 
	public static ForgeConfigSpec.IntValue MaxHeightCovellite; 

	public static ForgeConfigSpec.BooleanValue enableAzurite; 
	public static ForgeConfigSpec.IntValue VeinSizeAzurite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAzurite; 
	public static ForgeConfigSpec.IntValue MinHeightAzurite; 
	public static ForgeConfigSpec.IntValue MaxHeightAzurite; 

	public static ForgeConfigSpec.BooleanValue enableMalachite; 
	public static ForgeConfigSpec.IntValue VeinSizeMalachite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMalachite; 
	public static ForgeConfigSpec.IntValue MinHeightMalachite; 
	public static ForgeConfigSpec.IntValue MaxHeightMalachite; 

	public static ForgeConfigSpec.BooleanValue enableCuprite; 
	public static ForgeConfigSpec.IntValue VeinSizeCuprite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCuprite; 
	public static ForgeConfigSpec.IntValue MinHeightCuprite; 
	public static ForgeConfigSpec.IntValue MaxHeightCuprite; 

	public static ForgeConfigSpec.BooleanValue enableNative_silver; 
	public static ForgeConfigSpec.IntValue VeinSizeNative_silver; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNative_silver; 
	public static ForgeConfigSpec.IntValue MinHeightNative_silver; 
	public static ForgeConfigSpec.IntValue MaxHeightNative_silver; 

	public static ForgeConfigSpec.BooleanValue enableAcanthite; 
	public static ForgeConfigSpec.IntValue VeinSizeAcanthite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAcanthite; 
	public static ForgeConfigSpec.IntValue MinHeightAcanthite; 
	public static ForgeConfigSpec.IntValue MaxHeightAcanthite;

	public static ForgeConfigSpec.BooleanValue enableStephanite; 
	public static ForgeConfigSpec.IntValue VeinSizeStephanite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkStephanite; 
	public static ForgeConfigSpec.IntValue MinHeightStephanite; 
	public static ForgeConfigSpec.IntValue MaxHeightStephanite; 

	public static ForgeConfigSpec.BooleanValue enableProustite; 
	public static ForgeConfigSpec.IntValue VeinSizeProustite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkProustite; 
	public static ForgeConfigSpec.IntValue MinHeightProustite; 
	public static ForgeConfigSpec.IntValue MaxHeightProustite; 

	public static ForgeConfigSpec.BooleanValue enableFreibergite; 
	public static ForgeConfigSpec.IntValue VeinSizeFreibergite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkFreibergite; 
	public static ForgeConfigSpec.IntValue MinHeightFreibergite; 
	public static ForgeConfigSpec.IntValue MaxHeightFreibergite; 

	public static ForgeConfigSpec.BooleanValue enableNickeline; 
	public static ForgeConfigSpec.IntValue VeinSizeNickeline; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNickeline; 
	public static ForgeConfigSpec.IntValue MinHeightNickeline; 
	public static ForgeConfigSpec.IntValue MaxHeightNickeline; 

	public static ForgeConfigSpec.BooleanValue enablePentlandite; 
	public static ForgeConfigSpec.IntValue VeinSizePentlandite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPentlandite; 
	public static ForgeConfigSpec.IntValue MinHeightPentlandite; 
	public static ForgeConfigSpec.IntValue MaxHeightPentlandite; 

	public static ForgeConfigSpec.BooleanValue enableNepouite; 
	public static ForgeConfigSpec.IntValue VeinSizeNepouite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNepouite; 
	public static ForgeConfigSpec.IntValue MinHeightNepouite; 
	public static ForgeConfigSpec.IntValue MaxHeightNepouite;

	public static ForgeConfigSpec.BooleanValue enableMillerite; 
	public static ForgeConfigSpec.IntValue VeinSizeMillerite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMillerite; 
	public static ForgeConfigSpec.IntValue MinHeightMillerite; 
	public static ForgeConfigSpec.IntValue MaxHeightMillerite; 

	public static ForgeConfigSpec.BooleanValue enableGersdorffite; 
	public static ForgeConfigSpec.IntValue VeinSizeGersdorffite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGersdorffite; 
	public static ForgeConfigSpec.IntValue MinHeightGersdorffite; 
	public static ForgeConfigSpec.IntValue MaxHeightGersdorffite; 

	public static ForgeConfigSpec.BooleanValue enableCobaltite; 
	public static ForgeConfigSpec.IntValue VeinSizeCobaltite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCobaltite; 
	public static ForgeConfigSpec.IntValue MinHeightCobaltite; 
	public static ForgeConfigSpec.IntValue MaxHeightCobaltite; 

	public static ForgeConfigSpec.BooleanValue enableCarrollite; 
	public static ForgeConfigSpec.IntValue VeinSizeCarrollite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCarrollite; 
	public static ForgeConfigSpec.IntValue MinHeightCarrollite; 
	public static ForgeConfigSpec.IntValue MaxHeightCarrollite; 

	public static ForgeConfigSpec.BooleanValue enableSkutterudite; 
	public static ForgeConfigSpec.IntValue VeinSizeSkutterudite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSkutterudite; 
	public static ForgeConfigSpec.IntValue MinHeightSkutterudite; 
	public static ForgeConfigSpec.IntValue MaxHeightSkutterudite; 

	public static ForgeConfigSpec.BooleanValue enableHematite; 
	public static ForgeConfigSpec.IntValue VeinSizeHematite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHematite; 
	public static ForgeConfigSpec.IntValue MinHeightHematite; 
	public static ForgeConfigSpec.IntValue MaxHeightHematite; 

	public static ForgeConfigSpec.BooleanValue enableMagnetite; 
	public static ForgeConfigSpec.IntValue VeinSizeMagnetite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMagnetite; 
	public static ForgeConfigSpec.IntValue MinHeightMagnetite; 
	public static ForgeConfigSpec.IntValue MaxHeightMagnetite; 

	public static ForgeConfigSpec.BooleanValue enableLimonite; 
	public static ForgeConfigSpec.IntValue VeinSizeLimonite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLimonite; 
	public static ForgeConfigSpec.IntValue MinHeightLimonite; 
	public static ForgeConfigSpec.IntValue MaxHeightLimonite;

	public static ForgeConfigSpec.BooleanValue enableSiderite; 
	public static ForgeConfigSpec.IntValue VeinSizeSiderite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSiderite; 
	public static ForgeConfigSpec.IntValue MinHeightSiderite; 
	public static ForgeConfigSpec.IntValue MaxHeightSiderite; 

	public static ForgeConfigSpec.BooleanValue enableTelluric_iron; 
	public static ForgeConfigSpec.IntValue VeinSizeTelluric_iron; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTelluric_iron; 
	public static ForgeConfigSpec.IntValue MinHeightTelluric_iron; 
	public static ForgeConfigSpec.IntValue MaxHeightTelluric_iron; 

	public static ForgeConfigSpec.BooleanValue enablePyrolusite; 
	public static ForgeConfigSpec.IntValue VeinSizePyrolusite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPyrolusite; 
	public static ForgeConfigSpec.IntValue MinHeightPyrolusite; 
	public static ForgeConfigSpec.IntValue MaxHeightPyrolusite; 

	public static ForgeConfigSpec.BooleanValue enableRhodochrosite; 
	public static ForgeConfigSpec.IntValue VeinSizeRhodochrosite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRhodochrosite; 
	public static ForgeConfigSpec.IntValue MinHeightRhodochrosite; 
	public static ForgeConfigSpec.IntValue MaxHeightRhodochrosite; 

	public static ForgeConfigSpec.BooleanValue enableHollandite; 
	public static ForgeConfigSpec.IntValue VeinSizeHollandite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHollandite; 
	public static ForgeConfigSpec.IntValue MinHeightHollandite; 
	public static ForgeConfigSpec.IntValue MaxHeightHollandite; 

	public static ForgeConfigSpec.BooleanValue enableManganite; 
	public static ForgeConfigSpec.IntValue VeinSizeManganite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkManganite; 
	public static ForgeConfigSpec.IntValue MinHeightManganite; 
	public static ForgeConfigSpec.IntValue MaxHeightManganite; 

	public static ForgeConfigSpec.BooleanValue enableHausmannite; 
	public static ForgeConfigSpec.IntValue VeinSizeHausmannite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHausmannite; 
	public static ForgeConfigSpec.IntValue MinHeightHausmannite; 
	public static ForgeConfigSpec.IntValue MaxHeightHausmannite;

	public static ForgeConfigSpec.BooleanValue enableAlabandite; 
	public static ForgeConfigSpec.IntValue VeinSizeAlabandite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAlabandite; 
	public static ForgeConfigSpec.IntValue MinHeightAlabandite; 
	public static ForgeConfigSpec.IntValue MaxHeightAlabandite; 

	public static ForgeConfigSpec.BooleanValue enableRhodonite; 
	public static ForgeConfigSpec.IntValue VeinSizeRhodonite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRhodonite; 
	public static ForgeConfigSpec.IntValue MinHeightRhodonite; 
	public static ForgeConfigSpec.IntValue MaxHeightRhodonite; 

	public static ForgeConfigSpec.BooleanValue enableChromite; 
	public static ForgeConfigSpec.IntValue VeinSizeChromite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkChromite; 
	public static ForgeConfigSpec.IntValue MinHeightChromite; 
	public static ForgeConfigSpec.IntValue MaxHeightChromite; 

	public static ForgeConfigSpec.BooleanValue enableMolybdenite; 
	public static ForgeConfigSpec.IntValue VeinSizeMolybdenite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMolybdenite; 
	public static ForgeConfigSpec.IntValue MinHeightMolybdenite; 
	public static ForgeConfigSpec.IntValue MaxHeightMolybdenite; 

	public static ForgeConfigSpec.BooleanValue enableWulfenite; 
	public static ForgeConfigSpec.IntValue VeinSizeWulfenite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkWulfenite; 
	public static ForgeConfigSpec.IntValue MinHeightWulfenite; 
	public static ForgeConfigSpec.IntValue MaxHeightWulfenite; 

	public static ForgeConfigSpec.BooleanValue enableScheelite; 
	public static ForgeConfigSpec.IntValue VeinSizeScheelite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkScheelite; 
	public static ForgeConfigSpec.IntValue MinHeightScheelite; 
	public static ForgeConfigSpec.IntValue MaxHeightScheelite; 

	public static ForgeConfigSpec.BooleanValue enableFerberite; 
	public static ForgeConfigSpec.IntValue VeinSizeFerberite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkFerberite; 
	public static ForgeConfigSpec.IntValue MinHeightFerberite; 
	public static ForgeConfigSpec.IntValue MaxHeightFerberite; 

	public static ForgeConfigSpec.BooleanValue enableHubnerite; 
	public static ForgeConfigSpec.IntValue VeinSizeHubnerite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHubnerite; 
	public static ForgeConfigSpec.IntValue MinHeightHubnerite; 
	public static ForgeConfigSpec.IntValue MaxHeightHubnerite;

	public static ForgeConfigSpec.BooleanValue enableVanadinite; 
	public static ForgeConfigSpec.IntValue VeinSizeVanadinite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkVanadinite; 
	public static ForgeConfigSpec.IntValue MinHeightVanadinite; 
	public static ForgeConfigSpec.IntValue MaxHeightVanadinite; 

	public static ForgeConfigSpec.BooleanValue enableDescloizite; 
	public static ForgeConfigSpec.IntValue VeinSizeDescloizite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkDescloizite; 
	public static ForgeConfigSpec.IntValue MinHeightDescloizite; 
	public static ForgeConfigSpec.IntValue MaxHeightDescloizite; 

	public static ForgeConfigSpec.BooleanValue enableColumbite; 
	public static ForgeConfigSpec.IntValue VeinSizeColumbite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkColumbite; 
	public static ForgeConfigSpec.IntValue MinHeightColumbite; 
	public static ForgeConfigSpec.IntValue MaxHeightColumbite; 

	public static ForgeConfigSpec.BooleanValue enableTantalite; 
	public static ForgeConfigSpec.IntValue VeinSizeTantalite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTantalite; 
	public static ForgeConfigSpec.IntValue MinHeightTantalite; 
	public static ForgeConfigSpec.IntValue MaxHeightTantalite; 

	public static ForgeConfigSpec.BooleanValue enableRutile; 
	public static ForgeConfigSpec.IntValue VeinSizeRutile; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRutile; 
	public static ForgeConfigSpec.IntValue MinHeightRutile; 
	public static ForgeConfigSpec.IntValue MaxHeightRutile; 

	public static ForgeConfigSpec.BooleanValue enableIlmenite; 
	public static ForgeConfigSpec.IntValue VeinSizeIlmenite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkIlmenite; 
	public static ForgeConfigSpec.IntValue MinHeightIlmenite; 
	public static ForgeConfigSpec.IntValue MaxHeightIlmenite; 

	public static ForgeConfigSpec.BooleanValue enableAnatase; 
	public static ForgeConfigSpec.IntValue VeinSizeAnatase; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAnatase; 
	public static ForgeConfigSpec.IntValue MinHeightAnatase; 
	public static ForgeConfigSpec.IntValue MaxHeightAnatase; 

	public static ForgeConfigSpec.BooleanValue enableBrookite; 
	public static ForgeConfigSpec.IntValue VeinSizeBrookite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBrookite; 
	public static ForgeConfigSpec.IntValue MinHeightBrookite; 
	public static ForgeConfigSpec.IntValue MaxHeightBrookite;

	public static ForgeConfigSpec.BooleanValue enableTitanite; 
	public static ForgeConfigSpec.IntValue VeinSizeTitanite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTitanite; 
	public static ForgeConfigSpec.IntValue MinHeightTitanite; 
	public static ForgeConfigSpec.IntValue MaxHeightTitanite; 

	public static ForgeConfigSpec.BooleanValue enableZircon; 
	public static ForgeConfigSpec.IntValue VeinSizeZircon; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkZircon; 
	public static ForgeConfigSpec.IntValue MinHeightZircon; 
	public static ForgeConfigSpec.IntValue MaxHeightZircon; 

	public static ForgeConfigSpec.BooleanValue enableThorite; 
	public static ForgeConfigSpec.IntValue VeinSizeThorite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkThorite; 
	public static ForgeConfigSpec.IntValue MinHeightThorite; 
	public static ForgeConfigSpec.IntValue MaxHeightThorite; 

	public static ForgeConfigSpec.BooleanValue enableCarnotite; 
	public static ForgeConfigSpec.IntValue VeinSizeCarnotite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCarnotite; 
	public static ForgeConfigSpec.IntValue MinHeightCarnotite; 
	public static ForgeConfigSpec.IntValue MaxHeightCarnotite; 

	public static ForgeConfigSpec.BooleanValue enableUraninite; 
	public static ForgeConfigSpec.IntValue VeinSizeUraninite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkUraninite; 
	public static ForgeConfigSpec.IntValue MinHeightUraninite; 
	public static ForgeConfigSpec.IntValue MaxHeightUraninite; 

	public static ForgeConfigSpec.BooleanValue enableMagnesite; 
	public static ForgeConfigSpec.IntValue VeinSizeMagnesite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMagnesite; 
	public static ForgeConfigSpec.IntValue MinHeightMagnesite; 
	public static ForgeConfigSpec.IntValue MaxHeightMagnesite; 

	public static ForgeConfigSpec.BooleanValue enableKieserite; 
	public static ForgeConfigSpec.IntValue VeinSizeKieserite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkKieserite; 
	public static ForgeConfigSpec.IntValue MinHeightKieserite; 
	public static ForgeConfigSpec.IntValue MaxHeightKieserite;

	public static ForgeConfigSpec.BooleanValue enableBrucite; 
	public static ForgeConfigSpec.IntValue VeinSizeBrucite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBrucite; 
	public static ForgeConfigSpec.IntValue MinHeightBrucite; 
	public static ForgeConfigSpec.IntValue MaxHeightBrucite; 

	public static ForgeConfigSpec.BooleanValue enableCalcite; 
	public static ForgeConfigSpec.IntValue VeinSizeCalcite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCalcite; 
	public static ForgeConfigSpec.IntValue MinHeightCalcite; 
	public static ForgeConfigSpec.IntValue MaxHeightCalcite; 

	public static ForgeConfigSpec.BooleanValue enableGypsum; 
	public static ForgeConfigSpec.IntValue VeinSizeGypsum; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGypsum; 
	public static ForgeConfigSpec.IntValue MinHeightGypsum; 
	public static ForgeConfigSpec.IntValue MaxHeightGypsum; 

	public static ForgeConfigSpec.BooleanValue enableAnhydrite; 
	public static ForgeConfigSpec.IntValue VeinSizeAnhydrite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAnhydrite; 
	public static ForgeConfigSpec.IntValue MinHeightAnhydrite; 
	public static ForgeConfigSpec.IntValue MaxHeightAnhydrite; 

	public static ForgeConfigSpec.BooleanValue enableDolomite; 
	public static ForgeConfigSpec.IntValue VeinSizeDolomite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkDolomite; 
	public static ForgeConfigSpec.IntValue MinHeightDolomite; 
	public static ForgeConfigSpec.IntValue MaxHeightDolomite; 

	public static ForgeConfigSpec.BooleanValue enableStrontianite; 
	public static ForgeConfigSpec.IntValue VeinSizeStrontianite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkStrontianite; 
	public static ForgeConfigSpec.IntValue MinHeightStrontianite; 
	public static ForgeConfigSpec.IntValue MaxHeightStrontianite; 

	public static ForgeConfigSpec.BooleanValue enableCelestine; 
	public static ForgeConfigSpec.IntValue VeinSizeCelestine; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCelestine; 
	public static ForgeConfigSpec.IntValue MinHeightCelestine; 
	public static ForgeConfigSpec.IntValue MaxHeightCelestine;

	public static ForgeConfigSpec.BooleanValue enablePolylithionite; 
	public static ForgeConfigSpec.IntValue VeinSizePolylithionite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPolylithionite; 
	public static ForgeConfigSpec.IntValue MinHeightPolylithionite; 
	public static ForgeConfigSpec.IntValue MaxHeightPolylithionite; 

	public static ForgeConfigSpec.BooleanValue enablePetalite; 
	public static ForgeConfigSpec.IntValue VeinSizePetalite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPetalite; 
	public static ForgeConfigSpec.IntValue MinHeightPetalite; 
	public static ForgeConfigSpec.IntValue MaxHeightPetalite; 

	public static ForgeConfigSpec.BooleanValue enableCarnallite; 
	public static ForgeConfigSpec.IntValue VeinSizeCarnallite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCarnallite; 
	public static ForgeConfigSpec.IntValue MinHeightCarnallite; 
	public static ForgeConfigSpec.IntValue MaxHeightCarnallite; 

	public static ForgeConfigSpec.BooleanValue enableSylvite; 
	public static ForgeConfigSpec.IntValue VeinSizeSylvite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSylvite; 
	public static ForgeConfigSpec.IntValue MinHeightSylvite; 
	public static ForgeConfigSpec.IntValue MaxHeightSylvite; 

	public static ForgeConfigSpec.BooleanValue enablePolyhalite; 
	public static ForgeConfigSpec.IntValue VeinSizePolyhalite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPolyhalite; 
	public static ForgeConfigSpec.IntValue MinHeightPolyhalite; 
	public static ForgeConfigSpec.IntValue MaxHeightPolyhalite; 

	public static ForgeConfigSpec.BooleanValue enableKainite; 
	public static ForgeConfigSpec.IntValue VeinSizeKainite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkKainite; 
	public static ForgeConfigSpec.IntValue MinHeightKainite; 
	public static ForgeConfigSpec.IntValue MaxHeightKainite; 

	public static ForgeConfigSpec.BooleanValue enableLangbeinite; 
	public static ForgeConfigSpec.IntValue VeinSizeLangbeinite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLangbeinite; 
	public static ForgeConfigSpec.IntValue MinHeightLangbeinite; 
	public static ForgeConfigSpec.IntValue MaxHeightLangbeinite; 

	public static ForgeConfigSpec.BooleanValue enableNitratine; 
	public static ForgeConfigSpec.IntValue VeinSizeNitratine; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNitratine; 
	public static ForgeConfigSpec.IntValue MinHeightNitratine; 
	public static ForgeConfigSpec.IntValue MaxHeightNitratine;

	public static ForgeConfigSpec.BooleanValue enableHalite; 
	public static ForgeConfigSpec.IntValue VeinSizeHalite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHalite; 
	public static ForgeConfigSpec.IntValue MinHeightHalite; 
	public static ForgeConfigSpec.IntValue MaxHeightHalite; 

	public static ForgeConfigSpec.BooleanValue enableSapphire_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeSapphire_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSapphire_ore; 
	public static ForgeConfigSpec.IntValue MinHeightSapphire_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightSapphire_ore; 

	public static ForgeConfigSpec.BooleanValue enableRuby_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeRuby_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRuby_ore; 
	public static ForgeConfigSpec.IntValue MinHeightRuby_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightRuby_ore; 

	public static ForgeConfigSpec.BooleanValue enableSpinel_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeSpinel_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSpinel_ore; 
	public static ForgeConfigSpec.IntValue MinHeightSpinel_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightSpinel_ore; 

	public static ForgeConfigSpec.BooleanValue enableAmethyst_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAmethyst_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAmethyst_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAmethyst_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAmethyst_ore; 

	public static ForgeConfigSpec.BooleanValue enableJade_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeJade_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkJade_ore; 
	public static ForgeConfigSpec.IntValue MinHeightJade_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightJade_ore; 

	public static ForgeConfigSpec.BooleanValue enableTourmaline_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeTourmaline_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTourmaline_ore; 
	public static ForgeConfigSpec.IntValue MinHeightTourmaline_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightTourmaline_ore;

	public static ForgeConfigSpec.BooleanValue enableSugilite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeSugilite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSugilite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightSugilite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightSugilite_ore; 

	public static ForgeConfigSpec.BooleanValue enablePeridot_ore; 
	public static ForgeConfigSpec.IntValue VeinSizePeridot_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPeridot_ore; 
	public static ForgeConfigSpec.IntValue MinHeightPeridot_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightPeridot_ore; 

	public static ForgeConfigSpec.BooleanValue enableAgate_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAgate_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAgate_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAgate_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAgate_ore; 

	public static ForgeConfigSpec.BooleanValue enableCarnelian_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeCarnelian_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkCarnelian_ore; 
	public static ForgeConfigSpec.IntValue MinHeightCarnelian_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightCarnelian_ore; 

	public static ForgeConfigSpec.BooleanValue enableChrysoprase_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeChrysoprase_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkChrysoprase_ore; 
	public static ForgeConfigSpec.IntValue MinHeightChrysoprase_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightChrysoprase_ore; 

	public static ForgeConfigSpec.BooleanValue enableHeliotrope_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeHeliotrope_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHeliotrope_ore; 
	public static ForgeConfigSpec.IntValue MinHeightHeliotrope_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightHeliotrope_ore; 

	public static ForgeConfigSpec.BooleanValue enableTopaz_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeTopaz_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTopaz_ore; 
	public static ForgeConfigSpec.IntValue MinHeightTopaz_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightTopaz_ore;

	public static ForgeConfigSpec.BooleanValue enableUnakite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeUnakite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkUnakite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightUnakite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightUnakite_ore; 

	public static ForgeConfigSpec.BooleanValue enableTanzanite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeTanzanite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTanzanite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightTanzanite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightTanzanite_ore; 

	public static ForgeConfigSpec.BooleanValue enableHauyne_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeHauyne_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkHauyne_ore; 
	public static ForgeConfigSpec.IntValue MinHeightHauyne_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightHauyne_ore; 

	public static ForgeConfigSpec.BooleanValue enableOnyx_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeOnyx_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkOnyx_ore; 
	public static ForgeConfigSpec.IntValue MinHeightOnyx_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightOnyx_ore; 

	public static ForgeConfigSpec.BooleanValue enableOpal_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeOpal_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkOpal_ore; 
	public static ForgeConfigSpec.IntValue MinHeightOpal_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightOpal_ore; 

	public static ForgeConfigSpec.BooleanValue enableMoonstone_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeMoonstone_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMoonstone_ore; 
	public static ForgeConfigSpec.IntValue MinHeightMoonstone_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightMoonstone_ore;

	public static ForgeConfigSpec.BooleanValue enableTurquoise_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeTurquoise_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTurquoise_ore; 
	public static ForgeConfigSpec.IntValue MinHeightTurquoise_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightTurquoise_ore; 

	public static ForgeConfigSpec.BooleanValue enableAmazonite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAmazonite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAmazonite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAmazonite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAmazonite_ore; 

	public static ForgeConfigSpec.BooleanValue enableChrysocolla_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeChrysocolla_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkChrysocolla_ore; 
	public static ForgeConfigSpec.IntValue MinHeightChrysocolla_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightChrysocolla_ore; 

	public static ForgeConfigSpec.BooleanValue enableAlmandine_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAlmandine_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAlmandine_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAlmandine_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAlmandine_ore; 

	public static ForgeConfigSpec.BooleanValue enableSpessartine_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeSpessartine_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkSpessartine_ore; 
	public static ForgeConfigSpec.IntValue MinHeightSpessartine_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightSpessartine_ore; 

	public static ForgeConfigSpec.BooleanValue enablePyrope_ore; 
	public static ForgeConfigSpec.IntValue VeinSizePyrope_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPyrope_ore; 
	public static ForgeConfigSpec.IntValue MinHeightPyrope_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightPyrope_ore;

	public static ForgeConfigSpec.BooleanValue enableTsavorite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeTsavorite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkTsavorite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightTsavorite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightTsavorite_ore; 

	public static ForgeConfigSpec.BooleanValue enableAndradite_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeAndradite_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAndradite_ore; 
	public static ForgeConfigSpec.IntValue MinHeightAndradite_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightAndradite_ore;

	public static ForgeConfigSpec.BooleanValue enableMithril_ore; 
	public static ForgeConfigSpec.IntValue VeinSizeMithril_ore; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkMithril_ore; 
	public static ForgeConfigSpec.IntValue MinHeightMithril_ore; 
	public static ForgeConfigSpec.IntValue MaxHeightMithril_ore;

	public static ForgeConfigSpec.BooleanValue enableSulphurOres;
	public static ForgeConfigSpec.BooleanValue enableSeleniumOres;
	public static ForgeConfigSpec.BooleanValue enableCoalOres;
	public static ForgeConfigSpec.BooleanValue enableGraphiteOre;
	public static ForgeConfigSpec.BooleanValue enableArsenicOres;
	public static ForgeConfigSpec.BooleanValue enableAntimonyOres;
	public static ForgeConfigSpec.BooleanValue enableGermaniumOres;
	public static ForgeConfigSpec.BooleanValue enableBismuthOres;
	public static ForgeConfigSpec.BooleanValue enableTinOres;
	public static ForgeConfigSpec.BooleanValue enableLeadOres;
	public static ForgeConfigSpec.BooleanValue enableAluminumOres;
	public static ForgeConfigSpec.BooleanValue enableZincOres;
	public static ForgeConfigSpec.BooleanValue enableCadmiumOres;
	public static ForgeConfigSpec.BooleanValue enableMercuryOres;
	public static ForgeConfigSpec.BooleanValue enableCopperOres;
	public static ForgeConfigSpec.BooleanValue enableSilverOres;
	public static ForgeConfigSpec.BooleanValue enableNickelOres;
	public static ForgeConfigSpec.BooleanValue enableCobaltOres;
	public static ForgeConfigSpec.BooleanValue enableIronOres;
	public static ForgeConfigSpec.BooleanValue enableManganeseOres;
	public static ForgeConfigSpec.BooleanValue enableChromiumOres;
	public static ForgeConfigSpec.BooleanValue enableMolybdenumOres;
	public static ForgeConfigSpec.BooleanValue enableTungstenOres;
	public static ForgeConfigSpec.BooleanValue enableVanadiumOres;
	public static ForgeConfigSpec.BooleanValue enableNiobiumOres;
	public static ForgeConfigSpec.BooleanValue enableTantalumOres;
	public static ForgeConfigSpec.BooleanValue enableTitaniumOres;
	public static ForgeConfigSpec.BooleanValue enableZirconiumOres;
	public static ForgeConfigSpec.BooleanValue enableThoriumOres;
	public static ForgeConfigSpec.BooleanValue enableUraniumOres;
	public static ForgeConfigSpec.BooleanValue enableMagnesiumOres;
	public static ForgeConfigSpec.BooleanValue enableCalciumOres;
	public static ForgeConfigSpec.BooleanValue enableStrontiumOres;
	public static ForgeConfigSpec.BooleanValue enableLithiumOres;	
	public static ForgeConfigSpec.BooleanValue enableNPKOres;
	public static ForgeConfigSpec.BooleanValue enableMithrilOre;
	public static ForgeConfigSpec.BooleanValue enableSaltpetreOre;
	public static ForgeConfigSpec.BooleanValue enableSaltOre;
	public static ForgeConfigSpec.BooleanValue enableSomeGems;
	public static ForgeConfigSpec.BooleanValue enableAllGems;
	public static ForgeConfigSpec.BooleanValue enablePGMs;
	public static ForgeConfigSpec.BooleanValue enableRarePGMs;	
	public static ForgeConfigSpec.BooleanValue enableREEs;

	public static ForgeConfigSpec.BooleanValue enableGold; 
	public static ForgeConfigSpec.IntValue VeinSizeGold; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGold; 
	public static ForgeConfigSpec.IntValue MinHeightGold; 
	public static ForgeConfigSpec.IntValue MaxHeightGold;

	public static ForgeConfigSpec.BooleanValue enableBadlandsGold; 
	public static ForgeConfigSpec.IntValue VeinSizeBadlandsGold; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkBadlandsGold; 
	public static ForgeConfigSpec.IntValue MinHeightBadlandsGold; 
	public static ForgeConfigSpec.IntValue MaxHeightBadlandsGold;

	public static ForgeConfigSpec.BooleanValue enableRedstone; 
	public static ForgeConfigSpec.IntValue VeinSizeRedstone; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRedstone; 
	public static ForgeConfigSpec.IntValue MinHeightRedstone; 
	public static ForgeConfigSpec.IntValue MaxHeightRedstone;

	public static ForgeConfigSpec.BooleanValue enableDiamond; 
	public static ForgeConfigSpec.IntValue VeinSizeDiamond; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkDiamond; 
	public static ForgeConfigSpec.IntValue MinHeightDiamond; 
	public static ForgeConfigSpec.IntValue MaxHeightDiamond;

	public static ForgeConfigSpec.BooleanValue enableLapis; 
	public static ForgeConfigSpec.IntValue VeinSizeLapis; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkLapis; 
	public static ForgeConfigSpec.IntValue DepthAverageLapis; 

	public static ForgeConfigSpec.BooleanValue enableDirt; 
	public static ForgeConfigSpec.IntValue VeinSizeDirt; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkDirt; 
	public static ForgeConfigSpec.IntValue MinHeightDirt; 
	public static ForgeConfigSpec.IntValue MaxHeightDirt;

	public static ForgeConfigSpec.BooleanValue enableGravel; 
	public static ForgeConfigSpec.IntValue VeinSizeGravel; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGravel; 
	public static ForgeConfigSpec.IntValue MinHeightGravel; 
	public static ForgeConfigSpec.IntValue MaxHeightGravel;

	public static ForgeConfigSpec.BooleanValue enableGranite; 
	public static ForgeConfigSpec.IntValue VeinSizeGranite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkGranite; 
	public static ForgeConfigSpec.IntValue MinHeightGranite; 
	public static ForgeConfigSpec.IntValue MaxHeightGranite;

	public static ForgeConfigSpec.BooleanValue enableDiorite; 
	public static ForgeConfigSpec.IntValue VeinSizeDiorite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkDiorite; 
	public static ForgeConfigSpec.IntValue MinHeightDiorite; 
	public static ForgeConfigSpec.IntValue MaxHeightDiorite;

	public static ForgeConfigSpec.BooleanValue enableAndesite; 
	public static ForgeConfigSpec.IntValue VeinSizeAndesite; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAndesite; 
	public static ForgeConfigSpec.IntValue MinHeightAndesite; 
	public static ForgeConfigSpec.IntValue MaxHeightAndesite;

	public static ForgeConfigSpec.BooleanValue enableInfestedStone; 
	public static ForgeConfigSpec.IntValue VeinSizeInfestedStone; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkInfestedStone; 
	public static ForgeConfigSpec.IntValue MinHeightInfestedStone; 
	public static ForgeConfigSpec.IntValue MaxHeightInfestedStone;

	public static ForgeConfigSpec.BooleanValue enableAdditionalPeat; 
	public static ForgeConfigSpec.IntValue VeinSizeAdditionalPeat; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkAdditionalPeat; 
	public static ForgeConfigSpec.IntValue MinHeightAdditionalPeat; 
	public static ForgeConfigSpec.IntValue MaxHeightAdditionalPeat;

	public static ForgeConfigSpec.BooleanValue enableNetherCoal; 
	public static ForgeConfigSpec.IntValue VeinSizeNetherCoal; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNetherCoal; 
	public static ForgeConfigSpec.IntValue MinHeightNetherCoal; 
	public static ForgeConfigSpec.IntValue MaxHeightNetherCoal;

	public static ForgeConfigSpec.BooleanValue enableNetherGold; 
	public static ForgeConfigSpec.IntValue VeinSizeNetherGold; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNetherGold; 
	public static ForgeConfigSpec.IntValue MinHeightNetherGold; 
	public static ForgeConfigSpec.IntValue MaxHeightNetherGold;

	public static ForgeConfigSpec.BooleanValue enableNetherMithril; 
	public static ForgeConfigSpec.IntValue VeinSizeNetherMithril; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNetherMithril; 
	public static ForgeConfigSpec.IntValue MinHeightNetherMithril; 
	public static ForgeConfigSpec.IntValue MaxHeightNetherMithril;

	public static ForgeConfigSpec.BooleanValue enableNetherSulphur; 
	public static ForgeConfigSpec.IntValue VeinSizeNetherSulphur; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkNetherSulphur; 
	public static ForgeConfigSpec.IntValue MinHeightNetherSulphur; 
	public static ForgeConfigSpec.IntValue MaxHeightNetherSulphur;

	public static ForgeConfigSpec.IntValue VeinSizeCoal;
	public static ForgeConfigSpec.IntValue VeinsPerChunkCoal;
	public static ForgeConfigSpec.IntValue MinHeightCoal;	
	public static ForgeConfigSpec.IntValue MaxHeightCoal;

	public static ForgeConfigSpec.IntValue VeinSizeIron;
	public static ForgeConfigSpec.IntValue VeinsPerChunkIron;
	public static ForgeConfigSpec.IntValue MinHeightIron;
	public static ForgeConfigSpec.IntValue MaxHeightIron;

	public static ForgeConfigSpec.BooleanValue enabledPGMs; 
	public static ForgeConfigSpec.IntValue VeinSizePGMs; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkPGMs; 
	public static ForgeConfigSpec.IntValue MinHeightPGMs; 
	public static ForgeConfigSpec.IntValue MaxHeightPGMs;

	public static ForgeConfigSpec.BooleanValue enabledRarePGMs; 
	public static ForgeConfigSpec.IntValue VeinSizeRarePGMs; 
	public static ForgeConfigSpec.IntValue VeinsPerChunkRarePGMs; 
	public static ForgeConfigSpec.IntValue MinHeightRarePGMs; 
	public static ForgeConfigSpec.IntValue MaxHeightRarePGMs;

	public static ForgeConfigSpec.IntValue copperHL;
	public static ForgeConfigSpec.IntValue tinHL;
	public static ForgeConfigSpec.IntValue zincHL;
	public static ForgeConfigSpec.IntValue leadHL;
	public static ForgeConfigSpec.IntValue cadmiumHL;
	public static ForgeConfigSpec.IntValue mercuryHL;
	public static ForgeConfigSpec.IntValue aluminiumHL;
	public static ForgeConfigSpec.IntValue silverHL;
	public static ForgeConfigSpec.IntValue manganeseHL;
	public static ForgeConfigSpec.IntValue titaniumHL;
	public static ForgeConfigSpec.IntValue tungstenHL;
	public static ForgeConfigSpec.IntValue nickelHL;
	public static ForgeConfigSpec.IntValue carnotiteHL;
	public static ForgeConfigSpec.IntValue uraniniteHL;
	public static ForgeConfigSpec.BooleanValue overwriteAutoStoneAgeValues;


	public static ForgeConfigSpec.BooleanValue enableEmerald;

	public static ForgeConfigSpec.BooleanValue All;

	static {
		BUILDER.comment("General settings").push("general");
		handleEverythingInOverworld = BUILDER.comment("Should Aato remove ALL ores from other mods to prevent 'duplicate' ores in the overworld.").define("handleEverythingInOverworld", true);
		disableAatoGeneration = BUILDER.comment("Set this to true if you only want to use this mod to tune vanilla ores spawning. Nothing from this mod will spawn in any dimension.").define("disableAatoGeneration", false);
		enableStoneAge = BUILDER.comment("Activate the stone age. Disable a few smelting recipes so you have to build a refiner in order to have iron. It really changes the way you have to play early game. (default: false)").define("enableStoneAge", false);
		enablePlugAndPlay = BUILDER.comment("If for some reason you don't want the mod to automatically enable ore generation for mods supported by the plug and play feature, set this to false"
				+ " WARNING : you will have to enable everything by yourself.").define("enablePlugAndPlay", true);
		clearNether = BUILDER.comment("Should Nether be cleared of all ore generation from vanilla and other mods.").define("clearNether", false);
		BUILDER.pop();

		BUILDER.comment("Harvest Levels. Wood, Stone, Iron, Diamond : 0, 1, 2, 3. Above 3 is modded materials stronger than diamond.").push("harvestlevels");
		overwriteAutoStoneAgeValues = BUILDER.comment("Should the mod use customized harvest levels "
				+ "instead of its default/automatic values").define("useCustomHarvestLevelValues", false);
		copperHL = BUILDER.comment("Copper ores harvest level").defineInRange("copperHarvestLevel", 1, 0, 5);
		tinHL = BUILDER.comment("Tin ores harvest level").defineInRange("tinHarvestLevel", 2, 0, 5);
		zincHL = BUILDER.comment("Zinc ores harvest level").defineInRange("zincHarvestLevel", 2, 0, 5);
		leadHL = BUILDER.comment("Lead ores harvest level").defineInRange("leadHarvestLevel", 2, 0, 5);
		cadmiumHL = BUILDER.comment("Cadmium ores harvest level").defineInRange("cadmiumHarvestLevel", 1, 0, 5);
		mercuryHL = BUILDER.comment("Mercury ores harvest level").defineInRange("mercuryHarvestLevel", 1, 0, 5);
		aluminiumHL = BUILDER.comment("Aluminium ores harvest level").defineInRange("aluminiumHarvestLevel", 2, 0, 5);
		silverHL = BUILDER.comment("Silver ores harvest level").defineInRange("silverHarvestLevel", 2, 0, 5);
		manganeseHL = BUILDER.comment("Manganese ores harvest level").defineInRange("manganeseHarvestLevel", 2, 0, 5);
		titaniumHL = BUILDER.comment("Titanium ores harvest level").defineInRange("titaniumHarvestLevel", 2, 0, 5);
		tungstenHL = BUILDER.comment("Tungsten ores harvest level").defineInRange("tungstenHarvestLevel", 2, 0, 5);
		nickelHL = BUILDER.comment("Nickel ores harvest level").defineInRange("nickelHarvestLevel", 2, 0, 5);
		BUILDER.comment("Uranium Ores harvest level").push("uraniumOresHarvestLevels");
		carnotiteHL = BUILDER.comment("Carnotite harvest level").defineInRange("carnotiteHarvestLevel", 2, 0, 5);
		uraniniteHL = BUILDER.comment("Uraninite harvest level").defineInRange("uraniniteHarvestLevel", 3, 0, 5);
		BUILDER.pop();
		BUILDER.pop();
		
		BUILDER.comment("Here you can blacklist biomes you don't want a group of ores to spawn in. You should put biomes registry names, e.g."
				+ " minecraft:plains or whatevermod:whateverbiome. See github wiki for examples. Works in all biomes except Nether and End.").push("blacklists");
		blacklistGoldOre = BUILDER.comment("Gold ore biomes blacklist").define("biomesBlacklistGoldOre", new ArrayList<String>());
		blacklistDiamondOre = BUILDER.comment("Diamond ore biomes blacklist").define("biomesBlacklistDiamondOre", new ArrayList<String>());
		blacklistLapisOre = BUILDER.comment("Lapis lazuli ore biomes blacklist").define("biomesBlacklistLapislazuliOre", new ArrayList<String>());
		blacklistRedstoneOre = BUILDER.comment("Redstone ore biomes blacklist").define("biomesBlacklistRedstoneOre", new ArrayList<String>());
		blacklistCopperOres = BUILDER.comment("Copper ores biomes blacklist").define("biomesBlacklistCopperOres", new ArrayList<String>());		
		blacklistIronOres = BUILDER.comment("Iron ores biomes blacklist. Also works for vanilla iron ore if you enabled it.").define("biomesBlacklistIronOres", new ArrayList<String>());
		blacklistAnthraciteOre = BUILDER.comment("Anthracite ore biomes blacklist").define("biomesBlacklistAnthraciteOre", new ArrayList<String>());
		blacklistBituminousCoalOre = BUILDER.comment("Bituminous coal ore biomes blacklist. Also works for vanilla coal ore if you enabled it.").define("biomesBlacklistBituminousCoalOre", new ArrayList<String>());
		blacklistPeatOre = BUILDER.comment("Peat biomes blacklist").define("biomesBlacklistPeat", new ArrayList<String>());
		blacklistLigniteOre = BUILDER.comment("Lignite ore biomes blacklist").define("biomesBlacklistLigniteOre", new ArrayList<String>());
		blacklistTinOres = BUILDER.comment("Tin ores biomes blacklist").define("biomesBlacklistTinOres", new ArrayList<String>());	
		blacklistSulfurOres = BUILDER.comment("Sulfur ores biomes blacklist").define("biomesBlacklistSulfurOres", new ArrayList<String>());
		blacklistNPKOres = BUILDER.comment("NPK ores (used for making fertilizer) biomes blacklist").define("biomesBlacklistNPKOres", new ArrayList<String>());
		blacklistLeadOres = BUILDER.comment("Lead ores biomes blacklist").define("biomesBlacklistLeadOres", new ArrayList<String>());
		blacklistAluminiumOres = BUILDER.comment("Aluminium ores biomes blacklist").define("biomesBlacklistAluminiumOres", new ArrayList<String>());
		blacklistZincOres = BUILDER.comment("Zinc ores biomes blacklist").define("biomesBlacklistZincOres", new ArrayList<String>());
		blacklistCadmiumOres = BUILDER.comment("Cadmium ores biomes blacklist").define("biomesBlacklistCadmiumOres", new ArrayList<String>());
		blacklistMercuryOres = BUILDER.comment("Mercury ores biomes blacklist").define("biomesBlacklistMercuryOres", new ArrayList<String>());
		blacklistSilverOres = BUILDER.comment("Silver ores biomes blacklist").define("biomesBlacklistSilverOres", new ArrayList<String>());
		blacklistNickelOres = BUILDER.comment("Nickel ores biomes blacklist").define("biomesBlacklistNickelOres", new ArrayList<String>());
		blacklistCommonPGMsOres = BUILDER.comment("Common PGMs (platinum, iridium, osmium) ores biomes blacklist").define("biomesBlacklistCommonPGMsOres", new ArrayList<String>());
		blacklistRarePGMsOres = BUILDER.comment("Rare PGMs (palladium, rhodium, ruthenium) ores biomes blacklist").define("biomesBlacklistRarePGMsOres", new ArrayList<String>());
		blacklistManganeseOres = BUILDER.comment("Manganese ores biomes blacklist").define("biomesBlacklistManganeseOres", new ArrayList<String>());
		blacklistChromiumOres = BUILDER.comment("Chromium ores biomes blacklist").define("biomesBlacklistChromiumOres", new ArrayList<String>());
		blacklistMolybdenumOres = BUILDER.comment("Molybdenum ores biomes blacklist").define("biomesBlacklistMolybdenumOres", new ArrayList<String>());
		blacklistTungstenOres = BUILDER.comment("Tungsten ores biomes blacklist").define("biomesBlacklistTungstenOres", new ArrayList<String>());
		blacklistVanadiumOres = BUILDER.comment("Vanadium ores biomes blacklist").define("biomesBlacklistVanadiumOres", new ArrayList<String>());
		blacklistNiobiumOres = BUILDER.comment("Niobium ores biomes blacklist").define("biomesBlacklistNiobiumOres", new ArrayList<String>());
		blacklistTantalumOres = BUILDER.comment("Tantalum ores biomes blacklist").define("biomesBlacklistTantalumOres", new ArrayList<String>());
		blacklistTitaniumOres = BUILDER.comment("Titanium ores biomes blacklist").define("biomesBlacklistTitaniumOres", new ArrayList<String>());
		blacklistZirconiumOres = BUILDER.comment("Zirconium ores biomes blacklist").define("biomesBlacklistZirconiumOres", new ArrayList<String>());
		blacklistThoriumOres = BUILDER.comment("Thorium ores biomes blacklist").define("biomesBlacklistThoriumOres", new ArrayList<String>());
		blacklistUraniumOres = BUILDER.comment("Uranium ores biomes blacklist").define("biomesBlacklistUraniumOres", new ArrayList<String>());
		blacklistMagnesiumOres = BUILDER.comment("Magnesium ores biomes blacklist").define("biomesBlacklistMagnesiumOres", new ArrayList<String>());
		blacklistCalciumOres = BUILDER.comment("Calcium ores biomes blacklist").define("biomesBlacklistCalciumOres", new ArrayList<String>());
		blacklistStrontiumOres = BUILDER.comment("Strontium ores biomes blacklist").define("biomesBlacklistStrontiumOres", new ArrayList<String>());
		blacklistLithiumOres = BUILDER.comment("Lithium ores biomes blacklist").define("biomesBlacklistLithiumOres", new ArrayList<String>());
		blacklistPotassiumOres = BUILDER.comment("Potassium ores biomes blacklist").define("biomesBlacklistPotassiumOres", new ArrayList<String>());
		blacklistSaltOre = BUILDER.comment("Salt ore (halite) biomes blacklist").define("biomesBlacklistSaltOre", new ArrayList<String>());
		blacklistSaltpetreOre = BUILDER.comment("Saltpetre ore (nitratine) biomes blacklist").define("biomesBlacklistSaltpetreOre", new ArrayList<String>());
		blacklistMithrilOre = BUILDER.comment("Mithril ore biomes blacklist").define("biomesBlacklistMithrilOre", new ArrayList<String>());
		blacklistCobaltOres = BUILDER.comment("Cobalt ores biomes blacklist").define("biomesBlacklistCobaltOres", new ArrayList<String>());
		blacklistGraphiteOre = BUILDER.comment("Graphite biomes blacklist").define("biomesBlacklistGraphite", new ArrayList<String>());
		blacklistChrysocollaOre = BUILDER.comment("Chrysocolla (gem used to make a refiner) biomes blacklist").define("biomesBlacklistChrysocollaOre", new ArrayList<String>());
		BUILDER.pop();

		BUILDER.comment("Simplified overworld generation settings for modded ores.").push("overworldSimplified");
		enableSulphurOres = BUILDER.comment("Enable all sulphur ores. (default: true)").define("enableSulphurOres", true);
		enableSeleniumOres = BUILDER.comment("Enable all selenium ores. (default: false)").define("enableSeleniumOres", false);
		enableCoalOres = BUILDER.comment("Enable all coal ores. (default: true)").define("enableCoalOres", true); 
		enableGraphiteOre = BUILDER.comment("Enable graphite ore. (default: false)").define("enableGraphiteOre", false); 
		enableArsenicOres = BUILDER.comment("Enable all arsenic ores. (default: false)").define("enableArsenicOres", false);
		enableAntimonyOres = BUILDER.comment("Enable all antimony ores. (default: false)").define("enableAntimonyOres", false);
		enableGermaniumOres = BUILDER.comment("Enable all germanium ores. (default: false)").define("enableGermaniumOres", false);
		enableBismuthOres = BUILDER.comment("Enable all bismuth ores. (default: false)").define("enableBismuthOres", false);
		enableTinOres = BUILDER.comment("Enable all tin ores. (default: false)").define("enableTinOres", false);
		enableLeadOres = BUILDER.comment("Enable all lead ores. (default: false)").define("enableLeadOres", false);
		enableAluminumOres = BUILDER.comment("Enable all aluminum ores. (default: false)").define("enableAluminumOres", false);
		enableZincOres = BUILDER.comment("Enable all zinc ores. (default: false)").define("enableZincOres", false);
		enableCadmiumOres = BUILDER.comment("Enable all cadmium ores. (default: false)").define("enableCadmiumOres", false);
		enableMercuryOres = BUILDER.comment("Enable all mercury ores. (default: false)").define("enableMercuryOres", false);
		enableCopperOres = BUILDER.comment("Enable all copper ores. (default: false)").define("enableCopperOres", false);
		enableSilverOres = BUILDER.comment("Enable all silver ores. (default: false)").define("enableSilverOres", false);
		enableNickelOres = BUILDER.comment("Enable all nickel ores. (default: false)").define("enableNickelOres", false);
		enableCobaltOres = BUILDER.comment("Enable all cobalt ores. (default: false)").define("enableCobaltOres", false);
		enableIronOres = BUILDER.comment("Enable all iron ores. (default: true)").define("enableIronOres", true);
		enableManganeseOres = BUILDER.comment("Enable all manganese ores. (default: false)").define("enableManganeseOres", false);
		enableChromiumOres = BUILDER.comment("Enable all chromium ores. (default: false)").define("enableChromiumOres", false);
		enableMolybdenumOres = BUILDER.comment("Enable all molybdenum ores. (default: false)").define("enableMolybdenumOres", false);
		enableTungstenOres = BUILDER.comment("Enable all tungsten ores. (default: false)").define("enableTungstenOres", false);
		enableVanadiumOres = BUILDER.comment("Enable all vanadium ores. (default: false)").define("enableVanadiumOres", false);
		enableNiobiumOres = BUILDER.comment("Enable all nionium ores. (default: false)").define("enableNiobiumOres", false);
		enableTantalumOres = BUILDER.comment("Enable all tantalum ores. (default: false)").define("enableTantalumOres", false);
		enableTitaniumOres = BUILDER.comment("Enable all titanium ores. (default: false)").define("enableTitaniumOres", false);
		enableZirconiumOres = BUILDER.comment("Enable all zirconium ores. (default: false)").define("enableZirconiumOres", false);
		enableThoriumOres = BUILDER.comment("Enable all thorium ores. (default: false)").define("enableThoriumOres", false);
		enableUraniumOres = BUILDER.comment("Enable all uranium ores. (default: false)").define("enableUraniumOres", false);
		enableMagnesiumOres = BUILDER.comment("Enable all magnesium ores. (default: false)").define("enableMagnesiumOres", false);
		enableCalciumOres = BUILDER.comment("Enable all calcium ores. Includes gypsum and calcite (limestone). (default: false)").define("enableCalciumOres", false);
		enableStrontiumOres = BUILDER.comment("Enable all strontium ores. (default: false)").define("enableStrontiumOres", false);
		enableLithiumOres = BUILDER.comment("Enable all lithium ores. (default: false)").define("enableLithiumOres", false);
		enableNPKOres = BUILDER.comment("Enable NPK ores (used for making fertilizer). (default: true)").define("enableNPKOres", true);
		enableMithrilOre = BUILDER.comment("Enable mithril ore. (default: false)").define("enableMithrilOre", false);
		enableSaltpetreOre = BUILDER.comment("Enable saltpetre ore. (default: true)").define("enableSaltpetreOre", true);
		enableSaltOre = BUILDER.comment("Enable salt ore. (default: true)").define("enableSaltOre", true);
		enableSomeGems = BUILDER.comment("Enable a few gems ore generation (Sapphire, Ruby, Spinel, Amethyst, Jade, Peridot, Topaz, Tanzanite, Onyx, Opal). (default: false)").define("enableSomeGems", false); 
		enableAllGems = BUILDER.comment("Enable ALL gems. (default: false)").define("enableAllGems", false);
		enablePGMs = BUILDER.comment("Enable commmon platinum-group metals (platinum, iridium, osmium). (default: false)").define("enablePGMs", false);
		enableRarePGMs = BUILDER.comment("Enable rare platinum-group metals (ruthenium, rhodium, palladium). (default: false)").define("enableRarePGMs", false);
		enableREEs = BUILDER.comment("Enable rare-earth elements ores (Bastnasite La, Ce, Y, Nd, Monazite La, Ce, Nd, Samarskite Y, Thortveitite.). (default: false)").define("enableREEs", false);
		BUILDER.pop();


		BUILDER.comment("Vanilla ores generation settings.").push("vanilla");

		BUILDER.comment("If you want vanilla's coal ore to spawn").push("coal");
		enableVanillaCoalOre = BUILDER.comment("Should vanilla coal ore spawn.").define("enableVanillaCoalOre", false);
		VeinSizeCoal = BUILDER.comment("Coal Ore Vein Size").defineInRange("VeinSizeCoalOre", 17, 0, 50);
		VeinsPerChunkCoal = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCoalOre", 20, 0, 50);
		MinHeightCoal = BUILDER.comment("Minimum Height").defineInRange("MinHeightCoalOre", 0, 0, 255);
		MaxHeightCoal = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCoalOre", 128, 0, 255);
		BUILDER.pop();

		BUILDER.comment("If you want vanilla's iron ore to spawn").push("iron");
		enableVanillaIronOre = BUILDER.comment("Should vanilla iron ore spawn.").define("enableVanillaIronOre", false);
		VeinSizeIron = BUILDER.comment("Iron Ore Vein Size").defineInRange("VeinSizeIronOre", 9, 0, 50);
		VeinsPerChunkIron = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkIronOre", 20, 0, 50);
		MinHeightIron = BUILDER.comment("Minimum Height").defineInRange("MinHeightIronOre", 0, 0, 255);
		MaxHeightIron = BUILDER.comment("Maximum Height").defineInRange("MaxHeightIronOre", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("emerald_ore");
		enableEmerald = BUILDER.comment("Enable emerald_ore generation").define("enableEmeraldOre", true);
		BUILDER.pop();

		BUILDER.push("gold_ore");
		enableGold = BUILDER.comment("Enable gold ore generation").define("enableGold", true);
		VeinSizeGold = BUILDER.comment("Vein Size").defineInRange("VeinSizeGold", 9, 0, 50);
		VeinsPerChunkGold = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGold", 2, 0, 50);
		MinHeightGold = BUILDER.comment("Minimum Height").defineInRange("MinHeightGold", 0, 0, 255);
		MaxHeightGold = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGold", 32, 0, 255);
		enableBadlandsGold = BUILDER.comment("Enable additional gold in badlands biomes").define("enableBadlandsGold", true);
		VeinSizeBadlandsGold = BUILDER.comment("Vein Size badlands gold").defineInRange("VeinSizeBadlandsGold", 9, 0, 50);
		VeinsPerChunkBadlandsGold = BUILDER.comment("Veins per chunk badlands gold").defineInRange("VeinsPerChunkBadlandsGold", 20, 0, 50);
		MinHeightBadlandsGold = BUILDER.comment("Minimum Height badlands gold").defineInRange("MinHeightBadlandsGold", 32, 0, 255);
		MaxHeightBadlandsGold = BUILDER.comment("Maximum Height badlands gold").defineInRange("MaxHeightBadlandsGold", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("redstone_ore");
		enableRedstone = BUILDER.comment("Enable redstone ore generation").define("enableRedstone", true);
		VeinSizeRedstone = BUILDER.comment("Vein Size").defineInRange("VeinSizeRedstone", 8, 0, 50);
		VeinsPerChunkRedstone = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRedstone", 8, 0, 50);
		MinHeightRedstone = BUILDER.comment("Minimum Height").defineInRange("MinHeightRedstone", 0, 0, 255);
		MaxHeightRedstone = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRedstone", 16, 0, 255);
		BUILDER.pop();

		BUILDER.push("diamond_ore");
		enableDiamond = BUILDER.comment("Enable diamond ore generation").define("enableDiamond", true);
		VeinSizeDiamond = BUILDER.comment("Vein Size").defineInRange("VeinSizeDiamond", 8, 0, 50);
		VeinsPerChunkDiamond = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkDiamond", 1, 0, 50);
		MinHeightDiamond = BUILDER.comment("Minimum Height").defineInRange("MinHeightDiamond", 0, 0, 255);
		MaxHeightDiamond = BUILDER.comment("Maximum Height").defineInRange("MaxHeightDiamond", 16, 0, 255);
		BUILDER.pop();

		BUILDER.push("lapis_lazuli_ore");
		enableLapis = BUILDER.comment("Enable lapis lazuli ore generation").define("enableLapis", true);
		VeinSizeLapis = BUILDER.comment("Vein Size").defineInRange("VeinSizeLapis", 7, 0, 50);
		VeinsPerChunkLapis = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLapis", 1, 0, 50);
		DepthAverageLapis = BUILDER.comment("Depth average of lapis lazuli ores").defineInRange("DepthAverageLapis", 16, 0, 255);
		BUILDER.pop();

		BUILDER.push("dirt");
		enableDirt = BUILDER.comment("Enable underground dirt pockets generation").define("enableDirt", true);
		VeinSizeDirt = BUILDER.comment("Vein Size").defineInRange("VeinSizeDirt", 33, 0, 50);
		VeinsPerChunkDirt = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkDirt", 10, 0, 50);
		MinHeightDirt = BUILDER.comment("Minimum Height").defineInRange("MinHeightDirt", 0, 0, 255);
		MaxHeightDirt = BUILDER.comment("Maximum Height").defineInRange("MaxHeightDirt", 255, 0, 255);
		BUILDER.pop();

		BUILDER.push("gravel");
		enableGravel = BUILDER.comment("Enable underground gravel generation").define("enableGravel", true);
		VeinSizeGravel = BUILDER.comment("Vein Size").defineInRange("VeinSizeGravel", 33, 0, 50);
		VeinsPerChunkGravel = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGravel", 8, 0, 50);
		MinHeightGravel = BUILDER.comment("Minimum Height").defineInRange("MinHeightGravel", 0, 0, 255);
		MaxHeightGravel = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGravel", 255, 0, 255);
		BUILDER.pop();

		BUILDER.push("granite");
		enableGranite = BUILDER.comment("Enable granite generation").define("enableGranite", true);
		VeinSizeGranite = BUILDER.comment("Vein Size").defineInRange("VeinSizeGranite", 33, 0, 50);
		VeinsPerChunkGranite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGranite", 10, 0, 50);
		MinHeightGranite = BUILDER.comment("Minimum Height").defineInRange("MinHeightGranite", 10, 0, 255);
		MaxHeightGranite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGranite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("diorite");
		enableDiorite = BUILDER.comment("Enable diorite generation").define("enableDiorite", true);
		VeinSizeDiorite = BUILDER.comment("Vein Size").defineInRange("VeinSizeDiorite", 33, 0, 50);
		VeinsPerChunkDiorite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkDiorite", 10, 0, 50);
		MinHeightDiorite = BUILDER.comment("Minimum Height").defineInRange("MinHeightDiorite", 10, 0, 255);
		MaxHeightDiorite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightDiorite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("andesite");
		enableAndesite = BUILDER.comment("Enable andesite generation").define("enableAndesite", true);
		VeinSizeAndesite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAndesite", 33, 0, 50);
		VeinsPerChunkAndesite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAndesite", 10, 0, 50);
		MinHeightAndesite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAndesite", 10, 0, 255);
		MaxHeightAndesite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAndesite", 80, 0, 255);
		BUILDER.pop();	

		BUILDER.push("infested_stone");
		enableInfestedStone = BUILDER.comment("Enable infested stone generation").define("enableInfestedStone", true);
		VeinSizeInfestedStone  = BUILDER.comment("Vein Size").defineInRange("VeinSizeInfestedStone", 9, 0, 50);
		VeinsPerChunkInfestedStone = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkInfestedStone", 7, 0, 50);
		MinHeightInfestedStone = BUILDER.comment("Minimum Height").defineInRange("MinHeightInfestedStone", 0, 0, 255);
		MaxHeightInfestedStone = BUILDER.comment("Maximum Height").defineInRange("MaxHeightInfestedStone", 64, 0, 255);		
		BUILDER.pop();

		BUILDER.pop();


		BUILDER.comment("Expert overworld generation settings").push("overworldExpert");		

		BUILDER.push("pyrite");
		enablePyrite = BUILDER.comment("Enable pyrite generation").define("enablePyrite", false);
		VeinSizePyrite = BUILDER.comment("Vein Size").defineInRange("VeinSizePyrite", 6, 0, 50);
		VeinsPerChunkPyrite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPyrite", 2, 0, 50);
		MinHeightPyrite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPyrite", 30, 0, 255);
		MaxHeightPyrite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPyrite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("sulphur");
		enableSulphur = BUILDER.comment("Enable sulphur generation").define("enableSulphur", false);
		VeinSizeSulphur = BUILDER.comment("Vein Size").defineInRange("VeinSizeSulphur", 6, 0, 50);
		VeinsPerChunkSulphur = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSulphur", 2, 0, 50);
		MinHeightSulphur = BUILDER.comment("Minimum Height").defineInRange("MinHeightSulphur", 40, 0, 255);
		MaxHeightSulphur = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSulphur", 255, 0, 255);
		BUILDER.pop();

		BUILDER.push("clausthalite");
		enableClausthalite = BUILDER.comment("Enable clausthalite generation").define("enableClausthalite", false);
		VeinSizeClausthalite = BUILDER.comment("Vein Size").defineInRange("VeinSizeClausthalite", 6, 0, 50);
		VeinsPerChunkClausthalite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkClausthalite", 8, 0, 50);
		MinHeightClausthalite = BUILDER.comment("Minimum Height").defineInRange("MinHeightClausthalite", 30, 0, 255);
		MaxHeightClausthalite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightClausthalite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("guano");
		enableGuano = BUILDER.comment("Enable guano generation").define("enableGuano", false);
		VeinSizeGuano = BUILDER.comment("Vein Size").defineInRange("VeinSizeGuano", 7, 0, 50);
		VeinsPerChunkGuano = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGuano", 5, 0, 50);
		MinHeightGuano = BUILDER.comment("Minimum Height").defineInRange("MinHeightGuano", 40, 0, 255);
		MaxHeightGuano = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGuano", 255, 0, 255);
		BUILDER.pop();

		BUILDER.push("phosphorite");
		enablePhosphorite = BUILDER.comment("Enable phosphorite generation").define("enablePhosphorite", false);
		VeinSizePhosphorite = BUILDER.comment("Vein Size").defineInRange("VeinSizePhosphorite", 7, 0, 50);
		VeinsPerChunkPhosphorite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPhosphorite", 5, 0, 50);
		MinHeightPhosphorite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPhosphorite", 40, 0, 255);
		MaxHeightPhosphorite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPhosphorite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("peat");
		enablePeat = BUILDER.comment("Enable peat generation").define("enablePeat", false);
		VeinSizePeat = BUILDER.comment("Vein Size").defineInRange("VeinSizePeat", 9, 0, 50);
		VeinsPerChunkPeat = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPeat", 3, 0, 50);
		MinHeightPeat = BUILDER.comment("Minimum Height").defineInRange("MinHeightPeat", 50, 0, 255);
		MaxHeightPeat = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPeat", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("lignite_ore");
		enableLignite_ore = BUILDER.comment("Enable lignite ore generation").define("enableLignite_ore", false);
		VeinSizeLignite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeLignite_ore", 15, 0, 50);
		VeinsPerChunkLignite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLignite_ore", 7, 0, 50);
		MinHeightLignite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightLignite_ore", 5, 0, 255);
		MaxHeightLignite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightLignite_ore", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("bituminous_coal_ore");
		enableBituminous_coal_ore = BUILDER.comment("Enable bituminous coal ore generation").define("enableBituminous_coal_ore", false);
		VeinSizeBituminous_coal_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeBituminous_coal_ore", 14, 0, 50);
		VeinsPerChunkBituminous_coal_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBituminous_coal_ore", 7, 0, 50);
		MinHeightBituminous_coal_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightBituminous_coal_ore", 5, 0, 255);
		MaxHeightBituminous_coal_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBituminous_coal_ore", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("anthracite_ore");
		enableAnthracite_ore = BUILDER.comment("Enable anthracite ore generation").define("enableAnthracite_ore", false);
		VeinSizeAnthracite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAnthracite_ore", 12, 0, 50);
		VeinsPerChunkAnthracite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAnthracite_ore", 6, 0, 50);
		MinHeightAnthracite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAnthracite_ore", 5, 0, 255);
		MaxHeightAnthracite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAnthracite_ore", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("graphite");
		enableGraphite = BUILDER.comment("Enable graphite generation").define("enableGraphite", false);
		VeinSizeGraphite = BUILDER.comment("Vein Size").defineInRange("VeinSizeGraphite", 6, 0, 50);
		VeinsPerChunkGraphite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGraphite", 6, 0, 50);
		MinHeightGraphite = BUILDER.comment("Minimum Height").defineInRange("MinHeightGraphite", 5, 0, 255);
		MaxHeightGraphite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGraphite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("lollingite");
		enableLollingite = BUILDER.comment("Enable lollingite generation").define("enableLollingite", false);
		VeinSizeLollingite = BUILDER.comment("Vein Size").defineInRange("VeinSizeLollingite", 6, 0, 50);
		VeinsPerChunkLollingite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLollingite", 6, 0, 50);
		MinHeightLollingite = BUILDER.comment("Minimum Height").defineInRange("MinHeightLollingite", 5, 0, 255);
		MaxHeightLollingite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightLollingite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("realgar");
		enableRealgar = BUILDER.comment("Enable realgar generation").define("enableRealgar", false);
		VeinSizeRealgar = BUILDER.comment("Vein Size").defineInRange("VeinSizeRealgar", 6, 0, 50);
		VeinsPerChunkRealgar = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRealgar", 6, 0, 50);
		MinHeightRealgar = BUILDER.comment("Minimum Height").defineInRange("MinHeightRealgar", 5, 0, 255);
		MaxHeightRealgar = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRealgar", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("orpiment");
		enableOrpiment = BUILDER.comment("Enable orpiment generation").define("enableOrpiment", false);
		VeinSizeOrpiment = BUILDER.comment("Vein Size").defineInRange("VeinSizeOrpiment", 6, 0, 50);
		VeinsPerChunkOrpiment = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkOrpiment", 6, 0, 50);
		MinHeightOrpiment = BUILDER.comment("Minimum Height").defineInRange("MinHeightOrpiment", 5, 0, 255);
		MaxHeightOrpiment = BUILDER.comment("Maximum Height").defineInRange("MaxHeightOrpiment", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("arsenopyrite");
		enableArsenopyrite = BUILDER.comment("Enable arsenopyrite generation").define("enableArsenopyrite", false);
		VeinSizeArsenopyrite = BUILDER.comment("Vein Size").defineInRange("VeinSizeArsenopyrite", 6, 0, 50);
		VeinsPerChunkArsenopyrite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkArsenopyrite", 6, 0, 50);
		MinHeightArsenopyrite = BUILDER.comment("Minimum Height").defineInRange("MinHeightArsenopyrite", 5, 0, 255);
		MaxHeightArsenopyrite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightArsenopyrite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("stibnite");
		enableStibnite = BUILDER.comment("Enable stibnite generation").define("enableStibnite", false);
		VeinSizeStibnite = BUILDER.comment("Vein Size").defineInRange("VeinSizeStibnite", 5, 0, 50);
		VeinsPerChunkStibnite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkStibnite", 5, 0, 50);
		MinHeightStibnite = BUILDER.comment("Minimum Height").defineInRange("MinHeightStibnite", 5, 0, 255);
		MaxHeightStibnite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightStibnite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("germanite");
		enableGermanite = BUILDER.comment("Enable germanite generation").define("enableGermanite", false);
		VeinSizeGermanite = BUILDER.comment("Vein Size").defineInRange("VeinSizeGermanite", 5, 0, 50);
		VeinsPerChunkGermanite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGermanite", 4, 0, 50);
		MinHeightGermanite = BUILDER.comment("Minimum Height").defineInRange("MinHeightGermanite", 20, 0, 255);
		MaxHeightGermanite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGermanite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("argutite");
		enableArgutite = BUILDER.comment("Enable argutite generation").define("enableArgutite", false);
		VeinSizeArgutite = BUILDER.comment("Vein Size").defineInRange("VeinSizeArgutite", 4, 0, 50);
		VeinsPerChunkArgutite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkArgutite", 3, 0, 50);
		MinHeightArgutite = BUILDER.comment("Minimum Height").defineInRange("MinHeightArgutite", 20, 0, 255);
		MaxHeightArgutite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightArgutite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("bismuthinite");
		enableBismuthinite = BUILDER.comment("Enable bismuthinite generation").define("enableBismuthinite", false);
		VeinSizeBismuthinite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBismuthinite", 6, 0, 50);
		VeinsPerChunkBismuthinite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBismuthinite", 4, 0, 50);
		MinHeightBismuthinite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBismuthinite", 20, 0, 255);
		MaxHeightBismuthinite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBismuthinite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("native_bismuth");
		enableNative_bismuth = BUILDER.comment("Enable native bismuth generation").define("enableNative_bismuth", false);
		VeinSizeNative_bismuth = BUILDER.comment("Vein Size").defineInRange("VeinSizeNative_bismuth", 3, 0, 50);
		VeinsPerChunkNative_bismuth = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNative_bismuth", 3, 0, 50);
		MinHeightNative_bismuth = BUILDER.comment("Minimum Height").defineInRange("MinHeightNative_bismuth", 20, 0, 255);
		MaxHeightNative_bismuth = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNative_bismuth", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("bismite");
		enableBismite = BUILDER.comment("Enable bismite generation").define("enableBismite", false);
		VeinSizeBismite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBismite", 6, 0, 50);
		VeinsPerChunkBismite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBismite", 3, 0, 50);
		MinHeightBismite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBismite", 20, 0, 255);
		MaxHeightBismite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBismite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("cassiterite");
		enableCassiterite = BUILDER.comment("Enable cassiterite generation").define("enableCassiterite", false);
		VeinSizeCassiterite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCassiterite", 8, 0, 50);
		VeinsPerChunkCassiterite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCassiterite", 6, 0, 50);
		MinHeightCassiterite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCassiterite", 20, 0, 255);
		MaxHeightCassiterite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCassiterite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("teallite");
		enableTeallite = BUILDER.comment("Enable teallite generation").define("enableTeallite", false);
		VeinSizeTeallite = BUILDER.comment("Vein Size").defineInRange("VeinSizeTeallite", 6, 0, 50);
		VeinsPerChunkTeallite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTeallite", 3, 0, 50);
		MinHeightTeallite = BUILDER.comment("Minimum Height").defineInRange("MinHeightTeallite", 20, 0, 255);
		MaxHeightTeallite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTeallite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("stannite");
		enableStannite = BUILDER.comment("Enable stannite generation").define("enableStannite", false);
		VeinSizeStannite = BUILDER.comment("Vein Size").defineInRange("VeinSizeStannite", 6, 0, 50);
		VeinsPerChunkStannite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkStannite", 6, 0, 50);
		MinHeightStannite = BUILDER.comment("Minimum Height").defineInRange("MinHeightStannite", 20, 0, 255);
		MaxHeightStannite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightStannite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("native_tin");
		enableNative_tin = BUILDER.comment("Enable native tin generation").define("enableNative_tin", false);
		VeinSizeNative_tin = BUILDER.comment("Vein Size").defineInRange("VeinSizeNative_tin", 4, 0, 50);
		VeinsPerChunkNative_tin = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNative_tin", 2, 0, 50);
		MinHeightNative_tin = BUILDER.comment("Minimum Height").defineInRange("MinHeightNative_tin", 20, 0, 255);
		MaxHeightNative_tin = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNative_tin", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("kesterite");
		enableKesterite = BUILDER.comment("Enable kesterite generation").define("enableKesterite", false);
		VeinSizeKesterite = BUILDER.comment("Vein Size").defineInRange("VeinSizeKesterite", 5, 0, 50);
		VeinsPerChunkKesterite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkKesterite", 1, 0, 50);
		MinHeightKesterite = BUILDER.comment("Minimum Height").defineInRange("MinHeightKesterite", 20, 0, 255);
		MaxHeightKesterite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightKesterite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("galena");
		enableGalena = BUILDER.comment("Enable galena generation").define("enableGalena", false);
		VeinSizeGalena = BUILDER.comment("Vein Size").defineInRange("VeinSizeGalena", 5, 0, 50);
		VeinsPerChunkGalena = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGalena", 3, 0, 50);
		MinHeightGalena = BUILDER.comment("Minimum Height").defineInRange("MinHeightGalena", 30, 0, 255);
		MaxHeightGalena = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGalena", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("cerussite");
		enableCerussite = BUILDER.comment("Enable cerussite generation").define("enableCerussite", false);
		VeinSizeCerussite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCerussite", 5, 0, 50);
		VeinsPerChunkCerussite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCerussite", 3, 0, 50);
		MinHeightCerussite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCerussite", 30, 0, 255);
		MaxHeightCerussite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCerussite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("anglesite");
		enableAnglesite = BUILDER.comment("Enable anglesite generation").define("enableAnglesite", false);
		VeinSizeAnglesite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAnglesite", 5, 0, 50);
		VeinsPerChunkAnglesite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAnglesite", 3, 0, 50);
		MinHeightAnglesite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAnglesite", 30, 0, 255);
		MaxHeightAnglesite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAnglesite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("boulangerite");
		enableBoulangerite = BUILDER.comment("Enable boulangerite generation").define("enableBoulangerite", false);
		VeinSizeBoulangerite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBoulangerite", 5, 0, 50);
		VeinsPerChunkBoulangerite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBoulangerite", 3, 0, 50);
		MinHeightBoulangerite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBoulangerite", 30, 0, 255);
		MaxHeightBoulangerite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBoulangerite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("pyromorphite");
		enablePyromorphite = BUILDER.comment("Enable pyromorphite generation").define("enablePyromorphite", false);
		VeinSizePyromorphite = BUILDER.comment("Vein Size").defineInRange("VeinSizePyromorphite", 5, 0, 50);
		VeinsPerChunkPyromorphite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPyromorphite", 3, 0, 50);
		MinHeightPyromorphite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPyromorphite", 30, 0, 255);
		MaxHeightPyromorphite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPyromorphite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("bauxite");
		enableBauxite = BUILDER.comment("Enable bauxite generation").define("enableBauxite", false);
		VeinSizeBauxite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBauxite", 8, 0, 50);
		VeinsPerChunkBauxite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBauxite", 3, 0, 50);
		MinHeightBauxite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBauxite", 20, 0, 255);
		MaxHeightBauxite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBauxite", 75, 0, 255);
		BUILDER.pop();

		BUILDER.push("nepheline");
		enableNepheline = BUILDER.comment("Enable nepheline generation").define("enableNepheline", false);
		VeinSizeNepheline = BUILDER.comment("Vein Size").defineInRange("VeinSizeNepheline", 6, 0, 50);
		VeinsPerChunkNepheline = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNepheline", 3, 0, 50);
		MinHeightNepheline = BUILDER.comment("Minimum Height").defineInRange("MinHeightNepheline", 20, 0, 255);
		MaxHeightNepheline = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNepheline", 75, 0, 255);
		BUILDER.pop();

		BUILDER.push("leucite");
		enableLeucite = BUILDER.comment("Enable leucite generation").define("enableLeucite", false);
		VeinSizeLeucite = BUILDER.comment("Vein Size").defineInRange("VeinSizeLeucite", 6, 0, 50);
		VeinsPerChunkLeucite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLeucite", 3, 0, 50);
		MinHeightLeucite = BUILDER.comment("Minimum Height").defineInRange("MinHeightLeucite", 20, 0, 255);
		MaxHeightLeucite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightLeucite", 75, 0, 255);
		BUILDER.pop();

		BUILDER.push("sphalerite");
		enableSphalerite = BUILDER.comment("Enable sphalerite generation").define("enableSphalerite", false);
		VeinSizeSphalerite = BUILDER.comment("Vein Size").defineInRange("VeinSizeSphalerite", 6, 0, 50);
		VeinsPerChunkSphalerite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSphalerite", 2, 0, 50);
		MinHeightSphalerite = BUILDER.comment("Minimum Height").defineInRange("MinHeightSphalerite", 20, 0, 255);
		MaxHeightSphalerite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSphalerite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("smithsonite");
		enableSmithsonite = BUILDER.comment("Enable smithsonite generation").define("enableSmithsonite", false);
		VeinSizeSmithsonite = BUILDER.comment("Vein Size").defineInRange("VeinSizeSmithsonite", 6, 0, 50);
		VeinsPerChunkSmithsonite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSmithsonite", 2, 0, 50);
		MinHeightSmithsonite = BUILDER.comment("Minimum Height").defineInRange("MinHeightSmithsonite", 20, 0, 255);
		MaxHeightSmithsonite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSmithsonite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("hemimorphite");
		enableHemimorphite = BUILDER.comment("Enable hemimorphite generation").define("enableHemimorphite", false);
		VeinSizeHemimorphite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHemimorphite", 5, 0, 50);
		VeinsPerChunkHemimorphite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHemimorphite", 2, 0, 50);
		MinHeightHemimorphite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHemimorphite", 20, 0, 255);
		MaxHeightHemimorphite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHemimorphite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("franklinite");
		enableFranklinite = BUILDER.comment("Enable franklinite generation").define("enableFranklinite", false);
		VeinSizeFranklinite = BUILDER.comment("Vein Size").defineInRange("VeinSizeFranklinite", 5, 0, 50);
		VeinsPerChunkFranklinite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkFranklinite", 2, 0, 50);
		MinHeightFranklinite = BUILDER.comment("Minimum Height").defineInRange("MinHeightFranklinite", 20, 0, 255);
		MaxHeightFranklinite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightFranklinite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("zincite");
		enableZincite = BUILDER.comment("Enable zincite generation").define("enableZincite", false);
		VeinSizeZincite = BUILDER.comment("Vein Size").defineInRange("VeinSizeZincite", 6, 0, 50);
		VeinsPerChunkZincite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkZincite", 2, 0, 50);
		MinHeightZincite = BUILDER.comment("Minimum Height").defineInRange("MinHeightZincite", 20, 0, 255);
		MaxHeightZincite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightZincite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("hydrozincite");
		enableHydrozincite = BUILDER.comment("Enable hydrozincite generation").define("enableHydrozincite", false);
		VeinSizeHydrozincite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHydrozincite", 5, 0, 50);
		VeinsPerChunkHydrozincite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHydrozincite", 1, 0, 50);
		MinHeightHydrozincite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHydrozincite", 20, 0, 255);
		MaxHeightHydrozincite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHydrozincite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("otavite");
		enableOtavite = BUILDER.comment("Enable otavite generation").define("enableOtavite", false);
		VeinSizeOtavite = BUILDER.comment("Vein Size").defineInRange("VeinSizeOtavite", 7, 0, 50);
		VeinsPerChunkOtavite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkOtavite", 2, 0, 50);
		MinHeightOtavite = BUILDER.comment("Minimum Height").defineInRange("MinHeightOtavite", 20, 0, 255);
		MaxHeightOtavite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightOtavite", 45, 0, 255);
		BUILDER.pop();

		BUILDER.push("greenockite");
		enableGreenockite = BUILDER.comment("Enable greenockite generation").define("enableGreenockite", false);
		VeinSizeGreenockite = BUILDER.comment("Vein Size").defineInRange("VeinSizeGreenockite", 7, 0, 50);
		VeinsPerChunkGreenockite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGreenockite", 2, 0, 50);
		MinHeightGreenockite = BUILDER.comment("Minimum Height").defineInRange("MinHeightGreenockite", 20, 0, 255);
		MaxHeightGreenockite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGreenockite", 45, 0, 255);
		BUILDER.pop();

		BUILDER.push("cinnabar");
		enableCinnabar = BUILDER.comment("Enable cinnabar generation").define("enableCinnabar", false);
		VeinSizeCinnabar = BUILDER.comment("Vein Size").defineInRange("VeinSizeCinnabar", 6, 0, 50);
		VeinsPerChunkCinnabar = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCinnabar", 4, 0, 50);
		MinHeightCinnabar = BUILDER.comment("Minimum Height").defineInRange("MinHeightCinnabar", 30, 0, 255);
		MaxHeightCinnabar = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCinnabar", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("native_copper");
		enableNative_copper = BUILDER.comment("Enable native copper generation").define("enableNative_copper", false);
		VeinSizeNative_copper = BUILDER.comment("Vein Size").defineInRange("VeinSizeNative_copper", 5, 0, 50);
		VeinsPerChunkNative_copper = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNative_copper", 2, 0, 50);
		MinHeightNative_copper = BUILDER.comment("Minimum Height").defineInRange("MinHeightNative_copper", 30, 0, 255);
		MaxHeightNative_copper = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNative_copper", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("chalcopyrite");
		enableChalcopyrite = BUILDER.comment("Enable chalcopyrite generation").define("enableChalcopyrite", false);
		VeinSizeChalcopyrite = BUILDER.comment("Vein Size").defineInRange("VeinSizeChalcopyrite", 9, 0, 50);
		VeinsPerChunkChalcopyrite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkChalcopyrite", 3, 0, 50);
		MinHeightChalcopyrite = BUILDER.comment("Minimum Height").defineInRange("MinHeightChalcopyrite", 30, 0, 255);
		MaxHeightChalcopyrite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightChalcopyrite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("chalcocite");
		enableChalcocite = BUILDER.comment("Enable chalcocite generation").define("enableChalcocite", false);
		VeinSizeChalcocite = BUILDER.comment("Vein Size").defineInRange("VeinSizeChalcocite", 8, 0, 50);
		VeinsPerChunkChalcocite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkChalcocite", 2, 0, 50);
		MinHeightChalcocite = BUILDER.comment("Minimum Height").defineInRange("MinHeightChalcocite", 30, 0, 255);
		MaxHeightChalcocite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightChalcocite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("bornite");
		enableBornite = BUILDER.comment("Enable bornite generation").define("enableBornite", false);
		VeinSizeBornite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBornite", 7, 0, 50);
		VeinsPerChunkBornite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBornite", 2, 0, 50);
		MinHeightBornite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBornite", 30, 0, 255);
		MaxHeightBornite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBornite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("enargite");
		enableEnargite = BUILDER.comment("Enable enargite generation").define("enableEnargite", false);
		VeinSizeEnargite = BUILDER.comment("Vein Size").defineInRange("VeinSizeEnargite", 4, 0, 50);
		VeinsPerChunkEnargite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkEnargite", 3, 0, 50);
		MinHeightEnargite = BUILDER.comment("Minimum Height").defineInRange("MinHeightEnargite", 30, 0, 255);
		MaxHeightEnargite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightEnargite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("tennantite");
		enableTennantite = BUILDER.comment("Enable tennantite generation").define("enableTennantite", false);
		VeinSizeTennantite = BUILDER.comment("Vein Size").defineInRange("VeinSizeTennantite", 5, 0, 50);
		VeinsPerChunkTennantite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTennantite", 2, 0, 50);
		MinHeightTennantite = BUILDER.comment("Minimum Height").defineInRange("MinHeightTennantite", 30, 0, 255);
		MaxHeightTennantite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTennantite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("tetrahedrite");
		enableTetrahedrite = BUILDER.comment("Enable tetrahedrite generation").define("enableTetrahedrite", false);
		VeinSizeTetrahedrite = BUILDER.comment("Vein Size").defineInRange("VeinSizeTetrahedrite", 6, 0, 50);
		VeinsPerChunkTetrahedrite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTetrahedrite", 2, 0, 50);
		MinHeightTetrahedrite = BUILDER.comment("Minimum Height").defineInRange("MinHeightTetrahedrite", 30, 0, 255);
		MaxHeightTetrahedrite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTetrahedrite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("covellite");
		enableCovellite = BUILDER.comment("Enable covellite generation").define("enableCovellite", false);
		VeinSizeCovellite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCovellite", 5, 0, 50);
		VeinsPerChunkCovellite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCovellite", 2, 0, 50);
		MinHeightCovellite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCovellite", 30, 0, 255);
		MaxHeightCovellite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCovellite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("azurite");
		enableAzurite = BUILDER.comment("Enable azurite generation").define("enableAzurite", false);
		VeinSizeAzurite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAzurite", 6, 0, 50);
		VeinsPerChunkAzurite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAzurite", 2, 0, 50);
		MinHeightAzurite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAzurite", 30, 0, 255);
		MaxHeightAzurite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAzurite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("malachite");
		enableMalachite = BUILDER.comment("Enable malachite generation").define("enableMalachite", false);
		VeinSizeMalachite = BUILDER.comment("Vein Size").defineInRange("VeinSizeMalachite", 8, 0, 50);
		VeinsPerChunkMalachite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMalachite", 3, 0, 50);
		MinHeightMalachite = BUILDER.comment("Minimum Height").defineInRange("MinHeightMalachite", 30, 0, 255);
		MaxHeightMalachite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMalachite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("cuprite");
		enableCuprite = BUILDER.comment("Enable cuprite generation").define("enableCuprite", false);
		VeinSizeCuprite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCuprite", 6, 0, 50);
		VeinsPerChunkCuprite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCuprite", 2, 0, 50);
		MinHeightCuprite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCuprite", 30, 0, 255);
		MaxHeightCuprite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCuprite", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("native_silver");
		enableNative_silver = BUILDER.comment("Enable native silver generation").define("enableNative_silver", false);
		VeinSizeNative_silver = BUILDER.comment("Vein Size").defineInRange("VeinSizeNative_silver", 7, 0, 50);
		VeinsPerChunkNative_silver = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNative_silver", 2, 0, 50);
		MinHeightNative_silver = BUILDER.comment("Minimum Height").defineInRange("MinHeightNative_silver", 10, 0, 255);
		MaxHeightNative_silver = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNative_silver", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("acanthite");
		enableAcanthite = BUILDER.comment("Enable acanthite generation").define("enableAcanthite", false);
		VeinSizeAcanthite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAcanthite", 6, 0, 50);
		VeinsPerChunkAcanthite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAcanthite", 2, 0, 50);
		MinHeightAcanthite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAcanthite", 10, 0, 255);
		MaxHeightAcanthite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAcanthite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("stephanite");
		enableStephanite = BUILDER.comment("Enable stephanite generation").define("enableStephanite", false);
		VeinSizeStephanite = BUILDER.comment("Vein Size").defineInRange("VeinSizeStephanite", 6, 0, 50);
		VeinsPerChunkStephanite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkStephanite", 2, 0, 50);
		MinHeightStephanite = BUILDER.comment("Minimum Height").defineInRange("MinHeightStephanite", 10, 0, 255);
		MaxHeightStephanite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightStephanite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("proustite");
		enableProustite = BUILDER.comment("Enable proustite generation").define("enableProustite", false);
		VeinSizeProustite = BUILDER.comment("Vein Size").defineInRange("VeinSizeProustite", 9, 0, 50);
		VeinsPerChunkProustite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkProustite", 2, 0, 50);
		MinHeightProustite = BUILDER.comment("Minimum Height").defineInRange("MinHeightProustite", 10, 0, 255);
		MaxHeightProustite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightProustite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("freibergite");
		enableFreibergite = BUILDER.comment("Enable freibergite generation").define("enableFreibergite", false);
		VeinSizeFreibergite = BUILDER.comment("Vein Size").defineInRange("VeinSizeFreibergite", 6, 0, 50);
		VeinsPerChunkFreibergite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkFreibergite", 2, 0, 50);
		MinHeightFreibergite = BUILDER.comment("Minimum Height").defineInRange("MinHeightFreibergite", 10, 0, 255);
		MaxHeightFreibergite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightFreibergite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("nickeline");
		enableNickeline = BUILDER.comment("Enable nickeline generation").define("enableNickeline", false);
		VeinSizeNickeline = BUILDER.comment("Vein Size").defineInRange("VeinSizeNickeline", 7, 0, 50);
		VeinsPerChunkNickeline = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNickeline", 2, 0, 50);
		MinHeightNickeline = BUILDER.comment("Minimum Height").defineInRange("MinHeightNickeline", 20, 0, 255);
		MaxHeightNickeline = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNickeline", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("pentlandite");
		enablePentlandite = BUILDER.comment("Enable pentlandite generation").define("enablePentlandite", false);
		VeinSizePentlandite = BUILDER.comment("Vein Size").defineInRange("VeinSizePentlandite", 6, 0, 50);
		VeinsPerChunkPentlandite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPentlandite", 2, 0, 50);
		MinHeightPentlandite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPentlandite", 20, 0, 255);
		MaxHeightPentlandite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPentlandite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("nepouite");
		enableNepouite = BUILDER.comment("Enable nepouite generation").define("enableNepouite", false);
		VeinSizeNepouite = BUILDER.comment("Vein Size").defineInRange("VeinSizeNepouite", 7, 0, 50);
		VeinsPerChunkNepouite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNepouite", 2, 0, 50);
		MinHeightNepouite = BUILDER.comment("Minimum Height").defineInRange("MinHeightNepouite", 20, 0, 255);
		MaxHeightNepouite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNepouite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("millerite");
		enableMillerite = BUILDER.comment("Enable millerite generation").define("enableMillerite", false);
		VeinSizeMillerite = BUILDER.comment("Vein Size").defineInRange("VeinSizeMillerite", 6, 0, 50);
		VeinsPerChunkMillerite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMillerite", 2, 0, 50);
		MinHeightMillerite = BUILDER.comment("Minimum Height").defineInRange("MinHeightMillerite", 20, 0, 255);
		MaxHeightMillerite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMillerite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("gersdorffite");
		enableGersdorffite = BUILDER.comment("Enable gersdorffite generation").define("enableGersdorffite", false);
		VeinSizeGersdorffite = BUILDER.comment("Vein Size").defineInRange("VeinSizeGersdorffite", 6, 0, 50);
		VeinsPerChunkGersdorffite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGersdorffite", 2, 0, 50);
		MinHeightGersdorffite = BUILDER.comment("Minimum Height").defineInRange("MinHeightGersdorffite", 20, 0, 255);
		MaxHeightGersdorffite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGersdorffite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("cobaltite");
		enableCobaltite = BUILDER.comment("Enable cobaltite generation").define("enableCobaltite", false);
		VeinSizeCobaltite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCobaltite", 6, 0, 50);
		VeinsPerChunkCobaltite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCobaltite", 6, 0, 50);
		MinHeightCobaltite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCobaltite", 5, 0, 255);
		MaxHeightCobaltite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCobaltite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("carrollite");
		enableCarrollite = BUILDER.comment("Enable carrollite generation").define("enableCarrollite", false);
		VeinSizeCarrollite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCarrollite", 6, 0, 50);
		VeinsPerChunkCarrollite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCarrollite", 4, 0, 50);
		MinHeightCarrollite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCarrollite", 5, 0, 255);
		MaxHeightCarrollite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCarrollite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("skutterudite");
		enableSkutterudite = BUILDER.comment("Enable skutterudite generation").define("enableSkutterudite", false);
		VeinSizeSkutterudite = BUILDER.comment("Vein Size").defineInRange("VeinSizeSkutterudite", 6, 0, 50);
		VeinsPerChunkSkutterudite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSkutterudite", 4, 0, 50);
		MinHeightSkutterudite = BUILDER.comment("Minimum Height").defineInRange("MinHeightSkutterudite", 5, 0, 255);
		MaxHeightSkutterudite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSkutterudite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("hematite");
		enableHematite = BUILDER.comment("Enable hematite generation").define("enableHematite", false);
		VeinSizeHematite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHematite", 9, 0, 50);
		VeinsPerChunkHematite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHematite", 5, 0, 50);
		MinHeightHematite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHematite", 5, 0, 255);
		MaxHeightHematite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHematite", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("magnetite");
		enableMagnetite = BUILDER.comment("Enable magnetite generation").define("enableMagnetite", false);
		VeinSizeMagnetite = BUILDER.comment("Vein Size").defineInRange("VeinSizeMagnetite", 9, 0, 50);
		VeinsPerChunkMagnetite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMagnetite", 5, 0, 50);
		MinHeightMagnetite = BUILDER.comment("Minimum Height").defineInRange("MinHeightMagnetite", 5, 0, 255);
		MaxHeightMagnetite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMagnetite", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("limonite");
		enableLimonite = BUILDER.comment("Enable limonite generation").define("enableLimonite", false);
		VeinSizeLimonite = BUILDER.comment("Vein Size").defineInRange("VeinSizeLimonite", 9, 0, 50);
		VeinsPerChunkLimonite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLimonite", 5, 0, 50);
		MinHeightLimonite = BUILDER.comment("Minimum Height").defineInRange("MinHeightLimonite", 5, 0, 255);
		MaxHeightLimonite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightLimonite", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("siderite");
		enableSiderite = BUILDER.comment("Enable siderite generation").define("enableSiderite", false);
		VeinSizeSiderite = BUILDER.comment("Vein Size").defineInRange("VeinSizeSiderite", 9, 0, 50);
		VeinsPerChunkSiderite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSiderite", 5, 0, 50);
		MinHeightSiderite = BUILDER.comment("Minimum Height").defineInRange("MinHeightSiderite", 5, 0, 255);
		MaxHeightSiderite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSiderite", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("telluric_iron");
		enableTelluric_iron = BUILDER.comment("Enable telluric iron generation").define("enableTelluric_iron", false);
		VeinSizeTelluric_iron = BUILDER.comment("Vein Size").defineInRange("VeinSizeTelluric_iron", 1, 0, 50);
		VeinsPerChunkTelluric_iron = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTelluric_iron", 1, 0, 50);
		MinHeightTelluric_iron = BUILDER.comment("Minimum Height").defineInRange("MinHeightTelluric_iron", 5, 0, 255);
		MaxHeightTelluric_iron = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTelluric_iron", 64, 0, 255);
		BUILDER.pop();

		BUILDER.push("pyrolusite");
		enablePyrolusite = BUILDER.comment("Enable pyrolusite generation").define("enablePyrolusite", false);
		VeinSizePyrolusite = BUILDER.comment("Vein Size").defineInRange("VeinSizePyrolusite", 8, 0, 50);
		VeinsPerChunkPyrolusite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPyrolusite", 2, 0, 50);
		MinHeightPyrolusite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPyrolusite", 30, 0, 255);
		MaxHeightPyrolusite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPyrolusite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("rhodochrosite");
		enableRhodochrosite = BUILDER.comment("Enable rhodochrosite generation").define("enableRhodochrosite", false);
		VeinSizeRhodochrosite = BUILDER.comment("Vein Size").defineInRange("VeinSizeRhodochrosite", 7, 0, 50);
		VeinsPerChunkRhodochrosite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRhodochrosite", 1, 0, 50);
		MinHeightRhodochrosite = BUILDER.comment("Minimum Height").defineInRange("MinHeightRhodochrosite", 30, 0, 255);
		MaxHeightRhodochrosite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRhodochrosite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("hollandite");
		enableHollandite = BUILDER.comment("Enable hollandite generation").define("enableHollandite", false);
		VeinSizeHollandite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHollandite", 7, 0, 50);
		VeinsPerChunkHollandite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHollandite", 1, 0, 50);
		MinHeightHollandite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHollandite", 30, 0, 255);
		MaxHeightHollandite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHollandite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("manganite");
		enableManganite = BUILDER.comment("Enable manganite generation").define("enableManganite", false);
		VeinSizeManganite = BUILDER.comment("Vein Size").defineInRange("VeinSizeManganite", 7, 0, 50);
		VeinsPerChunkManganite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkManganite", 1, 0, 50);
		MinHeightManganite = BUILDER.comment("Minimum Height").defineInRange("MinHeightManganite", 30, 0, 255);
		MaxHeightManganite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightManganite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("hausmannite");
		enableHausmannite = BUILDER.comment("Enable hausmannite generation").define("enableHausmannite", false);
		VeinSizeHausmannite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHausmannite", 7, 0, 50);
		VeinsPerChunkHausmannite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHausmannite", 1, 0, 50);
		MinHeightHausmannite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHausmannite", 30, 0, 255);
		MaxHeightHausmannite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHausmannite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("alabandite");
		enableAlabandite = BUILDER.comment("Enable alabandite generation").define("enableAlabandite", false);
		VeinSizeAlabandite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAlabandite", 7, 0, 50);
		VeinsPerChunkAlabandite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAlabandite", 1, 0, 50);
		MinHeightAlabandite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAlabandite", 30, 0, 255);
		MaxHeightAlabandite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAlabandite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("rhodonite");
		enableRhodonite = BUILDER.comment("Enable rhodonite generation").define("enableRhodonite", false);
		VeinSizeRhodonite = BUILDER.comment("Vein Size").defineInRange("VeinSizeRhodonite", 7, 0, 50);
		VeinsPerChunkRhodonite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRhodonite", 1, 0, 50);
		MinHeightRhodonite = BUILDER.comment("Minimum Height").defineInRange("MinHeightRhodonite", 30, 0, 255);
		MaxHeightRhodonite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRhodonite", 60, 0, 255);
		BUILDER.pop();

		BUILDER.push("chromite");
		enableChromite = BUILDER.comment("Enable chromite generation").define("enableChromite", false);
		VeinSizeChromite = BUILDER.comment("Vein Size").defineInRange("VeinSizeChromite", 7, 0, 50);
		VeinsPerChunkChromite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkChromite", 3, 0, 50);
		MinHeightChromite = BUILDER.comment("Minimum Height").defineInRange("MinHeightChromite", 5, 0, 255);
		MaxHeightChromite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightChromite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("molybdenite");
		enableMolybdenite = BUILDER.comment("Enable molybdenite generation").define("enableMolybdenite", false);
		VeinSizeMolybdenite = BUILDER.comment("Vein Size").defineInRange("VeinSizeMolybdenite", 8, 0, 50);
		VeinsPerChunkMolybdenite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMolybdenite", 1, 0, 50);
		MinHeightMolybdenite = BUILDER.comment("Minimum Height").defineInRange("MinHeightMolybdenite", 15, 0, 255);
		MaxHeightMolybdenite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMolybdenite", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("wulfenite");
		enableWulfenite = BUILDER.comment("Enable wulfenite generation").define("enableWulfenite", false);
		VeinSizeWulfenite = BUILDER.comment("Vein Size").defineInRange("VeinSizeWulfenite", 7, 0, 50);
		VeinsPerChunkWulfenite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkWulfenite", 1, 0, 50);
		MinHeightWulfenite = BUILDER.comment("Minimum Height").defineInRange("MinHeightWulfenite", 15, 0, 255);
		MaxHeightWulfenite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightWulfenite", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("scheelite");
		enableScheelite = BUILDER.comment("Enable scheelite generation").define("enableScheelite", false);
		VeinSizeScheelite = BUILDER.comment("Vein Size").defineInRange("VeinSizeScheelite", 6, 0, 50);
		VeinsPerChunkScheelite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkScheelite", 1, 0, 50);
		MinHeightScheelite = BUILDER.comment("Minimum Height").defineInRange("MinHeightScheelite", 20, 0, 255);
		MaxHeightScheelite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightScheelite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("ferberite");
		enableFerberite = BUILDER.comment("Enable ferberite generation").define("enableFerberite", false);
		VeinSizeFerberite = BUILDER.comment("Vein Size").defineInRange("VeinSizeFerberite", 6, 0, 50);
		VeinsPerChunkFerberite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkFerberite", 1, 0, 50);
		MinHeightFerberite = BUILDER.comment("Minimum Height").defineInRange("MinHeightFerberite", 20, 0, 255);
		MaxHeightFerberite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightFerberite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("hubnerite");
		enableHubnerite = BUILDER.comment("Enable hubnerite generation").define("enableHubnerite", false);
		VeinSizeHubnerite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHubnerite", 6, 0, 50);
		VeinsPerChunkHubnerite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHubnerite", 1, 0, 50);
		MinHeightHubnerite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHubnerite", 20, 0, 255);
		MaxHeightHubnerite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHubnerite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("vanadinite");
		enableVanadinite = BUILDER.comment("Enable vanadinite generation").define("enableVanadinite", false);
		VeinSizeVanadinite = BUILDER.comment("Vein Size").defineInRange("VeinSizeVanadinite", 5, 0, 50);
		VeinsPerChunkVanadinite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkVanadinite", 3, 0, 50);
		MinHeightVanadinite = BUILDER.comment("Minimum Height").defineInRange("MinHeightVanadinite", 5, 0, 255);
		MaxHeightVanadinite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightVanadinite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("descloizite");
		enableDescloizite = BUILDER.comment("Enable descloizite generation").define("enableDescloizite", false);
		VeinSizeDescloizite = BUILDER.comment("Vein Size").defineInRange("VeinSizeDescloizite", 5, 0, 50);
		VeinsPerChunkDescloizite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkDescloizite", 3, 0, 50);
		MinHeightDescloizite = BUILDER.comment("Minimum Height").defineInRange("MinHeightDescloizite", 5, 0, 255);
		MaxHeightDescloizite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightDescloizite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("columbite");
		enableColumbite = BUILDER.comment("Enable columbite generation").define("enableColumbite", false);
		VeinSizeColumbite = BUILDER.comment("Vein Size").defineInRange("VeinSizeColumbite", 8, 0, 50);
		VeinsPerChunkColumbite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkColumbite", 1, 0, 50);
		MinHeightColumbite = BUILDER.comment("Minimum Height").defineInRange("MinHeightColumbite", 5, 0, 255);
		MaxHeightColumbite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightColumbite", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("tantalite");
		enableTantalite = BUILDER.comment("Enable tantalite generation").define("enableTantalite", false);
		VeinSizeTantalite = BUILDER.comment("Vein Size").defineInRange("VeinSizeTantalite", 8, 0, 50);
		VeinsPerChunkTantalite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTantalite", 1, 0, 50);
		MinHeightTantalite = BUILDER.comment("Minimum Height").defineInRange("MinHeightTantalite", 10, 0, 255);
		MaxHeightTantalite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTantalite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("rutile");
		enableRutile = BUILDER.comment("Enable rutile generation").define("enableRutile", false);
		VeinSizeRutile = BUILDER.comment("Vein Size").defineInRange("VeinSizeRutile", 8, 0, 50);
		VeinsPerChunkRutile = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRutile", 1, 0, 50);
		MinHeightRutile = BUILDER.comment("Minimum Height").defineInRange("MinHeightRutile", 4, 0, 255);
		MaxHeightRutile = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRutile", 20, 0, 255);
		BUILDER.pop();

		BUILDER.push("ilmenite");
		enableIlmenite = BUILDER.comment("Enable ilmenite generation").define("enableIlmenite", false);
		VeinSizeIlmenite = BUILDER.comment("Vein Size").defineInRange("VeinSizeIlmenite", 8, 0, 50);
		VeinsPerChunkIlmenite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkIlmenite", 1, 0, 50);
		MinHeightIlmenite = BUILDER.comment("Minimum Height").defineInRange("MinHeightIlmenite", 4, 0, 255);
		MaxHeightIlmenite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightIlmenite", 20, 0, 255);
		BUILDER.pop();

		BUILDER.push("anatase");
		enableAnatase = BUILDER.comment("Enable anatase generation").define("enableAnatase", false);
		VeinSizeAnatase = BUILDER.comment("Vein Size").defineInRange("VeinSizeAnatase", 7, 0, 50);
		VeinsPerChunkAnatase = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAnatase", 1, 0, 50);
		MinHeightAnatase = BUILDER.comment("Minimum Height").defineInRange("MinHeightAnatase", 4, 0, 255);
		MaxHeightAnatase = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAnatase", 20, 0, 255);
		BUILDER.pop();

		BUILDER.push("brookite");
		enableBrookite = BUILDER.comment("Enable brookite generation").define("enableBrookite", false);
		VeinSizeBrookite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBrookite", 7, 0, 50);
		VeinsPerChunkBrookite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBrookite", 1, 0, 50);
		MinHeightBrookite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBrookite", 4, 0, 255);
		MaxHeightBrookite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBrookite", 20, 0, 255);
		BUILDER.pop();

		BUILDER.push("titanite");
		enableTitanite = BUILDER.comment("Enable titanite generation").define("enableTitanite", false);
		VeinSizeTitanite = BUILDER.comment("Vein Size").defineInRange("VeinSizeTitanite", 7, 0, 50);
		VeinsPerChunkTitanite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTitanite", 1, 0, 50);
		MinHeightTitanite = BUILDER.comment("Minimum Height").defineInRange("MinHeightTitanite", 4, 0, 255);
		MaxHeightTitanite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTitanite", 20, 0, 255);
		BUILDER.pop();

		BUILDER.push("zircon");
		enableZircon = BUILDER.comment("Enable zircon generation").define("enableZircon", false);
		VeinSizeZircon = BUILDER.comment("Vein Size").defineInRange("VeinSizeZircon", 8, 0, 50);
		VeinsPerChunkZircon = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkZircon", 1, 0, 50);
		MinHeightZircon = BUILDER.comment("Minimum Height").defineInRange("MinHeightZircon", 4, 0, 255);
		MaxHeightZircon = BUILDER.comment("Maximum Height").defineInRange("MaxHeightZircon", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("thorite");
		enableThorite = BUILDER.comment("Enable thorite generation").define("enableThorite", false);
		VeinSizeThorite = BUILDER.comment("Vein Size").defineInRange("VeinSizeThorite", 5, 0, 50);
		VeinsPerChunkThorite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkThorite", 1, 0, 50);
		MinHeightThorite = BUILDER.comment("Minimum Height").defineInRange("MinHeightThorite", 4, 0, 255);
		MaxHeightThorite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightThorite", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("carnotite");
		enableCarnotite = BUILDER.comment("Enable carnotite generation").define("enableCarnotite", false);
		VeinSizeCarnotite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCarnotite", 7, 0, 50);
		VeinsPerChunkCarnotite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCarnotite", 1, 0, 50);
		MinHeightCarnotite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCarnotite", 4, 0, 255);
		MaxHeightCarnotite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCarnotite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("uraninite");
		enableUraninite = BUILDER.comment("Enable uraninite generation").define("enableUraninite", false);
		VeinSizeUraninite = BUILDER.comment("Vein Size").defineInRange("VeinSizeUraninite", 7, 0, 50);
		VeinsPerChunkUraninite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkUraninite", 1, 0, 50);
		MinHeightUraninite = BUILDER.comment("Minimum Height").defineInRange("MinHeightUraninite", 4, 0, 255);
		MaxHeightUraninite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightUraninite", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("magnesite");
		enableMagnesite = BUILDER.comment("Enable magnesite generation").define("enableMagnesite", false);
		VeinSizeMagnesite = BUILDER.comment("Vein Size").defineInRange("VeinSizeMagnesite", 8, 0, 50);
		VeinsPerChunkMagnesite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMagnesite", 1, 0, 50);
		MinHeightMagnesite = BUILDER.comment("Minimum Height").defineInRange("MinHeightMagnesite", 20, 0, 255);
		MaxHeightMagnesite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMagnesite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("kieserite");
		enableKieserite = BUILDER.comment("Enable kieserite generation").define("enableKieserite", false);
		VeinSizeKieserite = BUILDER.comment("Vein Size").defineInRange("VeinSizeKieserite", 8, 0, 50);
		VeinsPerChunkKieserite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkKieserite", 1, 0, 50);
		MinHeightKieserite = BUILDER.comment("Minimum Height").defineInRange("MinHeightKieserite", 20, 0, 255);
		MaxHeightKieserite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightKieserite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("brucite");
		enableBrucite = BUILDER.comment("Enable brucite generation").define("enableBrucite", false);
		VeinSizeBrucite = BUILDER.comment("Vein Size").defineInRange("VeinSizeBrucite", 8, 0, 50);
		VeinsPerChunkBrucite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBrucite", 1, 0, 50);
		MinHeightBrucite = BUILDER.comment("Minimum Height").defineInRange("MinHeightBrucite", 20, 0, 255);
		MaxHeightBrucite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBrucite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("calcite");
		enableCalcite = BUILDER.comment("Enable calcite generation").define("enableCalcite", false);
		VeinSizeCalcite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCalcite", 10, 0, 50);
		VeinsPerChunkCalcite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCalcite", 5, 0, 50);
		MinHeightCalcite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCalcite", 30, 0, 255);
		MaxHeightCalcite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCalcite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("gypsum");
		enableGypsum = BUILDER.comment("Enable gypsum generation").define("enableGypsum", false);
		VeinSizeGypsum = BUILDER.comment("Vein Size").defineInRange("VeinSizeGypsum", 10, 0, 50);
		VeinsPerChunkGypsum = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkGypsum", 5, 0, 50);
		MinHeightGypsum = BUILDER.comment("Minimum Height").defineInRange("MinHeightGypsum", 30, 0, 255);
		MaxHeightGypsum = BUILDER.comment("Maximum Height").defineInRange("MaxHeightGypsum", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("anhydrite");
		enableAnhydrite = BUILDER.comment("Enable anhydrite generation").define("enableAnhydrite", false);
		VeinSizeAnhydrite = BUILDER.comment("Vein Size").defineInRange("VeinSizeAnhydrite", 8, 0, 50);
		VeinsPerChunkAnhydrite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAnhydrite", 3, 0, 50);
		MinHeightAnhydrite = BUILDER.comment("Minimum Height").defineInRange("MinHeightAnhydrite", 30, 0, 255);
		MaxHeightAnhydrite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAnhydrite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("dolomite");
		enableDolomite = BUILDER.comment("Enable dolomite generation").define("enableDolomite", false);
		VeinSizeDolomite = BUILDER.comment("Vein Size").defineInRange("VeinSizeDolomite", 10, 0, 50);
		VeinsPerChunkDolomite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkDolomite", 5, 0, 50);
		MinHeightDolomite = BUILDER.comment("Minimum Height").defineInRange("MinHeightDolomite", 30, 0, 255);
		MaxHeightDolomite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightDolomite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("strontianite");
		enableStrontianite = BUILDER.comment("Enable strontianite generation").define("enableStrontianite", false);
		VeinSizeStrontianite = BUILDER.comment("Vein Size").defineInRange("VeinSizeStrontianite", 8, 0, 50);
		VeinsPerChunkStrontianite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkStrontianite", 2, 0, 50);
		MinHeightStrontianite = BUILDER.comment("Minimum Height").defineInRange("MinHeightStrontianite", 15, 0, 255);
		MaxHeightStrontianite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightStrontianite", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("celestine");
		enableCelestine = BUILDER.comment("Enable celestine generation").define("enableCelestine", false);
		VeinSizeCelestine = BUILDER.comment("Vein Size").defineInRange("VeinSizeCelestine", 8, 0, 50);
		VeinsPerChunkCelestine = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCelestine", 1, 0, 50);
		MinHeightCelestine = BUILDER.comment("Minimum Height").defineInRange("MinHeightCelestine", 15, 0, 255);
		MaxHeightCelestine = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCelestine", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("polylithionite");
		enablePolylithionite = BUILDER.comment("Enable polylithionite generation").define("enablePolylithionite", false);
		VeinSizePolylithionite = BUILDER.comment("Vein Size").defineInRange("VeinSizePolylithionite", 8, 0, 50);
		VeinsPerChunkPolylithionite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPolylithionite", 2, 0, 50);
		MinHeightPolylithionite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPolylithionite", 20, 0, 255);
		MaxHeightPolylithionite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPolylithionite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("petalite");
		enablePetalite = BUILDER.comment("Enable petalite generation").define("enablePetalite", false);
		VeinSizePetalite = BUILDER.comment("Vein Size").defineInRange("VeinSizePetalite", 6, 0, 50);
		VeinsPerChunkPetalite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPetalite", 2, 0, 50);
		MinHeightPetalite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPetalite", 20, 0, 255);
		MaxHeightPetalite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPetalite", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("carnallite");
		enableCarnallite = BUILDER.comment("Enable carnallite generation").define("enableCarnallite", false);
		VeinSizeCarnallite = BUILDER.comment("Vein Size").defineInRange("VeinSizeCarnallite", 8, 0, 50);
		VeinsPerChunkCarnallite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCarnallite", 2, 0, 50);
		MinHeightCarnallite = BUILDER.comment("Minimum Height").defineInRange("MinHeightCarnallite", 45, 0, 255);
		MaxHeightCarnallite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCarnallite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("sylvite");
		enableSylvite = BUILDER.comment("Enable sylvite generation").define("enableSylvite", false);
		VeinSizeSylvite = BUILDER.comment("Vein Size").defineInRange("VeinSizeSylvite", 8, 0, 50);
		VeinsPerChunkSylvite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSylvite", 2, 0, 50);
		MinHeightSylvite = BUILDER.comment("Minimum Height").defineInRange("MinHeightSylvite", 45, 0, 255);
		MaxHeightSylvite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSylvite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("polyhalite");
		enablePolyhalite = BUILDER.comment("Enable polyhalite generation").define("enablePolyhalite", false);
		VeinSizePolyhalite = BUILDER.comment("Vein Size").defineInRange("VeinSizePolyhalite", 8, 0, 50);
		VeinsPerChunkPolyhalite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPolyhalite", 1, 0, 50);
		MinHeightPolyhalite = BUILDER.comment("Minimum Height").defineInRange("MinHeightPolyhalite", 45, 0, 255);
		MaxHeightPolyhalite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPolyhalite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("kainite");
		enableKainite = BUILDER.comment("Enable kainite generation").define("enableKainite", false);
		VeinSizeKainite = BUILDER.comment("Vein Size").defineInRange("VeinSizeKainite", 4, 0, 50);
		VeinsPerChunkKainite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkKainite", 1, 0, 50);
		MinHeightKainite = BUILDER.comment("Minimum Height").defineInRange("MinHeightKainite", 45, 0, 255);
		MaxHeightKainite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightKainite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("langbeinite");
		enableLangbeinite = BUILDER.comment("Enable langbeinite generation").define("enableLangbeinite", false);
		VeinSizeLangbeinite = BUILDER.comment("Vein Size").defineInRange("VeinSizeLangbeinite", 8, 0, 50);
		VeinsPerChunkLangbeinite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkLangbeinite", 1, 0, 50);
		MinHeightLangbeinite = BUILDER.comment("Minimum Height").defineInRange("MinHeightLangbeinite", 45, 0, 255);
		MaxHeightLangbeinite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightLangbeinite", 128, 0, 255);
		BUILDER.pop();

		BUILDER.push("nitratine");
		enableNitratine = BUILDER.comment("Enable nitratine generation").define("enableNitratine", false);
		VeinSizeNitratine = BUILDER.comment("Vein Size").defineInRange("VeinSizeNitratine", 18, 0, 50);
		VeinsPerChunkNitratine = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNitratine", 10, 0, 50);
		MinHeightNitratine = BUILDER.comment("Minimum Height").defineInRange("MinHeightNitratine", 42, 0, 255);
		MaxHeightNitratine = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNitratine", 65, 0, 255);
		BUILDER.pop();

		BUILDER.push("halite");
		enableHalite = BUILDER.comment("Enable halite generation").define("enableHalite", false);
		VeinSizeHalite = BUILDER.comment("Vein Size").defineInRange("VeinSizeHalite", 9, 0, 50);
		VeinsPerChunkHalite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHalite", 4, 0, 50);
		MinHeightHalite = BUILDER.comment("Minimum Height").defineInRange("MinHeightHalite", 40, 0, 255);
		MaxHeightHalite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHalite", 80, 0, 255);
		BUILDER.pop();

		BUILDER.push("sapphire_ore");
		enableSapphire_ore = BUILDER.comment("Enable sapphire generation").define("enableSapphire_ore", false);
		VeinSizeSapphire_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeSapphire_ore", 9, 0, 50);
		VeinsPerChunkSapphire_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSapphire_ore", 1, 0, 50);
		MinHeightSapphire_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightSapphire_ore", 4, 0, 255);
		MaxHeightSapphire_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSapphire_ore", 16, 0, 255);
		BUILDER.pop();

		BUILDER.push("ruby_ore");
		enableRuby_ore = BUILDER.comment("Enable ruby generation").define("enableRuby_ore", false);
		VeinSizeRuby_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeRuby_ore", 9, 0, 50);
		VeinsPerChunkRuby_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRuby_ore", 1, 0, 50);
		MinHeightRuby_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightRuby_ore", 4, 0, 255);
		MaxHeightRuby_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRuby_ore", 16, 0, 255);
		BUILDER.pop();

		BUILDER.push("spinel_ore");
		enableSpinel_ore = BUILDER.comment("Enable spinel generation").define("enableSpinel_ore", false);
		VeinSizeSpinel_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeSpinel_ore", 7, 0, 50);
		VeinsPerChunkSpinel_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSpinel_ore", 2, 0, 50);
		MinHeightSpinel_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightSpinel_ore", 4, 0, 255);
		MaxHeightSpinel_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSpinel_ore", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("amethyst_ore");
		enableAmethyst_ore = BUILDER.comment("Enable amethyst generation").define("enableAmethyst_ore", false);
		VeinSizeAmethyst_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAmethyst_ore", 7, 0, 50);
		VeinsPerChunkAmethyst_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAmethyst_ore", 2, 0, 50);
		MinHeightAmethyst_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAmethyst_ore", 4, 0, 255);
		MaxHeightAmethyst_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAmethyst_ore", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("jade_ore");
		enableJade_ore = BUILDER.comment("Enable jade generation").define("enableJade_ore", false);
		VeinSizeJade_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeJade_ore", 8, 0, 50);
		VeinsPerChunkJade_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkJade_ore", 2, 0, 50);
		MinHeightJade_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightJade_ore", 4, 0, 255);
		MaxHeightJade_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightJade_ore", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("tourmaline_ore");
		enableTourmaline_ore = BUILDER.comment("Enable tourmaline generation").define("enableTourmaline_ore", false);
		VeinSizeTourmaline_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeTourmaline_ore", 8, 0, 50);
		VeinsPerChunkTourmaline_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTourmaline_ore", 2, 0, 50);
		MinHeightTourmaline_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightTourmaline_ore", 4, 0, 255);
		MaxHeightTourmaline_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTourmaline_ore", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("sugilite_ore");
		enableSugilite_ore = BUILDER.comment("Enable sugilite generation").define("enableSugilite_ore", false);
		VeinSizeSugilite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeSugilite_ore", 7, 0, 50);
		VeinsPerChunkSugilite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSugilite_ore", 3, 0, 50);
		MinHeightSugilite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightSugilite_ore", 4, 0, 255);
		MaxHeightSugilite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSugilite_ore", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("peridot_ore");
		enablePeridot_ore = BUILDER.comment("Enable peridot generation").define("enablePeridot_ore", false);
		VeinSizePeridot_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizePeridot_ore", 8, 0, 50);
		VeinsPerChunkPeridot_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPeridot_ore", 3, 0, 50);
		MinHeightPeridot_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightPeridot_ore", 4, 0, 255);
		MaxHeightPeridot_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPeridot_ore", 45, 0, 255);
		BUILDER.pop();

		BUILDER.push("agate_ore");
		enableAgate_ore = BUILDER.comment("Enable agate generation").define("enableAgate_ore", false);
		VeinSizeAgate_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAgate_ore", 7, 0, 50);
		VeinsPerChunkAgate_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAgate_ore", 3, 0, 50);
		MinHeightAgate_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAgate_ore", 4, 0, 255);
		MaxHeightAgate_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAgate_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("carnelian_ore");
		enableCarnelian_ore = BUILDER.comment("Enable carnelian generation").define("enableCarnelian_ore", false);
		VeinSizeCarnelian_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeCarnelian_ore", 7, 0, 50);
		VeinsPerChunkCarnelian_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCarnelian_ore", 3, 0, 50);
		MinHeightCarnelian_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightCarnelian_ore", 4, 0, 255);
		MaxHeightCarnelian_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCarnelian_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("chrysoprase_ore");
		enableChrysoprase_ore = BUILDER.comment("Enable chrysoprase generation").define("enableChrysoprase_ore", false);
		VeinSizeChrysoprase_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeChrysoprase_ore", 7, 0, 50);
		VeinsPerChunkChrysoprase_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkChrysoprase_ore", 3, 0, 50);
		MinHeightChrysoprase_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightChrysoprase_ore", 4, 0, 255);
		MaxHeightChrysoprase_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightChrysoprase_ore", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("heliotrope_ore");
		enableHeliotrope_ore = BUILDER.comment("Enable heliotrope generation").define("enableHeliotrope_ore", false);
		VeinSizeHeliotrope_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeHeliotrope_ore", 7, 0, 50);
		VeinsPerChunkHeliotrope_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHeliotrope_ore", 3, 0, 50);
		MinHeightHeliotrope_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightHeliotrope_ore", 4, 0, 255);
		MaxHeightHeliotrope_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHeliotrope_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("topaz_ore");
		enableTopaz_ore = BUILDER.comment("Enable topaz generation").define("enableTopaz_ore", false);
		VeinSizeTopaz_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeTopaz_ore", 7, 0, 50);
		VeinsPerChunkTopaz_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTopaz_ore", 2, 0, 50);
		MinHeightTopaz_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightTopaz_ore", 4, 0, 255);
		MaxHeightTopaz_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTopaz_ore", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("unakite_ore");
		enableUnakite_ore = BUILDER.comment("Enable unakite generation").define("enableUnakite_ore", false);
		VeinSizeUnakite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeUnakite_ore", 8, 0, 50);
		VeinsPerChunkUnakite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkUnakite_ore", 2, 0, 50);
		MinHeightUnakite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightUnakite_ore", 4, 0, 255);
		MaxHeightUnakite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightUnakite_ore", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("tanzanite_ore");
		enableTanzanite_ore = BUILDER.comment("Enable tanzanite generation").define("enableTanzanite_ore", false);
		VeinSizeTanzanite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeTanzanite_ore", 8, 0, 50);
		VeinsPerChunkTanzanite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTanzanite_ore", 4, 0, 50);
		MinHeightTanzanite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightTanzanite_ore", 4, 0, 255);
		MaxHeightTanzanite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTanzanite_ore", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("hauyne_ore");
		enableHauyne_ore = BUILDER.comment("Enable hauyne generation").define("enableHauyne_ore", false);
		VeinSizeHauyne_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeHauyne_ore", 7, 0, 50);
		VeinsPerChunkHauyne_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkHauyne_ore", 3, 0, 50);
		MinHeightHauyne_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightHauyne_ore", 4, 0, 255);
		MaxHeightHauyne_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightHauyne_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("onyx_ore");
		enableOnyx_ore = BUILDER.comment("Enable onyx generation").define("enableOnyx_ore", false);
		VeinSizeOnyx_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeOnyx_ore", 7, 0, 50);
		VeinsPerChunkOnyx_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkOnyx_ore", 2, 0, 50);
		MinHeightOnyx_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightOnyx_ore", 4, 0, 255);
		MaxHeightOnyx_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightOnyx_ore", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("opal_ore");
		enableOpal_ore = BUILDER.comment("Enable opal generation").define("enableOpal_ore", false);
		VeinSizeOpal_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeOpal_ore", 7, 0, 50);
		VeinsPerChunkOpal_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkOpal_ore", 4, 0, 50);
		MinHeightOpal_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightOpal_ore", 4, 0, 255);
		MaxHeightOpal_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightOpal_ore", 40, 0, 255);
		BUILDER.pop();

		BUILDER.push("moonstone_ore");
		enableMoonstone_ore = BUILDER.comment("Enable moonstone generation").define("enableMoonstone_ore", false);
		VeinSizeMoonstone_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeMoonstone_ore", 7, 0, 50);
		VeinsPerChunkMoonstone_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMoonstone_ore", 4, 0, 50);
		MinHeightMoonstone_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightMoonstone_ore", 20, 0, 255);
		MaxHeightMoonstone_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMoonstone_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("turquoise_ore");
		enableTurquoise_ore = BUILDER.comment("Enable turquoise generation").define("enableTurquoise_ore", false);
		VeinSizeTurquoise_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeTurquoise_ore", 7, 0, 50);
		VeinsPerChunkTurquoise_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTurquoise_ore", 3, 0, 50);
		MinHeightTurquoise_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightTurquoise_ore", 20, 0, 255);
		MaxHeightTurquoise_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTurquoise_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("amazonite_ore");
		enableAmazonite_ore = BUILDER.comment("Enable amazonite generation").define("enableAmazonite_ore", false);
		VeinSizeAmazonite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAmazonite_ore", 7, 0, 50);
		VeinsPerChunkAmazonite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAmazonite_ore", 2, 0, 50);
		MinHeightAmazonite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAmazonite_ore", 10, 0, 255);
		MaxHeightAmazonite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAmazonite_ore", 30, 0, 255);
		BUILDER.pop();

		BUILDER.push("chrysocolla_ore");
		enableChrysocolla_ore = BUILDER.comment("Enable chrysocolla generation").define("enableChrysocolla_ore", false);
		VeinSizeChrysocolla_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeChrysocolla_ore", 6, 0, 50);
		VeinsPerChunkChrysocolla_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkChrysocolla_ore", 5, 0, 50);
		MinHeightChrysocolla_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightChrysocolla_ore", 25, 0, 255);
		MaxHeightChrysocolla_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightChrysocolla_ore", 50, 0, 255);
		BUILDER.pop();

		BUILDER.push("almandine_ore");
		enableAlmandine_ore = BUILDER.comment("Enable almandine generation").define("enableAlmandine_ore", false);
		VeinSizeAlmandine_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAlmandine_ore", 6, 0, 50);
		VeinsPerChunkAlmandine_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAlmandine_ore", 4, 0, 50);
		MinHeightAlmandine_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAlmandine_ore", 4, 0, 255);
		MaxHeightAlmandine_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAlmandine_ore", 25, 0, 255);
		BUILDER.pop();

		BUILDER.push("spessartine_ore");
		enableSpessartine_ore = BUILDER.comment("Enable spessartine generation").define("enableSpessartine_ore", false);
		VeinSizeSpessartine_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeSpessartine_ore", 7, 0, 50);
		VeinsPerChunkSpessartine_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSpessartine_ore", 3, 0, 50);
		MinHeightSpessartine_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightSpessartine_ore", 4, 0, 255);
		MaxHeightSpessartine_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSpessartine_ore", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("pyrope_ore");
		enablePyrope_ore = BUILDER.comment("Enable pyrope generation").define("enablePyrope_ore", false);
		VeinSizePyrope_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizePyrope_ore", 7, 0, 50);
		VeinsPerChunkPyrope_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkPyrope_ore", 3, 0, 50);
		MinHeightPyrope_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightPyrope_ore", 4, 0, 255);
		MaxHeightPyrope_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightPyrope_ore", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("tsavorite_ore");
		enableTsavorite_ore = BUILDER.comment("Enable tsavorite generation").define("enableTsavorite_ore", false);
		VeinSizeTsavorite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeTsavorite_ore", 7, 0, 50);
		VeinsPerChunkTsavorite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkTsavorite_ore", 3, 0, 50);
		MinHeightTsavorite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightTsavorite_ore", 4, 0, 255);
		MaxHeightTsavorite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightTsavorite_ore", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("andradite_ore");
		enableAndradite_ore = BUILDER.comment("Enable andradite generation").define("enableAndradite_ore", false);
		VeinSizeAndradite_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeAndradite_ore", 7, 0, 50);
		VeinsPerChunkAndradite_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAndradite_ore", 3, 0, 50);
		MinHeightAndradite_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightAndradite_ore", 4, 0, 255);
		MaxHeightAndradite_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAndradite_ore", 35, 0, 255);
		BUILDER.pop();

		BUILDER.push("mithril_ore");
		enableMithril_ore = BUILDER.comment("Enable mithril generation").define("enableMithril_ore", false);
		VeinSizeMithril_ore = BUILDER.comment("Vein Size").defineInRange("VeinSizeMithril_ore", 7, 0, 50);
		VeinsPerChunkMithril_ore = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMithril_ore", 3, 0, 50);
		MinHeightMithril_ore = BUILDER.comment("Minimum Height").defineInRange("MinHeightMithril_ore", 4, 0, 255);
		MaxHeightMithril_ore = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMithril_ore", 35, 0, 255);
		BUILDER.pop();		

		BUILDER.push("additional_peat");
		enableAdditionalPeat = BUILDER.comment("Enable additional peat generation in swamps").define("enableAdditionalPeat", false);
		VeinSizeAdditionalPeat = BUILDER.comment("Vein Size").defineInRange("VeinSizeAdditionalPeat", 18, 0, 50);
		VeinsPerChunkAdditionalPeat = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkAdditionalPeat", 9, 0, 50);
		MinHeightAdditionalPeat = BUILDER.comment("Minimum Height").defineInRange("MinHeightAdditionalPeat", 48, 0, 255);
		MaxHeightAdditionalPeat = BUILDER.comment("Maximum Height").defineInRange("MaxHeightAdditionalPeat", 70, 0, 255);
		BUILDER.pop();

		BUILDER.push("Common PGMs platinum group metals");
		enabledPGMs = BUILDER.comment("Enable Common platinum group metals (platinum, osmium, iridium)").define("enableCommonPGMs", false);
		VeinSizePGMs = BUILDER.comment("Vein Size").defineInRange("VeinSizeCommonPGMs", 5, 0, 50);
		VeinsPerChunkPGMs = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkCommonPGMs", 2, 0, 50);
		MinHeightPGMs = BUILDER.comment("Minimum Height").defineInRange("MinHeightCommonPGMs", 4, 0, 255);
		MaxHeightPGMs = BUILDER.comment("Maximum Height").defineInRange("MaxHeightCommonPGMs", 12, 0, 255);
		BUILDER.pop();

		BUILDER.push("Rare PGMS platinum group metals");
		enabledRarePGMs = BUILDER.comment("Enable rare platinum group metals (rhodium, palladium, ruthenium)").define("enableRarePGMs", false);
		VeinSizeRarePGMs = BUILDER.comment("Vein Size").defineInRange("VeinSizeRarePGMs", 4, 0, 50);
		VeinsPerChunkRarePGMs = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkRarePGMs", 1, 0, 50);
		MinHeightRarePGMs = BUILDER.comment("Minimum Height").defineInRange("MinHeightRarePGMs", 4, 0, 255);
		MaxHeightRarePGMs = BUILDER.comment("Maximum Height").defineInRange("MaxHeightRarePGMs", 12, 0, 255);
		BUILDER.pop();

		BUILDER.pop();


		BUILDER.comment("Nether generation settings").push("nether");

		BUILDER.push("nether_gold");
		enableNetherGold = BUILDER.comment("Enable gold ore generation in nether. (default: true)").define("enableNetherGold", true);
		VeinSizeNetherGold = BUILDER.comment("Vein Size").defineInRange("VeinSizeNetherGold", 21, 0, 50);
		VeinsPerChunkNetherGold = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNetherGold", 4, 0, 50);
		MinHeightNetherGold = BUILDER.comment("Minimum Height").defineInRange("MinHeightNetherGold", 10, 0, 126);
		MaxHeightNetherGold = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNetherGold", 110, 0, 126);
		BUILDER.pop();

		BUILDER.push("nether_coal");
		enableNetherCoal = BUILDER.comment("Enable coal ore generation in nether. (default: true)").define("enableNetherCoal", true);
		VeinSizeNetherCoal = BUILDER.comment("Vein Size").defineInRange("VeinSizeNetherCoal", 16, 0, 50);
		VeinsPerChunkNetherCoal = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNetherCoal", 5, 0, 50);
		MinHeightNetherCoal = BUILDER.comment("Minimum Height").defineInRange("MinHeightNetherCoal", 10, 0, 126);
		MaxHeightNetherCoal = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNetherCoal", 110, 0, 126);
		BUILDER.pop();

		BUILDER.push("nether_mithril");
		enableNetherMithril = BUILDER.comment("Enable mithril ore generation in nether. (default: false)").define("enableNetherMithril", false);
		VeinSizeNetherMithril = BUILDER.comment("Vein Size").defineInRange("VeinSizeNetherMithril", 9, 0, 50);
		VeinsPerChunkNetherMithril = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNetherMithril", 6, 0, 50);
		MinHeightNetherMithril = BUILDER.comment("Minimum Height").defineInRange("MinHeightNetherMithril", 10, 0, 126);
		MaxHeightNetherMithril = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNetherMithril", 110, 0, 126);
		BUILDER.pop();

		BUILDER.push("nether_sulphur");
		enableNetherSulphur = BUILDER.comment("Enable sulphur ore generation in nether. (default: true)").define("enableNetherSulphur", true);
		VeinSizeNetherSulphur = BUILDER.comment("Vein Size").defineInRange("VeinSizeNetherSulphur", 15, 0, 50);
		VeinsPerChunkNetherSulphur = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkNetherSulphur", 11, 0, 50);
		MinHeightNetherSulphur = BUILDER.comment("Minimum Height").defineInRange("MinHeightNetherSulphur", 10, 0, 126);
		MaxHeightNetherSulphur = BUILDER.comment("Maximum Height").defineInRange("MaxHeightNetherSulphur", 110, 0, 126);
		BUILDER.pop();		

		BUILDER.pop();

		BUILDER.comment("Rare-earth elements").push("rees");
		BUILDER.push("bastnasite_la");
		enableBastnasite_la = BUILDER.comment("Enable Bastnasite La generation.").define("enableBastnasite_la", false);
		VeinSizeBastnasite_la = BUILDER.comment("Vein Size").defineInRange("VeinSizeBastnasite_la", 6, 0, 50);	
		VeinsPerChunkBastnasite_la = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBastnasite_la", 2, 0, 50);
		MinHeightBastnasite_la = BUILDER.comment("Minimum Height").defineInRange("MinHeightBastnasite_la", 3, 0, 255);
		MaxHeightBastnasite_la = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBastnasite_la", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("monazite_la");
		enableMonazite_la = BUILDER.comment("Enable Monazite La generation.").define("enableMonazite_la", false);
		VeinSizeMonazite_la = BUILDER.comment("Vein Size").defineInRange("VeinSizeMonazite_la", 8, 0, 50);	
		VeinsPerChunkMonazite_la = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMonazite_la", 1, 0, 50);
		MinHeightMonazite_la = BUILDER.comment("Minimum Height").defineInRange("MinHeightMonazite_la", 3, 0, 255);
		MaxHeightMonazite_la = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMonazite_la", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("bastnasite_ce");
		enableBastnasite_ce = BUILDER.comment("Enable Bastnasite Ce generation.").define("enableBastnasite_ce", false);
		VeinSizeBastnasite_ce = BUILDER.comment("Vein Size").defineInRange("VeinSizeBastnasite_ce", 6, 0, 50);	
		VeinsPerChunkBastnasite_ce = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBastnasite_ce", 2, 0, 50);
		MinHeightBastnasite_ce = BUILDER.comment("Minimum Height").defineInRange("MinHeightBastnasite_ce", 3, 0, 255);
		MaxHeightBastnasite_ce = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBastnasite_ce", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("monazite_ce");
		enableMonazite_ce = BUILDER.comment("Enable Monazite Ce generation.").define("enableMonazite_ce", false);
		VeinSizeMonazite_ce = BUILDER.comment("Vein Size").defineInRange("VeinSizeMonazite_ce", 8, 0, 50);	
		VeinsPerChunkMonazite_ce = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMonazite_ce", 1, 0, 50);
		MinHeightMonazite_ce = BUILDER.comment("Minimum Height").defineInRange("MinHeightMonazite_ce", 3, 0, 255);
		MaxHeightMonazite_ce = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMonazite_ce", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("bastnasite_nd");
		enableBastnasite_nd = BUILDER.comment("Enable Bastnasite Nd generation.").define("enableBastnasite_nd", false);
		VeinSizeBastnasite_nd = BUILDER.comment("Vein Size").defineInRange("VeinSizeBastnasite_nd", 9, 0, 50);	
		VeinsPerChunkBastnasite_nd = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBastnasite_nd", 1, 0, 50);
		MinHeightBastnasite_nd = BUILDER.comment("Minimum Height").defineInRange("MinHeightBastnasite_nd", 3, 0, 255);
		MaxHeightBastnasite_nd = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBastnasite_nd", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("monazite_nd");
		enableMonazite_nd = BUILDER.comment("Enable Monazite Nd generation.").define("enableMonazite_nd", false);
		VeinSizeMonazite_nd = BUILDER.comment("Vein Size").defineInRange("VeinSizeMonazite_nd", 7, 0, 50);	
		VeinsPerChunkMonazite_nd = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkMonazite_nd", 1, 0, 50);
		MinHeightMonazite_nd = BUILDER.comment("Minimum Height").defineInRange("MinHeightMonazite_nd", 3, 0, 255);
		MaxHeightMonazite_nd = BUILDER.comment("Maximum Height").defineInRange("MaxHeightMonazite_nd", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("bastnasite_y");
		enableBastnasite_y = BUILDER.comment("Enable Bastnasite Y generation.").define("enableBastnasite_y", false);
		VeinSizeBastnasite_y = BUILDER.comment("Vein Size").defineInRange("VeinSizeBastnasite_y", 6, 0, 50);	
		VeinsPerChunkBastnasite_y = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkBastnasite_y", 2, 0, 50);
		MinHeightBastnasite_y = BUILDER.comment("Minimum Height").defineInRange("MinHeightBastnasite_y", 3, 0, 255);
		MaxHeightBastnasite_y = BUILDER.comment("Maximum Height").defineInRange("MaxHeightBastnasite_y", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("samarskite_y");
		enableSamarskite_y = BUILDER.comment("Enable Samarskite Y generation.").define("enableSamarskite_y", false);
		VeinSizeSamarskite_y = BUILDER.comment("Vein Size").defineInRange("VeinSizeSamarskite_y", 7, 0, 50);	
		VeinsPerChunkSamarskite_y = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkSamarskite_y", 2, 0, 50);
		MinHeightSamarskite_y = BUILDER.comment("Minimum Height").defineInRange("MinHeightSamarskite_y", 3, 0, 255);
		MaxHeightSamarskite_y = BUILDER.comment("Maximum Height").defineInRange("MaxHeightSamarskite_y", 60, 0, 255);
		BUILDER.pop();
		BUILDER.push("thortveitite");
		enableThortveitite = BUILDER.comment("Enable Thortveitite generation.").define("enableThortveitite", false);
		VeinSizeThortveitite = BUILDER.comment("Vein Size").defineInRange("VeinSizeThortveitite", 8, 0, 50);	
		VeinsPerChunkThortveitite = BUILDER.comment("Veins per chunk").defineInRange("VeinsPerChunkThortveitite", 2, 0, 50);
		MinHeightThortveitite = BUILDER.comment("Minimum Height").defineInRange("MinHeightThortveitite", 3, 0, 255);
		MaxHeightThortveitite = BUILDER.comment("Maximum Height").defineInRange("MaxHeightThortveitite", 60, 0, 255);
		BUILDER.pop();
		BUILDER.pop();


		BUILDER.comment("Debug options").push("debug");
		All = BUILDER.comment("Enable all AatO ores in their relative dimensions. ALL of them. For testing purposes. (default: false)")
				.define("All", false);
		BUILDER.pop();


		spec = BUILDER.build();
	}

	public static void loadConfig() {		
		final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(AlmostAllTheOres.MODID + "-common.toml"))
				.sync()
				.autosave()
				.writingMode(WritingMode.REPLACE)
				.build();

		configData.load();

		if(configData.contains("general.enablePlugAndPlay")) {
			if((boolean) configData.get("general.enablePlugAndPlay")) {
				if(enableTinkersDefault) {
					configData.set("overworldSimplified.enableCopperOres", true);
					configData.set("overworldSimplified.enableTinOres", true);
					configData.set("overworldSimplified.enableAluminumOres", true);
					configData.set("overworldSimplified.enableSilverOres", true);
					configData.set("overworldSimplified.enableLeadOres", true);
					configData.set("overworldSimplified.enableZincOres", true);
				}
				if(enableToolsforaatogemsMaterials) {
					configData.set("overworldSimplified.enableSomeGems", true);
				}
				if(enableExtraGemsMaterials) {
					configData.set("overworldExpert.ruby_ore.enableRuby_ore", true);
					configData.set("overworldExpert.sapphire_ore.enableSapphire_ore", true);
					configData.set("overworldExpert.amethyst_ore.enableAmethyst_ore", true);
					configData.set("overworldExpert.topaz_ore.enableTopaz_ore", true);
				}
				if(enableEasySteelMaterials) {
					configData.set("overworldSimplified.enableCopperOres", true);
					configData.set("overworldSimplified.enableTinOres", true);
					configData.set("overworldSimplified.enableTitaniumOres", true);
					configData.set("overworldSimplified.enableTungstenOres", true);
				}
				if(enableUndergroundMaterialsMaterials) {
					configData.set("overworldExpert.ruby_ore.enableRuby_ore", true);
					configData.set("overworldExpert.amethyst_ore.enableAmethyst_ore", true);
					configData.set("overworldExpert.topaz_ore.enableTopaz_ore", true);
					configData.set("overworldSimplified.enableCobaltOres", true);
					configData.set("overworldSimplified.enableCalciumOres", true);			
				}
				if(enableSilentsGemsMaterials) {
					configData.set("overworldExpert.ruby_ore.enableSapphire_ore", true);
					configData.set("overworldExpert.amethyst_ore.enableAmethyst_ore", true);
					configData.set("overworldExpert.topaz_ore.enableTopaz_ore", true);
					configData.set("overworldExpert.ruby_ore.enableRuby_ore", true);
					configData.set("overworldExpert.ruby_ore.enableSpinel_ore", true);
					configData.set("overworldExpert.ruby_ore.enableJade_ore", true);
					configData.set("overworldExpert.ruby_ore.enablePeridot_ore", true);
					configData.set("overworldExpert.ruby_ore.enableAgate_ore", true);
					configData.set("overworldExpert.ruby_ore.enableCarnelian_ore", true);
					configData.set("overworldExpert.ruby_ore.enableChrysoprase_ore", true);
					configData.set("overworldExpert.ruby_ore.enableTanzanite_ore", true);
					configData.set("overworldExpert.ruby_ore.enableOnyx_ore", true);
					configData.set("overworldExpert.ruby_ore.enableOpal_ore", true);
					configData.set("overworldExpert.ruby_ore.enableMoonstone_ore", true);
					configData.set("overworldExpert.ruby_ore.enableTurquoise_ore", true);
					configData.set("overworldExpert.ruby_ore.enablePyrope_ore", true);			
				}
			}
		}
		spec.setConfig(configData);
	}	

	public static void enableTinkersDefaultMaterials() {
		enableTinkersDefault = true;		
	}

	public static void enableToolsforaatogemsMaterials() {
		enableToolsforaatogemsMaterials = true;
	}

	public static void enableExtraGemsMaterials() {
		enableExtraGemsMaterials = true;
	}

	public static void enableEasySteelMaterials() {
		enableEasySteelMaterials = true;
	}
	public static void enableUndergroundMaterialsMaterials() {
		enableUndergroundMaterialsMaterials = true;
	}
	public static void enableSilentsGemsMaterials() {
		enableSilentsGemsMaterials = true;
	}
}
