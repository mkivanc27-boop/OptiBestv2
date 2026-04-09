package com.optibest.mixin;

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
        if (!frustum.isVisible(entity.getBoundingBox())) {
            cir.setReturnValue(false);
            return;
        }

        if (OptiBestConfig.aggressiveCulling) {
            var player = MinecraftClient.getInstance().player;
            if (player == null || entity == player) return;

            double distSq = entity.squaredDistanceTo(player.getX(), player.getY(), player.getZ());
            if (distSq > 625.0) {
                if (!entity.isPlayer()) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
