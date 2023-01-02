package me.Incompleteusern.BrianSMP.mixin;

import me.Incompleteusern.BrianSMP.common.init.BrianSMPEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TurtleEggBlock.class)
public abstract class MixinTurtleEggBlock {
    @Shadow protected abstract void tryBreakEgg(World world, BlockState state, BlockPos pos, Entity entity, int inverseChance);

    @Redirect(method = "onSteppedOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/TurtleEggBlock;tryBreakEgg(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;I)V"))
    public void redirectSteppedDamage(TurtleEggBlock instance, World world, BlockState state, BlockPos pos, Entity entity, int inverseChance) {
        if (!world.isClient && entity instanceof ServerPlayerEntity player && BrianSMPEnchantments.hasSoftSteps(player)) {
            return; // soft steps cancels
        }

        tryBreakEgg(world, state, pos, entity, inverseChance);
    }

    @Redirect(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/TurtleEggBlock;tryBreakEgg(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;I)V"))
    public void redirectLandedDamage(TurtleEggBlock instance, World world, BlockState state, BlockPos pos, Entity entity, int inverseChance) {
        if (!world.isClient && entity instanceof ServerPlayerEntity player && BrianSMPEnchantments.hasSoftSteps(player)) {
            return; // soft steps cancels
        }

        tryBreakEgg(world, state, pos, entity, inverseChance);
    }
}
