package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();

		plugin.getApi().addDeaths(p, 1);

		if (plugin.getApi().getDeaths(p) == 5) {
			plugin.getApi().setSpectator(p);
		}
		
		p.setHealth(20D);
		p.teleport(plugin.getGameManager().getSpawns().get(1));
	}
}