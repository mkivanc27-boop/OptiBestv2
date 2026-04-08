package com.optibest.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.ParticlesMode;
import net.minecraft.client.option.CloudRenderMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author mbest700
 * OptiBest Project - Auto Performance Engine
 */
@Mixin(MinecraftClient.class)
public class MixinAutoOptimizer {

    /**
     * @author mbest700
     * @reason Ayarları otomatik olarak en hızlı seviyeye zorlar.
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    private void mbest700$applyGlobalOptimizations(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        GameOptions options = client.options;

        // mbest700 Özel Ayarları:
        options.getParticles().setValue(ParticlesMode.MINIMAL); // Parçacıkları kapat
        options.getCloudRenderMode().setValue(CloudRenderMode.OFF); // Bulutları yok et
        options.getEntityShadows().setValue(false); // Varlık gölgelerini sil
        options.getSmoothLighting().setValue(false); // Yumuşak ışıklandırmayı kapat
        options.getGraphicsMode().setValue(net.minecraft.client.option.GraphicsMode.FAST); // Grafikleri 'Hızlı' yap
        
        // mbest700 Not: Bu ayarlar her açılışta FPS'i korumaya alır.
    }
}
