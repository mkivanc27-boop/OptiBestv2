package com.optibest.mixin;

import net.minecraft.client.font.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(TextRenderer.class)
public class MixinFontRenderer {
    @ModifyVariable(method = "drawInternal", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private boolean disableShadow(boolean shadow) {
        return false;
    }
}

