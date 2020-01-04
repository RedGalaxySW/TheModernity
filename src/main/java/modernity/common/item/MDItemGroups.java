/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 04 - 2020
 * Author: rgsw
 */

package modernity.common.item;

import modernity.common.block.MDBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Holder class for Modernity creative tabs.
 */
public final class MDItemGroups {
    public static final ItemGroup BLOCKS = new ItemGroup( "modernity.blocks" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.blocks";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDBlocks.MURKY_GRASS_BLOCK.asItem() );
        }
    };
    public static final ItemGroup DECORATIVES = new ItemGroup( "modernity.decoratives" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.decoratives";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDBlocks.LIGHTROCK_TORCH.asItem() );
        }
    };
    public static final ItemGroup MISC = new ItemGroup( "modernity.misc" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.misc";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDItems.ALUMINIUM_INGOT );
        }
    };
    public static final ItemGroup PLANTS = new ItemGroup( "modernity.plants" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.plants";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDBlocks.MINT_PLANT.asItem() );
        }
    };
    public static final ItemGroup COMBAT = new ItemGroup( "modernity.combat" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.combat";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDItems.ALUMINIUM_SWORD );
        }
    };
    public static final ItemGroup TOOLS = new ItemGroup( "modernity.tools" ) {
        @Override
        public String getTranslationKey() {
            return "itemgroup.modernity.tools";
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack( MDItems.ALUMINIUM_PICKAXE );
        }
    };

    private MDItemGroups() {
    }
}
