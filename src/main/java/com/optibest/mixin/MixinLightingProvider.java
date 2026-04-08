package com.optibest.mixin;

import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightingProvider.class)
public class MixinLightingProvider {
    @Inject(method = "hasUpdates", at = @At("HEAD"), cancellable = true)
    private void onHasUpdates(CallbackInfoReturnable<Boolean> cir) {
        // Işık güncellemelerini optimize etmek için; 
        // burayı boş bırakabiliriz veya ağır işlemleri engelleyebiliriz.
    }
}
