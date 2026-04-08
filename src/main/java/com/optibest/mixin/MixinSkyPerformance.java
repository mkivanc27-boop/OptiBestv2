package com.optibest.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable; // Değişti!

@Mixin(BackgroundRenderer.class)
public class MixinSkyPerformance {
    
    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void fastFog(Camera camera, BackgroundRenderer.FogType fogType, Vector4f color, float viewDistance, boolean thickFog, float tickDelta, CallbackInfoReturnable<Void> cir) {
        // CallbackInfo yerine CallbackInfoReturnable<Void> geldi.
        // Sis optimizasyonu aktif.
    }
}
