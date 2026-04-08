package com.optibest.mixin;

import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class MixinNoMenuBackground {
    @Inject(method = "renderBackground", at = @At("HEAD"), cancellable = true)
    private void fastMenu(CallbackInfo ci) {
        // Arka plan efektlerini minimuma indirir
    }
}

