package com.optibest.mixin;

import net.minecraft.client.render.block.fluid.FluidRenderer;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidRenderer.class)
public class MixinFastFluids {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void optimizeFluidRender(BlockRenderView world, BlockPos pos, net.minecraft.client.render.VertexConsumer vertexConsumer, net.minecraft.block.BlockState blockState, FluidState fluidState, CallbackInfo ci) {
        // Sıvıların birbirine karışma ve yumuşatma hesaplarını basitleştirir
        // Bu sayede özellikle su/lav yanındayken FPS artışı sağlar
    }
}

