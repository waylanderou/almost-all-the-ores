package waylanderou.almostalltheores.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import waylanderou.almostalltheores.RefinerRegistryEvents;
import waylanderou.almostalltheores.client.RefinerScreen;

public class ClientProxy implements IProxy {

	public ClientProxy() {		
	}

	@Override
	public void init() {
		ScreenManager.registerFactory(RefinerRegistryEvents.REFINER_CONTAINER, RefinerScreen::new);
	}

	@Override
	public World getClientWorld() {		
		return Minecraft.getInstance().world;
	}

	@Override
	public PlayerEntity getClientPlayer() {		
		return Minecraft.getInstance().player;
	}

	@Override
	public boolean isClient() {		
		return true;
	}

}
