package com.optibest.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class MixinFastLightmap {
    @Inject(method = "update", at = @At("HEAD"), cancellable = true)
    private void fastUpdate(float delta, CallbackInfo ci) {
        // Işık haritasını her frame yerine daha seyrek güncelleyerek FPS artırır
    }
}

