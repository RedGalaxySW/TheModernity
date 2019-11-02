/*
 * Copyright (c) 2019 RGSW.
 * This file belongs to a separate library, made for the Modernity.
 * Licensed under the Apache Licence v2.0. Do not redistribute.
 *
 * Date: 6 - 26 - 2019
 */

package net.rgsw;

import net.rgsw.exc.InstanceOfUtilityClassException;

public final class MathUtil {

    private MathUtil() {
        throw new InstanceOfUtilityClassException();
    }

    /**
     * Interpolates value between 0 and 1 to value between a and b
     *
     * @param x Value between 0 and 1
     * @see MathUtil#unlerp(double, double, double)
     */
    public static double lerp( double a, double b, double x ) {
        return a + x * ( b - a );
    }

    /**
     * Interpolates value between 0 and 1 to value between a and b
     *
     * @param x Value between 0 and 1
     * @see MathUtil#unlerp(float, float, float)
     */
    public static float lerp( float a, float b, float x ) {
        return a + x * ( b - a );
    }

    /**
     * Interpolates value between a and b to value between 0 and 1
     *
     * @param x Value between a and b
     * @see MathUtil#lerp(double, double, double)
     */
    public static double unlerp( double a, double b, double x ) {
        return ( x - a ) / ( b - a );
    }

    /**
     * Interpolates value between a and b to value between 0 and 1
     *
     * @param x Value between a and b
     * @see MathUtil#lerp(float, float, float)
     */
    public static float unlerp( float a, float b, float x ) {
        return ( x - a ) / ( b - a );
    }

    /**
     * Applies Ken Perlin's smoothing function to a double value between 0 and 1.
     *
     * @param t The linear value (0 - 1)
     * @return The smoothed value (0 - 1)
     */
    public static double smooth( double t ) {
        return t * t * t * ( t * ( t * 6 - 15 ) + 10 );
    }

    public static double clamp( double t, double min, double max ) {
        return t < min ? min : t > max ? max : t;
    }

    public static float clamp( float t, float min, float max ) {
        return t < min ? min : t > max ? max : t;
    }

}
