package dev.prangellplays.infuse;

import dev.prangellplays.infuse.registry.InfuseEffects;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Infuse implements ModInitializer {
	public static final String MOD_ID = "infuse";
	public static final Logger LOGGER = LoggerFactory.getLogger("infuse");

	@Override
	public void onInitialize() {
		InfuseEffects.init();
	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}