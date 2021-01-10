package mrthomas20121.biolib.library;

import mrthomas20121.biolib.Biolib;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Biolib.MODID)
public class Registry {

    private static ArrayList<String> toolforgeBlocks = new ArrayList<>();

    public static void addBToolForgeBlock(String oredict)
    {
        toolforgeBlocks.add("block"+oredict);
    }

    @SubscribeEvent
    public static void addRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistry<IRecipe> r = event.getRegistry();
        for(String ore : toolforgeBlocks)
        {
            TinkerTools.registerToolForgeBlock(r, ore);
        }
    }
}
