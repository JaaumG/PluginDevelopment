package teste.pluginteste;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import teste.pluginteste.commands.*;
import teste.pluginteste.events.playerevents.ChatEvents;
import teste.pluginteste.events.playerevents.MenuEvents;
import teste.pluginteste.events.playerevents.PlayerEvents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PluginTeste extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hello World by JAAUMG");
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvents(this), this);
        Bukkit.getPluginManager().registerEvents(new MenuEvents(), this);
        getCommand("fake").setExecutor(new Fake());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("ping").setExecutor(new Ping());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("tag").setExecutor(new Tag());
        getCommand("rtp").setExecutor(new Rtp());
        getCommand("hat").setExecutor(new Hat());
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("gamemode") || command.getName().equalsIgnoreCase("gm")){
            if(args.length==1) {
                List<String> gamemodes = Arrays.asList("0", "1", "2", "3");
                return gamemodes;
            }if(args.length==2){
                List<String> players = new ArrayList<>();
                Bukkit.getOnlinePlayers().forEach(Player -> players.add(Player.getDisplayName()));
                return players;
            }else{
                return null;
            }
        }
        if(command.getName().equalsIgnoreCase("ping") || command.getName().equalsIgnoreCase("heal")){
            if(args.length==1){
                List<String> players = new ArrayList<>();
                Bukkit.getOnlinePlayers().forEach(Player -> players.add(Player.getDisplayName()));
                return players;
            }
        }
        return null;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
