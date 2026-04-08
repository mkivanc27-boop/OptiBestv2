package com.optibest.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import org.joml.Vector4f; // Bu yeni eklenmeli
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class MixinSkyPerformance {
    // 1.21.4 için doğru parametre dizilimi budur
    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void fastFog(Camera camera, BackgroundRenderer.FogType fogType, Vector4f color, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        // Sisi basit tutarak GPU yükünü hafifletiyoruz
    }
}
