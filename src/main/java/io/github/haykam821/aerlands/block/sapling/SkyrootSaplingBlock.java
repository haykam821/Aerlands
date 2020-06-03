package io.github.haykam821.aerlands.block.sapling;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SkyrootSaplingBlock extends SaplingBlock {
	public SkyrootSaplingBlock(Settings settings) {
		super(new SkyrootSaplingGenerator(), settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView view, BlockPos pos) {
		Block floorBlock = floor.getBlock();
		return floorBlock == ModBlocks.AERLAND_DIRT.block || floorBlock == ModBlocks.AERLAND_GRASS_BLOCK.block;
	}
}