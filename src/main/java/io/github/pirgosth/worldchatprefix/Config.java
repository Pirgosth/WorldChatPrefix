package io.github.pirgosth.worldchatprefix;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Config {
	
	private FileConfiguration config = null;

	//Key is the group name, Value is information to display in chat for given worlds
	private Map<String, GroupInfo> worldPrefixes = null;
	
	public Config() {
		this.config = WorldChatPrefix.getInstance().getConfig();
		WorldChatPrefix.getInstance().saveDefaultConfig();
	}
	
	public void loadPrefixes() {
		this.worldPrefixes = new HashMap<>();
		ConfigurationSection section = this.config.getConfigurationSection("groups");
		if(section == null) {
			this.config.createSection("groups");
			return;
		}
		for(String group: section.getKeys(false)) {
			this.worldPrefixes.put(group, new GroupInfo(this.config.getStringList("groups." + group + ".worlds"), this.config.getString("groups." + group + ".prefix", "")));
		}
	}
	
	public void reload() {
		WorldChatPrefix.getInstance().saveDefaultConfig();
		WorldChatPrefix.getInstance().reloadConfig();
		this.config = WorldChatPrefix.getInstance().getConfig();
		this.loadPrefixes();
	}
	
	public String getWorldPrefix(String worldName) {
		String prefix = null;
		for(GroupInfo group : this.worldPrefixes.values()){
			if(group.worlds.contains(worldName)){
				prefix = group.prefix;
			}
		}
		return prefix == null ? "" : ChatColor.translateAlternateColorCodes('&', prefix);
	}
	
}
