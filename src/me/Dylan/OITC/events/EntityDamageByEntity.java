package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (e.getEntity() instanceof LivingEntity) {
				if (plugin.getGameManager().getSpectators().contains(p.getUniqueId())) {
					e.setCancelled(true);
				}
			}
		}
	}
}