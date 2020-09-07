package io.github.pirgosth.worldchatprefix;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import net.md_5.bungee.api.ChatColor;

public class Config {
	
	private FileConfiguration config = null;
	private Map<String, String> worldPrefixes = null;
	
	public Config() {
		this.config = WorldChatPrefix.getInstance().getConfig();
		WorldChatPrefix.getInstance().saveDefaultConfig();
	}
	
	public void loadPrefixes() {
		this.worldPrefixes = new HashMap<>();
		ConfigurationSection section = this.config.getConfigurationSection("worlds");
		if(section == null) {
			this.config.createSection("worlds");
			return;
		}
		for(String world: section.getKeys(false)) {
			this.worldPrefixes.put(world, this.config.getString("worlds." + world + ".prefix", ""));
		}
	}
	
	public void reload() {
		WorldChatPrefix.getInstance().saveDefaultConfig();
		WorldChatPrefix.getInstance().reloadConfig();
		this.config = WorldChatPrefix.getInstance().getConfig();
		this.loadPrefixes();
	}
	
	public String getWorldPrefix(String worldName) {
		String prefix = this.worldPrefixes.get(worldName);
		return prefix == null ? "" : ChatColor.translateAlternateColorCodes('&', prefix);
	}
	
}
