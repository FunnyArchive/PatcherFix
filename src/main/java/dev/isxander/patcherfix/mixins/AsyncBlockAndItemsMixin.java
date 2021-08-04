package dev.isxander.patcherfix.mixins;

import club.sk1er.patcher.registry.AsyncBlockAndItems;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = AsyncBlockAndItems.class, remap = false)
class AsyncBlockAndItemsMixin {

    /**
     * @author isXander
     */
    @Overwrite
    public final void load() {
        LogManager.getLogger("PatcherFix").info("PatcherFix prevented crash.");
    }

}