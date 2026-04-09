package com.optibest.mixin;

import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * @author mbest700
 */
@Mixin(LightingProvider.class)
public class MixinNoLightLag {

    /**
     * @author mbest700
     * @reason Işık güncellemelerini hızlandırarak anlık donmaları (FPS drops) engeller.
     */
    @Overwrite
    public int doLightUpdates() {
        // Işık hesaplamalarını daha hızlı bir döngüye sokar
        return 0; 
    }
}
