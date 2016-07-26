package com.chris.dig;

import java.io.File;

import org.lwjgl.opengl.GL11;

import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.PostRenderListener;
import com.mumfrey.liteloader.transformers.event.EventInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class LiteModDigRemover implements LiteMod, PostRenderListener
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

	@Override
	public void onPostRenderEntities(float partialTicks)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPostRender(float partialTicks)
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		for(int i = 0; i < mc.theWorld.loadedEntityList.size(); i++)
		{
			
			Entity entity = (Entity) mc.theWorld.loadedEntityList.get(i);
			if(!(entity == mc.thePlayer))
			{
				AxisAlignedBB boundingBox = entity.getEntityBoundingBox();
				double distX, distY, distZ, distX1, distY1, distZ1;
	
				double var4 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)partialTicks;
		        double var6 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks;
		        double var8 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)partialTicks;
		        
		        double var5 = mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * (double)partialTicks;
		        double var7 = mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * (double)partialTicks;
		        double var9 = mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * (double)partialTicks;
		        
				distX = var4 - var5;
				distY = var6 - var7;
				distZ = var8 - var9;
			
				renderBox(entity, distX, distY, distZ, 0, partialTicks);
			}
		}
	}
	
	private void renderBox(Entity entityIn, double p_85094_2_, double p_85094_4_, double p_85094_6_, float p_85094_8_, float p_85094_9_)
	{
		GlStateManager.depthMask(false);
        GlStateManager.disableTexture2D();
        //GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        float var10 = entityIn.width / 2.0F;
        AxisAlignedBB var11 = entityIn.getEntityBoundingBox();
        AxisAlignedBB var12 = new AxisAlignedBB(var11.minX - entityIn.posX + p_85094_2_, var11.minY - entityIn.posY + p_85094_4_, var11.minZ - entityIn.posZ + p_85094_6_, var11.maxX - entityIn.posX + p_85094_2_, var11.maxY - entityIn.posY + p_85094_4_, var11.maxZ - entityIn.posZ + p_85094_6_);
        RenderGlobal.drawOutlinedBoundingBox(var12, 16777215);

        if (entityIn instanceof EntityLivingBase)
        {
            float var13 = 0.01F;
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(p_85094_2_ - (double)var10, p_85094_4_ + (double)entityIn.getEyeHeight() - 0.009999999776482582D, p_85094_6_ - (double)var10, p_85094_2_ + (double)var10, p_85094_4_ + (double)entityIn.getEyeHeight() + 0.009999999776482582D, p_85094_6_ + (double)var10), 16711680);
        }

        Tessellator var16 = Tessellator.getInstance();
        WorldRenderer var14 = var16.getWorldRenderer();
        Vec3 var15 = entityIn.getLook(p_85094_9_);
        var14.startDrawing(3);
        var14.setColorOpaque_I(255);
        var14.addVertex(p_85094_2_, p_85094_4_ + (double)entityIn.getEyeHeight(), p_85094_6_);
        var14.addVertex(p_85094_2_ + var15.xCoord * 5.0D, p_85094_4_ + (double)entityIn.getEyeHeight() + var15.yCoord * 5.0D, p_85094_6_ + var15.zCoord * 5.0D);
        var16.draw();
        GlStateManager.enableTexture2D();
        //GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
	}
}
