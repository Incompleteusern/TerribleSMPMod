package me.Incompleteusern.TerribleSMP.common.init;

import me.Incompleteusern.TerribleSMP.common.TerribleSMPMod;
import me.Incompleteusern.TerribleSMP.common.blocks.IceSlimeBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class TerribleBlocks {
    public static IceSlimeBlock ICE_SLIME_BLOCK;

    public static void init() {
        // One slime block + Two blue ice -> Ice slime block
        // TODO Map color
        ICE_SLIME_BLOCK = registerBlock(new IceSlimeBlock(
                FabricBlockSettings
                        .of(Material.ORGANIC_PRODUCT, MapColor.LAPIS_BLUE)
                        .slipperiness(0.993F)
                        .hardness(0.4f)
                        .sounds(BlockSoundGroup.SLIME)
                        .nonOpaque()
        ), "ice_slime_block", TerribleItems.ITEM_GROUP);
    }

    private static <T extends Block> T registerBlock(T block, String name, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, TerribleSMPMod.MODID + ":" + name, block);

        // Add to item group
        if (itemGroup != null) {
            BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            TerribleItems.registerItem(item, name);
        }

        return block;
    }
}
