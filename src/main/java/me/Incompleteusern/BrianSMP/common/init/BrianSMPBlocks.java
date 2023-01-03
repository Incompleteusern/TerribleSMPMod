package me.Incompleteusern.BrianSMP.common.init;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import me.Incompleteusern.BrianSMP.common.blocks.BrianBlock;
import me.Incompleteusern.BrianSMP.util.Utils;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BrianSMPBlocks {


    public static BrianBlock BRIAN_BLOCK;

    public static void init() {
        // One slime block + Two blue ice -> Brian block
        // TODO Map color
        BRIAN_BLOCK = registerBlock(new BrianBlock(
                FabricBlockSettings
                        .of(Material.STONE)
                        .slipperiness(0.993F)
                        .hardness(0.3f)
        ), "brian_block", BrianSMPItems.BRIAN_ITEM_GROUP);
    }

    private static <T extends Block> T registerBlock(T block, String name, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, BrianSMPMod.MODID + ":" + name, block);

        // Add to item group
        if (itemGroup != null) {
            BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            BrianSMPItems.registerItem(item, name);
        }

        return block;
    }
}
