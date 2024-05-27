package dev.prangellplays.infuse.registry;

import dev.prangellplays.infuse.Infuse;
import dev.prangellplays.infuse.item.ability_crystal.primary.FeatherAbilityCrystal;
import dev.prangellplays.infuse.item.ability_crystal.secondary.SpeedAbilityCrystal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InfuseItems {
    //Primary Ability Crystal
    public static final Item FEATHER_ABILITY_CRYSTAL = registerItem("feather_ability_crystal", new FeatherAbilityCrystal(new FabricItemSettings().maxCount(1)));

    //Secondary Ability Crystal
    public static final Item SPEED_ABILITY_CRYSTAL = registerItem("speed_ability_crystal", new SpeedAbilityCrystal(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Infuse.MOD_ID, name), item);
    }

    public static void init() {
        Infuse.LOGGER.info("Registering Mod Items for " + Infuse.MOD_ID);
    }
}
