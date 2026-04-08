package com.optibest.mixin;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class MixinNoShadows {
    @Inject(method = "renderShadow", at = @At("HEAD"), cancellable = true)
    private static void cancelShadows(CallbackInfo ci) {
        ci.cancel(); 
    }
}

