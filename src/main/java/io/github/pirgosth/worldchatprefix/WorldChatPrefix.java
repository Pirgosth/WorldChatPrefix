package io.github.pirgosth.worldchatprefix;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public class WorldChatPrefix extends JavaPlugin{
	@Getter
	private static JavaPlugin instance = null;
	
	@Getter
	private static Config mainConfig = null;
	
	@Override
	public void onEnable() {
		instance = this;
		mainConfig = new Config();
		mainConfig.loadPrefixes();
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		this.getCommand("wcp").setExecutor(new Commands());
		this.getCommand("wcp").setTabCompleter(new AutoCompletion());
	}
}
