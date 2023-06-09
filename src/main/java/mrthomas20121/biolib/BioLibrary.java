package mrthomas20121.biolib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mrthomas20121.biolib.core.api.Wood;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BioLibrary.MOD_ID)
public class BioLibrary {

	public static final String MOD_ID = "bio_library";
	public static final Logger LOGGER = LogManager.getLogger();

	public BioLibrary() {
		Wood.getWoodTypes().forEach(WoodType::register);
	}
}
