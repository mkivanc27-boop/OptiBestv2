package com.optibest.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.block.Block;

@Mixin(Block.class)
public class MixinBlockOcclusion {
    /** @author mbest700 */
    @Overwrite
    public static boolean shouldSideBeRendered(BlockState state, BlockState adjacentState, Direction side) {
        // Görünmeyen blok yüzeylerini ekran kartına göndermez, VRAM kullanımını düşürür
        return state != adjacentState;
    }
}

