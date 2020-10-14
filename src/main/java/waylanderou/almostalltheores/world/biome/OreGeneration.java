package waylanderou.almostalltheores.world.biome;

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
import waylanderou.almostalltheores.AatoConfig;
import waylanderou.almostalltheores.block.Ores;

public class OreGeneration {

	public static void setup() {
		for(Biome biome: ForgeRegistries.BIOMES.getValues()) {			
			if(biome.getCategory() == Biome.Category.NETHER) {	
				if(AatoConfig.clearNether.get()) {
					biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
					removeNetherQuartz(biome);
				}
				if(!AatoConfig.disableAatoGeneration.get()) {
					addNetherOres(biome);
				}				
				continue;
			}
			if(biome.getCategory() == Biome.Category.THEEND) {								
				continue;
			}
			if(AatoConfig.handleEverythingInOverworld.get()) {
				removeEverythingExceptWhitelisted(biome);
			} else {
				removeVanillaStuff(biome);
			}
			if(!AatoConfig.disableAatoGeneration.get()) {
				addAatoOverworldGeneration(biome);
			}
			addVanillaStuff(biome);
			handleInfestedStone(biome);
		}		
	}

	private static void removeEverythingExceptWhitelisted(Biome biome) {
		boolean keep;
		List<ConfiguredFeature<?,?>> featuresToRemove = new ArrayList<ConfiguredFeature<?,?>>();
		for(ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)) {
			if (feature.config instanceof DecoratedFeatureConfig) {
				if(((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {
					Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
					keep = false;
					for(String modname : AatoConfig.modWhitelist.get()) {
						if(b.getRegistryName().getNamespace().equals(modname))
							keep = true;
					}
					if(!keep)
						featuresToRemove.add(feature);
				}
			}
		}
		biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(featuresToRemove);

	}

	private static void removeNetherQuartz(Biome biome) {
		List<ConfiguredFeature<?, ?>> featuresToRemove = new ArrayList<ConfiguredFeature<?, ?>>();
		for(ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)) {
			if (feature.config instanceof DecoratedFeatureConfig) {
				if(((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {
					Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
					if (b == Blocks.NETHER_QUARTZ_ORE) {						
						featuresToRemove.add(feature);	                	
					}
				}
			}
		}
		biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(featuresToRemove);
	}

	private static void addAatoOverworldGeneration(Biome biome) {		
		if(AatoConfig.All.get() || AatoConfig.enablePGMs.get() || AatoConfig.enabledPGMs.get()) {
			if(!AatoConfig.blacklistCommonPGMsOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PLATINUM_GROUP_METALS.getDefaultState(), AatoConfig.VeinSizePGMs.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPGMs.get(), AatoConfig.MinHeightPGMs.get(), 0,AatoConfig.MaxHeightPGMs.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableRarePGMs.get() || AatoConfig.enabledRarePGMs.get()) {
			if(!AatoConfig.blacklistRarePGMsOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RARE_PLATINUM_GROUP_METALS.getDefaultState(), AatoConfig.VeinSizeRarePGMs.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRarePGMs.get(), AatoConfig.MinHeightRarePGMs.get(), 0,AatoConfig.MaxHeightRarePGMs.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePyrite.get() || AatoConfig.enableSulphurOres.get()) {
			if(!AatoConfig.blacklistSulfurOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYRITE.getDefaultState(), AatoConfig.VeinSizePyrite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPyrite.get(), AatoConfig.MinHeightPyrite.get(), 0,AatoConfig.MaxHeightPyrite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableGuano.get() || AatoConfig.enableNPKOres.get()) {
			if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GUANO.getDefaultState(), AatoConfig.VeinSizeGuano.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGuano.get(), AatoConfig.MinHeightGuano.get(), 0,AatoConfig.MaxHeightGuano.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePhosphorite.get() || AatoConfig.enableNPKOres.get()) {
			if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PHOSPHORITE.getDefaultState(), AatoConfig.VeinSizePhosphorite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPhosphorite.get(), AatoConfig.MinHeightPhosphorite.get(), 0,AatoConfig.MaxHeightPhosphorite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableLignite_ore.get() || AatoConfig.enableCoalOres.get()) {
			if(!AatoConfig.blacklistLigniteOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LIGNITE_ORE.getDefaultState(), AatoConfig.VeinSizeLignite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkLignite_ore.get(), AatoConfig.MinHeightLignite_ore.get(), 0,AatoConfig.MaxHeightLignite_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableBituminous_coal_ore.get() || AatoConfig.enableCoalOres.get()) {
			if(!AatoConfig.blacklistBituminousCoalOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BITUMINOUS_COAL_ORE.getDefaultState(), AatoConfig.VeinSizeBituminous_coal_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBituminous_coal_ore.get(), AatoConfig.MinHeightBituminous_coal_ore.get(), 0,AatoConfig.MaxHeightBituminous_coal_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableAnthracite_ore.get() || AatoConfig.enableCoalOres.get()) {
			if(!AatoConfig.blacklistAnthraciteOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANTHRACITE_ORE.getDefaultState(), AatoConfig.VeinSizeAnthracite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAnthracite_ore.get(), AatoConfig.MinHeightAnthracite_ore.get(), 0,AatoConfig.MaxHeightAnthracite_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableGraphite.get() || AatoConfig.enableGraphiteOre.get()) {
			if(!AatoConfig.blacklistGraphiteOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GRAPHITE.getDefaultState(), AatoConfig.VeinSizeGraphite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGraphite.get(), AatoConfig.MinHeightGraphite.get(), 0,AatoConfig.MaxHeightGraphite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableArsenopyrite.get() || AatoConfig.enableArsenicOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ARSENOPYRITE.getDefaultState(), AatoConfig.VeinSizeArsenopyrite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkArsenopyrite.get(), AatoConfig.MinHeightArsenopyrite.get(), 0,AatoConfig.MaxHeightArsenopyrite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableStibnite.get() || AatoConfig.enableAntimonyOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STIBNITE.getDefaultState(), AatoConfig.VeinSizeStibnite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkStibnite.get(), AatoConfig.MinHeightStibnite.get(), 0,AatoConfig.MaxHeightStibnite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableGermanite.get() || AatoConfig.enableGermaniumOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GERMANITE.getDefaultState(), AatoConfig.VeinSizeGermanite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGermanite.get(), AatoConfig.MinHeightGermanite.get(), 0,AatoConfig.MaxHeightGermanite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableArgutite.get() || AatoConfig.enableGermaniumOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ARGUTITE.getDefaultState(), AatoConfig.VeinSizeArgutite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkArgutite.get(), AatoConfig.MinHeightArgutite.get(), 0,AatoConfig.MaxHeightArgutite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableBismuthinite.get() || AatoConfig.enableBismuthOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BISMUTHINITE.getDefaultState(), AatoConfig.VeinSizeBismuthinite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBismuthinite.get(), AatoConfig.MinHeightBismuthinite.get(), 0,AatoConfig.MaxHeightBismuthinite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNative_bismuth.get() || AatoConfig.enableBismuthOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_BISMUTH.getDefaultState(), AatoConfig.VeinSizeNative_bismuth.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNative_bismuth.get(), AatoConfig.MinHeightNative_bismuth.get(), 0,AatoConfig.MaxHeightNative_bismuth.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableBismite.get() || AatoConfig.enableBismuthOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BISMITE.getDefaultState(), AatoConfig.VeinSizeBismite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBismite.get(), AatoConfig.MinHeightBismite.get(), 0,AatoConfig.MaxHeightBismite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCassiterite.get() || AatoConfig.enableTinOres.get()) {
			if(!AatoConfig.blacklistTinOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CASSITERITE.getDefaultState(), AatoConfig.VeinSizeCassiterite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCassiterite.get(), AatoConfig.MinHeightCassiterite.get(), 0,AatoConfig.MaxHeightCassiterite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNative_tin.get() || AatoConfig.enableTinOres.get()) {
			if(!AatoConfig.blacklistTinOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_TIN.getDefaultState(), AatoConfig.VeinSizeNative_tin.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNative_tin.get(), AatoConfig.MinHeightNative_tin.get(), 0,AatoConfig.MaxHeightNative_tin.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableGalena.get() || AatoConfig.enableLeadOres.get()) {
			if(!AatoConfig.blacklistLeadOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GALENA.getDefaultState(), AatoConfig.VeinSizeGalena.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGalena.get(), AatoConfig.MinHeightGalena.get(), 0,AatoConfig.MaxHeightGalena.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePyromorphite.get() || AatoConfig.enableLeadOres.get()) {
			if(!AatoConfig.blacklistLeadOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROMORPHITE.getDefaultState(), AatoConfig.VeinSizePyromorphite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPyromorphite.get(), AatoConfig.MinHeightPyromorphite.get(), 0,AatoConfig.MaxHeightPyromorphite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableBauxite.get() || AatoConfig.enableAluminumOres.get()) {
			if(!AatoConfig.blacklistAluminiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BAUXITE.getDefaultState(), AatoConfig.VeinSizeBauxite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBauxite.get(), AatoConfig.MinHeightBauxite.get(), 0,AatoConfig.MaxHeightBauxite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNepheline.get() || AatoConfig.enableAluminumOres.get()) {
			if(!AatoConfig.blacklistAluminiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NEPHELINE.getDefaultState(), AatoConfig.VeinSizeNepheline.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNepheline.get(), AatoConfig.MinHeightNepheline.get(), 0,AatoConfig.MaxHeightNepheline.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableLeucite.get() || AatoConfig.enableAluminumOres.get()) {
			if(!AatoConfig.blacklistAluminiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LEUCITE.getDefaultState(), AatoConfig.VeinSizeLeucite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkLeucite.get(), AatoConfig.MinHeightLeucite.get(), 0,AatoConfig.MaxHeightLeucite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableSphalerite.get() || AatoConfig.enableZincOres.get()) {
			if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPHALERITE.getDefaultState(), AatoConfig.VeinSizeSphalerite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSphalerite.get(), AatoConfig.MinHeightSphalerite.get(), 0,AatoConfig.MaxHeightSphalerite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableSmithsonite.get() || AatoConfig.enableZincOres.get()) {
			if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SMITHSONITE.getDefaultState(), AatoConfig.VeinSizeSmithsonite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSmithsonite.get(), AatoConfig.MinHeightSmithsonite.get(), 0,AatoConfig.MaxHeightSmithsonite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCinnabar.get() || AatoConfig.enableMercuryOres.get()) {
			if(!AatoConfig.blacklistMercuryOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CINNABAR.getDefaultState(), AatoConfig.VeinSizeCinnabar.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCinnabar.get(), AatoConfig.MinHeightCinnabar.get(), 0,AatoConfig.MaxHeightCinnabar.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableChalcopyrite.get() || AatoConfig.enableCopperOres.get()) {
			if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHALCOPYRITE.getDefaultState(), AatoConfig.VeinSizeChalcopyrite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkChalcopyrite.get(), AatoConfig.MinHeightChalcopyrite.get(), 0,AatoConfig.MaxHeightChalcopyrite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableChalcocite.get() || AatoConfig.enableCopperOres.get()) {
			if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHALCOCITE.getDefaultState(), AatoConfig.VeinSizeChalcocite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkChalcocite.get(), AatoConfig.MinHeightChalcocite.get(), 0,AatoConfig.MaxHeightChalcocite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableMalachite.get() || AatoConfig.enableCopperOres.get()) {
			if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MALACHITE.getDefaultState(), AatoConfig.VeinSizeMalachite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMalachite.get(), AatoConfig.MinHeightMalachite.get(), 0,AatoConfig.MaxHeightMalachite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNative_silver.get() || AatoConfig.enableSilverOres.get()) {
			if(!AatoConfig.blacklistSilverOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_SILVER.getDefaultState(), AatoConfig.VeinSizeNative_silver.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNative_silver.get(), AatoConfig.MinHeightNative_silver.get(), 0,AatoConfig.MaxHeightNative_silver.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableProustite.get() || AatoConfig.enableSilverOres.get()) {
			if(!AatoConfig.blacklistSilverOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PROUSTITE.getDefaultState(), AatoConfig.VeinSizeProustite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkProustite.get(), AatoConfig.MinHeightProustite.get(), 0,AatoConfig.MaxHeightProustite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNickeline.get() || AatoConfig.enableNickelOres.get()) {
			if(!AatoConfig.blacklistNickelOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NICKELINE.getDefaultState(), AatoConfig.VeinSizeNickeline.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNickeline.get(), AatoConfig.MinHeightNickeline.get(), 0,AatoConfig.MaxHeightNickeline.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNepouite.get() || AatoConfig.enableNickelOres.get()) {
			if(!AatoConfig.blacklistNickelOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NEPOUITE.getDefaultState(), AatoConfig.VeinSizeNepouite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNepouite.get(), AatoConfig.MinHeightNepouite.get(), 0,AatoConfig.MaxHeightNepouite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCobaltite.get() || AatoConfig.enableCobaltOres.get()) {
			if(!AatoConfig.blacklistCobaltOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COBALTITE.getDefaultState(), AatoConfig.VeinSizeCobaltite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCobaltite.get(), AatoConfig.MinHeightCobaltite.get(), 0,AatoConfig.MaxHeightCobaltite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableHematite.get() || AatoConfig.enableIronOres.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMATITE.getDefaultState(), AatoConfig.VeinSizeHematite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHematite.get(), AatoConfig.MinHeightHematite.get(), 0,AatoConfig.MaxHeightHematite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableMagnetite.get() || AatoConfig.enableIronOres.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MAGNETITE.getDefaultState(), AatoConfig.VeinSizeMagnetite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMagnetite.get(), AatoConfig.MinHeightMagnetite.get(), 0,AatoConfig.MaxHeightMagnetite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableLimonite.get() || AatoConfig.enableIronOres.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LIMONITE.getDefaultState(), AatoConfig.VeinSizeLimonite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkLimonite.get(), AatoConfig.MinHeightLimonite.get(), 0,AatoConfig.MaxHeightLimonite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableSiderite.get() || AatoConfig.enableIronOres.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SIDERITE.getDefaultState(), AatoConfig.VeinSizeSiderite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSiderite.get(), AatoConfig.MinHeightSiderite.get(), 0,AatoConfig.MaxHeightSiderite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableTelluric_iron.get() || AatoConfig.enableIronOres.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TELLURIC_IRON.getDefaultState(), AatoConfig.VeinSizeTelluric_iron.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTelluric_iron.get(), AatoConfig.MinHeightTelluric_iron.get(), 0,AatoConfig.MaxHeightTelluric_iron.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePyrolusite.get() || AatoConfig.enableManganeseOres.get()) {
			if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROLUSITE.getDefaultState(), AatoConfig.VeinSizePyrolusite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPyrolusite.get(), AatoConfig.MinHeightPyrolusite.get(), 0,AatoConfig.MaxHeightPyrolusite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableChromite.get() || AatoConfig.enableChromiumOres.get()) {
			if(!AatoConfig.blacklistChromiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHROMITE.getDefaultState(), AatoConfig.VeinSizeChromite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkChromite.get(), AatoConfig.MinHeightChromite.get(), 0,AatoConfig.MaxHeightChromite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableMolybdenite.get() || AatoConfig.enableMolybdenumOres.get()) {
			if(!AatoConfig.blacklistMolybdenumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MOLYBDENITE.getDefaultState(), AatoConfig.VeinSizeMolybdenite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMolybdenite.get(), AatoConfig.MinHeightMolybdenite.get(), 0,AatoConfig.MaxHeightMolybdenite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableWulfenite.get() || AatoConfig.enableMolybdenumOres.get()) {
			if(!AatoConfig.blacklistMolybdenumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.WULFENITE.getDefaultState(), AatoConfig.VeinSizeWulfenite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkWulfenite.get(), AatoConfig.MinHeightWulfenite.get(), 0,AatoConfig.MaxHeightWulfenite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableScheelite.get() || AatoConfig.enableTungstenOres.get()) {
			if(!AatoConfig.blacklistTungstenOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SCHEELITE.getDefaultState(), AatoConfig.VeinSizeScheelite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkScheelite.get(), AatoConfig.MinHeightScheelite.get(), 0,AatoConfig.MaxHeightScheelite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableFerberite.get() || AatoConfig.enableTungstenOres.get()) {
			if(!AatoConfig.blacklistTungstenOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FERBERITE.getDefaultState(), AatoConfig.VeinSizeFerberite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkFerberite.get(), AatoConfig.MinHeightFerberite.get(), 0,AatoConfig.MaxHeightFerberite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableHubnerite.get() || AatoConfig.enableTungstenOres.get()) {
			if(!AatoConfig.blacklistTungstenOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HUBNERITE.getDefaultState(), AatoConfig.VeinSizeHubnerite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHubnerite.get(), AatoConfig.MinHeightHubnerite.get(), 0,AatoConfig.MaxHeightHubnerite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableVanadinite.get() || AatoConfig.enableVanadiumOres.get()) {
			if(!AatoConfig.blacklistVanadiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.VANADINITE.getDefaultState(), AatoConfig.VeinSizeVanadinite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkVanadinite.get(), AatoConfig.MinHeightVanadinite.get(), 0,AatoConfig.MaxHeightVanadinite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableDescloizite.get() || AatoConfig.enableVanadiumOres.get()) {
			if(!AatoConfig.blacklistVanadiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.DESCLOIZITE.getDefaultState(), AatoConfig.VeinSizeDescloizite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDescloizite.get(), AatoConfig.MinHeightDescloizite.get(), 0,AatoConfig.MaxHeightDescloizite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableColumbite.get() || AatoConfig.enableNiobiumOres.get()) {
			if(!AatoConfig.blacklistNiobiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COLUMBITE.getDefaultState(), AatoConfig.VeinSizeColumbite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkColumbite.get(), AatoConfig.MinHeightColumbite.get(), 0,AatoConfig.MaxHeightColumbite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableTantalite.get() || AatoConfig.enableTantalumOres.get()) {
			if(!AatoConfig.blacklistTantalumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TANTALITE.getDefaultState(), AatoConfig.VeinSizeTantalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTantalite.get(), AatoConfig.MinHeightTantalite.get(), 0,AatoConfig.MaxHeightTantalite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableRutile.get() || AatoConfig.enableTitaniumOres.get()) {
			if(!AatoConfig.blacklistTitaniumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RUTILE.getDefaultState(), AatoConfig.VeinSizeRutile.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRutile.get(), AatoConfig.MinHeightRutile.get(), 0,AatoConfig.MaxHeightRutile.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableIlmenite.get() || AatoConfig.enableTitaniumOres.get()) {
			if(!AatoConfig.blacklistTitaniumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ILMENITE.getDefaultState(), AatoConfig.VeinSizeIlmenite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkIlmenite.get(), AatoConfig.MinHeightIlmenite.get(), 0,AatoConfig.MaxHeightIlmenite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableZircon.get() || AatoConfig.enableZirconiumOres.get()) {
			if(!AatoConfig.blacklistZirconiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ZIRCON.getDefaultState(), AatoConfig.VeinSizeZircon.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkZircon.get(), AatoConfig.MinHeightZircon.get(), 0,AatoConfig.MaxHeightZircon.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableThorite.get() || AatoConfig.enableThoriumOres.get()) {
			if(!AatoConfig.blacklistThoriumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.THORITE.getDefaultState(), AatoConfig.VeinSizeThorite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkThorite.get(), AatoConfig.MinHeightThorite.get(), 0,AatoConfig.MaxHeightThorite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCarnotite.get() || AatoConfig.enableUraniumOres.get()) {
			if(!AatoConfig.blacklistUraniumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNOTITE.getDefaultState(), AatoConfig.VeinSizeCarnotite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCarnotite.get(), AatoConfig.MinHeightCarnotite.get(), 0,AatoConfig.MaxHeightCarnotite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableUraninite.get() || AatoConfig.enableUraniumOres.get()) {
			if(!AatoConfig.blacklistUraniumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.URANINITE.getDefaultState(), AatoConfig.VeinSizeUraninite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkUraninite.get(), AatoConfig.MinHeightUraninite.get(), 0,AatoConfig.MaxHeightUraninite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableMagnesite.get() || AatoConfig.enableMagnesiumOres.get()) {
			if(!AatoConfig.blacklistMagnesiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MAGNESITE.getDefaultState(), AatoConfig.VeinSizeMagnesite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMagnesite.get(), AatoConfig.MinHeightMagnesite.get(), 0,AatoConfig.MaxHeightMagnesite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableKieserite.get() || AatoConfig.enableMagnesiumOres.get()) {
			if(!AatoConfig.blacklistMagnesiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KIESERITE.getDefaultState(), AatoConfig.VeinSizeKieserite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkKieserite.get(), AatoConfig.MinHeightKieserite.get(), 0,AatoConfig.MaxHeightKieserite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableBrucite.get() || AatoConfig.enableMagnesiumOres.get()) {
			if(!AatoConfig.blacklistMagnesiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BRUCITE.getDefaultState(), AatoConfig.VeinSizeBrucite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBrucite.get(), AatoConfig.MinHeightBrucite.get(), 0,AatoConfig.MaxHeightBrucite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCalcite.get() || AatoConfig.enableCalciumOres.get()) {
			if(!AatoConfig.blacklistCalciumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CALCITE.getDefaultState(), AatoConfig.VeinSizeCalcite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCalcite.get(), AatoConfig.MinHeightCalcite.get(), 0,AatoConfig.MaxHeightCalcite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableGypsum.get() || AatoConfig.enableCalciumOres.get()) {
			if(!AatoConfig.blacklistCalciumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GYPSUM.getDefaultState(), AatoConfig.VeinSizeGypsum.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGypsum.get(), AatoConfig.MinHeightGypsum.get(), 0,AatoConfig.MaxHeightGypsum.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableAnhydrite.get() || AatoConfig.enableCalciumOres.get()) {
			if(!AatoConfig.blacklistCalciumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANHYDRITE.getDefaultState(), AatoConfig.VeinSizeAnhydrite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAnhydrite.get(), AatoConfig.MinHeightAnhydrite.get(), 0,AatoConfig.MaxHeightAnhydrite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableDolomite.get() || AatoConfig.enableCalciumOres.get()) {
			if(!AatoConfig.blacklistCalciumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.DOLOMITE.getDefaultState(), AatoConfig.VeinSizeDolomite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDolomite.get(), AatoConfig.MinHeightDolomite.get(), 0,AatoConfig.MaxHeightDolomite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableStrontianite.get() || AatoConfig.enableStrontiumOres.get()) {
			if(!AatoConfig.blacklistStrontiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STRONTIANITE.getDefaultState(), AatoConfig.VeinSizeStrontianite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkStrontianite.get(), AatoConfig.MinHeightStrontianite.get(), 0,AatoConfig.MaxHeightStrontianite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePolylithionite.get() || AatoConfig.enableLithiumOres.get()) {
			if(!AatoConfig.blacklistLithiumOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.POLYLITHIONITE.getDefaultState(), AatoConfig.VeinSizePolylithionite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPolylithionite.get(), AatoConfig.MinHeightPolylithionite.get(), 0,AatoConfig.MaxHeightPolylithionite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCarnallite.get() || AatoConfig.enableNPKOres.get()) {
			if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNALLITE.getDefaultState(), AatoConfig.VeinSizeCarnallite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCarnallite.get(), AatoConfig.MinHeightCarnallite.get(), 0,AatoConfig.MaxHeightCarnallite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableSylvite.get() || AatoConfig.enableNPKOres.get()) {
			if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SYLVITE.getDefaultState(), AatoConfig.VeinSizeSylvite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSylvite.get(), AatoConfig.MinHeightSylvite.get(), 0,AatoConfig.MaxHeightSylvite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableHalite.get() || AatoConfig.enableSaltOre.get()) {
			if(!AatoConfig.blacklistSaltOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HALITE.getDefaultState(), AatoConfig.VeinSizeHalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHalite.get(), AatoConfig.MinHeightHalite.get(), 0,AatoConfig.MaxHeightHalite.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableSapphire_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SAPPHIRE_ORE.getDefaultState(), AatoConfig.VeinSizeSapphire_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSapphire_ore.get(), AatoConfig.MinHeightSapphire_ore.get(), 0,AatoConfig.MaxHeightSapphire_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableRuby_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RUBY_ORE.getDefaultState(), AatoConfig.VeinSizeRuby_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRuby_ore.get(), AatoConfig.MinHeightRuby_ore.get(), 0,AatoConfig.MaxHeightRuby_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableAmethyst_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AMETHYST_ORE.getDefaultState(), AatoConfig.VeinSizeAmethyst_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAmethyst_ore.get(), AatoConfig.MinHeightAmethyst_ore.get(), 0,AatoConfig.MaxHeightAmethyst_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableJade_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.JADE_ORE.getDefaultState(), AatoConfig.VeinSizeJade_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkJade_ore.get(), AatoConfig.MinHeightJade_ore.get(), 0,AatoConfig.MaxHeightJade_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enablePeridot_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PERIDOT_ORE.getDefaultState(), AatoConfig.VeinSizePeridot_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPeridot_ore.get(), AatoConfig.MinHeightPeridot_ore.get(), 0,AatoConfig.MaxHeightPeridot_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableAgate_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AGATE_ORE.getDefaultState(), AatoConfig.VeinSizeAgate_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAgate_ore.get(), AatoConfig.MinHeightAgate_ore.get(), 0,AatoConfig.MaxHeightAgate_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableCarnelian_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARNELIAN_ORE.getDefaultState(), AatoConfig.VeinSizeCarnelian_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCarnelian_ore.get(), AatoConfig.MinHeightCarnelian_ore.get(), 0,AatoConfig.MaxHeightCarnelian_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableHeliotrope_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HELIOTROPE_ORE.getDefaultState(), AatoConfig.VeinSizeHeliotrope_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHeliotrope_ore.get(), AatoConfig.MinHeightHeliotrope_ore.get(), 0,AatoConfig.MaxHeightHeliotrope_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableTopaz_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TOPAZ_ORE.getDefaultState(), AatoConfig.VeinSizeTopaz_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTopaz_ore.get(), AatoConfig.MinHeightTopaz_ore.get(), 0,AatoConfig.MaxHeightTopaz_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableUnakite_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.UNAKITE_ORE.getDefaultState(), AatoConfig.VeinSizeUnakite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkUnakite_ore.get(), AatoConfig.MinHeightUnakite_ore.get(), 0,AatoConfig.MaxHeightUnakite_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableOnyx_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ONYX_ORE.getDefaultState(), AatoConfig.VeinSizeOnyx_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkOnyx_ore.get(), AatoConfig.MinHeightOnyx_ore.get(), 0,AatoConfig.MaxHeightOnyx_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableTurquoise_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TURQUOISE_ORE.getDefaultState(), AatoConfig.VeinSizeTurquoise_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTurquoise_ore.get(), AatoConfig.MinHeightTurquoise_ore.get(), 0,AatoConfig.MaxHeightTurquoise_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableAmazonite_ore.get() || AatoConfig.enableAllGems.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AMAZONITE_ORE.getDefaultState(), AatoConfig.VeinSizeAmazonite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAmazonite_ore.get(), AatoConfig.MinHeightAmazonite_ore.get(), 0,AatoConfig.MaxHeightAmazonite_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableChrysocolla_ore.get() || AatoConfig.enableAllGems.get() || (AatoConfig.enableStoneAge.get() && AatoConfig.enablePlugAndPlay.get())) {
			if(!AatoConfig.blacklistChrysocollaOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHRYSOCOLLA_ORE.getDefaultState(), AatoConfig.VeinSizeChrysocolla_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkChrysocolla_ore.get(), AatoConfig.MinHeightChrysocolla_ore.get(), 0,AatoConfig.MaxHeightChrysocolla_ore.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableMithril_ore.get() || AatoConfig.enableMithrilOre.get()) {
			if(!AatoConfig.blacklistMithrilOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MITHRIL_ORE.getDefaultState(), AatoConfig.VeinSizeMithril_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMithril_ore.get(), AatoConfig.MinHeightMithril_ore.get(), 0,AatoConfig.MaxHeightMithril_ore.get()))));
		}
		if(biome.getTempCategory() == TempCategory.MEDIUM) {
			if(AatoConfig.enableDiamond.get())
				if(!AatoConfig.blacklistDiamondOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KIMBERLITE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0,AatoConfig.MaxHeightDiamond.get()))));
			if(AatoConfig.All.get() || AatoConfig.enabledTorbernite.get() || AatoConfig.enableUraniumOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TORBERNITE.getDefaultState(), AatoConfig.VeinSizeTorbernite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTorbernite.get(), AatoConfig.MinHeightTorbernite.get(), 0, AatoConfig.MaxHeightTorbernite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_ce.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_CE.getDefaultState(), AatoConfig.VeinSizeBastnasite_ce.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_ce.get(), AatoConfig.MinHeightBastnasite_ce.get(), 0,AatoConfig.MaxHeightBastnasite_ce.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_la.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_LA.getDefaultState(), AatoConfig.VeinSizeBastnasite_la.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_la.get(), AatoConfig.MinHeightBastnasite_la.get(), 0,AatoConfig.MaxHeightBastnasite_la.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableClausthalite.get() || AatoConfig.enableSeleniumOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CLAUSTHALITE.getDefaultState(), AatoConfig.VeinSizeClausthalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkClausthalite.get(), AatoConfig.MinHeightClausthalite.get(), 0,AatoConfig.MaxHeightClausthalite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableOrpiment.get() || AatoConfig.enableArsenicOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ORPIMENT.getDefaultState(), AatoConfig.VeinSizeOrpiment.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkOrpiment.get(), AatoConfig.MinHeightOrpiment.get(), 0,AatoConfig.MaxHeightOrpiment.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableStannite.get() || AatoConfig.enableTinOres.get()) {
				if(!AatoConfig.blacklistTinOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STANNITE.getDefaultState(), AatoConfig.VeinSizeStannite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkStannite.get(), AatoConfig.MinHeightStannite.get(), 0,AatoConfig.MaxHeightStannite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableBoulangerite.get() || AatoConfig.enableLeadOres.get()) {
				if(!AatoConfig.blacklistLeadOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BOULANGERITE.getDefaultState(), AatoConfig.VeinSizeBoulangerite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBoulangerite.get(), AatoConfig.MinHeightBoulangerite.get(), 0,AatoConfig.MaxHeightBoulangerite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHemimorphite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMIMORPHITE.getDefaultState(), AatoConfig.VeinSizeHemimorphite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHemimorphite.get(), AatoConfig.MinHeightHemimorphite.get(), 0,AatoConfig.MaxHeightHemimorphite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableFranklinite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FRANKLINITE.getDefaultState(), AatoConfig.VeinSizeFranklinite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkFranklinite.get(), AatoConfig.MinHeightFranklinite.get(), 0,AatoConfig.MaxHeightFranklinite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableGreenockite.get() || AatoConfig.enableCadmiumOres.get()) {
				if(!AatoConfig.blacklistCadmiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GREENOCKITE.getDefaultState(), AatoConfig.VeinSizeGreenockite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGreenockite.get(), AatoConfig.MinHeightGreenockite.get(), 0,AatoConfig.MaxHeightGreenockite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableNative_copper.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NATIVE_COPPER.getDefaultState(), AatoConfig.VeinSizeNative_copper.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNative_copper.get(), AatoConfig.MinHeightNative_copper.get(), 0,AatoConfig.MaxHeightNative_copper.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableBornite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BORNITE.getDefaultState(), AatoConfig.VeinSizeBornite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBornite.get(), AatoConfig.MinHeightBornite.get(), 0,AatoConfig.MaxHeightBornite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAzurite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.AZURITE.getDefaultState(), AatoConfig.VeinSizeAzurite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAzurite.get(), AatoConfig.MinHeightAzurite.get(), 0,AatoConfig.MaxHeightAzurite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableFreibergite.get() || AatoConfig.enableSilverOres.get()) {
				if(!AatoConfig.blacklistSilverOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FREIBERGITE.getDefaultState(), AatoConfig.VeinSizeFreibergite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkFreibergite.get(), AatoConfig.MinHeightFreibergite.get(), 0,AatoConfig.MaxHeightFreibergite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enablePentlandite.get() || AatoConfig.enableNickelOres.get()) {
				if(!AatoConfig.blacklistNickelOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PENTLANDITE.getDefaultState(), AatoConfig.VeinSizePentlandite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPentlandite.get(), AatoConfig.MinHeightPentlandite.get(), 0,AatoConfig.MaxHeightPentlandite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCarrollite.get() || AatoConfig.enableCobaltOres.get()) {
				if(!AatoConfig.blacklistCobaltOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARROLLITE.getDefaultState(), AatoConfig.VeinSizeCarrollite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCarrollite.get(), AatoConfig.MinHeightCarrollite.get(), 0,AatoConfig.MaxHeightCarrollite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableRhodochrosite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RHODOCHROSITE.getDefaultState(), AatoConfig.VeinSizeRhodochrosite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRhodochrosite.get(), AatoConfig.MinHeightRhodochrosite.get(), 0,AatoConfig.MaxHeightRhodochrosite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHollandite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HOLLANDITE.getDefaultState(), AatoConfig.VeinSizeHollandite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHollandite.get(), AatoConfig.MinHeightHollandite.get(), 0,AatoConfig.MaxHeightHollandite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableBrookite.get() || AatoConfig.enableTitaniumOres.get()) {
				if(!AatoConfig.blacklistTitaniumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BROOKITE.getDefaultState(), AatoConfig.VeinSizeBrookite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBrookite.get(), AatoConfig.MinHeightBrookite.get(), 0,AatoConfig.MaxHeightBrookite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCelestine.get() || AatoConfig.enableStrontiumOres.get()) {
				if(!AatoConfig.blacklistStrontiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CELESTINE.getDefaultState(), AatoConfig.VeinSizeCelestine.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCelestine.get(), AatoConfig.MinHeightCelestine.get(), 0,AatoConfig.MaxHeightCelestine.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enablePolyhalite.get() || AatoConfig.enableNPKOres.get()) {
				if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.POLYHALITE.getDefaultState(), AatoConfig.VeinSizePolyhalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPolyhalite.get(), AatoConfig.MinHeightPolyhalite.get(), 0,AatoConfig.MaxHeightPolyhalite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHauyne_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUYNE_ORE.getDefaultState(), AatoConfig.VeinSizeHauyne_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHauyne_ore.get(), AatoConfig.MinHeightHauyne_ore.get(), 0,AatoConfig.MaxHeightHauyne_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableMoonstone_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MOONSTONE_ORE.getDefaultState(), AatoConfig.VeinSizeMoonstone_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMoonstone_ore.get(), AatoConfig.MinHeightMoonstone_ore.get(), 0,AatoConfig.MaxHeightMoonstone_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAlmandine_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ALMANDINE_ORE.getDefaultState(), AatoConfig.VeinSizeAlmandine_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAlmandine_ore.get(), AatoConfig.MinHeightAlmandine_ore.get(), 0,AatoConfig.MaxHeightAlmandine_ore.get()))));
			}
		}
		if(biome.getTempCategory() == TempCategory.WARM) {
			if(AatoConfig.enableDiamond.get())
				if(!AatoConfig.blacklistDiamondOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KIMBERLITE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0,AatoConfig.MaxHeightDiamond.get()))));
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_y.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_Y.getDefaultState(), AatoConfig.VeinSizeBastnasite_y.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_y.get(), AatoConfig.MinHeightBastnasite_y.get(), 0,AatoConfig.MaxHeightBastnasite_y.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableMonazite_la.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MONAZITE_LA.getDefaultState(), AatoConfig.VeinSizeMonazite_la.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMonazite_la.get(), AatoConfig.MinHeightMonazite_la.get(), 0,AatoConfig.MaxHeightMonazite_la.get()))));			
			}		
			if(AatoConfig.All.get() || AatoConfig.enableMonazite_ce.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MONAZITE_CE.getDefaultState(), AatoConfig.VeinSizeMonazite_ce.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMonazite_ce.get(), AatoConfig.MinHeightMonazite_ce.get(), 0,AatoConfig.MaxHeightMonazite_ce.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableSulphur.get() || AatoConfig.enableSulphurOres.get()) {
				if(!AatoConfig.blacklistSulfurOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SULPHUR.getDefaultState(), AatoConfig.VeinSizeSulphur.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSulphur.get(), AatoConfig.MinHeightSulphur.get(), 0,AatoConfig.MaxHeightSulphur.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableRealgar.get() || AatoConfig.enableArsenicOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.REALGAR.getDefaultState(), AatoConfig.VeinSizeRealgar.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRealgar.get(), AatoConfig.MinHeightRealgar.get(), 0,AatoConfig.MaxHeightRealgar.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTeallite.get() || AatoConfig.enableTinOres.get()) {
				if(!AatoConfig.blacklistTinOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TEALLITE.getDefaultState(), AatoConfig.VeinSizeTeallite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTeallite.get(), AatoConfig.MinHeightTeallite.get(), 0,AatoConfig.MaxHeightTeallite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAnglesite.get() || AatoConfig.enableLeadOres.get()) {
				if(!AatoConfig.blacklistLeadOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANGLESITE.getDefaultState(), AatoConfig.VeinSizeAnglesite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAnglesite.get(), AatoConfig.MinHeightAnglesite.get(), 0,AatoConfig.MaxHeightAnglesite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableZincite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ZINCITE.getDefaultState(), AatoConfig.VeinSizeZincite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkZincite.get(), AatoConfig.MinHeightZincite.get(), 0,AatoConfig.MaxHeightZincite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHydrozincite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HYDROZINCITE.getDefaultState(), AatoConfig.VeinSizeHydrozincite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHydrozincite.get(), AatoConfig.MinHeightHydrozincite.get(), 0,AatoConfig.MaxHeightHydrozincite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableOtavite.get() || AatoConfig.enableCadmiumOres.get()) {
				if(!AatoConfig.blacklistCadmiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OTAVITE.getDefaultState(), AatoConfig.VeinSizeOtavite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkOtavite.get(), AatoConfig.MinHeightOtavite.get(), 0,AatoConfig.MaxHeightOtavite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTennantite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TENNANTITE.getDefaultState(), AatoConfig.VeinSizeTennantite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTennantite.get(), AatoConfig.MinHeightTennantite.get(), 0,AatoConfig.MaxHeightTennantite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTetrahedrite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TETRAHEDRITE.getDefaultState(), AatoConfig.VeinSizeTetrahedrite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTetrahedrite.get(), AatoConfig.MinHeightTetrahedrite.get(), 0,AatoConfig.MaxHeightTetrahedrite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableStephanite.get() || AatoConfig.enableSilverOres.get()) {
				if(!AatoConfig.blacklistSilverOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.STEPHANITE.getDefaultState(), AatoConfig.VeinSizeStephanite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkStephanite.get(), AatoConfig.MinHeightStephanite.get(), 0,AatoConfig.MaxHeightStephanite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableGersdorffite.get() || AatoConfig.enableNickelOres.get()) {
				if(!AatoConfig.blacklistNickelOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GERSDORFFITE.getDefaultState(), AatoConfig.VeinSizeGersdorffite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGersdorffite.get(), AatoConfig.MinHeightGersdorffite.get(), 0,AatoConfig.MaxHeightGersdorffite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCarrollite.get() || AatoConfig.enableCobaltOres.get()) {
				if(!AatoConfig.blacklistCobaltOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CARROLLITE.getDefaultState(), AatoConfig.VeinSizeCarrollite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCarrollite.get(), AatoConfig.MinHeightCarrollite.get(), 0,AatoConfig.MaxHeightCarrollite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableManganite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MANGANITE.getDefaultState(), AatoConfig.VeinSizeManganite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkManganite.get(), AatoConfig.MinHeightManganite.get(), 0,AatoConfig.MaxHeightManganite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHausmannite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUSMANNITE.getDefaultState(), AatoConfig.VeinSizeHausmannite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHausmannite.get(), AatoConfig.MinHeightHausmannite.get(), 0,AatoConfig.MaxHeightHausmannite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTitanite.get() || AatoConfig.enableTitaniumOres.get()) {
				if(!AatoConfig.blacklistTitaniumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TITANITE.getDefaultState(), AatoConfig.VeinSizeTitanite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTitanite.get(), AatoConfig.MinHeightTitanite.get(), 0,AatoConfig.MaxHeightTitanite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCelestine.get() || AatoConfig.enableStrontiumOres.get()) {
				if(!AatoConfig.blacklistStrontiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CELESTINE.getDefaultState(), AatoConfig.VeinSizeCelestine.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCelestine.get(), AatoConfig.MinHeightCelestine.get(), 0,AatoConfig.MaxHeightCelestine.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enablePetalite.get() || AatoConfig.enableLithiumOres.get()) {
				if(!AatoConfig.blacklistLithiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PETALITE.getDefaultState(), AatoConfig.VeinSizePetalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPetalite.get(), AatoConfig.MinHeightPetalite.get(), 0,AatoConfig.MaxHeightPetalite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableKainite.get() || AatoConfig.enableNPKOres.get()) {
				if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KAINITE.getDefaultState(), AatoConfig.VeinSizeKainite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkKainite.get(), AatoConfig.MinHeightKainite.get(), 0,AatoConfig.MaxHeightKainite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableSpinel_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPINEL_ORE.getDefaultState(), AatoConfig.VeinSizeSpinel_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSpinel_ore.get(), AatoConfig.MinHeightSpinel_ore.get(), 0,AatoConfig.MaxHeightSpinel_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTourmaline_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TOURMALINE_ORE.getDefaultState(), AatoConfig.VeinSizeTourmaline_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTourmaline_ore.get(), AatoConfig.MinHeightTourmaline_ore.get(), 0,AatoConfig.MaxHeightTourmaline_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTanzanite_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TANZANITE_ORE.getDefaultState(), AatoConfig.VeinSizeTanzanite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTanzanite_ore.get(), AatoConfig.MinHeightTanzanite_ore.get(), 0,AatoConfig.MaxHeightTanzanite_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableOpal_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OPAL_ORE.getDefaultState(), AatoConfig.VeinSizeOpal_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkOpal_ore.get(), AatoConfig.MinHeightOpal_ore.get(), 0,AatoConfig.MaxHeightOpal_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enablePyrope_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PYROPE_ORE.getDefaultState(), AatoConfig.VeinSizePyrope_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPyrope_ore.get(), AatoConfig.MinHeightPyrope_ore.get(), 0,AatoConfig.MaxHeightPyrope_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAndradite_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANDRADITE_ORE.getDefaultState(), AatoConfig.VeinSizeAndradite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAndradite_ore.get(), AatoConfig.MinHeightAndradite_ore.get(), 0,AatoConfig.MaxHeightAndradite_ore.get()))));
			}
		}
		if(biome.getTempCategory() == TempCategory.COLD) {
			if(AatoConfig.enableDiamond.get())
				if(!AatoConfig.blacklistDiamondOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LAMPROITE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0,AatoConfig.MaxHeightDiamond.get()))));

			if(AatoConfig.All.get() || AatoConfig.enableSamarskite_y.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SAMARSKITE_Y.getDefaultState(), AatoConfig.VeinSizeSamarskite_y.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSamarskite_y.get(), AatoConfig.MinHeightSamarskite_y.get(), 0,AatoConfig.MaxHeightSamarskite_y.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableThortveitite.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.THORTVEITITE.getDefaultState(), AatoConfig.VeinSizeThortveitite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkThortveitite.get(), AatoConfig.MinHeightThortveitite.get(), 0,AatoConfig.MaxHeightThortveitite.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_nd.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_ND.getDefaultState(), AatoConfig.VeinSizeBastnasite_nd.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_nd.get(), AatoConfig.MinHeightBastnasite_nd.get(), 0,AatoConfig.MaxHeightBastnasite_nd.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableMonazite_nd.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MONAZITE_ND.getDefaultState(), AatoConfig.VeinSizeMonazite_nd.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMonazite_nd.get(), AatoConfig.MinHeightMonazite_nd.get(), 0,AatoConfig.MaxHeightMonazite_nd.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableSulphur.get() || AatoConfig.enableSulphurOres.get()) {
				if(!AatoConfig.blacklistSulfurOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SULPHUR.getDefaultState(), AatoConfig.VeinSizeSulphur.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSulphur.get(), AatoConfig.MinHeightSulphur.get(), 0,AatoConfig.MaxHeightSulphur.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableClausthalite.get() || AatoConfig.enableSeleniumOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CLAUSTHALITE.getDefaultState(), AatoConfig.VeinSizeClausthalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkClausthalite.get(), AatoConfig.MinHeightClausthalite.get(), 0,AatoConfig.MaxHeightClausthalite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableLollingite.get() || AatoConfig.enableArsenicOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LOLLINGITE.getDefaultState(), AatoConfig.VeinSizeLollingite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkLollingite.get(), AatoConfig.MinHeightLollingite.get(), 0,AatoConfig.MaxHeightLollingite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableKesterite.get() || AatoConfig.enableTinOres.get()) {
				if(!AatoConfig.blacklistTinOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KESTERITE.getDefaultState(), AatoConfig.VeinSizeKesterite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkKesterite.get(), AatoConfig.MinHeightKesterite.get(), 0,AatoConfig.MaxHeightKesterite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCerussite.get() || AatoConfig.enableLeadOres.get()) {
				if(!AatoConfig.blacklistLeadOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CERUSSITE.getDefaultState(), AatoConfig.VeinSizeCerussite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCerussite.get(), AatoConfig.MinHeightCerussite.get(), 0,AatoConfig.MaxHeightCerussite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHemimorphite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HEMIMORPHITE.getDefaultState(), AatoConfig.VeinSizeHemimorphite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHemimorphite.get(), AatoConfig.MinHeightHemimorphite.get(), 0,AatoConfig.MaxHeightHemimorphite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableFranklinite.get() || AatoConfig.enableZincOres.get()) {
				if(!AatoConfig.blacklistZincOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.FRANKLINITE.getDefaultState(), AatoConfig.VeinSizeFranklinite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkFranklinite.get(), AatoConfig.MinHeightFranklinite.get(), 0,AatoConfig.MaxHeightFranklinite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableGreenockite.get() || AatoConfig.enableCadmiumOres.get()) {
				if(!AatoConfig.blacklistCadmiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GREENOCKITE.getDefaultState(), AatoConfig.VeinSizeGreenockite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGreenockite.get(), AatoConfig.MinHeightGreenockite.get(), 0,AatoConfig.MaxHeightGreenockite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableEnargite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ENARGITE.getDefaultState(), AatoConfig.VeinSizeEnargite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkEnargite.get(), AatoConfig.MinHeightEnargite.get(), 0,AatoConfig.MaxHeightEnargite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCovellite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.COVELLITE.getDefaultState(), AatoConfig.VeinSizeCovellite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCovellite.get(), AatoConfig.MinHeightCovellite.get(), 0,AatoConfig.MaxHeightCovellite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableCuprite.get() || AatoConfig.enableCopperOres.get()) {
				if(!AatoConfig.blacklistCopperOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CUPRITE.getDefaultState(), AatoConfig.VeinSizeCuprite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCuprite.get(), AatoConfig.MinHeightCuprite.get(), 0,AatoConfig.MaxHeightCuprite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAcanthite.get() || AatoConfig.enableSilverOres.get()) {
				if(!AatoConfig.blacklistSilverOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ACANTHITE.getDefaultState(), AatoConfig.VeinSizeAcanthite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAcanthite.get(), AatoConfig.MinHeightAcanthite.get(), 0,AatoConfig.MaxHeightAcanthite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableMillerite.get() || AatoConfig.enableNickelOres.get()) {
				if(!AatoConfig.blacklistNickelOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.MILLERITE.getDefaultState(), AatoConfig.VeinSizeMillerite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkMillerite.get(), AatoConfig.MinHeightMillerite.get(), 0,AatoConfig.MaxHeightMillerite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableSkutterudite.get() || AatoConfig.enableCobaltOres.get()) {
				if(!AatoConfig.blacklistCobaltOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SKUTTERUDITE.getDefaultState(), AatoConfig.VeinSizeSkutterudite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSkutterudite.get(), AatoConfig.MinHeightSkutterudite.get(), 0,AatoConfig.MaxHeightSkutterudite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAlabandite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ALABANDITE.getDefaultState(), AatoConfig.VeinSizeAlabandite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAlabandite.get(), AatoConfig.MinHeightAlabandite.get(), 0,AatoConfig.MaxHeightAlabandite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableRhodonite.get() || AatoConfig.enableManganeseOres.get()) {
				if(!AatoConfig.blacklistManganeseOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.RHODONITE.getDefaultState(), AatoConfig.VeinSizeRhodonite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRhodonite.get(), AatoConfig.MinHeightRhodonite.get(), 0,AatoConfig.MaxHeightRhodonite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableAnatase.get() || AatoConfig.enableTitaniumOres.get()) {
				if(!AatoConfig.blacklistTitaniumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.ANATASE.getDefaultState(), AatoConfig.VeinSizeAnatase.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAnatase.get(), AatoConfig.MinHeightAnatase.get(), 0,AatoConfig.MaxHeightAnatase.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableLangbeinite.get() || AatoConfig.enableNPKOres.get()) {
				if(!AatoConfig.blacklistNPKOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.LANGBEINITE.getDefaultState(), AatoConfig.VeinSizeLangbeinite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkLangbeinite.get(), AatoConfig.MinHeightLangbeinite.get(), 0,AatoConfig.MaxHeightLangbeinite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableSugilite_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SUGILITE_ORE.getDefaultState(), AatoConfig.VeinSizeSugilite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSugilite_ore.get(), AatoConfig.MinHeightSugilite_ore.get(), 0,AatoConfig.MaxHeightSugilite_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableChrysoprase_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CHRYSOPRASE_ORE.getDefaultState(), AatoConfig.VeinSizeChrysoprase_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkChrysoprase_ore.get(), AatoConfig.MinHeightChrysoprase_ore.get(), 0,AatoConfig.MaxHeightChrysoprase_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableHauyne_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.HAUYNE_ORE.getDefaultState(), AatoConfig.VeinSizeHauyne_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkHauyne_ore.get(), AatoConfig.MinHeightHauyne_ore.get(), 0,AatoConfig.MaxHeightHauyne_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableOpal_ore.get() || AatoConfig.enableAllGems.get() || AatoConfig.enableSomeGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.OPAL_ORE.getDefaultState(), AatoConfig.VeinSizeOpal_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkOpal_ore.get(), AatoConfig.MinHeightOpal_ore.get(), 0,AatoConfig.MaxHeightOpal_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableSpessartine_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.SPESSARTINE_ORE.getDefaultState(), AatoConfig.VeinSizeSpessartine_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkSpessartine_ore.get(), AatoConfig.MinHeightSpessartine_ore.get(), 0,AatoConfig.MaxHeightSpessartine_ore.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableTsavorite_ore.get() || AatoConfig.enableAllGems.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TSAVORITE_ORE.getDefaultState(), AatoConfig.VeinSizeTsavorite_ore.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTsavorite_ore.get(), AatoConfig.MinHeightTsavorite_ore.get(), 0,AatoConfig.MaxHeightTsavorite_ore.get()))));
			}
		}
		if(biome.getTempCategory() == TempCategory.OCEAN) {
			if(AatoConfig.enableDiamond.get())
				if(!AatoConfig.blacklistDiamondOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.KIMBERLITE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0,AatoConfig.MaxHeightDiamond.get()))));
			if(AatoConfig.All.get() || AatoConfig.enabledTorbernite.get() || AatoConfig.enableUraniumOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.TORBERNITE.getDefaultState(), AatoConfig.VeinSizeTorbernite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkTorbernite.get(), AatoConfig.MinHeightTorbernite.get(), 0, AatoConfig.MaxHeightTorbernite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_ce.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_CE.getDefaultState(), AatoConfig.VeinSizeBastnasite_ce.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_ce.get(), AatoConfig.MinHeightBastnasite_ce.get(), 0,AatoConfig.MaxHeightBastnasite_ce.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableBastnasite_la.get() || AatoConfig.enableREEs.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.BASTNASITE_LA.getDefaultState(), AatoConfig.VeinSizeBastnasite_la.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBastnasite_la.get(), AatoConfig.MinHeightBastnasite_la.get(), 0,AatoConfig.MaxHeightBastnasite_la.get()))));			
			}
			if(AatoConfig.All.get() || AatoConfig.enableClausthalite.get() || AatoConfig.enableSeleniumOres.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.CLAUSTHALITE.getDefaultState(), AatoConfig.VeinSizeClausthalite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkClausthalite.get(), AatoConfig.MinHeightClausthalite.get(), 0,AatoConfig.MaxHeightClausthalite.get()))));
			}
			if(AatoConfig.All.get() || AatoConfig.enableGreenockite.get() || AatoConfig.enableCadmiumOres.get()) {
				if(!AatoConfig.blacklistCadmiumOres.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.GREENOCKITE.getDefaultState(), AatoConfig.VeinSizeGreenockite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGreenockite.get(), AatoConfig.MinHeightGreenockite.get(), 0,AatoConfig.MaxHeightGreenockite.get()))));
			}			
		}
		if(biome.getDownfall() < 0.25F) {
			if(AatoConfig.All.get() || AatoConfig.enableNitratine.get() || AatoConfig.enableSaltpetreOre.get()) {
				if(!AatoConfig.blacklistSaltpetreOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.NITRATINE.getDefaultState(), AatoConfig.VeinSizeNitratine.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNitratine.get(), AatoConfig.MinHeightNitratine.get(), 0,AatoConfig.MaxHeightNitratine.get()))));
			}				
		}
		if(biome.getTempCategory() != TempCategory.WARM && biome.getTempCategory() != TempCategory.OCEAN && biome.getDownfall() > 0.75F) { //forest 0.8 ...
			if(AatoConfig.All.get() || AatoConfig.enablePeat.get() || AatoConfig.enableCoalOres.get()) {
				if(!AatoConfig.blacklistPeatOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(), AatoConfig.VeinSizePeat.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkPeat.get(), AatoConfig.MinHeightPeat.get(), 0,AatoConfig.MaxHeightPeat.get()))));
			}
			if((biome.isHighHumidity() || biome.getCategory() == Biome.Category.SWAMP) && (AatoConfig.All.get() || AatoConfig.enableAdditionalPeat.get() || AatoConfig.enableCoalOres.get())) {
				if(!AatoConfig.blacklistPeatOre.get().contains(biome.getRegistryName().toString()))
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Ores.PEAT.getDefaultState(), AatoConfig.VeinSizeAdditionalPeat.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAdditionalPeat.get(), AatoConfig.MinHeightAdditionalPeat.get(), 0,AatoConfig.MaxHeightAdditionalPeat.get()))));
			}
		}		
	}

	private static void removeVanillaStuff(Biome biome) {
		List<ConfiguredFeature<?, ?>> featuresToRemove = new ArrayList<ConfiguredFeature<?, ?>>();
		for (ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)) {			
			if (feature.config instanceof DecoratedFeatureConfig) {			
				if(((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {
					Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
					if (b == Blocks.IRON_ORE || b == Blocks.GOLD_ORE || b == Blocks.COAL_ORE || b == Blocks.DIAMOND_ORE || b == Blocks.EMERALD_ORE || b == Blocks.LAPIS_ORE || b == Blocks.REDSTONE_ORE) {
						featuresToRemove.add(feature);	                    	
					} 
					if(b == Blocks.DIRT || b == Blocks.GRAVEL || b == Blocks.GRANITE || b == Blocks.DIORITE || b == Blocks.ANDESITE) {
						featuresToRemove.add(feature);	                    	                    	
					}					
				}				
			}
		}
		biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(featuresToRemove);		
	}

	private static void addNetherOres(Biome biome) {
		if(AatoConfig.All.get() || AatoConfig.enableSulphur.get() || AatoConfig.enableSulphurOres.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.SULPHUR.getDefaultState(), AatoConfig.VeinSizeNetherSulphur.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherSulphur.get(), AatoConfig.MinHeightNetherSulphur.get(), 0, AatoConfig.MaxHeightNetherSulphur.get()))));

		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherCoal.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_COAL_ORE.getDefaultState(), AatoConfig.VeinSizeNetherCoal.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherCoal.get(), AatoConfig.MinHeightNetherCoal.get(), 0,AatoConfig.MaxHeightNetherCoal.get()))));

		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherGold.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeNetherGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherGold.get(), AatoConfig.MinHeightNetherGold.get(), 0,AatoConfig.MaxHeightNetherGold.get()))));
		}
		if(AatoConfig.All.get() || AatoConfig.enableNetherMithril.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Ores.NETHER_MITHRIL_ORE.getDefaultState(), AatoConfig.VeinSizeNetherMithril.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkNetherMithril.get(), AatoConfig.MinHeightNetherMithril.get(), 0,AatoConfig.MaxHeightNetherMithril.get()))));

		}
	}

	private static void handleInfestedStone(Biome biome) {
		List<ConfiguredFeature<?, ?>> featuresToRemove = new ArrayList<ConfiguredFeature<?, ?>>();
		if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
			for (ConfiguredFeature<?, ?> feature : biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION)) {				
				if (feature.config instanceof DecoratedFeatureConfig) {
					if(((DecoratedFeatureConfig)feature.config).feature.feature instanceof OreFeature) {
						Block b = ((OreFeatureConfig)((DecoratedFeatureConfig)feature.config).feature.config).state.getBlock();
						if (b == Blocks.INFESTED_STONE) {
							featuresToRemove.add(feature);	                	
						}
					}
				}
			}			
			if(biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(featuresToRemove)) {
				if(AatoConfig.enableInfestedStone.get()) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.INFESTED_STONE.getDefaultState(), AatoConfig.VeinSizeInfestedStone.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkInfestedStone.get(), AatoConfig.MinHeightInfestedStone.get(), 0,AatoConfig.MaxHeightInfestedStone.get()))));
				} 
			}
		}				
	}

	private static void addVanillaStuff(Biome biome) {
		if(AatoConfig.enableVanillaCoalOre.get()) {
			if(!AatoConfig.blacklistBituminousCoalOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), AatoConfig.VeinSizeCoal.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkCoal.get(), AatoConfig.MinHeightCoal.get(), 0, AatoConfig.MaxHeightCoal.get()))));
		}
		if(AatoConfig.enableVanillaIronOre.get()) {
			if(!AatoConfig.blacklistIronOres.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), AatoConfig.VeinSizeIron.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkIron.get(), AatoConfig.MinHeightIron.get(), 0, AatoConfig.MaxHeightIron.get()))));		      
		}
		if(AatoConfig.enableGold.get()) {
			if(!AatoConfig.blacklistGoldOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGold.get(), AatoConfig.MinHeightGold.get(), 0,AatoConfig.MaxHeightGold.get()))));
		}
		if(AatoConfig.enableRedstone.get()) {
			if(!AatoConfig.blacklistRedstoneOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.REDSTONE_ORE.getDefaultState(), AatoConfig.VeinSizeRedstone.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkRedstone.get(), AatoConfig.MinHeightRedstone.get(), 0,AatoConfig.MaxHeightRedstone.get()))));
		}
		if(AatoConfig.enableLapis.get()) {
			if(!AatoConfig.blacklistLapisOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.LAPIS_ORE.getDefaultState(), AatoConfig.VeinSizeLapis.get())).func_227228_a_(Placement.COUNT_DEPTH_AVERAGE.func_227446_a_(new DepthAverageConfig(AatoConfig.VeinsPerChunkLapis.get(), AatoConfig.DepthAverageLapis.get(), AatoConfig.DepthAverageLapis.get()))));
		}
		if(AatoConfig.enableDiamond.get()) {
			if(!AatoConfig.blacklistDiamondOre.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIAMOND_ORE.getDefaultState(), AatoConfig.VeinSizeDiamond.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiamond.get(), AatoConfig.MinHeightDiamond.get(), 0, AatoConfig.MaxHeightDiamond.get()))));
		}
		if(AatoConfig.enableDirt.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), AatoConfig.VeinSizeDirt.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDirt.get(), AatoConfig.MinHeightDirt.get(), 0,AatoConfig.MaxHeightDirt.get()))));
		}
		if(AatoConfig.enableGravel.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), AatoConfig.VeinSizeGravel.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGravel.get(), AatoConfig.MinHeightGravel.get(), 0,AatoConfig.MaxHeightGravel.get()))));
		}
		if(AatoConfig.enableGranite.get()) {	
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), AatoConfig.VeinSizeGranite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkGranite.get(), AatoConfig.MinHeightGranite.get(), 0,AatoConfig.MaxHeightGranite.get()))));
		}
		if(AatoConfig.enableDiorite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), AatoConfig.VeinSizeDiorite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkDiorite.get(), AatoConfig.MinHeightDiorite.get(), 0,AatoConfig.MaxHeightDiorite.get()))));
		}
		if(AatoConfig.enableAndesite.get()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), AatoConfig.VeinSizeAndesite.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkAndesite.get(), AatoConfig.MinHeightAndesite.get(), 0,AatoConfig.MaxHeightAndesite.get()))));
		}
		DefaultBiomeFeatures.addSedimentDisks(biome);
		if(biome.getCategory() == Biome.Category.SWAMP) {
			DefaultBiomeFeatures.addSwampClayDisks(biome);
		}	    
		if(biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU || biome == Biomes.ERODED_BADLANDS || biome == Biomes.MODIFIED_BADLANDS_PLATEAU || biome == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU || biome == Biomes.WOODED_BADLANDS_PLATEAU) {
			if(AatoConfig.enableBadlandsGold.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), AatoConfig.VeinSizeBadlandsGold.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(AatoConfig.VeinsPerChunkBadlandsGold.get(), AatoConfig.MinHeightBadlandsGold.get(), 0,AatoConfig.MaxHeightBadlandsGold.get()))));
			}
		}
		if(biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS) {
			if(AatoConfig.enableEmerald.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.EMERALD_ORE.getDefaultState())).func_227228_a_(Placement.EMERALD_ORE.func_227446_a_(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
		}	   	
	}

}