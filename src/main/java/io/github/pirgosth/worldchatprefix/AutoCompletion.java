package io.github.pirgosth.worldchatprefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class AutoCompletion implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> completions = new ArrayList<>();
		if(args.length == 1) {
			StringUtil.copyPartialMatches(args[0], Arrays.asList("reload"), completions);
		}
		return completions;
	}

}
