package io.github.haykam821.aerlands;

import io.github.haykam821.aerlands.block.ModBlocks;
import io.github.haykam821.aerlands.world.AerlandsDimension;
import io.github.haykam821.aerlands.world.biome.ModBiomes;
import io.github.haykam821.aerlands.world.biome.source.AerlandsLayeredBiomeSourceType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "aerlands";

	private static final Identifier AERLANDS_LAYERED_SOURCE_TYPE_ID = new Identifier(MOD_ID, "aerlands_layered");
	public static final AerlandsLayeredBiomeSourceType AERLANDS_LAYERED_SOURCE_TYPE = new AerlandsLayeredBiomeSourceType();

	public static final Identifier SKYROOT_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/skyroot");

	private static final Identifier AERLANDS_ID = new Identifier(MOD_ID, "aerlands");
	public static FabricDimensionType AERLANDS;

	@Override
	public void onInitialize() {
		Registry.register(Registry.BIOME_SOURCE_TYPE, AERLANDS_LAYERED_SOURCE_TYPE_ID, AERLANDS_LAYERED_SOURCE_TYPE);

		ModBlocks.initialize();
		ModBiomes.initialize();

		AERLANDS = FabricDimensionType.builder()
			.defaultPlacer(AerlandsDimension.AERLANDS_PLACER)
			.factory(AerlandsDimension::new)
			.buildAndRegister(AERLANDS_ID);
	}
}