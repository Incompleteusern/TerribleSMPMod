package me.Incompleteusern.BrianSMP.common.init;

import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class BrianSMPItems {

    public static Item registerItem(Item item, String name) {
        Registry.register(Registry.ITEM, BrianSMPMod.MODID + ":" + name, item);

        return item;


    }

}
