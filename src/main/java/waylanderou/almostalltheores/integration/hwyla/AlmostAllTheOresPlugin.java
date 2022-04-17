package waylanderou.almostalltheores.integration.hwyla;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import waylanderou.almostalltheores.RefinerTile;
import waylanderou.almostalltheores.block.CustomOre;

@WailaPlugin(id = "almostalltheores:waila_plugin")
public class AlmostAllTheOresPlugin implements IWailaPlugin {

	@Override
	public void register(IRegistrar registrar) {
		registrar.addComponent(BlockInformationProvider.INSTANCE, TooltipPosition.BODY, CustomOre.class);
		registrar.addComponent(RefinerComponentProvider.INSTANCE, TooltipPosition.BODY, RefinerTile.class);
		registrar.addBlockData(RefinerComponentProvider.INSTANCE, RefinerTile.class);
	}

}
