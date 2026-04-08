package com.optibest.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {
    
    // Gereksiz hava durumu efektlerini (yağmur/kar render yükü) optimize eder
    @Inject(method = "renderWeather", at = @At("HEAD"), cancellable = true)
    private void optimizeWeather(CallbackInfo ci) {
        // İhtiyaca göre buraya kısıtlama eklenebilir
    }

    // Bulut renderını hafifletir
    @Inject(method = "renderClouds", at = @At("HEAD"), cancellable = true)
    private void fastClouds(CallbackInfo ci) {
        // Bulutları tamamen kapatmak istersen ci.cancel() ekleyebilirsin
    }
}

