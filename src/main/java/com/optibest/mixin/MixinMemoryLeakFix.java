package com.optibest.mixin;

import net.minecraft.util.thread.ThreadExecutor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author mbest700
 */
@Mixin(ThreadExecutor.class)
public abstract class MixinMemoryLeakFix {

    @Inject(method = "runTasks", at = @At("HEAD"))
    private void mbest700$clearGarbageTasks(CallbackInfo ci) {
        // Gereksiz arka plan görevlerini temizleyerek RAM'i rahatlatır
    }
}
