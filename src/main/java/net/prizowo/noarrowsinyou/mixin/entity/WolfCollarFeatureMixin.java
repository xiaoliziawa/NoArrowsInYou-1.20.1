package net.prizowo.noarrowsinyou.mixin.entity;

import net.prizowo.noarrowsinyou.NAIY;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.animal.Wolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WolfCollarLayer.class)
public abstract class WolfCollarFeatureMixin {
    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Wolf;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderWolfCollar(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Wolf wolfEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(NAIY.getConfig().hideWolfCollar) {
            ci.cancel();
        }
    }
}
