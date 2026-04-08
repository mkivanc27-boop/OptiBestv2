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

        // 1.21.4 uyumlu mbest700 ayarları
        // Hata veren getSmoothLighting ve ParticlesMode kısımları silindi.
        // Sadece kesin çalışan ve FPS uçuran ayarlar bırakıldı.
        
        options.getCloudRenderMode().setValue(CloudRenderMode.OFF);
        options.getEntityShadows().setValue(false);
        options.getAo().setValue(net.minecraft.client.option.AoMode.OFF); // Smooth Lighting'in yeni adı
        
        System.out.println("OptiBest: mbest700 performance settings applied!");
    }
}
