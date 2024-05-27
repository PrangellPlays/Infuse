package dev.prangellplays.infuse.effect.side;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class SpeedAbilityStatusEffect extends StatusEffect {
    public SpeedAbilityStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7cd4a1f4-61ba-4dba-a569-08fb9be88f94", 0.04, EntityAttributeModifier.Operation.ADDITION);
        super.applyUpdateEffect(entity, amplifier);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
