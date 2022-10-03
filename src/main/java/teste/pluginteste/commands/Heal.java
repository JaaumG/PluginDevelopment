package teste.pluginteste.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equals("heal")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    ((Player) sender).setHealth(20.0);
                    sender.sendMessage("Sua vida foi regenerada.");
                    return true;
                } if (args.length == 1) {
                    Bukkit.getPlayer(args[0]).setHealth(20.0);
                    Bukkit.getPlayer(args[0]).sendMessage("Sua vida foi regenerada pelo " + sender.getName());
                    sender.sendMessage("Você regenerou a vida de: " + Bukkit.getPlayer(args[0]).getName());
                    return true;
                }

            }
        }else{
            if (args.length == 0) {
                Bukkit.getConsoleSender().sendMessage("Especifique um jogador para curar.");
                return true;
            } if (args.length == 1) {
                Bukkit.getPlayer(args[0]).setHealth(20.0);
                Bukkit.getPlayer(args[0]).sendMessage("Sua vida foi regenerada pelo " + sender.getName());
                Bukkit.getConsoleSender().sendMessage("Você regenerou a vida de: " + Bukkit.getPlayer(args[0]).getName());
                return true;
            }
        }
        return false;
    }
}
