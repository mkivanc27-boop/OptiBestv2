package com.optibest.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMemoryLeakFix {
    @Inject(method = "render", at = @At("HEAD"))
    private void cleanMemory(boolean tick, CallbackInfo ci) {
        // RAM doluluğu %90'ı geçerse Java'nın temizlik sistemini uyarır
        if (Runtime.getRuntime().freeMemory() < Runtime.getRuntime().totalMemory() * 0.1) {
            System.gc(); 
        }
    }
}

