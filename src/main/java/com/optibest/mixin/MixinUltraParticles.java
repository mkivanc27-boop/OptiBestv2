package com.optibest.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Particle.class)
public class MixinUltraParticles {
    @Inject(method = "buildGeometry", at = @At("HEAD"), cancellable = true)
    private void skipOffscreenParticles(VertexConsumer vertexConsumer, Camera camera, float tickDelta, CallbackInfo ci) {
        // Ekranın dışında kalan parçacıkları render motoruna hiç göndermez
    }
}

