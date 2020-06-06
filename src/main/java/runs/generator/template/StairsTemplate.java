/*
 * Copyright (c) 2020 RedGalaxy
 * All rights reserved. Do not distribute.
 *
 * Date:   01 - 06 - 2020
 * Author: rgsw
 */

package runs.generator.template;

import runs.generator.FileCopy;

public class StairsTemplate extends Template {
    public StairsTemplate( String stairsName, String innerName, String outerName, String fullName ) {
        this( stairsName, innerName, outerName, fullName, fullName );
    }

    public StairsTemplate( String stairsName, String innerName, String outerName, String fullName, String textureName ) {
        super( modIDFromName( stairsName ) );
        innerName = innerName.replaceAll( "^%", stairsName );
        outerName = outerName.replaceAll( "^%", stairsName );
        addCopy(
            new FileCopy( "templates/blockstates/stairs_step.json", wrapIntoFolder( stairsName, "assets", "blockstates", ".json" ) )
                .property( "regular_name", toSubfolder( stairsName, "block" ) )
                .property( "outer_name", toSubfolder( outerName, "block" ) )
                .property( "inner_name", toSubfolder( innerName, "block" ) )
        );
        addCopy(
            new FileCopy( "templates/models/block/stairs.json", wrapIntoFolder( stairsName, "assets", "models/block", ".json" ) )
                .property( "name", toSubfolder( textureName, "block" ) )
        );
        addCopy(
            new FileCopy( "templates/models/block/outer_stairs.json", wrapIntoFolder( outerName, "assets", "models/block", ".json" ) )
                .property( "name", toSubfolder( textureName, "block" ) )
        );
        addCopy(
            new FileCopy( "templates/models/block/inner_stairs.json", wrapIntoFolder( innerName, "assets", "models/block", ".json" ) )
                .property( "name", toSubfolder( textureName, "block" ) )
        );
        addCopy(
            new FileCopy( "templates/models/item/parent.json", wrapIntoFolder( stairsName, "assets", "models/item", ".json" ) )
                .property( "name", toSubfolder( stairsName, "block" ) )
        );
        addCopy(
            new FileCopy( "templates/loot_tables/basic.json", wrapIntoFolder( stairsName, "data", "loot_tables/blocks", ".json" ) )
                .property( "dropped_item", stairsName )
        );
        addCopy(
            new FileCopy( "templates/recipes/stairs.json", wrapIntoFolder( stairsName, "data", "recipes/stairs", ".json" ) )
                .property( "ingredient", fullName )
                .property( "result", stairsName )
        );
    }
}