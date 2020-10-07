package mrthomas20121.biolib.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public abstract class ConfigBase implements IConf {
    public Configuration config;
    protected String category;
    protected String name;
    protected static ConfigBase instance;

    public ConfigBase(String name, String category)
    {
        this.category = category;
        this.name = name;
        this.config = null;
        instance = this;
    }
    public ConfigBase(String name, String category, File file)
    {
        this(name, category);
        this.config = new Configuration(file);
    }

    @Override
    abstract public void preInit(FMLPreInitializationEvent event);

    @Override
    abstract public void init();

    @Override
    abstract public boolean isLoaded();

    @Override
    public boolean canLoad()
    {
        return this.load;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public Configuration getConfig() {
        return this.config;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
