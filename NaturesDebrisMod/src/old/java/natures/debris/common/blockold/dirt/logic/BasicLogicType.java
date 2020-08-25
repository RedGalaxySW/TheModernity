/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.common.blockold.dirt.logic;

public class BasicLogicType implements IDirtLogicType {
    @Override
    public boolean allowOnFarmland() {
        return true;
    }

    @Override
    public boolean allowOnNormal() {
        return true;
    }

    @Override
    public boolean canSwitchTo(DirtLogic logic, IDirtLogicType switchTo) {
        return true;
    }
}