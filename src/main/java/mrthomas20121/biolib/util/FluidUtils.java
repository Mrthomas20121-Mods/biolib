package mrthomas20121.biolib.util;

import mrthomas20121.biolib.biolib;
import mrthomas20121.biolib.objects.fluids.FluidWrapper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class FluidUtils
{

    public static FluidStack getFluidStack(Fluid fluid, int amount)
    {
        return new FluidStack(fluid, amount);
    }

    public static FluidStack getFluidStack(String name, int amount)
    {
        return new FluidStack(getFluid(name), amount);
    }

    public static Fluid getFluid(String name)
    {
        return FluidRegistry.getFluid(name);
    }

    public static FluidWrapper createMetalFluid(String name, int color)
    {
        return new FluidWrapper(name, color);
    }

}
