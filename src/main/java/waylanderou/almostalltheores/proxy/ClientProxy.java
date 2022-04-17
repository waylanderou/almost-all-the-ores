package waylanderou.almostalltheores.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import waylanderou.almostalltheores.RefinerRegistryEvents;
import waylanderou.almostalltheores.client.RefinerScreen;

@SuppressWarnings("resource")
public class ClientProxy implements IProxy {

	public ClientProxy() {		
	}

	@Override
	public void init() {
		MenuScreens.register(RefinerRegistryEvents.REFINER_CONTAINER, RefinerScreen::new);
	}

	
	@Override
	public Level getClientWorld() {	
		return Minecraft.getInstance().level;
	}

	@Override
	public Player getClientPlayer() {		
		return Minecraft.getInstance().player;
	}

	@Override
	public boolean isClient() {
		return true;
	}

}
