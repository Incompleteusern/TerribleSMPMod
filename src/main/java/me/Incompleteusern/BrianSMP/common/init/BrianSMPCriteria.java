package me.Incompleteusern.BrianSMP.common.init;

import me.Incompleteusern.BrianSMP.common.advancements.KilledBrianCriteria;
import me.Incompleteusern.BrianSMP.util.Utils;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;

public class BrianSMPCriteria {

    public static KilledBrianCriteria KILLED_BRIAN = Criteria.register(new KilledBrianCriteria());

    public static void init() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, killer, killed) -> {
            if (killer instanceof ServerPlayerEntity player && Utils.isBrian(killed)) {
                ItemStack held = player.getEquippedStack(EquipmentSlot.CHEST);

                if (held.getItem().equals(Items.GOLDEN_CHESTPLATE)) {
                    KILLED_BRIAN.trigger(player);
                }
            }
        });
    }
}
