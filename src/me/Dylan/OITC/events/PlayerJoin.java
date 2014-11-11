package me.Dylan.OITC.events;

import me.Dylan.OITC.Main;
import me.Dylan.OITC.utils.GameManager.GameState;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	private Main plugin = Main.getInstance();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		if (GameState.state == GameState.LOBBY) {
			e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 1, 1, 1));
			plugin.getSpawnHandler();
			if(Bukkit.getOnlinePlayers().length > 0 && Bukkit.getOnlinePlayers().length < 2){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b1 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 1 && Bukkit.getOnlinePlayers().length < 3){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b2 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 2 && Bukkit.getOnlinePlayers().length < 4){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b3 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 3 && Bukkit.getOnlinePlayers().length < 5){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b4 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 4 && Bukkit.getOnlinePlayers().length < 6){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b5 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 5 && Bukkit.getOnlinePlayers().length < 7){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b6 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 6 && Bukkit.getOnlinePlayers().length < 8){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b7 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 7 && Bukkit.getOnlinePlayers().length < 9){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b8 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 8 && Bukkit.getOnlinePlayers().length < 10){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b9 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 9 && Bukkit.getOnlinePlayers().length < 11){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b10 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length > 10 && Bukkit.getOnlinePlayers().length < 12){
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b11 §d/ §b12§d)");
			}
			if(Bukkit.getOnlinePlayers().length >= 12) {
				Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + " §e§njoined §e the game! §d(§b12 §d/ §b12§d)");
				plugin.getGameManager().startGame();
				
			}
		}
	}
}
