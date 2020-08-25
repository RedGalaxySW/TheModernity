/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.generator.biome.layer;

import modernity.api.generator.fractal.IRegionRNG;
import modernity.api.generator.fractal.layer.IFilterMergerLayer;
import natures.debris.common.generator.biome.profile.BiomeMutationProfile;
import natures.debris.common.generator.biome.profile.BiomeProfile;

public class RiverMixLayer implements IFilterMergerLayer, IBiomeLayer {
    private final BiomeMutationProfile mutations;

    public RiverMixLayer(BiomeMutationProfile mutations) {
        this.mutations = mutations;
    }

    @Override
    public int generate(IRegionRNG rng, int original, int riverData) {
        if (riverData > 0) {
            BiomeProfile profile = mutations.getProfile(original);
            if (profile == null) return original;
            return profile.random(rng.random(profile.getTotalWeight())).getBiomeID();
        } else {
            return original;
        }
    }
}