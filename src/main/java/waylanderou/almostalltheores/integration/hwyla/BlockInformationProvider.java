package waylanderou.almostalltheores.integration.hwyla;

import java.util.List;

import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import net.minecraft.network.chat.Component;
import waylanderou.almostalltheores.client.TooltipHandler;

public class BlockInformationProvider implements IBlockComponentProvider {

	static final BlockInformationProvider INSTANCE = new BlockInformationProvider();
	TooltipHandler handler = new TooltipHandler();

	@Override
	public void appendBody(List<Component> tooltip, IBlockAccessor accessor, IPluginConfig config) {		
		if(!accessor.getBlock().getRegistryName().toString().contains("almostalltheores")) { 
			return;
		} 
		String name = accessor.getBlock().getRegistryName().toString().split(":")[1];
		handler.addTooltips(name, tooltip);

	}

}
