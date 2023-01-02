package me.Incompleteusern.BrianSMP.mixin;

import me.Incompleteusern.BrianSMP.common.init.BrianSMPEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FarmlandBlock.class)
public abstract class MixinFarmlandBlock {

    @Shadow
    public static void setToDirt(BlockState state, World world, BlockPos pos) {
    }

    @Redirect(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"))
    public void redirectLandedDamage(BlockState state, World world, BlockPos pos, World dup1, BlockState dup2, BlockPos dup3, Entity entity) {
        if (!world.isClient && entity instanceof ServerPlayerEntity player && BrianSMPEnchantments.hasSoftSteps(player)) {
            return; // soft steps cancels
        }

        setToDirt(state, world, pos);
    }

}
