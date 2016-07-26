package com.chris.dig;

import com.mumfrey.liteloader.transformers.event.Event;
import com.mumfrey.liteloader.transformers.event.EventInjectionTransformer;
import com.mumfrey.liteloader.transformers.event.MethodInfo;
import com.mumfrey.liteloader.transformers.event.inject.MethodHead;

import static com.chris.dig.DigRemoverObfTable.*;

public class DigRemoverTransformer extends EventInjectionTransformer
{

	@Override
	protected void addEvents()
	{
		Event onEntityDiggingFX = Event.getOrCreate("onEntityDiggingFX", true);
		MethodInfo mdRenderParticle = new MethodInfo(EntityDigFX, renderParticle, 
				Void.TYPE, WorldRenderer, Entity, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
		MethodHead injectionPoint = new MethodHead();
		
		this.addEvent(onEntityDiggingFX, mdRenderParticle, injectionPoint).addListener(
				new MethodInfo("com.chris.dig.LiteModDigRemover"));
	}

}
