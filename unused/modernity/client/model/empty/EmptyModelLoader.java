package modernity.client.model.empty;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class EmptyModelLoader implements IModelLoader<EmptyModelGeometry> {
    @Override
    public void onResourceManagerReload( IResourceManager resourceManager ) {

    }

    @Override
    public EmptyModelGeometry read( JsonDeserializationContext deserializationContext, JsonObject modelContents ) {
        return new EmptyModelGeometry();
    }
}