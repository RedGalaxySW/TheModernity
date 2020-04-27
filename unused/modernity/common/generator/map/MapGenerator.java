/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 11 - 2020
 * Author: rgsw
 */

package modernity.common.generator.map;

import modernity.common.generator.map.surface.DarkrockGenerator;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.WorldGenRegion;
import net.redgalaxy.util.ILongScrambler;

import java.util.Random;

/**
 * A map generator generates a part of a large feature in a chunk. It usually generates some noise field or a cave. The
 * currently only implementation is {@link DarkrockGenerator}.
 */
public abstract class MapGenerator<D extends IMapGenData> {
    protected final IWorld world;
    protected final long seed;
    protected final Random rand;
    protected final BiomeProvider biomeGen;


    public MapGenerator( IWorld world, BiomeProvider biomeGen, ILongScrambler scrambler ) {
        this.world = world;
        this.seed = world.getSeed();
        this.rand = new Random( scrambler.scramble( world.getSeed() ) );
        this.biomeGen = biomeGen;
    }

    public MapGenerator( IWorld world, BiomeProvider biomeGen ) {
        this( world, biomeGen, ILongScrambler.lgc( 51812423440L, 2481239L ) );
    }

    public MapGenerator( IWorld world ) {
        this( world, ILongScrambler.lgc( 51812423440L, 2481239L ) );
    }

    public MapGenerator( IWorld world, ILongScrambler scrambler ) {
        this( world, null, scrambler );
    }

    /**
     * Generates the feature in the world. It must usually generate only in the main chunk of the region, but may
     * generate or read outside that chunk in some exceptional cases.
     */
    public abstract void generate( WorldGenRegion region, D data );
}