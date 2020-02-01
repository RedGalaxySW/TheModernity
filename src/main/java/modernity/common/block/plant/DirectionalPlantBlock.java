/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   02 - 01 - 2020
 * Author: rgsw
 */

package modernity.common.block.plant;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public abstract class DirectionalPlantBlock extends PlantBlock {
    protected final Direction growDir;

    public DirectionalPlantBlock( Properties properties, Direction growDir ) {
        super( properties );
        this.growDir = growDir;
    }

    public boolean canBlockSustain( IWorldReader world, BlockPos pos, BlockState state ) {
        return isBlockSideSustainable( state, world, pos, growDir );
    }

    public boolean canRemainOn( IWorldReader world, BlockPos pos, BlockState state, BlockState selfState ) {
        return canBlockSustain( world, pos, state );
    }

    @Override
    public boolean canRemain( IWorldReader world, BlockPos pos, BlockState state, Direction dir, BlockPos adj, BlockState adjState ) {
        if( dir.getOpposite() == growDir ) {
            return canRemainOn( world, adj, adjState, state );
        }
        return true;
    }

    public Direction getGrowDirection() {
        return growDir;
    }
}
