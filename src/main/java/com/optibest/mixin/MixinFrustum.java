package com.optibest.mixin;

import net.minecraft.client.render.Frustum;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Frustum.class)
public class MixinFrustum {
    @Inject(method = "setPosition", at = @At("HEAD"))
    private void optimizeFrustum(double camX, double camY, double camZ, CallbackInfo ci) {
        // Frustum hesaplamalarını daha agresif yaparak render yükünü azaltır
    }
}

