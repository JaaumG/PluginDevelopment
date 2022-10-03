package teste.pluginteste.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("feed")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    ((Player) sender).setFoodLevel(20);
                    sender.sendMessage("Seu apetite foi satisfeito.");
                    return true;
                } if (args.length == 1) {
                    Bukkit.getPlayer(args[0]).setFoodLevel(20);
                    Bukkit.getPlayer(args[0]).sendMessage("Seu apetite foi satisfeito pelo(a) " + sender.getName());
                    sender.sendMessage("Você satisfez o apetite de: " + Bukkit.getPlayer(args[0]).getName());
                    return true;
                }
            }else{
                if (args.length == 0) {
                    Bukkit.getConsoleSender().sendMessage("Especifique um jogador para satisfazer o apetite.");
                    return true;
                } if (args.length == 1) {
                    Bukkit.getPlayer(args[0]).setFoodLevel(20);
                    Bukkit.getPlayer(args[0]).sendMessage("Seu apetite foi satisfeito pelo(a) " + sender.getName());
                    Bukkit.getConsoleSender().sendMessage("Você satisfez o apetite de: " + Bukkit.getPlayer(args[0]).getName());
                    return true;
                }
            }
        }
        return false;
    }
}
