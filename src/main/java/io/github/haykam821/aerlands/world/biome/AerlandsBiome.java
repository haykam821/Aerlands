package io.github.haykam821.aerlands.world.biome;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class AerlandsBiome extends Biome {
	private static final BlockState AERLAND_GRASS_BLOCK = ModBlocks.AERLAND_GRASS_BLOCK.block.getDefaultState();
	private static final BlockState AERLAND_DIRT = ModBlocks.AERLAND_DIRT.block.getDefaultState();
	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	public static final TernarySurfaceConfig AERLAND_GRASS_CONFIG = new TernarySurfaceConfig(AERLAND_GRASS_BLOCK, AERLAND_DIRT, GRAVEL);

	public AerlandsBiome() {
		super(new Biome.Settings()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, AERLAND_GRASS_CONFIG)
			.precipitation(Biome.Precipitation.NONE)
			.category(Biome.Category.NONE)
			.depth(0.1f)
			.scale(0.2f)
			.temperature(0.5f)
			.downfall(0.5f)
			.waterColor(4445678)
			.waterFogColor(270131)
			.parent(null)
		);
	}
}