package io.github.pirgosth.worldchatprefix;

import io.github.pirgosth.liberty.core.api.commands.ICommandListener;
import io.github.pirgosth.liberty.core.api.commands.annotations.LibertyCommand;
import io.github.pirgosth.liberty.core.api.commands.annotations.LibertyCommandPermission;
import io.github.pirgosth.liberty.core.api.utils.ChatUtils;
import io.github.pirgosth.liberty.core.commands.CommandParameters;

public class Commands implements ICommandListener {

	@LibertyCommand(command = "wcp.reload")
	@LibertyCommandPermission(permission = "worldchatprefix.commands.reload")
	public boolean reloadCommand(CommandParameters params) {
		WorldChatPrefix.getMainConfig().reload();
		ChatUtils.sendColorMessage(params.sender, "&7[&aWorldChatPrefix&7] reloaded successfully !");
		return true;
	}

}
