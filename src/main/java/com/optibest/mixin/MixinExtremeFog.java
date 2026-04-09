package com.optibest.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import com.optibest.OptiBestConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author mbest700
 */
@Mixin(BackgroundRenderer.class)
public class MixinFogSpeed {

    @Inject(method = "applyFog", at = @At("RETURN"))
    private static void mbest700$dynamicFogSpeed(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        if (OptiBestConfig.extremeCulling) {
            // Hatanın olduğu yer burasıydı, artık bir metodun içinde:
            double velocity = camera.getFocusedEntity().getVelocity().horizontalLength();
            float speedFactor = (float) (velocity * 2.5); 
            
            float baseLimit = (float) OptiBestConfig.renderDistanceLimit;
            float finalLimit = baseLimit + speedFactor;

            RenderSystem.setShaderFogStart(finalLimit * 0.1F);
            RenderSystem.setShaderFogEnd(finalLimit);
        }
    }
}
