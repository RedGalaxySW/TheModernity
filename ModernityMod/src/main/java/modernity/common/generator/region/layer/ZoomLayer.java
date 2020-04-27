/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   03 - 04 - 2020
 * Author: rgsw
 */

package modernity.common.generator.region.layer;

import modernity.common.generator.region.IRegion;
import modernity.common.generator.region.IRegionContext;
import modernity.common.generator.region.IRegionFactory;
import modernity.common.generator.region.IRegionRNG;

/**
 * Transformation layer that zooms in on another layer with a ratio of 2:1.
 */
public class ZoomLayer implements ITransformerLayer {
    public static final ZoomLayer INSTANCE = new ZoomLayer();

    protected ZoomLayer() {
    }

    @Override
    public int generate( IRegionRNG rng, IRegion region, int x, int z ) {
        int lx = x >> 1;
        int lz = z >> 1;

        int sx = x & 1;
        int sz = z & 1;

        rng.setPosition( x >> 1 << 1, z >> 1 << 1 );

        // +   +
        //
        // *   +
        int v00 = region.getValue( lx, lz );
        if( sx == 0 && sz == 0 ) return v00;

        // +   +
        // *
        // +   +
        int v01 = region.getValue( lx, lz + 1 );
        if( sx == 0 ) return rng.pickRandom( v00, v01 );

        // +   +
        //
        // + * +
        int v10 = region.getValue( lx + 1, lz );
        if( sz == 0 ) return rng.pickRandom( v00, v10 );

        // +   +
        //   *
        // +   +
        int v11 = region.getValue( lx + 1, lz + 1 );
        return pickRandom( rng, v00, v01, v10, v11 );
    }

    protected int pickRandom( IRegionRNG rng, int v00, int v01, int v10, int v11 ) {
        // 01   11
        //    ?
        // 00   10
        if( v00 == v01 && v00 == v10 && v00 == v11 ) {
            // *   *
            //   *
            // *   *
            return v00;
        } else if( v11 == v01 && v11 == v10 ) {
            // *   *
            //   *
            // -   *
            return v11;
        } else if( v00 == v10 && v00 == v01 ) {
            // *   -
            //   *
            // *   *
            return v00;
        } else if( v10 == v00 && v10 == v11 ) {
            // -   *
            //   *
            // *   *
            return v00;
        } else if( v01 == v00 && v01 == v11 ) {
            // *   *
            //   *
            // *   -
            return v00;
        } else if( v00 == v10 && v01 != v11 ) {
            // +   -
            //   *
            // *   *
            return v00;
        } else if( v00 == v01 && v10 != v11 ) {
            // *   -
            //   *
            // *   +
            return v00;
        } else if( v00 == v11 && v10 != v01 ) {
            // -   *
            //   *
            // *   +
            return v00;
        } else if( v10 == v01 && v00 != v11 ) {
            // *   +
            //   *
            // -   *
            return v10;
        } else if( v10 == v11 && v00 != v01 ) {
            // +   *
            //   *
            // -   *
            return v10;
        } else if( v01 == v11 && v00 != v10 ) {
            // *   *
            //   *
            // -   +
            return v01;
        } else if( v00 == v11 ) {
            // -   *
            //   ?
            // *   -
            return rng.pickRandom( v00, v10 );
        } else if( v00 == v01 ) {
            // *   -
            //   ?
            // *   -
            return rng.pickRandom( v00, v10 );
        } else if( v00 == v10 ) {
            // -   -
            //   ?
            // *   *
            return rng.pickRandom( v00, v01 );
        } else {
            // *   +
            //   ?
            // -   x
            return rng.pickRandom( v00, v10, v01, v11 );
        }
    }

    public <R extends IRegion> IRegionFactory<R> magnify( IRegionContext<R> ctx, long seed, IRegionFactory<R> factory, int amount ) {
        for( int i = 0; i < amount; i++ ) {
            factory = factory( ctx, seed, factory );
            seed = seed * 1277 + 73 & 0xFFFF;
        }
        return factory;
    }
}