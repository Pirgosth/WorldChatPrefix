package io.github.pirgosth.worldchatprefix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{

	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	private void onPlayerChat(AsyncPlayerChatEvent event){
		event.setFormat(WorldChatPrefix.getMainConfig().getWorldPrefix(event.getPlayer().getWorld().getName()) + event.getFormat());
	}
	
}
