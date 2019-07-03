/*
 * Copyright (c) 2019 RedGalaxy & co.
 * Licensed under the Apache Licence v2.0.
 * Do not redistribute.
 *
 * By  : RGSW
 * Date: 6 - 29 - 2019
 */

package modernity.common.block.base;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import modernity.api.block.IParticleShapeBlock;
import modernity.api.util.MDVoxelShapes;
import modernity.common.tileentity.TileEntityNetherAltar;
import modernity.common.util.ContainerManager;

import javax.annotation.Nullable;

public class BlockNetherAltar extends BlockNoDrop implements IParticleShapeBlock {
    private static final VoxelShape ALTAR_SHAPE;
    private static final VoxelShape SIMPLE_SHAPE = MDVoxelShapes.create16( 0, 0, 0, 16, 12, 16 );

    static {
        VoxelShape obsidian = MDVoxelShapes.create16( 1, 1, 1, 15, 11, 15 );
        VoxelShape corner1 = MDVoxelShapes.create16( 0, - 1, 0, 2, 12, 2 );
        VoxelShape corner2 = MDVoxelShapes.create16( 0, - 1, 14, 2, 12, 16 );
        VoxelShape corner3 = MDVoxelShapes.create16( 14, - 1, 14, 16, 12, 16 );
        VoxelShape corner4 = MDVoxelShapes.create16( 14, - 1, 0, 16, 12, 2 );
        VoxelShape edge1 = MDVoxelShapes.create16( 2, 10, 0, 14, 12, 2 );
        VoxelShape edge2 = MDVoxelShapes.create16( 2, 10, 14, 14, 12, 16 );
        VoxelShape edge3 = MDVoxelShapes.create16( 0, 10, 2, 2, 12, 14 );
        VoxelShape edge4 = MDVoxelShapes.create16( 14, 10, 2, 16, 12, 14 );
        VoxelShape bricks = MDVoxelShapes.create16( 3, 10.25, 3, 13, 11.25, 13 );
        VoxelShape netherrack1 = MDVoxelShapes.create16( 0, 0, 2, 1, 1, 14 );
        VoxelShape netherrack2 = MDVoxelShapes.create16( 15, 0, 2, 16, 1, 14 );
        VoxelShape netherrack3 = MDVoxelShapes.create16( 2, 0, 0, 14, 1, 1 );
        VoxelShape netherrack4 = MDVoxelShapes.create16( 2, 0, 15, 14, 1, 16 );
        VoxelShape sand1 = MDVoxelShapes.create16( - 1, - 1, - 1, 3, 2, 3 );
        VoxelShape sand2 = MDVoxelShapes.create16( - 1, - 1, 13, 3, 2, 17 );
        VoxelShape sand3 = MDVoxelShapes.create16( 13, - 1, 13, 17, 2, 17 );
        VoxelShape sand4 = MDVoxelShapes.create16( 13, - 1, - 1, 17, 2, 3 );
        VoxelShape glowstone = MDVoxelShapes.create16( 6, 11, 6, 10, 13, 10 );

        VoxelShape s = obsidian;
        s = VoxelShapes.combineAndSimplify( s, corner1, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, corner2, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, corner3, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, corner4, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, edge1, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, edge2, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, edge3, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, edge4, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, bricks, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, netherrack1, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, netherrack2, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, netherrack3, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, netherrack4, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, sand1, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, sand2, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, sand3, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, sand4, IBooleanFunction.OR );
        s = VoxelShapes.combineAndSimplify( s, glowstone, IBooleanFunction.OR );
        ALTAR_SHAPE = s;
    }

    public BlockNetherAltar( String id, Properties properties, Item.Properties itemProps ) {
        super( id, properties, itemProps );
    }

    @Override
    public boolean isFullCube( IBlockState state ) {
        return false;
    }

    @Override
    public VoxelShape getShape( IBlockState state, IBlockReader world, BlockPos pos ) {
        return ALTAR_SHAPE;
    }

    @Override
    public VoxelShape getParticleShape( IBlockState state, IBlockReader world, BlockPos pos ) {
        return SIMPLE_SHAPE;
    }

    @Override
    public boolean onBlockActivated( IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ ) {
        if( ! world.isRemote ) {
            TileEntity te = world.getTileEntity( pos );
            if( te instanceof TileEntityNetherAltar ) {
                ContainerManager.openContainer( player, (TileEntityNetherAltar) te );
            }
        }
        return true;
    }

    @Override
    public boolean hasTileEntity( IBlockState state ) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity( IBlockState state, IBlockReader world ) {
        return new TileEntityNetherAltar();
    }
}