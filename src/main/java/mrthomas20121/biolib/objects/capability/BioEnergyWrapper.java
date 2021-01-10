package mrthomas20121.biolib.objects.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.Objects;

public class BioEnergyWrapper implements IEnergyStorage {

    private final ItemStack stack;

    public BioEnergyWrapper(ItemStack stack)
    {
        this.stack = stack;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        NBTTagCompound tag = Objects.requireNonNull(stack.getTagCompound());
        int stored = tag.getInteger("bioEnergy");
        int toTransfer = Math.min(maxReceive, tag.getInteger("bioEnergyCapacity") - stored);
        if (!simulate)
            tag.setInteger("bioEnergy", stored + toTransfer);
        return toTransfer;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return Objects.requireNonNull(stack.getTagCompound()).getInteger("bioEnergy");
    }

    @Override
    public int getMaxEnergyStored() {
        return Objects.requireNonNull(stack.getTagCompound()).getInteger("bioEnergyCapacity");
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
