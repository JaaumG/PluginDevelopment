package teste.pluginteste;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import teste.pluginteste.events.playerevents.ChatEvents;
import teste.pluginteste.events.playerevents.PlayerEvents;

public final class PluginTeste extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hello World by JAAUMG");

        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
