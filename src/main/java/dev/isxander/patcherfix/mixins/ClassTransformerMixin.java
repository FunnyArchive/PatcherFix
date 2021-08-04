package dev.isxander.patcherfix.mixins;

import club.sk1er.patcher.Patcher;
import club.sk1er.patcher.asm.forge.ModelLoaderTransformer;
import club.sk1er.patcher.tweaker.ClassTransformer;
import club.sk1er.patcher.tweaker.transform.PatcherTransformer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClassTransformer.class, remap = false)
public class ClassTransformerMixin {

    @Inject(method = "registerTransformer", at = @At("HEAD"), cancellable = true)
    private void registerTransformerHook(PatcherTransformer transformer, CallbackInfo ci) {
        if (Patcher.VERSION != "1.5.1") throw new IllegalStateException("Sk1erLLC has requested that this mod is only compatible with Patcher 1.5.1. This is to prevent use of old versions.");
        if (transformer instanceof ModelLoaderTransformer) ci.cancel();
    }

}
