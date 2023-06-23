package me.Incompleteusern.TerribleSMP.common.init;

import me.Incompleteusern.TerribleSMP.common.TerribleSMPMod;
import me.Incompleteusern.TerribleSMP.common.enchantments.SoftStepsEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class TerribleEnchantments {

    public static Enchantment SOFTSTEPS;

    public static void init() {
        SOFTSTEPS = registerEnchant(new SoftStepsEnchantment(), "soft_steps");
    }

    private static <T extends Enchantment> T registerEnchant(T enchant, String name) {
        Registry.register(Registry.ENCHANTMENT, TerribleSMPMod.MODID + ":" + name, enchant);

        return enchant;
    }

    public static boolean hasSoftSteps(PlayerEntity player) {
        ItemStack stack = player.getEquippedStack(EquipmentSlot.FEET);

        return EnchantmentHelper.getLevel(TerribleEnchantments.SOFTSTEPS, stack) > 0;
    }


}
