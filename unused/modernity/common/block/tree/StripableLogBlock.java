/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 25 - 2020
 * Author: rgsw
 */

package modernity.common.block.tree;

import modernity.common.block.base.AxisBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Describes an orientable block that can be stripped with an axe.
 */
public class StripableLogBlock extends AxisBlock {
    private final Supplier<AxisBlock> result;

    public StripableLogBlock( Supplier<AxisBlock> result, Properties properties ) {
        super( properties );
        this.result = result;
    }

    @Override
    public ActionResultType onBlockActivated( BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rtr ) {
        if( player.getHeldItem( hand ).getItem() instanceof AxeItem ) {
            player.getHeldItem( hand ).damageItem( 1, player, e -> {} );
            world.setBlockState( pos, result.get().getDefaultState().with( AXIS, state.get( AXIS ) ) );
            world.playSound( pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1, 1, false );
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
}