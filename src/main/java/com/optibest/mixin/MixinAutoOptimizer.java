package com.optibest.mixin;

import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.option.ParticlesMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class MixinAutoOptimizer {
    @Inject(method = "load", at = @At("RETURN"))
    private void forceBestSettings(CallbackInfo ci) {
        GameOptions options = (GameOptions) (Object) this;

        // FPS Canavarı Ayarlar
        options.getCloudRenderMode().setValue(CloudRenderMode.OFF); // Bulutlar Kapatıldı
        options.getSmoothLighting().setValue(false); // Yumuşak Işıklandırma Kapatıldı
        options.getParticles().setValue(ParticlesMode.MINIMAL); // Parçacıklar En Azda
        options.getAo().setValue(0); // Ambient Occlusion Kapatıldı
        options.getViewDistance().setValue(2); // Görüş Mesafesi 2 Chunk (En Hızlı)
        options.getEntityDistanceScaling().setValue(0.5f); // Varlık Görünme Mesafesi %50
        options.getMipmapLevels().setValue(0); // Mipmap Kapatıldı (Büyük FPS kazancı)
    }
}

