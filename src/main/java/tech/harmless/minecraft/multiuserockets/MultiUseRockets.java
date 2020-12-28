package tech.harmless.minecraft.multiuserockets;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.harmless.minecraft.htlib.lib.annotations.HTMod;

//TODO Use HTLib.
@HTMod(id = MultiUseRockets.ID, name = MultiUseRockets.NAME, version = MultiUseRockets.VERSION)
public class MultiUseRockets implements ModInitializer {

    public static final String NAME = "MultiUseRockets";
    public static final String ID = "multiuserockets";
    public static final String VERSION = "0.0.1";

    public static final Logger LOG = LogManager.getLogger();

    @Override
    public void onInitialize() {
    }
}
