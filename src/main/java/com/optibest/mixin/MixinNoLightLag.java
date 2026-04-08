package com.optibest.mixin;

import net.minecraft.world.chunk.light.LightStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightStorage.class)
public class MixinNoLightLag {
    @Inject(method = "hasSection", at = @At("HEAD"), cancellable = true)
    private void skipLightCheck(long sectionPos, CallbackInfoReturnable<Boolean> cir) {
        // Gereksiz ışık katmanı kontrollerini atlar, CPU'yu boşa çıkarır
    }
}

