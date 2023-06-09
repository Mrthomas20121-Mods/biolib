package mrthomas20121.biolib.core.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Wood {

    private final static List<WoodType> woodTypes = new ArrayList<>();

    public static WoodType addWoodType(String wood) {
        BlockSetType type = new BlockSetType(wood);
        WoodType woodType = new WoodType(wood, type);

        woodTypes.add(woodType);

        return woodType;
    }

    public static List<WoodType> getWoodTypes() {
        return woodTypes;
    }

    public static Supplier<Block> planks() {
        return () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    }

    public static Supplier<Block> log() {
        return () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
    }

    public static Supplier<Block> stripped_log() {
        return () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG));
    }

    public static Supplier<Block> leaves() {
        return () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    }

    public static Supplier<Block> bookshelf() {
        return () -> new Block(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF));
    }

    public static Supplier<Block> fence() {
        return () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE));
    }

    public static Supplier<Block> fence_gate(WoodType woodType) {
        return () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), woodType);
    }

    public static Supplier<Block> sign(WoodType woodType) {
        return () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), woodType);
    }

    public static Supplier<Block> wallSign(WoodType woodType) {
        return () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), woodType);
    }
}
