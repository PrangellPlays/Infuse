package dev.prangellplays.infuse.effect.primary;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class FeatherAbilityStatusEffect extends StatusEffect {
    public FeatherAbilityStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.fallDistance = 0;
        if (entity instanceof PlayerEntity player) {
            if (!player.getAbilities().flying && !player.isOnGround()) startFlying(player);
            if (player instanceof ServerPlayerEntity serverplayer && !serverplayer.isOnGround()) {
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity player) startFlying(player);
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity player) stopFlying(player);
        super.onRemoved(entity, attributes, amplifier);
    }

    private void startFlying(PlayerEntity player) {
        if (!player.isCreative() && !player.isSpectator() && !player.isOnGround()) {
            player.getAbilities().allowFlying = true;
            player.getAbilities().flying = false;
            player.sendAbilitiesUpdate();
        }
    }

    private void stopFlying(PlayerEntity player) {
        if (!player.isCreative() && !player.isSpectator()) {
            player.getAbilities().allowFlying = false;
            player.getAbilities().flying = false;
            player.sendAbilitiesUpdate();
        }
    }
}