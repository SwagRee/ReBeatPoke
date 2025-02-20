package io.github.swagree.rebeatpoke;

import net.minecraftforge.event.world.BlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;


        getCommand("rgp").setExecutor(new CommandBeat());

        Bukkit.getConsoleSender().sendMessage("§7[ReBeatPoke] §b作者§fSwagRee §cQQ:§f352208610");

        Bukkit.getPluginManager().registerEvents(new PokemonEventListener(), this);

        saveDefaultConfig();

        reloadConfig();
    }

    @Override
    public void onDisable() {

    }

}
