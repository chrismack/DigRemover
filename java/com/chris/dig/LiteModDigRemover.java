package com.chris.dig;

import java.io.File;

import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.transformers.event.EventInfo;

import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;

public class LiteModDigRemover implements LiteMod
{

	@Override
	public String getVersion()
	{
		return "1";
	}

	@Override
	public void init(File configPath)
	{
	}
	
	@Override
	public void upgradeSettings(String version, File configPath, File oldConfigPath)
	{
	}

	@Override
	public String getName()
	{
		return "Dig Remover";
	}

	public static void onentitydiggingfx(EventInfo<EntityDiggingFX> e, WorldRenderer arg1, Entity arg2, float partialTicks, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_)
	{
		p_180434_4_ = 0.9f;
		System.out.println(p_180434_4_);
	}

}
