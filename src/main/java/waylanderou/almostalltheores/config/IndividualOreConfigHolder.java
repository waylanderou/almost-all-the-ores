package waylanderou.almostalltheores.config;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import waylanderou.almostalltheores.AlmostAllTheOres;

public class IndividualOreConfigHolder {
	private String configName;
	private String configGroup;
	private Block ore;
	public Optional<DownfallCriteria> downfallcriteria;
	private Optional<String> joker;

	public IndividualOreConfigHolder(String configName) {
		this(configName, "NONE");
	}

	public IndividualOreConfigHolder(String configName, String configGroup) {
		this(configName,
				configGroup,
				ForgeRegistries.BLOCKS.getValue(new ResourceLocation("almostalltheores", configName.toLowerCase(Locale.ROOT))));
	}

	public IndividualOreConfigHolder(String configName, String configGroup, Block ore) {		
		this.configName = configName;
		this.configGroup = configGroup;
		this.ore = ore;
		this.joker = Optional.empty();
		this.downfallcriteria = Optional.empty();
	}

	public IndividualOreConfigHolder(String configName, String configGroup, Block ore, DownfallCriteria criteria) {
		this.configName = configName;
		this.configGroup = configGroup;
		this.ore = ore;
		this.joker = Optional.empty();
		this.downfallcriteria = Optional.of(criteria);
	}

	public IndividualOreConfigHolder(String configName, String configGroup, Block ore,  String joker) {
		this.configName = configName;
		this.configGroup = configGroup;
		this.ore = ore;
		this.joker = Optional.of(joker);
		this.downfallcriteria = Optional.empty();
	}

	public IndividualOreConfigHolder(String configName, String configGroup, String joker) {
		this.configName = configName;
		this.configGroup = configGroup;
		this.ore = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("almostalltheores", configName.toLowerCase(Locale.ROOT)));
		this.joker = Optional.of(joker);
		this.downfallcriteria = Optional.empty();
	}

	public <T> T getConfigValue(String configPath) {
		CommentedFileConfig configdata = AatoConfig.getConfigData();
		if(configdata.contains(configPath)) {
			return configdata.get(configPath);
		} else {
			return null;
		}
	}

	public boolean getGroupConfigValue() {
		if(!hasGroup())
			return false;
		else {
			if(getConfigValue("overworldSimplified.enable" + configGroup) == null) {
				if(getConfigValue("overworldSimplified.enable" + configGroup + "Ore") == null) {
					return getConfigValue("overworldSimplified.enable" + configGroup + "Ores");
				} else
					return getConfigValue("overworldSimplified.enable" + configGroup + "Ore");
			} else
				return getConfigValue("overworldSimplified.enable" + configGroup);
		}
	}

	public List<String> getOreGroupBlacklist() {
		if(getConfigValue("blacklists.biomesBlacklist" + configGroup) == null) {
			if(getConfigValue("blacklists.biomesBlacklist" + configGroup + "Ore") == null) {				
				return getConfigValue("blacklists.biomesBlacklist" + configGroup + "Ores");
			} else
				return getConfigValue("blacklists.biomesBlacklist" + configGroup + "Ore");
		} else
			return getConfigValue("blacklists.biomesBlacklist" + configGroup);
	}

	public boolean isEnabled() {
		if(aatoDisabled())
			return false;
		if(AatoConfig.All.get())
			return true;
		if(hasGroup()) {
			if(isOreGroupEnabled())
				return true;
		}
		return getConfigValue("overworldExpert." + configName.toLowerCase(Locale.ROOT) + ".enable" + configName);
	} 

	private boolean aatoDisabled() {
		if(AatoConfig.disableAatoGeneration.get())
			if(this.getOre().getRegistryName().getNamespace().equals(AlmostAllTheOres.MODID))
				return true;
		return false;
	}

	public int getMinHeight() {
		return getConfigValue("overworldExpert." + configName.toLowerCase(Locale.ROOT) + ".MinHeight" + configName);
	}

	public int getMaxHeight() {
		return getConfigValue("overworldExpert." + configName.toLowerCase(Locale.ROOT) + ".MaxHeight" + configName);
	}

	public int getVeinSize() {
		return getConfigValue("overworldExpert." + configName.toLowerCase(Locale.ROOT) + ".VeinSize" + configName);
	}

	public int getVeinsPerChunk() {
		return getConfigValue("overworldExpert." + configName.toLowerCase(Locale.ROOT) + ".VeinsPerChunk" + configName);
	}

	public Block getOre() {
		return this.ore;
	}

	public boolean isOreGroupEnabled() {
		return getGroupConfigValue();
	}

	public boolean isBiomeBlackListed(String biomeName) {
		if(!this.hasBlacklist())
			return false;
		for(String biomeEntry : getOreGroupBlacklist()) {
			if(biomeName.equals(biomeEntry))
				return true;
		}
		return false;
	}

	private boolean hasGroup() {
		if(this.configGroup.equals("NONE"))
			return false;
		else {
			if(this.joker.isPresent()) {
				if(this.joker.get().equals("NO_GROUP"))
					return false;
			}
			return true;
		}
	}

	private boolean hasBlacklist() {
		if(this.configGroup.equals("NONE"))			
			return false;
		else {
			if(this.joker.isPresent()) {
				if(this.joker.get().equals("NO_BLACKLIST"))
					return false;
			}
			return true;
		}
	}

}
