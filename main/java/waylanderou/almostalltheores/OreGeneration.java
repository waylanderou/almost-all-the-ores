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
import waylanderou.almostalltheores.block.Ores;

public class OreGeneration {

	public static void setup() {		
				
		for(Biome biome: ForgeRegistries.BIOMES.getValues()) {
			if(biome.getCategory() == Biome.Category.NETHER) {
				if(Config.hookNether.get()) {
					biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();	
				}
				if(Config.All.get() || Config.enableSulphur.get() || Config.enableSulphurOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.SULPHUR.getDefaultState(), Config.VeinSizeNetherSulphur.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNetherSulphur.get(), Config.MinHeightNetherSulphur.get(), 0, Config.MaxHeightNetherSulphur.get())));
				}
				if(Config.All.get() || Config.enableNetherCoal.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_COAL_ORE.getDefaultState(), Config.VeinSizeNetherCoal.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNetherCoal.get(), Config.MinHeightNetherCoal.get(), 0, Config.MaxHeightNetherCoal.get())));
				}
				if(Config.All.get() || Config.enableNetherGold.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_GOLD_ORE.getDefaultState(), Config.VeinSizeNetherGold.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNetherGold.get(), Config.MinHeightNetherGold.get(), 0, Config.MaxHeightNetherGold.get())));
				}
				if(Config.All.get() || Config.enableNetherMithril.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_MITHRIL_ORE.getDefaultState(), Config.VeinSizeNetherMithril.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNetherMithril.get(), Config.MinHeightNetherMithril.get(), 0, Config.MaxHeightNetherMithril.get())));
				}
				continue;
			}
			if(biome.getCategory() == Biome.Category.THEEND) {
				if(Config.hookEnd.get()) {
					biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();					
				}				
				continue;
			}
			
			//Overworld	
			
			if(Config.hookAll.get()) {
				biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();	
				addVanillaStuff(biome);
				handleInfestedStone(biome);
			} else if(Config.hookVanillaGenOnly.get()) {				
				List<ConfiguredFeature> featuresToRemove = new ArrayList<ConfiguredFeature>();
				for (ConfiguredFeature<?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)) {					
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
				if(biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(featuresToRemove)) {
					addVanillaStuff(biome);
					handleInfestedStone(biome);					
				}	
			}
			
			if(Config.All.get() || Config.enablePyrite.get() || Config.enableSulphurOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYRITE.getDefaultState(), Config.VeinSizePyrite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPyrite.get(), Config.MinHeightPyrite.get(), 0, Config.MaxHeightPyrite.get())));
			}
			if(Config.All.get() || Config.enableGuano.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GUANO.getDefaultState(), Config.VeinSizeGuano.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGuano.get(), Config.MinHeightGuano.get(), 0, Config.MaxHeightGuano.get())));
			}
			if(Config.All.get() || Config.enablePhosphorite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PHOSPHORITE.getDefaultState(), Config.VeinSizePhosphorite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPhosphorite.get(), Config.MinHeightPhosphorite.get(), 0, Config.MaxHeightPhosphorite.get())));
			}
			if(Config.All.get() || Config.enableLignite_ore.get() || Config.enableCoalOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LIGNITE_ORE.getDefaultState(), Config.VeinSizeLignite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkLignite_ore.get(), Config.MinHeightLignite_ore.get(), 0, Config.MaxHeightLignite_ore.get())));
			}
			if(Config.All.get() || Config.enableBituminous_coal_ore.get() || Config.enableCoalOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BITUMINOUS_COAL_ORE.getDefaultState(), Config.VeinSizeBituminous_coal_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBituminous_coal_ore.get(), Config.MinHeightBituminous_coal_ore.get(), 0, Config.MaxHeightBituminous_coal_ore.get())));
			}
			if(Config.All.get() || Config.enableAnthracite_ore.get() || Config.enableCoalOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANTHRACITE_ORE.getDefaultState(), Config.VeinSizeAnthracite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAnthracite_ore.get(), Config.MinHeightAnthracite_ore.get(), 0, Config.MaxHeightAnthracite_ore.get())));
			}
			if(Config.All.get() || Config.enableGraphite.get() || Config.enableGraphiteOre.get()) { 
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GRAPHITE.getDefaultState(), Config.VeinSizeGraphite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGraphite.get(), Config.MinHeightGraphite.get(), 0, Config.MaxHeightGraphite.get())));
			}
			if(Config.All.get() || Config.enableArsenopyrite.get() || Config.enableArsenicOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ARSENOPYRITE.getDefaultState(), Config.VeinSizeArsenopyrite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkArsenopyrite.get(), Config.MinHeightArsenopyrite.get(), 0, Config.MaxHeightArsenopyrite.get())));
			}
			if(Config.All.get() || Config.enableStibnite.get() || Config.enableAntimonyOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STIBNITE.getDefaultState(), Config.VeinSizeStibnite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkStibnite.get(), Config.MinHeightStibnite.get(), 0, Config.MaxHeightStibnite.get())));
			}
			if(Config.All.get() || Config.enableGermanite.get() || Config.enableGermaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GERMANITE.getDefaultState(), Config.VeinSizeGermanite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGermanite.get(), Config.MinHeightGermanite.get(), 0, Config.MaxHeightGermanite.get())));
			}
			if(Config.All.get() || Config.enableArgutite.get() || Config.enableGermaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ARGUTITE.getDefaultState(), Config.VeinSizeArgutite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkArgutite.get(), Config.MinHeightArgutite.get(), 0, Config.MaxHeightArgutite.get())));
			}
			if(Config.All.get() || Config.enableBismuthinite.get() || Config.enableBismuthOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BISMUTHINITE.getDefaultState(), Config.VeinSizeBismuthinite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBismuthinite.get(), Config.MinHeightBismuthinite.get(), 0, Config.MaxHeightBismuthinite.get())));
			}
			if(Config.All.get() || Config.enableNative_bismuth.get() || Config.enableBismuthOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_BISMUTH.getDefaultState(), Config.VeinSizeNative_bismuth.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNative_bismuth.get(), Config.MinHeightNative_bismuth.get(), 0, Config.MaxHeightNative_bismuth.get())));
			}
			if(Config.All.get() || Config.enableBismite.get() || Config.enableBismuthOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BISMITE.getDefaultState(), Config.VeinSizeBismite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBismite.get(), Config.MinHeightBismite.get(), 0, Config.MaxHeightBismite.get())));
			}
			if(Config.All.get() || Config.enableCassiterite.get() || Config.enableTinOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CASSITERITE.getDefaultState(), Config.VeinSizeCassiterite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCassiterite.get(), Config.MinHeightCassiterite.get(), 0, Config.MaxHeightCassiterite.get())));
			}
			if(Config.All.get() || Config.enableNative_tin.get() || Config.enableTinOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_TIN.getDefaultState(), Config.VeinSizeNative_tin.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNative_tin.get(), Config.MinHeightNative_tin.get(), 0, Config.MaxHeightNative_tin.get())));
			}
			if(Config.All.get() || Config.enableGalena.get() || Config.enableLeadOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GALENA.getDefaultState(), Config.VeinSizeGalena.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGalena.get(), Config.MinHeightGalena.get(), 0, Config.MaxHeightGalena.get())));
			}
			if(Config.All.get() || Config.enablePyromorphite.get() || Config.enableLeadOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROMORPHITE.getDefaultState(), Config.VeinSizePyromorphite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPyromorphite.get(), Config.MinHeightPyromorphite.get(), 0, Config.MaxHeightPyromorphite.get())));
			}
			if(Config.All.get() || Config.enableBauxite.get() || Config.enableAluminumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BAUXITE.getDefaultState(), Config.VeinSizeBauxite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBauxite.get(), Config.MinHeightBauxite.get(), 0, Config.MaxHeightBauxite.get())));
			}
			if(Config.All.get() || Config.enableNepheline.get() || Config.enableAluminumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NEPHELINE.getDefaultState(), Config.VeinSizeNepheline.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNepheline.get(), Config.MinHeightNepheline.get(), 0, Config.MaxHeightNepheline.get())));
			}
			if(Config.All.get() || Config.enableLeucite.get() || Config.enableAluminumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LEUCITE.getDefaultState(), Config.VeinSizeLeucite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkLeucite.get(), Config.MinHeightLeucite.get(), 0, Config.MaxHeightLeucite.get())));
			}
			if(Config.All.get() || Config.enableSphalerite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPHALERITE.getDefaultState(), Config.VeinSizeSphalerite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSphalerite.get(), Config.MinHeightSphalerite.get(), 0, Config.MaxHeightSphalerite.get())));
			}
			if(Config.All.get() || Config.enableSmithsonite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SMITHSONITE.getDefaultState(), Config.VeinSizeSmithsonite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSmithsonite.get(), Config.MinHeightSmithsonite.get(), 0, Config.MaxHeightSmithsonite.get())));
			}
			if(Config.All.get() || Config.enableCinnabar.get() || Config.enableMercuryOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CINNABAR.getDefaultState(), Config.VeinSizeCinnabar.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCinnabar.get(), Config.MinHeightCinnabar.get(), 0, Config.MaxHeightCinnabar.get())));
			}
			if(Config.All.get() || Config.enableChalcopyrite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHALCOPYRITE.getDefaultState(), Config.VeinSizeChalcopyrite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkChalcopyrite.get(), Config.MinHeightChalcopyrite.get(), 0, Config.MaxHeightChalcopyrite.get())));
			}
			if(Config.All.get() || Config.enableChalcocite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHALCOCITE.getDefaultState(), Config.VeinSizeChalcocite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkChalcocite.get(), Config.MinHeightChalcocite.get(), 0, Config.MaxHeightChalcocite.get())));
			}
			if(Config.All.get() || Config.enableMalachite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MALACHITE.getDefaultState(), Config.VeinSizeMalachite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMalachite.get(), Config.MinHeightMalachite.get(), 0, Config.MaxHeightMalachite.get())));
			}
			if(Config.All.get() || Config.enableNative_silver.get() || Config.enableSilverOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_SILVER.getDefaultState(), Config.VeinSizeNative_silver.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNative_silver.get(), Config.MinHeightNative_silver.get(), 0, Config.MaxHeightNative_silver.get())));
			}
			if(Config.All.get() || Config.enableProustite.get() || Config.enableSilverOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PROUSTITE.getDefaultState(), Config.VeinSizeProustite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkProustite.get(), Config.MinHeightProustite.get(), 0, Config.MaxHeightProustite.get())));
			}
			if(Config.All.get() || Config.enableNickeline.get() || Config.enableNickelOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NICKELINE.getDefaultState(), Config.VeinSizeNickeline.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNickeline.get(), Config.MinHeightNickeline.get(), 0, Config.MaxHeightNickeline.get())));
			}		
			if(Config.All.get() || Config.enableNepouite.get() || Config.enableNickelOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NEPOUITE.getDefaultState(), Config.VeinSizeNepouite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNepouite.get(), Config.MinHeightNepouite.get(), 0, Config.MaxHeightNepouite.get())));
			}
			if(Config.All.get() || Config.enableCobaltite.get() || Config.enableCobaltOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COBALTITE.getDefaultState(), Config.VeinSizeCobaltite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCobaltite.get(), Config.MinHeightCobaltite.get(), 0, Config.MaxHeightCobaltite.get())));
			}
			if(Config.All.get() || Config.enableHematite.get() || Config.enableIronOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMATITE.getDefaultState(), Config.VeinSizeHematite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHematite.get(), Config.MinHeightHematite.get(), 0, Config.MaxHeightHematite.get())));
			}
			if(Config.All.get() || Config.enableMagnetite.get() || Config.enableIronOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MAGNETITE.getDefaultState(), Config.VeinSizeMagnetite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMagnetite.get(), Config.MinHeightMagnetite.get(), 0, Config.MaxHeightMagnetite.get())));
			}
			if(Config.All.get() || Config.enableLimonite.get() || Config.enableIronOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LIMONITE.getDefaultState(), Config.VeinSizeLimonite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkLimonite.get(), Config.MinHeightLimonite.get(), 0, Config.MaxHeightLimonite.get())));
			}
			if(Config.All.get() || Config.enableSiderite.get() || Config.enableIronOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SIDERITE.getDefaultState(), Config.VeinSizeSiderite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSiderite.get(), Config.MinHeightSiderite.get(), 0, Config.MaxHeightSiderite.get())));
			}
			if(Config.All.get() || Config.enableTelluric_iron.get() || Config.enableIronOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TELLURIC_IRON.getDefaultState(), Config.VeinSizeTelluric_iron.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTelluric_iron.get(), Config.MinHeightTelluric_iron.get(), 0, Config.MaxHeightTelluric_iron.get())));
			}
			if(Config.All.get() || Config.enablePyrolusite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROLUSITE.getDefaultState(), Config.VeinSizePyrolusite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPyrolusite.get(), Config.MinHeightPyrolusite.get(), 0, Config.MaxHeightPyrolusite.get())));
			}
			if(Config.All.get() || Config.enableChromite.get() || Config.enableChromiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHROMITE.getDefaultState(), Config.VeinSizeChromite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkChromite.get(), Config.MinHeightChromite.get(), 0, Config.MaxHeightChromite.get())));
			}
			if(Config.All.get() || Config.enableMolybdenite.get() || Config.enableMolybdenumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MOLYBDENITE.getDefaultState(), Config.VeinSizeMolybdenite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMolybdenite.get(), Config.MinHeightMolybdenite.get(), 0, Config.MaxHeightMolybdenite.get())));
			}
			if(Config.All.get() || Config.enableWulfenite.get() || Config.enableMolybdenumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.WULFENITE.getDefaultState(), Config.VeinSizeWulfenite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkWulfenite.get(), Config.MinHeightWulfenite.get(), 0, Config.MaxHeightWulfenite.get())));
			}
			if(Config.All.get() || Config.enableScheelite.get() || Config.enableTungstenOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SCHEELITE.getDefaultState(), Config.VeinSizeScheelite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkScheelite.get(), Config.MinHeightScheelite.get(), 0, Config.MaxHeightScheelite.get())));
			}
			if(Config.All.get() || Config.enableFerberite.get() || Config.enableTungstenOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FERBERITE.getDefaultState(), Config.VeinSizeFerberite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkFerberite.get(), Config.MinHeightFerberite.get(), 0, Config.MaxHeightFerberite.get())));
			}
			if(Config.All.get() || Config.enableHubnerite.get() || Config.enableTungstenOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HUBNERITE.getDefaultState(), Config.VeinSizeHubnerite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHubnerite.get(), Config.MinHeightHubnerite.get(), 0, Config.MaxHeightHubnerite.get())));
			}
			if(Config.All.get() || Config.enableVanadinite.get() || Config.enableVanadiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.VANADINITE.getDefaultState(), Config.VeinSizeVanadinite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkVanadinite.get(), Config.MinHeightVanadinite.get(), 0, Config.MaxHeightVanadinite.get())));
			}
			if(Config.All.get() || Config.enableDescloizite.get() || Config.enableVanadiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.DESCLOIZITE.getDefaultState(), Config.VeinSizeDescloizite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkDescloizite.get(), Config.MinHeightDescloizite.get(), 0, Config.MaxHeightDescloizite.get())));
			}
			if(Config.All.get() || Config.enableColumbite.get() || Config.enableNiobiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COLUMBITE.getDefaultState(), Config.VeinSizeColumbite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkColumbite.get(), Config.MinHeightColumbite.get(), 0, Config.MaxHeightColumbite.get())));
			}
			if(Config.All.get() || Config.enableTantalite.get() || Config.enableTantalumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TANTALITE.getDefaultState(), Config.VeinSizeTantalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTantalite.get(), Config.MinHeightTantalite.get(), 0, Config.MaxHeightTantalite.get())));
			}
			if(Config.All.get() || Config.enableRutile.get() || Config.enableTitaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RUTILE.getDefaultState(), Config.VeinSizeRutile.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRutile.get(), Config.MinHeightRutile.get(), 0, Config.MaxHeightRutile.get())));
			}
			if(Config.All.get() || Config.enableIlmenite.get() || Config.enableTitaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ILMENITE.getDefaultState(), Config.VeinSizeIlmenite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkIlmenite.get(), Config.MinHeightIlmenite.get(), 0, Config.MaxHeightIlmenite.get())));
			}
			if(Config.All.get() || Config.enableZircon.get() || Config.enableZirconiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ZIRCON.getDefaultState(), Config.VeinSizeZircon.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkZircon.get(), Config.MinHeightZircon.get(), 0, Config.MaxHeightZircon.get())));
			}
			if(Config.All.get() || Config.enableThorite.get() || Config.enableThoriumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.THORITE.getDefaultState(), Config.VeinSizeThorite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkThorite.get(), Config.MinHeightThorite.get(), 0, Config.MaxHeightThorite.get())));
			}
			if(Config.All.get() || Config.enableCarnotite.get() || Config.enableUraniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNOTITE.getDefaultState(), Config.VeinSizeCarnotite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCarnotite.get(), Config.MinHeightCarnotite.get(), 0, Config.MaxHeightCarnotite.get())));
			}
			if(Config.All.get() || Config.enableUraninite.get() || Config.enableUraniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.URANINITE.getDefaultState(), Config.VeinSizeUraninite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkUraninite.get(), Config.MinHeightUraninite.get(), 0, Config.MaxHeightUraninite.get())));
			}
			if(Config.All.get() || Config.enableMagnesite.get() || Config.enableMagnesiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MAGNESITE.getDefaultState(), Config.VeinSizeMagnesite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMagnesite.get(), Config.MinHeightMagnesite.get(), 0, Config.MaxHeightMagnesite.get())));
			}
			if(Config.All.get() || Config.enableKieserite.get() || Config.enableMagnesiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KIESERITE.getDefaultState(), Config.VeinSizeKieserite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkKieserite.get(), Config.MinHeightKieserite.get(), 0, Config.MaxHeightKieserite.get())));
			}
			if(Config.All.get() || Config.enableBrucite.get() || Config.enableMagnesiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BRUCITE.getDefaultState(), Config.VeinSizeBrucite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBrucite.get(), Config.MinHeightBrucite.get(), 0, Config.MaxHeightBrucite.get())));
			}
			if(Config.All.get() || Config.enableCalcite.get() || Config.enableCalciumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CALCITE.getDefaultState(), Config.VeinSizeCalcite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCalcite.get(), Config.MinHeightCalcite.get(), 0, Config.MaxHeightCalcite.get())));
			}
			if(Config.All.get() || Config.enableGypsum.get() || Config.enableCalciumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GYPSUM.getDefaultState(), Config.VeinSizeGypsum.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGypsum.get(), Config.MinHeightGypsum.get(), 0, Config.MaxHeightGypsum.get())));
			}
			if(Config.All.get() || Config.enableAnhydrite.get() || Config.enableCalciumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANHYDRITE.getDefaultState(), Config.VeinSizeAnhydrite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAnhydrite.get(), Config.MinHeightAnhydrite.get(), 0, Config.MaxHeightAnhydrite.get())));
			}
			if(Config.All.get() || Config.enableDolomite.get() || Config.enableCalciumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.DOLOMITE.getDefaultState(), Config.VeinSizeDolomite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkDolomite.get(), Config.MinHeightDolomite.get(), 0, Config.MaxHeightDolomite.get())));
			}
			if(Config.All.get() || Config.enableStrontianite.get() || Config.enableStrontiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STRONTIANITE.getDefaultState(), Config.VeinSizeStrontianite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkStrontianite.get(), Config.MinHeightStrontianite.get(), 0, Config.MaxHeightStrontianite.get())));
			}
			if(Config.All.get() || Config.enablePolylithionite.get() || Config.enableLithiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.POLYLITHIONITE.getDefaultState(), Config.VeinSizePolylithionite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPolylithionite.get(), Config.MinHeightPolylithionite.get(), 0, Config.MaxHeightPolylithionite.get())));
			}
			if(Config.All.get() || Config.enableCarnallite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNALLITE.getDefaultState(), Config.VeinSizeCarnallite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCarnallite.get(), Config.MinHeightCarnallite.get(), 0, Config.MaxHeightCarnallite.get())));
			}
			if(Config.All.get() || Config.enableSylvite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SYLVITE.getDefaultState(), Config.VeinSizeSylvite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSylvite.get(), Config.MinHeightSylvite.get(), 0, Config.MaxHeightSylvite.get())));
			}
			if(Config.All.get() || Config.enableHalite.get() || Config.enableSaltOre.get()) { 
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HALITE.getDefaultState(), Config.VeinSizeHalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHalite.get(), Config.MinHeightHalite.get(), 0, Config.MaxHeightHalite.get())));
			}
			if(Config.All.get() || Config.enableSapphire_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SAPPHIRE_ORE.getDefaultState(), Config.VeinSizeSapphire_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSapphire_ore.get(), Config.MinHeightSapphire_ore.get(), 0, Config.MaxHeightSapphire_ore.get())));
			}
			if(Config.All.get() || Config.enableRuby_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RUBY_ORE.getDefaultState(), Config.VeinSizeRuby_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRuby_ore.get(), Config.MinHeightRuby_ore.get(), 0, Config.MaxHeightRuby_ore.get())));
			}
			if(Config.All.get() || Config.enableAmethyst_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AMETHYST_ORE.getDefaultState(), Config.VeinSizeAmethyst_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAmethyst_ore.get(), Config.MinHeightAmethyst_ore.get(), 0, Config.MaxHeightAmethyst_ore.get())));
			}
			if(Config.All.get() || Config.enableJade_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.JADE_ORE.getDefaultState(), Config.VeinSizeJade_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkJade_ore.get(), Config.MinHeightJade_ore.get(), 0, Config.MaxHeightJade_ore.get())));
			}
			if(Config.All.get() || Config.enablePeridot_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PERIDOT_ORE.getDefaultState(), Config.VeinSizePeridot_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPeridot_ore.get(), Config.MinHeightPeridot_ore.get(), 0, Config.MaxHeightPeridot_ore.get())));
			}
			if(Config.All.get() || Config.enableAgate_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AGATE_ORE.getDefaultState(), Config.VeinSizeAgate_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAgate_ore.get(), Config.MinHeightAgate_ore.get(), 0, Config.MaxHeightAgate_ore.get())));
			}
			if(Config.All.get() || Config.enableCarnelian_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNELIAN_ORE.getDefaultState(), Config.VeinSizeCarnelian_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCarnelian_ore.get(), Config.MinHeightCarnelian_ore.get(), 0, Config.MaxHeightCarnelian_ore.get())));
			}
			if(Config.All.get() || Config.enableHeliotrope_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HELIOTROPE_ORE.getDefaultState(), Config.VeinSizeHeliotrope_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHeliotrope_ore.get(), Config.MinHeightHeliotrope_ore.get(), 0, Config.MaxHeightHeliotrope_ore.get())));
			}
			if(Config.All.get() || Config.enableTopaz_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TOPAZ_ORE.getDefaultState(), Config.VeinSizeTopaz_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTopaz_ore.get(), Config.MinHeightTopaz_ore.get(), 0, Config.MaxHeightTopaz_ore.get())));
			}
			if(Config.All.get() || Config.enableUnakite_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.UNAKITE_ORE.getDefaultState(), Config.VeinSizeUnakite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkUnakite_ore.get(), Config.MinHeightUnakite_ore.get(), 0, Config.MaxHeightUnakite_ore.get())));
			}
			if(Config.All.get() || Config.enableOnyx_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ONYX_ORE.getDefaultState(), Config.VeinSizeOnyx_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkOnyx_ore.get(), Config.MinHeightOnyx_ore.get(), 0, Config.MaxHeightOnyx_ore.get())));
			}
			if(Config.All.get() || Config.enableTurquoise_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TURQUOISE_ORE.getDefaultState(), Config.VeinSizeTurquoise_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTurquoise_ore.get(), Config.MinHeightTurquoise_ore.get(), 0, Config.MaxHeightTurquoise_ore.get())));
			}
			if(Config.All.get() || Config.enableAmazonite_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AMAZONITE_ORE.getDefaultState(), Config.VeinSizeAmazonite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAmazonite_ore.get(), Config.MinHeightAmazonite_ore.get(), 0, Config.MaxHeightAmazonite_ore.get())));
			}
			if(Config.All.get() || Config.enableChrysocolla_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHRYSOCOLLA_ORE.getDefaultState(), Config.VeinSizeChrysocolla_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkChrysocolla_ore.get(), Config.MinHeightChrysocolla_ore.get(), 0, Config.MaxHeightChrysocolla_ore.get())));
			}
			if(Config.All.get() || Config.enableMithril_ore.get() || Config.enableMithrilOre.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MITHRIL_ORE.getDefaultState(), Config.VeinSizeMithril_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMithril_ore.get(), Config.MinHeightMithril_ore.get(), 0, Config.MaxHeightMithril_ore.get())));			
			}
			//MEDIUM biomes TempCategory and OCEAN
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.MEDIUM) {
				if(Config.All.get() || Config.enableClausthalite.get() || Config.enableSeleniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CLAUSTHALITE.getDefaultState(), Config.VeinSizeClausthalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkClausthalite.get(), Config.MinHeightClausthalite.get(), 0, Config.MaxHeightClausthalite.get())));
				}
				if(Config.All.get() || Config.enableOrpiment.get() || Config.enableArsenicOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ORPIMENT.getDefaultState(), Config.VeinSizeOrpiment.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkOrpiment.get(), Config.MinHeightOrpiment.get(), 0, Config.MaxHeightOrpiment.get())));
				}
				if(Config.All.get() || Config.enableStannite.get() || Config.enableTinOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STANNITE.getDefaultState(), Config.VeinSizeStannite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkStannite.get(), Config.MinHeightStannite.get(), 0, Config.MaxHeightStannite.get())));
				}
				if(Config.All.get() || Config.enableBoulangerite.get() || Config.enableLeadOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BOULANGERITE.getDefaultState(), Config.VeinSizeBoulangerite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBoulangerite.get(), Config.MinHeightBoulangerite.get(), 0, Config.MaxHeightBoulangerite.get())));
				}
				if(Config.All.get() || Config.enableHemimorphite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMIMORPHITE.getDefaultState(), Config.VeinSizeHemimorphite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHemimorphite.get(), Config.MinHeightHemimorphite.get(), 0, Config.MaxHeightHemimorphite.get())));
				}
				if(Config.All.get() || Config.enableFranklinite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FRANKLINITE.getDefaultState(), Config.VeinSizeFranklinite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkFranklinite.get(), Config.MinHeightFranklinite.get(), 0, Config.MaxHeightFranklinite.get())));
				}
				if(Config.All.get() || Config.enableGreenockite.get() || Config.enableCadmiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GREENOCKITE.getDefaultState(), Config.VeinSizeGreenockite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGreenockite.get(), Config.MinHeightGreenockite.get(), 0, Config.MaxHeightGreenockite.get())));
				}
				if(Config.All.get() || Config.enableNative_copper.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_COPPER.getDefaultState(), Config.VeinSizeNative_copper.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNative_copper.get(), Config.MinHeightNative_copper.get(), 0, Config.MaxHeightNative_copper.get())));
				}
				if(Config.All.get() || Config.enableBornite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BORNITE.getDefaultState(), Config.VeinSizeBornite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBornite.get(), Config.MinHeightBornite.get(), 0, Config.MaxHeightBornite.get())));
				}
				if(Config.All.get() || Config.enableAzurite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AZURITE.getDefaultState(), Config.VeinSizeAzurite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAzurite.get(), Config.MinHeightAzurite.get(), 0, Config.MaxHeightAzurite.get())));
				}
				if(Config.All.get() || Config.enableFreibergite.get() || Config.enableSilverOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FREIBERGITE.getDefaultState(), Config.VeinSizeFreibergite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkFreibergite.get(), Config.MinHeightFreibergite.get(), 0, Config.MaxHeightFreibergite.get())));
				}
				if(Config.All.get() || Config.enablePentlandite.get() || Config.enableNickelOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PENTLANDITE.getDefaultState(), Config.VeinSizePentlandite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPentlandite.get(), Config.MinHeightPentlandite.get(), 0, Config.MaxHeightPentlandite.get())));
				}
				if(Config.All.get() || Config.enableCarrollite.get() || Config.enableCobaltOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARROLLITE.getDefaultState(), Config.VeinSizeCarrollite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCarrollite.get(), Config.MinHeightCarrollite.get(), 0, Config.MaxHeightCarrollite.get())));
				}
				if(Config.All.get() || Config.enableRhodochrosite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RHODOCHROSITE.getDefaultState(), Config.VeinSizeRhodochrosite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRhodochrosite.get(), Config.MinHeightRhodochrosite.get(), 0, Config.MaxHeightRhodochrosite.get())));
				}
				if(Config.All.get() || Config.enableHollandite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HOLLANDITE.getDefaultState(), Config.VeinSizeHollandite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHollandite.get(), Config.MinHeightHollandite.get(), 0, Config.MaxHeightHollandite.get())));
				}
				if(Config.All.get() || Config.enableBrookite.get() || Config.enableTitaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BROOKITE.getDefaultState(), Config.VeinSizeBrookite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBrookite.get(), Config.MinHeightBrookite.get(), 0, Config.MaxHeightBrookite.get())));
				}
				if(Config.All.get() || Config.enableCelestine.get() || Config.enableStrontiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CELESTINE.getDefaultState(), Config.VeinSizeCelestine.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCelestine.get(), Config.MinHeightCelestine.get(), 0, Config.MaxHeightCelestine.get())));
				}
				if(Config.All.get() || Config.enablePolyhalite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.POLYHALITE.getDefaultState(), Config.VeinSizePolyhalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPolyhalite.get(), Config.MinHeightPolyhalite.get(), 0, Config.MaxHeightPolyhalite.get())));
				}
				if(Config.All.get() || Config.enableHauyne_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUYNE_ORE.getDefaultState(), Config.VeinSizeHauyne_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHauyne_ore.get(), Config.MinHeightHauyne_ore.get(), 0, Config.MaxHeightHauyne_ore.get())));
				}
				if(Config.All.get() || Config.enableMoonstone_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MOONSTONE_ORE.getDefaultState(), Config.VeinSizeMoonstone_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMoonstone_ore.get(), Config.MinHeightMoonstone_ore.get(), 0, Config.MaxHeightMoonstone_ore.get())));
				}
				if(Config.All.get() || Config.enableAlmandine_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ALMANDINE_ORE.getDefaultState(), Config.VeinSizeAlmandine_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAlmandine_ore.get(), Config.MinHeightAlmandine_ore.get(), 0, Config.MaxHeightAlmandine_ore.get())));
				}
			}
			
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.WARM) {
				if(Config.All.get() || Config.enableSulphur.get() || Config.enableSulphurOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SULPHUR.getDefaultState(), Config.VeinSizeSulphur.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSulphur.get(), Config.MinHeightSulphur.get(), 0, Config.MaxHeightSulphur.get())));
				}
				if(Config.All.get() || Config.enableRealgar.get() || Config.enableArsenicOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.REALGAR.getDefaultState(), Config.VeinSizeRealgar.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRealgar.get(), Config.MinHeightRealgar.get(), 0, Config.MaxHeightRealgar.get())));
				}
				if(Config.All.get() || Config.enableTeallite.get() || Config.enableTinOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TEALLITE.getDefaultState(), Config.VeinSizeTeallite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTeallite.get(), Config.MinHeightTeallite.get(), 0, Config.MaxHeightTeallite.get())));
				}
				if(Config.All.get() || Config.enableAnglesite.get() || Config.enableLeadOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANGLESITE.getDefaultState(), Config.VeinSizeAnglesite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAnglesite.get(), Config.MinHeightAnglesite.get(), 0, Config.MaxHeightAnglesite.get())));
				}
				if(Config.All.get() || Config.enableZincite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ZINCITE.getDefaultState(), Config.VeinSizeZincite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkZincite.get(), Config.MinHeightZincite.get(), 0, Config.MaxHeightZincite.get())));
				}
				if(Config.All.get() || Config.enableHydrozincite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HYDROZINCITE.getDefaultState(), Config.VeinSizeHydrozincite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHydrozincite.get(), Config.MinHeightHydrozincite.get(), 0, Config.MaxHeightHydrozincite.get())));
				}
				if(Config.All.get() || Config.enableOtavite.get() || Config.enableCadmiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OTAVITE.getDefaultState(), Config.VeinSizeOtavite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkOtavite.get(), Config.MinHeightOtavite.get(), 0, Config.MaxHeightOtavite.get())));
				}
				if(Config.All.get() || Config.enableTennantite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TENNANTITE.getDefaultState(), Config.VeinSizeTennantite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTennantite.get(), Config.MinHeightTennantite.get(), 0, Config.MaxHeightTennantite.get())));
				}
				if(Config.All.get() || Config.enableTetrahedrite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TETRAHEDRITE.getDefaultState(), Config.VeinSizeTetrahedrite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTetrahedrite.get(), Config.MinHeightTetrahedrite.get(), 0, Config.MaxHeightTetrahedrite.get())));
				}
				if(Config.All.get() || Config.enableStephanite.get() || Config.enableSilverOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STEPHANITE.getDefaultState(), Config.VeinSizeStephanite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkStephanite.get(), Config.MinHeightStephanite.get(), 0, Config.MaxHeightStephanite.get())));
				}
				if(Config.All.get() || Config.enableGersdorffite.get() || Config.enableNickelOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GERSDORFFITE.getDefaultState(), Config.VeinSizeGersdorffite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGersdorffite.get(), Config.MinHeightGersdorffite.get(), 0, Config.MaxHeightGersdorffite.get())));
				}
				if(Config.All.get() || Config.enableCarrollite.get() || Config.enableCobaltOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARROLLITE.getDefaultState(), Config.VeinSizeCarrollite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCarrollite.get(), Config.MinHeightCarrollite.get(), 0, Config.MaxHeightCarrollite.get())));
				}
				if(Config.All.get() || Config.enableManganite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MANGANITE.getDefaultState(), Config.VeinSizeManganite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkManganite.get(), Config.MinHeightManganite.get(), 0, Config.MaxHeightManganite.get())));
				}
				if(Config.All.get() || Config.enableHausmannite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUSMANNITE.getDefaultState(), Config.VeinSizeHausmannite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHausmannite.get(), Config.MinHeightHausmannite.get(), 0, Config.MaxHeightHausmannite.get())));
				}
				if(Config.All.get() || Config.enableTitanite.get() || Config.enableTitaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TITANITE.getDefaultState(), Config.VeinSizeTitanite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTitanite.get(), Config.MinHeightTitanite.get(), 0, Config.MaxHeightTitanite.get())));
				}
				if(Config.All.get() || Config.enableCelestine.get() || Config.enableStrontiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CELESTINE.getDefaultState(), Config.VeinSizeCelestine.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCelestine.get(), Config.MinHeightCelestine.get(), 0, Config.MaxHeightCelestine.get())));
				}
				if(Config.All.get() || Config.enablePetalite.get() || Config.enableLithiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PETALITE.getDefaultState(), Config.VeinSizePetalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPetalite.get(), Config.MinHeightPetalite.get(), 0, Config.MaxHeightPetalite.get())));
				}
				if(Config.All.get() || Config.enableKainite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KAINITE.getDefaultState(), Config.VeinSizeKainite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkKainite.get(), Config.MinHeightKainite.get(), 0, Config.MaxHeightKainite.get())));
				}				
				if(Config.All.get() || Config.enableSpinel_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPINEL_ORE.getDefaultState(), Config.VeinSizeSpinel_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSpinel_ore.get(), Config.MinHeightSpinel_ore.get(), 0, Config.MaxHeightSpinel_ore.get())));
				}
				if(Config.All.get() || Config.enableTourmaline_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TOURMALINE_ORE.getDefaultState(), Config.VeinSizeTourmaline_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTourmaline_ore.get(), Config.MinHeightTourmaline_ore.get(), 0, Config.MaxHeightTourmaline_ore.get())));
				}
				if(Config.All.get() || Config.enableTanzanite_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TANZANITE_ORE.getDefaultState(), Config.VeinSizeTanzanite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTanzanite_ore.get(), Config.MinHeightTanzanite_ore.get(), 0, Config.MaxHeightTanzanite_ore.get())));
				}
				if(Config.All.get() || Config.enableOpal_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OPAL_ORE.getDefaultState(), Config.VeinSizeOpal_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkOpal_ore.get(), Config.MinHeightOpal_ore.get(), 0, Config.MaxHeightOpal_ore.get())));
				}
				if(Config.All.get() || Config.enablePyrope_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROPE_ORE.getDefaultState(), Config.VeinSizePyrope_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPyrope_ore.get(), Config.MinHeightPyrope_ore.get(), 0, Config.MaxHeightPyrope_ore.get())));
				}
				if(Config.All.get() || Config.enableAndradite_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANDRADITE_ORE.getDefaultState(), Config.VeinSizeAndradite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAndradite_ore.get(), Config.MinHeightAndradite_ore.get(), 0, Config.MaxHeightAndradite_ore.get())));
				}
			}
			
			if(biome.getTempCategory() == TempCategory.OCEAN || biome.getTempCategory() == TempCategory.COLD) {
				if(Config.All.get() || Config.enableSulphur.get() || Config.enableSulphurOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SULPHUR.getDefaultState(), Config.VeinSizeSulphur.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSulphur.get(), Config.MinHeightSulphur.get(), 0, Config.MaxHeightSulphur.get())));
				}
				if(Config.All.get() || Config.enableClausthalite.get() || Config.enableSeleniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CLAUSTHALITE.getDefaultState(), Config.VeinSizeClausthalite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkClausthalite.get(), Config.MinHeightClausthalite.get(), 0, Config.MaxHeightClausthalite.get())));
				}
				if(Config.All.get() || Config.enableLollingite.get() || Config.enableArsenicOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LOLLINGITE.getDefaultState(), Config.VeinSizeLollingite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkLollingite.get(), Config.MinHeightLollingite.get(), 0, Config.MaxHeightLollingite.get())));
				}
				if(Config.All.get() || Config.enableKesterite.get() || Config.enableTinOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KESTERITE.getDefaultState(), Config.VeinSizeKesterite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkKesterite.get(), Config.MinHeightKesterite.get(), 0, Config.MaxHeightKesterite.get())));
				}
				if(Config.All.get() || Config.enableCerussite.get() || Config.enableLeadOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CERUSSITE.getDefaultState(), Config.VeinSizeCerussite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCerussite.get(), Config.MinHeightCerussite.get(), 0, Config.MaxHeightCerussite.get())));
				}
				if(Config.All.get() || Config.enableHemimorphite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMIMORPHITE.getDefaultState(), Config.VeinSizeHemimorphite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHemimorphite.get(), Config.MinHeightHemimorphite.get(), 0, Config.MaxHeightHemimorphite.get())));
				}
				if(Config.All.get() || Config.enableFranklinite.get() || Config.enableZincOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FRANKLINITE.getDefaultState(), Config.VeinSizeFranklinite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkFranklinite.get(), Config.MinHeightFranklinite.get(), 0, Config.MaxHeightFranklinite.get())));
				}
				if(Config.All.get() || Config.enableGreenockite.get() || Config.enableCadmiumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GREENOCKITE.getDefaultState(), Config.VeinSizeGreenockite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGreenockite.get(), Config.MinHeightGreenockite.get(), 0, Config.MaxHeightGreenockite.get())));
				}
				if(Config.All.get() || Config.enableEnargite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ENARGITE.getDefaultState(), Config.VeinSizeEnargite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkEnargite.get(), Config.MinHeightEnargite.get(), 0, Config.MaxHeightEnargite.get())));
				}
				if(Config.All.get() || Config.enableCovellite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COVELLITE.getDefaultState(), Config.VeinSizeCovellite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCovellite.get(), Config.MinHeightCovellite.get(), 0, Config.MaxHeightCovellite.get())));
				}
				if(Config.All.get() || Config.enableCuprite.get() || Config.enableCopperOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CUPRITE.getDefaultState(), Config.VeinSizeCuprite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkCuprite.get(), Config.MinHeightCuprite.get(), 0, Config.MaxHeightCuprite.get())));
				}
				if(Config.All.get() || Config.enableAcanthite.get() || Config.enableSilverOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ACANTHITE.getDefaultState(), Config.VeinSizeAcanthite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAcanthite.get(), Config.MinHeightAcanthite.get(), 0, Config.MaxHeightAcanthite.get())));
				}
				if(Config.All.get() || Config.enableMillerite.get() || Config.enableNickelOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MILLERITE.getDefaultState(), Config.VeinSizeMillerite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkMillerite.get(), Config.MinHeightMillerite.get(), 0, Config.MaxHeightMillerite.get())));
				}
				if(Config.All.get() || Config.enableSkutterudite.get() || Config.enableCobaltOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SKUTTERUDITE.getDefaultState(), Config.VeinSizeSkutterudite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSkutterudite.get(), Config.MinHeightSkutterudite.get(), 0, Config.MaxHeightSkutterudite.get())));
				}
				if(Config.All.get() || Config.enableAlabandite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ALABANDITE.getDefaultState(), Config.VeinSizeAlabandite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAlabandite.get(), Config.MinHeightAlabandite.get(), 0, Config.MaxHeightAlabandite.get())));
				}
				if(Config.All.get() || Config.enableRhodonite.get() || Config.enableManganeseOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RHODONITE.getDefaultState(), Config.VeinSizeRhodonite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRhodonite.get(), Config.MinHeightRhodonite.get(), 0, Config.MaxHeightRhodonite.get())));
				}
				if(Config.All.get() || Config.enableAnatase.get() || Config.enableTitaniumOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANATASE.getDefaultState(), Config.VeinSizeAnatase.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAnatase.get(), Config.MinHeightAnatase.get(), 0, Config.MaxHeightAnatase.get())));
				}
				if(Config.All.get() || Config.enableLangbeinite.get() || Config.enableNPKOres.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LANGBEINITE.getDefaultState(), Config.VeinSizeLangbeinite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkLangbeinite.get(), Config.MinHeightLangbeinite.get(), 0, Config.MaxHeightLangbeinite.get())));
				}
				if(Config.All.get() || Config.enableSugilite_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SUGILITE_ORE.getDefaultState(), Config.VeinSizeSugilite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSugilite_ore.get(), Config.MinHeightSugilite_ore.get(), 0, Config.MaxHeightSugilite_ore.get())));
				}
				if(Config.All.get() || Config.enableChrysoprase_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHRYSOPRASE_ORE.getDefaultState(), Config.VeinSizeChrysoprase_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkChrysoprase_ore.get(), Config.MinHeightChrysoprase_ore.get(), 0, Config.MaxHeightChrysoprase_ore.get())));
				}
				if(Config.All.get() || Config.enableHauyne_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUYNE_ORE.getDefaultState(), Config.VeinSizeHauyne_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkHauyne_ore.get(), Config.MinHeightHauyne_ore.get(), 0, Config.MaxHeightHauyne_ore.get())));
				}
				if(Config.All.get() || Config.enableOpal_ore.get() || Config.enableAllGems.get() || Config.enableSomeGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OPAL_ORE.getDefaultState(), Config.VeinSizeOpal_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkOpal_ore.get(), Config.MinHeightOpal_ore.get(), 0, Config.MaxHeightOpal_ore.get())));
				}
				if(Config.All.get() || Config.enableSpessartine_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPESSARTINE_ORE.getDefaultState(), Config.VeinSizeSpessartine_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkSpessartine_ore.get(), Config.MinHeightSpessartine_ore.get(), 0, Config.MaxHeightSpessartine_ore.get())));
				}
				if(Config.All.get() || Config.enableTsavorite_ore.get() || Config.enableAllGems.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TSAVORITE_ORE.getDefaultState(), Config.VeinSizeTsavorite_ore.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkTsavorite_ore.get(), Config.MinHeightTsavorite_ore.get(), 0, Config.MaxHeightTsavorite_ore.get())));
				}
			}
			if(biome.getDownfall() < 0.25F) {
				if(Config.All.get() || Config.enableNitratine.get() || Config.enableSaltpetreOre.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NITRATINE.getDefaultState(), Config.VeinSizeNitratine.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkNitratine.get(), Config.MinHeightNitratine.get(), 0, Config.MaxHeightNitratine.get())));
				}				
			}
			if(biome.getTempCategory() != TempCategory.WARM && biome.getTempCategory() != TempCategory.OCEAN && biome.getDownfall() > 0.75F) { //forest 0.8 ...
				if(Config.All.get() || Config.enablePeat.get() || Config.enableCoalOres.get()) {					
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(), Config.VeinSizePeat.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkPeat.get(), Config.MinHeightPeat.get(), 0, Config.MaxHeightPeat.get())));	
				}
				if((biome.isHighHumidity() || biome.getCategory() == Biome.Category.SWAMP) && (Config.All.get() || Config.enableAdditionalPeat.get() || Config.enableCoalOres.get())) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(), Config.VeinSizeAdditionalPeat.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAdditionalPeat.get(), Config.MinHeightAdditionalPeat.get(), 0, Config.MaxHeightAdditionalPeat.get())));						
				}
			}
		}		
	}
	
	private static void handleInfestedStone(Biome biome) {
		List<ConfiguredFeature> featuresToRemove = new ArrayList<ConfiguredFeature>();
		if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
			for (ConfiguredFeature<?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)) {					
	            if (((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {	
	            	Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
	                if (b == Blocks.INFESTED_STONE) {
	                	featuresToRemove.add(feature);	                	
	                }
	            }
	        }
			if(biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(featuresToRemove)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.INFESTED_STONE.getDefaultState(), Config.VeinSizeInfestedStone.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkInfestedStone.get(), Config.MinHeightInfestedStone.get(), 0, Config.MaxHeightInfestedStone.get())));
			}        	
		}				
	}

	private static void addVanillaStuff(Biome biome) {
		if(Config.enableGold.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), Config.VeinSizeGold.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGold.get(), Config.MinHeightGold.get(), 0, Config.MaxHeightGold.get())));			   	
		}
		if(Config.enableRedstone.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.REDSTONE_ORE.getDefaultState(), Config.VeinSizeRedstone.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkRedstone.get(), Config.MinHeightRedstone.get(), 0, Config.MaxHeightRedstone.get())));		
		}
		if(Config.enableDiamond.get()) {			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIAMOND_ORE.getDefaultState(), Config.VeinSizeDiamond.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkDiamond.get(), Config.MinHeightDiamond.get(), 0, Config.MaxHeightDiamond.get())));			  			
		}
		if(Config.enableLapis.get()) {			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.LAPIS_ORE.getDefaultState(), Config.VeinSizeLapis.get()), Placement.COUNT_DEPTH_AVERAGE, new DepthAverageConfig(Config.VeinsPerChunkLapis.get(), Config.DepthAverageLapis.get(), Config.DepthAverageLapis.get())));		 			
		}
		if(Config.enableDirt.get()) {			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), Config.VeinSizeDirt.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkDirt.get(), Config.MinHeightDirt.get(), 0, Config.MaxHeightDirt.get())));	    			
		}
		if(Config.enableGravel.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), Config.VeinSizeGravel.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGravel.get(), Config.MinHeightGravel.get(), 0, Config.MaxHeightGravel.get())));		    			
		}
		if(Config.enableGranite.get()) {	
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), Config.VeinSizeGranite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkGranite.get(), Config.MinHeightGranite.get(), 0, Config.MaxHeightGranite.get())));			   			
		}
		if(Config.enableDiorite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), Config.VeinSizeDiorite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkDiorite.get(), Config.MinHeightDiorite.get(), 0, Config.MaxHeightDiorite.get())));			   			
		}
		if(Config.enableAndesite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), Config.VeinSizeAndesite.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkAndesite.get(), Config.MinHeightAndesite.get(), 0, Config.MaxHeightAndesite.get())));			   						
		}
		DefaultBiomeFeatures.addSedimentDisks(biome);
	    if(biome.getCategory() == Biome.Category.SWAMP) {
	    	DefaultBiomeFeatures.addSwampClayDisks(biome);
	    }	    
	   	if(biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU || biome == Biomes.ERODED_BADLANDS || biome == Biomes.MODIFIED_BADLANDS_PLATEAU || biome == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU || biome == Biomes.WOODED_BADLANDS_PLATEAU) {
	   		if(Config.enableBadlandsGold.get()) {
	   			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), Config.VeinSizeBadlandsGold.get()), Placement.COUNT_RANGE, new CountRangeConfig(Config.VeinsPerChunkBadlandsGold.get(), Config.MinHeightBadlandsGold.get(), Config.MinHeightBadlandsGold.get(), Config.MaxHeightBadlandsGold.get())));	   			   			   			   		   		   			
	   		}
	   	}
	   	if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
	   		if(Config.enableEmerald.get()) {
	   			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE, new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.EMERALD_ORE.getDefaultState()), Placement.EMERALD_ORE, IPlacementConfig.NO_PLACEMENT_CONFIG));	   	  	   			   			
	   		}
	   	}	   	
	}

}
