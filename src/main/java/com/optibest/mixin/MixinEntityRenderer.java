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
        // Görüş açısı dışında kalanları çizmez
        if (!frustum.isVisible(entity.getBoundingBox())) {
            cir.setReturnValue(false);
            return;
        }

        // mbest700 Özel: 25 blok ötesi kısıtlaması
        if (OptiBestConfig.aggressiveCulling) {
            double distSq = entity.squaredDistanceTo(MinecraftClient.getInstance().player);
            if (distSq > 625 && !entity.isPlayer()) {
                cir.setReturnValue(false);
            }
        }
    }
}
