package me.Dylan.OITC.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import me.Dylan.OITC.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;

public class GameManager implements Plugin{

	private Main plugin = Main.getInstance();
	
    private World arenaworld, lobbyworld;
	
	private List<UUID> players = new ArrayList<>();
	private List<UUID> spectators = new ArrayList<>();
	private List<Location> arenaSpawns = new ArrayList<>();

	private HashMap<UUID, Integer> kills = new HashMap<>();
	private HashMap<UUID, Integer> points = new HashMap<>();
	private HashMap<UUID, Integer> deaths = new HashMap<>();
	
	public GameManager() {
		plugin.getServer().createWorld(new WorldCreator("Arenaworld"));

		lobbyworld = Bukkit.getWorld("world");
		arenaworld = Bukkit.getWorld("Arenaworld");
		
		GameState.state = GameState.LOBBY;
	}

	public World getArenaWorld() {
	    return arenaworld;
	}
	
	public World getLobbyWorld() {
	    return lobbyworld;
	}
	
	public List<UUID> getPlayers() {
	    return players;
	}
	
	public List<UUID> getSpectators() {
	    return spectators;
	}
	
	public List<Location> getSpawns() {
	    return arenaSpawns;
	}
	
	public HashMap<UUID, Integer> getKills() {
	    return kills;
	}
	
	public HashMap<UUID, Integer> getPoints() {
	    return points;
	}
	
	public HashMap<UUID, Integer> getDeaths() {
	    return deaths;
	}
	
	public void setArenaSpawns(List<Location> list) {
	    this.arenaSpawns = list;
	}
	
	public void getArenaSpawns(List<Location> arenaSpawns) {
		this.arenaSpawns = arenaSpawns;
	}

	public enum GameState {
	    
		LOBBY, STARTED, ENDED;
		
		public static GameState state;
	}
	
	public void startGame() {
		GameState.state = GameState.STARTED;
		
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.setGameMode(GameMode.ADVENTURE);
						Bukkit.broadcastMessage("§cThe game has started! First to 5 kills wins!");
						plugin.getSpawnHandler().teleportToArena();
						
					    UUID uuid = p.getUniqueId();
						players.add(uuid);
						points.put(uuid, 0);
						kills.put(uuid, 0);
						deaths.put(uuid, 0);
						
						PlayerInventory pi = p.getInventory();
						
						ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
						ItemMeta swordm = sword.getItemMeta();
						swordm.setDisplayName("§6[OITC] §cOnly Use This In Emergencies!");
						sword.setItemMeta(swordm);
						
						ItemStack bow = new ItemStack(Material.BOW, 1);
						ItemMeta bowm = bow.getItemMeta();
						bowm.setDisplayName("§6[OITC] §cBow!");
						bow.setItemMeta(bowm);
						
						ItemStack arrow = new ItemStack(Material.ARROW, 1);
						ItemMeta arrowm = arrow.getItemMeta();
						arrowm.setDisplayName("§6[OITC] §cArrow");
						arrow.setItemMeta(arrowm);
						
						pi.setItem(0, sword);
						pi.setItem(1, bow);
						pi.setItem(2, arrow);
						
					}
	}


	public void endGame() {
		GameState.state = GameState.ENDED;

		Player winner = null;

		for (UUID uuids : players) {
			winner = Bukkit.getPlayer(uuids);
			if(players.contains(winner.getUniqueId())){
			Bukkit.broadcastMessage("§cThe game has ended! Winner: " + winner);
			break;
			}
		}

		if (winner != null) {
			plugin.getApi().firework(winner);
		}
		Bukkit.getServer().broadcastMessage("§6[OITC] §cServer restarting in 10 seconds!");
	}
		
	
	
	
	
	
	
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1,
			String arg2, String[] arg3) {
		
		return null;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		
		return false;
	}

	@Override
	public FileConfiguration getConfig() {
		
		return null;
	}

	@Override
	public File getDataFolder() {
		
		return null;
	}

	@Override
	public EbeanServer getDatabase() {
		
		return null;
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		
		return null;
	}

	@Override
	public PluginDescriptionFile getDescription() {
		
		return null;
	}

	@Override
	public Logger getLogger() {
		
		return null;
	}

	@Override
	public String getName() {
		
		return null;
	}

	@Override
	public PluginLoader getPluginLoader() {
		
		return null;
	}

	@Override
	public InputStream getResource(String arg0) {
		
		return null;
	}

	@Override
	public Server getServer() {
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		
		return false;
	}

	@Override
	public boolean isNaggable() {
		
		return false;
	}

	@Override
	public void onDisable() {
		
		
	}

	@Override
	public void onEnable() {
		
		
	}

	@Override
	public void onLoad() {
		
		
	}

	@Override
	public void reloadConfig() {
		
		
	}

	@Override
	public void saveConfig() {
		
		
	}

	@Override
	public void saveDefaultConfig() {
		
		
	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		
		
	}

	@Override
	public void setNaggable(boolean arg0) {
		
		
	}

}