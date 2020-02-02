package waylanderou.almostalltheores;

import waylanderou.almostalltheores.block.CustomOre;
import waylanderou.almostalltheores.block.Ores;

import java.util.ArrayList;
import java.util.HashMap;

public class OreUtilities {


    public static HashMap<CustomOre, ArrayList<Boolean>> booleanOreConfigMap;
    public static HashMap<CustomOre, ArrayList<Integer>> integerOreConfigMap;

    public static ArrayList<CustomOre> listMediumOceanOres;
    public static ArrayList<CustomOre> listWarmOceanOres;
    public static ArrayList<CustomOre> listColdOceanOres;
    public static ArrayList<CustomOre> listDroughtOres;
    public static ArrayList<CustomOre> listForestOres;

    public static ArrayList<CustomOre> listSulphurOres;
    public static ArrayList<CustomOre> listSeleniumOres;
    public static ArrayList<CustomOre> listCoalOres;
    public static ArrayList<CustomOre> listArsenicOres;
    public static ArrayList<CustomOre> listAntimonyOres;
    public static ArrayList<CustomOre> listGermaniumOres;
    public static ArrayList<CustomOre> listBismuthOres;
    public static ArrayList<CustomOre> listTinOres;
    public static ArrayList<CustomOre> listLeadOres;
    public static ArrayList<CustomOre> listAluminumOres;
    public static ArrayList<CustomOre> listZincOres;
    public static ArrayList<CustomOre> listCadmiumOres;
    public static ArrayList<CustomOre> listMercuryOres;
    public static ArrayList<CustomOre> listCopperOres;
    public static ArrayList<CustomOre> listSilverOres;
    public static ArrayList<CustomOre> listNickelOres;
    public static ArrayList<CustomOre> listCobaltOres;
    public static ArrayList<CustomOre> listIronOres;
    public static ArrayList<CustomOre> listManganeseOres;
    public static ArrayList<CustomOre> listChromiumOres;
    public static ArrayList<CustomOre> listMolybdenumOres;
    public static ArrayList<CustomOre> listTungstenOres;
    public static ArrayList<CustomOre> listVanadiumOres;
    public static ArrayList<CustomOre> listNiobiumOres;
    public static ArrayList<CustomOre> listTantalumOres;
    public static ArrayList<CustomOre> listTitaniumOres;
    public static ArrayList<CustomOre> listZirconiumOres;
    public static ArrayList<CustomOre> listThoriumOres;
    public static ArrayList<CustomOre> listUraniumOres;
    public static ArrayList<CustomOre> listMagnesiumOres;
    public static ArrayList<CustomOre> listCalciumOres;
    public static ArrayList<CustomOre> listStrontiumOres;
    public static ArrayList<CustomOre> listLithiumOres;
    public static ArrayList<CustomOre> listSaltOre;
    public static ArrayList<CustomOre> listSaltpetreOre;
    public static ArrayList<CustomOre> listNPKOres;
    public static ArrayList<CustomOre> listSomeGems;
    public static ArrayList<CustomOre> listAllGems;
    public static ArrayList<CustomOre> listMithrilOre;
    public static ArrayList<CustomOre> listPGMs;
    public static ArrayList<CustomOre> listRarePGMs;

    public static boolean getEnabledGroupConfig(CustomOre customOre){
        if(listSulphurOres.contains(customOre)) return AatoConfig.enableSulphurOres.get();
        else if(listSeleniumOres.contains(customOre)) return AatoConfig.enableSeleniumOres.get();
        else if(listCoalOres.contains(customOre)) return AatoConfig.enableCoalOres.get();
        else if(listArsenicOres.contains(customOre)) return AatoConfig.enableSulphurOres.get();
        else if(listAntimonyOres.contains(customOre)) return AatoConfig.enableAntimonyOres.get();
        else if(listGermaniumOres.contains(customOre)) return AatoConfig.enableGermaniumOres.get();
        else if(listBismuthOres.contains(customOre)) return AatoConfig.enableBismuthOres.get();
        else if(listTinOres.contains(customOre)) return AatoConfig.enableTinOres.get();
        else if(listLeadOres.contains(customOre)) return AatoConfig.enableLeadOres.get();
        else if(listAluminumOres.contains(customOre)) return AatoConfig.enableAluminumOres.get();
        else if(listZincOres.contains(customOre)) return AatoConfig.enableZincOres.get();
        else if(listCadmiumOres.contains(customOre)) return AatoConfig.enableCadmiumOres.get();
        else if(listMercuryOres.contains(customOre)) return AatoConfig.enableMercuryOres.get();
        else if(listCopperOres.contains(customOre)) return AatoConfig.enableCopperOres.get();
        else if(listSilverOres.contains(customOre)) return AatoConfig.enableSilverOres.get();
        else if(listNickelOres.contains(customOre)) return AatoConfig.enableNickelOres.get();
        else if(listCobaltOres.contains(customOre)) return AatoConfig.enableCobaltOres.get();
        else if(listIronOres.contains(customOre)) return AatoConfig.enableIronOres.get();
        else if(listManganeseOres.contains(customOre)) return AatoConfig.enableManganeseOres.get();
        else if(listChromiumOres.contains(customOre)) return AatoConfig.enableChromiumOres.get();
        else if(listMolybdenumOres.contains(customOre)) return AatoConfig.enableMolybdenumOres.get();
        else if(listTungstenOres.contains(customOre)) return AatoConfig.enableTungstenOres.get();
        else if(listVanadiumOres.contains(customOre)) return AatoConfig.enableVanadiumOres.get();
        else if(listNiobiumOres.contains(customOre)) return AatoConfig.enableNiobiumOres.get();
        else if(listTantalumOres.contains(customOre)) return AatoConfig.enableTantalumOres.get();
        else if(listTitaniumOres.contains(customOre)) return AatoConfig.enableTitaniumOres.get();
        else if(listZirconiumOres.contains(customOre)) return AatoConfig.enableZirconiumOres.get();
        else if(listThoriumOres.contains(customOre)) return AatoConfig.enableThoriumOres.get();
        else if(listUraniumOres.contains(customOre)) return AatoConfig.enableUraniumOres.get();
        else if(listMagnesiumOres.contains(customOre)) return AatoConfig.enableMagnesiumOres.get();
        else if(listCalciumOres.contains(customOre)) return AatoConfig.enableCalciumOres.get();
        else if(listStrontiumOres.contains(customOre)) return AatoConfig.enableStrontiumOres.get();
        else if(listLithiumOres.contains(customOre)) return AatoConfig.enableLithiumOres.get();
        else if(listSaltOre.contains(customOre)) return AatoConfig.enableSaltOre.get();
        else if(listSaltpetreOre.contains(customOre)) return AatoConfig.enableSaltpetreOre.get();
        else if(listNPKOres.contains(customOre)) return AatoConfig.enableNPKOres.get();
        else if(listSomeGems.contains(customOre)) return AatoConfig.enableSomeGems.get();
        else if(listAllGems.contains(customOre)) return AatoConfig.enableAllGems.get();
        else if(listMithrilOre.contains(customOre)) return AatoConfig.enableMithrilOre.get();
        else if(listPGMs.contains(customOre)) return AatoConfig.enabledPGMs.get();
        else if(listRarePGMs.contains(customOre)) return AatoConfig.enabledRarePGMs.get();
        else return Boolean.parseBoolean(null);
    }


    public static void createOreConfigMappings(){

        // MEDIUM OCEAN ORES
        listMediumOceanOres.add(Ores.CLAUSTHALITE);
        listMediumOceanOres.add(Ores.ORPIMENT);
        listMediumOceanOres.add(Ores.STANNITE);
        listMediumOceanOres.add(Ores.BOULANGERITE);
        listMediumOceanOres.add(Ores.HEMIMORPHITE);
        listMediumOceanOres.add(Ores.FRANKLINITE);
        listMediumOceanOres.add(Ores.GREENOCKITE);
        listMediumOceanOres.add(Ores.NATIVE_COPPER);
        listMediumOceanOres.add(Ores.BORNITE);
        listMediumOceanOres.add(Ores.AZURITE);
        listMediumOceanOres.add(Ores.FREIBERGITE);
        listMediumOceanOres.add(Ores.PENTLANDITE);
        listMediumOceanOres.add(Ores.CARROLLITE);
        listMediumOceanOres.add(Ores.RHODOCHROSITE);
        listMediumOceanOres.add(Ores.HOLLANDITE);
        listMediumOceanOres.add(Ores.BROOKITE);
        listMediumOceanOres.add(Ores.CELESTINE);
        listMediumOceanOres.add(Ores.POLYHALITE);
        listMediumOceanOres.add(Ores.HAUYNE_ORE);
        listMediumOceanOres.add(Ores.MOONSTONE_ORE);
        listMediumOceanOres.add(Ores.ALMANDINE_ORE);

        // WARM OCEAN ORES
        listWarmOceanOres.add(Ores.SULPHUR);
        listWarmOceanOres.add(Ores.REALGAR);
        listWarmOceanOres.add(Ores.TEALLITE);
        listWarmOceanOres.add(Ores.ANGLESITE);
        listWarmOceanOres.add(Ores.ZINCITE);
        listWarmOceanOres.add(Ores.HYDROZINCITE);
        listWarmOceanOres.add(Ores.OTAVITE);
        listWarmOceanOres.add(Ores.TENNANTITE);
        listWarmOceanOres.add(Ores.TETRAHEDRITE);
        listWarmOceanOres.add(Ores.STEPHANITE);
        listWarmOceanOres.add(Ores.GERSDORFFITE);
        listWarmOceanOres.add(Ores.CARROLLITE);
        listWarmOceanOres.add(Ores.MANGANITE);
        listWarmOceanOres.add(Ores.HAUSMANNITE);
        listWarmOceanOres.add(Ores.TITANITE);
        listWarmOceanOres.add(Ores.CELESTINE);
        listWarmOceanOres.add(Ores.PETALITE);
        listWarmOceanOres.add(Ores.KAINITE);
        listWarmOceanOres.add(Ores.NITRATINE);
        listWarmOceanOres.add(Ores.SPINEL_ORE);
        listWarmOceanOres.add(Ores.TOURMALINE_ORE);
        listWarmOceanOres.add(Ores.TANZANITE_ORE);
        listWarmOceanOres.add(Ores.OPAL_ORE);
        listWarmOceanOres.add(Ores.PYROPE_ORE);
        listWarmOceanOres.add(Ores.ANDRADITE_ORE);

        // COLD OCEAN ORES
        listColdOceanOres.add(Ores.SULPHUR);
        listColdOceanOres.add(Ores.CLAUSTHALITE); // ocean only
        listColdOceanOres.add(Ores.LOLLINGITE);
        listColdOceanOres.add(Ores.KESTERITE);
        listColdOceanOres.add(Ores.CERUSSITE);
        listColdOceanOres.add(Ores.HEMIMORPHITE);
        listColdOceanOres.add(Ores.FRANKLINITE);
        listColdOceanOres.add(Ores.GREENOCKITE);
        listColdOceanOres.add(Ores.ENARGITE);
        listColdOceanOres.add(Ores.COVELLITE);
        listColdOceanOres.add(Ores.CUPRITE);
        listColdOceanOres.add(Ores.ACANTHITE);
        listColdOceanOres.add(Ores.MILLERITE);
        listColdOceanOres.add(Ores.SKUTTERUDITE);
        listColdOceanOres.add(Ores.ALABANDITE);
        listColdOceanOres.add(Ores.RHODONITE);
        listColdOceanOres.add(Ores.ANATASE);
        listColdOceanOres.add(Ores.LANGBEINITE);
        listColdOceanOres.add(Ores.SUGILITE_ORE);
        listColdOceanOres.add(Ores.CHRYSOPRASE_ORE);
        listColdOceanOres.add(Ores.HAUYNE_ORE);
        listColdOceanOres.add(Ores.OPAL_ORE);
        listColdOceanOres.add(Ores.SPESSARTINE_ORE);
        listColdOceanOres.add(Ores.TSAVORITE_ORE);

        // DROUGHT ORES
        listDroughtOres.add(Ores.NITRATINE);

        // FOREST ORES
        listForestOres.add(Ores.PEAT);
        //biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(), AatoConfig.VeinSizeAdditionalPeat.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAdditionalPeat.get(), AatoConfig.MinHeightAdditionalPeat.get(), 0,AatoConfig.MaxHeightAdditionalPeat.get()))));

        // SELENIUM ORES
        listSeleniumOres.add(Ores.CLAUSTHALITE);

        ArrayList<Boolean> booleanConfigsClausthalite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsClausthalite = new ArrayList<>(4);
        booleanConfigsClausthalite.add(AatoConfig.All.get());
        booleanConfigsClausthalite.add(AatoConfig.enableClausthalite.get());
        booleanConfigsClausthalite.add(getEnabledGroupConfig(Ores.CLAUSTHALITE));
        integerConfigsClausthalite.add(AatoConfig.VeinSizeClausthalite.get());
        integerConfigsClausthalite.add(AatoConfig.VeinsPerChunkClausthalite.get());
        integerConfigsClausthalite.add(AatoConfig.MinHeightClausthalite.get());
        integerConfigsClausthalite.add(AatoConfig.MaxHeightClausthalite.get());
        booleanOreConfigMap.put(Ores.CLAUSTHALITE, booleanConfigsClausthalite);
        integerOreConfigMap.put(Ores.CLAUSTHALITE, integerConfigsClausthalite);

        // SALTPETRE ORES
        listSaltpetreOre.add(Ores.NITRATINE);

        ArrayList<Boolean> booleanConfigsNitratine = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNitratine = new ArrayList<>(4);
        booleanConfigsNitratine.add(AatoConfig.All.get());
        booleanConfigsNitratine.add(AatoConfig.enableNitratine.get());
        booleanConfigsNitratine.add(getEnabledGroupConfig(Ores.NITRATINE));
        integerConfigsNitratine.add(AatoConfig.VeinSizeNitratine.get());
        integerConfigsNitratine.add(AatoConfig.VeinsPerChunkNitratine.get());
        integerConfigsNitratine.add(AatoConfig.MinHeightNitratine.get());
        integerConfigsNitratine.add(AatoConfig.MaxHeightNitratine.get());
        booleanOreConfigMap.put(Ores.NITRATINE, booleanConfigsNitratine);
        integerOreConfigMap.put(Ores.NITRATINE, integerConfigsNitratine);

        // CADMIUM ORES
        listCadmiumOres.add(Ores.GREENOCKITE);
        listCadmiumOres.add(Ores.OTAVITE);

        ArrayList<Boolean> booleanConfigsGreenockite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGreenockite = new ArrayList<>(4);
        booleanConfigsGreenockite.add(AatoConfig.All.get());
        booleanConfigsGreenockite.add(AatoConfig.enableGreenockite.get());
        booleanConfigsGreenockite.add(getEnabledGroupConfig(Ores.GREENOCKITE));
        integerConfigsGreenockite.add(AatoConfig.VeinSizeGreenockite.get());
        integerConfigsGreenockite.add(AatoConfig.VeinsPerChunkGreenockite.get());
        integerConfigsGreenockite.add(AatoConfig.MinHeightGreenockite.get());
        integerConfigsGreenockite.add(AatoConfig.MaxHeightGreenockite.get());
        booleanOreConfigMap.put(Ores.GREENOCKITE, booleanConfigsGreenockite);
        integerOreConfigMap.put(Ores.GREENOCKITE, integerConfigsGreenockite);

        ArrayList<Boolean> booleanConfigsOtavite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsOtavite = new ArrayList<>(4);
        booleanConfigsOtavite.add(AatoConfig.All.get());
        booleanConfigsOtavite.add(AatoConfig.enableOtavite.get());
        booleanConfigsOtavite.add(getEnabledGroupConfig(Ores.OTAVITE));
        integerConfigsOtavite.add(AatoConfig.VeinSizeOtavite.get());
        integerConfigsOtavite.add(AatoConfig.VeinsPerChunkOtavite.get());
        integerConfigsOtavite.add(AatoConfig.MinHeightOtavite.get());
        integerConfigsOtavite.add(AatoConfig.MaxHeightOtavite.get());
        booleanOreConfigMap.put(Ores.OTAVITE, booleanConfigsOtavite);
        integerOreConfigMap.put(Ores.OTAVITE, integerConfigsOtavite);

        // PLATINUM GROUP METALS

        listPGMs.add(Ores.PLATINUM_GROUP_METALS);

        ArrayList<Boolean> booleanConfigsPGMs = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPGMs = new ArrayList<>(4);
        booleanConfigsPGMs.add(AatoConfig.All.get());
        booleanConfigsPGMs.add(AatoConfig.enablePGMs.get());
        booleanConfigsPGMs.add(getEnabledGroupConfig(Ores.PLATINUM_GROUP_METALS));
        integerConfigsPGMs.add(AatoConfig.VeinSizePGMs.get());
        integerConfigsPGMs.add(AatoConfig.VeinsPerChunkPGMs.get());
        integerConfigsPGMs.add(AatoConfig.MinHeightPGMs.get());
        integerConfigsPGMs.add(AatoConfig.MaxHeightPGMs.get());
        booleanOreConfigMap.put(Ores.PLATINUM_GROUP_METALS, booleanConfigsPGMs);
        integerOreConfigMap.put(Ores.PLATINUM_GROUP_METALS, integerConfigsPGMs);

        // RARE PLATINUM GROUP METALS

        listRarePGMs.add(Ores.RARE_PLATINUM_GROUP_METALS);

        ArrayList<Boolean> booleanConfigsRarePGMs = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsRarePGMs = new ArrayList<>(4);
        booleanConfigsRarePGMs.add(AatoConfig.All.get());
        booleanConfigsRarePGMs.add(AatoConfig.enableRarePGMs.get());
        booleanConfigsRarePGMs.add(AatoConfig.enabledRarePGMs.get());
        integerConfigsRarePGMs.add(AatoConfig.VeinSizeRarePGMs.get());
        integerConfigsRarePGMs.add(AatoConfig.VeinsPerChunkRarePGMs.get());
        integerConfigsRarePGMs.add(AatoConfig.MinHeightRarePGMs.get());
        integerConfigsRarePGMs.add(AatoConfig.MaxHeightRarePGMs.get());
        booleanOreConfigMap.put(Ores.RARE_PLATINUM_GROUP_METALS, booleanConfigsRarePGMs);
        integerOreConfigMap.put(Ores.RARE_PLATINUM_GROUP_METALS, integerConfigsRarePGMs);

        // SULPHUR ORES

        listSulphurOres.add(Ores.SULPHUR);
        listSulphurOres.add(Ores.PYRITE);

        ArrayList<Boolean> booleanConfigsSulphur = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSulphur = new ArrayList<>(4);
        booleanConfigsSulphur.add(AatoConfig.All.get());
        booleanConfigsSulphur.add(AatoConfig.enableSulphur.get());
        booleanConfigsSulphur.add(getEnabledGroupConfig(Ores.PLATINUM_GROUP_METALS));
        integerConfigsSulphur.add(AatoConfig.VeinSizeSulphur.get());
        integerConfigsSulphur.add(AatoConfig.VeinsPerChunkSulphur.get());
        integerConfigsSulphur.add(AatoConfig.MinHeightSulphur.get());
        integerConfigsSulphur.add(AatoConfig.MaxHeightSulphur.get());
        booleanOreConfigMap.put(Ores.SULPHUR, booleanConfigsSulphur);
        integerOreConfigMap.put(Ores.SULPHUR, integerConfigsSulphur);

        ArrayList<Boolean> booleanConfigsPyrite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPyrite = new ArrayList<>(4);
        booleanConfigsPyrite.add(AatoConfig.All.get());
        booleanConfigsPyrite.add(AatoConfig.enablePyrite.get());
        booleanConfigsPyrite.add(getEnabledGroupConfig(Ores.PLATINUM_GROUP_METALS));
        integerConfigsPyrite.add(AatoConfig.VeinSizePyrite.get());
        integerConfigsPyrite.add(AatoConfig.VeinsPerChunkPyrite.get());
        integerConfigsPyrite.add(AatoConfig.MinHeightPyrite.get());
        integerConfigsPyrite.add(AatoConfig.MaxHeightPyrite.get());
        booleanOreConfigMap.put(Ores.PYRITE, booleanConfigsPyrite);
        integerOreConfigMap.put(Ores.PYRITE, integerConfigsPyrite);

        // NPK ORES

        listNPKOres.add(Ores.GUANO);
        listNPKOres.add(Ores.PHOSPHORITE);
        listNPKOres.add(Ores.CARNALLITE);
        listNPKOres.add(Ores.SYLVITE);
        listNPKOres.add(Ores.POLYHALITE);
        listNPKOres.add(Ores.KAINITE);
        listNPKOres.add(Ores.LANGBEINITE);

        ArrayList<Boolean> booleanConfigsGuano = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGuano = new ArrayList<>(4);
        booleanConfigsGuano.add(AatoConfig.All.get());
        booleanConfigsGuano.add(AatoConfig.enableGuano.get());
        booleanConfigsGuano.add(getEnabledGroupConfig(Ores.GUANO));
        integerConfigsGuano.add(AatoConfig.VeinSizeGuano.get());
        integerConfigsGuano.add(AatoConfig.VeinsPerChunkGuano.get());
        integerConfigsGuano.add(AatoConfig.MinHeightGuano.get());
        integerConfigsGuano.add(AatoConfig.MaxHeightGuano.get());
        booleanOreConfigMap.put(Ores.GUANO, booleanConfigsGuano);
        integerOreConfigMap.put(Ores.GUANO, integerConfigsGuano);

        ArrayList<Boolean> booleanConfigsPhosphorite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPhosphorite = new ArrayList<>(4);
        booleanConfigsPhosphorite.add(AatoConfig.All.get());
        booleanConfigsPhosphorite.add(getEnabledGroupConfig(Ores.PHOSPHORITE));
        booleanConfigsPhosphorite.add(AatoConfig.enableNPKOres.get());
        integerConfigsPhosphorite.add(AatoConfig.VeinSizePhosphorite.get());
        integerConfigsPhosphorite.add(AatoConfig.VeinsPerChunkPhosphorite.get());
        integerConfigsPhosphorite.add(AatoConfig.MinHeightPhosphorite.get());
        integerConfigsPhosphorite.add(AatoConfig.MaxHeightPhosphorite.get());
        booleanOreConfigMap.put(Ores.PHOSPHORITE, booleanConfigsPhosphorite);
        integerOreConfigMap.put(Ores.PHOSPHORITE, integerConfigsPhosphorite);

        ArrayList<Boolean> booleanConfigsCarnallite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCarnallite = new ArrayList<>(4);
        booleanConfigsCarnallite.add(AatoConfig.All.get());
        booleanConfigsCarnallite.add(AatoConfig.enableCarnallite.get());
        booleanConfigsCarnallite.add(getEnabledGroupConfig(Ores.CARNALLITE));
        integerConfigsCarnallite.add(AatoConfig.VeinSizeCarnallite.get());
        integerConfigsCarnallite.add(AatoConfig.VeinsPerChunkCarnallite.get());
        integerConfigsCarnallite.add(AatoConfig.MinHeightCarnallite.get());
        integerConfigsCarnallite.add(AatoConfig.MaxHeightCarnallite.get());
        booleanOreConfigMap.put(Ores.CARNALLITE, booleanConfigsCarnallite);
        integerOreConfigMap.put(Ores.CARNALLITE, integerConfigsCarnallite);

        ArrayList<Boolean> booleanConfigsSylvite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSylvite = new ArrayList<>(4);
        booleanConfigsSylvite.add(AatoConfig.All.get());
        booleanConfigsSylvite.add(AatoConfig.enableSylvite.get());
        booleanConfigsSylvite.add(getEnabledGroupConfig(Ores.SYLVITE));
        integerConfigsSylvite.add(AatoConfig.VeinSizeSylvite.get());
        integerConfigsSylvite.add(AatoConfig.VeinsPerChunkSylvite.get());
        integerConfigsSylvite.add(AatoConfig.MinHeightSylvite.get());
        integerConfigsSylvite.add(AatoConfig.MaxHeightSylvite.get());
        booleanOreConfigMap.put(Ores.SYLVITE, booleanConfigsSylvite);
        integerOreConfigMap.put(Ores.SYLVITE, integerConfigsSylvite);

        ArrayList<Boolean> booleanConfigsPolyhalite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPolyhalite = new ArrayList<>(4);
        booleanConfigsPolyhalite.add(AatoConfig.All.get());
        booleanConfigsPolyhalite.add(AatoConfig.enablePolyhalite.get());
        booleanConfigsPolyhalite.add(getEnabledGroupConfig(Ores.POLYHALITE));
        integerConfigsPolyhalite.add(AatoConfig.VeinSizePolyhalite.get());
        integerConfigsPolyhalite.add(AatoConfig.VeinsPerChunkPolyhalite.get());
        integerConfigsPolyhalite.add(AatoConfig.MinHeightPolyhalite.get());
        integerConfigsPolyhalite.add(AatoConfig.MaxHeightPolyhalite.get());
        booleanOreConfigMap.put(Ores.POLYHALITE, booleanConfigsPolyhalite);
        integerOreConfigMap.put(Ores.POLYHALITE, integerConfigsPolyhalite);

        ArrayList<Boolean> booleanConfigsKainite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsKainite = new ArrayList<>(4);
        booleanConfigsKainite.add(AatoConfig.All.get());
        booleanConfigsKainite.add(AatoConfig.enableKainite.get());
        booleanConfigsKainite.add(getEnabledGroupConfig(Ores.KAINITE));
        integerConfigsKainite.add(AatoConfig.VeinSizeKainite.get());
        integerConfigsKainite.add(AatoConfig.VeinsPerChunkKainite.get());
        integerConfigsKainite.add(AatoConfig.MinHeightKainite.get());
        integerConfigsKainite.add(AatoConfig.MaxHeightKainite.get());
        booleanOreConfigMap.put(Ores.KAINITE, booleanConfigsKainite);
        integerOreConfigMap.put(Ores.KAINITE, integerConfigsKainite);

        ArrayList<Boolean> booleanConfigsLangbeinite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsLangbeinite = new ArrayList<>(4);
        booleanConfigsLangbeinite.add(AatoConfig.All.get());
        booleanConfigsLangbeinite.add(AatoConfig.enableLangbeinite.get());
        booleanConfigsLangbeinite.add(getEnabledGroupConfig(Ores.LANGBEINITE));
        integerConfigsLangbeinite.add(AatoConfig.VeinSizeLangbeinite.get());
        integerConfigsLangbeinite.add(AatoConfig.VeinsPerChunkLangbeinite.get());
        integerConfigsLangbeinite.add(AatoConfig.MinHeightLangbeinite.get());
        integerConfigsLangbeinite.add(AatoConfig.MaxHeightLangbeinite.get());
        booleanOreConfigMap.put(Ores.LANGBEINITE, booleanConfigsLangbeinite);
        integerOreConfigMap.put(Ores.LANGBEINITE, integerConfigsLangbeinite);

        // COAL ORES

        listCoalOres.add(Ores.LIGNITE_ORE);
        listCoalOres.add(Ores.BITUMINOUS_COAL_ORE);
        listCoalOres.add(Ores.ANTHRACITE_ORE);
        listCoalOres.add(Ores.GRAPHITE);
        listCoalOres.add(Ores.PEAT);

        ArrayList<Boolean> booleanConfigsLignite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsLignite = new ArrayList<>(4);
        booleanConfigsLignite.add(AatoConfig.All.get());
        booleanConfigsLignite.add(AatoConfig.enableLignite_ore.get());
        booleanConfigsLignite.add(getEnabledGroupConfig(Ores.LIGNITE_ORE));
        integerConfigsLignite.add(AatoConfig.VeinSizeLignite_ore.get());
        integerConfigsLignite.add(AatoConfig.VeinsPerChunkLignite_ore.get());
        integerConfigsLignite.add(AatoConfig.MinHeightLignite_ore.get());
        integerConfigsLignite.add(AatoConfig.MaxHeightLignite_ore.get());
        booleanOreConfigMap.put(Ores.LIGNITE_ORE, booleanConfigsLignite);
        integerOreConfigMap.put(Ores.LIGNITE_ORE, integerConfigsLignite);

        ArrayList<Boolean> booleanConfigsBituminous = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBituminous = new ArrayList<>(4);
        booleanConfigsBituminous.add(AatoConfig.All.get());
        booleanConfigsBituminous.add(AatoConfig.enableBituminous_coal_ore.get());
        booleanConfigsBituminous.add(getEnabledGroupConfig(Ores.BITUMINOUS_COAL_ORE));
        integerConfigsBituminous.add(AatoConfig.VeinSizeBituminous_coal_ore.get());
        integerConfigsBituminous.add(AatoConfig.VeinsPerChunkBituminous_coal_ore.get());
        integerConfigsBituminous.add(AatoConfig.MinHeightBituminous_coal_ore.get());
        integerConfigsBituminous.add(AatoConfig.MaxHeightBituminous_coal_ore.get());
        booleanOreConfigMap.put(Ores.BITUMINOUS_COAL_ORE, booleanConfigsBituminous);
        integerOreConfigMap.put(Ores.BITUMINOUS_COAL_ORE, integerConfigsBituminous);

        ArrayList<Boolean> booleanConfigsAnthracite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAnthracite = new ArrayList<>(4);
        booleanConfigsAnthracite.add(AatoConfig.All.get());
        booleanConfigsAnthracite.add(AatoConfig.enableAnthracite_ore.get());
        booleanConfigsAnthracite.add(getEnabledGroupConfig(Ores.ANTHRACITE_ORE));
        integerConfigsAnthracite.add(AatoConfig.VeinSizeAnthracite_ore.get());
        integerConfigsAnthracite.add(AatoConfig.VeinsPerChunkAnthracite_ore.get());
        integerConfigsAnthracite.add(AatoConfig.MinHeightAnthracite_ore.get());
        integerConfigsAnthracite.add(AatoConfig.MaxHeightAnthracite_ore.get());
        booleanOreConfigMap.put(Ores.ANTHRACITE_ORE, booleanConfigsAnthracite);
        integerOreConfigMap.put(Ores.ANTHRACITE_ORE, integerConfigsAnthracite);

        ArrayList<Boolean> booleanConfigsGraphite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGraphite = new ArrayList<>(4);
        booleanConfigsGraphite.add(AatoConfig.All.get());
        booleanConfigsGraphite.add(AatoConfig.enableGraphite.get());
        booleanConfigsGraphite.add(getEnabledGroupConfig(Ores.GRAPHITE));
        integerConfigsGraphite.add(AatoConfig.VeinSizeGraphite.get());
        integerConfigsGraphite.add(AatoConfig.VeinsPerChunkGraphite.get());
        integerConfigsGraphite.add(AatoConfig.MinHeightGraphite.get());
        integerConfigsGraphite.add(AatoConfig.MaxHeightGraphite.get());
        booleanOreConfigMap.put(Ores.GRAPHITE, booleanConfigsGraphite);
        integerOreConfigMap.put(Ores.GRAPHITE, integerConfigsGraphite);

        ArrayList<Boolean> booleanConfigsPeat = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPeat = new ArrayList<>(4);
        booleanConfigsPeat.add(AatoConfig.All.get());
        booleanConfigsPeat.add(AatoConfig.enablePeat.get());
        booleanConfigsPeat.add(getEnabledGroupConfig(Ores.PEAT));
        integerConfigsPeat.add(AatoConfig.VeinSizePeat.get());
        integerConfigsPeat.add(AatoConfig.VeinsPerChunkPeat.get());
        integerConfigsPeat.add(AatoConfig.MinHeightPeat.get());
        integerConfigsPeat.add(AatoConfig.MaxHeightPeat.get());
        booleanOreConfigMap.put(Ores.PEAT, booleanConfigsPeat);
        integerOreConfigMap.put(Ores.PEAT, integerConfigsPeat);

        // ARSENIC ORES

        listArsenicOres.add(Ores.ARSENOPYRITE);
        listArsenicOres.add(Ores.ORPIMENT);
        listArsenicOres.add(Ores.REALGAR);
        listArsenicOres.add(Ores.LOLLINGITE);

        ArrayList<Boolean> booleanConfigsArsenopyrite  = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsArsenopyrite  = new ArrayList<>(4);
        booleanConfigsArsenopyrite.add(AatoConfig.All.get());
        booleanConfigsArsenopyrite.add(AatoConfig.enableArsenopyrite.get());
        booleanConfigsArsenopyrite.add(getEnabledGroupConfig(Ores.ARSENOPYRITE));
        integerConfigsArsenopyrite.add(AatoConfig.VeinSizeArsenopyrite.get());
        integerConfigsArsenopyrite.add(AatoConfig.VeinsPerChunkArsenopyrite.get());
        integerConfigsArsenopyrite.add(AatoConfig.MinHeightArsenopyrite.get());
        integerConfigsArsenopyrite.add(AatoConfig.MaxHeightArsenopyrite.get());
        booleanOreConfigMap.put(Ores.ARSENOPYRITE, booleanConfigsArsenopyrite);
        integerOreConfigMap.put(Ores.ARSENOPYRITE, integerConfigsArsenopyrite);

        ArrayList<Boolean> booleanConfigsOrpiment = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsOrpiment = new ArrayList<>(4);
        booleanConfigsOrpiment.add(AatoConfig.All.get());
        booleanConfigsOrpiment.add(AatoConfig.enableOrpiment.get());
        booleanConfigsOrpiment.add(getEnabledGroupConfig(Ores.ORPIMENT));
        integerConfigsOrpiment.add(AatoConfig.VeinSizeOrpiment.get());
        integerConfigsOrpiment.add(AatoConfig.VeinsPerChunkOrpiment.get());
        integerConfigsOrpiment.add(AatoConfig.MinHeightOrpiment.get());
        integerConfigsOrpiment.add(AatoConfig.MaxHeightOrpiment.get());
        booleanOreConfigMap.put(Ores.ORPIMENT, booleanConfigsOrpiment);
        integerOreConfigMap.put(Ores.ORPIMENT, integerConfigsOrpiment);

        ArrayList<Boolean> booleanConfigsRealgar = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsRealgar = new ArrayList<>(4);
        booleanConfigsRealgar.add(AatoConfig.All.get());
        booleanConfigsRealgar.add(AatoConfig.enableRealgar.get());
        booleanConfigsRealgar.add(getEnabledGroupConfig(Ores.REALGAR));
        integerConfigsRealgar.add(AatoConfig.VeinSizeRealgar.get());
        integerConfigsRealgar.add(AatoConfig.VeinsPerChunkRealgar.get());
        integerConfigsRealgar.add(AatoConfig.MinHeightRealgar.get());
        integerConfigsRealgar.add(AatoConfig.MaxHeightRealgar.get());
        booleanOreConfigMap.put(Ores.REALGAR, booleanConfigsRealgar);
        integerOreConfigMap.put(Ores.REALGAR, integerConfigsRealgar);

        ArrayList<Boolean> booleanConfigsLollingite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsLollingite = new ArrayList<>(4);
        booleanConfigsLollingite.add(AatoConfig.All.get());
        booleanConfigsLollingite.add(AatoConfig.enableLollingite.get());
        booleanConfigsLollingite.add(getEnabledGroupConfig(Ores.LOLLINGITE));
        integerConfigsLollingite.add(AatoConfig.VeinSizeLollingite.get());
        integerConfigsLollingite.add(AatoConfig.VeinsPerChunkLollingite.get());
        integerConfigsLollingite.add(AatoConfig.MinHeightLollingite.get());
        integerConfigsLollingite.add(AatoConfig.MaxHeightLollingite.get());
        booleanOreConfigMap.put(Ores.LOLLINGITE, booleanConfigsLollingite);
        integerOreConfigMap.put(Ores.LOLLINGITE, integerConfigsLollingite);

        // ANTIMONY ORES

        listAntimonyOres.add(Ores.STIBNITE);

        ArrayList<Boolean> booleanConfigsStibnite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsStibnite = new ArrayList<>(4);
        booleanConfigsStibnite.add(AatoConfig.All.get());
        booleanConfigsStibnite.add(AatoConfig.enableStibnite.get());
        booleanConfigsStibnite.add(getEnabledGroupConfig(Ores.STIBNITE));
        integerConfigsStibnite.add(AatoConfig.VeinSizeStibnite.get());
        integerConfigsStibnite.add(AatoConfig.VeinsPerChunkStibnite.get());
        integerConfigsStibnite.add(AatoConfig.MinHeightStibnite.get());
        integerConfigsStibnite.add(AatoConfig.MaxHeightStibnite.get());
        booleanOreConfigMap.put(Ores.STIBNITE, booleanConfigsStibnite);
        integerOreConfigMap.put(Ores.STIBNITE, integerConfigsStibnite);

        // GERMANIUM ORES

        listGermaniumOres.add(Ores.GERMANITE);
        listGermaniumOres.add(Ores.ARGUTITE);

        ArrayList<Boolean> booleanConfigsGermanite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGermanite = new ArrayList<>(4);
        booleanConfigsGermanite.add(AatoConfig.All.get());
        booleanConfigsGermanite.add(AatoConfig.enableGermanite.get());
        booleanConfigsGermanite.add(getEnabledGroupConfig(Ores.GERMANITE));
        integerConfigsGermanite.add(AatoConfig.VeinSizeGermanite.get());
        integerConfigsGermanite.add(AatoConfig.VeinsPerChunkGermanite.get());
        integerConfigsGermanite.add(AatoConfig.MinHeightGermanite.get());
        integerConfigsGermanite.add(AatoConfig.MaxHeightGermanite.get());
        booleanOreConfigMap.put(Ores.GERMANITE, booleanConfigsGermanite);
        integerOreConfigMap.put(Ores.GERMANITE, integerConfigsGermanite);

        ArrayList<Boolean> booleanConfigsArgutite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsArgutite = new ArrayList<>(4);
        booleanConfigsArgutite.add(AatoConfig.All.get());
        booleanConfigsArgutite.add(AatoConfig.enableArgutite.get());
        booleanConfigsArgutite.add(getEnabledGroupConfig(Ores.ARGUTITE));
        integerConfigsArgutite.add(AatoConfig.VeinSizeArgutite.get());
        integerConfigsArgutite.add(AatoConfig.VeinsPerChunkArgutite.get());
        integerConfigsArgutite.add(AatoConfig.MinHeightArgutite.get());
        integerConfigsArgutite.add(AatoConfig.MaxHeightArgutite.get());
        booleanOreConfigMap.put(Ores.ARGUTITE, booleanConfigsArgutite);
        integerOreConfigMap.put(Ores.ARGUTITE, integerConfigsArgutite);

        // BISMUTH ORES

        listBismuthOres.add(Ores.BISMUTHINITE);
        listBismuthOres.add(Ores.NATIVE_BISMUTH);
        listBismuthOres.add(Ores.BISMITE);

        ArrayList<Boolean> booleanConfigsBismuthinite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBismuthinite = new ArrayList<>(4);
        booleanConfigsBismuthinite.add(AatoConfig.All.get());
        booleanConfigsBismuthinite.add(AatoConfig.enableBismuthinite.get());
        booleanConfigsBismuthinite.add(getEnabledGroupConfig(Ores.BISMUTHINITE));
        integerConfigsBismuthinite.add(AatoConfig.VeinSizeBismuthinite.get());
        integerConfigsBismuthinite.add(AatoConfig.VeinsPerChunkBismuthinite.get());
        integerConfigsBismuthinite.add(AatoConfig.MinHeightBismuthinite.get());
        integerConfigsBismuthinite.add(AatoConfig.MaxHeightBismuthinite.get());
        booleanOreConfigMap.put(Ores.BISMUTHINITE, booleanConfigsBismuthinite);
        integerOreConfigMap.put(Ores.BISMUTHINITE, integerConfigsBismuthinite);

        ArrayList<Boolean> booleanConfigsNative_bismuth = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNative_bismuth = new ArrayList<>(4);
        booleanConfigsNative_bismuth.add(AatoConfig.All.get());
        booleanConfigsNative_bismuth.add(AatoConfig.enableNative_bismuth.get());
        booleanConfigsNative_bismuth.add(getEnabledGroupConfig(Ores.NATIVE_BISMUTH));
        integerConfigsNative_bismuth.add(AatoConfig.VeinSizeNative_bismuth.get());
        integerConfigsNative_bismuth.add(AatoConfig.VeinsPerChunkNative_bismuth.get());
        integerConfigsNative_bismuth.add(AatoConfig.MinHeightNative_bismuth.get());
        integerConfigsNative_bismuth.add(AatoConfig.MaxHeightNative_bismuth.get());
        booleanOreConfigMap.put(Ores.NATIVE_BISMUTH, booleanConfigsNative_bismuth);
        integerOreConfigMap.put(Ores.NATIVE_BISMUTH, integerConfigsNative_bismuth);

        ArrayList<Boolean> booleanConfigsBismite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBismite = new ArrayList<>(4);
        booleanConfigsBismite.add(AatoConfig.All.get());
        booleanConfigsBismite.add(AatoConfig.enableBismite.get());
        booleanConfigsBismite.add(getEnabledGroupConfig(Ores.BISMITE));
        integerConfigsBismite.add(AatoConfig.VeinSizeBismite.get());
        integerConfigsBismite.add(AatoConfig.VeinsPerChunkBismite.get());
        integerConfigsBismite.add(AatoConfig.MinHeightBismite.get());
        integerConfigsBismite.add(AatoConfig.MaxHeightBismite.get());
        booleanOreConfigMap.put(Ores.BISMITE, booleanConfigsBismite);
        integerOreConfigMap.put(Ores.BISMITE, integerConfigsBismite);

        // TIN ORES

        listTinOres.add(Ores.CASSITERITE);
        listTinOres.add(Ores.NATIVE_TIN);
        listTinOres.add(Ores.STANNITE);
        listTinOres.add(Ores.TEALLITE);
        listTinOres.add(Ores.KESTERITE);

        ArrayList<Boolean> booleanConfigsCassiterite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCassiterite = new ArrayList<>(4);
        booleanConfigsCassiterite.add(AatoConfig.All.get());
        booleanConfigsCassiterite.add(AatoConfig.enableCassiterite.get());
        booleanConfigsCassiterite.add(getEnabledGroupConfig(Ores.CASSITERITE));
        integerConfigsCassiterite.add(AatoConfig.VeinSizeCassiterite.get());
        integerConfigsCassiterite.add(AatoConfig.VeinsPerChunkCassiterite.get());
        integerConfigsCassiterite.add(AatoConfig.MinHeightCassiterite.get());
        integerConfigsCassiterite.add(AatoConfig.MaxHeightCassiterite.get());
        booleanOreConfigMap.put(Ores.CASSITERITE, booleanConfigsCassiterite);
        integerOreConfigMap.put(Ores.CASSITERITE, integerConfigsCassiterite);

        ArrayList<Boolean> booleanConfigsNative_tin = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNative_tin = new ArrayList<>(4);
        booleanConfigsNative_tin.add(AatoConfig.All.get());
        booleanConfigsNative_tin.add(AatoConfig.enableNative_tin.get());
        booleanConfigsNative_tin.add(getEnabledGroupConfig(Ores.NATIVE_TIN));
        integerConfigsNative_tin.add(AatoConfig.VeinSizeNative_tin.get());
        integerConfigsNative_tin.add(AatoConfig.VeinsPerChunkNative_tin.get());
        integerConfigsNative_tin.add(AatoConfig.MinHeightNative_tin.get());
        integerConfigsNative_tin.add(AatoConfig.MaxHeightNative_tin.get());
        booleanOreConfigMap.put(Ores.NATIVE_TIN, booleanConfigsNative_tin);
        integerOreConfigMap.put(Ores.NATIVE_TIN, integerConfigsNative_tin);

        ArrayList<Boolean> booleanConfigsStannite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsStannite = new ArrayList<>(4);
        booleanConfigsStannite.add(AatoConfig.All.get());
        booleanConfigsStannite.add(AatoConfig.enableStannite.get());
        booleanConfigsStannite.add(getEnabledGroupConfig(Ores.STANNITE));
        integerConfigsStannite.add(AatoConfig.VeinSizeStannite.get());
        integerConfigsStannite.add(AatoConfig.VeinsPerChunkStannite.get());
        integerConfigsStannite.add(AatoConfig.MinHeightStannite.get());
        integerConfigsStannite.add(AatoConfig.MaxHeightStannite.get());
        booleanOreConfigMap.put(Ores.STANNITE, booleanConfigsStannite);
        integerOreConfigMap.put(Ores.STANNITE, integerConfigsStannite);

        ArrayList<Boolean> booleanConfigsTeallite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTeallite = new ArrayList<>(4);
        booleanConfigsTeallite.add(AatoConfig.All.get());
        booleanConfigsTeallite.add(AatoConfig.enableTeallite.get());
        booleanConfigsTeallite.add(getEnabledGroupConfig(Ores.TEALLITE));
        integerConfigsTeallite.add(AatoConfig.VeinSizeTeallite.get());
        integerConfigsTeallite.add(AatoConfig.VeinsPerChunkTeallite.get());
        integerConfigsTeallite.add(AatoConfig.MinHeightTeallite.get());
        integerConfigsTeallite.add(AatoConfig.MaxHeightTeallite.get());
        booleanOreConfigMap.put(Ores.TEALLITE, booleanConfigsTeallite);
        integerOreConfigMap.put(Ores.TEALLITE, integerConfigsTeallite);

        ArrayList<Boolean> booleanConfigsKesterite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsKesterite = new ArrayList<>(4);
        booleanConfigsKesterite.add(AatoConfig.All.get());
        booleanConfigsKesterite.add(AatoConfig.enableKesterite.get());
        booleanConfigsKesterite.add(getEnabledGroupConfig(Ores.KESTERITE));
        integerConfigsKesterite.add(AatoConfig.VeinSizeKesterite.get());
        integerConfigsKesterite.add(AatoConfig.VeinsPerChunkKesterite.get());
        integerConfigsKesterite.add(AatoConfig.MinHeightKesterite.get());
        integerConfigsKesterite.add(AatoConfig.MaxHeightKesterite.get());
        booleanOreConfigMap.put(Ores.KESTERITE, booleanConfigsKesterite);
        integerOreConfigMap.put(Ores.KESTERITE, integerConfigsKesterite);

        // LEAD ORES

        listLeadOres.add(Ores.GALENA);
        listLeadOres.add(Ores.PYROMORPHITE);
        listLeadOres.add(Ores.BOULANGERITE);
        listLeadOres.add(Ores.ANGLESITE);
        listLeadOres.add(Ores.CERUSSITE);

        ArrayList<Boolean> booleanConfigsGalena = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGalena = new ArrayList<>(4);
        booleanConfigsGalena.add(AatoConfig.All.get());
        booleanConfigsGalena.add(AatoConfig.enableGalena.get());
        booleanConfigsGalena.add(getEnabledGroupConfig(Ores.GALENA));
        integerConfigsGalena.add(AatoConfig.VeinSizeGalena.get());
        integerConfigsGalena.add(AatoConfig.VeinsPerChunkGalena.get());
        integerConfigsGalena.add(AatoConfig.MinHeightGalena.get());
        integerConfigsGalena.add(AatoConfig.MaxHeightGalena.get());
        booleanOreConfigMap.put(Ores.GALENA, booleanConfigsGalena);
        integerOreConfigMap.put(Ores.GALENA, integerConfigsGalena);

        ArrayList<Boolean> booleanConfigsPyromorphite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPyromorphite = new ArrayList<>(4);
        booleanConfigsPyromorphite.add(AatoConfig.All.get());
        booleanConfigsPyromorphite.add(AatoConfig.enablePyromorphite.get());
        booleanConfigsPyromorphite.add(getEnabledGroupConfig(Ores.PYROMORPHITE));
        integerConfigsPyromorphite.add(AatoConfig.VeinSizePyromorphite.get());
        integerConfigsPyromorphite.add(AatoConfig.VeinsPerChunkPyromorphite.get());
        integerConfigsPyromorphite.add(AatoConfig.MinHeightPyromorphite.get());
        integerConfigsPyromorphite.add(AatoConfig.MaxHeightPyromorphite.get());
        booleanOreConfigMap.put(Ores.PYROMORPHITE, booleanConfigsPyromorphite);
        integerOreConfigMap.put(Ores.PYROMORPHITE, integerConfigsPyromorphite);

        ArrayList<Boolean> booleanConfigsBoulangerite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBoulangerite = new ArrayList<>(4);
        booleanConfigsBoulangerite.add(AatoConfig.All.get());
        booleanConfigsBoulangerite.add(AatoConfig.enableBoulangerite.get());
        booleanConfigsBoulangerite.add(getEnabledGroupConfig(Ores.BOULANGERITE));
        integerConfigsBoulangerite.add(AatoConfig.VeinSizeBoulangerite.get());
        integerConfigsBoulangerite.add(AatoConfig.VeinsPerChunkBoulangerite.get());
        integerConfigsBoulangerite.add(AatoConfig.MinHeightBoulangerite.get());
        integerConfigsBoulangerite.add(AatoConfig.MaxHeightBoulangerite.get());
        booleanOreConfigMap.put(Ores.BOULANGERITE, booleanConfigsBoulangerite);
        integerOreConfigMap.put(Ores.BOULANGERITE, integerConfigsBoulangerite);

        ArrayList<Boolean> booleanConfigsAnglesite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAnglesite = new ArrayList<>(4);
        booleanConfigsAnglesite.add(AatoConfig.All.get());
        booleanConfigsAnglesite.add(AatoConfig.enableAnglesite.get());
        booleanConfigsAnglesite.add(getEnabledGroupConfig(Ores.ANGLESITE));
        integerConfigsAnglesite.add(AatoConfig.VeinSizeAnglesite.get());
        integerConfigsAnglesite.add(AatoConfig.VeinsPerChunkAnglesite.get());
        integerConfigsAnglesite.add(AatoConfig.MinHeightAnglesite.get());
        integerConfigsAnglesite.add(AatoConfig.MaxHeightAnglesite.get());
        booleanOreConfigMap.put(Ores.ANGLESITE, booleanConfigsAnglesite);
        integerOreConfigMap.put(Ores.ANGLESITE, integerConfigsAnglesite);

        ArrayList<Boolean> booleanConfigsCerussite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCerussite = new ArrayList<>(4);
        booleanConfigsCerussite.add(AatoConfig.All.get());
        booleanConfigsCerussite.add(AatoConfig.enableCerussite.get());
        booleanConfigsCerussite.add(getEnabledGroupConfig(Ores.CERUSSITE));
        integerConfigsCerussite.add(AatoConfig.VeinSizeCerussite.get());
        integerConfigsCerussite.add(AatoConfig.VeinsPerChunkCerussite.get());
        integerConfigsCerussite.add(AatoConfig.MinHeightCerussite.get());
        integerConfigsCerussite.add(AatoConfig.MaxHeightCerussite.get());
        booleanOreConfigMap.put(Ores.CERUSSITE, booleanConfigsCerussite);
        integerOreConfigMap.put(Ores.CERUSSITE, integerConfigsCerussite);

        // ALUMINUM ORES

        listAluminumOres.add(Ores.BAUXITE);
        listAluminumOres.add(Ores.NEPHELINE);
        listAluminumOres.add(Ores.LEUCITE);

        ArrayList<Boolean> booleanConfigsBauxite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBauxite = new ArrayList<>(4);
        booleanConfigsBauxite.add(AatoConfig.All.get());
        booleanConfigsBauxite.add(AatoConfig.enableBauxite.get());
        booleanConfigsBauxite.add(getEnabledGroupConfig(Ores.BAUXITE));
        integerConfigsBauxite.add(AatoConfig.VeinSizeBauxite.get());
        integerConfigsBauxite.add(AatoConfig.VeinsPerChunkBauxite.get());
        integerConfigsBauxite.add(AatoConfig.MinHeightBauxite.get());
        integerConfigsBauxite.add(AatoConfig.MaxHeightBauxite.get());
        booleanOreConfigMap.put(Ores.BAUXITE, booleanConfigsBauxite);
        integerOreConfigMap.put(Ores.BAUXITE, integerConfigsBauxite);

        ArrayList<Boolean> booleanConfigsNepheline = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNepheline = new ArrayList<>(4);
        booleanConfigsNepheline.add(AatoConfig.All.get());
        booleanConfigsNepheline.add(AatoConfig.enableNepheline.get());
        booleanConfigsNepheline.add(getEnabledGroupConfig(Ores.NEPHELINE));
        integerConfigsNepheline.add(AatoConfig.VeinSizeNepheline.get());
        integerConfigsNepheline.add(AatoConfig.VeinsPerChunkNepheline.get());
        integerConfigsNepheline.add(AatoConfig.MinHeightNepheline.get());
        integerConfigsNepheline.add(AatoConfig.MaxHeightNepheline.get());
        booleanOreConfigMap.put(Ores.NEPHELINE, booleanConfigsNepheline);
        integerOreConfigMap.put(Ores.NEPHELINE, integerConfigsNepheline);

        ArrayList<Boolean> booleanConfigsLeucite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsLeucite = new ArrayList<>(4);
        booleanConfigsLeucite.add(AatoConfig.All.get());
        booleanConfigsLeucite.add(AatoConfig.enableLeucite.get());
        booleanConfigsLeucite.add(getEnabledGroupConfig(Ores.LEUCITE));
        integerConfigsLeucite.add(AatoConfig.VeinSizeLeucite.get());
        integerConfigsLeucite.add(AatoConfig.VeinsPerChunkLeucite.get());
        integerConfigsLeucite.add(AatoConfig.MinHeightLeucite.get());
        integerConfigsLeucite.add(AatoConfig.MaxHeightLeucite.get());
        booleanOreConfigMap.put(Ores.LEUCITE, booleanConfigsLeucite);
        integerOreConfigMap.put(Ores.LEUCITE, integerConfigsLeucite);

        // ZINC ORES

        listZincOres.add(Ores.SPHALERITE);
        listZincOres.add(Ores.SMITHSONITE);
        listZincOres.add(Ores.HEMIMORPHITE);
        listZincOres.add(Ores.FRANKLINITE);
        listZincOres.add(Ores.ZINCITE);
        listZincOres.add(Ores.HYDROZINCITE);

        ArrayList<Boolean> booleanConfigsSphalerite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSphalerite = new ArrayList<>(4);
        booleanConfigsSphalerite.add(AatoConfig.All.get());
        booleanConfigsSphalerite.add(AatoConfig.enableSphalerite.get());
        booleanConfigsSphalerite.add(getEnabledGroupConfig(Ores.SPHALERITE));
        integerConfigsSphalerite.add(AatoConfig.VeinSizeSphalerite.get());
        integerConfigsSphalerite.add(AatoConfig.VeinsPerChunkSphalerite.get());
        integerConfigsSphalerite.add(AatoConfig.MinHeightSphalerite.get());
        integerConfigsSphalerite.add(AatoConfig.MaxHeightSphalerite.get());
        booleanOreConfigMap.put(Ores.SPHALERITE, booleanConfigsSphalerite);
        integerOreConfigMap.put(Ores.SPHALERITE, integerConfigsSphalerite);

        ArrayList<Boolean> booleanConfigsSmithsonite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSmithsonite = new ArrayList<>(4);
        booleanConfigsSmithsonite.add(AatoConfig.All.get());
        booleanConfigsSmithsonite.add(AatoConfig.enableSmithsonite.get());
        booleanConfigsSmithsonite.add(getEnabledGroupConfig(Ores.SMITHSONITE));
        integerConfigsSmithsonite.add(AatoConfig.VeinSizeSmithsonite.get());
        integerConfigsSmithsonite.add(AatoConfig.VeinsPerChunkSmithsonite.get());
        integerConfigsSmithsonite.add(AatoConfig.MinHeightSmithsonite.get());
        integerConfigsSmithsonite.add(AatoConfig.MaxHeightSmithsonite.get());
        booleanOreConfigMap.put(Ores.SMITHSONITE, booleanConfigsSmithsonite);
        integerOreConfigMap.put(Ores.SMITHSONITE, integerConfigsSmithsonite);

        ArrayList<Boolean> booleanConfigsHemimorphite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHemimorphite = new ArrayList<>(4);
        booleanConfigsHemimorphite.add(AatoConfig.All.get());
        booleanConfigsHemimorphite.add(AatoConfig.enableHemimorphite.get());
        booleanConfigsHemimorphite.add(getEnabledGroupConfig(Ores.HEMIMORPHITE));
        integerConfigsHemimorphite.add(AatoConfig.VeinSizeHemimorphite.get());
        integerConfigsHemimorphite.add(AatoConfig.VeinsPerChunkHemimorphite.get());
        integerConfigsHemimorphite.add(AatoConfig.MinHeightHemimorphite.get());
        integerConfigsHemimorphite.add(AatoConfig.MaxHeightHemimorphite.get());
        booleanOreConfigMap.put(Ores.HEMIMORPHITE, booleanConfigsHemimorphite);
        integerOreConfigMap.put(Ores.HEMIMORPHITE, integerConfigsHemimorphite);

        ArrayList<Boolean> booleanConfigsFranklinite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsFranklinite = new ArrayList<>(4);
        booleanConfigsFranklinite.add(AatoConfig.All.get());
        booleanConfigsFranklinite.add(AatoConfig.enableFranklinite.get());
        booleanConfigsFranklinite.add(getEnabledGroupConfig(Ores.FRANKLINITE));
        integerConfigsFranklinite.add(AatoConfig.VeinSizeFranklinite.get());
        integerConfigsFranklinite.add(AatoConfig.VeinsPerChunkFranklinite.get());
        integerConfigsFranklinite.add(AatoConfig.MinHeightFranklinite.get());
        integerConfigsFranklinite.add(AatoConfig.MaxHeightFranklinite.get());
        booleanOreConfigMap.put(Ores.FRANKLINITE, booleanConfigsFranklinite);
        integerOreConfigMap.put(Ores.FRANKLINITE, integerConfigsFranklinite);

        ArrayList<Boolean> booleanConfigsZincite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsZincite = new ArrayList<>(4);
        booleanConfigsZincite.add(AatoConfig.All.get());
        booleanConfigsZincite.add(AatoConfig.enableZincite.get());
        booleanConfigsZincite.add(getEnabledGroupConfig(Ores.ZINCITE));
        integerConfigsZincite.add(AatoConfig.VeinSizeZincite.get());
        integerConfigsZincite.add(AatoConfig.VeinsPerChunkZincite.get());
        integerConfigsZincite.add(AatoConfig.MinHeightZincite.get());
        integerConfigsZincite.add(AatoConfig.MaxHeightZincite.get());
        booleanOreConfigMap.put(Ores.ZINCITE, booleanConfigsZincite);
        integerOreConfigMap.put(Ores.ZINCITE, integerConfigsZincite);

        ArrayList<Boolean> booleanConfigsHydrozincite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHydrozincite = new ArrayList<>(4);
        booleanConfigsHydrozincite.add(AatoConfig.All.get());
        booleanConfigsHydrozincite.add(AatoConfig.enableHydrozincite.get());
        booleanConfigsHydrozincite.add(getEnabledGroupConfig(Ores.HYDROZINCITE));
        integerConfigsHydrozincite.add(AatoConfig.VeinSizeHydrozincite.get());
        integerConfigsHydrozincite.add(AatoConfig.VeinsPerChunkHydrozincite.get());
        integerConfigsHydrozincite.add(AatoConfig.MinHeightHydrozincite.get());
        integerConfigsHydrozincite.add(AatoConfig.MaxHeightHydrozincite.get());
        booleanOreConfigMap.put(Ores.HYDROZINCITE, booleanConfigsHydrozincite);
        integerOreConfigMap.put(Ores.HYDROZINCITE, integerConfigsHydrozincite);

        // MERCURY ORES

        listMercuryOres.add(Ores.CINNABAR);

        ArrayList<Boolean> booleanConfigsCinnabar = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCinnabar = new ArrayList<>(4);
        booleanConfigsCinnabar.add(AatoConfig.All.get());
        booleanConfigsCinnabar.add(AatoConfig.enableCinnabar.get());
        booleanConfigsCinnabar.add(getEnabledGroupConfig(Ores.CINNABAR));
        integerConfigsCinnabar.add(AatoConfig.VeinSizeCinnabar.get());
        integerConfigsCinnabar.add(AatoConfig.VeinsPerChunkCinnabar.get());
        integerConfigsCinnabar.add(AatoConfig.MinHeightCinnabar.get());
        integerConfigsCinnabar.add(AatoConfig.MaxHeightCinnabar.get());
        booleanOreConfigMap.put(Ores.CINNABAR, booleanConfigsCinnabar);
        integerOreConfigMap.put(Ores.CINNABAR, integerConfigsCinnabar);

        // COPPER ORES

        listCopperOres.add(Ores.CHALCOPYRITE);
        listCopperOres.add(Ores.CHALCOCITE);
        listCopperOres.add(Ores.MALACHITE);
        listCopperOres.add(Ores.NATIVE_COPPER);
        listCopperOres.add(Ores.BORNITE);
        listCopperOres.add(Ores.AZURITE);
        listCopperOres.add(Ores.TENNANTITE);
        listCopperOres.add(Ores.TETRAHEDRITE);
        listCopperOres.add(Ores.ENARGITE);
        listCopperOres.add(Ores.COVELLITE);
        listCopperOres.add(Ores.CUPRITE);

        ArrayList<Boolean> booleanConfigsChalcopyrite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsChalcopyrite = new ArrayList<>(4);
        booleanConfigsChalcopyrite.add(AatoConfig.All.get());
        booleanConfigsChalcopyrite.add(AatoConfig.enableChalcopyrite.get());
        booleanConfigsChalcopyrite.add(getEnabledGroupConfig(Ores.CHALCOPYRITE));
        integerConfigsChalcopyrite.add(AatoConfig.VeinSizeChalcopyrite.get());
        integerConfigsChalcopyrite.add(AatoConfig.VeinsPerChunkChalcopyrite.get());
        integerConfigsChalcopyrite.add(AatoConfig.MinHeightChalcopyrite.get());
        integerConfigsChalcopyrite.add(AatoConfig.MaxHeightChalcopyrite.get());
        booleanOreConfigMap.put(Ores.CHALCOPYRITE, booleanConfigsChalcopyrite);
        integerOreConfigMap.put(Ores.CHALCOPYRITE, integerConfigsChalcopyrite);

        ArrayList<Boolean> booleanConfigsChalcocite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsChalcocite = new ArrayList<>(4);
        booleanConfigsChalcocite.add(AatoConfig.All.get());
        booleanConfigsChalcocite.add(AatoConfig.enableChalcocite.get());
        booleanConfigsChalcocite.add(getEnabledGroupConfig(Ores.CHALCOCITE));
        integerConfigsChalcocite.add(AatoConfig.VeinSizeChalcocite.get());
        integerConfigsChalcocite.add(AatoConfig.VeinsPerChunkChalcocite.get());
        integerConfigsChalcocite.add(AatoConfig.MinHeightChalcocite.get());
        integerConfigsChalcocite.add(AatoConfig.MaxHeightChalcocite.get());
        booleanOreConfigMap.put(Ores.CHALCOCITE, booleanConfigsChalcocite);
        integerOreConfigMap.put(Ores.CHALCOCITE, integerConfigsChalcocite);

        ArrayList<Boolean> booleanConfigsMalachite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMalachite = new ArrayList<>(4);
        booleanConfigsMalachite.add(AatoConfig.All.get());
        booleanConfigsMalachite.add(AatoConfig.enableMalachite.get());
        booleanConfigsMalachite.add(getEnabledGroupConfig(Ores.MALACHITE));
        integerConfigsMalachite.add(AatoConfig.VeinSizeMalachite.get());
        integerConfigsMalachite.add(AatoConfig.VeinsPerChunkMalachite.get());
        integerConfigsMalachite.add(AatoConfig.MinHeightMalachite.get());
        integerConfigsMalachite.add(AatoConfig.MaxHeightMalachite.get());
        booleanOreConfigMap.put(Ores.MALACHITE, booleanConfigsMalachite);
        integerOreConfigMap.put(Ores.MALACHITE, integerConfigsMalachite);

        ArrayList<Boolean> booleanConfigsNative_copper = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNative_copper = new ArrayList<>(4);
        booleanConfigsNative_copper.add(AatoConfig.All.get());
        booleanConfigsNative_copper.add(AatoConfig.enableNative_copper.get());
        booleanConfigsNative_copper.add(getEnabledGroupConfig(Ores.NATIVE_COPPER));
        integerConfigsNative_copper.add(AatoConfig.VeinSizeNative_copper.get());
        integerConfigsNative_copper.add(AatoConfig.VeinsPerChunkNative_copper.get());
        integerConfigsNative_copper.add(AatoConfig.MinHeightNative_copper.get());
        integerConfigsNative_copper.add(AatoConfig.MaxHeightNative_copper.get());
        booleanOreConfigMap.put(Ores.NATIVE_COPPER, booleanConfigsNative_copper);
        integerOreConfigMap.put(Ores.NATIVE_COPPER, integerConfigsNative_copper);

        ArrayList<Boolean> booleanConfigsBornite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBornite = new ArrayList<>(4);
        booleanConfigsBornite.add(AatoConfig.All.get());
        booleanConfigsBornite.add(AatoConfig.enableBornite.get());
        booleanConfigsBornite.add(getEnabledGroupConfig(Ores.BORNITE));
        integerConfigsBornite.add(AatoConfig.VeinSizeBornite.get());
        integerConfigsBornite.add(AatoConfig.VeinsPerChunkBornite.get());
        integerConfigsBornite.add(AatoConfig.MinHeightBornite.get());
        integerConfigsBornite.add(AatoConfig.MaxHeightBornite.get());
        booleanOreConfigMap.put(Ores.BORNITE, booleanConfigsBornite);
        integerOreConfigMap.put(Ores.BORNITE, integerConfigsBornite);

        ArrayList<Boolean> booleanConfigsAzurite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAzurite = new ArrayList<>(4);
        booleanConfigsAzurite.add(AatoConfig.All.get());
        booleanConfigsAzurite.add(AatoConfig.enableAzurite.get());
        booleanConfigsAzurite.add(getEnabledGroupConfig(Ores.AZURITE));
        integerConfigsAzurite.add(AatoConfig.VeinSizeAzurite.get());
        integerConfigsAzurite.add(AatoConfig.VeinsPerChunkAzurite.get());
        integerConfigsAzurite.add(AatoConfig.MinHeightAzurite.get());
        integerConfigsAzurite.add(AatoConfig.MaxHeightAzurite.get());
        booleanOreConfigMap.put(Ores.AZURITE, booleanConfigsAzurite);
        integerOreConfigMap.put(Ores.AZURITE, integerConfigsAzurite);

        ArrayList<Boolean> booleanConfigsTennantite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTennantite = new ArrayList<>(4);
        booleanConfigsTennantite.add(AatoConfig.All.get());
        booleanConfigsTennantite.add(AatoConfig.enableTennantite.get());
        booleanConfigsTennantite.add(getEnabledGroupConfig(Ores.TENNANTITE));
        integerConfigsTennantite.add(AatoConfig.VeinSizeTennantite.get());
        integerConfigsTennantite.add(AatoConfig.VeinsPerChunkTennantite.get());
        integerConfigsTennantite.add(AatoConfig.MinHeightTennantite.get());
        integerConfigsTennantite.add(AatoConfig.MaxHeightTennantite.get());
        booleanOreConfigMap.put(Ores.TENNANTITE, booleanConfigsTennantite);
        integerOreConfigMap.put(Ores.TENNANTITE, integerConfigsTennantite);

        ArrayList<Boolean> booleanConfigsTetrahedrite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTetrahedrite = new ArrayList<>(4);
        booleanConfigsTetrahedrite.add(AatoConfig.All.get());
        booleanConfigsTetrahedrite.add(AatoConfig.enableTetrahedrite.get());
        booleanConfigsTetrahedrite.add(getEnabledGroupConfig(Ores.TETRAHEDRITE));
        integerConfigsTetrahedrite.add(AatoConfig.VeinSizeTetrahedrite.get());
        integerConfigsTetrahedrite.add(AatoConfig.VeinsPerChunkTetrahedrite.get());
        integerConfigsTetrahedrite.add(AatoConfig.MinHeightTetrahedrite.get());
        integerConfigsTetrahedrite.add(AatoConfig.MaxHeightTetrahedrite.get());
        booleanOreConfigMap.put(Ores.TETRAHEDRITE, booleanConfigsTetrahedrite);
        integerOreConfigMap.put(Ores.TETRAHEDRITE, integerConfigsTetrahedrite);

        ArrayList<Boolean> booleanConfigsEnargite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsEnargite = new ArrayList<>(4);
        booleanConfigsEnargite.add(AatoConfig.All.get());
        booleanConfigsEnargite.add(AatoConfig.enableEnargite.get());
        booleanConfigsEnargite.add(getEnabledGroupConfig(Ores.ENARGITE));
        integerConfigsEnargite.add(AatoConfig.VeinSizeEnargite.get());
        integerConfigsEnargite.add(AatoConfig.VeinsPerChunkEnargite.get());
        integerConfigsEnargite.add(AatoConfig.MinHeightEnargite.get());
        integerConfigsEnargite.add(AatoConfig.MaxHeightEnargite.get());
        booleanOreConfigMap.put(Ores.ENARGITE, booleanConfigsEnargite);
        integerOreConfigMap.put(Ores.ENARGITE, integerConfigsEnargite);

        ArrayList<Boolean> booleanConfigsCovellite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCovellite = new ArrayList<>(4);
        booleanConfigsCovellite.add(AatoConfig.All.get());
        booleanConfigsCovellite.add(AatoConfig.enableCovellite.get());
        booleanConfigsCovellite.add(getEnabledGroupConfig(Ores.COVELLITE));
        integerConfigsCovellite.add(AatoConfig.VeinSizeCovellite.get());
        integerConfigsCovellite.add(AatoConfig.VeinsPerChunkCovellite.get());
        integerConfigsCovellite.add(AatoConfig.MinHeightCovellite.get());
        integerConfigsCovellite.add(AatoConfig.MaxHeightCovellite.get());
        booleanOreConfigMap.put(Ores.COVELLITE, booleanConfigsCovellite);
        integerOreConfigMap.put(Ores.COVELLITE, integerConfigsCovellite);

        ArrayList<Boolean> booleanConfigsCuprite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCuprite = new ArrayList<>(4);
        booleanConfigsCuprite.add(AatoConfig.All.get());
        booleanConfigsCuprite.add(AatoConfig.enableCuprite.get());
        booleanConfigsCuprite.add(getEnabledGroupConfig(Ores.CUPRITE));
        integerConfigsCuprite.add(AatoConfig.VeinSizeCuprite.get());
        integerConfigsCuprite.add(AatoConfig.VeinsPerChunkCuprite.get());
        integerConfigsCuprite.add(AatoConfig.MinHeightCuprite.get());
        integerConfigsCuprite.add(AatoConfig.MaxHeightCuprite.get());
        booleanOreConfigMap.put(Ores.CUPRITE, booleanConfigsCuprite);
        integerOreConfigMap.put(Ores.CUPRITE, integerConfigsCuprite);

        // SILVER ORES

        listSilverOres.add(Ores.NATIVE_SILVER);
        listSilverOres.add(Ores.PROUSTITE);
        listSilverOres.add(Ores.FREIBERGITE);
        listSilverOres.add(Ores.STEPHANITE);
        listSilverOres.add(Ores.ACANTHITE);

        ArrayList<Boolean> booleanConfigsNative_silver = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNative_silver = new ArrayList<>(4);
        booleanConfigsNative_silver.add(AatoConfig.All.get());
        booleanConfigsNative_silver.add(AatoConfig.enableNative_silver.get());
        booleanConfigsNative_silver.add(getEnabledGroupConfig(Ores.NATIVE_SILVER));
        integerConfigsNative_silver.add(AatoConfig.VeinSizeNative_silver.get());
        integerConfigsNative_silver.add(AatoConfig.VeinsPerChunkNative_silver.get());
        integerConfigsNative_silver.add(AatoConfig.MinHeightNative_silver.get());
        integerConfigsNative_silver.add(AatoConfig.MaxHeightNative_silver.get());
        booleanOreConfigMap.put(Ores.NATIVE_SILVER, booleanConfigsNative_silver);
        integerOreConfigMap.put(Ores.NATIVE_SILVER, integerConfigsNative_silver);

        ArrayList<Boolean> booleanConfigsProustite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsProustite = new ArrayList<>(4);
        booleanConfigsProustite.add(AatoConfig.All.get());
        booleanConfigsProustite.add(AatoConfig.enableProustite.get());
        booleanConfigsProustite.add(getEnabledGroupConfig(Ores.PROUSTITE));
        integerConfigsProustite.add(AatoConfig.VeinSizeProustite.get());
        integerConfigsProustite.add(AatoConfig.VeinsPerChunkProustite.get());
        integerConfigsProustite.add(AatoConfig.MinHeightProustite.get());
        integerConfigsProustite.add(AatoConfig.MaxHeightProustite.get());
        booleanOreConfigMap.put(Ores.PROUSTITE, booleanConfigsProustite);
        integerOreConfigMap.put(Ores.PROUSTITE, integerConfigsProustite);

        ArrayList<Boolean> booleanConfigsFreibergite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsFreibergite = new ArrayList<>(4);
        booleanConfigsFreibergite.add(AatoConfig.All.get());
        booleanConfigsFreibergite.add(AatoConfig.enableFreibergite.get());
        booleanConfigsFreibergite.add(getEnabledGroupConfig(Ores.FREIBERGITE));
        integerConfigsFreibergite.add(AatoConfig.VeinSizeFreibergite.get());
        integerConfigsFreibergite.add(AatoConfig.VeinsPerChunkFreibergite.get());
        integerConfigsFreibergite.add(AatoConfig.MinHeightFreibergite.get());
        integerConfigsFreibergite.add(AatoConfig.MaxHeightFreibergite.get());
        booleanOreConfigMap.put(Ores.FREIBERGITE, booleanConfigsFreibergite);
        integerOreConfigMap.put(Ores.FREIBERGITE, integerConfigsFreibergite);

        ArrayList<Boolean> booleanConfigsStephanite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsStephanite = new ArrayList<>(4);
        booleanConfigsStephanite.add(AatoConfig.All.get());
        booleanConfigsStephanite.add(AatoConfig.enableStephanite.get());
        booleanConfigsStephanite.add(getEnabledGroupConfig(Ores.STEPHANITE));
        integerConfigsStephanite.add(AatoConfig.VeinSizeStephanite.get());
        integerConfigsStephanite.add(AatoConfig.VeinsPerChunkStephanite.get());
        integerConfigsStephanite.add(AatoConfig.MinHeightStephanite.get());
        integerConfigsStephanite.add(AatoConfig.MaxHeightStephanite.get());
        booleanOreConfigMap.put(Ores.STEPHANITE, booleanConfigsStephanite);
        integerOreConfigMap.put(Ores.STEPHANITE, integerConfigsStephanite);

        ArrayList<Boolean> booleanConfigsAcanthite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAcanthite = new ArrayList<>(4);
        booleanConfigsAcanthite.add(AatoConfig.All.get());
        booleanConfigsAcanthite.add(AatoConfig.enableAcanthite.get());
        booleanConfigsAcanthite.add(getEnabledGroupConfig(Ores.ACANTHITE));
        integerConfigsAcanthite.add(AatoConfig.VeinSizeAcanthite.get());
        integerConfigsAcanthite.add(AatoConfig.VeinsPerChunkAcanthite.get());
        integerConfigsAcanthite.add(AatoConfig.MinHeightAcanthite.get());
        integerConfigsAcanthite.add(AatoConfig.MaxHeightAcanthite.get());
        booleanOreConfigMap.put(Ores.ACANTHITE, booleanConfigsAcanthite);
        integerOreConfigMap.put(Ores.ACANTHITE, integerConfigsAcanthite);

        // NICKEL ORES

        listNickelOres.add(Ores.NICKELINE);
        listNickelOres.add(Ores.NEPOUITE);
        listNickelOres.add(Ores.PENTLANDITE);
        listNickelOres.add(Ores.GERSDORFFITE);
        listNickelOres.add(Ores.MILLERITE);

        ArrayList<Boolean> booleanConfigsNickeline = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNickeline = new ArrayList<>(4);
        booleanConfigsNickeline.add(AatoConfig.All.get());
        booleanConfigsNickeline.add(AatoConfig.enableNickeline.get());
        booleanConfigsNickeline.add(getEnabledGroupConfig(Ores.NICKELINE));
        integerConfigsNickeline.add(AatoConfig.VeinSizeNickeline.get());
        integerConfigsNickeline.add(AatoConfig.VeinsPerChunkNickeline.get());
        integerConfigsNickeline.add(AatoConfig.MinHeightNickeline.get());
        integerConfigsNickeline.add(AatoConfig.MaxHeightNickeline.get());
        booleanOreConfigMap.put(Ores.NICKELINE, booleanConfigsNickeline);
        integerOreConfigMap.put(Ores.NICKELINE, integerConfigsNickeline);

        ArrayList<Boolean> booleanConfigsNepouite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsNepouite = new ArrayList<>(4);
        booleanConfigsNepouite.add(AatoConfig.All.get());
        booleanConfigsNepouite.add(AatoConfig.enableNepouite.get());
        booleanConfigsNepouite.add(getEnabledGroupConfig(Ores.NEPOUITE));
        integerConfigsNepouite.add(AatoConfig.VeinSizeNepouite.get());
        integerConfigsNepouite.add(AatoConfig.VeinsPerChunkNepouite.get());
        integerConfigsNepouite.add(AatoConfig.MinHeightNepouite.get());
        integerConfigsNepouite.add(AatoConfig.MaxHeightNepouite.get());
        booleanOreConfigMap.put(Ores.NEPOUITE, booleanConfigsNepouite);
        integerOreConfigMap.put(Ores.NEPOUITE, integerConfigsNepouite);

        ArrayList<Boolean> booleanConfigsPentlandite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPentlandite = new ArrayList<>(4);
        booleanConfigsPentlandite.add(AatoConfig.All.get());
        booleanConfigsPentlandite.add(AatoConfig.enablePentlandite.get());
        booleanConfigsPentlandite.add(getEnabledGroupConfig(Ores.PENTLANDITE));
        integerConfigsPentlandite.add(AatoConfig.VeinSizePentlandite.get());
        integerConfigsPentlandite.add(AatoConfig.VeinsPerChunkPentlandite.get());
        integerConfigsPentlandite.add(AatoConfig.MinHeightPentlandite.get());
        integerConfigsPentlandite.add(AatoConfig.MaxHeightPentlandite.get());
        booleanOreConfigMap.put(Ores.PENTLANDITE, booleanConfigsPentlandite);
        integerOreConfigMap.put(Ores.PENTLANDITE, integerConfigsPentlandite);

        ArrayList<Boolean> booleanConfigsGersdorffite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGersdorffite = new ArrayList<>(4);
        booleanConfigsGersdorffite.add(AatoConfig.All.get());
        booleanConfigsGersdorffite.add(AatoConfig.enableGersdorffite.get());
        booleanConfigsGersdorffite.add(getEnabledGroupConfig(Ores.GERSDORFFITE));
        integerConfigsGersdorffite.add(AatoConfig.VeinSizeGersdorffite.get());
        integerConfigsGersdorffite.add(AatoConfig.VeinsPerChunkGersdorffite.get());
        integerConfigsGersdorffite.add(AatoConfig.MinHeightGersdorffite.get());
        integerConfigsGersdorffite.add(AatoConfig.MaxHeightGersdorffite.get());
        booleanOreConfigMap.put(Ores.GERSDORFFITE, booleanConfigsGersdorffite);
        integerOreConfigMap.put(Ores.GERSDORFFITE, integerConfigsGersdorffite);

        ArrayList<Boolean> booleanConfigsMillerite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMillerite = new ArrayList<>(4);
        booleanConfigsMillerite.add(AatoConfig.All.get());
        booleanConfigsMillerite.add(AatoConfig.enableMillerite.get());
        booleanConfigsMillerite.add(getEnabledGroupConfig(Ores.MILLERITE));
        integerConfigsMillerite.add(AatoConfig.VeinSizeMillerite.get());
        integerConfigsMillerite.add(AatoConfig.VeinsPerChunkMillerite.get());
        integerConfigsMillerite.add(AatoConfig.MinHeightMillerite.get());
        integerConfigsMillerite.add(AatoConfig.MaxHeightMillerite.get());
        booleanOreConfigMap.put(Ores.MILLERITE, booleanConfigsMillerite);
        integerOreConfigMap.put(Ores.MILLERITE, integerConfigsMillerite);

        // COBALT ORES
        listCobaltOres.add(Ores.COBALTITE);
        listCobaltOres.add(Ores.CARROLLITE);
        listCobaltOres.add(Ores.SKUTTERUDITE);

        ArrayList<Boolean> booleanConfigsCobaltite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCobaltite = new ArrayList<>(4);
        booleanConfigsCobaltite.add(AatoConfig.All.get());
        booleanConfigsCobaltite.add(AatoConfig.enableCobaltite.get());
        booleanConfigsCobaltite.add(getEnabledGroupConfig(Ores.COBALTITE));
        integerConfigsCobaltite.add(AatoConfig.VeinSizeCobaltite.get());
        integerConfigsCobaltite.add(AatoConfig.VeinsPerChunkCobaltite.get());
        integerConfigsCobaltite.add(AatoConfig.MinHeightCobaltite.get());
        integerConfigsCobaltite.add(AatoConfig.MaxHeightCobaltite.get());
        booleanOreConfigMap.put(Ores.COBALTITE, booleanConfigsCobaltite);
        integerOreConfigMap.put(Ores.COBALTITE, integerConfigsCobaltite);

        ArrayList<Boolean> booleanConfigsCarrollite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCarrollite = new ArrayList<>(4);
        booleanConfigsCarrollite.add(AatoConfig.All.get());
        booleanConfigsCarrollite.add(AatoConfig.enableCarrollite.get());
        booleanConfigsCarrollite.add(getEnabledGroupConfig(Ores.CARROLLITE));
        integerConfigsCarrollite.add(AatoConfig.VeinSizeCarrollite.get());
        integerConfigsCarrollite.add(AatoConfig.VeinsPerChunkCarrollite.get());
        integerConfigsCarrollite.add(AatoConfig.MinHeightCarrollite.get());
        integerConfigsCarrollite.add(AatoConfig.MaxHeightCarrollite.get());
        booleanOreConfigMap.put(Ores.CARROLLITE, booleanConfigsCarrollite);
        integerOreConfigMap.put(Ores.CARROLLITE, integerConfigsCarrollite);

        ArrayList<Boolean> booleanConfigsSkutterudite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSkutterudite = new ArrayList<>(4);
        booleanConfigsSkutterudite.add(AatoConfig.All.get());
        booleanConfigsSkutterudite.add(AatoConfig.enableSkutterudite.get());
        booleanConfigsSkutterudite.add(getEnabledGroupConfig(Ores.SKUTTERUDITE));
        integerConfigsSkutterudite.add(AatoConfig.VeinSizeSkutterudite.get());
        integerConfigsSkutterudite.add(AatoConfig.VeinsPerChunkSkutterudite.get());
        integerConfigsSkutterudite.add(AatoConfig.MinHeightSkutterudite.get());
        integerConfigsSkutterudite.add(AatoConfig.MaxHeightSkutterudite.get());
        booleanOreConfigMap.put(Ores.SKUTTERUDITE, booleanConfigsSkutterudite);
        integerOreConfigMap.put(Ores.SKUTTERUDITE, integerConfigsSkutterudite);

        // IRON ORES

        listIronOres.add(Ores.HEMATITE);
        listIronOres.add(Ores.MAGNETITE);
        listIronOres.add(Ores.LIMONITE);
        listIronOres.add(Ores.SIDERITE);
        listIronOres.add(Ores.HEMATITE);
        listIronOres.add(Ores.TELLURIC_IRON);

        ArrayList<Boolean> booleanConfigsHematite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHematite = new ArrayList<>(4);
        booleanConfigsHematite.add(AatoConfig.All.get());
        booleanConfigsHematite.add(AatoConfig.enableHematite.get());
        booleanConfigsHematite.add(getEnabledGroupConfig(Ores.HEMATITE));
        integerConfigsHematite.add(AatoConfig.VeinSizeHematite.get());
        integerConfigsHematite.add(AatoConfig.VeinsPerChunkHematite.get());
        integerConfigsHematite.add(AatoConfig.MinHeightHematite.get());
        integerConfigsHematite.add(AatoConfig.MaxHeightHematite.get());
        booleanOreConfigMap.put(Ores.HEMATITE, booleanConfigsHematite);
        integerOreConfigMap.put(Ores.HEMATITE, integerConfigsHematite);

        ArrayList<Boolean> booleanConfigsMagnetite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMagnetite = new ArrayList<>(4);
        booleanConfigsMagnetite.add(AatoConfig.All.get());
        booleanConfigsMagnetite.add(AatoConfig.enableMagnetite.get());
        booleanConfigsMagnetite.add(getEnabledGroupConfig(Ores.MAGNETITE));
        integerConfigsMagnetite.add(AatoConfig.VeinSizeMagnetite.get());
        integerConfigsMagnetite.add(AatoConfig.VeinsPerChunkMagnetite.get());
        integerConfigsMagnetite.add(AatoConfig.MinHeightMagnetite.get());
        integerConfigsMagnetite.add(AatoConfig.MaxHeightMagnetite.get());
        booleanOreConfigMap.put(Ores.MAGNETITE, booleanConfigsMagnetite);
        integerOreConfigMap.put(Ores.MAGNETITE, integerConfigsMagnetite);

        ArrayList<Boolean> booleanConfigsLimonite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsLimonite = new ArrayList<>(4);
        booleanConfigsLimonite.add(AatoConfig.All.get());
        booleanConfigsLimonite.add(AatoConfig.enableLimonite.get());
        booleanConfigsLimonite.add(getEnabledGroupConfig(Ores.LIMONITE));
        integerConfigsLimonite.add(AatoConfig.VeinSizeLimonite.get());
        integerConfigsLimonite.add(AatoConfig.VeinsPerChunkLimonite.get());
        integerConfigsLimonite.add(AatoConfig.MinHeightLimonite.get());
        integerConfigsLimonite.add(AatoConfig.MaxHeightLimonite.get());
        booleanOreConfigMap.put(Ores.LIMONITE, booleanConfigsLimonite);
        integerOreConfigMap.put(Ores.LIMONITE, integerConfigsLimonite);

        ArrayList<Boolean> booleanConfigsSiderite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSiderite = new ArrayList<>(4);
        booleanConfigsSiderite.add(AatoConfig.All.get());
        booleanConfigsSiderite.add(AatoConfig.enableSiderite.get());
        booleanConfigsSiderite.add(getEnabledGroupConfig(Ores.SIDERITE));
        integerConfigsSiderite.add(AatoConfig.VeinSizeSiderite.get());
        integerConfigsSiderite.add(AatoConfig.VeinsPerChunkSiderite.get());
        integerConfigsSiderite.add(AatoConfig.MinHeightSiderite.get());
        integerConfigsSiderite.add(AatoConfig.MaxHeightSiderite.get());
        booleanOreConfigMap.put(Ores.SIDERITE, booleanConfigsSiderite);
        integerOreConfigMap.put(Ores.SIDERITE, integerConfigsSiderite);

        ArrayList<Boolean> booleanConfigsTelluric_iron = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTelluric_iron = new ArrayList<>(4);
        booleanConfigsTelluric_iron.add(AatoConfig.All.get());
        booleanConfigsTelluric_iron.add(AatoConfig.enableTelluric_iron.get());
        booleanConfigsTelluric_iron.add(getEnabledGroupConfig(Ores.TELLURIC_IRON));
        integerConfigsTelluric_iron.add(AatoConfig.VeinSizeTelluric_iron.get());
        integerConfigsTelluric_iron.add(AatoConfig.VeinsPerChunkTelluric_iron.get());
        integerConfigsTelluric_iron.add(AatoConfig.MinHeightTelluric_iron.get());
        integerConfigsTelluric_iron.add(AatoConfig.MaxHeightTelluric_iron.get());
        booleanOreConfigMap.put(Ores.TELLURIC_IRON, booleanConfigsTelluric_iron);
        integerOreConfigMap.put(Ores.TELLURIC_IRON, integerConfigsTelluric_iron);

        // MANGANESE ORES

        listManganeseOres.add(Ores.PYROLUSITE);
        listManganeseOres.add(Ores.RHODOCHROSITE);
        listManganeseOres.add(Ores.HOLLANDITE);
        listCobaltOres.add(Ores.MANGANITE);
        listCobaltOres.add(Ores.HAUSMANNITE);
        listCobaltOres.add(Ores.ALABANDITE);
        listCobaltOres.add(Ores.RHODONITE);

        ArrayList<Boolean> booleanConfigsPyrolusite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPyrolusite = new ArrayList<>(4);
        booleanConfigsPyrolusite.add(AatoConfig.All.get());
        booleanConfigsPyrolusite.add(AatoConfig.enablePyrolusite.get());
        booleanConfigsPyrolusite.add(getEnabledGroupConfig(Ores.PYROLUSITE));
        integerConfigsPyrolusite.add(AatoConfig.VeinSizePyrolusite.get());
        integerConfigsPyrolusite.add(AatoConfig.VeinsPerChunkPyrolusite.get());
        integerConfigsPyrolusite.add(AatoConfig.MinHeightPyrolusite.get());
        integerConfigsPyrolusite.add(AatoConfig.MaxHeightPyrolusite.get());
        booleanOreConfigMap.put(Ores.PYROLUSITE, booleanConfigsPyrolusite);
        integerOreConfigMap.put(Ores.PYROLUSITE, integerConfigsPyrolusite);

        ArrayList<Boolean> booleanConfigsRhodochrosite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsRhodochrosite = new ArrayList<>(4);
        booleanConfigsRhodochrosite.add(AatoConfig.All.get());
        booleanConfigsRhodochrosite.add(AatoConfig.enableRhodochrosite.get());
        booleanConfigsRhodochrosite.add(getEnabledGroupConfig(Ores.RHODOCHROSITE));
        integerConfigsRhodochrosite.add(AatoConfig.VeinSizeRhodochrosite.get());
        integerConfigsRhodochrosite.add(AatoConfig.VeinsPerChunkRhodochrosite.get());
        integerConfigsRhodochrosite.add(AatoConfig.MinHeightRhodochrosite.get());
        integerConfigsRhodochrosite.add(AatoConfig.MaxHeightRhodochrosite.get());
        booleanOreConfigMap.put(Ores.RHODOCHROSITE, booleanConfigsRhodochrosite);
        integerOreConfigMap.put(Ores.RHODOCHROSITE, integerConfigsRhodochrosite);

        ArrayList<Boolean> booleanConfigsHollandite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHollandite = new ArrayList<>(4);
        booleanConfigsHollandite.add(AatoConfig.All.get());
        booleanConfigsHollandite.add(AatoConfig.enableHollandite.get());
        booleanConfigsHollandite.add(getEnabledGroupConfig(Ores.HOLLANDITE));
        integerConfigsHollandite.add(AatoConfig.VeinSizeHollandite.get());
        integerConfigsHollandite.add(AatoConfig.VeinsPerChunkHollandite.get());
        integerConfigsHollandite.add(AatoConfig.MinHeightHollandite.get());
        integerConfigsHollandite.add(AatoConfig.MaxHeightHollandite.get());
        booleanOreConfigMap.put(Ores.HOLLANDITE, booleanConfigsHollandite);
        integerOreConfigMap.put(Ores.HOLLANDITE, integerConfigsHollandite);

        ArrayList<Boolean> booleanConfigsManganite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsManganite = new ArrayList<>(4);
        booleanConfigsManganite.add(AatoConfig.All.get());
        booleanConfigsManganite.add(AatoConfig.enableManganite.get());
        booleanConfigsManganite.add(getEnabledGroupConfig(Ores.MANGANITE));
        integerConfigsManganite.add(AatoConfig.VeinSizeManganite.get());
        integerConfigsManganite.add(AatoConfig.VeinsPerChunkManganite.get());
        integerConfigsManganite.add(AatoConfig.MinHeightManganite.get());
        integerConfigsManganite.add(AatoConfig.MaxHeightManganite.get());
        booleanOreConfigMap.put(Ores.MANGANITE, booleanConfigsManganite);
        integerOreConfigMap.put(Ores.MANGANITE, integerConfigsManganite);

        ArrayList<Boolean> booleanConfigsHausmannite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHausmannite = new ArrayList<>(4);
        booleanConfigsHausmannite.add(AatoConfig.All.get());
        booleanConfigsHausmannite.add(AatoConfig.enableHausmannite.get());
        booleanConfigsHausmannite.add(getEnabledGroupConfig(Ores.HAUSMANNITE));
        integerConfigsHausmannite.add(AatoConfig.VeinSizeHausmannite.get());
        integerConfigsHausmannite.add(AatoConfig.VeinsPerChunkHausmannite.get());
        integerConfigsHausmannite.add(AatoConfig.MinHeightHausmannite.get());
        integerConfigsHausmannite.add(AatoConfig.MaxHeightHausmannite.get());
        booleanOreConfigMap.put(Ores.HAUSMANNITE, booleanConfigsHausmannite);
        integerOreConfigMap.put(Ores.HAUSMANNITE, integerConfigsHausmannite);

        ArrayList<Boolean> booleanConfigsAlabandite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAlabandite = new ArrayList<>(4);
        booleanConfigsAlabandite.add(AatoConfig.All.get());
        booleanConfigsAlabandite.add(AatoConfig.enableAlabandite.get());
        booleanConfigsAlabandite.add(getEnabledGroupConfig(Ores.ALABANDITE));
        integerConfigsAlabandite.add(AatoConfig.VeinSizeAlabandite.get());
        integerConfigsAlabandite.add(AatoConfig.VeinsPerChunkAlabandite.get());
        integerConfigsAlabandite.add(AatoConfig.MinHeightAlabandite.get());
        integerConfigsAlabandite.add(AatoConfig.MaxHeightAlabandite.get());
        booleanOreConfigMap.put(Ores.ALABANDITE, booleanConfigsAlabandite);
        integerOreConfigMap.put(Ores.ALABANDITE, integerConfigsAlabandite);

        ArrayList<Boolean> booleanConfigsRhodonite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsRhodonite = new ArrayList<>(4);
        booleanConfigsRhodonite.add(AatoConfig.All.get());
        booleanConfigsRhodonite.add(AatoConfig.enableRhodonite.get());
        booleanConfigsRhodonite.add(getEnabledGroupConfig(Ores.RHODONITE));
        integerConfigsRhodonite.add(AatoConfig.VeinSizeRhodonite.get());
        integerConfigsRhodonite.add(AatoConfig.VeinsPerChunkRhodonite.get());
        integerConfigsRhodonite.add(AatoConfig.MinHeightRhodonite.get());
        integerConfigsRhodonite.add(AatoConfig.MaxHeightRhodonite.get());
        booleanOreConfigMap.put(Ores.RHODONITE, booleanConfigsRhodonite);
        integerOreConfigMap.put(Ores.RHODONITE, integerConfigsRhodonite);

        // CHROMIUM ORES

        listChromiumOres.add(Ores.CHROMITE);

        ArrayList<Boolean> booleanConfigsChromite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsChromite = new ArrayList<>(4);
        booleanConfigsChromite.add(AatoConfig.All.get());
        booleanConfigsChromite.add(AatoConfig.enableChromite.get());
        booleanConfigsChromite.add(getEnabledGroupConfig(Ores.CHROMITE));
        integerConfigsChromite.add(AatoConfig.VeinSizeChromite.get());
        integerConfigsChromite.add(AatoConfig.VeinsPerChunkChromite.get());
        integerConfigsChromite.add(AatoConfig.MinHeightChromite.get());
        integerConfigsChromite.add(AatoConfig.MaxHeightChromite.get());
        booleanOreConfigMap.put(Ores.CHROMITE, booleanConfigsChromite);
        integerOreConfigMap.put(Ores.CHROMITE, integerConfigsChromite);

        // MOLYBDENUM ORES

        listMolybdenumOres.add(Ores.MOLYBDENITE);
        listMolybdenumOres.add(Ores.WULFENITE);

        ArrayList<Boolean> booleanConfigsMolybdenite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMolybdenite = new ArrayList<>(4);
        booleanConfigsMolybdenite.add(AatoConfig.All.get());
        booleanConfigsMolybdenite.add(AatoConfig.enableMolybdenite.get());
        booleanConfigsMolybdenite.add(getEnabledGroupConfig(Ores.MOLYBDENITE));
        integerConfigsMolybdenite.add(AatoConfig.VeinSizeMolybdenite.get());
        integerConfigsMolybdenite.add(AatoConfig.VeinsPerChunkMolybdenite.get());
        integerConfigsMolybdenite.add(AatoConfig.MinHeightMolybdenite.get());
        integerConfigsMolybdenite.add(AatoConfig.MaxHeightMolybdenite.get());
        booleanOreConfigMap.put(Ores.MOLYBDENITE, booleanConfigsMolybdenite);
        integerOreConfigMap.put(Ores.MOLYBDENITE, integerConfigsMolybdenite);

        ArrayList<Boolean> booleanConfigsWulfenite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsWulfenite = new ArrayList<>(4);
        booleanConfigsWulfenite.add(AatoConfig.All.get());
        booleanConfigsWulfenite.add(AatoConfig.enableWulfenite.get());
        booleanConfigsWulfenite.add(getEnabledGroupConfig(Ores.WULFENITE));
        integerConfigsWulfenite.add(AatoConfig.VeinSizeWulfenite.get());
        integerConfigsWulfenite.add(AatoConfig.VeinsPerChunkWulfenite.get());
        integerConfigsWulfenite.add(AatoConfig.MinHeightWulfenite.get());
        integerConfigsWulfenite.add(AatoConfig.MaxHeightWulfenite.get());
        booleanOreConfigMap.put(Ores.WULFENITE, booleanConfigsWulfenite);
        integerOreConfigMap.put(Ores.WULFENITE, integerConfigsWulfenite);

        // TUNGSTEN ORES

        listTungstenOres.add(Ores.SCHEELITE);
        listTungstenOres.add(Ores.FERBERITE);
        listTungstenOres.add(Ores.HUBNERITE);

        ArrayList<Boolean> booleanConfigsScheelite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsScheelite = new ArrayList<>(4);
        booleanConfigsScheelite.add(AatoConfig.All.get());
        booleanConfigsScheelite.add(AatoConfig.enableScheelite.get());
        booleanConfigsScheelite.add(getEnabledGroupConfig(Ores.SCHEELITE));
        integerConfigsScheelite.add(AatoConfig.VeinSizeScheelite.get());
        integerConfigsScheelite.add(AatoConfig.VeinsPerChunkScheelite.get());
        integerConfigsScheelite.add(AatoConfig.MinHeightScheelite.get());
        integerConfigsScheelite.add(AatoConfig.MaxHeightScheelite.get());
        booleanOreConfigMap.put(Ores.SCHEELITE, booleanConfigsScheelite);
        integerOreConfigMap.put(Ores.SCHEELITE, integerConfigsScheelite);

        ArrayList<Boolean> booleanConfigsFerberite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsFerberite = new ArrayList<>(4);
        booleanConfigsFerberite.add(AatoConfig.All.get());
        booleanConfigsFerberite.add(AatoConfig.enableFerberite.get());
        booleanConfigsFerberite.add(getEnabledGroupConfig(Ores.FERBERITE));
        integerConfigsFerberite.add(AatoConfig.VeinSizeFerberite.get());
        integerConfigsFerberite.add(AatoConfig.VeinsPerChunkFerberite.get());
        integerConfigsFerberite.add(AatoConfig.MinHeightFerberite.get());
        integerConfigsFerberite.add(AatoConfig.MaxHeightFerberite.get());
        booleanOreConfigMap.put(Ores.FERBERITE, booleanConfigsFerberite);
        integerOreConfigMap.put(Ores.FERBERITE, integerConfigsFerberite);

        ArrayList<Boolean> booleanConfigsHubnerite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHubnerite = new ArrayList<>(4);
        booleanConfigsHubnerite.add(AatoConfig.All.get());
        booleanConfigsHubnerite.add(AatoConfig.enableHubnerite.get());
        booleanConfigsHubnerite.add(getEnabledGroupConfig(Ores.HUBNERITE));
        integerConfigsHubnerite.add(AatoConfig.VeinSizeHubnerite.get());
        integerConfigsHubnerite.add(AatoConfig.VeinsPerChunkHubnerite.get());
        integerConfigsHubnerite.add(AatoConfig.MinHeightHubnerite.get());
        integerConfigsHubnerite.add(AatoConfig.MaxHeightHubnerite.get());
        booleanOreConfigMap.put(Ores.HUBNERITE, booleanConfigsHubnerite);
        integerOreConfigMap.put(Ores.HUBNERITE, integerConfigsHubnerite);

        // VANADIUM

        listVanadiumOres.add(Ores.VANADINITE);
        listVanadiumOres.add(Ores.DESCLOIZITE);

        ArrayList<Boolean> booleanConfigsVanadinite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsVanadinite = new ArrayList<>(4);
        booleanConfigsVanadinite.add(AatoConfig.All.get());
        booleanConfigsVanadinite.add(AatoConfig.enableVanadinite.get());
        booleanConfigsVanadinite.add(getEnabledGroupConfig(Ores.VANADINITE));
        integerConfigsVanadinite.add(AatoConfig.VeinSizeVanadinite.get());
        integerConfigsVanadinite.add(AatoConfig.VeinsPerChunkVanadinite.get());
        integerConfigsVanadinite.add(AatoConfig.MinHeightVanadinite.get());
        integerConfigsVanadinite.add(AatoConfig.MaxHeightVanadinite.get());
        booleanOreConfigMap.put(Ores.VANADINITE, booleanConfigsVanadinite);
        integerOreConfigMap.put(Ores.VANADINITE, integerConfigsVanadinite);

        ArrayList<Boolean> booleanConfigsDescloizite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsDescloizite = new ArrayList<>(4);
        booleanConfigsDescloizite.add(AatoConfig.All.get());
        booleanConfigsDescloizite.add(AatoConfig.enableDescloizite.get());
        booleanConfigsDescloizite.add(getEnabledGroupConfig(Ores.DESCLOIZITE));
        integerConfigsDescloizite.add(AatoConfig.VeinSizeDescloizite.get());
        integerConfigsDescloizite.add(AatoConfig.VeinsPerChunkDescloizite.get());
        integerConfigsDescloizite.add(AatoConfig.MinHeightDescloizite.get());
        integerConfigsDescloizite.add(AatoConfig.MaxHeightDescloizite.get());
        booleanOreConfigMap.put(Ores.DESCLOIZITE, booleanConfigsDescloizite);
        integerOreConfigMap.put(Ores.DESCLOIZITE, integerConfigsDescloizite);

        // NIOBIUM ORES

        listNiobiumOres.add(Ores.COLUMBITE);

        ArrayList<Boolean> booleanConfigsColumbite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsColumbite = new ArrayList<>(4);
        booleanConfigsColumbite.add(AatoConfig.All.get());
        booleanConfigsColumbite.add(AatoConfig.enableColumbite.get());
        booleanConfigsColumbite.add(getEnabledGroupConfig(Ores.COLUMBITE));
        integerConfigsColumbite.add(AatoConfig.VeinSizeColumbite.get());
        integerConfigsColumbite.add(AatoConfig.VeinsPerChunkColumbite.get());
        integerConfigsColumbite.add(AatoConfig.MinHeightColumbite.get());
        integerConfigsColumbite.add(AatoConfig.MaxHeightColumbite.get());
        booleanOreConfigMap.put(Ores.COLUMBITE, booleanConfigsColumbite);
        integerOreConfigMap.put(Ores.COLUMBITE, integerConfigsColumbite);

        // TANTALUM ORES

        listTantalumOres.add(Ores.TANTALITE);

        ArrayList<Boolean> booleanConfigsTantalite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTantalite = new ArrayList<>(4);
        booleanConfigsTantalite.add(AatoConfig.All.get());
        booleanConfigsTantalite.add(AatoConfig.enableTantalite.get());
        booleanConfigsTantalite.add(getEnabledGroupConfig(Ores.TANTALITE));
        integerConfigsTantalite.add(AatoConfig.VeinSizeTantalite.get());
        integerConfigsTantalite.add(AatoConfig.VeinsPerChunkTantalite.get());
        integerConfigsTantalite.add(AatoConfig.MinHeightTantalite.get());
        integerConfigsTantalite.add(AatoConfig.MaxHeightTantalite.get());
        booleanOreConfigMap.put(Ores.TANTALITE, booleanConfigsTantalite);
        integerOreConfigMap.put(Ores.TANTALITE, integerConfigsTantalite);

        // TITANIUM ORES

        listTitaniumOres.add(Ores.RUTILE);
        listTitaniumOres.add(Ores.ILMENITE);
        listTitaniumOres.add(Ores.BROOKITE);
        listTitaniumOres.add(Ores.TITANITE);
        listTitaniumOres.add(Ores.ANATASE);

        ArrayList<Boolean> booleanConfigsRutile = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsRutile = new ArrayList<>(4);
        booleanConfigsRutile.add(AatoConfig.All.get());
        booleanConfigsRutile.add(AatoConfig.enableRutile.get());
        booleanConfigsRutile.add(getEnabledGroupConfig(Ores.RUTILE));
        integerConfigsRutile.add(AatoConfig.VeinSizeRutile.get());
        integerConfigsRutile.add(AatoConfig.VeinsPerChunkRutile.get());
        integerConfigsRutile.add(AatoConfig.MinHeightRutile.get());
        integerConfigsRutile.add(AatoConfig.MaxHeightRutile.get());
        booleanOreConfigMap.put(Ores.RUTILE, booleanConfigsRutile);
        integerOreConfigMap.put(Ores.RUTILE, integerConfigsRutile);

        ArrayList<Boolean> booleanConfigsIlmenite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsIlmenite = new ArrayList<>(4);
        booleanConfigsIlmenite.add(AatoConfig.All.get());
        booleanConfigsIlmenite.add(AatoConfig.enableIlmenite.get());
        booleanConfigsIlmenite.add(getEnabledGroupConfig(Ores.ILMENITE));
        integerConfigsIlmenite.add(AatoConfig.VeinSizeIlmenite.get());
        integerConfigsIlmenite.add(AatoConfig.VeinsPerChunkIlmenite.get());
        integerConfigsIlmenite.add(AatoConfig.MinHeightIlmenite.get());
        integerConfigsIlmenite.add(AatoConfig.MaxHeightIlmenite.get());
        booleanOreConfigMap.put(Ores.ILMENITE, booleanConfigsIlmenite);
        integerOreConfigMap.put(Ores.ILMENITE, integerConfigsIlmenite);

        ArrayList<Boolean> booleanConfigsBrookite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBrookite = new ArrayList<>(4);
        booleanConfigsBrookite.add(AatoConfig.All.get());
        booleanConfigsBrookite.add(AatoConfig.enableBrookite.get());
        booleanConfigsBrookite.add(getEnabledGroupConfig(Ores.BROOKITE));
        integerConfigsBrookite.add(AatoConfig.VeinSizeBrookite.get());
        integerConfigsBrookite.add(AatoConfig.VeinsPerChunkBrookite.get());
        integerConfigsBrookite.add(AatoConfig.MinHeightBrookite.get());
        integerConfigsBrookite.add(AatoConfig.MaxHeightBrookite.get());
        booleanOreConfigMap.put(Ores.BROOKITE, booleanConfigsBrookite);
        integerOreConfigMap.put(Ores.BROOKITE, integerConfigsBrookite);

        ArrayList<Boolean> booleanConfigsTitanite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTitanite = new ArrayList<>(4);
        booleanConfigsTitanite.add(AatoConfig.All.get());
        booleanConfigsTitanite.add(AatoConfig.enableTitanite.get());
        booleanConfigsTitanite.add(getEnabledGroupConfig(Ores.TITANITE));
        integerConfigsTitanite.add(AatoConfig.VeinSizeTitanite.get());
        integerConfigsTitanite.add(AatoConfig.VeinsPerChunkTitanite.get());
        integerConfigsTitanite.add(AatoConfig.MinHeightTitanite.get());
        integerConfigsTitanite.add(AatoConfig.MaxHeightTitanite.get());
        booleanOreConfigMap.put(Ores.TITANITE, booleanConfigsTitanite);
        integerOreConfigMap.put(Ores.TITANITE, integerConfigsTitanite);

        ArrayList<Boolean> booleanConfigsAnatase = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAnatase = new ArrayList<>(4);
        booleanConfigsAnatase.add(AatoConfig.All.get());
        booleanConfigsAnatase.add(AatoConfig.enableAnatase.get());
        booleanConfigsAnatase.add(getEnabledGroupConfig(Ores.ANATASE));
        integerConfigsAnatase.add(AatoConfig.VeinSizeAnatase.get());
        integerConfigsAnatase.add(AatoConfig.VeinsPerChunkAnatase.get());
        integerConfigsAnatase.add(AatoConfig.MinHeightAnatase.get());
        integerConfigsAnatase.add(AatoConfig.MaxHeightAnatase.get());
        booleanOreConfigMap.put(Ores.ANATASE, booleanConfigsAnatase);
        integerOreConfigMap.put(Ores.ANATASE, integerConfigsAnatase);

        // ZIRCONIUM ORES

        listZirconiumOres.add(Ores.ZIRCON);

        ArrayList<Boolean> booleanConfigsZircon = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsZircon = new ArrayList<>(4);
        booleanConfigsZircon.add(AatoConfig.All.get());
        booleanConfigsZircon.add(AatoConfig.enableZircon.get());
        booleanConfigsZircon.add(getEnabledGroupConfig(Ores.ZIRCON));
        integerConfigsZircon.add(AatoConfig.VeinSizeZircon.get());
        integerConfigsZircon.add(AatoConfig.VeinsPerChunkZircon.get());
        integerConfigsZircon.add(AatoConfig.MinHeightZircon.get());
        integerConfigsZircon.add(AatoConfig.MaxHeightZircon.get());
        booleanOreConfigMap.put(Ores.ZIRCON, booleanConfigsZircon);
        integerOreConfigMap.put(Ores.ZIRCON, integerConfigsZircon);

        // THORIUM ORES

        listThoriumOres.add(Ores.THORITE);

        ArrayList<Boolean> booleanConfigsThorite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsThorite = new ArrayList<>(4);
        booleanConfigsThorite.add(AatoConfig.All.get());
        booleanConfigsThorite.add(AatoConfig.enableThorite.get());
        booleanConfigsThorite.add(getEnabledGroupConfig(Ores.THORITE));
        integerConfigsThorite.add(AatoConfig.VeinSizeThorite.get());
        integerConfigsThorite.add(AatoConfig.VeinsPerChunkThorite.get());
        integerConfigsThorite.add(AatoConfig.MinHeightThorite.get());
        integerConfigsThorite.add(AatoConfig.MaxHeightThorite.get());
        booleanOreConfigMap.put(Ores.THORITE, booleanConfigsThorite);
        integerOreConfigMap.put(Ores.THORITE, integerConfigsThorite);

        // URANIUM ORES

        listUraniumOres.add(Ores.CARNOTITE);
        listUraniumOres.add(Ores.URANINITE);

        ArrayList<Boolean> booleanConfigsCarnotite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCarnotite = new ArrayList<>(4);
        booleanConfigsCarnotite.add(AatoConfig.All.get());
        booleanConfigsCarnotite.add(AatoConfig.enableCarnotite.get());
        booleanConfigsCarnotite.add(getEnabledGroupConfig(Ores.CARNOTITE));
        integerConfigsCarnotite.add(AatoConfig.VeinSizeCarnotite.get());
        integerConfigsCarnotite.add(AatoConfig.VeinsPerChunkCarnotite.get());
        integerConfigsCarnotite.add(AatoConfig.MinHeightCarnotite.get());
        integerConfigsCarnotite.add(AatoConfig.MaxHeightCarnotite.get());
        booleanOreConfigMap.put(Ores.CARNOTITE, booleanConfigsCarnotite);
        integerOreConfigMap.put(Ores.CARNOTITE, integerConfigsCarnotite);

        ArrayList<Boolean> booleanConfigsUraninite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsUraninite = new ArrayList<>(4);
        booleanConfigsUraninite.add(AatoConfig.All.get());
        booleanConfigsUraninite.add(AatoConfig.enableUraninite.get());
        booleanConfigsUraninite.add(getEnabledGroupConfig(Ores.URANINITE));
        integerConfigsUraninite.add(AatoConfig.VeinSizeUraninite.get());
        integerConfigsUraninite.add(AatoConfig.VeinsPerChunkUraninite.get());
        integerConfigsUraninite.add(AatoConfig.MinHeightUraninite.get());
        integerConfigsUraninite.add(AatoConfig.MaxHeightUraninite.get());
        booleanOreConfigMap.put(Ores.URANINITE, booleanConfigsUraninite);
        integerOreConfigMap.put(Ores.URANINITE, integerConfigsUraninite);

        // MAGNESIUM ORES

        listMagnesiumOres.add(Ores.MAGNESITE);
        listMagnesiumOres.add(Ores.KIESERITE);
        listMagnesiumOres.add(Ores.BRUCITE);

        ArrayList<Boolean> booleanConfigsMagnesite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMagnesite = new ArrayList<>(4);
        booleanConfigsMagnesite.add(AatoConfig.All.get());
        booleanConfigsMagnesite.add(AatoConfig.enableMagnesite.get());
        booleanConfigsMagnesite.add(getEnabledGroupConfig(Ores.MAGNESITE));
        integerConfigsMagnesite.add(AatoConfig.VeinSizeMagnesite.get());
        integerConfigsMagnesite.add(AatoConfig.VeinsPerChunkMagnesite.get());
        integerConfigsMagnesite.add(AatoConfig.MinHeightMagnesite.get());
        integerConfigsMagnesite.add(AatoConfig.MaxHeightMagnesite.get());
        booleanOreConfigMap.put(Ores.MAGNESITE, booleanConfigsMagnesite);
        integerOreConfigMap.put(Ores.MAGNESITE, integerConfigsMagnesite);

        ArrayList<Boolean> booleanConfigsKieserite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsKieserite = new ArrayList<>(4);
        booleanConfigsKieserite.add(AatoConfig.All.get());
        booleanConfigsKieserite.add(AatoConfig.enableKieserite.get());
        booleanConfigsKieserite.add(getEnabledGroupConfig(Ores.KIESERITE));
        integerConfigsKieserite.add(AatoConfig.VeinSizeKieserite.get());
        integerConfigsKieserite.add(AatoConfig.VeinsPerChunkKieserite.get());
        integerConfigsKieserite.add(AatoConfig.MinHeightKieserite.get());
        integerConfigsKieserite.add(AatoConfig.MaxHeightKieserite.get());
        booleanOreConfigMap.put(Ores.KIESERITE, booleanConfigsKieserite);
        integerOreConfigMap.put(Ores.KIESERITE, integerConfigsKieserite);

        ArrayList<Boolean> booleanConfigsBrucite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsBrucite = new ArrayList<>(4);
        booleanConfigsBrucite.add(AatoConfig.All.get());
        booleanConfigsBrucite.add(AatoConfig.enableBrucite.get());
        booleanConfigsBrucite.add(getEnabledGroupConfig(Ores.BRUCITE));
        integerConfigsBrucite.add(AatoConfig.VeinSizeBrucite.get());
        integerConfigsBrucite.add(AatoConfig.VeinsPerChunkBrucite.get());
        integerConfigsBrucite.add(AatoConfig.MinHeightBrucite.get());
        integerConfigsBrucite.add(AatoConfig.MaxHeightBrucite.get());
        booleanOreConfigMap.put(Ores.BRUCITE, booleanConfigsBrucite);
        integerOreConfigMap.put(Ores.BRUCITE, integerConfigsBrucite);

        // CALCIUM ORES

        listCalciumOres.add(Ores.CALCITE);
        listCalciumOres.add(Ores.GYPSUM);
        listCalciumOres.add(Ores.ANHYDRITE);
        listCalciumOres.add(Ores.DOLOMITE);

        ArrayList<Boolean> booleanConfigsCalcite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCalcite = new ArrayList<>(4);
        booleanConfigsCalcite.add(AatoConfig.All.get());
        booleanConfigsCalcite.add(AatoConfig.enableCalcite.get());
        booleanConfigsCalcite.add(getEnabledGroupConfig(Ores.CALCITE));
        integerConfigsCalcite.add(AatoConfig.VeinSizeCalcite.get());
        integerConfigsCalcite.add(AatoConfig.VeinsPerChunkCalcite.get());
        integerConfigsCalcite.add(AatoConfig.MinHeightCalcite.get());
        integerConfigsCalcite.add(AatoConfig.MaxHeightCalcite.get());
        booleanOreConfigMap.put(Ores.CALCITE, booleanConfigsCalcite);
        integerOreConfigMap.put(Ores.CALCITE, integerConfigsCalcite);

        ArrayList<Boolean> booleanConfigsGypsum = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsGypsum = new ArrayList<>(4);
        booleanConfigsGypsum.add(AatoConfig.All.get());
        booleanConfigsGypsum.add(AatoConfig.enableGypsum.get());
        booleanConfigsGypsum.add(getEnabledGroupConfig(Ores.GYPSUM));
        integerConfigsGypsum.add(AatoConfig.VeinSizeGypsum.get());
        integerConfigsGypsum.add(AatoConfig.VeinsPerChunkGypsum.get());
        integerConfigsGypsum.add(AatoConfig.MinHeightGypsum.get());
        integerConfigsGypsum.add(AatoConfig.MaxHeightGypsum.get());
        booleanOreConfigMap.put(Ores.GYPSUM, booleanConfigsGypsum);
        integerOreConfigMap.put(Ores.GYPSUM, integerConfigsGypsum);

        ArrayList<Boolean> booleanConfigsAnhydrite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAnhydrite = new ArrayList<>(4);
        booleanConfigsAnhydrite.add(AatoConfig.All.get());
        booleanConfigsAnhydrite.add(AatoConfig.enableAnhydrite.get());
        booleanConfigsAnhydrite.add(getEnabledGroupConfig(Ores.ANHYDRITE));
        integerConfigsAnhydrite.add(AatoConfig.VeinSizeAnhydrite.get());
        integerConfigsAnhydrite.add(AatoConfig.VeinsPerChunkAnhydrite.get());
        integerConfigsAnhydrite.add(AatoConfig.MinHeightAnhydrite.get());
        integerConfigsAnhydrite.add(AatoConfig.MaxHeightAnhydrite.get());
        booleanOreConfigMap.put(Ores.ANHYDRITE, booleanConfigsAnhydrite);
        integerOreConfigMap.put(Ores.ANHYDRITE, integerConfigsAnhydrite);

        ArrayList<Boolean> booleanConfigsDolomite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsDolomite = new ArrayList<>(4);
        booleanConfigsDolomite.add(AatoConfig.All.get());
        booleanConfigsDolomite.add(AatoConfig.enableDolomite.get());
        booleanConfigsDolomite.add(getEnabledGroupConfig(Ores.DOLOMITE));
        integerConfigsDolomite.add(AatoConfig.VeinSizeDolomite.get());
        integerConfigsDolomite.add(AatoConfig.VeinsPerChunkDolomite.get());
        integerConfigsDolomite.add(AatoConfig.MinHeightDolomite.get());
        integerConfigsDolomite.add(AatoConfig.MaxHeightDolomite.get());
        booleanOreConfigMap.put(Ores.DOLOMITE, booleanConfigsDolomite);
        integerOreConfigMap.put(Ores.DOLOMITE, integerConfigsDolomite);

        // STRONTIUM ORES

        listStrontiumOres.add(Ores.STRONTIANITE);
        listStrontiumOres.add(Ores.CELESTINE);

        ArrayList<Boolean> booleanConfigsStrontianite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsStrontianite = new ArrayList<>(4);
        booleanConfigsStrontianite.add(AatoConfig.All.get());
        booleanConfigsStrontianite.add(AatoConfig.enableStrontianite.get());
        booleanConfigsStrontianite.add(getEnabledGroupConfig(Ores.STRONTIANITE));
        integerConfigsStrontianite.add(AatoConfig.VeinSizeStrontianite.get());
        integerConfigsStrontianite.add(AatoConfig.VeinsPerChunkStrontianite.get());
        integerConfigsStrontianite.add(AatoConfig.MinHeightStrontianite.get());
        integerConfigsStrontianite.add(AatoConfig.MaxHeightStrontianite.get());
        booleanOreConfigMap.put(Ores.STRONTIANITE, booleanConfigsStrontianite);
        integerOreConfigMap.put(Ores.STRONTIANITE, integerConfigsStrontianite);

        ArrayList<Boolean> booleanConfigsCelestine = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCelestine = new ArrayList<>(4);
        booleanConfigsCelestine.add(AatoConfig.All.get());
        booleanConfigsCelestine.add(AatoConfig.enableCelestine.get());
        booleanConfigsCelestine.add(getEnabledGroupConfig(Ores.CELESTINE));
        integerConfigsCelestine.add(AatoConfig.VeinSizeCelestine.get());
        integerConfigsCelestine.add(AatoConfig.VeinsPerChunkCelestine.get());
        integerConfigsCelestine.add(AatoConfig.MinHeightCelestine.get());
        integerConfigsCelestine.add(AatoConfig.MaxHeightCelestine.get());
        booleanOreConfigMap.put(Ores.CELESTINE, booleanConfigsCelestine);
        integerOreConfigMap.put(Ores.CELESTINE, integerConfigsCelestine);

        // LITHIUM ORES

        listLithiumOres.add(Ores.POLYLITHIONITE);
        listLithiumOres.add(Ores.PETALITE);

        ArrayList<Boolean> booleanConfigsPolylithionite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPolylithionite = new ArrayList<>(4);
        booleanConfigsPolylithionite.add(AatoConfig.All.get());
        booleanConfigsPolylithionite.add(AatoConfig.enablePolylithionite.get());
        booleanConfigsPolylithionite.add(getEnabledGroupConfig(Ores.POLYLITHIONITE));
        integerConfigsPolylithionite.add(AatoConfig.VeinSizePolylithionite.get());
        integerConfigsPolylithionite.add(AatoConfig.VeinsPerChunkPolylithionite.get());
        integerConfigsPolylithionite.add(AatoConfig.MinHeightPolylithionite.get());
        integerConfigsPolylithionite.add(AatoConfig.MaxHeightPolylithionite.get());
        booleanOreConfigMap.put(Ores.POLYLITHIONITE, booleanConfigsPolylithionite);
        integerOreConfigMap.put(Ores.POLYLITHIONITE, integerConfigsPolylithionite);

        ArrayList<Boolean> booleanConfigsPetalite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPetalite = new ArrayList<>(4);
        booleanConfigsPetalite.add(AatoConfig.All.get());
        booleanConfigsPetalite.add(AatoConfig.enablePetalite.get());
        booleanConfigsPetalite.add(getEnabledGroupConfig(Ores.PETALITE));
        integerConfigsPetalite.add(AatoConfig.VeinSizePetalite.get());
        integerConfigsPetalite.add(AatoConfig.VeinsPerChunkPetalite.get());
        integerConfigsPetalite.add(AatoConfig.MinHeightPetalite.get());
        integerConfigsPetalite.add(AatoConfig.MaxHeightPetalite.get());
        booleanOreConfigMap.put(Ores.PETALITE, booleanConfigsPetalite);
        integerOreConfigMap.put(Ores.PETALITE, integerConfigsPetalite);

        // SALT ORE

        listSaltOre.add(Ores.HALITE);

        ArrayList<Boolean> booleanConfigsHalite = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHalite = new ArrayList<>(4);
        booleanConfigsHalite.add(AatoConfig.All.get());
        booleanConfigsHalite.add(AatoConfig.enableHalite.get());
        booleanConfigsHalite.add(getEnabledGroupConfig(Ores.HALITE));
        integerConfigsHalite.add(AatoConfig.VeinSizeHalite.get());
        integerConfigsHalite.add(AatoConfig.VeinsPerChunkHalite.get());
        integerConfigsHalite.add(AatoConfig.MinHeightHalite.get());
        integerConfigsHalite.add(AatoConfig.MaxHeightHalite.get());
        booleanOreConfigMap.put(Ores.HALITE, booleanConfigsHalite);
        integerOreConfigMap.put(Ores.HALITE, integerConfigsHalite);

        // GEM ORES

        listAllGems.add(Ores.SAPPHIRE_ORE);
        listAllGems.add(Ores.RUBY_ORE);
        listAllGems.add(Ores.AMETHYST_ORE);
        listAllGems.add(Ores.JADE_ORE);
        listAllGems.add(Ores.PERIDOT_ORE);
        listAllGems.add(Ores.ONYX_ORE);
        listAllGems.add(Ores.TOPAZ_ORE);
        listAllGems.add(Ores.SPINEL_ORE);
        listAllGems.add(Ores.TANZANITE_ORE);
        listAllGems.add(Ores.OPAL_ORE);

        listAllGems.add(Ores.AGATE_ORE);
        listAllGems.add(Ores.CARNELIAN_ORE);
        listAllGems.add(Ores.HELIOTROPE_ORE);
        listAllGems.add(Ores.UNAKITE_ORE);
        listAllGems.add(Ores.TURQUOISE_ORE);
        listAllGems.add(Ores.AMAZONITE_ORE);
        listAllGems.add(Ores.CHRYSOCOLLA_ORE);
        listAllGems.add(Ores.HAUYNE_ORE);
        listAllGems.add(Ores.MOONSTONE_ORE);
        listAllGems.add(Ores.ALMANDINE_ORE);
        listAllGems.add(Ores.TOURMALINE_ORE);
        listAllGems.add(Ores.PYROPE_ORE);
        listAllGems.add(Ores.ANDRADITE_ORE);
        listAllGems.add(Ores.SUGILITE_ORE);
        listAllGems.add(Ores.CHRYSOPRASE_ORE);
        listAllGems.add(Ores.SPESSARTINE_ORE);
        listAllGems.add(Ores.TSAVORITE_ORE);

        listSomeGems.add(Ores.SAPPHIRE_ORE);
        listSomeGems.add(Ores.RUBY_ORE);
        listSomeGems.add(Ores.AMETHYST_ORE);
        listSomeGems.add(Ores.JADE_ORE);
        listSomeGems.add(Ores.PERIDOT_ORE);
        listSomeGems.add(Ores.ONYX_ORE);
        listSomeGems.add(Ores.TOPAZ_ORE);
        listSomeGems.add(Ores.SPINEL_ORE);
        listSomeGems.add(Ores.TANZANITE_ORE);
        listSomeGems.add(Ores.OPAL_ORE);

        ArrayList<Boolean> booleanConfigsSapphire_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsSapphire_ore = new ArrayList<>(4);
        booleanConfigsSapphire_ore.add(AatoConfig.All.get());
        booleanConfigsSapphire_ore.add(AatoConfig.enableSapphire_ore.get());
        booleanConfigsSapphire_ore.add(getEnabledGroupConfig(Ores.SAPPHIRE_ORE));
        integerConfigsSapphire_ore.add(AatoConfig.VeinSizeSapphire_ore.get());
        integerConfigsSapphire_ore.add(AatoConfig.VeinsPerChunkSapphire_ore.get());
        integerConfigsSapphire_ore.add(AatoConfig.MinHeightSapphire_ore.get());
        integerConfigsSapphire_ore.add(AatoConfig.MaxHeightSapphire_ore.get());
        booleanOreConfigMap.put(Ores.SAPPHIRE_ORE, booleanConfigsSapphire_ore);
        integerOreConfigMap.put(Ores.SAPPHIRE_ORE, integerConfigsSapphire_ore);

        ArrayList<Boolean> booleanConfigsRuby_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsRuby_ore = new ArrayList<>(4);
        booleanConfigsRuby_ore.add(AatoConfig.All.get());
        booleanConfigsRuby_ore.add(AatoConfig.enableRuby_ore.get());
        booleanConfigsRuby_ore.add(getEnabledGroupConfig(Ores.RUBY_ORE));
        integerConfigsRuby_ore.add(AatoConfig.VeinSizeRuby_ore.get());
        integerConfigsRuby_ore.add(AatoConfig.VeinsPerChunkRuby_ore.get());
        integerConfigsRuby_ore.add(AatoConfig.MinHeightRuby_ore.get());
        integerConfigsRuby_ore.add(AatoConfig.MaxHeightRuby_ore.get());
        booleanOreConfigMap.put(Ores.RUBY_ORE, booleanConfigsRuby_ore);
        integerOreConfigMap.put(Ores.RUBY_ORE, integerConfigsRuby_ore);

        ArrayList<Boolean> booleanConfigsAmethyst_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsAmethyst_ore = new ArrayList<>(4);
        booleanConfigsAmethyst_ore.add(AatoConfig.All.get());
        booleanConfigsAmethyst_ore.add(AatoConfig.enableAmethyst_ore.get());
        booleanConfigsAmethyst_ore.add(getEnabledGroupConfig(Ores.AMETHYST_ORE));
        integerConfigsAmethyst_ore.add(AatoConfig.VeinSizeAmethyst_ore.get());
        integerConfigsAmethyst_ore.add(AatoConfig.VeinsPerChunkAmethyst_ore.get());
        integerConfigsAmethyst_ore.add(AatoConfig.MinHeightAmethyst_ore.get());
        integerConfigsAmethyst_ore.add(AatoConfig.MaxHeightAmethyst_ore.get());
        booleanOreConfigMap.put(Ores.AMETHYST_ORE, booleanConfigsAmethyst_ore);
        integerOreConfigMap.put(Ores.AMETHYST_ORE, integerConfigsAmethyst_ore);

        ArrayList<Boolean> booleanConfigsJade_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsJade_ore = new ArrayList<>(4);
        booleanConfigsJade_ore.add(AatoConfig.All.get());
        booleanConfigsJade_ore.add(AatoConfig.enableJade_ore.get());
        booleanConfigsJade_ore.add(getEnabledGroupConfig(Ores.JADE_ORE));
        integerConfigsJade_ore.add(AatoConfig.VeinSizeJade_ore.get());
        integerConfigsJade_ore.add(AatoConfig.VeinsPerChunkJade_ore.get());
        integerConfigsJade_ore.add(AatoConfig.MinHeightJade_ore.get());
        integerConfigsJade_ore.add(AatoConfig.MaxHeightJade_ore.get());
        booleanOreConfigMap.put(Ores.JADE_ORE, booleanConfigsJade_ore);
        integerOreConfigMap.put(Ores.JADE_ORE, integerConfigsJade_ore);

        ArrayList<Boolean> booleanConfigsPeridot_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsPeridot_ore = new ArrayList<>(4);
        booleanConfigsPeridot_ore.add(AatoConfig.All.get());
        booleanConfigsPeridot_ore.add(AatoConfig.enablePeridot_ore.get());
        booleanConfigsPeridot_ore.add(getEnabledGroupConfig(Ores.PERIDOT_ORE));
        integerConfigsPeridot_ore.add(AatoConfig.VeinSizePeridot_ore.get());
        integerConfigsPeridot_ore.add(AatoConfig.VeinsPerChunkPeridot_ore.get());
        integerConfigsPeridot_ore.add(AatoConfig.MinHeightPeridot_ore.get());
        integerConfigsPeridot_ore.add(AatoConfig.MaxHeightPeridot_ore.get());
        booleanOreConfigMap.put(Ores.PERIDOT_ORE, booleanConfigsPeridot_ore);
        integerOreConfigMap.put(Ores.PERIDOT_ORE, integerConfigsPeridot_ore);

        ArrayList<Boolean> booleanConfigsAgate_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAgate_ore = new ArrayList<>(4);
        booleanConfigsAgate_ore.add(AatoConfig.All.get());
        booleanConfigsAgate_ore.add(AatoConfig.enableAgate_ore.get());
        booleanConfigsAgate_ore.add(getEnabledGroupConfig(Ores.AGATE_ORE));
        integerConfigsAgate_ore.add(AatoConfig.VeinSizeAgate_ore.get());
        integerConfigsAgate_ore.add(AatoConfig.VeinsPerChunkAgate_ore.get());
        integerConfigsAgate_ore.add(AatoConfig.MinHeightAgate_ore.get());
        integerConfigsAgate_ore.add(AatoConfig.MaxHeightAgate_ore.get());
        booleanOreConfigMap.put(Ores.AGATE_ORE, booleanConfigsAgate_ore);
        integerOreConfigMap.put(Ores.AGATE_ORE, integerConfigsAgate_ore);

        ArrayList<Boolean> booleanConfigsCarnelian_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsCarnelian_ore = new ArrayList<>(4);
        booleanConfigsCarnelian_ore.add(AatoConfig.All.get());
        booleanConfigsCarnelian_ore.add(AatoConfig.enableCarnelian_ore.get());
        booleanConfigsCarnelian_ore.add(getEnabledGroupConfig(Ores.CARNELIAN_ORE));
        integerConfigsCarnelian_ore.add(AatoConfig.VeinSizeCarnelian_ore.get());
        integerConfigsCarnelian_ore.add(AatoConfig.VeinsPerChunkCarnelian_ore.get());
        integerConfigsCarnelian_ore.add(AatoConfig.MinHeightCarnelian_ore.get());
        integerConfigsCarnelian_ore.add(AatoConfig.MaxHeightCarnelian_ore.get());
        booleanOreConfigMap.put(Ores.CARNELIAN_ORE, booleanConfigsCarnelian_ore);
        integerOreConfigMap.put(Ores.CARNELIAN_ORE, integerConfigsCarnelian_ore);

        ArrayList<Boolean> booleanConfigsHeliotrope_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHeliotrope_ore = new ArrayList<>(4);
        booleanConfigsHeliotrope_ore.add(AatoConfig.All.get());
        booleanConfigsHeliotrope_ore.add(AatoConfig.enableHeliotrope_ore.get());
        booleanConfigsHeliotrope_ore.add(getEnabledGroupConfig(Ores.HELIOTROPE_ORE));
        integerConfigsHeliotrope_ore.add(AatoConfig.VeinSizeHeliotrope_ore.get());
        integerConfigsHeliotrope_ore.add(AatoConfig.VeinsPerChunkHeliotrope_ore.get());
        integerConfigsHeliotrope_ore.add(AatoConfig.MinHeightHeliotrope_ore.get());
        integerConfigsHeliotrope_ore.add(AatoConfig.MaxHeightHeliotrope_ore.get());
        booleanOreConfigMap.put(Ores.HELIOTROPE_ORE, booleanConfigsHeliotrope_ore);
        integerOreConfigMap.put(Ores.HELIOTROPE_ORE, integerConfigsHeliotrope_ore);

        ArrayList<Boolean> booleanConfigsTopaz_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsTopaz_ore = new ArrayList<>(4);
        booleanConfigsTopaz_ore.add(AatoConfig.All.get());
        booleanConfigsTopaz_ore.add(AatoConfig.enableTopaz_ore.get());
        booleanConfigsTopaz_ore.add(getEnabledGroupConfig(Ores.TOPAZ_ORE));
        integerConfigsTopaz_ore.add(AatoConfig.VeinSizeTopaz_ore.get());
        integerConfigsTopaz_ore.add(AatoConfig.VeinsPerChunkTopaz_ore.get());
        integerConfigsTopaz_ore.add(AatoConfig.MinHeightTopaz_ore.get());
        integerConfigsTopaz_ore.add(AatoConfig.MaxHeightTopaz_ore.get());
        booleanOreConfigMap.put(Ores.TOPAZ_ORE, booleanConfigsTopaz_ore);
        integerOreConfigMap.put(Ores.TOPAZ_ORE, integerConfigsTopaz_ore);

        ArrayList<Boolean> booleanConfigsUnakite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsUnakite_ore = new ArrayList<>(4);
        booleanConfigsUnakite_ore.add(AatoConfig.All.get());
        booleanConfigsUnakite_ore.add(AatoConfig.enableUnakite_ore.get());
        booleanConfigsUnakite_ore.add(getEnabledGroupConfig(Ores.UNAKITE_ORE));
        integerConfigsUnakite_ore.add(AatoConfig.VeinSizeUnakite_ore.get());
        integerConfigsUnakite_ore.add(AatoConfig.VeinsPerChunkUnakite_ore.get());
        integerConfigsUnakite_ore.add(AatoConfig.MinHeightUnakite_ore.get());
        integerConfigsUnakite_ore.add(AatoConfig.MaxHeightUnakite_ore.get());
        booleanOreConfigMap.put(Ores.UNAKITE_ORE, booleanConfigsUnakite_ore);
        integerOreConfigMap.put(Ores.UNAKITE_ORE, integerConfigsUnakite_ore);

        ArrayList<Boolean> booleanConfigsOnyx_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsOnyx_ore = new ArrayList<>(4);
        booleanConfigsOnyx_ore.add(AatoConfig.All.get());
        booleanConfigsOnyx_ore.add(AatoConfig.enableOnyx_ore.get());
        booleanConfigsOnyx_ore.add(getEnabledGroupConfig(Ores.ONYX_ORE));
        integerConfigsOnyx_ore.add(AatoConfig.VeinSizeOnyx_ore.get());
        integerConfigsOnyx_ore.add(AatoConfig.VeinsPerChunkOnyx_ore.get());
        integerConfigsOnyx_ore.add(AatoConfig.MinHeightOnyx_ore.get());
        integerConfigsOnyx_ore.add(AatoConfig.MaxHeightOnyx_ore.get());
        booleanOreConfigMap.put(Ores.ONYX_ORE, booleanConfigsOnyx_ore);
        integerOreConfigMap.put(Ores.ONYX_ORE, integerConfigsOnyx_ore);

        ArrayList<Boolean> booleanConfigsTurquoise_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTurquoise_ore = new ArrayList<>(4);
        booleanConfigsTurquoise_ore.add(AatoConfig.All.get());
        booleanConfigsTurquoise_ore.add(AatoConfig.enableTurquoise_ore.get());
        booleanConfigsTurquoise_ore.add(getEnabledGroupConfig(Ores.TURQUOISE_ORE));
        integerConfigsTurquoise_ore.add(AatoConfig.VeinSizeTurquoise_ore.get());
        integerConfigsTurquoise_ore.add(AatoConfig.VeinsPerChunkTurquoise_ore.get());
        integerConfigsTurquoise_ore.add(AatoConfig.MinHeightTurquoise_ore.get());
        integerConfigsTurquoise_ore.add(AatoConfig.MaxHeightTurquoise_ore.get());
        booleanOreConfigMap.put(Ores.TURQUOISE_ORE, booleanConfigsTurquoise_ore);
        integerOreConfigMap.put(Ores.TURQUOISE_ORE, integerConfigsTurquoise_ore);

        ArrayList<Boolean> booleanConfigsAmazonite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAmazonite_ore = new ArrayList<>(4);
        booleanConfigsAmazonite_ore.add(AatoConfig.All.get());
        booleanConfigsAmazonite_ore.add(AatoConfig.enableAmazonite_ore.get());
        booleanConfigsAmazonite_ore.add(getEnabledGroupConfig(Ores.AMAZONITE_ORE));
        integerConfigsAmazonite_ore.add(AatoConfig.VeinSizeAmazonite_ore.get());
        integerConfigsAmazonite_ore.add(AatoConfig.VeinsPerChunkAmazonite_ore.get());
        integerConfigsAmazonite_ore.add(AatoConfig.MinHeightAmazonite_ore.get());
        integerConfigsAmazonite_ore.add(AatoConfig.MaxHeightAmazonite_ore.get());
        booleanOreConfigMap.put(Ores.AMAZONITE_ORE, booleanConfigsAmazonite_ore);
        integerOreConfigMap.put(Ores.AMAZONITE_ORE, integerConfigsAmazonite_ore);

        // CHRYSOCOLLA ORE, GEM ORE activated also by STONE AGE

        ArrayList<Boolean> booleanConfigsChrysocolla_ore = new ArrayList<>(4);
        ArrayList<Integer> integerConfigsChrysocolla_ore = new ArrayList<>(4);
        booleanConfigsChrysocolla_ore.add(AatoConfig.All.get());
        booleanConfigsChrysocolla_ore.add(AatoConfig.enableChrysocolla_ore.get());
        booleanConfigsChrysocolla_ore.add(getEnabledGroupConfig(Ores.CHRYSOCOLLA_ORE));
        booleanConfigsChrysocolla_ore.add(AatoConfig.enableStoneAge.get());
        integerConfigsChrysocolla_ore.add(AatoConfig.VeinSizeChrysocolla_ore.get());
        integerConfigsChrysocolla_ore.add(AatoConfig.VeinsPerChunkChrysocolla_ore.get());
        integerConfigsChrysocolla_ore.add(AatoConfig.MinHeightChrysocolla_ore.get());
        integerConfigsChrysocolla_ore.add(AatoConfig.MaxHeightChrysocolla_ore.get());
        booleanOreConfigMap.put(Ores.CHRYSOCOLLA_ORE, booleanConfigsChrysocolla_ore);
        integerOreConfigMap.put(Ores.CHRYSOCOLLA_ORE, integerConfigsChrysocolla_ore);

        ArrayList<Boolean> booleanConfigsHauyne_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsHauyne_ore = new ArrayList<>(4);
        booleanConfigsHauyne_ore.add(AatoConfig.All.get());
        booleanConfigsHauyne_ore.add(AatoConfig.enableHauyne_ore.get());
        booleanConfigsHauyne_ore.add(getEnabledGroupConfig(Ores.HAUYNE_ORE));
        integerConfigsHauyne_ore.add(AatoConfig.VeinSizeHauyne_ore.get());
        integerConfigsHauyne_ore.add(AatoConfig.VeinsPerChunkHauyne_ore.get());
        integerConfigsHauyne_ore.add(AatoConfig.MinHeightHauyne_ore.get());
        integerConfigsHauyne_ore.add(AatoConfig.MaxHeightHauyne_ore.get());
        booleanOreConfigMap.put(Ores.HAUYNE_ORE, booleanConfigsHauyne_ore);
        integerOreConfigMap.put(Ores.HAUYNE_ORE, integerConfigsHauyne_ore);

        ArrayList<Boolean> booleanConfigsMoonstone_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMoonstone_ore = new ArrayList<>(4);
        booleanConfigsMoonstone_ore.add(AatoConfig.All.get());
        booleanConfigsMoonstone_ore.add(AatoConfig.enableMoonstone_ore.get());
        booleanConfigsMoonstone_ore.add(getEnabledGroupConfig(Ores.MOONSTONE_ORE));
        integerConfigsMoonstone_ore.add(AatoConfig.VeinSizeMoonstone_ore.get());
        integerConfigsMoonstone_ore.add(AatoConfig.VeinsPerChunkMoonstone_ore.get());
        integerConfigsMoonstone_ore.add(AatoConfig.MinHeightMoonstone_ore.get());
        integerConfigsMoonstone_ore.add(AatoConfig.MaxHeightMoonstone_ore.get());
        booleanOreConfigMap.put(Ores.MOONSTONE_ORE, booleanConfigsMoonstone_ore);
        integerOreConfigMap.put(Ores.MOONSTONE_ORE, integerConfigsMoonstone_ore);

        ArrayList<Boolean> booleanConfigsAlmandine_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAlmandine_ore = new ArrayList<>(4);
        booleanConfigsAlmandine_ore.add(AatoConfig.All.get());
        booleanConfigsAlmandine_ore.add(AatoConfig.enableAlmandine_ore.get());
        booleanConfigsAlmandine_ore.add(getEnabledGroupConfig(Ores.ALMANDINE_ORE));
        integerConfigsAlmandine_ore.add(AatoConfig.VeinSizeAlmandine_ore.get());
        integerConfigsAlmandine_ore.add(AatoConfig.VeinsPerChunkAlmandine_ore.get());
        integerConfigsAlmandine_ore.add(AatoConfig.MinHeightAlmandine_ore.get());
        integerConfigsAlmandine_ore.add(AatoConfig.MaxHeightAlmandine_ore.get());
        booleanOreConfigMap.put(Ores.ALMANDINE_ORE, booleanConfigsAlmandine_ore);
        integerOreConfigMap.put(Ores.ALMANDINE_ORE, integerConfigsAlmandine_ore);

        ArrayList<Boolean> booleanConfigsSpinel_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSpinel_ore = new ArrayList<>(4);
        booleanConfigsSpinel_ore.add(AatoConfig.All.get());
        booleanConfigsSpinel_ore.add(AatoConfig.enableSpinel_ore.get());
        booleanConfigsSpinel_ore.add(getEnabledGroupConfig(Ores.SPINEL_ORE));
        integerConfigsSpinel_ore.add(AatoConfig.VeinSizeSpinel_ore.get());
        integerConfigsSpinel_ore.add(AatoConfig.VeinsPerChunkSpinel_ore.get());
        integerConfigsSpinel_ore.add(AatoConfig.MinHeightSpinel_ore.get());
        integerConfigsSpinel_ore.add(AatoConfig.MaxHeightSpinel_ore.get());
        booleanOreConfigMap.put(Ores.SPINEL_ORE, booleanConfigsSpinel_ore);
        integerOreConfigMap.put(Ores.SPINEL_ORE, integerConfigsSpinel_ore);

        ArrayList<Boolean> booleanConfigsTourmaline_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTourmaline_ore = new ArrayList<>(4);
        booleanConfigsTourmaline_ore.add(AatoConfig.All.get());
        booleanConfigsTourmaline_ore.add(AatoConfig.enableTourmaline_ore.get());
        booleanConfigsTourmaline_ore.add(getEnabledGroupConfig(Ores.TOURMALINE_ORE));
        integerConfigsTourmaline_ore.add(AatoConfig.VeinSizeTourmaline_ore.get());
        integerConfigsTourmaline_ore.add(AatoConfig.VeinsPerChunkTourmaline_ore.get());
        integerConfigsTourmaline_ore.add(AatoConfig.MinHeightTourmaline_ore.get());
        integerConfigsTourmaline_ore.add(AatoConfig.MaxHeightTourmaline_ore.get());
        booleanOreConfigMap.put(Ores.TOURMALINE_ORE, booleanConfigsTourmaline_ore);
        integerOreConfigMap.put(Ores.TOURMALINE_ORE, integerConfigsTourmaline_ore);

        ArrayList<Boolean> booleanConfigsTanzanite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTanzanite_ore = new ArrayList<>(4);
        booleanConfigsTanzanite_ore.add(AatoConfig.All.get());
        booleanConfigsTanzanite_ore.add(AatoConfig.enableTanzanite_ore.get());
        booleanConfigsTanzanite_ore.add(getEnabledGroupConfig(Ores.TANZANITE_ORE));
        integerConfigsTanzanite_ore.add(AatoConfig.VeinSizeTanzanite_ore.get());
        integerConfigsTanzanite_ore.add(AatoConfig.VeinsPerChunkTanzanite_ore.get());
        integerConfigsTanzanite_ore.add(AatoConfig.MinHeightTanzanite_ore.get());
        integerConfigsTanzanite_ore.add(AatoConfig.MaxHeightTanzanite_ore.get());
        booleanOreConfigMap.put(Ores.TANZANITE_ORE, booleanConfigsTanzanite_ore);
        integerOreConfigMap.put(Ores.TANZANITE_ORE, integerConfigsTanzanite_ore);

        ArrayList<Boolean> booleanConfigsOpal_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsOpal_ore = new ArrayList<>(4);
        booleanConfigsOpal_ore.add(AatoConfig.All.get());
        booleanConfigsOpal_ore.add(AatoConfig.enableOpal_ore.get());
        booleanConfigsOpal_ore.add(getEnabledGroupConfig(Ores.OPAL_ORE));
        integerConfigsOpal_ore.add(AatoConfig.VeinSizeOpal_ore.get());
        integerConfigsOpal_ore.add(AatoConfig.VeinsPerChunkOpal_ore.get());
        integerConfigsOpal_ore.add(AatoConfig.MinHeightOpal_ore.get());
        integerConfigsOpal_ore.add(AatoConfig.MaxHeightOpal_ore.get());
        booleanOreConfigMap.put(Ores.OPAL_ORE, booleanConfigsOpal_ore);
        integerOreConfigMap.put(Ores.OPAL_ORE, integerConfigsOpal_ore);

        ArrayList<Boolean> booleanConfigsPyrope_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsPyrope_ore = new ArrayList<>(4);
        booleanConfigsPyrope_ore.add(AatoConfig.All.get());
        booleanConfigsPyrope_ore.add(AatoConfig.enablePyrope_ore.get());
        booleanConfigsPyrope_ore.add(getEnabledGroupConfig(Ores.PYROPE_ORE));
        integerConfigsPyrope_ore.add(AatoConfig.VeinSizePyrope_ore.get());
        integerConfigsPyrope_ore.add(AatoConfig.VeinsPerChunkPyrope_ore.get());
        integerConfigsPyrope_ore.add(AatoConfig.MinHeightPyrope_ore.get());
        integerConfigsPyrope_ore.add(AatoConfig.MaxHeightPyrope_ore.get());
        booleanOreConfigMap.put(Ores.PYROPE_ORE, booleanConfigsPyrope_ore);
        integerOreConfigMap.put(Ores.PYROPE_ORE, integerConfigsPyrope_ore);

        ArrayList<Boolean> booleanConfigsAndradite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsAndradite_ore = new ArrayList<>(4);
        booleanConfigsAndradite_ore.add(AatoConfig.All.get());
        booleanConfigsAndradite_ore.add(AatoConfig.enableAndradite_ore.get());
        booleanConfigsAndradite_ore.add(getEnabledGroupConfig(Ores.ANDRADITE_ORE));
        integerConfigsAndradite_ore.add(AatoConfig.VeinSizeAndradite_ore.get());
        integerConfigsAndradite_ore.add(AatoConfig.VeinsPerChunkAndradite_ore.get());
        integerConfigsAndradite_ore.add(AatoConfig.MinHeightAndradite_ore.get());
        integerConfigsAndradite_ore.add(AatoConfig.MaxHeightAndradite_ore.get());
        booleanOreConfigMap.put(Ores.ANDRADITE_ORE, booleanConfigsAndradite_ore);
        integerOreConfigMap.put(Ores.ANDRADITE_ORE, integerConfigsAndradite_ore);

        ArrayList<Boolean> booleanConfigsSugilite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSugilite_ore = new ArrayList<>(4);
        booleanConfigsSugilite_ore.add(AatoConfig.All.get());
        booleanConfigsSugilite_ore.add(AatoConfig.enableSugilite_ore.get());
        booleanConfigsSugilite_ore.add(getEnabledGroupConfig(Ores.SUGILITE_ORE));
        integerConfigsSugilite_ore.add(AatoConfig.VeinSizeSugilite_ore.get());
        integerConfigsSugilite_ore.add(AatoConfig.VeinsPerChunkSugilite_ore.get());
        integerConfigsSugilite_ore.add(AatoConfig.MinHeightSugilite_ore.get());
        integerConfigsSugilite_ore.add(AatoConfig.MaxHeightSugilite_ore.get());
        booleanOreConfigMap.put(Ores.SUGILITE_ORE, booleanConfigsSugilite_ore);
        integerOreConfigMap.put(Ores.SUGILITE_ORE, integerConfigsSugilite_ore);

        ArrayList<Boolean> booleanConfigsChrysoprase_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsChrysoprase_ore = new ArrayList<>(4);
        booleanConfigsChrysoprase_ore.add(AatoConfig.All.get());
        booleanConfigsChrysoprase_ore.add(AatoConfig.enableChrysoprase_ore.get());
        booleanConfigsChrysoprase_ore.add(getEnabledGroupConfig(Ores.CHRYSOPRASE_ORE));
        integerConfigsChrysoprase_ore.add(AatoConfig.VeinSizeChrysoprase_ore.get());
        integerConfigsChrysoprase_ore.add(AatoConfig.VeinsPerChunkChrysoprase_ore.get());
        integerConfigsChrysoprase_ore.add(AatoConfig.MinHeightChrysoprase_ore.get());
        integerConfigsChrysoprase_ore.add(AatoConfig.MaxHeightChrysoprase_ore.get());
        booleanOreConfigMap.put(Ores.CHRYSOPRASE_ORE, booleanConfigsChrysoprase_ore);
        integerOreConfigMap.put(Ores.CHRYSOPRASE_ORE, integerConfigsChrysoprase_ore);

        ArrayList<Boolean> booleanConfigsSpessartine_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsSpessartine_ore = new ArrayList<>(4);
        booleanConfigsSpessartine_ore.add(AatoConfig.All.get());
        booleanConfigsSpessartine_ore.add(AatoConfig.enableSpessartine_ore.get());
        booleanConfigsSpessartine_ore.add(getEnabledGroupConfig(Ores.SPESSARTINE_ORE));
        integerConfigsSpessartine_ore.add(AatoConfig.VeinSizeSpessartine_ore.get());
        integerConfigsSpessartine_ore.add(AatoConfig.VeinsPerChunkSpessartine_ore.get());
        integerConfigsSpessartine_ore.add(AatoConfig.MinHeightSpessartine_ore.get());
        integerConfigsSpessartine_ore.add(AatoConfig.MaxHeightSpessartine_ore.get());
        booleanOreConfigMap.put(Ores.SPESSARTINE_ORE, booleanConfigsSpessartine_ore);
        integerOreConfigMap.put(Ores.SPESSARTINE_ORE, integerConfigsSpessartine_ore);

        ArrayList<Boolean> booleanConfigsTsavorite_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsTsavorite_ore = new ArrayList<>(4);
        booleanConfigsTsavorite_ore.add(AatoConfig.All.get());
        booleanConfigsTsavorite_ore.add(AatoConfig.enableTsavorite_ore.get());
        booleanConfigsTsavorite_ore.add(getEnabledGroupConfig(Ores.TSAVORITE_ORE));
        integerConfigsTsavorite_ore.add(AatoConfig.VeinSizeTsavorite_ore.get());
        integerConfigsTsavorite_ore.add(AatoConfig.VeinsPerChunkTsavorite_ore.get());
        integerConfigsTsavorite_ore.add(AatoConfig.MinHeightTsavorite_ore.get());
        integerConfigsTsavorite_ore.add(AatoConfig.MaxHeightTsavorite_ore.get());
        booleanOreConfigMap.put(Ores.TSAVORITE_ORE, booleanConfigsTsavorite_ore);
        integerOreConfigMap.put(Ores.TSAVORITE_ORE, integerConfigsTsavorite_ore);

        // MITHRIL ORE

        listMithrilOre.add(Ores.MITHRIL_ORE);

        ArrayList<Boolean> booleanConfigsMithril_ore = new ArrayList<>(3);
        ArrayList<Integer> integerConfigsMithril_ore = new ArrayList<>(4);
        booleanConfigsMithril_ore.add(AatoConfig.All.get());
        booleanConfigsMithril_ore.add(AatoConfig.enableMithril_ore.get());
        booleanConfigsMithril_ore.add(getEnabledGroupConfig(Ores.MITHRIL_ORE));
        integerConfigsMithril_ore.add(AatoConfig.VeinSizeMithril_ore.get());
        integerConfigsMithril_ore.add(AatoConfig.VeinsPerChunkMithril_ore.get());
        integerConfigsMithril_ore.add(AatoConfig.MinHeightMithril_ore.get());
        integerConfigsMithril_ore.add(AatoConfig.MaxHeightMithril_ore.get());
        booleanOreConfigMap.put(Ores.MITHRIL_ORE, booleanConfigsMithril_ore);
        integerOreConfigMap.put(Ores.MITHRIL_ORE, integerConfigsMithril_ore);

    }
}
