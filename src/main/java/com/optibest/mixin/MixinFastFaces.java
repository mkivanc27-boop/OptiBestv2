package com.optibest.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockState.class)
public abstract class MixinFastFaces {
    /**
     * @author MustafaKivanc
     * @reason Sodium-style fast face culling
     */
    @Overwrite
    public boolean shouldDrawSide(net.minecraft.world.BlockView world, net.minecraft.util.math.BlockPos pos, Direction side) {
        // Blokların görünmeyen yüzlerini render kuyruğuna hiç sokmaz
        return !world.getBlockState(pos.offset(side)).isOpaque();
    }
}

