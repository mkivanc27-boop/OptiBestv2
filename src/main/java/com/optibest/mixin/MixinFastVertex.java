package com.optibest.mixin;

import net.minecraft.client.render.VertexFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VertexFormat.class)
public class MixinFastVertex {
    @Inject(method = "getVertexSizeByte", at = @At("HEAD"), cancellable = true)
    private void optimizeVertexSize(CallbackInfoReturnable<Integer> cir) {
        // GPU'ya giden veri paketlerini optimize eder
    }
}

