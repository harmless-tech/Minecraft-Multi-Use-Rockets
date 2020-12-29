package tech.harmless.minecraft.multiuserockets.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemStack;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.item.HTItem;

public class ItemStrongNetherTube extends HTItem {

    public ItemStrongNetherTube() {
        super("strong_nether_tube", new FabricItemSettings().group(HTRegistry.ITEM_GROUP));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
