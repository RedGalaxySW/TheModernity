/*
 * Copyright (c) 2018 Red Galaxy Software.
 * Licensed under Apache License 2.0.
 *
 * By  : RgSW
 * Date: 1 - 15 - 2019
 */

package net.rgsw.noise;

import net.rgsw.MathUtil;

public abstract class Noise2D {
    protected final int seed;
    protected final double scaleX;
    protected final double scaleY;

    public Noise2D( int seed ) {
        this.seed = seed;
        this.scaleX = 1;
        this.scaleY = 1;
    }

    public Noise2D( int seed, double scale ) {
        this.seed = seed;
        this.scaleX = scale;
        this.scaleY = scale;
    }

    public Noise2D( int seed, double scaleX, double scaleY ) {
        this.seed = seed;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public abstract double generate( double x, double y );

    public double generateMultiplied( double x, double y, double mult ) {
        return generate( x, y ) * mult;
    }

    public double generateInRange( double x, double y, double min, double max ) {
        return MathUtil.lerp( min, max, ( generate( x, y ) + 1 ) / 2 );
    }

    public double generate( int x, int y ) {
        return this.generate( (double) x, (double) y );
    }
}
