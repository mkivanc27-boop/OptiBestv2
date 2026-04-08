package com.optibest.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldRenderer.class)
public class MixinChunkUpdateLimit {
    // 1.21.4'te terrain render kuyruğu kontrolünü bu şekilde yakalıyoruz
    @Inject(method = "isTerrainRenderQueued", at = @At("HEAD"), cancellable = true, remap = false)
    private void limitUpdates(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
