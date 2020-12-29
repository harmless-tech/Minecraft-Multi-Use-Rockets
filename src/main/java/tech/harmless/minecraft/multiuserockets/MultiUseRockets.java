package tech.harmless.minecraft.multiuserockets;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.annotations.HTMod;
import tech.harmless.minecraft.htlib.item.HTItem;

//TODO Use HTLib.
@HTMod(id = MultiUseRockets.ID, name = MultiUseRockets.NAME, version = MultiUseRockets.VERSION)
public class MultiUseRockets implements ModInitializer {

    public static final String NAME = "MultiUseRockets";
    public static final String ID = "multiuserockets";
    public static final String VERSION = "0.0.1";

    public static final Logger LOG = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing " + NAME + " " + VERSION + "...");

        // Items
        HTRegistry.addItem(ID, new HTItem("stacked_gunpowder", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("iron_tube", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("nether_tube", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("rocket_body", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));

        LOG.info("Done initializing " + NAME + ".");
    }
}
