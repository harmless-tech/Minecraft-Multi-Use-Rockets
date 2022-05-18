package tech.harmless.minecraft.multiuserockets;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.harmless.minecraft.htlib.HTRegistry;
import tech.harmless.minecraft.htlib.annotations.HTMod;
import tech.harmless.minecraft.htlib.item.HTItem;
import tech.harmless.minecraft.multiuserockets.items.rockets.Rocket;

//TODO Use HTLib.
@HTMod(id = MultiUseRockets.ID, name = MultiUseRockets.NAME, version = MultiUseRockets.VERSION)
public class MultiUseRockets implements ModInitializer {

    public static final String NAME = "MultiUseRockets";
    public static final String ID = "multiuserockets";
    public static final String VERSION = "0.1.0";

    public static final Logger LOG = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing " + NAME + " " + VERSION + "...");

        // Items
        HTRegistry.addItem(ID, new HTItem("stacked_gunpowder", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("rocket_body", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("iron_tube", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));
        HTRegistry.addItem(ID, new HTItem("nether_tube", new FabricItemSettings().group(HTRegistry.ITEM_GROUP)));

        //TODO Configurable uses.
        HTRegistry.addItem(ID, new Rocket(1));
        HTRegistry.addItem(ID, new Rocket(2));
        HTRegistry.addItem(ID, new Rocket(3));
        HTRegistry.addItem(ID, new Rocket(4));
        HTRegistry.addItem(ID, new Rocket(5)); //TODO Probably want a custom class.

        LOG.info("Done initializing " + NAME + ".");
    }
}
