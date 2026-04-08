package com.optibest.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.render.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class MixinSmartEntity<T extends Entity> {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void aggressiveCulling(T entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if (entity.getPos().getSquaredDistance(MinecraftClient.getInstance().player.getPos()) > 1024) {
            cir.setReturnValue(false);
        }
    }
}

