/*
 * Copyright (c) 2019 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   12 - 15 - 2019
 * Author: rgsw
 */

package net.rgsw.noise;

/**
 * 3D Perlin noise generator.
 */
public class Perlin3D extends Noise3D {

    /**
     * Constructs a Perlin noise generator
     *
     * @param seed The seed, may be any {@link int}
     */
    public Perlin3D( int seed ) {
        super( seed );
    }

    /**
     * Constructs a Perlin noise generator
     *
     * @param seed  The seed, may be any {@link int}
     * @param scale The coordinate scaling along all axes
     */
    public Perlin3D( int seed, double scale ) {
        super( seed, scale );
    }

    /**
     * Constructs a Perlin noise generator
     *
     * @param seed   The seed, may be any {@link int}
     * @param scaleX The coordinate scaling along X axis
     * @param scaleY The coordinate scaling along Y axis
     * @param scaleZ The coordinate scaling along Z axis
     */
    public Perlin3D( int seed, double scaleX, double scaleY, double scaleZ ) {
        super( seed, scaleX, scaleY, scaleZ );
    }

    private static final int[][] GRAD = {
        { - 1, - 1, 0 }, { - 1, 1, 0 }, { 1, - 1, 0 }, { 1, 1, 0 },
        { - 1, 0, - 1 }, { - 1, 0, 1 }, { 1, 0, - 1 }, { 1, 0, 1 },
        { 0, - 1, - 1 }, { 0, 1, - 1 }, { 0, - 1, 1 }, { 0, 1, 1 },
        { - 1, - 1, 0 }, { - 1, 1, 0 }, { 1, - 1, 0 }, { 1, 1, 0 },
        { - 1, 0, - 1 }, { - 1, 0, 1 }, { 1, 0, - 1 }, { 1, 0, 1 },
        { 0, - 1, - 1 }, { 0, 1, - 1 }, { 0, - 1, 1 }, { 0, 1, 1 },
        { - 1, - 1, 0 }, { - 1, 1, 0 }, { 1, - 1, 0 }, { 1, 1, 0 },
        { - 1, 0, - 1 }, { - 1, 0, 1 }, { 1, 0, - 1 }, { 1, 0, 1 }
    };

    private int gradIndex( int x, int y, int z ) {
        int hash = Hash.hash3I( this.seed, x, y, z );
        return hash & 31;
    }

    private double lerp( double a, double b, double x ) {
        return a + x * ( b - a );
    }

    private static double smooth( double t ) {
        return t * t * t * ( t * ( t * 6 - 15 ) + 10 );
    }

    private static int fastfloor( double v ) {
        int d = v < 0 ? - 1 : 0;
        return (int) v + d;
    }

    @Override
    public double generate( double x, double y, double z ) {
        x /= this.scaleX;
        y /= this.scaleY;
        z /= this.scaleZ;

        int minx = fastfloor( x );
        int miny = fastfloor( y );
        int minz = fastfloor( z );
        int maxx = minx + 1;
        int maxy = miny + 1;
        int maxz = minz + 1;
        double smoothx = smooth( x - minx );
        double smoothy = smooth( y - miny );
        double smoothz = smooth( z - minz );


        int idx1 = this.gradIndex( minx, miny, minz );
        int idx2 = this.gradIndex( maxx, miny, minz );
        int idx3 = this.gradIndex( minx, maxy, minz );
        int idx4 = this.gradIndex( maxx, maxy, minz );
        int idx5 = this.gradIndex( minx, miny, maxz );
        int idx6 = this.gradIndex( maxx, miny, maxz );
        int idx7 = this.gradIndex( minx, maxy, maxz );
        int idx8 = this.gradIndex( maxx, maxy, maxz );

        int[] grad1 = GRAD[ idx1 ];
        int[] grad2 = GRAD[ idx2 ];
        int[] grad3 = GRAD[ idx3 ];
        int[] grad4 = GRAD[ idx4 ];
        int[] grad5 = GRAD[ idx5 ];
        int[] grad6 = GRAD[ idx6 ];
        int[] grad7 = GRAD[ idx7 ];
        int[] grad8 = GRAD[ idx8 ];

        double dist11 = x - minx;
        double dist12 = y - miny;
        double dist13 = z - minz;
        double dist21 = x - maxx;
        double dist22 = y - miny;
        double dist23 = z - minz;
        double dist31 = x - minx;
        double dist32 = y - maxy;
        double dist33 = z - minz;
        double dist41 = x - maxx;
        double dist42 = y - maxy;
        double dist43 = z - minz;
        double dist51 = x - minx;
        double dist52 = y - miny;
        double dist53 = z - maxz;
        double dist61 = x - maxx;
        double dist62 = y - miny;
        double dist63 = z - maxz;
        double dist71 = x - minx;
        double dist72 = y - maxy;
        double dist73 = z - maxz;
        double dist81 = x - maxx;
        double dist82 = y - maxy;
        double dist83 = z - maxz;

        double dot1 = dist11 * grad1[ 0 ] + dist12 * grad1[ 1 ] + dist13 * grad1[ 2 ];
        double dot2 = dist21 * grad2[ 0 ] + dist22 * grad2[ 1 ] + dist23 * grad2[ 2 ];
        double dot3 = dist31 * grad3[ 0 ] + dist32 * grad3[ 1 ] + dist33 * grad3[ 2 ];
        double dot4 = dist41 * grad4[ 0 ] + dist42 * grad4[ 1 ] + dist43 * grad4[ 2 ];
        double dot5 = dist51 * grad5[ 0 ] + dist52 * grad5[ 1 ] + dist53 * grad5[ 2 ];
        double dot6 = dist61 * grad6[ 0 ] + dist62 * grad6[ 1 ] + dist63 * grad6[ 2 ];
        double dot7 = dist71 * grad7[ 0 ] + dist72 * grad7[ 1 ] + dist73 * grad7[ 2 ];
        double dot8 = dist81 * grad8[ 0 ] + dist82 * grad8[ 1 ] + dist83 * grad8[ 2 ];

        double lerp12 = this.lerp( dot1, dot2, smoothx );
        double lerp34 = this.lerp( dot3, dot4, smoothx );
        double lerp1234 = this.lerp( lerp12, lerp34, smoothy );
        double lerp56 = this.lerp( dot5, dot6, smoothx );
        double lerp78 = this.lerp( dot7, dot8, smoothx );
        double lerp5678 = this.lerp( lerp56, lerp78, smoothy );

        return this.lerp( lerp1234, lerp5678, smoothz );
    }
}