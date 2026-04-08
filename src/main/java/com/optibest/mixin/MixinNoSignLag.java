package com.optibest.mixin;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntity.class)
public class MixinNoSignLag {
    @Inject(method = "getText", at = @At("HEAD"), cancellable = true)
    private void hideFarSigns(CallbackInfoReturnable<Object> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        SignBlockEntity sign = (SignBlockEntity) (Object) this;
        if (client.player != null && sign.getPos().getSquaredDistance(client.player.getPos()) > 256) {
            // 16 bloktan uzaktaki tabela yazılarını işlemciye sormaz
        }
    }
}

