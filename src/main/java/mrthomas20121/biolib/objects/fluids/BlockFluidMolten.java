package mrthomas20121.biolib.objects.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;

public class BlockFluidMolten extends BlockFluidClassic {

    private int color;
    public BlockFluidMolten(Fluid fluid) {
        super(fluid, Material.LAVA);
        this.color = fluid.getColor();

        setCreativeTab(TinkerRegistry.tabSmeltery);
    }

    public int getColor() {
        return this.color;
    }

    @Override
    public String getLocalizedName() {
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if(fluid != null) {
            return fluid.getUnlocalizedName();
        }
        return super.getLocalizedName();
    }
}