package me.Incompleteusern.BrianSMP.common.init;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import me.Incompleteusern.BrianSMP.common.items.AppleJuice;
import me.Incompleteusern.BrianSMP.util.Utils;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BrianSMPItems {

    public static ItemGroup BRIAN_ITEM_GROUP;

    public static AppleJuice APPLE_JUICE;

    public static void init() {
        BRIAN_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(BrianSMPMod.MODID, "brian_group"),
                Utils::getBrianSkull);

        APPLE_JUICE = registerItem(new AppleJuice(
                new Item.Settings()
                        .group(BRIAN_ITEM_GROUP)
                        .food(
                                new FoodComponent.Builder()
                                        .hunger(6).saturationModifier(0.4F)
                                        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 5), 1.0F)
                                        .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0), 0.5F)
                                        .snack().alwaysEdible()
                                        .build()
                        )
                        .maxCount(16)
        ), "apple_juice");
    }

    public static <T extends Item> T registerItem(T item, String name) {
        Registry.register(Registry.ITEM, BrianSMPMod.MODID + ":" + name, item);

        return item;
    }


}
