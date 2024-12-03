package net.prizowo.noarrowsinyou.mixin.entity;

import net.prizowo.noarrowsinyou.NAIY;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.FoxHeldItemLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.animal.Fox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoxHeldItemLayer.class)
public abstract class FoxHeldItemFeatureMixin {
    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Fox;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderFoxHeldItem(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Fox foxEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(NAIY.getConfig().hideFoxHeldItem) {
            ci.cancel();
        }
    }
}
