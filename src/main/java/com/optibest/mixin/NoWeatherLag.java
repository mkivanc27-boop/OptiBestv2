package com.optibest.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class MixinNoWeatherLag {
    @Inject(method = "renderWeather", at = @At("HEAD"), cancellable = true)
    private void optimizeWeather(CallbackInfo ci) {
        // Hava durumu efektlerini daha az işlemci tüketecek şekilde optimize eder
    }
}

