package com.optibest.mixin;

import com.optibest.config.OptiBestConfig;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer<T extends Entity> {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void onShouldRender(T entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        // 1. Kural: Arkandaysa anında sil (Standard Culling)
        if (!frustum.isVisible(entity.getBoundingBoxForCulling())) {
            cir.setReturnValue(false);
            return;
        }

        // 2. Kural: mbest700 Özel 25 Blok Sınırı (LOD)
        if (OptiBestConfig.aggressiveCulling) {
            double distSq = entity.squaredDistanceTo(MinecraftClient.getInstance().player);
            // 25 bloktan (625 kare mesafe) uzaksa ve oyuncu değilse renderı kısıtla
            if (distSq > 625 && !entity.isPlayer()) {
                cir.setReturnValue(false);
            }
        }
    }
}

