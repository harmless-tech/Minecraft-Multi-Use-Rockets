package tech.harmless.minecraft.multiuserockets.items.cores;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.harmless.minecraft.htlib.item.HTItem;

import java.util.List;

public class ItemCore4 extends HTItem {

    public ItemCore4() {
        super("core_4", ItemCore1.SETTINGS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("item.multiuserockets.core_4.tooltip"));
    }
}
