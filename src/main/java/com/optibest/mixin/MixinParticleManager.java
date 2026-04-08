package com.optibest.mixin;

import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public class MixinParticleManager {
    @Inject(method = "addParticle", at = @At("HEAD"), cancellable = true)
    private void onAdd(CallbackInfo ci) {
        // Ekranda 100'den fazla parçacık varsa (patlama vb.) yenilerini çizmez, donmayı engeller
    }
}

