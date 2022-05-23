package mrthomas20121.biolib.item.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class BioHorseArmor extends HorseArmorItem {

    public BioHorseArmor(int p_41364_, String modID, String armor, Properties p_41366_) {
        this(p_41364_, new ResourceLocation(modID, "textures/models/armor/horse/horse_armor_" + armor + ".png"), p_41366_);
    }

    public BioHorseArmor(int p_41364_, ResourceLocation p_41365_, Properties p_41366_) {
        super(p_41364_, p_41365_, p_41366_);
    }
}
