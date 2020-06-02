package io.github.haykam821.aerlands.block;

import io.github.haykam821.aerlands.Main;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class AerlandWarperBlock extends Block {
	public AerlandWarperBlock(Settings settings) {
		super(settings);
	}

	@Override
	public int getLuminance(BlockState state) {
		return 14;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
		// Require using the top face of the block
		if (hitResult.getSide() != Direction.UP) {
			return ActionResult.PASS;
		}

		// Require the sky being visible
		if (!world.isSkyVisible(pos.up())) {
			player.addChatMessage(new TranslatableText(this.getTranslationKey() + ".no_sky_access"), true);
			return ActionResult.FAIL;
		}

		// Require using in the overworld
		if (world.getDimension().getType() != DimensionType.OVERWORLD) {
			return ActionResult.FAIL;
		}

		if (!world.isClient()) {
			FabricDimensions.teleport(player, Main.AERLANDS);
		}
		return ActionResult.SUCCESS;
	}
}