package com.optibest.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.CloudRenderMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author mbest700
 */
@Mixin(MinecraftClient.class)
public class MixinAutoOptimizer {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void mbest700$applyOptimizations(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        GameOptions options = client.options;

        // mbest700 Ayarları
        options.getCloudRenderMode().setValue(CloudRenderMode.OFF);
        options.getEntityShadows().setValue(false);
        options.getSmoothLighting().setValue(false);
        // Particle ayarını hata vermemesi için en güvenli yoldan kapattık
        options.getParticles().setValue(net.minecraft.client.option.ParticlesMode.MINIMAL);
    }
}
