package com.optibest.mixin;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class MixinRamPurge {
    @Inject(method = "disconnect", at = @At("HEAD"))
    private void forceGC(CallbackInfo ci) {
        System.gc(); // RAM'i zorla boşaltır
    }
}

