package me.Incompleteusern.BrianSMP.common.datagen;

import me.Incompleteusern.BrianSMP.common.init.BrianSMPBlocks;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPEnchantments;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

class BrianEnglishLangProvider extends FabricLanguageProvider {

    protected BrianEnglishLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(BrianSMPItems.BRIAN_ITEM_GROUP, "Brian SMP");
        translationBuilder.add(BrianSMPItems.APPLE_JUICE, "Apple Juice");
        translationBuilder.add(BrianSMPBlocks.BRIAN_BLOCK, "Block of Brian");
        translationBuilder.add(BrianSMPEnchantments.SOFTSTEPS, "Soft Steps");
    }
}
