package modernity.common.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import modernity.common.registry.MDRegistries;

public class MDFluids {
    public static final ModernizedWaterFluid MODERNIZED_WATER = new ModernizedWaterFluid.Source();
    public static final ModernizedWaterFluid MODERNIZED_WATER_FLOWING = new ModernizedWaterFluid.Flowing();

    public static void register( IForgeRegistry<FluidEntry> registry ) {
        registry.register( new FluidEntry( new ResourceLocation( "modernity:modernized_water" ), MODERNIZED_WATER ) );
        registry.register( new FluidEntry( new ResourceLocation( "modernity:modernized_water_flowing" ), MODERNIZED_WATER_FLOWING ) );
    }

    public static void inject() {
        ForgeRegistry<FluidEntry> entries = MDRegistries.fluids();
        for( FluidEntry entry : entries ) {
            int id = entries.getID( entry );
            ResourceLocation name = entries.getRegistryName();

            IRegistry.field_212619_h.register( id, name, entry.getFluid() );

            for( IFluidState state : entry.getFluid().getStateContainer().getValidStates() ) {
                Fluid.STATE_REGISTRY.add( state );
            }
        }
    }
}