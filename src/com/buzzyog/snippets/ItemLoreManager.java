package com.buzzyog.snippets;
 
import java.util.Arrays;
 
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
 
public class ItemLoreManager {
 
  public ItemLoreManager(){
		
	}
	
	public ItemStack createLore(ItemStack base , String[] lore , String display){
		ItemMeta meta = base.getItemMeta();
			meta.setDisplayName(display);
			meta.setLore(Arrays.asList(lore));
		base.setItemMeta(meta);
		return base;
	}
	
	public boolean contains(Player player , ItemStack stack){
		PlayerInventory inv = player.getInventory();
		inv.containsAtLeast(stack, stack.getAmount());
		for(ItemStack str : inv.getContents()){
			if(str.getType() == stack.getType()){
				if(str.getItemMeta().getDisplayName() == stack.getItemMeta().getDisplayName()){
					if(Arrays.equals(str.getItemMeta().getLore().toArray(), stack.getItemMeta().getLore().toArray())){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean remove(Player player , ItemStack stack){
		PlayerInventory inv = player.getInventory();
		inv.containsAtLeast(stack, stack.getAmount());
		for(ItemStack str : inv.getContents()){
			if(str.getType() == stack.getType()){
				if(str.getItemMeta().getDisplayName() == stack.getItemMeta().getDisplayName()){
					if(Arrays.equals(str.getItemMeta().getLore().toArray(), stack.getItemMeta().getLore().toArray())){
						inv.remove(stack);
						return true;
					}
				}
			}
		}
		return false;
	}
	
}