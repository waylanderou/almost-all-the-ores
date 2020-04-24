package waylanderou.almostalltheores.integration.hwyla;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.util.ResourceLocation;
import waylanderou.almostalltheores.AlmostAllTheOres;
import waylanderou.almostalltheores.RefinerTile;
import waylanderou.almostalltheores.block.CustomOre;

@WailaPlugin
public class AlmostAllTheOresPlugin implements IWailaPlugin {

	static final ResourceLocation RENDER_REFINER_PROGRESS = new ResourceLocation("refiner_progress");
	static final ResourceLocation RENDER_ITEM_CUSTOM = new ResourceLocation("item_c");
	static final ResourceLocation RENDER_SPACER = new ResourceLocation("spacer");

	@Override
	public void register(IRegistrar registrar) {
		registrar.registerComponentProvider(BlockInformationProvider.INSTANCE, TooltipPosition.BODY, CustomOre.class);		
		registrar.registerTooltipRenderer(RENDER_REFINER_PROGRESS, new RefinerTooltipProgressBarRenderer());
		if(AlmostAllTheOres.proxy.isClient())
			registrar.registerTooltipRenderer(RENDER_ITEM_CUSTOM, new ItemStackTooltipRenderer());
		registrar.registerComponentProvider(RefinerComponentProvider.INSTANCE, TooltipPosition.BODY, RefinerTile.class);
		registrar.registerBlockDataProvider(RefinerComponentProvider.INSTANCE, RefinerTile.class);
	}

}
