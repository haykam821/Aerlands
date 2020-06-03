package io.github.haykam821.aerlands.world.biome.source;

import java.util.HashSet;
import java.util.Set;

import io.github.haykam821.aerlands.world.biome.ModBiomes;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSourceConfig;
import net.minecraft.world.gen.ChunkRandom;

public class AerlandsLayeredBiomeSource extends BiomeSource {
	public static final Set<Biome> BIOMES = new HashSet<>();

	private final SimplexNoiseSampler sampler;
	private final ChunkRandom random;

	public AerlandsLayeredBiomeSource(VanillaLayeredBiomeSourceConfig config) {
		super(BIOMES);

		this.random = new ChunkRandom(config.getSeed());
		this.random.consume(18820);
		this.sampler = new SimplexNoiseSampler(this.random);
	}

	public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
		double sampleA = this.sampler.sample(biomeX * 4, biomeZ * 4);
		double sampleB = this.sampler.sample(biomeX * 8, biomeZ * 8) * 0.5;
		double sampleC = this.sampler.sample(biomeX * 16, biomeZ * 16) * 0.25;

		double sample = sampleA + sampleB + sampleC;
		return sample >= 0.1 ? ModBiomes.AERLANDS.biome : ModBiomes.SKYROOT_FOREST.biome;
	}

	static {
		BIOMES.add(Biomes.JUNGLE);
	}
}
