package mrthomas20121.biolib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mrthomas20121.biolib.worldgen.Ore;
import mrthomas20121.biolib.worldgen.OreConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BioLibrary.MOD_ID)
public class BioLibrary {

	public static final String MOD_ID = "biolib";
	public static final Logger LOGGER = LogManager.getLogger();

	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public BioLibrary() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Ore.CONFIGURED_FEATURES.register(bus);
		Ore.PLACED_FEATURES.register(bus);

		//MinecraftForge.EVENT_BUS.register(this);

		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TinkersReforgedConfig.config);
	}
}
