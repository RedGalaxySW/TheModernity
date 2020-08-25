/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.generator.decorate.count;

import net.minecraft.world.IWorld;

import java.util.Random;

public class Add implements IDecorCount {
    private final IDecorCount a;
    private final IDecorCount b;

    public Add(IDecorCount a, IDecorCount b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int count(IWorld world, int cx, int cz, Random rand) {
        return a.count(world, cx, cz, rand) + b.count(world, cx, cz, rand);
    }
}