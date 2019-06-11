package modernity.common.world.gen.decorate.feature;

import modernity.common.block.MDBlocks;

public class MDFeatures {
    public static final BushFeature BUSH = new BushFeature();
    public static final LakeFeature LAKE = new LakeFeature();
    public static final HangTreeFeature BLACKWOOD_TREE = new HangTreeFeature(
            MDBlocks.BLACKWOOD_LEAVES.getDefaultState(),
            MDBlocks.BLACKWOOD_LOG.getDefaultState(),
            null // MDBlocks.BLACKWOOD_BRANCH.getDefaultState()
    );
}
