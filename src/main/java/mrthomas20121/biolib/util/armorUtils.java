package mrthomas20121.biolib.util;

import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import mrthomas20121.biolib.common.MaterialBuilder;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

public class armorUtils
{
    public <T extends MaterialBuilder> void setArmorStats(T mat, float toughness)
    {
        HeadMaterialStats head = mat.getHeadStats();
        HandleMaterialStats handle = mat.getHandleStats();
        ExtraMaterialStats extra = mat.getExtraStats();

        TinkerRegistry.addMaterialStats(mat.getMat(),
                new CoreMaterialStats(head.durability / 30, head.attack * 2.1F),
                new PlatesMaterialStats(handle.modifier, handle.durability / 18, toughness),
                new TrimMaterialStats(extra.extraDurability / 16));      
    }
}