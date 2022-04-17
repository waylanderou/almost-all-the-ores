package waylanderou.almostalltheores;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import waylanderou.almostalltheores.block.Ores;
import waylanderou.almostalltheores.client.TooltipHandler;
import waylanderou.almostalltheores.config.AatoConfig;
import waylanderou.almostalltheores.integration.ModPlugAndPlay;
import waylanderou.almostalltheores.proxy.ClientProxy;
import waylanderou.almostalltheores.proxy.IProxy;
import waylanderou.almostalltheores.proxy.ServerProxy;
import waylanderou.almostalltheores.world.biome.OreGeneration;

@Mod("almostalltheores")
public class AlmostAllTheOres
{    
	public static final String MODID = "almostalltheores";
	public static IProxy proxy = DistExecutor.safeRunForDist(()->ClientProxy::new, ()->ServerProxy::new);

	public AlmostAllTheOres() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, this::oreGeneration);

		FMLJavaModLoadingContext.get().getModEventBus().register(Ores.OresRegistryEvents.class);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AatoConfig.spec);
		ModPlugAndPlay m = new ModPlugAndPlay();
		m.activateOres();
		AatoConfig.loadConfig(m);
	}

	private void oreGeneration(BiomeLoadingEvent event) {
		OreGeneration oreGen = new OreGeneration();
		oreGen.setup(event);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		proxy.init();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {		
		TooltipHandler handler = new TooltipHandler();
		MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, ItemTooltipEvent.class, handler::onToolTip);
	}

}
