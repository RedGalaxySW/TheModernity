/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.blockold.plant;

import natures.debris.common.blockold.MDBlockStateProperties;
import natures.debris.common.blockold.MDBlockTags;
import natures.debris.common.blockold.plant.growing.TallGrassGrowLogic;
import natures.debris.generic.block.IColoredBlock;
import natures.debris.generic.block.IReceiveFertilityFromFloorBlock;
import natures.debris.generic.util.MDVoxelShapes;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.ILightReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class TallMurkGrassBlock extends LimitedTallDirectionalPlantBlock implements IColoredBlock, IReceiveFertilityFromFloorBlock {

    public static final VoxelShape GRASS_END_SHAPE = MDVoxelShapes.create16(2, 0, 2, 14, 10, 14);
    public static final VoxelShape GRASS_MIDDLE_SHAPE = MDVoxelShapes.create16(2, 0, 2, 14, 16, 14);

    public static final IntegerProperty LENGTH = MDBlockStateProperties.LENGTH_1_4;

    private final TallGrassGrowLogic logic;

    public TallMurkGrassBlock(Properties properties) {
        super(properties, Direction.UP);
        setGrowLogic(logic = new TallGrassGrowLogic(this));
    }


    @Override
    public boolean canBlockSustain(IWorldReader world, BlockPos pos, BlockState state) {
        return state.isIn(MDBlockTags.DIRTLIKE);
    }

    @Override
    public IntegerProperty getLengthProperty() {
        return LENGTH;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int colorMultiplier(BlockState state, @Nullable ILightReader reader, @Nullable BlockPos pos, int tintIndex) {
        return 0;
//        return ModernityClient.get().getGrassColors().getColor( reader, pos );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return 0;
//        return ModernityClient.get().getGrassColors().getItemColor();
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isReplaceable(BlockState state, BlockItemUseContext ctx) {
        return ctx.getItem().getItem() != asItem();
    }

    @Override
    public int getDefaultGenerationHeight(Random rng) {
        if (rng.nextInt(10) == 0) return 2;
        return 1;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return state.get(END) ? GRASS_END_SHAPE : GRASS_MIDDLE_SHAPE;
    }

    @Override
    public void receiveFertilityFromFloor(World world, BlockPos pos, BlockState state, Random rand) {
        logic.growFromFloor(world, pos, state, rand);
    }
}