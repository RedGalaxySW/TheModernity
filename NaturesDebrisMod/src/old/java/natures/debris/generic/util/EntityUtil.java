/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package natures.debris.generic.util;

import modernity.util.reflect.FieldAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public final class EntityUtil {
    private static final FieldAccessor<Entity, Vec3d> motionMultiplierField = new FieldAccessor<>(Entity.class, "field_213328_B");

    private EntityUtil() {
    }

    public static Vec3d getMotionMultiplier(Entity entity) {
        return motionMultiplierField.get(entity);
    }

    public static void setMotionMultiplier(BlockState state, Entity entity, Vec3d multiplier) {
        float fall = entity.fallDistance;
        entity.setMotionMultiplier(state, multiplier);
        entity.fallDistance = fall;
    }

    public static void setSmallerMotionMutliplier(BlockState state, Entity entity, Vec3d multiplier) {
        Vec3d current = getMotionMultiplier(entity);
        if (multiplier.lengthSquared() < current.lengthSquared() || current.lengthSquared() < 1E-7) {
            setMotionMultiplier(state, entity, multiplier);
        }
    }

    public static void suspendFallDistance(Entity entity, double suspension) {
        entity.fallDistance *= 1 - suspension;
    }


}