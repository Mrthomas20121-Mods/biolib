package mrthomas20121.biolib.objects.material;

import mrthomas20121.biolib.objects.fluids.FluidWrapper;
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

    public MaterialWrapper(Material material, @Nullable String oredict, int temp)
    {
        this.material = material;
        this.fluidWrapper = new FluidWrapper(material.identifier, material.materialTextColor);
        this.fluidWrapper.setTemp(temp);
        this.oredict = oredict;
    }

    public MaterialWrapper(String prefix, String materialName, int color, int temp)
    {
        this.material = new Material(prefix+materialName, color);
        this.fluidWrapper = new FluidWrapper(material.identifier, material.materialTextColor);
        this.fluidWrapper.setTemp(temp);
        this.oredict = StringUtils.capitalize(materialName);
    }

    public MaterialWrapper(String prefix, String materialName, int color, @Nullable String oredict)
    {
        this(new Material(prefix+materialName, color), oredict, 0);
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
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material, this.fluidWrapper.getFluid(), oredict).setRepresentativeItem(this.oredict)).preInit();
    }

    /**
     * setup and register a gem material(a meterial that have a gem form, e.g sapphire, ruby)
     * @param materialStats Stats for that material
     */
    public void createGemMaterial(MaterialStats materialStats)
    {
        this.material.addItem("gem"+oredict, 1, Material.VALUE_Ingot);
        this.createMaterial(materialStats);
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
        this.material.setRepresentativeItem(ore+oredict);
        materialStats.registerStats(this.material);
        TinkerRegistry.integrate(new MaterialIntegration(material, null, oredict).setRepresentativeItem(this.oredict)).preInit();
    }

    public void createIngotMaterial(MaterialStats materialStats)
    {
        this.createMaterial(materialStats, "ingot");
        this.setMode(true);
    }
}
