/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 16 - 2020
 * Author: rgsw
 */

package modernity.client.model.old.farmlandctm;


//public class FarmlandConnectedTextureModel implements IUnbakedModel {
//    public static final Logger LOGGER = LogManager.getLogger();
//
//    private ResourceLocation all;
//    private ResourceLocation center;
//    private ResourceLocation cross;
//    private ResourceLocation horizontal;
//    private ResourceLocation vertical;
//    private ResourceLocation particle;
//
//    private int tint;
//    private float y;
//
//    @Override
//    public Collection<ResourceLocation> getDependencies() {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public Collection<ResourceLocation> getTextures( Function<ResourceLocation, IUnbakedModel> modelGetter, Set<String> missingTextureErrors ) {
//        return Sets.newHashSet( all, center, cross, horizontal, vertical );
//    }
//
//    @Nullable
//    @Override
//    public IBakedModel bake( ModelBakery bakery, Function<ResourceLocation, TextureAtlasSprite> spriteGetter, ISprite sprite, VertexFormat format ) {
//        try {
//            return new BakedFarmlandConnectedTextureModel(
//                tint, y, format,
//                sprite.getState().apply( Optional.empty() ),
//                spriteGetter.apply( all ),
//                spriteGetter.apply( center ),
//                spriteGetter.apply( cross ),
//                spriteGetter.apply( horizontal ),
//                spriteGetter.apply( vertical ),
//                spriteGetter.apply( particle )
//            );
//        } catch( RuntimeException e ) {
//            e.printStackTrace(); // MC won't let us see the stack trace: print it manually
//            throw e;
//        }
//    }
//
//    @Override
//    public IUnbakedModel process( ImmutableMap<String, String> customData ) {
//        FarmlandConnectedTextureModel out = new FarmlandConnectedTextureModel();
//        int tint = - 1;
//        String tintData = customData.get( "tint" );
//        if( tintData != null ) {
//            try {
//                tint = Integer.parseInt( tintData );
//            } catch( NumberFormatException ignored ) {}
//        }
//
//        float y = 16;
//        String yData = customData.get( "height" );
//        if( yData != null ) {
//            try {
//                y = Float.parseFloat( yData );
//            } catch( NumberFormatException ignored ) {}
//        }
//
//        out.tint = tint;
//        out.y = y;
//        out.all = all;
//        out.center = center;
//        out.cross = cross;
//        out.horizontal = horizontal;
//        out.vertical = vertical;
//        out.particle = particle;
//        return out;
//    }
//
//    @Override
//    public IUnbakedModel retexture( ImmutableMap<String, String> textures ) {
//        FarmlandConnectedTextureModel out = new FarmlandConnectedTextureModel();
//        out.tint = tint;
//        out.y = y;
//        out.all = getTexture( textures.get( "all" ) );
//        out.center = getTexture( textures.get( "center" ) );
//        out.cross = getTexture( textures.get( "cross" ) );
//        out.horizontal = getTexture( textures.get( "x" ) );
//        out.vertical = getTexture( textures.get( "z" ) );
//        out.particle = getParticleTexture( textures.get( "particle" ), all );
//        return out;
//    }
//
//    private ResourceLocation getTexture( String n ) {
//        ResourceLocation tex = MissingTextureSprite.getLocation();
//        if( n != null ) {
//            tex = new ResourceLocation( n );
//        }
//        return tex;
//    }
//
//    private ResourceLocation getParticleTexture( String n, ResourceLocation fallBack ) {
//        ResourceLocation tex = fallBack;
//        if( n != null ) {
//            tex = new ResourceLocation( n );
//        }
//        return tex;
//    }
//}