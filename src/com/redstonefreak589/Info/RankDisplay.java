package com.redstonefreak589.Info;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class RankDisplay extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static RankDisplay plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled!");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("rank")){
			if(args.length == 0){ //If no strings are given then we send a help box
				player.sendMessage(ChatColor.BLUE + "---RankInfo Help Page---");
				player.sendMessage(ChatColor.AQUA + "Usage: /rank <rank name>");
				player.sendMessage(ChatColor.AQUA + "Available rank names:");
				player.sendMessage(ChatColor.DARK_BLUE + "1, 2, 3, 4, Manager");
			}else if(args.length == 1){
				if(args[0] == "1"){
					player.sendMessage(ChatColor.AQUA + "Rank name: Level 1");
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
				}else if (args[0] == "2"){
					player.sendMessage(ChatColor.AQUA + "Rank name: Level 2");
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
				}else if (args[0] == "3"){
					player.sendMessage(ChatColor.AQUA + "Rank name: Level 3");
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
				}else if (args[0] == "4"){
					player.sendMessage(ChatColor.AQUA + "Rank name: Level 4");
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
				}else if (args[0] == "Manager" || args[0] == "manager"){
					player.sendMessage(ChatColor.AQUA + "Rank name: Manager");
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
				}else{
					player.sendMessage(ChatColor.AQUA + "Usage: /rank <rank name>");
					player.sendMessage(ChatColor.AQUA + "Available rank names:");
					player.sendMessage(ChatColor.DARK_BLUE + "1, 2, 3, 4, Manager");
				}
			}
		}
		return false;
	}
	
	
	
}
