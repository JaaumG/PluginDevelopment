package teste.pluginteste.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Rtp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("rtp")){
            if(sender instanceof Player){
                Player player = ((Player) sender).getPlayer();
                player.sendTitle("§6§lProcurando...", "§8Aguarde um tempo");
                Location location = player.getLocation(), location1 = player.getLocation(), location2 = player.getLocation();
                location.setX(new Random().nextDouble(location.getX()-10000, location.getX()+10000));
                location.setZ(new Random().nextDouble(location.getZ()-10000, location.getZ()+10000));
                location.setY(new Random().nextDouble(63, 250));
                while(location.getBlock().isPassable() && location1.getBlock().isPassable() && !location2.getBlock().isPassable() && location.getBlock().getType().isAir() &&  location1.getBlock().getType().isAir()){
                    location1 = location;
                    location1.setY(location.getY()+1);
                    location2 = location;
                    location2.setY(location.getY()-1);
                    location.setY(new Random().nextDouble(63, 250));
                }
                player.sendTitle("§6X: §7"+location.getX() +" §6Y: §7" +location.getY()+" §6Z: §7" + location.getZ(), "§8Teletransportando....");
                player.teleport(location);
                return true;
            }
        }
        return false;
    }
}
