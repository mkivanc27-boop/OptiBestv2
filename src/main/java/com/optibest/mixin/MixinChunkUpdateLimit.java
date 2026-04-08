package com.optibest.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldRenderer.class)
public class MixinChunkUpdateLimit {
    @Inject(method = "isTerrainRenderQueued", at = @At("HEAD"), cancellable = true)
    private void limitUpdates(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}

