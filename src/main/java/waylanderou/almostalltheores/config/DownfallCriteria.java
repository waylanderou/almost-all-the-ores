package waylanderou.almostalltheores.config;

public class DownfallCriteria {
	private float criteria;
	private boolean greaterThan;

	public DownfallCriteria(float downfall, boolean needsToBeGreater) {
		this.criteria = downfall;
		this.greaterThan = needsToBeGreater;
	}

	public boolean test(float f) {
		if(greaterThan) {
			if(criteria < f)
				return true;
			else
				return false;
		} else {
			if(criteria > f)
				return true;
			else
				return false;
		}
	}

}
