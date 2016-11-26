/**
 * 
 */
package com.chrismack.digremover.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.chrismack.digremover.LiteModDigRemover;

import net.minecraft.client.particle.ParticleDigging;

/**
 * @author Chris Mack
 *
 */
@Mixin(ParticleDigging.class)
public abstract class MixinParticleDigging
{
	
	@Inject(method = "renderParticle(Lnet/minecraft/client/renderer/VertexBuffer;Lnet/minecraft/entity/Entity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
	public void onRenderParticle(CallbackInfo ci)
    {
        if(LiteModDigRemover.CANCEL) ci.cancel();
    }
}
