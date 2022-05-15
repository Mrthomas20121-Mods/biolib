package mrthomas20121.biolib.objects;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.IToolPart;

import javax.annotation.Nonnull;

public class MaterialHelper {

    public void pourPartsCrafting(@Nonnull FluidStack fluidStack, String material_to_transform, String output_material) {
        for(IToolPart part: TinkerRegistry.getToolParts()) {
            Material material1 = TinkerRegistry.getMaterial(material_to_transform);
            Material material2 = TinkerRegistry.getMaterial(output_material);
            ItemStack input = part.getItemstackWithMaterial(material1);
            ItemStack output = part.getItemstackWithMaterial(material2);
            if(part.canUseMaterial(material1) && part.canUseMaterial(material2)) TinkerRegistry.registerTableCasting(output, input, fluidStack.getFluid(), fluidStack.amount);
        }
    }

    public void poorItemCrafting(FluidStack fluidStack, @Nonnull ItemStack itemToTransform, @Nonnull ItemStack output) {
        if(fluidStack != null) {
            TinkerRegistry.registerTableCasting(output, itemToTransform, fluidStack.getFluid(), fluidStack.amount);
        }
    }
}
