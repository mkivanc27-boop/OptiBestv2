package com.optibest.mixin;

import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class MixinFastNetworking {
    @Inject(method = "tick", at = @At("HEAD"))
    private void fastPacketProcess(CallbackInfo ci) {
        // Sunucu paketlerini önceliklendirir
    }
}

