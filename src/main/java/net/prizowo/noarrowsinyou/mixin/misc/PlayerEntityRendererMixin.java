package net.prizowo.noarrowsinyou.mixin.misc;

import net.prizowo.noarrowsinyou.NAIY;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class PlayerEntityRendererMixin {
    @Inject(method = "scale(Lnet/minecraft/client/player/AbstractClientPlayer;Lcom/mojang/blaze3d/vertex/PoseStack;F)V", at = @At("TAIL"))
    public void naiy$resizePlayer(AbstractClientPlayer player, PoseStack matrices, float amount, CallbackInfo ci) {
        if (NAIY.isLocalPlayer(player) && NAIY.getConfig().resize) {
            matrices.scale(NAIY.getConfig().resX, NAIY.getConfig().resY, NAIY.getConfig().resZ);
        }
    }

    @Inject(method = "renderRightHand", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderRightArm(PoseStack matrices, MultiBufferSource vertexConsumers, int light, AbstractClientPlayer player, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().rightArm) {
            ci.cancel();
        }
    }

    @Inject(method = "renderLeftHand", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderLeftArm(PoseStack matrices, MultiBufferSource vertexConsumers, int light, AbstractClientPlayer player, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().leftArm) {
            ci.cancel();
        }
    }

    @Inject(method = "render(Lnet/minecraft/client/player/AbstractClientPlayer;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderPlayer(AbstractClientPlayer player, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().render) {
            ci.cancel();
        }
    }
}
