package mrthomas20121.biolib.item.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BioArmorItem extends ArmorItem {

    private String armorTexture;

    public BioArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Properties properties) {
        super(armorMaterial, equipmentSlot, properties);
    }

    public BioArmorItem setArmorTexture(String modID, String armor) {
        this.armorTexture = modID+":textures/models/armor/"+armor+".png";
        return this;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return this.armorTexture;
    }
}
