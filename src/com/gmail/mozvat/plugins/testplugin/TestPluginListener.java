package com.gmail.mozvat.plugins.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TestPluginListener implements Listener {
	
	//Event handler can set the priority.
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player p = event.getPlayer();
		Block bp = event.getBlockPlaced(); 
		p.sendMessage("You placed a " + bp.getType().toString());
	}
	
	//Event handler can set the priority.
	@EventHandler
	public void onTalk(AsyncPlayerChatEvent event ){
		
		if(event.getMessage().equalsIgnoreCase("hello server")){
		Player p = event.getPlayer(); 
		p.sendMessage("Hello Dave");
		
		Block targetblock = p.getTargetBlock(null, 100);
        Location location = targetblock.getLocation();
        p.getWorld().strikeLightningEffect(location);
        p.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " has summoned Smaug!");					
		p.getWorld().spawnEntity(location, EntityType.ENDER_DRAGON);
		
		
		} else if (event.getMessage().equalsIgnoreCase("cb")){
			Player p = event.getPlayer(); 
			p.sendMessage("Block Change event");		
		}
		
	}
}
