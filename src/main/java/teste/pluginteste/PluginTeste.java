package teste.pluginteste;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import teste.pluginteste.events.playerevents.ChatEvents;
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
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ping")) {
            if(args.length==0) {
                if (sender instanceof Player) {
                    Player player = ((Player) sender).getPlayer();
                    int ping = player.getPing();
                    if (ping <= 30) {
                        player.sendMessage("Seu ping: §2" + player.getPing() + "ms");
                    } else if (ping <= 50) {
                        player.sendMessage("Seu ping: §a" + player.getPing() + "ms");
                    } else if (ping <= 70) {
                        player.sendMessage("Seu ping: §e" + player.getPing() + "ms");
                    } else if (ping <= 150) {
                        player.sendMessage("Seu ping: §c" + player.getPing() + "ms");
                    } else {
                        player.sendMessage("Seu ping: §4" + player.getPing() + "ms");
                    }
                    return true;
                } else {
                    Bukkit.getConsoleSender().sendMessage("Este comando é apenas para players!");
                    return true;
                }
            }if(args.length==1){
                Player player = Bukkit.getPlayer(args[0]);
                if(player !=null){
                    int ping = player.getPing();
                    if(sender instanceof Player) {
                        if (ping <= 30) {
                            sender.sendMessage("O ping de " + player.getDisplayName() + ": §2" + player.getPing() + "ms");
                        } else if (ping <= 50) {
                            sender.sendMessage("O ping de " + player.getDisplayName() + ": §a" + player.getPing() + "ms");
                        } else if (ping <= 70) {
                            sender.sendMessage("O ping de " + player.getDisplayName() + ": §e" + player.getPing() + "ms");
                        } else if (ping <= 150) {
                            sender.sendMessage("O ping de " + player.getDisplayName() + ": §c" + player.getPing() + "ms");
                        } else {
                            sender.sendMessage("O ping de " + player.getDisplayName() + ": §4" + player.getPing() + "ms");
                        }
                        return true;
                    }else{
                        if (ping <= 30) {
                            Bukkit.getConsoleSender().sendMessage("O ping de " + player.getDisplayName() + ": §2" + player.getPing() + "ms");
                        } else if (ping <= 50) {
                            Bukkit.getConsoleSender().sendMessage("O ping de " + player.getDisplayName() + ": §a" + player.getPing() + "ms");
                        } else if (ping <= 70) {
                            Bukkit.getConsoleSender().sendMessage("O ping de " + player.getDisplayName() + ": §e" + player.getPing() + "ms");
                        } else if (ping <= 150) {
                            Bukkit.getConsoleSender().sendMessage("O ping de " + player.getDisplayName() + ": §c" + player.getPing() + "ms");
                        } else {
                            Bukkit.getConsoleSender().sendMessage("O ping de " + player.getDisplayName() + ": §4" + player.getPing() + "ms");
                        }
                        return true;
                    }
                }
            }
        }
        if(command.getName().equalsIgnoreCase("gamemode") || command.getName().equalsIgnoreCase("gm")) {
            if(sender instanceof Player){
                if(args.length == 1){
                   switch (args[0]) {
                       case "s", "0" -> {
                           ((Player) sender).setGameMode(GameMode.SURVIVAL);
                           sender.sendMessage("Seu gamemode foi alterado para Survival");
                           return true;
                       }
                       case "c", "1" -> {
                           ((Player) sender).setGameMode(GameMode.CREATIVE);
                           sender.sendMessage("Seu gamemode foi alterado para Creative");
                           return true;
                       }
                       case "a", "2" -> {
                           ((Player) sender).setGameMode(GameMode.ADVENTURE);
                           sender.sendMessage("Seu gamemode foi alterado para Adventure");
                           return true;
                       }
                       case "3" -> {
                           ((Player) sender).setGameMode(GameMode.SPECTATOR);
                           sender.sendMessage("Seu gamemode foi alterado para Spectator");
                           return true;
                       }
                   }
                }if(args.length == 2){
                    Player player = Bukkit.getPlayer(args[1]);
                    if(player !=null){
                        switch (args[0]) {
                            case "s", "0" -> {
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage("Seu gamemode foi alterado para Survival pelo "+((Player) sender).getDisplayName());
                                return true;
                            }
                            case "c", "1" -> {
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage("Seu gamemode foi alterado para Creative pelo "+((Player) sender).getDisplayName());
                                return true;
                            }
                            case "a","2" -> {
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage("Seu gamemode foi alterado para Adventure pelo "+((Player) sender).getDisplayName());
                                return true;
                            }
                            case "3" -> {
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage("Seu gamemode foi alterado para Spectator pelo "+((Player) sender).getDisplayName());
                                return true;
                            }
                        }
                    }else{
                        sender.sendMessage("Esse jogador não foi encontrado.");
                        return true;
                    }
                }if(args.length<1){
                    if(((Player) sender).getGameMode().equals(GameMode.CREATIVE)){
                        ((Player) sender).setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage("Seu gamemode foi alterado para Survival");
                        return true;
                    }if(((Player) sender).getGameMode().equals(GameMode.SURVIVAL)){
                        ((Player) sender).setGameMode(GameMode.CREATIVE);
                        sender.sendMessage("Seu gamemode foi alterado para Creative");
                        return true;
                    }
                }
            }
        }
        return false;
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
        }if(command.getName().equalsIgnoreCase("ping")){
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
