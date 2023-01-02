package me.Incompleteusern.BrianSMP.util;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public final class Utils {
    private Utils() {
    }

    public static boolean isBrian(Entity entity) {
        if (!(entity instanceof PlayerEntity player)) return false;
        return player.getUuidAsString().equals(BrianSMPMod.BRIAN_UUID);
    }
}
