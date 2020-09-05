package natures.debris.common.block;

import javax.annotation.Nonnull;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import natures.debris.common.NaturesDebris;
import natures.debris.common.item.HookedShovelItem;

@ObjectHolder("ndebris")
public final class NdBlocks {
    public static final Block MURKY_DIRT = inj();
    public static final Block MURKY_GRASS_BLOCK = inj();
    public static final Block MURKY_COARSE_DIRT = inj();
    public static final Block MURKY_HUMUS = inj();
    public static final Block MURKY_PODZOL = inj();
    public static final Block LEAFY_HUMUS = inj();
    public static final Block MURKY_SAND = inj();
    public static final Block MURKY_CLAY = inj();
    public static final Block MURKY_TERRACOTTA = inj();
    public static final Block MURKY_GRASS_PATH = inj();

    public static final Block ROCK = inj();
    public static final Block MOSSY_ROCK = inj();
    public static final Block ROCK_BRICKS = inj();
    public static final Block MOSSY_ROCK_BRICKS = inj();
    public static final Block CRACKED_ROCK_BRICKS = inj();
    public static final Block ROCK_TILES = inj();
    public static final Block MOSSY_ROCK_TILES = inj();
    public static final Block CRACKED_ROCK_TILES = inj();
    public static final Block SMOOTH_ROCK = inj();
    public static final Block POLISHED_ROCK = inj();
    public static final Block CHISELED_ROCK = inj();
    public static final Block ROCK_PILLAR = inj();
    public static final Block ROCK_LANTERN = inj();

    public static final Block ROCK_SLAB = inj();
    public static final Block MOSSY_ROCK_SLAB = inj();
    public static final Block ROCK_BRICKS_SLAB = inj();
    public static final Block MOSSY_ROCK_BRICKS_SLAB = inj();
    public static final Block CRACKED_ROCK_BRICKS_SLAB = inj();
    public static final Block ROCK_TILES_SLAB = inj();
    public static final Block MOSSY_ROCK_TILES_SLAB = inj();
    public static final Block CRACKED_ROCK_TILES_SLAB = inj();
    public static final Block SMOOTH_ROCK_SLAB = inj();
    public static final Block POLISHED_ROCK_SLAB = inj();

    public static final Block ROCK_STAIRS = inj();
    public static final Block MOSSY_ROCK_STAIRS = inj();
    public static final Block ROCK_BRICKS_STAIRS = inj();
    public static final Block MOSSY_ROCK_BRICKS_STAIRS = inj();
    public static final Block CRACKED_ROCK_BRICKS_STAIRS = inj();
    public static final Block ROCK_TILES_STAIRS = inj();
    public static final Block MOSSY_ROCK_TILES_STAIRS = inj();
    public static final Block CRACKED_ROCK_TILES_STAIRS = inj();
    public static final Block SMOOTH_ROCK_STAIRS = inj();
    public static final Block POLISHED_ROCK_STAIRS = inj();

    public static final Block ROCK_STEP = inj();
    public static final Block MOSSY_ROCK_STEP = inj();
    public static final Block ROCK_BRICKS_STEP = inj();
    public static final Block MOSSY_ROCK_BRICKS_STEP = inj();
    public static final Block CRACKED_ROCK_BRICKS_STEP = inj();
    public static final Block ROCK_TILES_STEP = inj();
    public static final Block MOSSY_ROCK_TILES_STEP = inj();
    public static final Block CRACKED_ROCK_TILES_STEP = inj();
    public static final Block SMOOTH_ROCK_STEP = inj();
    public static final Block POLISHED_ROCK_STEP = inj();

    public static final Block DARKROCK = inj();
    public static final Block MOSSY_DARKROCK = inj();
    public static final Block DARKROCK_BRICKS = inj();
    public static final Block MOSSY_DARKROCK_BRICKS = inj();
    public static final Block CRACKED_DARKROCK_BRICKS = inj();
    public static final Block DARKROCK_TILES = inj();
    public static final Block MOSSY_DARKROCK_TILES = inj();
    public static final Block CRACKED_DARKROCK_TILES = inj();
    public static final Block SMOOTH_DARKROCK = inj();
    public static final Block POLISHED_DARKROCK = inj();
    public static final Block CHISELED_DARKROCK = inj();
    public static final Block DARKROCK_PILLAR = inj();
    public static final Block DARKROCK_LANTERN = inj();

    public static final Block DARKROCK_SLAB = inj();
    public static final Block MOSSY_DARKROCK_SLAB = inj();
    public static final Block DARKROCK_BRICKS_SLAB = inj();
    public static final Block MOSSY_DARKROCK_BRICKS_SLAB = inj();
    public static final Block CRACKED_DARKROCK_BRICKS_SLAB = inj();
    public static final Block DARKROCK_TILES_SLAB = inj();
    public static final Block MOSSY_DARKROCK_TILES_SLAB = inj();
    public static final Block CRACKED_DARKROCK_TILES_SLAB = inj();
    public static final Block SMOOTH_DARKROCK_SLAB = inj();
    public static final Block POLISHED_DARKROCK_SLAB = inj();

    public static final Block DARKROCK_STAIRS = inj();
    public static final Block MOSSY_DARKROCK_STAIRS = inj();
    public static final Block DARKROCK_BRICKS_STAIRS = inj();
    public static final Block MOSSY_DARKROCK_BRICKS_STAIRS = inj();
    public static final Block CRACKED_DARKROCK_BRICKS_STAIRS = inj();
    public static final Block DARKROCK_TILES_STAIRS = inj();
    public static final Block MOSSY_DARKROCK_TILES_STAIRS = inj();
    public static final Block CRACKED_DARKROCK_TILES_STAIRS = inj();
    public static final Block SMOOTH_DARKROCK_STAIRS = inj();
    public static final Block POLISHED_DARKROCK_STAIRS = inj();

    public static final Block DARKROCK_STEP = inj();
    public static final Block MOSSY_DARKROCK_STEP = inj();
    public static final Block DARKROCK_BRICKS_STEP = inj();
    public static final Block MOSSY_DARKROCK_BRICKS_STEP = inj();
    public static final Block CRACKED_DARKROCK_BRICKS_STEP = inj();
    public static final Block DARKROCK_TILES_STEP = inj();
    public static final Block MOSSY_DARKROCK_TILES_STEP = inj();
    public static final Block CRACKED_DARKROCK_TILES_STEP = inj();
    public static final Block SMOOTH_DARKROCK_STEP = inj();
    public static final Block POLISHED_DARKROCK_STEP = inj();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
            rock("rock", 1.5, 6, false),
            rock("darkrock", 1.5, 6, true),
            dirt("murky_dirt", 0.5, MaterialColor.DIRT, SoundType.GROUND),
            grass("murky_grass_block", 0.6, MaterialColor.GRASS, SoundType.PLANT),
            dirt("murky_coarse_dirt", 0.5, MaterialColor.DIRT, SoundType.GROUND),
            humus("murky_humus", 0.5, MaterialColor.BLACK_TERRACOTTA, SoundType.GROUND),
            leafyHumus("leafy_humus", 0.5, MaterialColor.DIRT, SoundType.PLANT),
            dirt("murky_podzol", 0.5, MaterialColor.DIRT, SoundType.GROUND),
            sand("murky_sand", 0.5, MaterialColor.SAND, SoundType.SAND),
            clay("murky_clay"),
            terracotta("murky_terracotta"),
            grassPath("murky_grass_path", 0.5, MaterialColor.GRASS, SoundType.PLANT),


            rock("mossy_rock", 1.5, 6, false),
            rock("rock_bricks", 2, 6, false),
            rock("mossy_rock_bricks", 2, 6, false),
            rock("cracked_rock_bricks", 2, 6, false),
            rock("rock_tiles", 2, 6, false),
            rock("mossy_rock_tiles", 2, 6, false),
            rock("cracked_rock_tiles", 2, 6, false),
            rock("smooth_rock", 1.5, 6, false),
            rock("polished_rock", 2, 6, false),
            rock("chiseled_rock", 2, 6, false),
            rockPillar("rock_pillar", 2, 6, false),
            rockLantern("rock_lantern", 2, 6, false),

            rockSlab("rock_slab", 1.5, 6, false),
            rockSlab("mossy_rock_slab", 1.5, 6, false),
            rockSlab("rock_bricks_slab", 2, 6, false),
            rockSlab("mossy_rock_bricks_slab", 2, 6, false),
            rockSlab("cracked_rock_bricks_slab", 2, 6, false),
            rockSlab("rock_tiles_slab", 2, 6, false),
            rockSlab("mossy_rock_tiles_slab", 2, 6, false),
            rockSlab("cracked_rock_tiles_slab", 2, 6, false),
            rockSlab("smooth_rock_slab", 1.5, 6, false),
            rockSlab("polished_rock_slab", 2, 6, false),

            rockStairs("rock_stairs", 1.5, 6, false),
            rockStairs("mossy_rock_stairs", 1.5, 6, false),
            rockStairs("rock_bricks_stairs", 2, 6, false),
            rockStairs("mossy_rock_bricks_stairs", 2, 6, false),
            rockStairs("cracked_rock_bricks_stairs", 2, 6, false),
            rockStairs("rock_tiles_stairs", 2, 6, false),
            rockStairs("mossy_rock_tiles_stairs", 2, 6, false),
            rockStairs("cracked_rock_tiles_stairs", 2, 6, false),
            rockStairs("smooth_rock_stairs", 1.5, 6, false),
            rockStairs("polished_rock_stairs", 2, 6, false),

            rockStep("rock_step", 1.5, 6, false),
            rockStep("mossy_rock_step", 1.5, 6, false),
            rockStep("rock_bricks_step", 2, 6, false),
            rockStep("mossy_rock_bricks_step", 2, 6, false),
            rockStep("cracked_rock_bricks_step", 2, 6, false),
            rockStep("rock_tiles_step", 2, 6, false),
            rockStep("mossy_rock_tiles_step", 2, 6, false),
            rockStep("cracked_rock_tiles_step", 2, 6, false),
            rockStep("smooth_rock_step", 1.5, 6, false),
            rockStep("polished_rock_step", 2, 6, false),


            rock("mossy_darkrock", 1.5, 6, true),
            rock("darkrock_bricks", 2, 6, true),
            rock("mossy_darkrock_bricks", 2, 6, true),
            rock("cracked_darkrock_bricks", 2, 6, true),
            rock("darkrock_tiles", 2, 6, true),
            rock("mossy_darkrock_tiles", 2, 6, true),
            rock("cracked_darkrock_tiles", 2, 6, true),
            rock("smooth_darkrock", 1.5, 6, true),
            rock("polished_darkrock", 2, 6, true),
            rock("chiseled_darkrock", 2, 6, true),
            rockPillar("darkrock_pillar", 2, 6, true),
            rockLantern("darkrock_lantern", 2, 6, true),

            rockSlab("darkrock_slab", 1.5, 6, true),
            rockSlab("mossy_darkrock_slab", 1.5, 6, true),
            rockSlab("darkrock_bricks_slab", 2, 6, true),
            rockSlab("mossy_darkrock_bricks_slab", 2, 6, true),
            rockSlab("cracked_darkrock_bricks_slab", 2, 6, true),
            rockSlab("darkrock_tiles_slab", 2, 6, true),
            rockSlab("mossy_darkrock_tiles_slab", 2, 6, true),
            rockSlab("cracked_darkrock_tiles_slab", 2, 6, true),
            rockSlab("smooth_darkrock_slab", 1.5, 6, true),
            rockSlab("polished_darkrock_slab", 2, 6, true),

            rockStairs("darkrock_stairs", 1.5, 6, true),
            rockStairs("mossy_darkrock_stairs", 1.5, 6, true),
            rockStairs("darkrock_bricks_stairs", 2, 6, true),
            rockStairs("mossy_darkrock_bricks_stairs", 2, 6, true),
            rockStairs("cracked_darkrock_bricks_stairs", 2, 6, true),
            rockStairs("darkrock_tiles_stairs", 2, 6, true),
            rockStairs("mossy_darkrock_tiles_stairs", 2, 6, true),
            rockStairs("cracked_darkrock_tiles_stairs", 2, 6, true),
            rockStairs("smooth_darkrock_stairs", 1.5, 6, true),
            rockStairs("polished_darkrock_stairs", 2, 6, true),

            rockStep("darkrock_step", 1.5, 6, true),
            rockStep("mossy_darkrock_step", 1.5, 6, true),
            rockStep("darkrock_bricks_step", 2, 6, true),
            rockStep("mossy_darkrock_bricks_step", 2, 6, true),
            rockStep("cracked_darkrock_bricks_step", 2, 6, true),
            rockStep("darkrock_tiles_step", 2, 6, true),
            rockStep("mossy_darkrock_tiles_step", 2, 6, true),
            rockStep("cracked_darkrock_tiles_step", 2, 6, true),
            rockStep("smooth_darkrock_step", 1.5, 6, true),
            rockStep("polished_darkrock_step", 2, 6, true)
        );
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.registerAll(
            item(ROCK, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_DIRT, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_GRASS_BLOCK, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_COARSE_DIRT, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_HUMUS, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_PODZOL, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_SAND, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_CLAY, ItemGroup.BUILDING_BLOCKS),
            item(LEAFY_HUMUS, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_TERRACOTTA, ItemGroup.BUILDING_BLOCKS),
            item(MURKY_GRASS_PATH, ItemGroup.BUILDING_BLOCKS),

            item(MOSSY_ROCK, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_ROCK, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_ROCK, ItemGroup.BUILDING_BLOCKS),
            item(CHISELED_ROCK, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_PILLAR, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_LANTERN, ItemGroup.BUILDING_BLOCKS),

            item(ROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_ROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_ROCK_SLAB, ItemGroup.BUILDING_BLOCKS),

            item(ROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_ROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_ROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),

            item(ROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(ROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_ROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_ROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_ROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_ROCK_STEP, ItemGroup.BUILDING_BLOCKS),


            item(MOSSY_DARKROCK, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_BRICKS, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_TILES, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_DARKROCK, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_DARKROCK, ItemGroup.BUILDING_BLOCKS),
            item(CHISELED_DARKROCK, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_PILLAR, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_LANTERN, ItemGroup.BUILDING_BLOCKS),

            item(DARKROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_BRICKS_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_TILES_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_DARKROCK_SLAB, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_DARKROCK_SLAB, ItemGroup.BUILDING_BLOCKS),

            item(DARKROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_BRICKS_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_TILES_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_DARKROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_DARKROCK_STAIRS, ItemGroup.BUILDING_BLOCKS),

            item(DARKROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_BRICKS_STEP, ItemGroup.BUILDING_BLOCKS),
            item(DARKROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(MOSSY_DARKROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(CRACKED_DARKROCK_TILES_STEP, ItemGroup.BUILDING_BLOCKS),
            item(SMOOTH_DARKROCK_STEP, ItemGroup.BUILDING_BLOCKS),
            item(POLISHED_DARKROCK_STEP, ItemGroup.BUILDING_BLOCKS)
        );
    }

    public static void setup() {
        HookedShovelItem.registerShovelAction(NdBlocks.MURKY_GRASS_BLOCK, NdBlocks.MURKY_GRASS_PATH.getDefaultState());
    }

    @OnlyIn(Dist.CLIENT)
    public static void setupClient() {
        RenderTypeLookup.setRenderLayer(MURKY_GRASS_BLOCK, RenderType.getCutoutMipped());

        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        ItemColors itemColors = Minecraft.getInstance().getItemColors();

        blockColors.register(
            // TODO Biome colors coming later
            (state, world, pos, index) -> 0x11783F,
            MURKY_GRASS_BLOCK
        );
        itemColors.register(
            (item, index) -> 0x11783F,
            MURKY_GRASS_BLOCK
        );
    }

    private static Block block(String id, Block block) {
        return block.setRegistryName(NaturesDebris.resLoc(id));
    }

    private static Block rock(String id, double hardness, double resistance, boolean dark) {
        return block(id, new Block(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block rockLantern(String id, double hardness, double resistance, boolean dark) {
        return block(id, new Block(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
                            .lightValue(15)
        ));
    }

    private static Block rockPillar(String id, double hardness, double resistance, boolean dark) {
        return block(id, new RotatedPillarBlock(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block rockSlab(String id, double hardness, double resistance, boolean dark) {
        return block(id, new SlabBlock(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block rockStairs(String id, double hardness, double resistance, boolean dark) {
        return block(id, new SimpleStairsBlock(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block rockStep(String id, double hardness, double resistance, boolean dark) {
        return block(id, new StepBlock(
            Block.Properties.create(Material.ROCK, dark ? MaterialColor.BLACK : MaterialColor.STONE)
                            .hardnessAndResistance((float) hardness, (float) resistance)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static Block dirt(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new MurkyDirtBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block grassPath(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new MurkyGrassPathBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block humus(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new MurkyHumusBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
                            .tickRandomly()
        ));
    }

    private static Block leafyHumus(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new LeafyHumusBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
                            .tickRandomly()
        ));
    }

    private static Block grass(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new MurkyGrassBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
                            .tickRandomly()
        ));
    }

    private static Block sand(String id, double strength, MaterialColor color, SoundType sound) {
        return block(id, new MurkySandBlock(
            Block.Properties.create(Material.EARTH, color)
                            .hardnessAndResistance((float) strength)
                            .sound(sound)
                            .harvestTool(ToolType.SHOVEL)
                            .tickRandomly()
        ));
    }

    private static Block clay(String id) {
        return block(id, new Block(
            Block.Properties.create(Material.CLAY, MaterialColor.BLUE_TERRACOTTA)
                            .hardnessAndResistance(.5f)
                            .sound(SoundType.GROUND)
                            .harvestTool(ToolType.SHOVEL)
        ));
    }

    private static Block terracotta(String id) {
        return block(id, new Block(
            Block.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                            .hardnessAndResistance(1.25f, 4.2f)
                            .sound(SoundType.STONE)
                            .harvestTool(ToolType.PICKAXE)
        ));
    }

    private static BlockItem item(Block block, Item.Properties props) {
        ResourceLocation id = block.getRegistryName();
        assert id != null;
        BlockItem item = new BlockItem(block, props);
        item.setRegistryName(id);
        return item;
    }

    private static BlockItem item(Block block, ItemGroup group) {
        return item(block, new Item.Properties().group(group));
    }

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static Block inj() {
        return null;
    }
}
