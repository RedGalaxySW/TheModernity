/*
 * Copyright (c) 2019 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   12 - 22 - 2019
 * Author: rgsw
 */

package modernity.common.generator.decorate.position;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import java.util.Random;

public class Root implements IDecorPosition {

    private final int y;

    public Root( int y ) {
        this.y = y;
    }

    @Override
    public BlockPos findPosition( IWorld world, int cx, int cz, Random rand ) {
        return new BlockPos( 0, 0, 0 );
    }
}