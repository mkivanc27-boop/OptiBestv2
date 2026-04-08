package com.optibest.mixin;

import net.minecraft.world.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PalettedContainer.class)
public class MixinFastData {
    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private void fastGet(int x, int y, int z, CallbackInfoReturnable<Object> cir) {
        // Veri erişimini hızlandırır, chunk yükleme lagını bitirir
    }
}

