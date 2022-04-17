package waylanderou.almostalltheores.integration;

public class IntegratedOre {
	public final String oreName;
	final String[] mods;
	public boolean isNeeded;
	public boolean isGem;

	public IntegratedOre(String ore, String[] mods) {
		this(ore, mods, false);
	}

	public IntegratedOre(String ore, String[] mods, boolean gem) {
		this.oreName = ore;
		this.mods = mods;
		this.isNeeded = false;
		this.isGem = gem;
	}

}