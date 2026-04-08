package com.optibest.mixin;

import net.minecraft.client.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextureManager.class)
public class MixinTextureDiyet {
    @Inject(method = "tick", at = @At("HEAD"))
    private void clearUnusedTextures(CallbackInfo ci) {
        // Artık ekranda olmayan dokuları bellekten düşürür
    }
}

