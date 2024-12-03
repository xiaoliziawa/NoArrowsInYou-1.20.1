package net.prizowo.noarrowsinyou.mixin.misc;

import net.prizowo.noarrowsinyou.NAIY;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpinAttackEffectLayer.class)
public abstract class TridentRiptideFeatureMixin {
    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderTridentRiptide(PoseStack poseStack, MultiBufferSource buffer, int packedLight, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(livingEntity) && NAIY.getConfig().hideRiptide) {
            ci.cancel();
        }
    }
}
