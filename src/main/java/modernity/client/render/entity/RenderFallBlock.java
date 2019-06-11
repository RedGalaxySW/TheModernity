/*
 * Copyright (c) 2019 RedGalaxy & co.
 * Licensed under the Apache Licence v2.0.
 * Do not redistribute.
 *
 * By  : RGSW
 * Date: 6 - 12 - 2019
 */

package modernity.client.render.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.data.EmptyModelData;

import modernity.common.entity.EntityFallBlock;

import java.util.Random;

public class RenderFallBlock extends Render<EntityFallBlock> {
    public RenderFallBlock( RenderManager manager ) {
        super( manager );
        System.out.println( "Created fall block renderer" );
        this.shadowSize = 0.5F;
    }

    public void doRender( EntityFallBlock entity, double x, double y, double z, float entityYaw, float partialTicks ) {
        IBlockState state = entity.getFallingTile();
        if( state.getRenderType() == EnumBlockRenderType.MODEL ) {

            World world = entity.getWorldObj();
            if( state != world.getBlockState( new BlockPos( entity ) ) ) {
                bindTexture( TextureMap.LOCATION_BLOCKS_TEXTURE );

                GlStateManager.pushMatrix();
                GlStateManager.disableLighting();

                Tessellator tess = Tessellator.getInstance();
                BufferBuilder buff = tess.getBuffer();

                if( renderOutlines ) {
                    GlStateManager.enableColorMaterial();
                    GlStateManager.enableOutlineMode( getTeamColor( entity ) );
                }

                buff.begin( 7, DefaultVertexFormats.BLOCK );

                BlockPos pos = new BlockPos( entity.posX, entity.getBoundingBox().maxY, entity.posZ );
                GlStateManager.translated( x - pos.getX() - 0.5, y - pos.getY(), z - pos.getZ() - 0.5 );

                BlockRendererDispatcher renderer = Minecraft.getInstance().getBlockRendererDispatcher();
                renderer.getBlockModelRenderer().renderModel(
                        world,
                        renderer.getModelForState( state ),
                        state, pos, buff,
                        false, new Random(),
                        MathHelper.getPositionRandom( pos ),
                        EmptyModelData.INSTANCE
                );

                tess.draw();

                if( renderOutlines ) {
                    GlStateManager.disableOutlineMode();
                    GlStateManager.disableColorMaterial();
                }

                GlStateManager.enableLighting();
                GlStateManager.popMatrix();
                super.doRender( entity, x, y, z, entityYaw, partialTicks );
            }
        }
    }

    protected ResourceLocation getEntityTexture( EntityFallBlock entity ) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}