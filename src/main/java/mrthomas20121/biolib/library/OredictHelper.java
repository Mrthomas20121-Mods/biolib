package mrthomas20121.biolib.library;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class OredictHelper {
    private static HashMap<String, ItemStack> oredicts = new HashMap<>();

    public static void register(String oredict, ItemStack stack)
    {
        oredicts.put(oredict, stack);
    }

    public static void init()
    {
        oredicts.forEach(OreDictionary::registerOre);
    }
}
