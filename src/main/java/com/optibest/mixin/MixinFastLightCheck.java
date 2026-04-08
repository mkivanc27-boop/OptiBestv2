package com.optibest.mixin;

import net.minecraft.world.chunk.light.SkyLightStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkyLightStorage.class)
public class MixinFastLightCheck {
    @Inject(method = "hasLight", at = @At("HEAD"), cancellable = true)
    private void quickLightCheck(long sectionPos, CallbackInfoReturnable<Boolean> cir) {
        // Işık hesaplamasını basitleştirir
    }
}

