package io.github.haykam821.aerlands.mixin;

import java.util.Random;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Mixin(SpreadableBlock.class)
public class SpreadableBlockMixin {
	@Redirect(method = "scheduledTick", at = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DIRT:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC))
	public Block spreadAerlandGrass(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (state.getBlock() == ModBlocks.AERLAND_GRASS_BLOCK.block) {
			return ModBlocks.AERLAND_DIRT.block;
		}
		return Blocks.DIRT;
	}
}