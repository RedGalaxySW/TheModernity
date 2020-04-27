/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   03 - 24 - 2020
 * Author: rgsw
 */

package modernity.common.handler;

import modernity.common.advancements.MDCriteriaTriggers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public enum BlockHandler {
    INSTANCE;

    @SubscribeEvent
    public void onBreakBlock( BlockEvent.BreakEvent event ) {
        PlayerEntity player = event.getPlayer();
        if( player instanceof ServerPlayerEntity ) {
            MDCriteriaTriggers.BREAK_BLOCK.trigger(
                (ServerPlayerEntity) player,
                event.getState(),
                event.getPos(),
                player.getHeldItemMainhand()
            );
        }
    }
}