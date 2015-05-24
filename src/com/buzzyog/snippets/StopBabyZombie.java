package com.buzzyog.snippets;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class StopBabyZombie {
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
	    //check if the creature spawned is a zombie.
	    if (event.getEntity().getType() == EntityType.ZOMBIE) {
	        //create a variable to store the zombie.
	        Zombie zombie = (Zombie) event.getEntity();

	        //check if the zombie is a baby.
	        if(zombie.isBaby()) {
	            //don't spawn it.
	            event.setCancelled(true);
	        }

	        //check if the zombie is a baby.
	        if (zombie.isBaby()) {
	            //make the zombie an adult.
	            zombie.setBaby(false);
	        }
	    }
	}

}
