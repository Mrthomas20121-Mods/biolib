package mrthomas20121.biolib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Biolib.MODID, name = Biolib.NAME, version = Biolib.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
                + "after:mantle@[1.12-1.3.3.55,);"
                + "after:tconstruct@[1.12.2-2.13.0.183,);"
                + "after:conarm")
public class Biolib {
    public static final String MODID = "biolib";
    public static final String NAME = "Bio Library";
    public static final String VERSION = "1.1.3";

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
