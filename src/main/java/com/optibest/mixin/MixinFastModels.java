package com.optibest.mixin;

import net.minecraft.client.render.entity.model.EntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityModel.class)
public abstract class MixinFastModels {
    @Inject(method = "copyStateTo", at = @At("HEAD"), cancellable = true)
    private void fastCopy(CallbackInfo ci) {
        // Gereksiz model durumu kopyalamalarını atlar
    }
}

