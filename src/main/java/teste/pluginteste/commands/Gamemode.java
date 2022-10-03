package teste.pluginteste.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gamemode implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
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

}
