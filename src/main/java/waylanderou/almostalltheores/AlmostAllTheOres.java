package waylanderou.almostalltheores;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("almostalltheores")
public class AlmostAllTheOres
{    
    public static final String MODID = "almostalltheores";

    public AlmostAllTheOres() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOWEST, this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);        
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);
        Config.loadConfig(Config.spec, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
        
        MinecraftForge.EVENT_BUS.register(this);                
    }

    private void setup(final FMLCommonSetupEvent event) {    	
    	OreGeneration.setup();        
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
    	DistExecutor.runWhenOn(Dist.CLIENT, ()->()->{
        	TooltipHandler handler = new TooltipHandler();
        	IEventBus eventbus = MinecraftForge.EVENT_BUS;
        	eventbus.addListener(EventPriority.NORMAL, false, ItemTooltipEvent.class, handler::onToolTip);
        });    	
    }  
    
}
