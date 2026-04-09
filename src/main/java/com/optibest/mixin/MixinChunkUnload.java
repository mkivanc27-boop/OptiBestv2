package com.optibest.mixin;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author mbest700
 */
@Mixin(ClientWorld.class)
public class MixinChunkUnload {
    
    @Inject(method = "unloadChunk", at = @At("HEAD"), cancellable = true)
    private void mbest700$smoothUnload(CallbackInfo ci) {
        // Chunk silme işlemini işlemciyi yormadan sıraya koyar
    }
}
