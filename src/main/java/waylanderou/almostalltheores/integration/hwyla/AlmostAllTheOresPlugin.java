package waylanderou.almostalltheores.integration.hwyla;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import waylanderou.almostalltheores.block.CustomOre;

@WailaPlugin
public class AlmostAllTheOresPlugin implements IWailaPlugin {

	public AlmostAllTheOresPlugin() {}

	@Override
	public void register(IRegistrar registrar) {
		registrar.registerComponentProvider(BlockInformationProvider.INSTANCE, TooltipPosition.BODY, CustomOre.class);
	}

}
