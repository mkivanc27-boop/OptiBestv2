package com.optibest.mixin;

import com.optibest; // Sende package com.optibest ise böyle kalmalı
import com.optibest.OptiBestConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author mbest700
 */
@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer<T extends Entity> {

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void mbest700$optimizeEntityRender(T entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        // 1. Frustum (Görüş açısı) kontrolü zaten Minecraft'ta var ama biz garantiye alıyoruz
        if (!frustum.isVisible(entity.getBoundingBox())) {
            cir.setReturnValue(false);
            return;
        }

        // 2. mbest700 Özel: Agresif Culling (25 Blok Sınırı)
        if (OptiBestConfig.aggressiveCulling) {
            var player = MinecraftClient.getInstance().player;
            
            // Oyuncu yoksa veya render edilen şey oyuncunun kendisiyse dokunma
            if (player == null || entity == player) return;

            // 25 blok = 625 squared distance
            double distSq = entity.squaredDistanceTo(player.getX(), player.getY(), player.getZ());
            
            if (distSq > 625.0) {
                // Sadece dekoratif/önemsiz varlıkları gizle, oyuncuları ve bossları gizleme
                if (!entity.isPlayer()) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
