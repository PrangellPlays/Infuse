package dev.prangellplays.infuse.client;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.prangellplays.infuse.Infuse;
import dev.prangellplays.infuse.registry.InfuseEffects;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;

public class TertiaryAbilityOverlay implements HudRenderCallback {
    private static final Identifier TERTIARY_ABILITY_DRAGON = new Identifier(Infuse.MOD_ID, "textures/hud/ability/tertiary/tertiary_ability_dragon.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        if (client.player.isSpectator()) {
            return;
        }
        else {
            if (client.player.hasStatusEffect(InfuseEffects.DRAGON)) {
                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, TERTIARY_ABILITY_DRAGON);
                TextRenderer textRenderer = MinecraftClient.getInstance().inGameHud.getTextRenderer();
                for (int i = 0; i < 1; i++) {
                    drawContext.drawTexture(TERTIARY_ABILITY_DRAGON, x - 10, y - 78, 0, 0, 20, 20, 20, 20);
                }
            }
            else {
                return;
            }
        }
    }
}