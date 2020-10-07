package mrthomas20121.biolib.util;

import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import c4.conarm.lib.traits.AbstractArmorTrait;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.objects.material.MaterialWrapper;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

public class armorUtils
{
    @Deprecated
    public static void setArmorStats(MaterialBuilder mat, float toughness)
    {
        HeadMaterialStats head = mat.getHeadStats();
        HandleMaterialStats handle = mat.getHandleStats();
        ExtraMaterialStats extra = mat.getExtraStats();

        TinkerRegistry.addMaterialStats(mat.getMat(),
                new CoreMaterialStats((float)head.durability / 30, head.attack * 2.1F),
                new PlatesMaterialStats(handle.modifier, (float)handle.durability / 18, toughness),
                new TrimMaterialStats((float)extra.extraDurability / 16));
    }
    @Deprecated
    public static void setArmorStats(MaterialBuilder mat, float toughness, AbstractArmorTrait trait)
    {
        setArmorStats(mat, toughness);
        TinkerRegistry.addMaterialTrait(mat.getMat(), trait, ArmorMaterialType.CORE);
        TinkerRegistry.addMaterialTrait(mat.getMat(), trait, ArmorMaterialType.PLATES);
        TinkerRegistry.addMaterialTrait(mat.getMat(), trait, ArmorMaterialType.TRIM);
    }

    public static void setArmorStats(MaterialWrapper mat, MaterialStats stats, float toughness)
    {
        HeadMaterialStats head = stats.getHeadMaterialStats();
        HandleMaterialStats handle = stats.getHandleMaterialStats();
        ExtraMaterialStats extra = stats.getExtraMaterialStats();

        TinkerRegistry.addMaterialStats(mat.getMaterial(),
                new CoreMaterialStats((float)head.durability / 30, head.attack * 2.1F),
                new PlatesMaterialStats(handle.modifier, (float)handle.durability / 18, toughness),
                new TrimMaterialStats((float)extra.extraDurability / 16));
    }
    public static void setArmorStats(MaterialWrapper mat, MaterialStats stats, float toughness, AbstractArmorTrait trait)
    {
        setArmorStats(mat, stats, toughness);
        TinkerRegistry.addMaterialTrait(mat.getMaterial(), trait, ArmorMaterialType.CORE);
        TinkerRegistry.addMaterialTrait(mat.getMaterial(), trait, ArmorMaterialType.PLATES);
        TinkerRegistry.addMaterialTrait(mat.getMaterial(), trait, ArmorMaterialType.TRIM);
    }
}