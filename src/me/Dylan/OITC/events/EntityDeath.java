package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;
import me.Dylan.OITC.utils.GameManager.GameState;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EntityDeath implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player victim = (Player) e.getEntity();
			if (victim.getKiller() instanceof Player) {
				Player killer = (Player) victim.getKiller();
				
				ItemStack arrow = new ItemStack(Material.ARROW, 1);
				ItemMeta arrowm = arrow.getItemMeta();
				arrowm.setDisplayName("§6[OITC] §cArrow");
				arrow.setItemMeta(arrowm);
				
				killer.getInventory().addItem(arrow);
				killer.sendMessage("§6[OITC] §cYou killed: §b" + victim.getName());
				victim.sendMessage("§6[OITC] §cYou were killed by: §b" + killer.getName());

				plugin.getApi().addDeaths(victim, 1);
				plugin.getApi().addKills(killer, 1);
				plugin.getApi().addPoints(killer, 5);

				if (GameState.state != GameState.ENDED) {
					if (plugin.getApi().getKills(killer) >= 5) {
						plugin.getGameManager().endGame();
					}
				}
			} 
		}
	}
}