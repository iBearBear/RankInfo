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
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("rankinfo") || commandLabel.equalsIgnoreCase("ri") || commandLabel.equalsIgnoreCase("rank")){ //If the player used the base command or its aliases
			if(args.length == 0){ //If no strings are given then we send a help box to the player
				player.sendMessage(ChatColor.BLUE + "---RankInfo Help Page---");
				player.sendMessage(ChatColor.AQUA + "Usage: /rank <rank name>");
				player.sendMessage(ChatColor.AQUA + "Use r1, r2, r3, r4, or r5 for selecting each rank.");
				player.sendMessage(ChatColor.AQUA + "Available rank names:");
				player.sendMessage(ChatColor.DARK_BLUE + getConfig().getString("Rank1.Name") + ", " + getConfig().getString("Rank2.Name") + ", "
						+ getConfig().getString("Rank3.Name") + ", " + getConfig().getString("Rank3.Name") 
						+ ", " + getConfig().getString("Rank5.Name"));
			
			}else if(args.length == 1){ // If the player sent 1 argument
				 if(args[0].toString().equalsIgnoreCase("r1")){
					player.sendMessage(ChatColor.AQUA + "Rank name: " + getConfig().getString("Rank1.Name"));
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
					player.sendMessage(ChatColor.GOLD + getConfig().getString("Rank1.Description"));
				}else if(args[0].toString().equalsIgnoreCase("r2")){
					player.sendMessage(ChatColor.AQUA + "Rank name: " + getConfig().getString("Rank2.Name"));
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
					player.sendMessage(ChatColor.GOLD + getConfig().getString("Rank2.Description"));
				}else if(args[0].toString().equalsIgnoreCase("r3")){
					player.sendMessage(ChatColor.AQUA + "Rank name: " + getConfig().getString("Rank3.Name"));
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
					player.sendMessage(ChatColor.GOLD + getConfig().getString("Rank3.Description"));
				}else if(args[0].toString().equalsIgnoreCase("r4")){
					player.sendMessage(ChatColor.AQUA + "Rank name: " + getConfig().getString("Rank4.Name"));
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
					player.sendMessage(ChatColor.GOLD + getConfig().getString("Rank4.Description"));
				}else if(args[0].toString().equalsIgnoreCase("r5")){
					player.sendMessage(ChatColor.AQUA + "Rank name: " + getConfig().getString("Rank5.Name"));
					player.sendMessage(ChatColor.AQUA + "Rank Permissions/Abilities:");
					player.sendMessage(ChatColor.GOLD + getConfig().getString("Rank5.Description"));
				}else{
					player.sendMessage(ChatColor.BLUE + "---You sent an incorrect string---");
					player.sendMessage(ChatColor.RED + "Incorrect String: " + args[0]);
					player.sendMessage(ChatColor.AQUA + "Usage: /rank <rank name>");
					player.sendMessage(ChatColor.AQUA + "Use 1, 2, 3, 4, or 5 for selecting each rank.");
					player.sendMessage(ChatColor.AQUA + "Available rank names:");
					player.sendMessage(ChatColor.DARK_BLUE + getConfig().getString("Rank1.Name") + ", " + getConfig().getString("Rank2.Name") + ", "
							+ getConfig().getString("Rank3.Name") + ", " + getConfig().getString("Rank3.Name") 
							+ ", " + getConfig().getString("Rank5.Name"));
				}
			}else if(args.length > 1){ // If the player passed too many arguments
				player.sendMessage(ChatColor.BLUE + "---You passed too many strings---");
				player.sendMessage(ChatColor.AQUA + "Usage: /rank <rank name>");
				player.sendMessage(ChatColor.AQUA + "Use 1, 2, 3, 4, or 5 for selecting each rank.");
				player.sendMessage(ChatColor.AQUA + "Available rank names:");
				player.sendMessage(ChatColor.DARK_BLUE + getConfig().getString("Rank1.Name") + ", " + getConfig().getString("Rank2.Name") + ", "
						+ getConfig().getString("Rank3.Name") + ", " + getConfig().getString("Rank3.Name") 
						+ ", " + getConfig().getString("Rank5.Name"));
			}
		}
		return false;
	}
}
