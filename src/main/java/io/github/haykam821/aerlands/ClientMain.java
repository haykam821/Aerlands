package io.github.haykam821.aerlands;

import com.terraformersmc.terraform.registry.SpriteIdentifierRegistry;

import io.github.haykam821.aerlands.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		RenderLayer cutoutLayer = RenderLayer.getCutout();
		BlockRenderLayerMap.INSTANCE.putBlocks(cutoutLayer, ModBlocks.SKYROOT_DOOR.block, ModBlocks.SKYROOT_TRAPDOOR.block);

		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, Main.SKYROOT_SIGN_TEXTURE));
	}
}