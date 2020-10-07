package mrthomas20121.biolib.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IConf {

    boolean load = true;

    void preInit(FMLPreInitializationEvent event);

    void init();

    boolean isLoaded();

    boolean canLoad();
}
