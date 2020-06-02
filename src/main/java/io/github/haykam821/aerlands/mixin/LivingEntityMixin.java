package io.github.haykam821.aerlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.aerlands.Main;
import io.github.haykam821.aerlands.world.AerlandsDimension;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.dimension.DimensionType;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(method = "destroy", at = @At("HEAD"), cancellable = true)
	public void fallIntoOverworld(CallbackInfo ci) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (entity.dimension == Main.AERLANDS && !entity.world.isClient()) {
			FabricDimensions.teleport(entity, DimensionType.OVERWORLD, AerlandsDimension.OUT_OF_AERLANDS_PLACER);
			ci.cancel();
		}
	}
}