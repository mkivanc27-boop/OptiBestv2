package com.optibest.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleTextureSheet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParticleManager.class)
public class MixinParticleManager {
    // 1.21.4 sürümünde addParticle artık bir değer döndürdüğü için Returnable kullanmalıyız
    @Inject(method = "addParticle(Lnet/minecraft/client/particle/Particle;)V", at = @At("HEAD"), cancellable = true)
    private void onAdd(Particle particle, CallbackInfoReturnable<Particle> cir) {
        // Gereksiz parçacıkları limitlemek için buraya ileride mantık ekleyebilirsin
    }
}
