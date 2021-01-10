package mrthomas20121.biolib.objects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BioCreativeTabs extends CreativeTabs {

    public BioCreativeTabs(int index, String label)
    {
        super(index, label);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public abstract ItemStack createIcon();
}
