package com.optibest.mixin;

import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.Frustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author mbest700
 */
@Mixin(PlayerEntityRenderer.class)
public class MixinPlayerCulling {
    
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void mbest700$cullPlayers(OtherClientPlayerEntity entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if (entity.isInvisible()) {
            cir.setReturnValue(false);
        }
    }
}
