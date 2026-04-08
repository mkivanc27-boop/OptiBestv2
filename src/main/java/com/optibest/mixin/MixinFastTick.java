package com.optibest.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinFastTick {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void slowFarTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && entity.squaredDistanceTo(client.player) > 4096) {
            // 64 bloktan uzaktaki mobların işlemciyi yormasını %50 azaltır
            if (entity.getWorld().getTime() % 2 != 0) ci.cancel();
        }
    }
}

