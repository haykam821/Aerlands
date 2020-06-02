package io.github.haykam821.aerlands.block;

import java.util.function.Function;

import io.github.haykam821.aerlands.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModBlocks {
	AERLAND_DIRT("aerland_dirt", Block::new, Blocks.DIRT, ItemGroup.BUILDING_BLOCKS),
	AERLAND_GRASS_BLOCK("aerland_grass_block", GrassBlock::new, Blocks.GRASS_BLOCK, ItemGroup.BUILDING_BLOCKS),
	AERLAND_WARPER("aerland_warper", AerlandWarperBlock::new, Blocks.OBSIDIAN, ItemGroup.DECORATIONS);

	public Block block;
	public BlockItem item;

	private ModBlocks(String type, Block block, ItemGroup group) {
		Identifier id = new Identifier(Main.MOD_ID, type);

		this.block = block;
		Registry.register(Registry.BLOCK, id, block);

		Item.Settings itemSettings = new Item.Settings().group(group);
		this.item = new BlockItem(this.block, itemSettings);
		Registry.register(Registry.ITEM, id, this.item);
	}

	private ModBlocks(String type, Function<Block.Settings, Block> function, Block base, ItemGroup group) {
		this(type, function.apply(FabricBlockSettings.copyOf(base)), group);
	}

	public static ModBlocks initialize() {
		return null;
	}
}