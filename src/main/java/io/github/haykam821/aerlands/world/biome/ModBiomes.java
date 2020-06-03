package io.github.haykam821.aerlands.world.biome;

import java.util.function.Supplier;

import io.github.haykam821.aerlands.Main;
import io.github.haykam821.aerlands.world.biome.source.AerlandsLayeredBiomeSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public enum ModBiomes {
	AERLANDS("aerlands", AerlandsBiome::new),
	SKYROOT_FOREST("skyroot_forest", SkyrootForestBiome::new);

	public Biome biome;

	private ModBiomes(String type, Supplier<Biome> supplier) {
		Identifier id = new Identifier(Main.MOD_ID, type);

		this.biome = supplier.get();
		Registry.register(Registry.BIOME, id, this.biome);
		AerlandsLayeredBiomeSource.BIOMES.add(this.biome);
	}

	public static ModBiomes initialize() {
		return null;
	}
}