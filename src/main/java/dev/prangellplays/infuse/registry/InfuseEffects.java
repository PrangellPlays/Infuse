package dev.prangellplays.infuse.registry;

import dev.prangellplays.infuse.Infuse;
import dev.prangellplays.infuse.effect.main.FeatherAbilityStatusEffect;
import dev.prangellplays.infuse.effect.side.SpeedAbilityStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InfuseEffects {

    //Main Ability
    public static StatusEffect FEATHER;

    public static StatusEffect registerFeatherEffect(String name){return Registry.register(Registries.STATUS_EFFECT, new Identifier(Infuse.MOD_ID, name), new FeatherAbilityStatusEffect(StatusEffectCategory.BENEFICIAL, 15978425));}

    //Side Ability
    public static StatusEffect SPEED;

    public static StatusEffect registerSpeedEffect(String name){return Registry.register(Registries.STATUS_EFFECT, new Identifier(Infuse.MOD_ID, name), new SpeedAbilityStatusEffect(StatusEffectCategory.BENEFICIAL, 15978425));}

    public static void init(){
        FEATHER = registerFeatherEffect("feather");
        SPEED = registerSpeedEffect("speed");
    }
}
