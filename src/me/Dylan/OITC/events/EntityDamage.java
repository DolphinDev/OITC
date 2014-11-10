package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (plugin.getGameManager().getSpectators().contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}
}