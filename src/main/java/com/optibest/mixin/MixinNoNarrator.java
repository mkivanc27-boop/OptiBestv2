package com.optibest.mixin;

import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NarratorManager.class)
public class MixinNoNarrator {
    // Anlatıcıyı aktif etmeye çalışan her şeyi "kapalı" olarak döndürüyoruz
    @Inject(method = "isActive", at = @At("HEAD"), cancellable = true)
    private void disableNarrator(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}

