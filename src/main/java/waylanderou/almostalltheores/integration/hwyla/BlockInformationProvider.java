package waylanderou.almostalltheores.integration.hwyla;

import java.util.List;

import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import net.minecraft.util.text.ITextComponent;
import waylanderou.almostalltheores.client.TooltipHandler;

public class BlockInformationProvider implements IComponentProvider {

	static final BlockInformationProvider INSTANCE = new BlockInformationProvider();

	@Override
	public void appendBody(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {		
		if(!accessor.getBlock().getTranslationKey().contains("almostalltheores")) { //|| !tooltip.isEmpty() doesn't change anything
			return;
		} 
		String name = accessor.getBlock().getRegistryName().toString().split(":")[1];
		new TooltipHandler().addTooltips(name, tooltip);		

	}

}
