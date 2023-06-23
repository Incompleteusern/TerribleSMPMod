package me.Incompleteusern.TerribleSMP.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TerribleDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(TerribleModelGenerator::new);
        fabricDataGenerator.addProvider(TerribleGenerator::new);
        fabricDataGenerator.addProvider(TerribleLangProvider::new);
        fabricDataGenerator.addProvider(TerribleAdvancementProvider::new);
    }


}
