package com.optibest.mixin;

import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MathHelper.class)
public class MixinFastMathAdvanced {
    @Overwrite
    public static float sin(float value) {
        // Standart Java Sinüs yerine Sodium tipi hızlı tablo okuması
        return MathHelper.SINE_TABLE[(int)(value * 10430.378F) & 65535];
    }
}

