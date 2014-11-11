package me.Dylan.OITC.commands;

import me.Dylan.OITC.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

	private Main plugin = Main.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("�cOnly ingame players can use this command!");
			return false;
		}	
	
		if (!sender.hasPermission("game.spawn")) {
			sender.sendMessage("�cNo permission!");
			return false;
		}

		if (a.length < 1) {
			sender.sendMessage("�c/setspawn <arenaname>");
		} else if (a.length == 1) {
			plugin.getSpawnHandler().setSpawn((Player) sender, a[0]);
		}

		return false;
	}
}