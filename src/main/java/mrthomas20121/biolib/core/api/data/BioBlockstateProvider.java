package mrthomas20121.biolib.core.api.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BioBlockstateProvider extends BlockStateProvider {

    public BioBlockstateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    public void log(RotatedPillarBlock block) {
        this.axisBlock(block, this.texture(this.name(block), "wood/"), this.extend(this.texture(this.name(block), "wood/"), "_top"));
    }

    public void enchantedLog(RotatedPillarBlock block, RotatedPillarBlock baseBlock) {
        this.axisBlock(block, this.texture(this.name(block), "wood/"), this.extend(this.texture(this.name(baseBlock), "wood/"), "_top"));
    }

    public void wood(RotatedPillarBlock block, RotatedPillarBlock baseBlock) {
        this.axisBlock(block, this.texture(this.name(baseBlock), "wood/"), this.texture(this.name(baseBlock), "wood/"));
    }

    public void fenceColumn(CrossCollisionBlock block, String side, String location) {
        String baseName = this.name(block);
        this.fourWayBlock(block,
                this.models().fencePost(baseName + "_post", this.texture(side, location)),
                this.models().fenceSide(baseName + "_side", this.texture(side, location)));
    }

    public void fenceGateBlock(FenceGateBlock block, Block baseBlock, String location) {
        this.fenceGateBlockInternal(block, this.name(block), this.texture(this.name(baseBlock), location));
    }

    public void fenceGateBlockInternal(FenceGateBlock block, String baseName, ResourceLocation texture) {
        ModelFile gate = this.models().fenceGate(baseName, texture);
        ModelFile gateOpen = this.models().fenceGateOpen(baseName + "_open", texture);
        ModelFile gateWall = this.models().fenceGateWall(baseName + "_wall", texture);
        ModelFile gateWallOpen = this.models().fenceGateWallOpen(baseName + "_wall_open", texture);
        this.fenceGateBlock(block, gate, gateOpen, gateWall, gateWallOpen);
    }

    public void doorBlock(DoorBlock block, ResourceLocation bottom, ResourceLocation top) {
        this.doorBlockWithRenderType(block, bottom, top, "cutout");
    }

    public void trapdoorBlock(TrapDoorBlock block, ResourceLocation texture, boolean orientable) {
        this.trapdoorBlockWithRenderType(block, texture, orientable, "cutout");
    }

    public void buttonBlock(ButtonBlock block, ResourceLocation texture) {
        ModelFile button = this.models().button(this.name(block), texture);
        ModelFile buttonPressed = this.models().buttonPressed(this.name(block) + "_pressed", texture);
        this.buttonBlock(block, button, buttonPressed);
    }

    public void pressurePlateBlock(PressurePlateBlock block, ResourceLocation texture) {
        ModelFile pressurePlate = this.models().pressurePlate(this.name(block), texture);
        ModelFile pressurePlateDown = this.models().pressurePlateDown(this.name(block) + "_down", texture);
        this.pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }

    public void stairs(StairBlock block, Block baseBlock, String location) {
        this.stairsBlock(block, this.texture(this.name(baseBlock), location));
    }

    public void slab(SlabBlock block, Block baseBlock, String location) {
        this.slabBlock(block, this.texture(this.name(baseBlock)), this.texture(this.name(baseBlock), location));
    }

    public void translucentSlab(Block block, Block baseBlock, String location) {
        ResourceLocation texture = this.texture(this.name(baseBlock), location);
        this.translucentSlabBlock(block, models().slab(this.name(block), texture, texture, texture).renderType(new ResourceLocation("translucent")),
                this.models().slabTop(this.name(block) + "_top", texture, texture, texture).renderType(new ResourceLocation("translucent")),
                this.models().getExistingFile(this.texture(this.name(baseBlock))));
    }

    public void translucentSlabBlock(Block block, ModelFile bottom, ModelFile top, ModelFile doubleSlab) {
        this.getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(bottom))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(top))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(doubleSlab));
    }

    public void bookshelf(Block block, Block endBlock) {
        ModelFile bookshelf = this.models().cubeColumn(this.name(block), this.texture(this.name(block), "wood/"), this.texture(this.name(endBlock), "wood/"));
        this.getVariantBuilder(block).partialState().addModels(new ConfiguredModel(bookshelf));
    }

    public void bed(Block block, Block dummyBlock) {
        ModelFile head = this.models().cubeAll(this.name(block) + "_head", this.texture(this.name(dummyBlock), "wood/"));
        ModelFile foot = this.models().cubeAll(this.name(block) + "_foot", this.texture(this.name(dummyBlock), "wood/"));
        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            BedPart part = state.getValue(BlockStateProperties.BED_PART);
            return ConfiguredModel.builder()
                    .modelFile(part == BedPart.HEAD ? head : foot)
                    .rotationY((((int) dir.toYRot()) + 180) % 360)
                    .build();
        }, BedBlock.OCCUPIED);
    }

    public void wallBlock(WallBlock block, Block baseBlock, String location) {
        this.wallBlockInternal(block, this.name(block), this.texture(this.name(baseBlock), location));
    }

    public void wallBlockInternal(WallBlock block, String baseName, ResourceLocation texture) {
        this.wallBlock(block, this.models().wallPost(baseName + "_post", texture),
                this.models().wallSide(baseName + "_side", texture),
                this.models().wallSideTall(baseName + "_side_tall", texture));
    }

    public ModelFile cubeAll(Block block, String location) {
        return this.models().cubeAll(this.name(block), this.texture(this.name(block), location));
    }

    public ModelFile cubeAllTranslucent(Block block, String location) {
        return this.models().cubeAll(this.name(block), this.texture(this.name(block), location)).renderType(new ResourceLocation("translucent"));
    }

    public ModelFile cubeBottomTop(String block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        return this.models().cubeBottomTop(block, side, bottom, top);
    }

    public ResourceLocation texture(String name) {
        return this.modLoc("block/" + name);
    }

    public ResourceLocation texture(String name, String location) {
        return this.modLoc("block/" + location + name);
    }

    public ResourceLocation texture(String name, String location, String suffix) {
        return this.modLoc("block/" + location + name + suffix);
    }

    public ResourceLocation extend(ResourceLocation location, String suffix) {
        return new ResourceLocation(location.getNamespace(), location.getPath() + suffix);
    }

    public void block(Block block, String location) {
        this.simpleBlock(block, this.cubeAll(block, location));
    }

    public String name(Block block) {
        ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown block: " + block.toString());
        }
    }
}
