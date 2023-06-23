package me.Incompleteusern.BrianSMP.common.datagen;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPBlocks;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPItems;
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

class BrianRecipeGenerator extends FabricRecipeProvider {
    BrianRecipeGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        registerRecipe(ShapedRecipeJsonBuilder
                        .create(BrianSMPBlocks.BRIAN_BLOCK)
                        .group("BRIAN_BLOCK")
                        .pattern("BSB")
                        .input('S', Items.SLIME_BLOCK)
                        .input('B', Items.BLUE_ICE),
                exporter, "horizontal", Items.BLUE_ICE, Items.SLIME_BLOCK);

        registerRecipe(ShapedRecipeJsonBuilder
                        .create(BrianSMPBlocks.BRIAN_BLOCK)
                        .group("BRIAN_BLOCK")
                        .pattern("B")
                        .pattern("S")
                        .pattern("B")
                        .input('S', Items.SLIME_BLOCK)
                        .input('B', Items.BLUE_ICE),
                exporter, "vertical", Items.BLUE_ICE, Items.SLIME_BLOCK);

        registerRecipe(ShapelessRecipeJsonBuilder
                        .create(BrianSMPItems.APPLE_JUICE)
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
                .offerTo(exporter, new Identifier(BrianSMPMod.MODID, String.format("%s_%s", itemId.getPath(), id)));
    }
}