package tech.harmless.minecraft.multiuserockets.items.rockets;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.annotations.NoRegister;
import tech.harmless.minecraft.htlib.item.HTItem;

@NoRegister
public class Rocket extends HTItem {

    public Rocket(int tier) {
        this(tier, new FabricItemSettings().maxCount(1).group(HTRegistry.ITEM_GROUP));
    }

    public Rocket(int tier, @NotNull Settings settings) {
        super("rocket_" + tier, settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //TODO Consume if uses are 0.

        /*if() {

        }*/

        return super.use(world, user, hand);
    }
}
