package me.Incompleteusern.TerribleSMP.common.datagen;

import me.Incompleteusern.TerribleSMP.common.init.TerribleBlocks;
import me.Incompleteusern.TerribleSMP.common.init.TerribleEnchantments;
import me.Incompleteusern.TerribleSMP.common.init.TerribleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

class TerribleLangProvider extends FabricLanguageProvider {

    protected TerribleLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(TerribleItems.ITEM_GROUP, "Terrible SMP");
        translationBuilder.add(TerribleItems.APPLE_JUICE, "Apple Juice");
        translationBuilder.add(TerribleBlocks.ICE_SLIME_BLOCK, "Icy Slime Block");
        translationBuilder.add(TerribleEnchantments.SOFTSTEPS, "Soft Steps");

        // Load an existing language file.
        try {
            Path existingFilePath = dataGenerator.getModContainer().findPath("assets/terrible-smp/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
