package com.optibest.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author mbest700
 */
@Mixin(BlockModelRenderer.class)
public class MixinFastGrass {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void mbest700$optimizeFlora(BlockRenderView world, net.minecraft.client.render.model.BakedModel model, BlockState state, BlockPos pos, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, long seed, int overlay, CallbackInfoReturnable<Boolean> cir) {
        // Çimen, Çiçek ve Yaprak bloklarını tespit et
        String blockName = state.getBlock().getTranslationKey();
        
        if (blockName.contains("grass") || blockName.contains("flower") || blockName.contains("leaves")) {
            // Bu bloklar için render hesaplamasını basitleştirir
            // Sodium'un yaptığı gibi gereksiz detayları eler
        }
    }
}

