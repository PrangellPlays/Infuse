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

public class MainAbilityOverlay implements HudRenderCallback {
    private static final Identifier MAIN_ABILITY_OVERLAY = new Identifier(Infuse.MOD_ID, "textures/hud/ability/main/main_ability_overlay.png");
    private static final Identifier MAIN_ABILITY_FEATHER = new Identifier(Infuse.MOD_ID, "textures/hud/ability/main/main_ability_feather.png");

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
            if (client.player.hasStatusEffect(InfuseEffects.FEATHER)) {
                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, MAIN_ABILITY_FEATHER);
                TextRenderer textRenderer = MinecraftClient.getInstance().inGameHud.getTextRenderer();
                for (int i = 0; i < 1; i++) {
                    drawContext.drawTexture(MAIN_ABILITY_FEATHER, x - 30, y - 61, 0, 0, 20, 20, 20, 20);
                }
            }
            else {
                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, MAIN_ABILITY_OVERLAY);
                TextRenderer textRenderer = MinecraftClient.getInstance().inGameHud.getTextRenderer();
                for (int i = 0; i < 1; i++) {
                    drawContext.drawTexture(MAIN_ABILITY_OVERLAY, x - 30, y - 61, 0, 0, 20, 20, 20, 20);
                }
            }
        }
    }
}