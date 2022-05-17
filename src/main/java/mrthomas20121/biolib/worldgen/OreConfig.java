package mrthomas20121.biolib.worldgen;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreConfig {
    public ForgeConfigSpec.BooleanValue enabled;
    public ForgeConfigSpec.IntValue minY;
    public ForgeConfigSpec.IntValue maxY;
    public ForgeConfigSpec.IntValue count;
    public ForgeConfigSpec.IntValue size;

    public OreConfig(ForgeConfigSpec.Builder builder) {
    }

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
}
