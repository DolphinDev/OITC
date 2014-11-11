package me.Dylan.OITC.commands;

import me.Dylan.OITC.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Start implements CommandExecutor {

	private Main plugin = Main.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {

		if (!sender.hasPermission("game.start")) {
			sender.sendMessage("§cNo permission!");
			return false;
		}

		plugin.getGameManager().startGame();
		return false;
	}
}