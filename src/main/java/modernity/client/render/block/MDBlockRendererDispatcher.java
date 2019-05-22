package modernity.client.render.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.fluid.IFluidState;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.pipeline.ForgeBlockModelRenderer;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.VanillaResourceType;

import java.util.Random;

public class MDBlockRendererDispatcher extends BlockRendererDispatcher {
    private final BlockModelShapes blockModelShapes;
    private final BlockModelRenderer blockModelRenderer;
    private final ChestRenderer chestRenderer = new ChestRenderer();
    private final MDFluidRenderer fluidRenderer;
    private final Random random = new Random();

    public MDBlockRendererDispatcher( BlockModelShapes bms, BlockColors colors ) {
        super( bms, colors );
        this.blockModelShapes = bms;
        this.blockModelRenderer = new ForgeBlockModelRenderer( colors );
        this.fluidRenderer = new MDFluidRenderer();
    }

    public BlockModelShapes getBlockModelShapes() {
        return this.blockModelShapes;
    }

    public void renderBlockDamage( IBlockState state, BlockPos pos, TextureAtlasSprite texture, IWorldReader blockAccess ) {
        if( state.getRenderType() == EnumBlockRenderType.MODEL ) {
            IBakedModel ibakedmodel = this.blockModelShapes.getModel( state );
            long i = state.getPositionRandom( pos );
            IBakedModel ibakedmodel1 = ForgeHooksClient.getDamageModel( ibakedmodel, texture, state, blockAccess, pos );
            this.blockModelRenderer.renderModel( blockAccess, ibakedmodel1, state, pos, Tessellator.getInstance().getBuffer(), true, this.random, i );
        }
    }

    @Deprecated
    public boolean renderBlock( IBlockState state, BlockPos pos, IWorldReader world, BufferBuilder buff, Random rand ) {
        return renderBlock( state, pos, world, buff, rand, EmptyModelData.INSTANCE );
    }

    public boolean renderBlock( IBlockState state, BlockPos pos, IWorldReader world, BufferBuilder buff, Random rand, IModelData modelData ) {
        try {
            EnumBlockRenderType enumblockrendertype = state.getRenderType();
            if( enumblockrendertype == EnumBlockRenderType.INVISIBLE ) {
                return false;
            } else {
                switch( enumblockrendertype ) {
                    case MODEL:
                        return this.blockModelRenderer.renderModel( world, this.getModelForState( state ), state, pos, buff, true, rand, state.getPositionRandom( pos ), modelData );
                    case ENTITYBLOCK_ANIMATED:
                        return false;
                    default:
                        return false;
                }
            }
        } catch( Throwable exc ) {
            CrashReport report = CrashReport.makeCrashReport( exc, "Tesselating block in world" );
            CrashReportCategory category = report.makeCategory( "Block being tesselated" );
            CrashReportCategory.addBlockInfo( category, pos, state );
            throw new ReportedException( report );
        }
    }

    public boolean renderFluid( BlockPos pos, IWorldReader world, BufferBuilder buff, IFluidState state ) {
        try {
            return this.fluidRenderer.render( world, pos, buff, state );
        } catch( Throwable exc ) {
            CrashReport report = CrashReport.makeCrashReport( exc, "Tesselating liquid in world" );
            CrashReportCategory category = report.makeCategory( "Block being tesselated" );
            CrashReportCategory.addBlockInfo( category, pos, null );
            throw new ReportedException( report );
        }
    }

    public BlockModelRenderer getBlockModelRenderer() {
        return this.blockModelRenderer;
    }

    public IBakedModel getModelForState( IBlockState state ) {
        return this.blockModelShapes.getModel( state );
    }

    public void renderBlockBrightness( IBlockState state, float brightness ) {
        EnumBlockRenderType enumblockrendertype = state.getRenderType();
        if( enumblockrendertype != EnumBlockRenderType.INVISIBLE ) {
            switch( enumblockrendertype ) {
                case MODEL:
                    IBakedModel ibakedmodel = this.getModelForState( state );
                    this.blockModelRenderer.renderModelBrightness( ibakedmodel, state, brightness, true );
                    break;
                case ENTITYBLOCK_ANIMATED:
                    this.chestRenderer.renderChestBrightness( state.getBlock(), brightness );
            }

        }
    }

    public void onResourceManagerReload( IResourceManager resourceManager ) {
        this.fluidRenderer.initAtlasSprites();
    }

    @Override
    public IResourceType getResourceType() {
        return VanillaResourceType.MODELS;
    }
}