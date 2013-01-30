package com.gmail.mozvat.plugins.testplugin;

//regular java.util for a random number
import java.util.Random;
//You apparently need to reference the library craftbukkit.jar. (this assembly comes with the bukkit server) and 
//allows you to reference the net.minecraft.server.v* import below.
//This import within net.server.minecraft.server.v* allows us access the Block class. 
import net.minecraft.server.v1_4_6.Block;

//Here we are defining the child class where we are using inheritance extending the 'Block' class.
//Check out this link to discuss 'inheritance' http://www.javacoffeebreak.com/java104/java104.html
//If this is too overwhelming initially, don't worry we can talk about it over voice.
public class UberBlock extends Block
{
	//Constructor for our child class we custom defiend as 'UberBlock'
	 public UberBlock(int i, int j)
	 {
		 //Calls the Parent class of Block and passes the required parameters (I don't know what all the parameters do yet)
		 super(i, j, net.minecraft.server.v1_4_6.Material.CLAY);
	 
	 }
	
	 //Just demonstrating some new method
	 public int quantityDropped(Random random)
	 {
		 return 2 + random.nextInt(3);
	 }
}