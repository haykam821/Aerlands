package io.github.haykam821.aerlands.block;

import java.util.function.Function;

import com.terraformersmc.terraform.block.TerraformButtonBlock;
import com.terraformersmc.terraform.block.TerraformDoorBlock;
import com.terraformersmc.terraform.block.TerraformPressurePlateBlock;
import com.terraformersmc.terraform.block.TerraformSignBlock;
import com.terraformersmc.terraform.block.TerraformStairsBlock;
import com.terraformersmc.terraform.block.TerraformTrapdoorBlock;
import com.terraformersmc.terraform.block.TerraformWallSignBlock;

import io.github.haykam821.aerlands.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModBlocks {
	AERLAND_DIRT("aerland_dirt", Block::new, Blocks.DIRT, ItemGroup.BUILDING_BLOCKS),
	AERLAND_GRASS_BLOCK("aerland_grass_block", GrassBlock::new, Blocks.GRASS_BLOCK, ItemGroup.BUILDING_BLOCKS),
	HOLYSTONE("holystone", Block::new, Blocks.STONE, ItemGroup.BUILDING_BLOCKS),
	HOLYSTONE_SLAB("holystone_slab", SlabBlock::new, Blocks.STONE_SLAB, ItemGroup.BUILDING_BLOCKS),
	MOSSY_HOLYSTONE("mossy_holystone", Block::new, Blocks.STONE, ItemGroup.BUILDING_BLOCKS),
	MOSSY_HOLYSTONE_SLAB("mossy_holystone_slab", SlabBlock::new, Blocks.STONE_SLAB, ItemGroup.BUILDING_BLOCKS),
	AERLAND_WARPER("aerland_warper", AerlandWarperBlock::new, Blocks.OBSIDIAN, ItemGroup.DECORATIONS),
	SKYROOT_PLANKS("skyroot_planks", Block::new, Blocks.OAK_PLANKS, ItemGroup.BUILDING_BLOCKS),
	SKYROOT_SLAB("skyroot_slab", SlabBlock::new, Blocks.OAK_SLAB, ItemGroup.BUILDING_BLOCKS),
	SKYROOT_STAIRS("skyroot_stairs", settings -> new TerraformStairsBlock(SKYROOT_PLANKS.block, settings), Blocks.OAK_STAIRS, ItemGroup.BUILDING_BLOCKS),
	SKYROOT_PRESSURE_PLATE("skyroot_pressure_plate", TerraformPressurePlateBlock::new, Blocks.OAK_PRESSURE_PLATE, ItemGroup.REDSTONE),
	SKYROOT_FENCE("skyroot_fence", FenceBlock::new, Blocks.OAK_FENCE, ItemGroup.DECORATIONS),
	SKYROOT_TRAPDOOR("skyroot_trapdoor", TerraformTrapdoorBlock::new, Blocks.OAK_TRAPDOOR, ItemGroup.REDSTONE),
	SKYROOT_FENCE_GATE("skyroot_fence_gate", FenceGateBlock::new, Blocks.OAK_FENCE_GATE, ItemGroup.REDSTONE),
	SKYROOT_BUTTON("skyroot_button", TerraformButtonBlock::new, Blocks.OAK_BUTTON, ItemGroup.REDSTONE),
	SKYROOT_DOOR("skyroot_door", TerraformDoorBlock::new, Blocks.OAK_DOOR, ItemGroup.REDSTONE),
	SKYROOT_SIGN("skyroot_sign", settings -> new TerraformSignBlock(Main.SKYROOT_SIGN_TEXTURE, settings), Blocks.OAK_SIGN, (BlockItem) null),
	SKYROOT_WALL_SIGN("skyroot_wall_sign", settings -> new TerraformWallSignBlock(Main.SKYROOT_SIGN_TEXTURE, settings.dropsLike(SKYROOT_SIGN.block)), Blocks.OAK_WALL_SIGN, (BlockItem) null);

	public Block block;
	public BlockItem item;

	private ModBlocks(String type, Block block, BlockItem item) {
		Identifier id = new Identifier(Main.MOD_ID, type);

		this.block = block;
		Registry.register(Registry.BLOCK, id, block);

		if (item != null) {
			this.item = item;
			Registry.register(Registry.ITEM, id, this.item);
		}
	}

	private ModBlocks(String type, Block block, ItemGroup group) {
		this(type, block, new BlockItem(block, new Item.Settings().group(group)));
	}

	private ModBlocks(String type, Function<Block.Settings, Block> function, Block base, BlockItem item) {
		this(type, function.apply(FabricBlockSettings.copyOf(base)), item);
	}

	private ModBlocks(String type, Function<Block.Settings, Block> function, Block base, ItemGroup group) {
		this(type, function.apply(FabricBlockSettings.copyOf(base)), group);
	}

	public static ModBlocks initialize() {
		Identifier skyrootSignId = new Identifier(Main.MOD_ID, "skyroot_sign");
		Item skyrootSign = new SignItem(new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(16), SKYROOT_SIGN.block, SKYROOT_WALL_SIGN.block);
		Registry.register(Registry.ITEM, skyrootSignId, skyrootSign);

		return null;
	}
}