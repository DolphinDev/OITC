package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;
import me.Dylan.OITC.utils.GameManager.GameState;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		if (GameState.state == GameState.STARTED) {
			if (plugin.getGameManager().getPlayers().contains(p.getUniqueId())) {
				plugin.getApi().addDeaths(p, 1);
				plugin.getGameManager().getPlayers().remove(p.getUniqueId());
			}
		}

		if (plugin.totalAlive <= 2) {
			if (GameState.state != GameState.ENDED) {
				plugin.getGameManager().endGame();
			}
		}
	}
}