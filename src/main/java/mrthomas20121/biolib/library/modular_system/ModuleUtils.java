package mrthomas20121.biolib.library.modular_system;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;

public class ModuleUtils {

    private static ModuleManager manager = new ModuleManager();

    public static <T extends ModuleCore> void addModule(T module) {
        manager.modules.put(module.getId(), module);
    }

    public static ArrayList<ModuleCore> getLoadedModules() {

        Collection<ModuleCore> modules = manager.modules.values();

        modules.removeIf(moduleCore -> !isLoaded(moduleCore));

        return Lists.newArrayList(modules);
    }

    public static boolean isLoaded(ModuleCore module) {
        return module.isLoaded() && manager.modules.containsValue(module);
    }


}
