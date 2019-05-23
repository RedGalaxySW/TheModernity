package modernity.api.util;

import net.minecraft.util.math.MathHelper;

public class ColorUtil {
    public static int rgb( int r, int g, int b ) {
        return r << 16 | g << 8 | b;
    }

    public static int rgb( double r, double g, double b ) {
        return rgb( (int) ( r * 255 ), (int) ( g * 255 ), (int) ( b * 255 ) );
    }

    public static int hsv( double h, double s, double v ) {
        h = h < 0 ? h % 360 + 360 : h % 360;
        double r, g, b;
        if( s == 0 ) r = g = b = v;
        else {
            int hi = MathHelper.fastFloor( h / 60 );
            double f = h / 60 - hi;
            double p = v * ( 1 - s );
            double q = v * ( 1 - s * f );
            double t = v * ( 1 - s * ( 1 - f ) );

            switch( hi ) {
                default:
                case 0:
                    r = v; g = t; b = p; break;
                case 1:
                    r = q; g = v; b = p; break;
                case 2:
                    r = p; g = v; b = t; break;
                case 3:
                    r = p; g = q; b = v; break;
                case 4:
                    r = t; g = p; b = v; break;
                case 5:
                    r = v; g = p; b = q; break;
            }
        }
        return rgb( r, g, b );
    }

    public static int darken( int col, double amount ) {
        if( amount < 0 ) return lighten( col, - amount );
        int r = col >>> 16 & 0xff;
        int g = col >>> 8 & 0xff;
        int b = col & 0xff;

        r = (int) ( r * ( 1 - amount ) );
        g = (int) ( g * ( 1 - amount ) );
        b = (int) ( b * ( 1 - amount ) );

        return rgb( r, g, b );
    }

    public static int lighten( int col, double amount ) {
        if( amount < 0 ) return darken( col, - amount );
        int r = col >>> 16 & 0xff;
        int g = col >>> 8 & 0xff;
        int b = col & 0xff;

        r = 255 - r;
        g = 255 - g;
        b = 255 - b;

        r = (int) ( r * ( 1 - amount ) );
        g = (int) ( g * ( 1 - amount ) );
        b = (int) ( b * ( 1 - amount ) );

        return rgb( 255 - r, 255 - g, 255 - b );
    }

    public static int inverse( int col ) {
        return 0xffffff - col;
    }
}