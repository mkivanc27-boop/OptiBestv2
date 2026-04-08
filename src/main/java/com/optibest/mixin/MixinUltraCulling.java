package com.optibest.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.render.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class MixinUltraCulling {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void aggressiveCulling(Entity entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        // Frustum (bakış açısı) dışında kalan her şeyi anında iptal eder
        if (!frustum.isVisible(entity.getBoundingBox())) {
            cir.setReturnValue(false);
        }
    }
}
