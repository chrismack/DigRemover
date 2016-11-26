/**
 * 
 */
package com.chrismack.digremover;

import java.io.File;

import org.lwjgl.input.Keyboard;

import com.mumfrey.liteloader.Tickable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;

/**
 * @author Chris
 *
 */
public class LiteModDigRemover implements Tickable
{
	public static boolean CANCEL = false;
	private static KeyBinding digKeyBinding = new KeyBinding("key.clock.toggle", Keyboard.KEY_F12, "key.categories.litemods");

	@Override
	public String getName()
	{
		return "Dig Remover";
	}

	@Override
	public String getVersion()
	{
		return "2.0.0";
	}

	@Override
	public void init(File configPath)
	{
	}

	@Override
	public void upgradeSettings(String version, File configPath, File oldConfigPath) {}

	@Override
	public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock)
	{
		if (inGame && minecraft.currentScreen == null && Minecraft.isGuiEnabled())
		{
			if (LiteModDigRemover.digKeyBinding.isPressed())
			{
				CANCEL = !CANCEL;
				minecraft.thePlayer.addChatComponentMessage(new TextComponentString("Dig remover " + (CANCEL == true ? "on" : "off")));
			}
		}
	}

}
