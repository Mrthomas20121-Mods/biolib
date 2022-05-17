package mrthomas20121.biolib.worldgen;

import mrthomas20121.biolib.BioLibrary;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.registration.ConfiguredFeatureDeferredRegister;
import slimeknights.tconstruct.common.registration.PlacedFeatureDeferredRegister;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Ore {

    public static final ConfiguredFeatureDeferredRegister CONFIGURED_FEATURES = new ConfiguredFeatureDeferredRegister(BioLibrary.MOD_ID);
    public static final PlacedFeatureDeferredRegister PLACED_FEATURES = new PlacedFeatureDeferredRegister(BioLibrary.MOD_ID);

    public static final RuleTest END_ORE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES);

    public static Supplier<List<OreConfiguration.TargetBlockState>> overworldOreReplace(RegistryObject<Block> ore, RegistryObject<Block> oreDeepslate) {
        return () -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, oreDeepslate.get().defaultBlockState()));
    }

    public static Supplier<OreConfiguration.TargetBlockState> netherOreReplace(RegistryObject<Block> ore) {
        return () -> OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ore.get().defaultBlockState());
    }

    public static Supplier<OreConfiguration.TargetBlockState> endOreReplace(RegistryObject<Block> ore) {
        return () -> OreConfiguration.target(END_ORE_REPLACEABLES, ore.get().defaultBlockState());
    }

    public static RegistryObject<PlacedFeature> registerOre(String name, Supplier<List<OreConfiguration.TargetBlockState>> target, OreConfig config) {
        RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> feature = CONFIGURED_FEATURES.registerSupplier(name, () -> Feature.ORE, () -> new OreConfiguration(target.get(), config.getSize()));
        return PLACED_FEATURES.register(name, feature, CountPlacement.of(config.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(config.getMinY()), VerticalAnchor.absolute(config.getMaxY())));
    }

    public static RegistryObject<PlacedFeature> registerNetherOre(String name, RegistryObject<Block> ore, OreConfig config) {
        Supplier<OreConfiguration.TargetBlockState> target = netherOreReplace(ore);
        RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> feature = CONFIGURED_FEATURES.registerSupplier(name, () -> Feature.ORE, () -> new OreConfiguration(Collections.singletonList(target.get()), config.getSize()));
        return PLACED_FEATURES.register(name, feature, CountPlacement.of(config.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(config.getMinY()), VerticalAnchor.absolute(config.getMaxY())));
    }

    public static RegistryObject<PlacedFeature> registerEndOre(String name, RegistryObject<Block> ore, OreConfig config) {
        Supplier<OreConfiguration.TargetBlockState> target = endOreReplace(ore);
        RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> feature = CONFIGURED_FEATURES.registerSupplier(name, () -> Feature.ORE, () -> new OreConfiguration(Collections.singletonList(target.get()), config.getSize()));
        return PLACED_FEATURES.register(name, feature, CountPlacement.of(config.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(config.getMinY()), VerticalAnchor.absolute(config.getMaxY())));
    }

    public static RegistryObject<PlacedFeature> registerOre(String name, RegistryObject<Block> ore, RegistryObject<Block> oreDeepslate, OreConfig config) {
        Supplier<List<OreConfiguration.TargetBlockState>> target = overworldOreReplace(ore, oreDeepslate);
        RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> feature = CONFIGURED_FEATURES.registerSupplier(name, () -> Feature.ORE, () -> new OreConfiguration(target.get(), config.getSize()));
        return PLACED_FEATURES.register(name, feature, CountPlacement.of(config.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(config.getMinY()), VerticalAnchor.absolute(config.getMaxY())));
    }
}
