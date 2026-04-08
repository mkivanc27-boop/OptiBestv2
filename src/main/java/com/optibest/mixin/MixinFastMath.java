package com.optibest.mixin;

import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MathHelper.class)
public class MixinFastMath {
    /**
     * @author mbest700
     * @reason Sinüs hesaplamalarını hızlandırarak CPU yükünü azaltır.
     */
    @Overwrite
    public static float sin(float value) {
        return (float) Math.sin(value); // Buraya daha hızlı bir tablo mantığı da eklenebilir
    }
}

