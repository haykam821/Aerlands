package io.github.haykam821.aerlands.world;

import io.github.haykam821.aerlands.Main;
import io.github.haykam821.aerlands.block.ModBlocks;
import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSourceConfig;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import net.minecraft.world.gen.chunk.FloatingIslandsChunkGeneratorConfig;

public class AerlandsDimension extends OverworldDimension {
	public static final EntityPlacer OUT_OF_AERLANDS_PLACER = (Entity entity, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) -> {
		Vec3d spawnPos = new Vec3d(entity.getX(), 384, entity.getZ()); 
		return new BlockPattern.TeleportTarget(spawnPos, entity.getVelocity(), (int) entity.yaw);
	};

	public static final EntityPlacer AERLANDS_PLACER = (Entity entity, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) -> {
		BlockPos blockTeleportPos = destination.getDimension().getTopSpawningBlockPosition((int) entity.getX(), (int) entity.getZ(), false);
		return new BlockPattern.TeleportTarget(
			blockTeleportPos == null ? new Vec3d(entity.getX(), 384, entity.getY()) : new Vec3d(blockTeleportPos),
			entity.getVelocity(),
			(int) entity.yaw
		);
	};


	public AerlandsDimension(World world, DimensionType type) {
		super(world, type);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		FloatingIslandsChunkGeneratorConfig config = ChunkGeneratorType.FLOATING_ISLANDS.createSettings();

		config.setDefaultBlock(ModBlocks.AERLAND_DIRT.block.getDefaultState());
		config.setDefaultFluid(Blocks.AIR.getDefaultState());

		// Biome config
		VanillaLayeredBiomeSourceConfig biomeConfig = Main.AERLANDS_LAYERED_SOURCE_TYPE.getConfig(world.getLevelProperties());

		return ChunkGeneratorType.FLOATING_ISLANDS.create(world, Main.AERLANDS_LAYERED_SOURCE_TYPE.applyConfig(biomeConfig), config);
	}

	@Override
	public DimensionType getType() {
		return Main.AERLANDS;
	}

	@Override
	public boolean canPlayersSleep() {
		return false;
	}
}