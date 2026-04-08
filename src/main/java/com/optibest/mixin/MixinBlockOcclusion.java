package com.optibest.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class MixinBlockOcclusion {
    @Inject(method = "shouldSideBeRendered", at = @At("HEAD"), cancellable = true)
    private static void onShouldSideBeRendered(BlockState state, BlockState adjacentState, Direction side, CallbackInfoReturnable<Boolean> cir) {
        // Aynı tip bloklar yan yanaysa görünmeyen iç yüzeyleri renderlamayı iptal eder
        if (state == adjacentState) {
            cir.setReturnValue(false);
        }
    }
}
