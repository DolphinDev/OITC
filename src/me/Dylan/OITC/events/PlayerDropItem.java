package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


public class PlayerDropItem implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (plugin.getGameManager().getSpectators().contains(e.getPlayer().getUniqueId()))
			e.setCancelled(true);
	}
}