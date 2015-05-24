package com.buzzyog.snippets;
import org.bukkit.Material;
 
public class ItemType {
	public static boolean isArmor(Material m){
		return isArmorHelmet(m)|isArmorChestplate(m)|isArmorLeggins(m)|isArmorBoots(m);
	}
	public static boolean isArmorHelmet(Material m){
		switch(m){
		case DIAMOND_HELMET: return true;
		case GOLD_HELMET: return true;
		case IRON_HELMET: return true;
		case CHAINMAIL_HELMET: return true;
		case LEATHER_HELMET: return true;
		default: return false;
		}
	}
	public static boolean isArmorChestplate(Material m){
		switch(m){
		case DIAMOND_CHESTPLATE: return true;
		case GOLD_CHESTPLATE: return true;
		case IRON_CHESTPLATE: return true;
		case CHAINMAIL_CHESTPLATE: return true;
		case LEATHER_CHESTPLATE: return true;
		default: return false;
		}
	}
	public static boolean isArmorLeggins(Material m){
		switch(m){
		case DIAMOND_LEGGINGS: return true;
		case GOLD_LEGGINGS: return true;
		case IRON_LEGGINGS: return true;
		case CHAINMAIL_LEGGINGS: return true;
		case LEATHER_LEGGINGS: return true;
		default: return false;
		}
	}
	public static boolean isArmorBoots(Material m){
		switch(m){
		case DIAMOND_BOOTS: return true;
		case GOLD_BOOTS: return true;
		case IRON_BOOTS: return true;
		case CHAINMAIL_BOOTS: return true;
		case LEATHER_BOOTS: return true;
		default: return false;
		}
	}
	public static boolean isTool(Material m){
		return isToolSword(m)|isToolAxe(m)|isToolPickAxe(m)|isToolSpade(m)|isToolHoe(m)|isToolAnother(m);
	}
	public static boolean isToolSword(Material m){
		switch(m){
		case DIAMOND_SWORD: return true;
		case GOLD_SWORD: return true;
		case IRON_SWORD: return true;
		case STONE_SWORD: return true;
		case WOOD_SWORD: return true;
		default: return false;
		}
	}
	public static boolean isToolAxe(Material m){
		switch(m){
		case DIAMOND_AXE: return true;
		case GOLD_AXE: return true;
		case IRON_AXE: return true;
		case STONE_AXE: return true;
		case WOOD_AXE: return true;
		default: return false;
		}
	}
	public static boolean isToolPickAxe(Material m){
		switch(m){
		case DIAMOND_PICKAXE: return true;
		case GOLD_PICKAXE: return true;
		case IRON_PICKAXE: return true;
		case STONE_PICKAXE: return true;
		case WOOD_PICKAXE: return true;
		default: return false;
		}
	}
	public static boolean isToolSpade(Material m){
		switch(m){
		case DIAMOND_SPADE: return true;
		case GOLD_SPADE: return true;
		case IRON_SPADE: return true;
		case STONE_SPADE: return true;
		case WOOD_SPADE: return true;
		default: return false;
		}
	}
	public static boolean isToolHoe(Material m){
		switch(m){
		case DIAMOND_HOE: return true;
		case GOLD_HOE: return true;
		case IRON_HOE: return true;
		case STONE_HOE: return true;
		case WOOD_HOE: return true;
		default: return false;
		}
	}
	public static boolean isToolAnother(Material m){
		switch(m){
		case BOW: return true;
		case FLINT_AND_STEEL: return true;
		case FISHING_ROD: return true;
		case CARROT_STICK: return true;
		case SHEARS: return true;
		default: return false;
		}
	}
}