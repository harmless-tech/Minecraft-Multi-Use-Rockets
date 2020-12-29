package tech.harmless.minecraft.multiuserockets.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.block.HTBlock;

import java.util.List;

//TODO Fix lighting issues after blowing up. Fix blocks being weird after blowing up.
public class BlockGunpowder extends HTBlock {

    public BlockGunpowder() {
        super("gunpowder_block", FabricBlockSettings.of(Material.WOOL),
                new FabricItemSettings().group(HTRegistry.ITEM_GROUP));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);

        tooltip.add(new TranslatableText("block.multiuserockets.gunpowder_block.tooltip"));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                         ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        Vec3i[] positions = new Vec3i[] {
                new Vec3i(1, 0, 0), new Vec3i(-1, 0, 0),
                new Vec3i(0, 1, 0), new Vec3i(0, -1, 0),
                new Vec3i(0, 0, 1), new Vec3i(0, 0, -1),
        };

        for(Vec3i p : positions) {
            BlockState eState = world.getBlockState(pos.add(p));

            if(eState != null &&
                    (eState.isOf(Blocks.FIRE) || eState.isOf(Blocks.LAVA) || eState.isOf(Blocks.MAGMA_BLOCK) ||
                            eState.isOf(Blocks.SOUL_FIRE))) {
                explode(world, pos);
                break;
            }
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos,
                               boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);

        BlockState eState = world.getBlockState(fromPos);
        if(eState != null && (eState.isOf(Blocks.FIRE) || eState.isOf(Blocks.LAVA) || eState.isOf(Blocks.MAGMA_BLOCK) ||
                eState.isOf(Blocks.SOUL_FIRE)))
            explode(world, pos);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        explode(world, pos);
    }

    private void explode(World world, BlockPos pos) {
        if(!world.isClient) {
            world.removeBlock(pos, false);
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 8, Explosion.DestructionType.DESTROY);
        }
    }
}
