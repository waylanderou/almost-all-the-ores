package waylanderou.almostalltheores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import waylanderou.almostalltheores.client.TooltipHandler;
import waylanderou.almostalltheores.proxy.ClientProxy;
import waylanderou.almostalltheores.proxy.IProxy;
import waylanderou.almostalltheores.proxy.ServerProxy;

@Mod("almostalltheores")
public class AlmostAllTheOres
{    
	public static final String MODID = "almostalltheores";
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	private static final Logger LOGGER = LogManager.getLogger();

	public AlmostAllTheOres() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOWEST, this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AatoConfig.spec);

		if(ModList.get().isLoaded("tconstruct")) {
			AatoConfig.enableTinkersDefaultMaterials();     	        	
		}
		if(ModList.get().isLoaded("toolsforaatogems")) {
			AatoConfig.enableToolsforaatogemsMaterials();       	
		}
		if(ModList.get().isLoaded("extragems")) {
			AatoConfig.enableExtraGemsMaterials();
		}
		AatoConfig.loadConfig();


	}

	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setup(); 
		proxy.init();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		LOGGER.info("Alpha version: might contain bugs.");
		TooltipHandler handler = new TooltipHandler();
		IEventBus eventbus = MinecraftForge.EVENT_BUS;
		eventbus.addListener(EventPriority.NORMAL, false, ItemTooltipEvent.class, handler::onToolTip);
	}	

	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			// register a new block here
			//LOGGER.info("HELLO from Register Block");
		}
	}
}
