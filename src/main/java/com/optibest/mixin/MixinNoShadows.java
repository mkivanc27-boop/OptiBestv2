package com.optibest.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class MixinNoShadows {
    @Inject(method = "getShadowRadius", at = @At("HEAD"), cancellable = true)
    private void onGetShadowRadius(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0.0f); // Tüm gölge yarıçaplarını 0 yapar
    }
}
