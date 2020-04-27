/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   03 - 23 - 2020
 * Author: rgsw
 */

package modernity.data;

import modernity.common.loot.MDLootTables;
import modernity.common.registry.RegistryEventHandler;
import modernity.data.lang.TranslationKeyProvider;
import modernity.data.loot.MDLootTableProvider;
import modernity.data.recipes.MDRecipeProvider;
import modernity.generic.IModernityOld;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModernityData implements IModernityOld {
    private final DataService dataService = new DataService();

    @Override
    public void setupRegistryHandler() {
        FMLJavaModLoadingContext.get().getModEventBus().register( RegistryEventHandler.INSTANCE );
        MinecraftForge.EVENT_BUS.register( RegistryEventHandler.INSTANCE );
    }

    @Override
    public void preInit() {
        MDLootTables.register();
    }

    @SubscribeEvent
    public void gather( GatherDataEvent event ) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider( new MDLootTableProvider( generator ) );
        generator.addProvider( new MDRecipeProvider( generator ) );
        generator.addProvider( new TranslationKeyProvider( generator ) );
    }

    @Override
    public DataService getDataService() {
        return dataService;
    }
}