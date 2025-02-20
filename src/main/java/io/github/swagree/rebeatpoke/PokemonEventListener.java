package io.github.swagree.rebeatpoke;

import catserver.api.bukkit.event.ForgeEvent;
import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import com.pixelmonmod.pixelmon.enums.EnumType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonEventListener implements Listener {
    @EventHandler
    public void onBattleStarted(ForgeEvent event) throws IOException {
        if (event.getForgeEvent() instanceof BeatWildPixelmonEvent) {
            BeatWildPixelmonEvent forgeEvent = (BeatWildPixelmonEvent) event.getForgeEvent();
            PixelmonWrapper[] allPokemon = forgeEvent.wpp.allPokemon;
            for (PixelmonWrapper pixelmonWrapper : allPokemon) {
                List<EnumType> types = pixelmonWrapper.type;
                for (EnumType enumType : types) {
                    String localizedName = enumType.getLocalizedName();
                    List<String> commands = Main.plugin.getConfig().getStringList(localizedName);
                    for (String command : commands) {
                        command = command.replace("%player%",forgeEvent.player.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    }
                }
            }
            return;
        }
    }
}
