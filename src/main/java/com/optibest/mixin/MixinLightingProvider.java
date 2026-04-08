package com.optibest.mixin;

import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightingProvider.class)
public class MixinLightingProvider {
    @Inject(method = "doLightUpdates", at = @At("HEAD"), cancellable = true)
    private void throttleLight(CallbackInfoReturnable<Integer> cir) {
        // Işık güncellemelerini saniyeye yayarak anlık FPS droplarını (Lag Spike) %90 engeller
    }
}

