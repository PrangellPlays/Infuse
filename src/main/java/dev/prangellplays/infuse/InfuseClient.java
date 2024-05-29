package dev.prangellplays.infuse;

import dev.prangellplays.infuse.client.PrimaryAbilityOverlay;
import dev.prangellplays.infuse.client.SecondaryAbilityOverlay;
import dev.prangellplays.infuse.client.TertiaryAbilityOverlay;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class InfuseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(new PrimaryAbilityOverlay());
		HudRenderCallback.EVENT.register(new SecondaryAbilityOverlay());
		HudRenderCallback.EVENT.register(new TertiaryAbilityOverlay());
	}
}