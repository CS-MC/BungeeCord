package me.cloud9;

import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandServerlist
  extends Command
{
  public CommandServerlist()
  {
    super("serverlist", "bungeecord.command.serverlist", new String[0]);
  }
  
  @SuppressWarnings("deprecation")
public void execute(CommandSender sender, String[] args)
  {
    if (!(sender instanceof ProxiedPlayer)) {
      return;
    }
    ProxiedPlayer player = (ProxiedPlayer)sender;
    Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
    if (args.length == 0)
    { 
      StringBuilder serverList = new StringBuilder();
      for (ServerInfo server : servers.values()) {
        if (server.canAccess(player))
        {
          serverList.append(server.getName());
          serverList.append(", ");
        }
      }
      if (serverList.length() != 0) {
        serverList.setLength(serverList.length() - 2);
      }
      player.sendMessage(ChatColor.AQUA + "Current servers: " + ChatColor.GOLD + serverList.toString());
    }
  }

  

}
