package mrthomas20121.biolib.objects.material;

import mrthomas20121.biolib.objects.fluids.FluidWrapper;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.ITrait;

import javax.annotation.Nullable;

public class MaterialWrapper {

    private final FluidWrapper fluidWrapper;
    private final Material material;
    private String oredict;
    private String prefix;

    public MaterialWrapper(Material material)
    {
        this.material = material;
        this.fluidWrapper = new FluidWrapper(material.identifier.replace("ref_", ""), material.materialTextColor);
        this.setOredict();
    }

    public MaterialWrapper(String prefix, String materialName, int color)
    {
        this(new Material(prefix+materialName, color));
    }

    public void setTemp(int temp)
    {
        this.fluidWrapper.setTemp(temp);
    }

    public Material getMaterial() {
        return material;
    }

    public FluidWrapper getFluidWrapper() {
        return fluidWrapper;
    }

    public void setOredict(String oredict) {
        this.oredict = oredict;
    }

    public void setOredict()
    {
        String str = this.material.getIdentifier().replace("ref_", "");
        this.oredict = cap(str);
    }

    public String getOredict() {
        return oredict;
    }

    /**
     * set to true to set craftable to false
     * @param mode mode
     */
    public void setMode(boolean mode)
    {
        this.material.setCraftable(!mode);
        this.material.setCastable(mode);
    }
    public void addItems(String ore)
    {
        this.material.addItem(ore, 1, Material.VALUE_Ingot);
        this.material.setRepresentativeItem(ore);
    }
    public void addItems(ItemStack stack)
    {
        this.material.addItem(stack, 1, Material.VALUE_Ingot);
        this.material.setRepresentativeItem(stack);
    }
    public void addWood(ItemStack planks, ItemStack log)
    {
        this.addItems(planks);
        this.material.addItem(log, 1, Material.VALUE_Ingot * 4);
    }

    public void addTrait(ITrait materialTrait, String dependency)
    {
        this.material.addTrait(materialTrait, dependency);
    }
    public void addTrait(ITrait materialTrait)
    {
        this.material.addTrait(materialTrait);
    }

    public void addCommonModdedItems()
    {
        this.material.addCommonItems(this.oredict);
        this.material.addItem("gear"+this.oredict, 1, Material.VALUE_BrickBlock);
        this.material.addItem("plate"+this.oredict, 1, Material.VALUE_Ingot);
    }

    /**
     * setup and register a material
     * @param materialStats Stats for that material
     */
    public void createMaterial(MaterialStats materialStats)
    {
        this.setMode(true);
        this.fluidWrapper.registerFluid();
        this.material.setFluid(this.fluidWrapper.getFluid());
        this.addCommonModdedItems();
        this.material.setRepresentativeItem("ingot"+oredict);
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material, this.fluidWrapper.getFluid(), oredict).setRepresentativeItem(this.oredict)).preInit();
    }

    /**
     * setup and register a gem material(a meterial that have a gem form, e.g sapphire, ruby)
     * @param materialStats Stats for that material
     */
    public void createGemMaterial(MaterialStats materialStats)
    {
        this.setMode(true);
        this.fluidWrapper.registerFluid();
        this.material.setFluid(this.fluidWrapper.getFluid());
        this.addCommonModdedItems();
        this.addItems("gem"+oredict);
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material, this.fluidWrapper.getFluid(), oredict).setRepresentativeItem(this.oredict)).preInit();
    }

    /**
     * setup and register a material that doesn't have a fluid
     * @param materialStats Stats for that material
     * @param ore the oredict part (gem, ingot, nugget, etc...)
     */
    public void createMaterial(MaterialStats materialStats, String ore)
    {
        this.material.setCastable(false);
        this.material.setCraftable(false);
        this.addCommonModdedItems();
        this.addItems(ore+oredict);
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material, null, oredict).setRepresentativeItem(this.oredict)).preInit();
    }

    public void createWoodMaterial(MaterialStats materialStats)
    {
        this.material.setCastable(false);
        this.material.setCraftable(true);
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material)).preInit();
    }
    public void createOtherMaterial(MaterialStats materialStats, String oredict)
    {
        this.addItems(oredict);
        createWoodMaterial(materialStats);
    }

/**
 * setup and register a material that doesn't have a fluid
 * @param materialStats Stats for that material
 */
    public void createIngotMaterial(MaterialStats materialStats)
    {
        this.createMaterial(materialStats, "ingot");
    }

    private String cap(String str)
    {
        String[] array = str.split("_");
        StringBuilder s = new StringBuilder();
        for(String string: array) {
            s.append(StringUtils.capitalize(string));
        }
        return s.toString();
    }
}
