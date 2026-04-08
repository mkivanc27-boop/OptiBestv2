package com.optibest.mixin;

import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.option.ParticleStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class MixinAutoOptimizer {
    @Inject(method = "load", at = @At("RETURN"))
    private void forceBestSettings(CallbackInfo ci) {
        GameOptions options = (GameOptions) (Object) this;

        options.getCloudRenderMode().setValue(CloudRenderMode.OFF);
        options.getParticles().setValue(ParticleStatus.MINIMAL);
        options.getAo().setValue(false);
        options.getViewDistance().setValue(2);
        options.getEntityDistanceScaling().setValue(0.5);
        options.getMipmapLevels().setValue(0);
    }
}
