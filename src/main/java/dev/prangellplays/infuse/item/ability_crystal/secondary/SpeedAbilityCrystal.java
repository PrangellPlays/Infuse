package dev.prangellplays.infuse.item.ability_crystal.secondary;

import dev.prangellplays.infuse.registry.InfuseEffects;
import dev.prangellplays.infuse.registry.InfuseItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class SpeedAbilityCrystal extends Item {
    public SpeedAbilityCrystal(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.removeStatusEffect(InfuseEffects.SPEED);
        user.setStatusEffect(new StatusEffectInstance(InfuseEffects.SPEED, StatusEffectInstance.INFINITE, 0, false, false), user);
        user.setStackInHand(hand, Items.AIR.getDefaultStack());
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.translatable("item.infuse.secondary_ability_crystal.activated").formatted(Formatting.GRAY).formatted(Formatting.UNDERLINE)));
        }
        world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, (1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
        MinecraftClient.getInstance().gameRenderer.showFloatingItem(InfuseItems.SPEED_ABILITY_CRYSTAL.getDefaultStack());
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            tooltip.add(Text.translatable("item.infuse.secondary_ability_crystal.description"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
