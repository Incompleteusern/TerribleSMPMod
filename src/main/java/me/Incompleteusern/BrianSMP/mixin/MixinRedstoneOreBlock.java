package me.Incompleteusern.BrianSMP.mixin;

import me.Incompleteusern.BrianSMP.common.init.BrianSMPEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RedstoneOreBlock.class)
public abstract class MixinRedstoneOreBlock {

    @Shadow
    private static void light(BlockState state, World world, BlockPos pos) {
    }

    @Redirect(method = "onSteppedOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/RedstoneOreBlock;light(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"))
    public void redirectLandedDamage(BlockState state, World world, BlockPos pos, World dup1, BlockPos dup2, BlockState dup3, Entity entity) {
        if (entity instanceof PlayerEntity player && BrianSMPEnchantments.hasSoftSteps(player)) {
            return; // soft steps cancels; handle on client to
        }

        light(state, world, pos);
    }
}
