package me.Dylan.OITC;

import me.Dylan.OITC.commands.SetSpawn;
import me.Dylan.OITC.commands.Start;
import me.Dylan.OITC.events.EntityDamage;
import me.Dylan.OITC.events.EntityDamageByEntity;
import me.Dylan.OITC.events.EntityDeath;
import me.Dylan.OITC.events.PlayerDeath;
import me.Dylan.OITC.events.PlayerDropItem;
import me.Dylan.OITC.events.PlayerJoin;
import me.Dylan.OITC.events.PlayerPickupItem;
import me.Dylan.OITC.events.PlayerQuit;
import me.Dylan.OITC.utils.GameManager;
import me.Dylan.OITC.utils.SpawnHandler;
import me.Dylan.OITC.utils.GameManager.GameState;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	private API api;
	private GameManager gm;
	private SpawnHandler spawnHandler;
	public SpawnHandler getArenaSpawns;
	public int totalAlive;
	
	private static Main plugin;

	public void onEnable() {
		GameState.state = GameState.LOBBY;
	    plugin = this;
		
		api = new API();
		gm = new GameManager();
		spawnHandler = new SpawnHandler();
		
        registerEvents();
        registerCommands();
	}
	
	public static Main getInstance() {
	    return plugin;
	}
	
	public API getApi() {
	    return api;
	}
	
	public GameManager getGameManager() {
	    return gm;
	}
	
	public SpawnHandler getSpawnHandler() {
	    return spawnHandler;
	}
	
	private void registerEvents() {
	    PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new EntityDamageByEntity(), this);
		pm.registerEvents(new EntityDeath(), this);
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new PlayerDropItem(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerPickupItem(), this);
		pm.registerEvents(new PlayerQuit(), this);
	}
	
	private void registerCommands() {
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("start").setExecutor(new Start());	
	}
}