package dev.prangellplays.infuse;

import dev.prangellplays.infuse.client.MainAbilityOverlay;
import dev.prangellplays.infuse.client.SideAbilityOverlay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfuseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(new MainAbilityOverlay());
		HudRenderCallback.EVENT.register(new SideAbilityOverlay());
	}
}