package com.optibest.mixin;

import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * @author mbest700
 */
@Mixin(MathHelper.class)
public class MixinFastMathAdvanced {

    @Shadow
    private static float[] SINE_TABLE;

    /**
     * @author mbest700
     * @reason Ultra fast math tables for mbest700 edition
     */
    @Overwrite
    public static float sin(float value) {
        return SINE_TABLE[(int)(value * 10430.378F) & 65535];
    }

    /**
     * @author mbest700
     * @reason Fast cosine calculation
     */
    @Overwrite
    public static float cos(float value) {
        return SINE_TABLE[(int)(value * 10430.378F + 16384.0F) & 65535];
    }
}
