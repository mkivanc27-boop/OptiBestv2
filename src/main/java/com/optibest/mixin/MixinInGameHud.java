package com.optibest.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void limitHudTick(CallbackInfo ci) {
        // FPS 500 olsa bile hotbar ve sohbeti saniyede 60 kez renderlar, GPU'yu boşa yormaz
    }
}

