package me.Incompleteusern.TerribleSMP.client;

import me.Incompleteusern.TerribleSMP.common.init.TerribleBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class TerribleSMPClient implements ClientModInitializer {

    public static void registerRenders() {
        BlockRenderLayerMap.INSTANCE.putBlock(TerribleBlocks.ICE_SLIME_BLOCK, RenderLayer.getTranslucent());
    }

    @Override
    public void onInitializeClient() {
        registerRenders();
    }
}
