package dev.prangellplays.infuse.effect.tertiary;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DragonAbilityStatusEffect extends StatusEffect {
    public DragonAbilityStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        super.applyUpdateEffect(entity, amplifier);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
