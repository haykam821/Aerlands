package io.github.haykam821.aerlands.world.biome;

import io.github.haykam821.aerlands.block.sapling.SkyrootSaplingGenerator;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

public class SkyrootForestBiome extends AerlandsBiome {
	public SkyrootForestBiome() {
		super();

		ConfiguredDecorator<CountExtraChanceDecoratorConfig> extraChanceDecorator = Decorator.COUNT_EXTRA_HEIGHTMAP
			.configure(new CountExtraChanceDecoratorConfig(4, 0.1f, 1));

		ConfiguredFeature<?, ?> treeFeature = Feature.NORMAL_TREE
			.configure(SkyrootSaplingGenerator.SKYROOT_TREE_CONFIG)
			.createDecoratedFeature(extraChanceDecorator);
	
		this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, treeFeature);
	}
}