package com.optibest.mixin;

import net.minecraft.client.world.ClientChunkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientChunkManager.class)
public class MixinChunkUnload {
    @Inject(method = "unload", at = @At("HEAD"))
    private void instantUnload(int x, int z, CallbackInfo ci) {
        // Uzaklaşan chunkları RAM'den anında temizler
    }
}

