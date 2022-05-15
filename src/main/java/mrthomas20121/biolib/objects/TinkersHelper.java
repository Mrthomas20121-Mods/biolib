package mrthomas20121.biolib.objects;

import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.ArrayList;
import java.util.Collection;

public class TinkersHelper
{

    public static void addRepairMaterial(Material material, ItemStack stack, int cost)
    {
        material.addItem(stack, cost, cost);
    }
    public static void addRepairMaterial(String material, ItemStack stack, int cost)
    {
        addRepairMaterial(getMaterial(material), stack, cost);
    }
    public static Material getMaterial(String name)
    {
        return TinkerRegistry.getMaterial(name);
    }

    public static ITrait getTrait(String name)
    {
        return TinkerRegistry.getTrait(name);
    }

    /**
     * return all materials
     * @return Collection<Material>
     */
    public static Collection<Material> getMaterials()
    {
        return TinkerRegistry.getAllMaterials();
    }
    public static ArrayList<String> getMaterialNames()
    {
        ArrayList<String> names = new ArrayList<>();
        getMaterials().forEach(material -> names.add(material.identifier));
        return names;
    }
}
