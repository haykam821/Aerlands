package io.github.haykam821.aerlands.world.biome.source;

import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSourceConfig;

public class AerlandsLayeredBiomeSourceType extends BiomeSourceType<VanillaLayeredBiomeSourceConfig, AerlandsLayeredBiomeSource> {
	public AerlandsLayeredBiomeSourceType() {
		super(AerlandsLayeredBiomeSource::new, VanillaLayeredBiomeSourceConfig::new);
	}
}