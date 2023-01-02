package me.Incompleteusern.BrianSMP.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BrianSMPDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(BrianModelGenerator::new);
        fabricDataGenerator.addProvider(BrianRecipeGenerator::new);
        fabricDataGenerator.addProvider(BrianEnglishLangProvider::new);
        fabricDataGenerator.addProvider(BrianAdvancementProvider::new);
    }


}
