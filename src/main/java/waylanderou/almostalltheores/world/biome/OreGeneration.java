package waylanderou.almostalltheores.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import waylanderou.almostalltheores.block.Ores;
import waylanderou.almostalltheores.config.AatoConfig;
import waylanderou.almostalltheores.config.AatoConfigHelper;
import waylanderou.almostalltheores.config.IndividualOreConfigHolder;

public class OreGeneration {
	private final Block[] VANILLA_ORE_FEATURES = { Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.COAL_ORE,
			Blocks.DIAMOND_ORE,Blocks.EMERALD_ORE, Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE,
			Blocks.DIRT, Blocks.GRAVEL, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE };

	public void setup(BiomeLoadingEvent event) {
		if(event.getCategory() == Biome.Category.NETHER) {
			removeVanillaNetherOres(event);
			addNetherOres(event);
		} else if(event.getCategory() == Biome.Category.THEEND) {
			//We don't care about the end
		} else {
			//Overworld or custom dimensions			
			removeVanillaOreFeatures(event);
			handleInfestedStone(event);
			addOverworldGeneration(event);
		}
	}

	private void removeVanillaNetherOres(BiomeLoadingEvent event) {
		List<Supplier<ConfiguredFeature<?, ?>>> suppliersToRemove = new ArrayList<Supplier<ConfiguredFeature<?, ?>>>();
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).forEach(featureSupplier -> {
			if(featureSupplier.get().config instanceof DecoratedFeatureConfig) {
				((DecoratedFeatureConfig)featureSupplier.get().config).func_241856_an_().forEach((feature) -> {
					if(feature.config instanceof OreFeatureConfig) {						
						final Block b = ((OreFeatureConfig)feature.config).state.getBlock();
						if(b == Blocks.NETHER_QUARTZ_ORE || b == Blocks.NETHER_GOLD_ORE) {
							suppliersToRemove.add(featureSupplier);
						}
					}					
				});
			}
		});
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(suppliersToRemove);
	}

	private void addOverworldGeneration(BiomeLoadingEvent event) {
		AatoConfigHelper helper = new AatoConfigHelper();
		List<IndividualOreConfigHolder> biomesOresList;
		final float temperature = event.getClimate().temperature;
		if(temperature < 0.45f) { //COLD
			biomesOresList = helper.getColdTempOreConfig();
		} else if(temperature > 0.85f) { //WARM
			biomesOresList = helper.getWarmTempOreConfig();
		} else { //MEDIUM
			biomesOresList = helper.getMediumTempOreConfig();
		}
		biomesOresList.addAll(helper.getAllBiomesOreConfig());
		biomesOresList.forEach(blockConfigHolder -> {
			if(!blockConfigHolder.isBiomeBlackListed(event.getName().toString())) {
				boolean downfallPassed = true;
				if(blockConfigHolder.downfallcriteria.isPresent())
					downfallPassed = blockConfigHolder.downfallcriteria.get().test(event.getClimate().downfall);
				if(downfallPassed && (blockConfigHolder.isEnabled() || blockConfigHolder.isOreGroupEnabled())) {
					BlockState oreState = blockConfigHolder.getOre().getDefaultState();
					addOre(event,
							OreFeatureConfig.FillerBlockType.field_241882_a, 
							oreState,
							blockConfigHolder.getVeinSize(),
							blockConfigHolder.getMinHeight(),
							blockConfigHolder.getMaxHeight(),
							blockConfigHolder.getVeinsPerChunk());
				}
			}
		});
		if(AatoConfig.enableLapis.get() && !AatoConfig.blacklistLapisOre.get().contains(event.getName().toString()))
			addLapisOre(event);
		if(AatoConfig.enableAllGems.get() || AatoConfig.enableChrysocolla_ore.get()
				|| (AatoConfig.enableStoneAge.get() && AatoConfig.enablePlugAndPlay.get())) {
			if(!AatoConfig.blacklistChrysocollaOre.get().contains(event.getName().toString()))
				addChrysocollaOre(event);
		}
		if(AatoConfig.enableEmerald.get() && isEmeraldBiome(event))
			addEmeraldOre(event);
		if(AatoConfig.enableBadlandsGold.get() && isBadlands(event))
			addBadlandsGold(event);

	}

	private void addOre(BiomeLoadingEvent event, RuleTest fill, BlockState state, int vsize, int min, int max, int vpchunk) {
		event 
		.getGeneration()
		.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
				Feature.ORE.withConfiguration(
						new OreFeatureConfig(fill,
								state,
								vsize))
				.withPlacement(
						(Placement.field_242907_l.configure(
								new TopSolidRangeConfig(min,
										min,
										max)))
						.func_242728_a().func_242731_b(vpchunk)));
	}

	private void removeVanillaOreFeatures(BiomeLoadingEvent event) {
		List<Supplier<ConfiguredFeature<?, ?>>> suppliersToRemove = new ArrayList<Supplier<ConfiguredFeature<?, ?>>>();
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).forEach(featureSupplier -> {
			if(featureSupplier.get().config instanceof DecoratedFeatureConfig) {
				((DecoratedFeatureConfig)featureSupplier.get().config).func_241856_an_().forEach((feature) -> {
					if(feature.config instanceof OreFeatureConfig) {						
						final Block blockToCheck = ((OreFeatureConfig)feature.config).state.getBlock();
						if(isVanillaOre(blockToCheck)) {
							suppliersToRemove.add(featureSupplier);
						}
					}					
				});
			}
		});
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).removeAll(suppliersToRemove);
	}

	private boolean isVanillaOre(Block blockToCheck) {
		for(Block vanillaOreFeature : VANILLA_ORE_FEATURES) {
			if(blockToCheck == vanillaOreFeature)
				return true;
		}		
		return false;
	}

	private void addNetherOres(BiomeLoadingEvent event) {
		AatoConfigHelper helper = new AatoConfigHelper();
		List<IndividualOreConfigHolder> netherBiomesOresList = helper.getNetherOres();
		netherBiomesOresList.forEach(blockConfigHolder -> {
			if(blockConfigHolder.isEnabled() || blockConfigHolder.isOreGroupEnabled()) {
				addOre(event, 
						OreFeatureConfig.FillerBlockType.field_241883_b, 
						blockConfigHolder.getOre().getDefaultState(),
						blockConfigHolder.getVeinSize(),
						blockConfigHolder.getMinHeight(),
						blockConfigHolder.getMaxHeight(),
						blockConfigHolder.getVeinsPerChunk());
			}
		});
	}

	private void handleInfestedStone(BiomeLoadingEvent event) {
		List<Supplier<ConfiguredFeature<?, ?>>> suppliersToRemove = new ArrayList<Supplier<ConfiguredFeature<?, ?>>>();
		if(isInfestedBiome(event)) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).forEach(featureSupplier -> {
				if(featureSupplier.get().config instanceof DecoratedFeatureConfig) {
					((DecoratedFeatureConfig)featureSupplier.get().config).func_241856_an_().forEach((feature) -> {
						if(feature.config instanceof OreFeatureConfig) {						
							final Block blockToCheck = ((OreFeatureConfig)feature.config).state.getBlock();
							if(blockToCheck == Blocks.INFESTED_STONE) {
								suppliersToRemove.add(featureSupplier);
							}
						}					
					});
				}
			});
		}
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).removeAll(suppliersToRemove);
		if(isInfestedBiome(event))
			addInfestedStone(event);
	}

	private void addInfestedStone(BiomeLoadingEvent event) {
		addOre(event, OreFeatureConfig.FillerBlockType.field_241882_a, 
				Blocks.INFESTED_STONE.getDefaultState(), 
				AatoConfig.VeinSizeInfestedStone.get(), AatoConfig.MinHeightInfestedStone.get(), 
				AatoConfig.MaxHeightInfestedStone.get(), AatoConfig.VeinsPerChunkInfestedStone.get());

	}

	private boolean isInfestedBiome(BiomeLoadingEvent event) {
		final ResourceLocation biomeToCheck = event.getName();
		if(biomeToCheck.equals(Biomes.GRAVELLY_MOUNTAINS.getLocation()) ||
				biomeToCheck.equals(Biomes.MODIFIED_GRAVELLY_MOUNTAINS.getLocation()) ||
				biomeToCheck.equals(Biomes.MOUNTAIN_EDGE.getLocation()) ||
				biomeToCheck.equals(Biomes.MOUNTAINS.getLocation()) || biomeToCheck.equals(Biomes.WOODED_MOUNTAINS.getLocation())) {
			return true;
		}
		return false;
	}

	private void addBadlandsGold(BiomeLoadingEvent event) {
		addOre(event, 
				OreFeatureConfig.FillerBlockType.field_241882_a, 
				Blocks.GOLD_ORE.getDefaultState(),
				AatoConfig.VeinSizeBadlandsGold.get(),
				AatoConfig.MinHeightBadlandsGold.get(),
				AatoConfig.MaxHeightBadlandsGold.get(),
				AatoConfig.VeinsPerChunkBadlandsGold.get());
	}

	private void addEmeraldOre(BiomeLoadingEvent event) {
		event 
		.getGeneration()
		.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
				Feature.EMERALD_ORE.withConfiguration(
						new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), Blocks.EMERALD_ORE.getDefaultState()))
				.withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}

	private void addLapisOre(BiomeLoadingEvent event) {
		event
		.getGeneration()
		.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
								Blocks.LAPIS_ORE.getDefaultState(), AatoConfig.VeinSizeLapis.get()))
				.withPlacement(Placement.field_242910_o.configure(
						new DepthAverageConfig(AatoConfig.DepthAverageLapis.get(),
								AatoConfig.DepthAverageLapis.get()))).func_242728_a());
	}

	private void addChrysocollaOre(BiomeLoadingEvent event) {
		addOre(event, 
				OreFeatureConfig.FillerBlockType.field_241882_a, 
				Ores.CHRYSOCOLLA_ORE.getDefaultState(),
				AatoConfig.VeinSizeChrysocolla_ore.get(),
				AatoConfig.MinHeightChrysocolla_ore.get(),
				AatoConfig.MaxHeightChrysocolla_ore.get(),
				AatoConfig.VeinsPerChunkChrysocolla_ore.get());
	}

	private boolean isBadlands(BiomeLoadingEvent event) {
		final ResourceLocation biome = event.getName();
		if(biome.equals(Biomes.BADLANDS.getLocation()) || biome.equals(Biomes.BADLANDS_PLATEAU.getLocation())
				|| biome.equals(Biomes.ERODED_BADLANDS.getLocation()) || biome.equals(Biomes.MODIFIED_BADLANDS_PLATEAU.getLocation()) 
				|| biome.equals(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU.getLocation()) 
				|| biome.equals(Biomes.WOODED_BADLANDS_PLATEAU.getLocation())) {
			return true;
		}
		return false;
	}

	private boolean isEmeraldBiome(BiomeLoadingEvent event) {
		final ResourceLocation biome = event.getName();
		if(biome.equals(Biomes.GRAVELLY_MOUNTAINS.getLocation()) || biome.equals(Biomes.MODIFIED_GRAVELLY_MOUNTAINS.getLocation()) 
				|| biome.equals(Biomes.MOUNTAIN_EDGE.getLocation()) || biome.equals(Biomes.MOUNTAINS.getLocation()) 
				|| biome.equals(Biomes.WOODED_MOUNTAINS.getLocation())) {
			return true;
		}
		return false;
	}

}