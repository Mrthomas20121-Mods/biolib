package mrthomas20121.biolib.objects.material;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

public class MaterialStats {

    private HeadMaterialStats headMaterialStats = null;
    private HandleMaterialStats handleMaterialStats = null;
    private ExtraMaterialStats extraMaterialStats = null;
    private BowMaterialStats bowMaterialStats = null;
    private BowStringMaterialStats bowStringMaterialStats = null;
    private ArrowShaftMaterialStats arrowShaftMaterialStats = null;

    public MaterialStats()
    {

    }

    public void registerStats(Material material)
    {
        if(!isNotNull(headMaterialStats) && !isNotNull(handleMaterialStats) && !isNotNull(extraMaterialStats))
        {
            TinkerRegistry.addMaterialStats(material, headMaterialStats, handleMaterialStats, extraMaterialStats);
        }
        if(!isNotNull(bowMaterialStats))
        {
            TinkerRegistry.addMaterialStats(material, bowMaterialStats);
        }
        if(!isNotNull(bowStringMaterialStats))
        {
            TinkerRegistry.addMaterialStats(material, bowStringMaterialStats);
        }
        if(!isNotNull(arrowShaftMaterialStats))
        {
            TinkerRegistry.addMaterialStats(material, arrowShaftMaterialStats);
        }
    }

    private boolean isNotNull(IMaterialStats stats)
    {
        return stats == null;
    }

    public void setHeadMaterialStats(HeadMaterialStats headMaterialStats) {
        this.headMaterialStats = headMaterialStats;
    }

    public void setHeadMaterialStats(int durability, float miningspeed, float attack, int harvestLevel) {
        this.setHeadMaterialStats(new HeadMaterialStats(durability, miningspeed, attack, harvestLevel));
    }

    public HeadMaterialStats getHeadMaterialStats() {
        return headMaterialStats;
    }

    public void setHandleMaterialStats(HandleMaterialStats handleMaterialStats) {
        this.handleMaterialStats = handleMaterialStats;
    }

    public void setHandleMaterialStats(float modifier, int durability) {
        this.setHandleMaterialStats(new HandleMaterialStats(modifier, durability));
    }

    public HandleMaterialStats getHandleMaterialStats() {
        return handleMaterialStats;
    }

    public void setExtraMaterialStats(ExtraMaterialStats extraMaterialStats) {
        this.extraMaterialStats = extraMaterialStats;
    }

    public void setExtraMaterialStats(int extraDurability) {
        this.setExtraMaterialStats(new ExtraMaterialStats(extraDurability));
    }

    public ExtraMaterialStats getExtraMaterialStats() {
        return extraMaterialStats;
    }

    public void setBowMaterialStats(BowMaterialStats bowMaterialStats) {
        this.bowMaterialStats = bowMaterialStats;
    }

    public void setBowMaterialStats(float drawspeed, float range, float bonusDamage) {
        this.setBowMaterialStats(new BowMaterialStats(drawspeed, range, bonusDamage));
    }

    public BowMaterialStats getBowMaterialStats() {
        return bowMaterialStats;
    }

    public void setBowStringMaterialStats(BowStringMaterialStats bowStringMaterialStats) {
        this.bowStringMaterialStats = bowStringMaterialStats;
    }

    public void setBowStringMaterialStats(float modifier) {
        this.setBowStringMaterialStats(new BowStringMaterialStats(modifier));
    }

    public BowStringMaterialStats getBowStringMaterialStats() {
        return bowStringMaterialStats;
    }

    public void setArrowShaftMaterialStats(ArrowShaftMaterialStats arrowShaftMaterialStats) {
        this.arrowShaftMaterialStats = arrowShaftMaterialStats;
    }

    public void setArrowShaftMaterialStats(float modifier, int bonusAmmo) {
        this.setArrowShaftMaterialStats(new ArrowShaftMaterialStats(modifier, bonusAmmo));
    }

    public ArrowShaftMaterialStats getArrowShaftMaterialStats() {
        return arrowShaftMaterialStats;
    }
}
