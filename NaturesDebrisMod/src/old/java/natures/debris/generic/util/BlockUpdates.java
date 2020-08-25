/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.generic.util;

import modernity.api.util.exc.InstanceOfUtilityClassException;
import net.minecraft.world.IWorldWriter;

/**
 * Holder class for {@link IWorldWriter#setBlockState} flags
 */
public final class BlockUpdates {
    public static final int CAUSE_UPDATE = 1;
    public static final int NOTIFY_CLIENTS = 2;
    public static final int NO_RENDER = 4;
    public static final int FORCE_RENDER = 8;
    public static final int NO_NEIGHBOR_REACTIONS = 16;
    public static final int NO_NEIGHBOR_DROPS = 32;
    public static final int MOVING = 64;

    private BlockUpdates() {
        throw new InstanceOfUtilityClassException("No BlockUpdates instances for you!");
    }
}