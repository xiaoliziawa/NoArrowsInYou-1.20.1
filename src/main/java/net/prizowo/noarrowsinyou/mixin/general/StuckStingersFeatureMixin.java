package net.prizowo.noarrowsinyou.mixin.general;

import net.prizowo.noarrowsinyou.NAIY;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeStingerLayer.class)
public abstract class StuckStingersFeatureMixin {
    @Inject(method = "renderStuckItem", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderStuckStingers(PoseStack matrices, MultiBufferSource vertexConsumers, int light, Entity entity, float directionX, float directionY, float directionZ, float tickDelta, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(entity) && NAIY.getConfig().hideStings) {
            ci.cancel();
        }
    }
}
