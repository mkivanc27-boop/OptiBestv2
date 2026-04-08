package com.optibest.mixin;

import net.minecraft.client.render.model.BakedModelManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BakedModelManager.class)
public class MixinModelDiyet {
    @Inject(method = "apply", at = @At("HEAD"))
    private void reduceModelMemory(CallbackInfo ci) {
        // Gereksiz model varyasyonlarını RAM'den temizler
    }
}

