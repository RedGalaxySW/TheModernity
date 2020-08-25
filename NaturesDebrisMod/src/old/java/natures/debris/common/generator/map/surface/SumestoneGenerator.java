/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.generator.map.surface;

import natures.debris.common.blockold.MDNatureBlocks;
import natures.debris.common.generator.map.LayerDepositGenerator;
import natures.debris.generic.util.MovingBlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.WorldGenRegion;

public class SumestoneGenerator extends LayerDepositGenerator<SurfaceGenData> {
    public SumestoneGenerator(IWorld world) {
        super(world, -1, 18, 8);
    }

    @Override
    protected void place(WorldGenRegion region, MovingBlockPos pos, SurfaceGenData data) {
        if (region.getBlockState(pos).getMaterial().blocksMovement()) {
            region.setBlockState(pos, MDNatureBlocks.SUMESTONE.getDefaultState(), 2);
        }
    }
}