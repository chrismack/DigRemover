package com.chris.dig;

import com.mumfrey.liteloader.core.runtime.Obf;

public class DigRemoverObfTable extends Obf
{
	public static DigRemoverObfTable EntityDigFX = new DigRemoverObfTable("net.minecraft.client.particle.EntityDiggingFX", "cid");
	public static DigRemoverObfTable renderParticle = new DigRemoverObfTable("func_180434_a", "a", "renderParticle");
	public static final DigRemoverObfTable WorldRenderer = new DigRemoverObfTable("net/minecraft/client/renderer/WorldRenderer", "civ");
	public static final DigRemoverObfTable Entity = new DigRemoverObfTable("net.minecraft.entity.Entity", "wv");
	
	public DigRemoverObfTable(String seargeName, String obfName, String mcpName)
	{
		super(seargeName, obfName, mcpName);
	}
	
	public DigRemoverObfTable(String seargeName, String obfName)
	{
		super(seargeName, obfName);
	}

	
}
