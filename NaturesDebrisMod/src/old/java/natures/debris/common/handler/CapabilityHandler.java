/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.handler;

import natures.debris.common.capability.MDCapabilities;
import natures.debris.common.capability.WorldAreaCapability;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public enum CapabilityHandler {
    INSTANCE;

    @SubscribeEvent
    public void attachWorldCaps(AttachCapabilitiesEvent<World> event) {
        World world = event.getObject();
        if (world instanceof ServerWorld) {
            event.addCapability(MDCapabilities.WORLD_AREAS_RES, new WorldAreaCapability.Provider(world));
        }
    }
}