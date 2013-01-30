package com.gmail.mozvat.plugins.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin{

	//onEnable is called when the plugin is enabled on a server
	@Override
	public void onEnable(){
		//this writes to the server start window declaring the Plugin is enabled 
		pluginInfo("Enabled!");
		getLogger().info("onEnable has been invoked!");
		
		getCommand("test").setExecutor(new TestPluginCommands());
		getCommand("smite").setExecutor(new TestPluginCommands());
		getCommand("dragon").setExecutor(new TestPluginCommands());
		getCommand("kd").setExecutor(new TestPluginCommands());
		//Declare the event
		TestPluginListener tpl = new TestPluginListener();
		//Hooks up the event 
		getServer().getPluginManager().registerEvents(tpl, this);
	}
	
	@Override
	public void onDisable(){
		pluginInfo("Disabled!");
		getLogger().info("onDisable has been invoked!");
	}
	
	public static void pluginInfo(String message){
		String v ="1.0";
		System.out.println("Test Plugin " + v + " " + message);
	}	
}
