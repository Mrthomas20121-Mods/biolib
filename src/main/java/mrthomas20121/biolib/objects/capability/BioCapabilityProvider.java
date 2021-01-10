package mrthomas20121.biolib.objects.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import slimeknights.tconstruct.library.tools.TinkerToolCore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Predicate;

public class BioCapabilityProvider implements ICapabilityProvider {

    private static final Predicate<ItemStack> predicate = itemStack -> itemStack.getItem() instanceof TinkerToolCore;
    private final ItemStack stack;

    public BioCapabilityProvider(ItemStack stack) {
        this.stack = stack;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityEnergy.ENERGY
                && stack.hasTagCompound() && stack.getTagCompound().hasKey("bioEnergyCapacity");
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return (T)new BioEnergyWrapper(stack);
        }
        return null;
    }
}
