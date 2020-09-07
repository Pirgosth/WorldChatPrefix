package io.github.pirgosth.worldchatprefix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length != 1) {
			return false;
		}
		
		if(args[0].equalsIgnoreCase("reload")) {
			WorldChatPrefix.getMainConfig().reload();
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&aWorldChatPrefix&7] reloaded successfully !"));
			return true;
		}
		
		return false;
	}

}
