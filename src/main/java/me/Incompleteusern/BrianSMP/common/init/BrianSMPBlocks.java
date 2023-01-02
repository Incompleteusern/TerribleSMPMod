package me.Incompleteusern.BrianSMP.common.init;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import me.Incompleteusern.BrianSMP.common.blocks.BrianBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class BrianSMPBlocks {

    public static Block BRIAN_BLOCK;

    public static void init() {
        // TODO Map color
        BRIAN_BLOCK = registerBlock(new BrianBlock(FabricBlockSettings.of(Material.STONE).slipperiness(0.993F)), "brian_block", ItemGroup.BUILDING_BLOCKS);
    }

    private static Block registerBlock(Block block, String name, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, BrianSMPMod.MODID + ":" + name, block);

        if (itemGroup != null) {
            BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            BrianSMPItems.registerItem(item, name);
        }

        return block;
    }
}
