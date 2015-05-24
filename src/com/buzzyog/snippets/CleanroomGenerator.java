package com.buzzyog.snippets;
 
import java.util.Random;
 
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
 
public class CleanroomGenerator extends ChunkGenerator {
	public byte[][] generateBlockSections(World world, Random random,
			int chunkX, int chunkZ, ChunkGenerator.BiomeGrid biomeGrid) {
		byte[][] res = new byte[world.getMaxHeight() / 16][];
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				biomeGrid.setBiome(x, z, Biome.FOREST);
			}
		}
		return res;
	}
 
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0.0D, 65.0D, 0.0D);
	}
 
}