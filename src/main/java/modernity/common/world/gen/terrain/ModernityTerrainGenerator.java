package modernity.common.world.gen.terrain;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.rgsw.MathUtil;
import net.rgsw.noise.FractalPerlin2D;
import net.rgsw.noise.FractalPerlin3D;

import modernity.api.util.EcoBlockPos;
import modernity.common.biome.BiomeBase;
import modernity.common.block.MDBlocks;
import modernity.common.world.gen.ModernityGenSettings;

import java.util.Random;

public class ModernityTerrainGenerator {
    private static final int BUFF_SIZE_X = 5;
    private static final int BUFF_SIZE_Y = 33;
    private static final int BUFF_SIZE_Z = 5;

    private final World world;
    private final long seed;
    private final Random rand;
    private final BiomeProvider provider;

    private final FractalPerlin3D noiseA;
    private final FractalPerlin3D noiseB;
    private final FractalPerlin3D mixNoise;
    private final FractalPerlin2D depthNoise;

    private final ModernityGenSettings settings;

    private final ThreadLocal<double[]> noiseBuffer = new ThreadLocal<>();

    public ModernityTerrainGenerator( World world, BiomeProvider provider, ModernityGenSettings settings ) {
        this.world = world;
        this.seed = world.getSeed();
        this.provider = provider;
        this.rand = new Random( seed );

        this.settings = settings;
        noiseA = new FractalPerlin3D( rand.nextInt(), 30, 8 );
        noiseB = new FractalPerlin3D( rand.nextInt(), 30, 8 );
        mixNoise = new FractalPerlin3D( rand.nextInt(), 6, 16 );
        depthNoise = new FractalPerlin2D( rand.nextInt(), 15, 16 );

    }

    public void generateTerrain( IChunk chunk ) {
        ChunkPos pos = chunk.getPos();
        int cx = pos.x;
        int cz = pos.z;
        fillNoiseBuffer( cx, cz );

        double[] buffer = noiseBuffer.get();

        EcoBlockPos rpos = EcoBlockPos.retain();
        for( int x4 = 0; x4 < 4; x4++ ) {
            for( int z4 = 0; z4 < 4; z4++ ) {
                for( int y8 = 0; y8 < 32; y8++ ) {
                    double noise00 = buffer[ index( x4, y8, z4 ) ];
                    double noise01 = buffer[ index( x4, y8, z4 + 1 ) ];
                    double noise10 = buffer[ index( x4 + 1, y8, z4 ) ];
                    double noise11 = buffer[ index( x4 + 1, y8, z4 + 1 ) ];

                    double delta00 = ( buffer[ index( x4, y8 + 1, z4 ) ] - noise00 ) / 8;
                    double delta01 = ( buffer[ index( x4, y8 + 1, z4 + 1 ) ] - noise01 ) / 8;
                    double delta10 = ( buffer[ index( x4 + 1, y8 + 1, z4 ) ] - noise10 ) / 8;
                    double delta11 = ( buffer[ index( x4 + 1, y8 + 1, z4 + 1 ) ] - noise11 ) / 8;

                    for( int y = 0; y < 8; y++ ) {

                        double noise0 = noise00;
                        double noise1 = noise01;

                        double delta0 = ( noise10 - noise00 ) / 4;
                        double delta1 = ( noise11 - noise01 ) / 4;

                        for( int x = 0; x < 4; x++ ) {
                            double noise = noise0;
                            double delta = ( noise1 - noise0 ) / 4;

                            for( int z = 0; z < 4; z++ ) {

                                int posx = x + x4 * 4;
                                int posy = y + y8 * 8;
                                int posz = z + z4 * 4;

                                IBlockState state = Blocks.AIR.getDefaultState();

                                if( posy < settings.getWaterLevel() ) {
                                    state = MDBlocks.MODERNIZED_WATER.getDefaultState();
                                }

                                if( noise > 0 ) {
                                    state = MDBlocks.ROCK.getDefaultState();
                                }

                                rpos.setPos( posx, posy, posz );
                                chunk.setBlockState( rpos, state, false );

                                // Change noise value by delta for interpolation
                                noise += delta;
                            }

                            // Change noise values by deltas for interpolation
                            noise0 += delta0;
                            noise1 += delta1;
                        }

                        // Change noise values by deltas for interpolation
                        noise00 += delta00;
                        noise01 += delta01;
                        noise10 += delta10;
                        noise11 += delta11;
                    }
                }
            }
        }
        rpos.release();
    }

    private void fillNoiseBuffer( int cx, int cz ) {
        double[] buff = noiseBuffer.get();
        if( buff == null ) {
            buff = new double[ BUFF_SIZE_X * BUFF_SIZE_Y * BUFF_SIZE_Z ];
            noiseBuffer.set( buff );
        }

        int r = settings.getBiomeBlendRadius();

        int max = ( 1 + r * 2 ) * ( 1 + r * 2 );

        Biome[] biomes = this.provider.getBiomes( cx * 4 - r, cz * 4 - r, 6 + r * 2, 6 + r * 2 );

        for( int x = 0; x < BUFF_SIZE_X; x++ ) {
            for( int z = 0; z < BUFF_SIZE_Z; z++ ) {

                double scale = 0;
                double depth = 0;
                double variation = 0;

                for( int x1 = - r; x1 <= r; x1++ ) {
                    for( int z1 = - r; z1 <= r; z1++ ) {
                        int bx = x1 + x + r;
                        int bz = z1 + z + r;

                        BiomeBase b = (BiomeBase) biomes[ bz * ( 6 + r * 2 ) + bx ];

                        variation += b.getHeightVar();
                        scale += b.getHeightDiff();
                        depth += b.getBaseHeight();
                    }
                }

                double depthNoise = this.depthNoise.generateMultiplied( x + cx * 4, z + cz * 4, 4 );
                if( depthNoise < 0 ) {
                    depthNoise *= - 1;
                    depthNoise /= 2;
                } else {
                    depthNoise *= 15;
                    if( depthNoise > 4 ) {
                        depthNoise = 4;
                    }
                }

                depthNoise -= 2;
                depthNoise *= - 0.25;

                scale /= max * 8;
                depth /= max * 8;
                variation /= max * 8;

                depth += depthNoise * variation;

                double minh = depth - scale;
                double maxh = depth + scale;


                for( int y = 0; y < BUFF_SIZE_Y; y++ ) {
                    // Apply height difference and height scale
                    double density = MathUtil.lerp( - 1, 1, MathUtil.invLerp( minh, maxh, y ) );

                    double a = noiseA.generateMultiplied( x + cx * 4, y, z + cz * 4, 6 );
                    double b = noiseB.generateMultiplied( x + cx * 4, y, z + cz * 4, 6 );
                    double mix = ( mixNoise.generateMultiplied( x + cx * 4, y, z + cz * 4, 4 ) + 1 ) / 2;
                    double noise = MathUtil.lerp( a, b, MathUtil.clamp( mix, 0, 1 ) ) - density;

                    buff[ index( x, y, z ) ] = noise;
                }
            }
        }
    }

    private int index( int x, int y, int z ) {
        return ( x * BUFF_SIZE_Z + z ) * BUFF_SIZE_Y + y;
    }
}
