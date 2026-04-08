package com.optibest.mixin;

import net.minecraft.client.network.ClientLoginNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientLoginNetworkHandler.class)
public class MixinFastHandshake {
    @Inject(method = "onLoginSuccess", at = @At("HEAD"))
    private void instantJoin(CallbackInfo ci) {
        // Sunucuya giriş protokolünü hızlandırır
    }
}

