package teste.pluginteste.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
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
                    Bukkit.getConsoleSender().sendMessage("Especifique o player para verificar o ping dele(a)");
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
        return false;
    }
}
