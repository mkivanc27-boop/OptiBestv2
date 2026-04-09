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
public class MixinExtremeFog {

    @Inject(method = "applyFog", at = @At("RETURN"))
    private static void mbest700$animatedDynamicFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        if (OptiBestConfig.extremeCulling) {
            long time = System.currentTimeMillis();
            
            // Animasyon matematiği: Sis her 3 saniyede bir hafifçe "nefes alır"
            // Math.sin ile yumuşak bir gidiş-dönüş yapıyoruz
            float animationOffset = MathHelper.sin((float) (time % 3000L) / 3000.0F * (float)Math.PI * 2.0F) * 1.5F;
            
            float baseLimit = (float) OptiBestConfig.renderDistanceLimit;
            float dynamicEnd = baseLimit + animationOffset; // Sis sınırı hafif oynar
            float dynamicStart = dynamicEnd * 0.15F; // Başlangıç her zaman bitişe oranlı

            RenderSystem.setShaderFogStart(dynamicStart);
            RenderSystem.setShaderFogEnd(dynamicEnd);
            
            // Sis rengini biraz daha derinleştirelim (Opsiyonel)
            // RenderSystem.setShaderFogColor(0.1F, 0.1F, 0.1F); 
        }
    }
}

