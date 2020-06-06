/*
 * Copyright (c) 2019 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   11 - 14 - 2019
 * Author: rgsw
 */

package modernity.client.render.area;

import modernity.common.area.core.Area;
import net.minecraft.world.World;

@FunctionalInterface
public interface IAreaRenderer<A extends Area> {
    void render( World world, A area, double x, double y, double z, float partialTicks );
}