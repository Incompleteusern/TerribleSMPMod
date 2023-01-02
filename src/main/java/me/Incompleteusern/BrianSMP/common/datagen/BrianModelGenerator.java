package me.Incompleteusern.BrianSMP.common.datagen;

import me.Incompleteusern.BrianSMP.common.init.BrianSMPBlocks;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

class BrianModelGenerator extends FabricModelProvider {
    BrianModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BrianSMPBlocks.BRIAN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BrianSMPItems.APPLE_JUICE, Models.GENERATED);
    }
}
