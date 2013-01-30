package com.gmail.mozvat.plugins.testplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TestPluginCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player)sender;
	try{
			
		if(commandLabel.equalsIgnoreCase("test")){
			sender.sendMessage("You just sent me a command");
			return true;
		} else if(commandLabel.equalsIgnoreCase("smite")){
			Block targetblock = player.getTargetBlock(null, 100);
            Location location = targetblock.getLocation();
			player.getWorld().strikeLightning(location);
			player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has called forth lightning !");					
			return true;
		} 	else if( commandLabel.equalsIgnoreCase("dragon")){
			Block targetblock = player.getTargetBlock(null, 100);
            Location location = targetblock.getLocation();
			player.getWorld().strikeLightningEffect(location);
			player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has summoned Smaug!");					
			player.getWorld().spawnEntity(location, EntityType.ENDER_DRAGON);
			return true;
		}  	else if( commandLabel.equalsIgnoreCase("kd")){
			List dragons = new ArrayList<EnderDragon>(player.getWorld().getEntitiesByClass(EnderDragon.class));
			player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has killed Smaug!");					
			EnderDragon mob = (EnderDragon)dragons.get(0);
			mob.setHealth(0);
			return true;
		}
	  }catch (Exception e){
          e.printStackTrace();
      }
		return false;
	}

}
 