package mrthomas20121.biolib.util;

import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import c4.conarm.lib.traits.AbstractArmorTrait;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import java.util.ArrayList;

public class ConarmUtil
{

    public static void addArmorMat(Material material, float toughness)
    {
        HeadMaterialStats head = material.getStats(MaterialTypes.HEAD);
        HandleMaterialStats handle = material.getStats(MaterialTypes.HANDLE);
        ExtraMaterialStats extra = material.getStats(MaterialTypes.EXTRA);

        TinkerRegistry.addMaterialStats(material,
                new CoreMaterialStats((float)head.durability / 30, head.attack * 2.1F),
                new PlatesMaterialStats(handle.modifier, (float)handle.durability / 18, toughness),
                new TrimMaterialStats((float)extra.extraDurability / 16));
    }
    public static void addArmorMat(Material material, float toughness, AbstractArmorTrait[] trait)
    {
        addArmorMat(material, toughness);
        TinkerRegistry.addMaterialTrait(material, trait[0], ArmorMaterialType.CORE);
        TinkerRegistry.addMaterialTrait(material, trait[1], ArmorMaterialType.PLATES);
        TinkerRegistry.addMaterialTrait(material, trait[2], ArmorMaterialType.TRIM);
    }
    public static void addArmorMat(Material material, float toughness, ArrayList<AbstractArmorTrait> trait)
    {
        addArmorMat(material, toughness, (AbstractArmorTrait[]) trait.toArray());
    }
}