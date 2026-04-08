package com.optibest.mixin;

import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MathHelper.class)
public class MixinFastMathAdvanced {

    @Shadow
    private static float[] SINE_TABLE; // Gizli tabloya erişim sağladık

    /**
     * @author MustafaKivanc
     */
    @Overwrite
    public static float sin(float value) {
        return SINE_TABLE[(int)(value * 10430.378F) & 65535];
    }
}
