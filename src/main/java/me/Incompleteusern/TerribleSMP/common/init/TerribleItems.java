package me.Incompleteusern.TerribleSMP.common.init;

import me.Incompleteusern.TerribleSMP.common.TerribleSMPMod;
import me.Incompleteusern.TerribleSMP.common.items.AppleJuice;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TerribleItems {

    public static ItemGroup ITEM_GROUP;

    public static AppleJuice APPLE_JUICE;

    public static void init() {
        ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(TerribleSMPMod.MODID, "brian_group"),
                () -> new ItemStack(Items.DIRT));

        APPLE_JUICE = registerItem(new AppleJuice(
                new Item.Settings()
                        .group(ITEM_GROUP)
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
        Registry.register(Registry.ITEM, TerribleSMPMod.MODID + ":" + name, item);

        return item;
    }


}
