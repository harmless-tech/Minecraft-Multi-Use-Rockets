package tech.harmless.minecraft.multiuserockets.items.cores;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import tech.harmless.minecraft.htlib.item.HTItem;

import java.util.List;

//TODO Fix lighting issues after blowing up. Fix blocks being weird after blowing up.
//TODO Maybe don't blow up on water, something else instead like lava.
public class ItemCore5 extends HTItem {

    public ItemCore5() {
        super("core_5", ItemCore1.SETTINGS.maxCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("item.multiuserockets.core_5.tooltip.1"));
        tooltip.add(new TranslatableText("item.multiuserockets.core_5.tooltip.2"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getStackInHand(hand);

        if(user.isTouchingWaterOrRain() || user.isOnFire()) {
            if(!world.isClient()) {
                //TODO Tweak power?
                world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 50, true,
                        Explosion.DestructionType.DESTROY);

                if(!user.isCreative())
                    item.decrement(1);
            }


            return TypedActionResult.success(item, world.isClient);
        }

        return TypedActionResult.pass(item);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
