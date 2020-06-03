package io.github.haykam821.aerlands.block.sapling;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.world.gen.decorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class SkyrootSaplingGenerator extends OakSaplingGenerator {
	private static final SimpleBlockStateProvider LOG_PROVIDER = new SimpleBlockStateProvider(ModBlocks.SKYROOT_LOG.block.getDefaultState());
	private static final SimpleBlockStateProvider LEAVES_PROVIDER = new SimpleBlockStateProvider(ModBlocks.SKYROOT_LEAVES.block.getDefaultState());

	public static final BranchedTreeFeatureConfig SKYROOT_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder(LOG_PROVIDER, LEAVES_PROVIDER, new BlobFoliagePlacer(2, 0))
			.baseHeight(4)
			.heightRandA(2)
			.foliageHeight(3)
			.noVines()
			.build();
	public static final BranchedTreeFeatureConfig SKYROOT_TREE_WITH_BEES_CONFIG = new BranchedTreeFeatureConfig.Builder(LOG_PROVIDER, LEAVES_PROVIDER, new BlobFoliagePlacer(2, 0))
			.baseHeight(4)
			.heightRandA(2)
			.foliageHeight(3)
			.noVines()
			.treeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.05f)))
			.build();

	@Override
	public ConfiguredFeature<BranchedTreeFeatureConfig, ?> createTreeFeature(Random random, boolean hasBeehives) {
		if (hasBeehives) {
			return Feature.NORMAL_TREE.configure(SKYROOT_TREE_WITH_BEES_CONFIG);
		}
		return Feature.NORMAL_TREE.configure(SKYROOT_TREE_CONFIG);
	}
}