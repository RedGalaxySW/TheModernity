/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.generator.surface;

import natures.debris.common.biome.ModernityBiome;
import natures.debris.common.blockold.MDNatureBlocks;
import natures.debris.generic.util.MovingBlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.IChunk;
import net.rgsw.noise.INoise3D;

import java.util.Random;

/**
 * Surface generator that generates a basic grass surface, with mud underwater.
 */
public class GrassSurfaceGenerator implements ISurfaceGenerator {

    private static final BlockState GRASS = MDNatureBlocks.MURKY_GRASS_BLOCK.getDefaultState();
    private static final BlockState DIRT = MDNatureBlocks.MURKY_DIRT.getDefaultState();
    private static final BlockState MUD = MDNatureBlocks.MUD.getDefaultState();

    @Override
    public void buildSurface(IChunk chunk, int cx, int cz, int x, int z, Random rand, ModernityBiome biome, INoise3D surfaceNoise, MovingBlockPos rpos) {
        int ctrl = 0;
        BlockState secondLayers = null;
        for (int y = 255; y >= 0; y--) {
            rpos.setPos(x, y, z);
            if (ctrl >= 0 && !chunk.getBlockState(rpos).getMaterial().blocksMovement()) {
                ctrl = -1;
            } else if (ctrl == -1 && chunk.getBlockState(rpos).getMaterial().blocksMovement()) {
                ctrl = (int) (3 + 2 * surfaceNoise.generate(x + cx * 16, y, z + cz * 16));
                boolean underwater = y < 71;
                chunk.setBlockState(rpos, underwater ? MUD : GRASS, false);
                secondLayers = underwater ? MUD : DIRT;
            } else if (ctrl > 0) {
                ctrl--;
                chunk.setBlockState(rpos, secondLayers, false);
            }
        }
    }
}