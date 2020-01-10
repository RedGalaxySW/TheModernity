/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 11 - 2020
 * Author: rgsw
 */

package modernity.common.generator.map;

import net.minecraft.world.gen.WorldGenRegion;

public class CompoundGenerator<D extends IMapGenData> extends MapGenerator<D> {
    private final MapGenerator<D> base;
    private final MapGenerator<D>[] mapGens;

    @SafeVarargs
    public CompoundGenerator( MapGenerator<D> base, MapGenerator<D>... mapGens ) {
        super( check( base ).world, base.biomeGen );
        if( mapGens == null ) throw new NullPointerException( "Map gen array is null" );
        for( MapGenerator<D> gen : mapGens ) {
            if( gen == null ) throw new NullPointerException( "Map gen array contains null elements" );
        }
        this.base = base;
        this.mapGens = mapGens;
    }

    @Override
    public void generate( WorldGenRegion region, D data ) {
        base.generate( region, data );
        for( MapGenerator<D> gen : mapGens ) {
            gen.generate( region, data );
        }
    }

    private static <D extends IMapGenData> MapGenerator<D> check( MapGenerator<D> gen ) {
        if( gen == null ) throw new NullPointerException( "Base generator is null" );
        return gen;
    }
}
