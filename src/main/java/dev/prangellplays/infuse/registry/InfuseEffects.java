package dev.prangellplays.infuse.registry;

import dev.prangellplays.infuse.Infuse;
import dev.prangellplays.infuse.effect.primary.FeatherAbilityStatusEffect;
import dev.prangellplays.infuse.effect.secondary.SpeedAbilityStatusEffect;
import dev.prangellplays.infuse.effect.tertiary.DragonAbilityStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InfuseEffects {

    //Primary Ability
    public static StatusEffect FEATHER;
    public static StatusEffect registerFeatherEffect(String name){return Registry.register(Registries.STATUS_EFFECT, new Identifier(Infuse.MOD_ID, name), new FeatherAbilityStatusEffect(StatusEffectCategory.BENEFICIAL, 16185078));}

    //Secondary Ability
    public static StatusEffect SPEED;
    public static StatusEffect registerSpeedEffect(String name){return Registry.register(Registries.STATUS_EFFECT, new Identifier(Infuse.MOD_ID, name), new SpeedAbilityStatusEffect(StatusEffectCategory.BENEFICIAL, 3402751));}

    //Tertiary Ability
    public static StatusEffect DRAGON;
    public static StatusEffect registerDragonEffect(String name){return Registry.register(Registries.STATUS_EFFECT, new Identifier(Infuse.MOD_ID, name), new DragonAbilityStatusEffect(StatusEffectCategory.BENEFICIAL, 3402751));}

    public static void init(){
        FEATHER = registerFeatherEffect("feather");
        SPEED = registerSpeedEffect("speed");
        DRAGON = registerDragonEffect("dragon");
    }
}
