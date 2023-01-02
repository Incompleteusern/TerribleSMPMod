package me.Incompleteusern.BrianSMP.common.datagen;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import me.Incompleteusern.BrianSMP.common.advancements.KilledBrianCriteria;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class BrianAdvancementProvider extends FabricAdvancementProvider {
    protected BrianAdvancementProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement.Builder.create()
                .display(
                        Items.GLOWSTONE_DUST,
                        Text.literal("Life of Brian"),
                        Text.literal("Kill Brian while wearing a gold chestplate."),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("killed_brian", new KilledBrianCriteria.Condition())
                .build(consumer, BrianSMPMod.MODID + "/killed_brian");
    }
}
