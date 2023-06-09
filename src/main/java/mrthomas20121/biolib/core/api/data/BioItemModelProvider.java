package mrthomas20121.biolib.core.api.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BioItemModelProvider extends ItemModelProvider {

    public BioItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    public String blockName(Block block) {
        ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown block: " + block.toString());
        }
    }

    public String itemName(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }

    protected ResourceLocation texture(String name) {
        return this.modLoc("block/" + name);
    }

    protected ResourceLocation texture(String name, String location) {
        return this.modLoc("block/" + location + name);
    }

    public void item(Item item, String location) {
        this.withExistingParent(this.itemName(item), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + location + this.itemName(item)));
    }

    public void handheldItem(Item item, String location) {
        this.withExistingParent(this.itemName(item), this.mcLoc("item/handheld"))
                .texture("layer0", this.modLoc("item/" + location + this.itemName(item)));
    }

    public void rotatedItem(Item item, String location) {
        this.withExistingParent(this.itemName(item), this.mcLoc("item/generated"))
                .texture("layer0", this.modLoc("item/" + location + this.itemName(item)))
                .transforms()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(90.0F, -90.0F, 25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F, 0.68F, 0.68F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(90.0F, 90.0F, -25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F, 0.68F, 0.68F).end()
                .end();
    }

    public void itemBlock(Block block) {
        this.withExistingParent(this.blockName(block), this.texture(this.blockName(block)));
    }

    public void itemBlock(Block block, String suffix) {
        this.withExistingParent(this.blockName(block), this.texture(this.blockName(block) + suffix));
    }

    public void itemFence(Block block, Block baseBlock, String location) {
        this.withExistingParent(this.blockName(block), this.mcLoc("block/fence_inventory"))
                .texture("texture", this.texture(this.blockName(baseBlock), location));
    }

    public void itemButton(Block block, Block baseBlock, String location) {
        this.withExistingParent(this.blockName(block), this.mcLoc("block/button_inventory"))
                .texture("texture", this.texture(this.blockName(baseBlock), location));
    }

    public void itemWallBlock(Block block, Block baseBlock, String location) {
        this.wallInventory(this.blockName(block), this.texture(this.blockName(baseBlock), location));
    }
}
