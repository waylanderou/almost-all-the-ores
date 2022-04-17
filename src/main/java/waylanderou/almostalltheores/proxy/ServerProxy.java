package waylanderou.almostalltheores.proxy;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ServerProxy implements IProxy {

	public ServerProxy() {
	}

	@Override
	public void init() {
	}

	@Override
	public Level getClientWorld() {
		throw new IllegalStateException("Trying to call getClientWorld on server...");
	}

	@Override
	public Player getClientPlayer() {
		throw new IllegalStateException("Trying to call getClientPlayer on server...");
	}

	@Override
	public boolean isClient() {
		return false;
	}

}
