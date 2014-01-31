package me.cloud9;

import net.md_5.bungee.api.plugin.Plugin;
import me.cloud9.CommandServerlist;

public class PluginServerlist extends Plugin
{
	public void onEnable ()
	{
		getProxy().getPluginManager().registerCommand(this, new CommandServerlist());
	}
}