/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   02 - 29 - 2020
 * Author: rgsw
 */

package modernity.common.block.plant.growing;

import modernity.common.block.farmland.IFarmland;
import modernity.common.block.plant.CropBlock;
import modernity.common.item.MDItemTags;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class SaltyCropGrowLogic extends CropGrowLogic {
    public SaltyCropGrowLogic( CropBlock crop ) {
        super( crop );
    }

    @Override
    protected boolean isFertilizer( ItemStack stack, Random rand ) {
        return stack.getItem().isIn( MDItemTags.SALTY ) || stack.getItem().isIn( MDItemTags.LITTLE_SALTY );
    }

    @Override
    protected int getItemGrow( ItemStack stack, Random rand ) {
        if( stack.getItem().isIn( MDItemTags.SALTY ) ) {
            return 1 + rand.nextInt( 3 );
        }
        if( stack.getItem().isIn( MDItemTags.LITTLE_SALTY ) ) {
            return rand.nextInt( 2 );
        }
        return 0;
    }

    @Override
    protected GrowType checkResources( IFarmland logic, Random rand ) {
        if( logic.isDecayed() ) {
            return rand.nextInt( 2 ) == 0 ? GrowType.DIE : GrowType.NONE;
        } else if( logic.isSalty() ) {
            return GrowType.GROW;
        } else {
            return GrowType.NONE;
        }
    }

    @Override
    protected void consumeResources( IFarmland logic, Random rand ) {
        logic.decreaseLevel();
    }
}