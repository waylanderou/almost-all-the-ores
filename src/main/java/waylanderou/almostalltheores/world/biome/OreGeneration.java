package waylanderou.almostalltheores.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import waylanderou.almostalltheores.block.Ores;
import waylanderou.almostalltheores.config.AatoConfig;
import waylanderou.almostalltheores.config.AatoConfigHelper;
import waylanderou.almostalltheores.config.IndividualOreConfigHolder;

public class OreGeneration {
	private final Block[] VANILLA_ORE_FEATURES = { Blocks.IRON_ORE, Blocks.COAL_ORE,
			Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.COPPER_ORE};

	public void setup(BiomeLoadingEvent event) {
		if(event.getCategory() == Biome.BiomeCategory.NETHER) {
			removeVanillaNetherOres(event);
			addNetherOres(event);
		} else if(event.getCategory() == Biome.BiomeCategory.THEEND) {
			//We don't care about the end
		} else {
			//Overworld or custom dimensions			
			removeVanillaOreFeatures(event);
			handleInfestedStone(event);
			addOverworldGeneration(event);
		}
	}

	private void removeVanillaNetherOres(BiomeLoadingEvent event) {
		List<Supplier<PlacedFeature>> suppliersToRemove = new ArrayList<Supplier<PlacedFeature>>();
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).forEach(featureSupplier -> {
			featureSupplier.get().getFeatures().forEach((feature) -> {
				if(feature.config instanceof OreConfiguration) {						
					((OreConfiguration)feature.config).targetStates.forEach(state -> {
						Block b = state.state.getBlock();
						if(b == Blocks.NETHER_QUARTZ_ORE || b == Blocks.NETHER_GOLD_ORE) {
							suppliersToRemove.add(featureSupplier);
						}
					});
				}					
			});

		});
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).removeAll(suppliersToRemove);
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
					BlockState oreState = blockConfigHolder.getOre().defaultBlockState();
					addOre(event,
							List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, oreState),
									OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, oreState)),
							oreState,
							blockConfigHolder.getVeinSize(),
							blockConfigHolder.getMinHeight(),
							blockConfigHolder.getMaxHeight(),
							blockConfigHolder.getVeinsPerChunk(),
							blockConfigHolder.hasTrianglePlacement());
				}
			}
		});
		if(AatoConfig.enableAllGems.get() || AatoConfig.enableChrysocolla_ore.get()
				|| (AatoConfig.enableStoneAge.get() && AatoConfig.enablePlugAndPlay.get())) {
			if(!AatoConfig.blacklistChrysocollaOre.get().contains(event.getName().toString()))
				addChrysocollaOre(event);
		}
	}

	private void addOre(BiomeLoadingEvent event, List<TargetBlockState> fill, BlockState state, int vsize, int min, int max, int vpchunk, boolean triangle) {
		event 
		.getGeneration()
		.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, 
				Feature.ORE.configured(
						new OreConfiguration(fill,
								vsize))
				.placed(orePlacementModifiers(vpchunk, min, max, triangle)));
	}

	private void removeVanillaOreFeatures(BiomeLoadingEvent event) {
		List<Supplier<PlacedFeature>> suppliersToRemove = new ArrayList<Supplier<PlacedFeature>>();
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).forEach(featureSupplier -> {
			featureSupplier.get().getFeatures().forEach((feature) -> {
				if(feature.config instanceof OreConfiguration) {						
					((OreConfiguration)feature.config).targetStates.forEach(state -> {
						Block blockToCheck = state.state.getBlock();
						if(isVanillaOre(blockToCheck)) {
							suppliersToRemove.add(featureSupplier);
						}
					});
				}					
			});
		});
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeAll(suppliersToRemove);
	}

	private boolean isVanillaOre(Block blockToCheck) {
		for(Block vanillaOreFeature : VANILLA_ORE_FEATURES) {
			if(blockToCheck.equals(vanillaOreFeature))
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
						List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, blockConfigHolder.getOre().defaultBlockState())), 
						blockConfigHolder.getOre().defaultBlockState(),
						blockConfigHolder.getVeinSize(),
						blockConfigHolder.getMinHeight(),
						blockConfigHolder.getMaxHeight(),
						blockConfigHolder.getVeinsPerChunk(),
						false);
			}
		});
	}

	private void handleInfestedStone(BiomeLoadingEvent event) {
		List<Supplier<PlacedFeature>> suppliersToRemove = new ArrayList<Supplier<PlacedFeature>>();
		if(isInfestedBiome(event)) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).forEach(featureSupplier -> {

				featureSupplier.get().getFeatures().forEach((feature) -> {
					if(feature.config instanceof OreConfiguration) {						
						((OreConfiguration)feature.config).targetStates.forEach(state -> {
							Block blockToCheck = state.state.getBlock();
							if(blockToCheck == Blocks.INFESTED_STONE || blockToCheck == Blocks.INFESTED_DEEPSLATE) {
								suppliersToRemove.add(featureSupplier);
							}
						});
					}					
				});
			});
		}
		event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_DECORATION).removeAll(suppliersToRemove);
	}


	private boolean isInfestedBiome(BiomeLoadingEvent event) {
		final ResourceLocation biomeToCheck = event.getName();
		if(biomeToCheck.equals(Biomes.WINDSWEPT_FOREST.getRegistryName()) ||
				biomeToCheck.equals(Biomes.WINDSWEPT_GRAVELLY_HILLS.getRegistryName()) ||
				biomeToCheck.equals(Biomes.WINDSWEPT_HILLS.getRegistryName()) ||
				biomeToCheck.equals(Biomes.WINDSWEPT_SAVANNA.getRegistryName())) {
			return true;
		}
		return false;
	}

	private void addChrysocollaOre(BiomeLoadingEvent event) {
		BlockState chrysocollaState = Ores.CHRYSOCOLLA_ORE.defaultBlockState();
		addOre(event, 
				List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, chrysocollaState),
						OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, chrysocollaState)),
				chrysocollaState,
				AatoConfig.VeinSizeChrysocolla_ore.get(),
				AatoConfig.MinHeightChrysocolla_ore.get(),
				AatoConfig.MaxHeightChrysocolla_ore.get(),
				AatoConfig.VeinsPerChunkChrysocolla_ore.get(), false);
	}

	private static List<PlacementModifier> orePlacementModifiers(int veinsPerChunk, int min, int max, boolean triangle) {
		if(triangle)
			return List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max)), BiomeFilter.biome());
		else
			return List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max)), BiomeFilter.biome());
	}

}