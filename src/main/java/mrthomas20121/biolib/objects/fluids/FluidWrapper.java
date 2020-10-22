package mrthomas20121.biolib.objects.fluids;

import mrthomas20121.biolib.biolib;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import javax.annotation.Nonnull;

public class FluidWrapper {

    public static ResourceLocation MetalStill = new ResourceLocation(biolib.MODID, "blocks/fluids/molten_metal");
    public static ResourceLocation MetalFlowing = new ResourceLocation(biolib.MODID, "blocks/fluids/molten_metal_flow");

    private Fluid fluid;

    public FluidWrapper(@Nonnull Fluid fluid)
    {
        this.fluid = fluid;
    }
    public FluidWrapper(String fluidName, int color)
    {
        this(new Fluid(fluidName, MetalStill, MetalFlowing, color));
    }

    @Nonnull
    public Fluid getFluid()
    {
        return this.fluid;
    }

    public void setTemp(int temp)
    {
       this.fluid.setTemperature(temp);
    }

    public void registerFluid()
    {
        if(!FluidRegistry.isFluidRegistered(this.fluid.getName()))
        {
            FluidRegistry.registerFluid(this.fluid);
            FluidRegistry.addBucketForFluid(this.fluid);
        }
        else
        {
            this.fluid = FluidRegistry.getFluid(this.fluid.getName());
        }
    }
}
