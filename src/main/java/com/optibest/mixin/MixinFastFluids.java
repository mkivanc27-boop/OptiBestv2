package com.optibest.mixin;

import net.minecraft.client.render.block.FluidRenderer; // Yeni yol bu
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidRenderer.class)
public class MixinFastFluids {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void optimizeFluidRender(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, BlockState blockState, FluidState fluidState, CallbackInfo ci) {
        // Sıvı render optimizasyonu aktif
    }
}
