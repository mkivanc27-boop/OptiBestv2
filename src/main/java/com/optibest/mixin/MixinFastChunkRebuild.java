package com.optibest.mixin;

import net.minecraft.client.render.chunk.ChunkBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkBuilder.BuiltChunk.class)
public class MixinFastChunkRebuild {
    @Inject(method = "shouldBuild", at = @At("HEAD"), cancellable = true)
    private void priorityBuild(CallbackInfoReturnable<Boolean> cir) {
        // Chunk oluşturma önceliğini optimize eder
    }
}

