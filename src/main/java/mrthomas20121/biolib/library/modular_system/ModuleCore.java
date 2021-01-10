package mrthomas20121.biolib.library.modular_system;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

public abstract class ModuleCore {

    private final ResourceLocation id;

    protected ArrayList<? extends Registry> registries = new ArrayList<>();

    public ModuleCore(ResourceLocation id) {
        this.id = id;
    }

    public abstract void preInit(FMLPreInitializationEvent event);

    /**
     * Used to Register Client stuff like a Client Event or something
     * @param event preInit event
     */
    @SideOnly(Side.CLIENT)
    public abstract void clientPreInit(FMLPreInitializationEvent event);

    public abstract void init(FMLInitializationEvent event);

    public abstract void postInit(FMLPostInitializationEvent event);

    public ArrayList<? extends Registry> getRegistries() {
        return this.registries;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public String getModID() {
        return this.id.getNamespace();
    }


}
