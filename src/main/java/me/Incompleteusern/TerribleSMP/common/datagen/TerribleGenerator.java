package me.Incompleteusern.TerribleSMP.common.datagen;

import me.Incompleteusern.TerribleSMP.common.TerribleSMPMod;
import me.Incompleteusern.TerribleSMP.common.init.TerribleBlocks;
import me.Incompleteusern.TerribleSMP.common.init.TerribleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

class TerribleGenerator extends FabricRecipeProvider {
    TerribleGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        registerRecipe(ShapedRecipeJsonBuilder
                        .create(TerribleBlocks.ICE_SLIME_BLOCK)
                        .group("ICE_SLIME_BLOCK")
                        .pattern("BSB")
                        .input('S', Items.SLIME_BLOCK)
                        .input('B', Items.BLUE_ICE),
                exporter, "horizontal", Items.BLUE_ICE, Items.SLIME_BLOCK);

        registerRecipe(ShapedRecipeJsonBuilder
                        .create(TerribleBlocks.ICE_SLIME_BLOCK)
                        .group("ICE_SLIME_BLOCK")
                        .pattern("B")
                        .pattern("S")
                        .pattern("B")
                        .input('S', Items.SLIME_BLOCK)
                        .input('B', Items.BLUE_ICE),
                exporter, "vertical", Items.BLUE_ICE, Items.SLIME_BLOCK);

        registerRecipe(ShapelessRecipeJsonBuilder
                        .create(TerribleItems.APPLE_JUICE)
                        .input(Items.GOLDEN_APPLE)
                        .input(Items.HONEY_BOTTLE),
                exporter, Items.GOLDEN_APPLE);
    }

    protected void registerRecipe(CraftingRecipeJsonBuilder builder, Consumer<RecipeJsonProvider> exporter, Item... items) {
        builder
                .criterion("has_ingredients", conditionsFromItemPredicates(
                        ItemPredicate.Builder.create()
                                .items(items)
                                .build()))
                .offerTo(exporter);
    }
    protected void registerRecipe(CraftingRecipeJsonBuilder builder, Consumer<RecipeJsonProvider> exporter, String id, Item... items) {
        Identifier itemId = Registry.ITEM.getId(builder.getOutputItem());

        builder
                .criterion("has_ingredients", conditionsFromItemPredicates(
                        ItemPredicate.Builder.create()
                                .items(items)
                                .build()))
                .offerTo(exporter, new Identifier(TerribleSMPMod.MODID, String.format("%s_%s", itemId.getPath(), id)));
    }
}
