package net.kosha.uh45.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.entity.ModEntities;
import net.kosha.uh45.entity.custom.GlitchteniteGolemEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin({ CarvedPumpkinBlock.class})
public abstract class CarvedPumpkinBlockMixin {

    @Shadow public abstract boolean canDispense(WorldView world, BlockPos pos);

    @Unique
    @Nullable
    private BlockPattern glitchteniteGolemDispenserPattern;
    @Unique
    @Nullable
    private BlockPattern glitchteniteGolemPattern;
    @Unique
    private static final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE = state -> state != null && (state.isOf(Blocks.CARVED_PUMPKIN) || state.isOf(Blocks.JACK_O_LANTERN));


    @Inject(method = "trySpawnEntity", at = @At("HEAD"), cancellable = true)
    private void onTrySpawnEntity(World world, BlockPos pos, CallbackInfo ci) {
        BlockPattern.Result result = this.getGlitchteniteGolemPattern().searchAround(world, pos);
        if (result != null) {
            GlitchteniteGolemEntity glitchteniteGolemEntity = ModEntities.GLITCHTENITE_GOLEM.create(world);
            if (glitchteniteGolemEntity != null) {
                spawnEntity(world, result, glitchteniteGolemEntity, result.translate(0, 2, 0).getBlockPos());
                ci.cancel(); // Cancel further processing to prevent other golems from spawning
            }
        }
    }
    @Unique
    private static void spawnEntity(World world, BlockPattern.Result patternResult, Entity entity, BlockPos pos) {
        CarvedPumpkinBlock.breakPatternBlocks(world, patternResult);
        entity.refreshPositionAndAngles((double)pos.getX() + 0.5, (double)pos.getY() + 0.05, (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.spawnEntity(entity);
        for (ServerPlayerEntity serverPlayerEntity : world.getNonSpectatingEntities(ServerPlayerEntity.class, entity.getBoundingBox().expand(5.0))) {
            Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, entity);
        }
        CarvedPumpkinBlock.updatePatternBlocks(world, patternResult);
    }

    @ModifyReturnValue(method = "canDispense", at = @At("RETURN"))
    public boolean onCanDispense(boolean original, WorldView world, BlockPos pos) {
        if(!original){
            return this.getGlitchteniteGolemDispenserPattern().searchAround(world, pos) != null;
        }
        return true;
    }

    @Unique
    private BlockPattern getGlitchteniteGolemDispenserPattern() {
        if (this.glitchteniteGolemDispenserPattern == null) {
            this.glitchteniteGolemDispenserPattern = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.GLITCHTENITE_BLOCK))).where('~', pos -> pos.getBlockState().isAir()).build();
        }
        return this.glitchteniteGolemDispenserPattern;
    }

    @Unique
    private BlockPattern getGlitchteniteGolemPattern() {
        if (this.glitchteniteGolemPattern == null) {
            this.glitchteniteGolemPattern = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.GLITCHTENITE_BLOCK))).where('~', pos -> pos.getBlockState().isAir()).build();
        }
        return this.glitchteniteGolemPattern;
    }

}
