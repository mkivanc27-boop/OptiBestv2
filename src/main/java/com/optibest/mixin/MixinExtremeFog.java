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

@Mixin(BackgroundRenderer.class)
public class MixinExtremeFog { // DOSYA ADIYLA AYNI OLMAK ZORUNDA

    @Inject(method = "applyFog", at = @At("RETURN"))
    private static void mbest700$animatedDynamicFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        if (OptiBestConfig.extremeCulling) {
            long time = System.currentTimeMillis();
            float animation = MathHelper.sin((float) (time % 3000L) / 3000.0F * (float)Math.PI * 2.0F) * 1.5F;
            float baseLimit = (float) OptiBestConfig.renderDistanceLimit;
            
            float dynamicEnd = baseLimit + animation;
            RenderSystem.setShaderFogStart(dynamicEnd * 0.15F);
            RenderSystem.setShaderFogEnd(dynamicEnd);
        }
    }
}
