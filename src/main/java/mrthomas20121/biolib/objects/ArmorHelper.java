package mrthomas20121.biolib.objects;

import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import c4.conarm.lib.traits.AbstractArmorTrait;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import java.util.ArrayList;
import java.util.Map;

public class ArmorHelper
{
    public static String CORE = "core";
    public static String PLATES = "plates";
    public static String TRIM = "trim";

    /**
     * Add Armor Stats but doesn't add a custom armor trait
     * @param material material
     * @param toughness armor toughness
     */
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

    /**
     * Add Armor Stats with custom traits
     * @param material material
     * @param toughness armor toughness
     * @param traits Array of traits. must be 3 in length
     */
    public static void addArmorMat(Material material, float toughness, AbstractArmorTrait[] traits)
    {
        addArmorMat(material, toughness);
        TinkerRegistry.addMaterialTrait(material, traits[0], ArmorMaterialType.CORE);
        TinkerRegistry.addMaterialTrait(material, traits[1], ArmorMaterialType.PLATES);
        TinkerRegistry.addMaterialTrait(material, traits[2], ArmorMaterialType.TRIM);
    }

    /**
     * Add Armor Stats with custom traits
     * @param material material
     * @param toughness armor toughness
     * @param traits Map of String and List of Armor Trait. The Strings are part name, must be core, plates or trim.
     */
    public static void addArmorMat(Material material, float toughness, Map<String, ArrayList<AbstractArmorTrait>> traits)
    {
        addArmorMat(material, toughness);
        for(Map.Entry<String, ArrayList<AbstractArmorTrait>> mapTrait : traits.entrySet()) {
            for(AbstractArmorTrait trait : mapTrait.getValue()) {
                TinkerRegistry.addMaterialTrait(material, trait, mapTrait.getKey());
            }
        }
    }
}