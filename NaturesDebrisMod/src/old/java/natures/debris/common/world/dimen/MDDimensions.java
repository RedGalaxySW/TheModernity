/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.world.dimen;

import com.google.common.collect.ImmutableSet;
import natures.debris.common.ModernityOld;
import natures.debris.common.registryold.RegistryEventHandler;
import natures.debris.common.registryold.RegistryHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Holder class for Modernity dimensions.
 */
//@ObjectHolder( "modernity" )
public final class MDDimensions {
    private static final RegistryHandler<ModDimension> ENTRIES = new RegistryHandler<>("natures/debris");
    public static final ModernityDim MURK_SURFACE = register("murk_surface", new ModernityDim(MurkSurfaceDimension::new));

    private static ImmutableSet<ResourceLocation> dimensionResLocs;

    static {
        ModernityOld.FML_EVENT_BUS.register(new MDDimensions());
    }

    private MDDimensions() {
    }

    public static ImmutableSet<ResourceLocation> getDimensionResLocs() {
        return dimensionResLocs;
    }

    private static <T extends ModDimension> T register(String id, T dim) {
        ENTRIES.register(id, dim);
        return dim;
    }

    public static void setup(RegistryEventHandler handler) {
        handler.addHandler(ModDimension.class, ENTRIES);
    }

    public static void restore(Set<ResourceLocation> missingNames) {
        for (ResourceLocation loc : missingNames) {
            if (loc.equals(MURK_SURFACE.getRegistryName())) {
                register(MURK_SURFACE.getRegistryName(), MURK_SURFACE, true);
            }
        }
    }

    private static void register(ResourceLocation location, ModDimension dimen, boolean skylight) {
        if (!Registry.DIMENSION_TYPE.containsKey(location)) {
            DimensionManager.registerDimension(location, dimen, null, skylight);
        }
    }

    /**
     * Registers the dimensions to the {@link DimensionManager}.
     */
    public static void init() {
        register(MURK_SURFACE.getRegistryName(), MURK_SURFACE, true);
    }

    @SubscribeEvent
    public void load(FMLLoadCompleteEvent event) {
        Set<ResourceLocation> locs = new HashSet<>();
        locs.addAll(Registry.DIMENSION_TYPE.keySet());
        locs.addAll(ForgeRegistries.MOD_DIMENSIONS.getKeys());
        dimensionResLocs = ImmutableSet.copyOf(locs);
    }

    public static class ModernityDim extends ModDimension {
        private final BiFunction<World, DimensionType, ? extends Dimension> factory;

        private ModernityDim(BiFunction<World, DimensionType, ? extends Dimension> factory) {
            this.factory = factory;
        }

        public DimensionType getType() {
            return DimensionType.byName(getRegistryName());
        }

        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return this.factory;
        }
    }
}