package mrthomas20121.biolib.library;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;

import javax.annotation.Nullable;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public class SmelteryUtils {

    public static int VALUE_Gear = Material.VALUE_Ingot*4;
    public static int VALUE_SHEET = 200;
    public static int VALUE_DOUBLE_INGOT = 200;

    public static void registerIngotCasting(String ore, Fluid fluid)
    {
        ItemStack result = OreDictionary.getOres("ingot"+ore).get(0);
        if(!result.equals(ItemStack.EMPTY))
        {
          TinkerRegistry.registerTableCasting(result, castIngot, fluid, Material.VALUE_Ingot);
        }
    }
    public static void registerCasting(String ore, ItemStack cast, Fluid fluid, int amount)
    {
        ItemStack result =  OreDictionary.getOres(ore).get(0);
        if(!result.equals(ItemStack.EMPTY))
        {
          TinkerRegistry.registerTableCasting(result, cast, fluid, amount);
        }
    }
    public static void registerCasting(ItemStack input, ItemStack cast, Fluid fluid, int amount)
    {
        TinkerRegistry.registerTableCasting(input, cast, fluid, amount);
    }
    public static void registerCasting(String type, String ore, Fluid fluid)
    {
        ItemStack input = OreDictionary.getOres(type+ore).get(0);
        if(!input.isEmpty())
        {
            switch (type) {
                case "plate":
                    TinkerRegistry.registerTableCasting(input, castPlate, fluid, Material.VALUE_Ingot);
                    break;
                case "gear":
                    TinkerRegistry.registerTableCasting(input, castGear, fluid, VALUE_Gear);
                    break;
                case "gem":
                    TinkerRegistry.registerTableCasting(input, castGem, fluid, Material.VALUE_Ingot);
                    break;
                case "nugget":
                    TinkerRegistry.registerTableCasting(input, castNugget, fluid, Material.VALUE_Nugget);
                    break;
                case "ingot":
                    TinkerRegistry.registerTableCasting(input, castIngot, fluid, Material.VALUE_Ingot);
                    break;
                case "block":
                    TinkerRegistry.registerBasinCasting(input, ItemStack.EMPTY, fluid, Material.VALUE_Block);
                    break;
            }
        }
    }

    public static void addMelting(String ore, FluidStack fluidstack) {
        TinkerRegistry.registerMelting(ore, fluidstack.getFluid(), fluidstack.amount);
    }
    public static void addMelting(ItemStack item, FluidStack fluidstack) {
        TinkerRegistry.registerMelting(item, fluidstack.getFluid(), fluidstack.amount);
    }
    public static void addBasinCasing(ItemStack output, FluidStack fluidstack, @Nullable ItemStack input) {
        TinkerRegistry.registerBasinCasting(output, input, fluidstack.getFluid(), fluidstack.amount);
    }

    public static void defaultMelting(String ore, Fluid fluid) {
        TinkerRegistry.registerMelting("ingot" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("block" + ore, fluid, Material.VALUE_Block);
        TinkerRegistry.registerMelting("ore" + ore, fluid, Material.VALUE_Ore());
        registerIngotCasting(ore, fluid);
    }
    public static void registerMelting(String ore, Fluid fluid, int mat) {
        TinkerRegistry.registerMelting(ore, fluid, mat);
    }
    public static void registerAlloy(FluidStack output, FluidStack... inputs) {
        AlloyRecipe recipe = new AlloyRecipe(output, inputs);
        TinkerRegistry.registerAlloy(recipe);
    }
    public static boolean checkIfAlloyRecipeExist(FluidStack output, FluidStack... inputs) {
        boolean exist = false;
        AlloyRecipe recipe = new AlloyRecipe(output, inputs);
        for(AlloyRecipe alloy: TinkerRegistry.getAlloys()) {
            if(alloy.equals(recipe)) {
                exist = true;
            }
        }
        return exist;
    }
}