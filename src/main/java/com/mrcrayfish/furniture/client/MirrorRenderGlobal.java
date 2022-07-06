package com.mrcrayfish.furniture.client;

import com.mrcrayfish.furniture.handler.ConfigurationHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MirrorRenderGlobal extends RenderGlobal
{
    public MirrorRenderGlobal(Minecraft mcIn)
    {
        super(mcIn);
    }

    private WorldClient nextWorld;
    private boolean first = true;
    public void updateWorldLoad(WorldClient wc) {
        if (first) {
            this.setWorldAndLoadRenderers(wc);
            first = false;
        } else {
            this.nextWorld = wc;
        }
    }

    public void updateWorldUnload() {
        this.setWorldAndLoadRenderers(nextWorld);
        if (nextWorld == null) first = true;
        nextWorld = null;
    }

    @Override
    public void renderClouds(float partialTicks, int pass, double p_180447_3_, double p_180447_5_, double p_180447_7_)
    {
        if(ConfigurationHandler.mirrorClouds)
            super.renderClouds(partialTicks, pass, p_180447_3_, p_180447_5_, p_180447_7_);
    }

    @Override
    public void playRecord(SoundEvent soundIn, BlockPos pos)
    {
    }

    @Override
    public void playSoundToAllNearExcept(EntityPlayer player, SoundEvent soundIn, SoundCategory category, double x, double y, double z, float volume, float pitch)
    {
    }

    @Override
    public void broadcastSound(int soundID, BlockPos pos, int data)
    {
    }

    @Override
    public void playEvent(EntityPlayer player, int type, BlockPos blockPosIn, int data)
    {
    }
}
