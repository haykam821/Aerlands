package io.github.haykam821.aerlands;

import io.github.haykam821.aerlands.block.ModBlocks;
import io.github.haykam821.aerlands.world.AerlandsDimension;
import io.github.haykam821.aerlands.world.biome.AerlandsBiome;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class Main implements ModInitializer {
	public static final String MOD_ID = "aerlands";

	private static final Identifier AERLANDS_ID = new Identifier(MOD_ID, "aerlands");
	public static final Biome AERLANDS_BIOME = new AerlandsBiome();

	public static final FabricDimensionType AERLANDS = FabricDimensionType.builder()
		.defaultPlacer(AerlandsDimension.AERLANDS_PLACER)
		.factory(AerlandsDimension::new)
		.buildAndRegister(AERLANDS_ID);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BIOME, AERLANDS_ID, AERLANDS_BIOME);
		ModBlocks.initialize();
	}
}