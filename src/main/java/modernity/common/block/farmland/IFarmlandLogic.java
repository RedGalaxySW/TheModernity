/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 18 - 2020
 * Author: rgsw
 */

package modernity.common.block.farmland;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public interface IFarmlandLogic {
    int useFertility( int amount );
    int useSaltiness( int amount );

    boolean addFertility( int amount );
    boolean addSaltiness( int amount );

    void flood();
    void unflood( int amount );
    void dryout( int amount );

    int decay( int amount );
    int undecay( int amount );

    boolean isFertile( int amount );
    boolean isSalty( int amount );
    boolean isDecayed( int amount );
    boolean isFlooded( int amount );

    boolean isFertile();
    boolean isSalty();
    boolean isDecayed();
    boolean isFlooded();
    boolean isWet();
    boolean isWetOrFlooded();
    boolean isDry();

    int getFertility();
    int getWetness();
    int getDecay();
    int getSaltiness();
    int getMaxFertility();
    int getMaxDecay();
    int getMaxSaltiness();
    int getMaxFloodedUpdates();

    static IFarmlandLogic get( World world, BlockPos pos ) {
        TileEntity te = world.getTileEntity( pos );
        if( te instanceof IFarmlandLogic ) {
            return (IFarmlandLogic) te;
        }
        return null;
    }

    static Optional<IFarmlandLogic> opt( World world, BlockPos pos ) {
        return Optional.ofNullable( get( world, pos ) );
    }
}
