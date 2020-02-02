package waylanderou.almostalltheores;

import java.util.ArrayList;
import java.util.List;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import waylanderou.almostalltheores.block.CustomOre;
import waylanderou.almostalltheores.block.Ores;

import static waylanderou.almostalltheores.OreUtilities.*;

public class OreGeneration {


	public static void setup() {
		createOreConfigMappings();

		for(Biome biome: ForgeRegistries.BIOMES.getValues()) {			
			if(biome.getCategory() == Biome.Category.NETHER) {	
				if(!AatoConfig.disableAatoGeneration.get()) {
					addNetherOres(biome);
				}
				continue;
			}
			if(biome.getCategory() == Biome.Category.THEEND) {								
				continue;
			}
			if(AatoConfig.handleEverythingInOverworld.get()) {
				biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
			} else {
				removeVanillaStuff(biome);
			}
			if(!AatoConfig.disableAatoGeneration.get()) {
				addEnabledAatoOverworldOres(biome);
				//addAatoOverworldGeneration(biome);
			}
			addVanillaStuff(biome);
			handleInfestedStone(biome);
		}		
	}

	public static void addEnabledAatoOverworldOres(Biome biome){
		for(CustomOre customOre : booleanOreConfigMap.keySet()){
			if(booleanOreConfigMap.get(customOre).contains(true)){
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
						new OreFeatureConfig(
								OreFeatureConfig.FillerBlockType.NATURAL_STONE, customOre.getDefaultState(),
								integerOreConfigMap.get(customOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
										new CountRangeConfig(integerOreConfigMap.get(customOre).get(1), integerOreConfigMap.get(customOre).get(2),
												0,
												integerOreConfigMap.get(customOre).get(3)))));

			}
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.MEDIUM){
				for(CustomOre mediumOceanOre : listMediumOceanOres){
					if(booleanOreConfigMap.get(mediumOceanOre).contains(true)){
						biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE, mediumOceanOre.getDefaultState(),
										integerOreConfigMap.get(mediumOceanOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
								new CountRangeConfig(integerOreConfigMap.get(mediumOceanOre).get(1), integerOreConfigMap.get(mediumOceanOre).get(2),
										0,
										integerOreConfigMap.get(mediumOceanOre).get(3)))));

					}
				}
			}
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.WARM){
				for(CustomOre warmOceanOre : listWarmOceanOres){
					if(booleanOreConfigMap.get(warmOceanOre).contains(true)){
						biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE, warmOceanOre.getDefaultState(),
										integerOreConfigMap.get(warmOceanOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
								new CountRangeConfig(integerOreConfigMap.get(warmOceanOre).get(1), integerOreConfigMap.get(warmOceanOre).get(2),
										0,
										integerOreConfigMap.get(warmOceanOre).get(3)))));

					}
				}
			}
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.COLD){
				for(CustomOre coldOceanOre : listColdOceanOres){
					if(booleanOreConfigMap.get(coldOceanOre).contains(true)){
						biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE, coldOceanOre.getDefaultState(),
										integerOreConfigMap.get(coldOceanOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
								new CountRangeConfig(integerOreConfigMap.get(coldOceanOre).get(1), integerOreConfigMap.get(coldOceanOre).get(2),
										0,
										integerOreConfigMap.get(coldOceanOre).get(3)))));

					}
				}
			}
			if(biome.getDownfall() < 0.25F){
				for(CustomOre droughtOre : listDroughtOres){
					if(booleanOreConfigMap.get(customOre).contains(true)){
						biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE, droughtOre.getDefaultState(),
										integerOreConfigMap.get(droughtOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
								new CountRangeConfig(integerOreConfigMap.get(droughtOre).get(1), integerOreConfigMap.get(droughtOre).get(2),
										0,
										integerOreConfigMap.get(droughtOre).get(3)))));

					}
				}
			}
			if(biome.getTempCategory() != TempCategory.WARM && biome.getTempCategory() != TempCategory.OCEAN && biome.getDownfall() > 0.75F){
				for(CustomOre forestOre : listForestOres){
					if(booleanOreConfigMap.get(customOre).contains(true)){
						if((biome.isHighHumidity() || biome.getCategory() == Biome.Category.SWAMP) && (AatoConfig.All.get() || AatoConfig.enableAdditionalPeat.get() || AatoConfig.enableCoalOres.get())) {
							biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
									new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(),
											AatoConfig.VeinSizeAdditionalPeat.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
													new CountRangeConfig(AatoConfig.VeinsPerChunkAdditionalPeat.get(), AatoConfig.MinHeightAdditionalPeat.get(),
															0,AatoConfig.MaxHeightAdditionalPeat.get()))));
						}
						else {
							biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
									new OreFeatureConfig(
											OreFeatureConfig.FillerBlockType.NATURAL_STONE, forestOre.getDefaultState(),
											integerOreConfigMap.get(forestOre).get(0))).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
									new CountRangeConfig(integerOreConfigMap.get(forestOre).get(1), integerOreConfigMap.get(forestOre).get(2),
											0,
											integerOreConfigMap.get(forestOre).get(3)))));

						}
					}
				}
			}
		}
	}

	private static void removeVanillaStuff(Biome biome) {
		List<ConfiguredFeature<?, ?>> featuresToRemove = new ArrayList<ConfiguredFeature<?, ?>>();
		for (ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)) {					
			if (((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {	
				Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
				if (b == Blocks.IRON_ORE || b == Blocks.GOLD_ORE || b == Blocks.COAL_ORE || b == Blocks.DIAMOND_ORE || b == Blocks.EMERALD_ORE || b == Blocks.LAPIS_ORE || b == Blocks.REDSTONE_ORE) {
					featuresToRemove.add(feature);	                    	
				} 
				if(b == Blocks.DIRT || b == Blocks.GRAVEL || b == Blocks.GRANITE || b == Blocks.DIORITE || b == Blocks.ANDESITE) {
					featuresToRemove.add(feature);	                    	                    	
				}
			}
		}
		biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(featuresToRemove);		
	}

	private static void addNetherOres(Biome biome) {
		if(AatoConfig.All.get() || AatoConfig.enableSulphur.get() || AatoConfig.enableSulphurOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.SULPHUR.getDefaultState(), AatoConfig.VeinSizeNetherSulphur.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherSulphur.get(), AatoConfig.MinHeightNetherSulphur.get(), 0, AatoConfig.MaxHeightNetherSulphur.get()))));

		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherCoal.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_COAL_ORE.getDefaultState(), AatoConfig.VeinSizeNetherCoal.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherCoal.get(), AatoConfig.MinHeightNetherCoal.get(), 0,AatoConfig.MaxHeightNetherCoal.get()))));

		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherGold.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeNetherGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherGold.get(), AatoConfig.MinHeightNetherGold.get(), 0,AatoConfig.MaxHeightNetherGold.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherMithril.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_MITHRIL_ORE.getDefaultState(), AatoConfig.VeinSizeNetherMithril.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherMithril.get(), AatoConfig.MinHeightNetherMithril.get(), 0,AatoConfig.MaxHeightNetherMithril.get()))));

		}
	}

	private static void handleInfestedStone(Biome biome) {
		List<ConfiguredFeature<?, ?>> featuresToRemove = new ArrayList<ConfiguredFeature<?, ?>>();
		if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
			for (ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)) {					
				if (((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {	
					Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
					if (b == Blocks.INFESTED_STONE) {
						featuresToRemove.add(feature);	                	
					}
				}
			}
			if(biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(featuresToRemove)) {
				if(AatoConfig.enableInfestedStone.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.INFESTED_STONE.getDefaultState(), AatoConfig.VeinSizeInfestedStone.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkInfestedStone.get(), AatoConfig.MinHeightInfestedStone.get(), 0,AatoConfig.MaxHeightInfestedStone.get()))));
				} 
			}
		}				
	}

	private static void addVanillaStuff(Biome biome) {
		if(AatoConfig.enableVanillaCoalOre.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), AatoConfig.VeinSizeCoal.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCoal.get(), AatoConfig.MinHeightCoal.get(), 0, AatoConfig.MaxHeightCoal.get()))));
		}
		if(AatoConfig.enableVanillaIronOre.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), AatoConfig.VeinSizeIron.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkIron.get(), AatoConfig.MinHeightIron.get(), 0, AatoConfig.MaxHeightIron.get()))));		      
		}
		if(AatoConfig.enableGold.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGold.get(), AatoConfig.MinHeightGold.get(), 0,AatoConfig.MaxHeightGold.get()))));
		}
		if(AatoConfig.enableRedstone.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.REDSTONE_ORE.getDefaultState(), AatoConfig.VeinSizeRedstone.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRedstone.get(), AatoConfig.MinHeightRedstone.get(), 0,AatoConfig.MaxHeightRedstone.get()))));
		}
		if(AatoConfig.enableDiamond.get()) {			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIAMOND_ORE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0,AatoConfig.MaxHeightDiamond.get()))));
		}
		if(AatoConfig.enableLapis.get()) {			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.LAPIS_ORE.getDefaultState(), AatoConfig.VeinSizeLapis.get())).func_227228_a_(Placement.COUNT_DEPTH_AVERAGE.func_227446_a_(new DepthAverageConfig(AatoConfig.VeinsPerChunkLapis.get(), AatoConfig.DepthAverageLapis.get(), AatoConfig.DepthAverageLapis.get()))));
		}
		if(AatoConfig.enableDirt.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), AatoConfig.VeinSizeDirt.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDirt.get(), AatoConfig.MinHeightDirt.get(), 0,AatoConfig.MaxHeightDirt.get()))));
		}
		if(AatoConfig.enableGravel.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), AatoConfig.VeinSizeGravel.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGravel.get(), AatoConfig.MinHeightGravel.get(), 0,AatoConfig.MaxHeightGravel.get()))));
		}
		if(AatoConfig.enableGranite.get()) {	
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), AatoConfig.VeinSizeGranite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGranite.get(), AatoConfig.MinHeightGranite.get(), 0,AatoConfig.MaxHeightGranite.get()))));
		}
		if(AatoConfig.enableDiorite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), AatoConfig.VeinSizeDiorite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiorite.get(), AatoConfig.MinHeightDiorite.get(), 0,AatoConfig.MaxHeightDiorite.get()))));
		}
		if(AatoConfig.enableAndesite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), AatoConfig.VeinSizeAndesite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAndesite.get(), AatoConfig.MinHeightAndesite.get(), 0,AatoConfig.MaxHeightAndesite.get()))));
		}
		DefaultBiomeFeatures.addSedimentDisks(biome);
		if(biome.getCategory() == Biome.Category.SWAMP) {
			DefaultBiomeFeatures.addSwampClayDisks(biome);
		}	    
		if(biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU || biome == Biomes.ERODED_BADLANDS || biome == Biomes.MODIFIED_BADLANDS_PLATEAU || biome == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU || biome == Biomes.WOODED_BADLANDS_PLATEAU) {
			if(AatoConfig.enableBadlandsGold.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeBadlandsGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBadlandsGold.get(), AatoConfig.MinHeightBadlandsGold.get(), 0,AatoConfig.MaxHeightBadlandsGold.get()))));
			}
		}
		if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
			if(AatoConfig.enableEmerald.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.func_225566_b_(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.EMERALD_ORE.getDefaultState())).func_227228_a_(Placement.EMERALD_ORE.func_227446_a_(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
		}	   	
	}

}