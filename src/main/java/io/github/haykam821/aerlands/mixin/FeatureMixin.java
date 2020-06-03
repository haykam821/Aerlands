package io.github.haykam821.aerlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;

@Mixin(Feature.class)
public class FeatureMixin {
	@Inject(method = "isDirt", at = @At("HEAD"), cancellable = true)
	private static void allowAerlandDirt(Block block, CallbackInfoReturnable<Boolean> ci) {
		if (block == ModBlocks.AERLAND_DIRT.block || block == ModBlocks.AERLAND_GRASS_BLOCK.block) {
			ci.setReturnValue(true);
		}
	}
}