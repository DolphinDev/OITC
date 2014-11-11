package me.Dylan.OITC.utils;

import java.util.ArrayList;
import java.util.List;

import me.Dylan.OITC.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnHandler {

	
	private Main plugin = Main.getInstance();

	public void teleportToArena() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			World Arenaworld = Bukkit.getServer().getWorld("Arenaworld");
			double x = 72;
            double y = 41;
            double z = 22;
            p.teleport(new Location(Arenaworld, x, y, z));
		}
	}


	public void loadSpawns(String arenaName) {
	    FileConfiguration config = plugin.getConfig();
		
		List<Location> temp = new ArrayList<>();

		int amount = config.getInt("Spawns." + arenaName + ".amount");

		World world = Bukkit.getWorld(config.getString("Spawns." + arenaName + ".world"));

		for (int i = 1; i <= amount; i++) {
			double x = config.getDouble("Spawns." + arenaName + "." + i + ".x");
			double y = config.getDouble("Spawns." + arenaName + "." + i + ".y");
			double z = config.getDouble("Spawns." + arenaName + "." + i + ".z");

			temp.add(new Location(world, x, y, z));
		}

		plugin.getGameManager().getArenaSpawns(temp);
	}

	public void setSpawn(Player p, String arenaName) {
	    FileConfiguration config = plugin.getConfig();
	
		int amount = config.getInt("Spawns." + arenaName + ".amount");

		int next = amount + 1;

		String world = p.getWorld().getName();

		config.set("Spawns." + arenaName + "amount", next);
		config.set("Spawns." + arenaName + "." + next + ".world", world);

		Location loc = p.getLocation();

		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();

		config.set("Spawns." + arenaName + "." + next + ".x", x);
		config.set("Spawns." + arenaName + "." + next + ".y", y);
		config.set("Spawns." + arenaName + "." + next + ".z", z);

		plugin.saveConfig();
	}
}