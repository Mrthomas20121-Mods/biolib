package mrthomas20121.biolib.worldgen;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Locale;

public class OreConfig {
    public ForgeConfigSpec.BooleanValue enabled;
    public ForgeConfigSpec.ConfigValue<Integer> minY;
    public ForgeConfigSpec.ConfigValue<Integer> maxY;
    public ForgeConfigSpec.ConfigValue<Integer> count;
    public ForgeConfigSpec.ConfigValue<Integer> size;

    private OreConfig(ForgeConfigSpec.Builder builder) {}

    public boolean isEnabled() {
        return enabled.get();
    }

    public int getCount() {
        return count.get();
    }

    public int getSize() {
        return size.get();
    }

    public int getMaxY() {
        return maxY.get();
    }

    public int getMinY() {
        return minY.get();
    }

    public static OreConfig create(ForgeConfigSpec.Builder builder, int minY, int maxY, int count, int size) {
        return new BasicOreConfig(builder, minY, maxY, count, size);
    }

    private static class BasicOreConfig extends OreConfig {

        private BasicOreConfig(ForgeConfigSpec.Builder builder, int minY, int maxY, int count, int size) {
            super(builder);
            this.enabled = builder.comment("Set to false to disable Ore").define("enabled", true);
            this.minY = builder.comment("Min Y level").define("minY", minY);
            this.maxY = builder.comment("Max Y Level").define("maxY", maxY);
            this.count = builder.comment("Ore vein count").define("veinCount", count);
            this.size = builder.comment("Ore vein size").define("veinSize", size);
        }
    }
}
