package dev.prangellplays.infuse.registry;

import dev.prangellplays.infuse.Infuse;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class InfuseItemGroups {
    public static final ItemGroup ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Infuse.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.items")).icon(() -> new ItemStack(Items.AIR)).entries((displayContext, entries) -> {

            }).build());
    public static final ItemGroup INFUSE_PRIMARY_ABILITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Infuse.MOD_ID, "primary_abilities"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.primary_abilities")).icon(() -> new ItemStack(InfuseItems.FEATHER_ABILITY_CRYSTAL)).entries((displayContext, entries) -> {
                entries.add(InfuseItems.FEATHER_ABILITY_CRYSTAL);
            }).build());
    public static final ItemGroup INFUSE_SECONDARY_ABILITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Infuse.MOD_ID, "secondary_abilities"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.secondary_abilities")).icon(() -> new ItemStack(InfuseItems.SPEED_ABILITY_CRYSTAL)).entries((displayContext, entries) -> {
                entries.add(InfuseItems.SPEED_ABILITY_CRYSTAL);
            }).build());


    public static void init() {
        Infuse.LOGGER.info("Registering Item Groups for " + Infuse.MOD_ID);
    }
}
