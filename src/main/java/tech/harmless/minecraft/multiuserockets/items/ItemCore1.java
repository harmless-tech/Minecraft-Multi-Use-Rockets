package tech.harmless.minecraft.multiuserockets.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.item.HTItem;

import java.util.List;

public class ItemCore1 extends HTItem {

    public static final Settings SETTINGS = new FabricItemSettings().group(HTRegistry.ITEM_GROUP).maxCount(16);

    public ItemCore1() {
        super("core_1", SETTINGS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("item.multiuserockets.core_1.tooltip"));
    }
}
