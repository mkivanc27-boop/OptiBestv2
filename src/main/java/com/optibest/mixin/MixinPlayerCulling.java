package com.optibest.mixin;

import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class MixinPlayerCulling {
    @Inject(method = "shouldRender(Lnet/minecraft/client/network/OtherClientPlayerEntity;Lnet/minecraft/client/render/Frustum;DDD)Z", at = @At("HEAD"), cancellable = true)
    private void cullPlayers(OtherClientPlayerEntity player, net.minecraft.client.render.Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if (player.isInvisible() || player.isSpectator()) {
            cir.setReturnValue(false);
        }
    }
}

