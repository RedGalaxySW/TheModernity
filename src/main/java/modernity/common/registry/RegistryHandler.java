package modernity.common.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RegistryHandler<E extends IForgeRegistryEntry<E>> implements Iterable<E> {
    protected final ArrayList<Entry<E>> registryItems = new ArrayList<>();
    protected final HashMap<ResourceLocation, Entry<E>> remappings = new HashMap<>();

    protected final String modid;

    public RegistryHandler( String modid ) {
        this.modid = modid;
    }

    public void fillRegistry( IForgeRegistry<E> registry ) {
        for( Entry<E> e : registryItems ) {
            registry.register( e.entry );
        }
    }

    public void remap( List<RegistryEvent.MissingMappings.Mapping<E>> mappings ) {
        for( RegistryEvent.MissingMappings.Mapping<E> mapping : mappings ) {
            if( remappings.containsKey( mapping.key ) ) {
                mapping.remap( remappings.get( mapping.key ).entry );
            }
        }
    }

    public <T extends E> T register( String name, T e, String... aliases ) {
        ResourceLocation id = computeID( name );
        Entry<E> entry = new Entry<>( id, e, aliases );
        registryItems.add( entry );
        e.setRegistryName( id );
        for( String alias : aliases ) {
            remappings.put( computeID( alias ), entry );
        }
        return e;
    }

    private ResourceLocation computeID( String name ) {
        int i = name.indexOf( ':' );
        String ns = this.modid;
        String path = name;
        if( i >= 0 ) {
            ns = name.substring( 0, i );
            path = name.substring( i + 1 );
        }
        return new ResourceLocation( ns, path );
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        final Iterator<Entry<E>> backing = registryItems.iterator();

        @Override
        public boolean hasNext() {
            return backing.hasNext();
        }

        @Override
        public E next() {
            return backing.next().entry;
        }
    }

    protected static final class Entry<E extends IForgeRegistryEntry<E>> {
        public final ResourceLocation name;
        public final E entry;
        public final String[] aliases;

        public Entry( ResourceLocation name, E entry, String... aliases ) {
            this.name = name;
            this.entry = entry;
            this.aliases = aliases;
        }
    }
}