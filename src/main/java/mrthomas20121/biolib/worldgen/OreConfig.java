package mrthomas20121.biolib.worldgen;

import com.google.gson.JsonObject;
import mrthomas20121.biolib.BioLibrary;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class OreConfig {

    private static final Map<String, OreConfig> config = new HashMap<>();

    protected final boolean enabled;
    protected final int minY;
    protected final int maxY;
    protected final int count;
    protected final int size;

    private OreConfig(boolean enabled, int minY, int maxY, int count, int size) {
        this.enabled = enabled;
        this.minY = minY;
        this.maxY = maxY;
        this.count = count;
        this.size = size;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public int getCount() {
        return this.count;
    }

    public int getSize() {
        return this.size;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public int getMinY() {
        return this.minY;
    }

    public static OreConfig create(ResourceLocation name, int minY, int maxY, int count, int size) {
        Path path = FMLPaths.CONFIGDIR.get().resolve(name.getNamespace());
        File file = path.toFile();
        OreConfig config = new OreConfig(true, minY, maxY, count, size);
        if(!file.exists()) {
            file.mkdir();
            File fileName = path.resolve(name.getPath()+".json").toFile();
            try {
                FileWriter writer = new FileWriter(fileName);
                BioLibrary.gson.toJson(config, writer);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            File conf = path.resolve(name.getPath()+".json").toFile();
            try {
                FileReader reader = new FileReader(conf);
                config = BioLibrary.gson.fromJson(reader, OreConfig.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return config;
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty("enable", this.enabled);
        return obj;
    }
}
