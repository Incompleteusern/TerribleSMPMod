package me.Incompleteusern.TerribleSMP.common.datagen;

import me.Incompleteusern.TerribleSMP.common.init.TerribleBlocks;
import me.Incompleteusern.TerribleSMP.common.init.TerribleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

class TerribleModelGenerator extends FabricModelProvider {
    TerribleModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(TerribleBlocks.ICE_SLIME_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(TerribleItems.APPLE_JUICE, Models.GENERATED);
    }
}
